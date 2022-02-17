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
<title>New Question</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div>
		<h1>What is your question?</h1>
		<form action="/questions/add" method="post">
			<div class="mb-3">
				<label for="question" class="form-label">Question:</label>
				<form:errors path="question.question" class="text-danger"/>
				<input type="text" class="form-control" name="question"/>
			</div>
			<div class="mb-3">
				<label for="tags" class="form-label">Tags:</label>
				<input type="text" class="form-control" name="tags"/>
			</div>
			<input type="submit" value="Submit" />
		</form>
	</div>
	
	<a href="/questions">Dashboard</a>
</body>
</html>