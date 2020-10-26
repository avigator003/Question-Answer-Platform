<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Give Comments</title>
</head>
<body>

</body><%@taglib prefix="qu" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path=application.getContextPath();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Give Comments</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<form action="<%=path%>/global/comments" method="POST">
<qu:forEach items="${questions}" var="question"> 

     <h1>Question : ${question.questionText}</h1>
     <qu:choose>
     <qu:when test="${question.answer!=null}">
     <h3>Answers :</h3>
     <qu:forEach items="${question.answer}" var="ans">
     <p>${ans.answerText} <input type="button" class="ansId"  data-id="${ans.answerId}" value="Like Answer"></p>
     <input type="hidden" value="${ans.answerId}" name="ansId" id="ansId">
    <br>
    <br>
     <label>Give Comments</label>
     <textarea maxLength="500" minLength="50" placeholder="Enter Your Comment" name="commentText" requried></textarea>
     <input type="submit" class="submit" data-id="${ans.answerId}" value="Post Comment">
     </qu:forEach>
     </qu:when>
     <qu:otherwise>
     No Answers
     </qu:otherwise>
     </qu:choose>
  

</qu:forEach>
</form>
<script>
$(document).ready(function()
		{
				$(".submit").click(function(){
				console.log("YYY");
				var ansId = $(this).data('id');
				$("#ansId").val(ansId);
                console.log(ansId);
			});

		});
		

</script>
</body>
</html>
</html>