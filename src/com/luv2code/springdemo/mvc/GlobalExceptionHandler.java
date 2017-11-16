package com.luv2code.springdemo.mvc;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) //Customized response code for the error
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Exception e) {
		System.out.println("Exception Occured " +e);
		return "HandleException";
	}
	
	@ExceptionHandler(value=IOException.class)
	public String IOExceptionHandler(IOException e) {
		System.out.println("Exception Occured " +e);
		return "IOException";
	}

}
