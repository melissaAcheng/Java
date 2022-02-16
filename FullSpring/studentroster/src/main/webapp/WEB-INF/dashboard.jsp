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
<title>Dormitories</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div>
		<h1>Dormitories</h1>
		<form:form action="/dorms/add" method="post" modelAttribute="dorm">
			<div class="mb-3">
				<form:label path="name" class="form-label">Name:</form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input class="form-control" path="name"/>
			</div>
			<input type="submit" value="Create" />
		</form:form>
	</div>
	<div>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Dormitory</th>
		      <th scope="col">Students</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="dorm" items="${ dorms }">
		  	<tr>
		  		<td><c:out value="${ dorm.name }"></c:out></td>
		  		<td><a href="/dorms/${ dorm.id }">See all students</a></td>
		  	</tr>		  	
		  	</c:forEach>
		  </tbody>
		</table>
	</div>
</body>
</html>