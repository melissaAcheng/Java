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
	<h1>All Products</h1>
	<div>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Name</th>
		      <th scope="col">Description</th>
		      <th scope="col">Price</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach var="product" items="${ products }">
			<tr>
		      <td><c:out value="${ product.id }"></c:out></td>
		      <td><a href="/products/${product.id}"><c:out value="${ product.name }"></c:out></a></td>
		      <td><c:out value="${ product.description }"></c:out></td>
		      <td>$<c:out value="${ product.price }"></c:out></td>
		    </tr>
			</c:forEach>	
		  </tbody>
		</table>
	</div>
	<a href="/">Home</a>
</body>
</html>