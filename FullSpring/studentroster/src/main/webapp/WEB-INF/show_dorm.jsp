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
<title>Show Dormitory</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
		<h1>${ dorm.name }</h1>
	<div>
		<h3>Students: </h3>
		<form action="/students/add/${ dorm.id }" method="post">
			<div class="mb-3">
				<label for="student" class="form-label">Name:</label>
				<select name="student">
					<c:forEach var="student" items="${ students }">
						<option value="${ student.id }">
							<c:out value="${ student.fullName }"></c:out>
						</option>
					</c:forEach>
				</select>
				<input type="submit" value="Submit" />
			</div>
		</form>
	</div>
	<div>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="student" items="${ dorm.getStudents() }">
		  	<tr>
		  		<td><c:out value="${ student.fullName }"></c:out></td>
		  		<td><a href="/dorms/${ dorm.id }/remove/${ student.id}">Remove</a></td>
		  	</tr>		  
		  </c:forEach>

		  </tbody>
		</table>
	</div>
	
	<a href="/dorms/new">Back</a>
</body>
</html>