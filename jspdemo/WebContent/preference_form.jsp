<html>
<body>
<% String favLang="Java";
Cookie[] cookies=request.getCookies();
	if(cookies!=null) {
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("myCookie")) {
				favLang=cookie.getValue();
				break;
			}
		}
	}
%>
Your fav Lang is:<%= favLang %>
<hr>
<h1>Enter preferences</h1>
<form action="preference_response.jsp">
<select name="lang">
<option value="java">Java</option>
<option value="c++">C++</option>
</select>
<input type="submit">
</form>
</body>
</html>