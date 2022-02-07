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
    <title>Dojos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	
	<a href="/dojos">Dashboard</a>
	<a href="/ninjas">Add New Ninja</a>
	
	<div>
		<h1>Add New Dojo</h1>
		
		<!-- Add new dojo location -->
		
		<form:form class="mb-5" action="/dojos" method="post" modelAttribute="dojo">
			<div class="mb-3">
				<form:label path="name" class="form-label">Location</form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input type="text" class="form-control" path="name"/>
			</div>
			<input type="submit" value="Create" />
		</form:form>
		
		<!-- Add table of Dojos here -->
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Location</th>
		      <th scope="col">Actions</th>	      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="dojo" items="${ dojos }">
				<tr>
					<td><c:out value="${ dojo.name }"></c:out></td>
					<td><a href="/dojos/<c:out value="${ dojo.id }"></c:out>">See Students</a></td>
				</tr>
		  	</c:forEach>		
			
		  </tbody>
		</table>
		
	</div>
	
</body>
</html>