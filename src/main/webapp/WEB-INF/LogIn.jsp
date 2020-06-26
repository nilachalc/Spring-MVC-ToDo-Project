<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Log In Page</title>
	</head>
	<body>
	<form action="/login.do" method="post">
		<div>${ ErrorMessage }</div>
		<div><label>Name</label></div>
		<div><input type="text" name="name" /></div>
		<div><label>Password</label></div>
		<div><input type="password" name="password" /></div>
		<br>
		<div><input type="submit" /></div>
	</form>
	</body>
</html>