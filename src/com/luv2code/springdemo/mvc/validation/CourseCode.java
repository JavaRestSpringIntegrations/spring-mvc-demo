package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CourseCodeConstraintValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD} ) //this says where can we apply the method
//How long the annotation will be stored or used
@Retention(RetentionPolicy.RUNTIME) //Retain in byte code during runtime
public @interface CourseCode {
	
	//define default course code
	public String value() default "LUV";
	
	//define default error message
	public String message() default "must start with LUV";
	
	//define default groups
	public Class<?>[] groups() default {}; // Groups can relate constraints
	
	//define default payloads
	public Class<? extends Payload>[] payload() default {}; 
	//Payloads provide details about validation failure ( Severity level , error code etc )
}
