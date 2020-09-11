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

String selme2 = request.getParameter("sel2");

session.setAttribute("sel2",selme2);
out.println("너가 선택한건"+session.getAttribute("sel2"));

%>
다음 둘 중에 마음에 드는 것을 모두 사 오렴<br>

<form action="scene4.jsp" method="post">
	<input type="checkbox" name="sel3" value="돼지고기" />돼지고기
	<input type="checkbox" name="sel3" value="닭고기" />닭고기
	<input type="checkbox" name="sel3" value="소고기" />소고기
	<input type="checkbox" name="sel3" value="오리고기" />오리고기
	<img src="imgs/<%=session.getAttribute("uimg") %>.png" />
		<button type="submit">다음</button>
</form>
</body>
</html>