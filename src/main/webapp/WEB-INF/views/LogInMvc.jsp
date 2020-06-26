<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Log In Page Spring MVC</title>
	</head>
	<body>
	<div>${ ErrorMessage }</div>
	<form action="/mvc/login" method="post">
		<label>Name</label>
		<input type="text" name="name" />
		<label>Password</label>
		<input type="password" name="password" />
		<br>
		<input type="submit" />
	</form>
	</body>
</html>