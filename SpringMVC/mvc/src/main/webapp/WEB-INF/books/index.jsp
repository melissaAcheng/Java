<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">
	<h1>All Books</h1>
	<table class="table">
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Language</th>
            <th scope="col">Number of Pages</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="book" items="${ books }">
         	<tr>
         		<td scope="row"><c:out value="${ book.id }"></c:out></td>
         		<td><a href="/books/${ book.id }"><c:out value="${ book.title }"></c:out></a></td>
         		<td><c:out value="${ book.language }"></c:out></td>
         		<td><c:out value="${ book.numberOfPages }"></c:out></td>
         	</tr>
         </c:forEach>
    </tbody>
</table>
</body>
</html>