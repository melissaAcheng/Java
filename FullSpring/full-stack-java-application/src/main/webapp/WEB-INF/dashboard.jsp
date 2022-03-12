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
<title>TV Shows Database</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	
	<div class="mt-2">
		<h1>Welcome ${ user.name }</h1>
		<p><a href="/logout">Logout</a></p>
	</div>
	
	<div>
		<h3 class="mb-3 text-primary">TV Shows</h3>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Show</th>
		      <th scope="col">Network</th>
		      <th scope="col">Average Rating</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="show" items="${ shows }">
			  	<tr>
			  		<td><a href="/shows/${ show.id }"><c:out value="${ show.title }"></c:out></a></td>
			  		<td><c:out value="${ show.network }"></c:out> </td>
			  		<td><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${show.getAverageRatings()}" /></td>
			  	</tr>
		  	</c:forEach>
		  </tbody>
		</table>
	</div>
	<p><a href="/shows/new">Add a Show</a></p>
</body>
</html>