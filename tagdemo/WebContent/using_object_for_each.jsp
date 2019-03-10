<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,datapack.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	List<Student> arr=new ArrayList<>();
	arr.add(new Student("Rohan",true));
	arr.add(new Student("Hmmm",false));
	
	pageContext.setAttribute("students",arr);
%>
<table>
<c:forEach var="stu" items="${ students }">
	<tr>
		<td>${ stu.firstName }</td>
		<td>
		<c:if test="${ stu.isGood }">
			Good Student
		</c:if>
		<c:if test="${ not stu.isGood }">
			Bad Student
		</c:if>
		</td>
		<td>
		<c:choose>
			<c:when test="${ stu.isGood }">
			Aaye
			</c:when>
			<c:otherwise>
			Huh
			</c:otherwise>
		</c:choose>
	
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>