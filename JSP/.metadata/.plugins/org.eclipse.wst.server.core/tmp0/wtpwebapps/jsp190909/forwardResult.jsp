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
	String age = request.getParameter("age");
	String name = (String)request.getParameter("name");
	
	%>
	forword방식으로 이동된 페이지<br />
	당신의 나이<%=age %>
	당신의 이름<%=name %>
</body>
</html>