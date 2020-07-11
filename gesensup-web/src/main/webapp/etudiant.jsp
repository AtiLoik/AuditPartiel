<%@page import="com.ensup.master.metier.Student"%>
<%@page import="java.util.List"%>

<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	<ul>
		<li><a href="etudiantAjout.jsp">Ajout un �tudiant</a></li>
	</ul>

	<!-- Masthead Heading-->
	<h1>Liste des �tudiants</h1>

	<div class="table-responsive text-nowrap">
		<!--Table-->

		<table class="table table-striped" id="paginationFull">

			<!--Table head-->
			<thead>
				<tr>

					<th id="ID" name="ID">Id</th>
					<th style="width: 150px;">First Name</th>
					<th>Last Name</th>
					<th>Mail Address</th>
					<th>Address</th>
					<th style="width: 70px;">Phone Number</th>
					<th style="width: 70px;">BirthDay</th>
					<th>Action</th>
				</tr>
			</thead>
			<!--Table head-->

			<!--Table body-->
			<tbody>
				<%
					List<Student> listEtudiant = (List<Student>) session.getAttribute("students");
				%>
				<%
					int i = 0;
				%>
				<%
					for (Student student : listEtudiant) {
				%>
			
				<tr>
					<td><%=student.getId()%></td>
					<td><%=student.getFirstName()%></td>
					<td><%=student.getLastName()%></td>
					<td><%=student.getMailAdresse()%></td>
					<td><%=student.getAdress()%></td>
					<td><%=student.getNumberPhone()%></td>
					<td><%=student.getDateOfBirth()%></td>
					<td>

						<ul>
							<li>
								<a href="EditerEtudiantServlet?id=<%=student.getId()%>">Edit</a>				
								
								<a href="SupprimerEtudiantServlet?id=<%=student.getId()%>">Delete</a>
								
								<a href="ViewEtudiantServlet?id=<%=student.getId()%>">View</a>
							
							</li>
						</ul>

					</td>
				</tr>
				<%
					}
				%>
			</tbody>
			<!--Table body-->


		</table>
		<!--Table-->
	</div>

	<!--Section: Live preview-->

</div>




<!-- footer -->
<script>

</script>
<%@include file="footer.jsp"%>