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
<title>TV Show Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body class="container mt-3">
	<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4">
		<h1 class="d-flex align-items-center text-dark text-decoration-none">${ show.title }</h1>
		<div class="col-md-3 text-end">
			<a href="/shows">Back to Dashboard</a>
		</div>
	</div>
	<div>
		<p><b>Posted by: <c:out value="${ show.user.name }"></c:out></b></p>
		<p>Network: <c:out value="${ show.network }"></c:out> </p>
		<p>Description: <c:out value="${ show.description }"></c:out> </p>
	</div>
	<a href="/shows/${ show.id }/edit">Edit</a>	
		
	<!-- Display table of ratings here and form for user to input rating -->
	<div class="mt-3">
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Rating</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="showRating" items="${ showRatings }">
			  	<tr>
			  		<td><c:out value="${ showRating.user.name }"></c:out></td>
			  		<td><c:out value="${ showRating.amount }"></c:out> </td>
			  	</tr>
		  	</c:forEach>
		  </tbody>
		</table>
		<form:form action="/ratings/${ show.id }/add" method="post" modelAttribute="rating">
			<div class="mb-3">
				<form:label path="amount">Leave a Rating:</form:label>
				<form:errors path="amount" class="text-danger"/>
				<form:input type="number" min="1" max="5" step="0.1" path="amount"/>
			</div>
			<input type="submit" value="Rate" />
		</form:form>
	</div>
</body>
</html>