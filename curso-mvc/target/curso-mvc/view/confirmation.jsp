<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	Confirmation
	<br /> ${student.firstName} ${student.lastName}

	<br /> ${student.countryName}

	<br /> ${student.vehicle}

	<br /> ${student.language}

	<br /> 
	
	<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
		<li>${temp}</li>
	</c:forEach>
	</ul>

</body>
</html>