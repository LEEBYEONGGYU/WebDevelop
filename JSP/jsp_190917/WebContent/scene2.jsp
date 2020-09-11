<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String selme = request.getParameter("sel");

session.setAttribute("sel",selme);
%>
다음 둘 중에 마음에 드는 것으로 하나만<br>
선택해서 사야 해!<br>

<form action="scene3.jsp" method="post">
	<input type="radio" name="sel2" value="초코우유" />초코우유
	<input type="radio" name="sel2" value="바나나우유" />바나나 우유
	
	<img src="imgs/<%=session.getAttribute("uimg") %>.png" />
		<button type="submit">다음</button>
</form>
</body>
</html>