<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>employee registration</title>

<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>

	<form:form action="processRegistration" modelAttribute="employee">

Fist name (*): <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br />
Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br />
Age (*): <form:input path="age" />
		<form:errors path="age" cssClass="error" />
		<br />
Postal code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		<br />
Employee code:
		<form:input path="employeeCode" />
		<form:errors path="employeeCode" cssClass="error" />
		<br />

		<input type="submit" value="submit" />
	</form:form>

</body>
</html>