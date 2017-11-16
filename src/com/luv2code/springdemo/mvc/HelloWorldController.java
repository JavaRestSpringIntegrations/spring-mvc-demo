package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//Gontu Series - Start
	@RequestMapping("/welcome/{countryName}/{userName}")
	public String helloWorld(@PathVariable("userName") String name,@PathVariable("countryName") String country) { 
		//Pathvariable tells to bind {userName} value in the incoming request URL to name variable
		return "hworld";
		
	}
	//Gontu Series - End
	//new controller method to read form data and also add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShout(HttpServletRequest request,Model model) { //httpServletRequest will hold form data
		//read the request parameter from the html form
		String theName = request.getParameter("studentName");
		//convert to upper case
		theName = theName.toUpperCase();
		//create message
		String result = "Yo! " + theName; 
		//add message to model
		model.addAttribute("message", result); // the first parameter can be of any name, its Key Value pair kind 
		//Name is message and value is result
		return "helloworld";
	}
	
	//Demo instead of using httpServletRequest, using request binding annotation parameter
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,Model model) { //httpServletRequest will hold form data
	
		//convert to upper case
		theName = theName.toUpperCase();
		//create message
		String result = "Hey my friend " + theName; 
		//add message to model
		model.addAttribute("message", result); // the first parameter can be of any name, its Key Value pair kind 
		//Name is message and value is result
		return "helloworld";
	}
}
