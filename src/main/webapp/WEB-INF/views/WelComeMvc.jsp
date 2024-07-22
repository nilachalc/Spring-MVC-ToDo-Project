<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome MVC</title>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
    		rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	</head>
	<body>
		<div class="container" ><p class="lead">Welcome ${ name }</p></div>
		<form id="WelComeMvc" name="WelComeMvcContainer" action="/mvc/login" method="get" >
			<div class="container">
				<table class="table table-striped">
					<tr>
					  <th colspan="3" >:: All The ToDos are In The List Below ::</th>
					</tr>
					<tr>
					  	<td>
							<table class="table">
								<tr style="background-color: aqua;">
									<td><label class="label" >Sr. #</label></td>
									<td><label class="label" >Description</label></td>
									<td><label class="label" >Target Date</label></td>
								</tr>
								<c:forEach items="${allToDos}" var="toDo">
									<tr>
										<td><label>${toDo.toDoId}</label></td>
										<td><label>${toDo.description}</label></td>
										<td><label>${toDo.targetDate}</label></td>
									</tr>		
								</c:forEach>
							</table>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td>
							<a class="button" href="/mvc/login">Ok, Thanks</a>
						</td>
					</tr>
				</table>
			<p><p>
			</div>
		</form>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>