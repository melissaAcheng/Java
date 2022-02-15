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
	<h1><c:out value="${ category.name }"></c:out></h1>
	<div>
		<h2>Products:</h2>
		<ul> 
			<!-- Loop through and display all products with categoryID of category.id -->
			<c:forEach var="product" items="${ productsInCategory }">
				<li><c:out value="${ product.name }"></c:out></li>	
			</c:forEach>
		</ul>
	</div>
	<div>
		<form:form action="/categories/${ category.id }" method="POST" modelAttribute="product">
			<div class="mb-3">
				<form:label path="name" class="form-label">Products:</form:label>
				<form:select path="id" class="form-select">
					<c:forEach var="product" items="${ remainingProducts }">
						<form:option value="${ product.id }">
							<c:out value="${ product.name }"></c:out>
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
	<a href="/categories/all">View All Categories</a>
</body>
</html>