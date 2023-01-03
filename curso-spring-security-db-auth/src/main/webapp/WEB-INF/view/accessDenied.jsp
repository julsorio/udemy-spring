<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>

</head>

<body>

	<h2>Access denied - you're not authorized to access this resource</h2>

	<c:set var="myContext" value="${pageContext.request.contextPath}" />

	<p>
		<c:out value="${myContext}" />
	</p>

	<a href="${myContext}">Back to home page</a>
</body>

</html>