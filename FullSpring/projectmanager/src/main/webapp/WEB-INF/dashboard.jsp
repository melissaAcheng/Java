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
<title>Project Manager Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div class="mt-2">
		<h1>Welcome ${ user.firstName }</h1>
		<p><a href="/logout">Logout</a></p>
		<p><a href="/projects/new">Add New Project</a></p>
	</div>
	
	<div>
		<h3 class="mb-3 text-primary">All Projects</h3>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Project</th>
		      <th scope="col">Team Lead</th>
		      <th scope="col">Due Date</th>
		      <th scope="col">Actions</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach var="project" items="${ projects }">
				<tr>
					<td><a href="/projects/${ project.id }"><c:out value="${ project.title }"></c:out></a></td>
					<td><c:out value="${ project.teamLead.firstName }"></c:out></td>
					<td><fmt:formatDate type="date" value="${ project.dueDate }"/></td>
					<td><a href="/projects/${ project.id }/join">Join team</a></td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
	
	<div>
		<h3 class="mb-3 text-primary">Your Projects</h3>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Project</th>
		      <th scope="col">Team Lead</th>
		      <th scope="col">Due Date</th>
		      <th scope="col">Actions</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach var="projectIn" items="${ projectsUserIsIn }">
				<tr>
					<td><a href="/projects/${ projectIn.id }"><c:out value="${ projectIn.title }"></c:out></a></td>
					<td><c:out value="${ projectIn.teamLead.firstName }"></c:out></td>
					<td><fmt:formatDate type="date" value="${ projectIn.dueDate }"/></td>
					<c:choose>
						<c:when test="${ projectIn.teamLead == user }">
							<td><a href="/projects/${ projectIn.id }/edit">Edit</a></td>
						</c:when>
						<c:otherwise>
							<td><a href="/projects/${ projectIn.id }/leave">Leave</a></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
	
</body>
</html>