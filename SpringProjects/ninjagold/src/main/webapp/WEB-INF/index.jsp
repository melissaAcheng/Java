<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container p-5">
	<h1 class="d-flex justify-content-center">Ninja Gold Game</h1>
	<div class="mb-5">
		<h2>Your Gold: <c:out value="${ totalCount }"></c:out></h2>
	</div>
	<div class="row row-cols-1 row-cols-md-4 g-4 mb-5">
		<div class="col">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Farm</h5>
					<p class="card-text">(earns 10-20 gold)</p>
					<form action="/findGold" method="post">
						<input type="hidden" name="location" value="farm"/>
						<input type="submit" value="Find Gold!"/>
					</form>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Cave</h5>
					<p class="card-text">(earns 5-10 gold)</p>
					<form action="/findGold" method="post">
						<input type="hidden" name="location" value="cave"/>
						<input type="submit" value="Find Gold!"/>
					</form>
				</div>
			</div>		
		</div>
		<div class="col">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">House</h5>
					<p class="card-text">(earns 2-5 gold)</p>
					<form action="/findGold" method="post">
						<input type="hidden" name="location" value="house"/>
						<input type="submit" value="Find Gold!"/>
					</form>
				</div>
			</div>		
		</div>
		<div class="col">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Casino!</h5>
					<p class="card-text">(earns/takes 0-50 gold)</p>
					<form action="/findGold" method="post">
						<input type="hidden" name="location" value="casino"/>
						<input type="submit" value="Find Gold!"/>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div>
		<h2>Activities:</h2>
		<form action="/restart" method="post" class="mb-2">
			<input type="submit" value="Restart Game" />
		</form>
		<div>
			<c:forEach var="play" items="${ plays }">
				<c:if test = "${ play.gold > 0 }">
					<p class="text-success">You entered a <c:out value="${ play.location }"></c:out> and earned <c:out value="${ play.gold }"></c:out> gold (<c:out value="${ play.date }"></c:out>)</p>
				</c:if>
				<c:if test = "${ play.gold < 0 }">
					<p class="text-danger">You entered a <c:out value="${ play.location }"></c:out> and lost <c:out value="${ play.gold }"></c:out> gold at (<c:out value="${ play.date }"></c:out>)</p>
				</c:if>
				
			</c:forEach>
		</div>
	</div>
</body>
</html>