<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="container">
	<div>
		<h1>Edit Expense</h1>
		<a href="/expenses">Go back</a>
	</div>
	<form:form action="/expenses/${ expense.id }" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put"/>
		<div class="mb-3">
			<form:label path="name" class="form-label">Expense</form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input class="form-control" path="name"/>
		</div>
		<div class="mb-3">
			<form:label path="vendor" class="form-label">Vendor</form:label>
			<form:errors path="vendor" class="text-danger"/>
			<form:input class="form-control" path="vendor"/>
		</div>
		<div class="mb-3">
			<form:label path="amount" class="form-label">Amount</form:label>
			<form:errors path="amount" class="text-danger"/>
			<form:input type="number" min="0.01" step="0.01" max="2500" class="form-control-sm" path="amount"/>
		</div>
		<div class="mb-3">
			<form:label path="description" class="form-label">Description</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:textarea path="description" class="form-control" cols="10" rows="5"/>
		</div>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>