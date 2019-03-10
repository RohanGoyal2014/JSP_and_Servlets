<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>
<form method="get" action="StudentControllerServlet">
<input type="hidden" value="add" name="command"/>
<input type="text" name="firstName" placeholder="first name" />
<input type="text" name="lastName" placeholder="last name"/>
<input type="text" name="email" placeholder="email"/>
<input type="submit"/>
</form>
</body>
</html>