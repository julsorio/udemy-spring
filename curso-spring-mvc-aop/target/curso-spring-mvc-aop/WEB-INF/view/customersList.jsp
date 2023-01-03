<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<input type="button" value="add customer"
				onclick="window.location.href='showFormForAdd';return false;"
				class="add-button">

			<form:form action="search" method="GET">
                Search customer: <input type="text" name="search" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>

				<c:forEach var="customer" items="${customersList}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>

					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete?'))) return false">Delete</a></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>