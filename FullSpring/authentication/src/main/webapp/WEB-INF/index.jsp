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
<title>Login and Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body class="container">
	<div class="mt-2">
		<h1>Welcome!</h1>
		<p>Join our growing community.</p>
	</div>
	
	<div class="row">
		<div class="col">
			<h1>Register</h1>
			<form:form class="mb-5" action="/register" method="post" modelAttribute="newUser">
				<div class="mb-3">
					<form:label path="userName" class="form-label">User Name</form:label>
					<form:errors path="userName" class="text-danger"/>
					<form:input class="form-control" path="userName"/>
				</div>
				<div class="mb-3">
					<form:label path="email" class="form-label">Email</form:label>
					<form:errors path="email" class="text-danger"/>
					<form:input type="email" class="form-control" path="email"/>
				</div>
				<div class="mb-3">
					<form:label path="password" class="form-label">Password</form:label>
					<form:errors path="password" class="text-danger"/>
					<form:input type="password" class="form-control" path="password"/>
				</div>
				<div class="mb-3">
					<form:label path="confirm" class="form-label">Confirm Password</form:label>
					<form:errors path="confirm" class="text-danger"/>
					<form:input type="password" class="form-control" path="confirm"/>
				</div>
				<input type="submit" value="Submit" />
			</form:form>
		</div>
		
		<div class="col">
			<h1>Login</h1>
			<form:form class="mb-5" action="/login" method="post" modelAttribute="newLogin">
				<div class="mb-3">
					<form:label path="email" class="form-label">Email</form:label>
					<form:errors path="email" class="text-danger"/>
					<form:input type="email" class="form-control" path="email"/>
				</div>
				<div class="mb-3">
					<form:label path="password" class="form-label">Password</form:label>
					<form:errors path="password" class="text-danger"/>
					<form:input type="password" class="form-control" path="password"/>
				</div>
				<input type="submit" value="Submit" />
			</form:form>
		</div>
	</div>
</body>
</html>