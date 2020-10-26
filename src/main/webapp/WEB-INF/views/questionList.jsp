<%@taglib prefix="qu" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="dateformat" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path=application.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question List</title>
</head>
<body>
<p>Question : ${question.questionText}</p>
<h2>Question Likes: ${questionLikes}</h2>
  <qu:choose>
     <qu:when test="${answers!=null}">
     <h3>Answers :</h3>
     <qu:forEach items="${answers}" var="ans">
     <p>Answer Text: ${ans.answerText}</p>
     <p>Answer Likes : ${ans.answerLikes.size()} </p>
     <hr>
     <qu:choose>
    <qu:when test="${ans.comment!=null}">
    <h3>Comments :</h3>
     <qu:forEach items="${ans.comment}" var="comment">
     <p>Comment Text: ${comment.commentText} 	<dateformat:formatDate value="${comment.postedOn}" pattern="dd - MMM - yyyy"></dateformat:formatDate>
									
     							</p>
     </qu:forEach>
     <hr>
    </qu:when>
     <qu:when test="${ans.comment==null}">
    <p>No Comments</p>
     </qu:when>
    </qu:choose>
     </qu:forEach>
     </qu:when>
     <qu:otherwise>
     No Answers
     </qu:otherwise>
     </qu:choose>
  <h1>Company Name : ${companyName}</h1>
<h1>Topic: ${question.subtopic.topic.topicName}</h1>


</body>
</html>