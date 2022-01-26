<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html class="h-100 bg-secondary">
<head>
<meta charset="UTF-8">
<title>Fruit Store</title>
<!-- import bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- import js file -->
<script type="text/javascript" src="js/script.js"></script>
</head>
<body class="container h-100 w-50 pt-5">
	<div class="h-100">
		<h1>Fruit Selection</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fruit" items="${ fruits }">
					<tr>
						<td><c:out value="${ fruit.name }"></c:out></td>
						<td><c:out value="${ fruit.price }"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>