package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
			implements ConstraintValidator<CourseCode, String>{
	
	private String coursePrefix;
	
	@Override
	//gives you access to the attribute values of the validated constraint and allows you to store them in a field 
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		// The parameters 'theCode' --> HTML form entered by User
		// theConstraintValidatorContext --> To place additional error messages
		
		boolean result;
		if (theCode != null) {
			result=theCode.startsWith(coursePrefix);
		}
		else {
			return true;
		}
		return result;
	}
	
	

}
