package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensup.master.daoImpl.IStudentDao2;
import com.ensup.master.daoImpl.StudentDao2;
import com.ensup.master.metier.Course;
import com.ensup.master.metier.Student;
import com.ensup.master.metier.User;
import com.ensup.master.serviceImpl.CourseService;
import com.ensup.master.serviceImpl.IStudentService;
import com.ensup.master.serviceImpl.StudentService;

/**
 * Servlet implementation class EtudiantCoursServlet
 */
public class EtudiantCoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentDao2 studentdao = new StudentDao2();
	private IStudentService studentService;
	private CourseService courseService;
	private RequestDispatcher dispatcher = null;

	/**
	 * Default constructor.
	 */
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantCoursServlet() {
        super();
        // TODO Auto-generated constructor stub
        studentService = new StudentService(studentdao);
        courseService = new CourseService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		methode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("mail") ;
		String course = request.getParameter("listeCours");		
		Student student = studentService.getStudentByEmail(email);
		HttpSession session = request.getSession();
		
		System.out.println(course + " " +student.getId());
		
		courseService.associateCourse(course, student.getId());	
		
		User user = (User)session.getAttribute("user");
		if(user.getProfil().equalsIgnoreCase("R")) {
			
			dispatcher = request.getRequestDispatcher("rechercheEtudiant.jsp");
		}
		else {
			dispatcher = request.getRequestDispatcher("etudiant.jsp");
		}
		dispatcher.forward(request, response);
	}
	
	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		int id = Integer.valueOf(object);
				
		Student student = studentService.getStudent(id);
		List<Course> listCours=courseService.getAllCourses();

		dispatcher = request.getRequestDispatcher("etudiantCours.jsp");
		session.setAttribute("student", student);
		session.setAttribute("courses", listCours);

		dispatcher.forward(request, response);
	}

}
