<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>register</title>
</head>
<body>
	<form:form action="processRegister" modelAttribute="student">
	First name: <form:input path="firstName" />
	Last name: <form:input path="lastName" />

		<br />
	
	Country: <form:select path="countryName">
			<!-- <form:option value="br" label="Brasil" />
	<form:option value="fr" label="France" />
	<form:option value="co" label="Colombia" /> -->

			<form:options items="${student.countryMap}" />

		</form:select>

		<br />
	
	Vehicle: <form:select path="vehicle">
			<form:options items="${vehicleOptions}" />
		</form:select>

		<br />

	Language:
		<!-- Java <form:radiobutton path="language" value="Java" />
		Php <form:radiobutton path="language" value="Php" />
		Javascript <form:radiobutton path="language" value="Javascript" />
		.Net <form:radiobutton path="language" value=".Net" /> -->

		<form:radiobuttons path="language" items="${student.languageMap}" />

		<br />
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		MacOS <form:checkbox path="operatingSystems" value="MacOS" />
		Windows <form:checkbox path="operatingSystems" value="Windows" />

		<br />

		<input type="submit" value="submit" />
	</form:form>
</body>
</html>