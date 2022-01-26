<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<title>Current Visit Count</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container h-100 d-flex flex-column justify-content-center align-items-center">
	<h2>You have visited <a href="/">Welcome Page</a> <c:out value="${ countToShow }"></c:out> times.</h2>
	<h2><a href="/">Test another visit?</a></h2>
</body>
</html>