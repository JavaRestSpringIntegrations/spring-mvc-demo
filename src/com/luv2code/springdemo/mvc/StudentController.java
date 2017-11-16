package com.luv2code.springdemo.mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luv2code.springdemo.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@InitBinder //Ignore data binding for mobile number
	public void initBinder(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[] {"mobileNumber"});
		binder.registerCustomEditor(String.class,"firstName",new StudentNameEditor());
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) throws Exception {
		
		String exception = "ARITHMETIC_EXCEPTION";
		
		if(exception.equalsIgnoreCase("IO_EXCEPTION")) {
			throw new IOException("IO_EXCEPTION");
		} else if(exception.equalsIgnoreCase("ARITHMETIC_EXCEPTION")) {
			throw new ArithmeticException("ARITHMETIC_EXCEPTION");
		}
		
		//create a student object
		Student theStudent = new Student();
		
		//Add the student object to the model
		theModel.addAttribute("student", theStudent); //First param is the key and second param is variable that holds the value
		theModel.addAttribute("headerMessage", "Student Registration Form");
		return "student-form";
		
	}
	
	
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student theStudent,BindingResult result) {
		//Model attribute will automatically bind all form elements with the corresponding properties of Student Object
		//@Valid annotation is used to activate the property level annotation in the Student Object, instructing Srping MVC framework,
		// only when performing the data binding tasks do the validation
		System.out.println(theStudent.getFirstName());
		System.out.println(theStudent.getLastName());
		System.out.println(theStudent.getMobileNumber());
		if(result.hasErrors()) {
			return "student-form";
		}
		return "student-confirmation";
	}
	
	@ResponseBody
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

}
