<%@ page import="java.util.*" %>
<html>
<body>
<form action="">
<input type="text" name="task">
<input type="submit">
</form>
<%
	String task=request.getParameter("task");
	List<String> taskList=(List<String>)session.getAttribute("taskAttr");
	
	if(taskList==null) {
		taskList=new ArrayList<String>();
		session.setAttribute("taskAttr",taskList);
	}
	if(task!=null) {
		taskList.add(task);
	}
	
	for(int i=0;i<taskList.size();++i) {
		out.println("<li>"+taskList.get(i)+"</li>");
	}
%>
</body>

</html>