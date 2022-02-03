<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expenses</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">
	<div>
		<h1>Save Travels</h1>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Expense</th>
		      <th scope="col">Vendor</th>
		      <th scope="col">Amount</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach var="expense" items="${ expenses }">
			<tr>
		      <td><c:out value="${ expense.name }"></c:out></td>
		      <td><c:out value="${ expense.vendor }"></c:out></td>
		      <td>$<c:out value="${ expense.amount }"></c:out></td>
		      <td><a href="/expenses/edit/<c:out value="${ expense.id }"></c:out>">edit</a></td>
		    </tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
	
	<div>
		<h2>Add an expense:</h2>
		<form:form action="/expenses" method="post" modelAttribute="expense">
			<div class="mb-3">
				<form:label path="name" class="form-label">Expense</form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input type="text" class="form-control" path="name"/>
			</div>
			<div class="mb-3">
				<form:label path="vendor" class="form-label">Vendor</form:label>
				<form:errors path="vendor" class="text-danger"/>
				<form:input type="text" class="form-control" path="vendor"/>
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
	</div>
</body>
</html>