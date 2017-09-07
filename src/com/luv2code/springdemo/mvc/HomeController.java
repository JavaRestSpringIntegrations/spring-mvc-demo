package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // tells spring that this is an MVC controller
public class HomeController {
	
	//Defining Controller method
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}

}
