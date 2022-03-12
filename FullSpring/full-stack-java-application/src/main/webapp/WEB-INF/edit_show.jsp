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
<title>Edit Show</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div class="mt-2">
		<h1>${ show.title }</h1>
	</div>
	
	<div>
		<form:form action="/shows/${ show.id }/update" method="post" modelAttribute="show">
			<input type="hidden" name="_method" value="put"/>
			<div class="mb-3">
				<form:label path="title" class="form-label">Title:</form:label>
				<form:errors path="title" class="text-danger"/>
				<form:input class="form-control" path="title"/>
			</div>
			<div class="mb-3">
				<form:label path="network" class="form-label">Network:</form:label>
				<form:errors path="network" class="text-danger"/>
				<form:input class="form-control" path="network"/>
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label">Description:</form:label>
				<form:errors path="description" class="text-danger"/>
				<form:textarea path="description" class="form-control" cols="10" rows="5"/>
			</div>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
	<p><a href="/shows">Cancel</a></p>
	<p><a href="/shows/${show.id}/delete">Delete</a></p>
</body>
</html>