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
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	
	<a href="/dojos">Dashboard</a>
	
	<div>
		<h1>Add New Ninja</h1>
		
		<!-- Add new ninja -->
		
		<form:form class="mb-5" action="/ninjas" method="post" modelAttribute="ninja">
			<div class="mb-3">
				<form:label path="dojo" class="form-label">Select Dojo: </form:label>
				<form:select path="dojo" class="form-select">
					<!-- Add for loop here to get all dojo names -->
					<c:forEach var="dojo" items="${ dojos }">
						<form:option value="${ dojo }">
							<c:out value="${ dojo.name }"></c:out>
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="mb-3">
				<form:label path="firstName" class="form-label">First Name: </form:label>
				<form:errors path="firstName" class="text-danger"/>
				<form:input type="text" class="form-control" path="firstName"/>
			</div>
			<div class="mb-3">
				<form:label path="lastName" class="form-label">Last Name: </form:label>
				<form:errors path="lastName" class="text-danger"/>
				<form:input type="text" class="form-control" path="lastName"/>
			</div>
			<div class="mb-3">
				<form:label path="age" class="form-label">Age: </form:label>
				<form:errors path="age" class="text-danger"/>
				<form:input type="number" class="form-control" path="age"/>
			</div>
			<input type="submit" value="Create" />
		</form:form>
		
		
	</div>
	
</body>
</html>