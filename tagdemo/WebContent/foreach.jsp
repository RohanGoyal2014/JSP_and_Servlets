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
<% String[] cities={"New Delhi","Mumbai","Bengaluru"};
	pageContext.setAttribute("mycities", cities);
%>
<c:forEach var="city" items="${ mycities }">
<li>${ city }</li>
</c:forEach>
</body>
</html>