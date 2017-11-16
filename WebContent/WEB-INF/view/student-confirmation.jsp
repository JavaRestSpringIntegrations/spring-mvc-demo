<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- The above is used because we have a checkbox and it can have multiple values
its declared as String array, but to display in page we need to loop and hence
we use the jstl tags-->
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" type="text/css"           
           href="${pageContext.request.contextPath}/resources/css/test.css">
    <title>Student Confirmation Page</title>       
</head>
<body>
<!-- the below code depicts the getter method in JAVA -->
The student is confirmed:  ${student.firstName} ${student.lastName} from ${student.country}
<br><br>
Language: ${student.language}
<br><br>
Hobby: ${student.studentHobby}
<br><br>
<!-- DOB: ${student.DOB} -->
<br><br>
OS:
<ul>
	<c:forEach var="temp" items="${student.operatingSystem}">
	
		<li> ${temp} </li>
	
	</c:forEach>
</ul>
<br><br>
Mobile Number : ${student.mobileNumber}
<br><br>
Address:
Country: ${student.studentAddress.country}
<br>
City : ${student.studentAddress.city}
<br>
Street: ${student.studentAddress.street}
<br>
Pincode: ${student.studentAddress.pincode}
</body>
</html>