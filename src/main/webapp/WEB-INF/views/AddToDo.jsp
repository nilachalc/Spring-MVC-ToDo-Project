<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add ToDo</title>
		<link href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css"
    		rel="stylesheet">
   		<%
			if (request.getSession(true).getAttribute("loggedinUserId") == null) {
				response.sendRedirect("/mvc/todo-login");
			}
		%>
	</head>
	<body>
	<p class="text-danger"><b>${ ErrorMessage }</b></p>
	<div class="container">
		<form action="/mvc/add-ToDo?loggedinUserId=${loggedinUserId}" method="post">
		<table class="table table-striped" >
			<tr style="background-color: aqua;">
			  <th colspan="2" class="lead" >:: Enter Your ToDo ::</th>
			</tr>
			<tr>
				<td><label>Description</label></td>
				<td><input class="text" type="text" name="description" /></td>
			</tr>
			<tr>
				<td><label>Target Date</label></td>
				<td>
					<!-- <input class="text" id="targetDate" name="targetDate" /> -->
					<jsp:include page="../views/DatePicker.html"></jsp:include>
			    	<input name="targetDate" id="targetDateId" type= "hidden" class="textbox">
				</td>
			</tr>
			<tr>
				<td><label>Is Completed</label></td>
				<td><input class="text" type="checkbox" name="isCompleted" /></td>
			</tr>
			<tr>
				<td colspan="2" ><input type="submit" class="btn btn-success"  value="Add ToDo" /></td>
			</tr>
		</table>
		</form>
	</div>
	<script>
		function updateValue() {
            var dateInputValue = document.getElementById('dateInput').value;
            document.getElementById('targetDateId').value = dateInputValue;
        } 
    </script>
	<script src="/webjars/jquery/3.6.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
	</body>
</html>