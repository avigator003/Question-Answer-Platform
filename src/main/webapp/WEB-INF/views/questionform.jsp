<%@taglib prefix="qu" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path=application.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Form</title>
</head>
<body>
<form method="get" action="<%=path%>/global/questions">
<input type="text" placeholder="Enter Question Id" name="questionId">
<input type="submit">
</form>



</body>
</html>