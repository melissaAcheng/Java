<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body class="container mt-3">
	<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4">
		<h1 class="d-flex align-items-center text-dark text-decoration-none">Project Details</h1>
		<div class="col-md-3 text-end">
			<a href="/dashboard">Back to Dashboard</a>
		</div>
	</div>
	<div>
		<p>Project: <c:out value="${ project.title }"></c:out></p>
		<p>Description: <c:out value="${ project.description }"></c:out> </p>
		<p>Due Date: <fmt:formatDate type="date" dateStyle = "short" value="${ project.dueDate }"/></p>
	</div>
	<c:if test="${ user.id == project.teamLead.id }">
		<a href="/projects/${ project.id }/delete">Delete</a>		
	</c:if>
</body>
</html>