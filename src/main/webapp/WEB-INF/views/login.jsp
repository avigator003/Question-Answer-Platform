<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String path=application.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=path%>/global/login">
<input type="text" placeholder="Enter Username" name="userName"/>
<input type="submit" value="login"> 
</form>
</body>
</html>