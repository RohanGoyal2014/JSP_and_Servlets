<html>
<body>
<h1>Response</h1><br>
 ${param.lastName}
 <% String[] cbs= request.getParameterValues("cb");
 out.println("<ul>");
 for(int i=0;i<cbs.length;++i) {
	 out.println("<li>"+cbs[i]+"</li>");
 } 
 out.println("</ul>");
 %>
</body>
</html>