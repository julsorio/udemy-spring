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
<title>Home Page</title>

</head>

<body>

	<h3>Home Page</h3>

	<c:set var="myContext" value="${pageContext.request.contextPath}" />

	<p>
		<c:out value="${myContext}" />
	</p>

	<!-- display user name and role -->
	<p>
		user:
		<security:authentication property="principal.username" />
		<br> <br> roles:
		<security:authentication property="principal.authorities" />
	</p>

	<br>

	<!-- link for leaders -->
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${myContext}/leaders">Leaders</a>
		</p>
	</security:authorize>

	<!-- link for systems -->
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${myContext}/systems">Admins</a>
		</p>
	</security:authorize>

	<form:form action="${myContext}/logout" method="POST">

		<input type="submit" value="Logout" />

	</form:form>

</body>

</html>