package com.luv2code.springdemo.model;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"countryOptions","language","operatingSystem","studentAddress"})
@JsonPropertyOrder({"dob","first_name","lastName"})
public class Student {
	
	@Pattern(regexp="[^0-9]*")
	@JsonProperty("first_name")
	private String firstName;
	@Size(min=2,max=15)
	private String lastName;
	@Max(2222)
	private Long mobileNumber;
	private String country;
	@IsValidHobby
	private String studentHobby;
	@Past //if the value you are binding , is in future give it as binding error
	private Date DOB;
	private LinkedHashMap<String, String> countryOptions;
	private String language;
	private String[] operatingSystem;
	private Address studentAddress;

	public Student() {
		//populate country options
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");  //first value is code/key and second value is value/label
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
	}
	
	
	
	public String getStudentHobby() {
		return studentHobby;
	}



	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}



	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}



	public Student(@Pattern(regexp = "[^0-9]*") String firstName, @Size(min = 2, max = 15) String lastName,
			String country, String studentHobby,String language) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.studentHobby = studentHobby;
		this.language = language;
	}
	
	
	
}
