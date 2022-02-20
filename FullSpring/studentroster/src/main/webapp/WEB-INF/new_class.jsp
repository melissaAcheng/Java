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
<title>Classes</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div>
		<h1>Classes</h1>
		<form:form action="/classes/add" method="post" modelAttribute="classClass">
			<div class="mb-3">
				<form:label path="classname" class="form-label">Class:</form:label>
				<form:errors path="classname" class="text-danger"/>
				<form:input class="form-control" path="classname"/>
			</div>
			<input type="submit" value="Create" />
		</form:form>
	</div>
	<div>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Classes</th>
		      <th scope="col">Students</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="oneClass" items="${ classes }">
		  	<tr>
		  		<td><c:out value="${ oneClass.classname }"></c:out></td>
		  		<td><a href="/classes/${ oneClass.id }">See all students</a></td>
		  	</tr>		  	
		  	</c:forEach>
		  </tbody>
		</table>
	</div>
</body>
</html>