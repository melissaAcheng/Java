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
	<div class="header d-flex justify-content-end">
		<a href="/languages">Dashboard</a>
	</div>
	<div class="mt-3">
		<h1>Language Details</h1>
		<p>Language Name: <c:out value="${ language.name }"></c:out></p>
		<p>Creator: <c:out value="${ language.creator }"></c:out><p>
		<p>Current Version: <c:out value="${ language.currentVersion }"></c:out></p>
		<a href="/languages/edit/${language.id}">Edit</a>
		<form action="/languages/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>