<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="myvar" value="MyString,Value1,Value2"/>
Length of ${ myvar } is ${ fn:length(myvar) }<br>
Uppercase of ${ myvar } is ${ fn:toUpperCase(myvar) }<br>
Starts with "MyS"? ${ fn:startsWith(myvar,"MyS") }
<c:set var="splitted" value="${fn:split(myvar,',') }"/>
Splitted Data: <c:forEach var="data" items="${splitted }">
<li>${data }</li>
</c:forEach>
<c:set var="joined" value="${ fn:join(splitted,'*') }"/>
Joined: ${ joined }
</body>
</html>