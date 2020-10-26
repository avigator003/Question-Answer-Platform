<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="qu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Question FIltered List</h1>
<qu:set var="i" value="0">
</qu:set>
<qu:forEach items="${questions}" var="qu">
<p>Question Id :${qu.questionId}</p>
<p>Question Text : ${qu.questionText}</p>
<p>Question Company :${qu.company.companyName}</p>
<p>Question Likes: ${qu.likes}</p>
<p> Max Likes Answer :${answerMax[i].answerText}</p>
<qu:set value="${i+1}" var="i">
</qu:set>
</qu:forEach>



</body>
</html>