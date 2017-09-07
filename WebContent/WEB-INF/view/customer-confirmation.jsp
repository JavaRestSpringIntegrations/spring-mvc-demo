<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>Customer Confirmation Page</title>
</head>
<body>
	The customer name is: ${customer.firstName} ${customer.lastName} with ${customer.freePasses} free passes.
	<br><br>
	Postal Code: ${customer.postalCode}
	<br><br>
	Course Code: ${customer.courseCode}
</body>
</html>
