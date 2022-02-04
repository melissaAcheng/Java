<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">
	<div class="mb-5 p-5">
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Creator</th>
		      <th scope="col">Version</th>
		      <th scope="col">Actions</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="language" items="${ languages }">
			    <tr>
			      <th scope="row"><a href="/languages/${ language.id }"><c:out value="${ language.name }"></c:out></a></th>
			      <td><c:out value="${ language.creator }"></c:out></td>
			      <td><c:out value="${ language.currentVersion }"></c:out></td>
			      <td>
			      	<form action="/languages/${language.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
				</td>
			      <td><a href="/languages/edit/${ language.id }">Edit</a></td>
			    </tr>
		  	</c:forEach>
		  </tbody>
		</table>
	</div>
	<form:form action="/languages" method="post" modelAttribute="language" class="p-5">
		<div class="mb-3">
			<form:label path="name" class="form-label">Name</form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input class="form-control" path="name"/>
		</div>
		<div class="mb-3">
			<form:label path="creator" class="form-label">Creator</form:label>
			<form:errors path="creator" class="text-danger"/>
			<form:input class="form-control" path="creator"/>
		</div>
		<div class="mb-3">
			<form:label path="currentVersion" class="form-label">Current Version</form:label>
			<form:errors path="currentVersion" class="text-danger"/>
			<form:input class="form-control" path="currentVersion"/>
		</div>
		<input type="submit" value="Add"/>
	</form:form>
</body>
</html>