<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Custom Login Page</title>

<style>
.failed {
	color: red;
}
</style>

</head>

<body>

	<h3>My Custom Login Page</h3>


	<c:set var="myContext" value="${pageContext.request.contextPath}" />

	<p>
		<c:out value="${myContext}" />
	</p>

	<form:form action="${myContext}/authenticateTheUser" method="POST">

		<!-- Check for login error -->

		<c:if test="${param.error != null}">

			<i class="failed">Sorry! You entered invalid username/password.</i>

		</c:if>

		<p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>

		<input type="submit" value="Login" />

	</form:form>

</body>

</html>












