<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">
	<h1>Expense Details</h1>
	<p>Expense Name: <c:out value="${ expense.name }"></c:out></p>
	<p>Vendor: <c:out value="${ expense.vendor }"></c:out><p>
	<p>Description: <c:out value="${ expense.description }"></c:out></p>
	<p>Amount Spent: $<c:out value="${ expense.amount }"></c:out></p>
	<a href="/expenses">Back</a>
</body>
</html>