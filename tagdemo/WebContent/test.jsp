<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- c prefix denotes core -->
<html>
<body>
<c:set var="stuff" value="<%= new java.util.Date() %>"></c:set>
Time on Server is ${stuff }
</body>
</html>