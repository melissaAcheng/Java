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
<title>Question</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div>
		<h1>${ question.question }</h1>
		<h3>Tags: </h3>
		<div>
			<c:forEach var="tagQuestion" items="${ question.tagQuestion }">
				<p><c:out value="${ tagQuestion.tag.subject }"></c:out></p>
			</c:forEach>
		</div>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Answers</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="answer" items="${ question.answers }">
		  		<tr>
		  			<td><c:out value="${ answer.answer }"></c:out></td>
		  		</tr>
		  	</c:forEach>
		  </tbody>
		</table>
	</div>
	<div>
		<h3>Add your answer:</h3>
		<form:form action="/answers/add/${ question.id }" method="post" modelAttribute="newAnswer">
			<div class="mb-3">
				<form:label path="answer" class="form-label">Answer:</form:label>
				<form:errors path="answer" class="text-danger"/>
				<form:textarea path="answer" rows="4" cols="20"/>
			</div>
			<input type="submit" value="Submit" />
		</form:form>
	
	</div>
	
	
	<a href="/questions">Back</a>
</body>
</html>