<%@taglib prefix="qu" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path=application.getContextPath();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<form action="<%=path%>/global/questions" method="POST">
<label>Question</label>
<textarea maxLength="500" minLength="50" placeholder="Enter Your Question..." name="questionText" requried></textarea>
<br>
<br>
<label>Choose Subtopic </label>

<select name="subtopic" id="subtopic" required>
<qu:forEach items="${subTopic}" var="name"> 
 <option value="${name.subtopicId}">${name.subtopicName}</option>
</qu:forEach>
</select>
<br>
<br>
<label>Choose Company</label>

<select name="company">
  <option value="" selected> </option>
<qu:forEach items="${company}" var="name">
 <option value="${name.companyId}">${name.companyName}</option>
</qu:forEach>

</select>
<br>
<br>


<input type="submit"  value="post Question">
</form>

<script>
		
</script>
</body>
</html>