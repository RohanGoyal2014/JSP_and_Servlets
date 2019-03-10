<html>
<body>
Thank You. Your Language is ${param.lang}<hr>
<% Cookie cookie=new Cookie("myCookie",request.getParameter("lang"));
	cookie.setMaxAge(60*60*24*365);
	response.addCookie(cookie);
%>
<a href="preference_form.jsp">Go Back</a>
</body>
</html>