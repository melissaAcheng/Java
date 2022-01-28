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
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji/submit" method="post">
		<div class="form-group mt-2">
			<label for="number">Pick any number from 5 to 25:</label>
			<input type="number" class="form-control-sm" name="number" min="5" max="25">
		</div>
		<div class="form-group mt-2">
			<label for="city">Enter the name of any city:</label>
			<input type="text" class="form-control" name="city" />
		</div>
		<div class="form-group mt-2">
			<label for="person">Enter the name of any real person:</label>
			<input type="text" class="form-control" name="person" />
		</div>
		<div class="form-group mt-2">
			<label for="hobby">Enter professional endeavor or hobby:</label>
			<input type="text" class="form-control" name="hobby" />
		</div>
		<div class="form-group mt-2">
			<label for="animal">Enter any type of living thing:</label>
			<input type="text" class="form-control" name="animal" />
		</div>
		<div class="form-group mt-2">
			<label for="words">Say something nice to someone:</label>
			<textarea name="words" class="form-control" cols="30" rows="5"></textarea>
		</div>
			<input class="mt-2" type="submit"/>
	</form>
	<p class="mt-2">Send and show a friend</p>
</body>
</html>