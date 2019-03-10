<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="button" value="Add Student" onclick="window.location.href='add-student-form.jsp';return false;"/>
<table>
<c:forEach var="tmp" items="${ STUDENT_LIST }">
	<c:url var="tmpLink" value="StudentControllerServlet">
	<c:param name="command" value="load"></c:param>
	<c:param name="id" value="${ tmp.id }"></c:param>
	</c:url>
	<c:url var="deleteLink" value="StudentControllerServlet">
	<c:param name="command" value="delete"></c:param>
	<c:param name="id" value="${ tmp.id }"></c:param>
	</c:url>
<tr>
<td>${ tmp.firstName }</td>
<td>${ tmp.lastName }</td>
<td>${ tmp.email }</td>
<td><a href="${tmpLink }">Update</a></td>
<td><a href="${deleteLink }" onclick="if(!confirm('Do you want to delete this?'))return false;">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>