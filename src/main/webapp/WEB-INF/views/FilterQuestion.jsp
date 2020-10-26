<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="qu" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
String path=application.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="<%=path%>/global/filterquestions">
Select Company :
<select name="company">
<option value="" selected>Others</option>
<hr>
<qu:forEach items="${company}" var="name"> 
 <option value="${name.companyId}">${name.companyName}</option>
</qu:forEach>
</select>
<br>
<br>
Select SubTopic
<select name="subtopic" id="subtopic">
<option value=" " selected>Others</option>
<hr>
<qu:forEach items="${subTopic}" var="name"> 
 <option value="${name.subtopicId}">${name.subtopicName}</option>
</qu:forEach>
</select>

<br>
<br>
<input type="number" placeholder="Number Of Likes" name="likes">

<br>
<br>

<br>
<br>
<input type="text" name="tags">

<br>
<br>

<input type="submit" value="Get Question">
</form>

</body>
</html>