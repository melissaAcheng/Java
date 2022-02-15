<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products and Categories</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container mt-3">
	<h1>Add New Product</h1>
	<div>
		<form:form action="/products/add" method="post" modelAttribute="product">
			<div class="mb-3">
				<form:label path="name" class="form-label">Name:</form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input class="form-control" path="name"/>
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label">Description</form:label>
				<form:errors path="description" class="text-danger"/>
				<form:textarea path="description" class="form-control" cols="10" rows="5"/>
			</div>
			<div class="mb-3">
				<form:label path="price" class="form-label">Price</form:label>
				<form:errors path="price" class="text-danger"/>
				<form:input type="number" min="0.01" step="0.01" max="2500" class="form-control" path="price"/>
			</div>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
	<a href="/">Home</a>
</body>
</html>