package com.luv2code.springdemo.mvc;

import java.beans.PropertyEditorSupport;


public class StudentNameEditor extends PropertyEditorSupport {
	
	//When you submit the form, Spring MVC will call setAsText function of this class
	//before performing data binding task for firstName property
	
	@Override
	public void setAsText(String firstName) throws IllegalArgumentException {
		
		if(firstName.contains("Mr.") || firstName.contains("Ms.")) {
			setValue(firstName);
		}
		else {
			setValue("Ms. " +firstName); //Whatever value you provide to setValue SpringMVC
										 // will provide that value to binding of firstname
		}
		
	}

}
