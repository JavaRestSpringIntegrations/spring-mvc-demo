<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" type="text/css"           
           href="${pageContext.request.contextPath}/resources/css/test.css">
    <title>Student Registration Form</title>       
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName"/>
		<br><br>
		Last Name: <form:input path="lastName"/>
		<br><br>
		
		<form:select path="country">
	<!--   	<form:option value="Brazil" label="Brazil"></form:option>
			<form:option value="France" label="France"></form:option>
			<form:option value="Germany" label="Germany"></form:option>
			<form:option value="India" label="India"></form:option> -->
			<form:options items="${student.countryOptions}"></form:options> <!-- Using the values from list will 
																			call student.getCountryOptions -->
			<form:option value="USA" label="USA"></form:option>																
		</form:select>
		<br><br>
		<form:radiobutton path="language" value="Java" label="Java"/>
		<form:radiobutton path="language" value=".NET" label=".NET"/>
		<form:radiobutton path="language" value="C++" label="C++"/>
		<form:radiobutton path="language" value="PHP" label="PHP"/>
		<br><br>
		MacOS<form:checkbox path="operatingSystem" value="MacOS"/> <!-- On submitting Spring will call setter method -->
		Linux<form:checkbox path="operatingSystem" value="Linux"/>
		Windows<form:checkbox path="operatingSystem" value="Windows"/>
		<br><br>
		<input type="submit" value="Submit">
		<br><br>
	</form:form>
</body>
</html>