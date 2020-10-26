<%@taglib prefix="qu" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path=application.getContextPath();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Give Answers</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<form action="<%=path%>/global/answers" method="POST">
<qu:forEach items="${questions}" var="question"> 

     <input type="hidden" value="${question.questionId}" name="quesId" id="quesId">
     
     <h1>Question ${question.questionId} </h1><p>${question.questionText}</p>
     <input type="button" class="like" data-id="${question.questionId}" value="Like Question">
     <br>
     <br>
     <qu:choose>
     <qu:when test="${question.answer!=null}">
     <h3>Answers :</h3>
     <qu:forEach items="${question.answer}" var="ans">
     <p>${ans.answerText}</p>
     <input type="button" class="ansId"  data-id="${ans.answerId}" value="Like Answer">
     </qu:forEach>
     </qu:when>
     <qu:otherwise>
     No Answers
     </qu:otherwise>
     </qu:choose>
     <br>
     <br>
     <label>Give Answer</label>
     <textarea maxLength="500" minLength="50" placeholder="Enter Your Answer" name="answerText" requried></textarea>
<br>
<br>

<input type="submit" class="submit" data-id="${question.questionId}" value="post Answer">
</qu:forEach>
</form>
<script>
$(document).ready(function()
		{
				$(".submit").click(function(){
				console.log("YYY");
				var quesId = $(this).data('id');
				$("#quesId").val(quesId);
                console.log(quesId);
			});

				$(".like").click(function(){
                    var likesId = $(this).data('id');

					console.log(likesId);
					$.post("${path}/global/questionlikes",{likesId:likesId}, function(data, status){});
					console.log("YYY");

				});

				$(".ansId").click(function(){
                    var likesId = $(this).data('id');
            	$.post("${path}/global/answerlikes",{likesId:likesId}, function(data, status){});
					console.log("YYY");

				});
					

		});
		

</script>
</body>
</html>