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
	<h1><c:out value="${ product.name }"></c:out></h1>
	<div>
		<h2>Categories:</h2>
		<ul> 
			<!-- Loop through and display all categories with productID of products.id -->
			<c:forEach var="category" items="${ categoriesForProduct }">
				<li><c:out value="${ category.name }"></c:out></li>	
			</c:forEach>
		</ul>
	</div>
	<div>
		<form:form action="/products/${ product.id }" method="POST" modelAttribute="category">
			<div class="mb-3">
				<form:label path="name" class="form-label">Categories:</form:label>
				<form:select path="id" class="form-select">
					<c:forEach var="category" items="${ remainingCategories }">
						<form:option value="${ category.id }">
							<c:out value="${ category.name }"></c:out>
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
	<a href="/products/all">View All Products</a>
</body>
</html>