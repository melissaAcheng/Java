<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ language.name }"></c:out></title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container p-5">
	<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3">
		<nav class="my-2 my-md-0 mr-md-3">
			<a href="/languages/delete/${language.id}">Delete</a>
			<a href="/languages">Dashboard</a>
		</nav>
	</div>
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language" class="p-5">
		<input type="hidden" name="_method" value="put"/>
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
		<input type="submit" value="Update"/>
	</form:form>
</body>
</html>