
package com.ensup.master.metier;

import java.util.Collection;

//import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Class Course
 *  
 * @author DANON
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "getAllCourse", query = "select c from Course c ")
})
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String themeCourse;
	private int numberHours;
	
	@OneToMany(mappedBy = "course" , fetch = FetchType.LAZY)
	private Collection<Student> students;
	
	public Course(String themeCourse, int numberHours) {
		super();
		this.themeCourse = themeCourse;
		this.numberHours = numberHours;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public String getThemeCourse() {
		return themeCourse;
	}

	public void setThemeCourse(String themeCourse) {
		this.themeCourse = themeCourse;
	}

	public int getNumberHours() {
		return numberHours;
	}

	public void setNumberHours(int numberHours) {
		this.numberHours = numberHours;
	}
	
	

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [themeCourse=" + themeCourse + ", numberHours=" + numberHours + "]";
	}
	
}
