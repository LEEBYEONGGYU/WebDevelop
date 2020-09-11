<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="">
		<%
			out.println(session.getAttribute("uname")+"!");
		%>
		오늘은 엄마 심부름 좀 해 주겠니?<br>
		몇 가지 장을 봐야 하니<br>
		잘 기억해<br>
		
		<img src="imgs/<%=session.getAttribute("uimg") %>.png" />
		<a href="scene1.jsp"><button type="button">다음</button></a>
	</div>
</body>
</html>