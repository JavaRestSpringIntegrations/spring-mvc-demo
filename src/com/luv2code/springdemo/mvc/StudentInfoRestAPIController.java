package com.luv2code.springdemo.mvc;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.model.Student;

@RestController //Indicates spring MVC all the methods in this controller class is related to RestAPI
public class StudentInfoRestAPIController {
	
	@RequestMapping(value="/studentlist",method=RequestMethod.GET)
	public ArrayList<Student> getStudentsList() {
		
		Student student1 = new Student();
		student1.setFirstName("Sunil");
		student1.setLastName("Jacob");
		student1.setCountry("India");
		student1.setLanguage("English");
		
		Student student2 = new Student();
		student2.setFirstName("Jojo");
		student2.setLastName("John");
		student2.setCountry("France");
		student2.setLanguage("French");
		
		Student student3 = new Student();
		student3.setFirstName("Abel");
		student3.setLastName("Jacob");
		student3.setCountry("Germany");
		student3.setLanguage("French");
		
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		return studentList;
	}
	
	@RequestMapping(value="/studentlist/{firstName}",method=RequestMethod.GET)
	// Enclose name variable in curly braces, means that value is going to be specified by the client variable
	public Student getStudent(@PathVariable String firstName) {
		
		Student s = new Student();
		s.setFirstName(firstName);
		s.setLastName("Jacob");
		s.setCountry("India");
		s.setStudentHobby("Badminton");
		
		return s;
	}

}
