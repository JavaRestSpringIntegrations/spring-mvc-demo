<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" type="text/css"           

           href="${pageContext.request.contextPath}/resources/css/test.css">
</head>
<body>
Hello World of Spring
<br><br>
Student name : ${param.studentName} 
<br><br>
<!-- Accessing message from the model -->
The message : ${message} 
<br><br>
Testing image loading below
<br>
<img src="${pageContext.request.contextPath}/resources/images/test.png" />
</body>
</html>