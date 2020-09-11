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

String selme3 = request.getParameter("sel3");
String chkss[] = request.getParameterValues("sel3");

int i=0;
	for(String val : chkss){
		session.setAttribute("chk"+i,val);
		i++;
		
	}
%>
자, 지금까지 뭘 골랐는지 한 번 체크 해 봐<br>
<form action="sceneTest.jsp" method="post">
	<input type="radio" name="sel5" value="두부" />두부
	<input type="radio" name="sel5" value="순두부" />순두부
	<input type="radio" name="sel6" value="초코우유" />초코우유
	<input type="radio" name="sel6" value="바나나우유" />바나나 우유
	
	<input type="checkbox" name="chkk" value="돼지고기" />돼지고기
	<input type="checkbox" name="chkk" value="닭고기" />닭고기
	<input type="checkbox" name="chkk" value="소고기" />소고기
	<input type="checkbox" name="chkk" value="오리고기" />오리고기
	
	<img src="imgs/<%=session.getAttribute("uimg") %>.png" />
		<a href="scene1.jsp"><button type="submit">다음</button></a>
</form>
</body>
</html>