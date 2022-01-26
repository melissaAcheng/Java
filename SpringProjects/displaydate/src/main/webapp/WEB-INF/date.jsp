<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<title>Date</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="js/app.js"></script>
</head>
<body class="container h-100">
	<div class="d-flex h-100 justify-content-around align-items-center">
		<h1 class='text-primary'><c:out value="${date}"></c:out></h1>
	</div>
</body>
</html>