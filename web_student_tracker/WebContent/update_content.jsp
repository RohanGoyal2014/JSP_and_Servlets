<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="StudentControllerServlet" method="GET">
	<input type="hidden" name="command" value="update"/>
	<input type="hidden" name="id" value="${student.id }"/>
	<input type="text" name="firstName" value="${ student.firstName }"/>
	<input type="text" name="lastName" value="${student.lastName }"/>
	<input type="email" name="email" value="${student.email }"/>
	<input type="submit"/>
	</form> 
</body>
</html>