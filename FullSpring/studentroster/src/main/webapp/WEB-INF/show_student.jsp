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
<title>Show Class</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
		<h1>${ student.fullName }</h1>
	<div>
		<form action="/students/${student.id}/addClass" method="post">
			<div class="mb-3">
				<label for="classes" class="form-label">Classes:</label>
				<select name="classes">
					<c:forEach var="oneClass" items="${ classes }">
						<option value="${ oneClass.id }">
							<c:out value="${ oneClass.classname }"></c:out>
						</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add" />
			</div>
		</form>
	</div>
	<div>
		<h2>Schedule</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Class Name</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="studentClasses" items="${ student.studentsClasses }">
		  	<tr>
		  		<td><c:out value="${ studentClasses.classes.classname }"></c:out></td>
		  		<td><a href="/classes/${studentClasses.classes.id }/remove/${ studentClasses.student.id}">Drop Class</a></td>
		  	</tr>		  
		  </c:forEach>

		  </tbody>
		</table>
	</div>
	
	<a href="/classes/new">All Classes</a>
</body>
</html>