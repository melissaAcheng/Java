<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container w-50 p-3">
	<h1>Here's Your Omikuji!</h1>
	<div class="card mt-2 mb-2">
		<div class="card-body">
			<p><c:out value="${ result }"></c:out></p>
		</div>
	</div>
	<a href="/omikuji">Go Back</a>
</body>
</html>