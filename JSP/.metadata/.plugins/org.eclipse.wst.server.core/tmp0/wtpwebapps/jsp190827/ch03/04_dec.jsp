<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! int globalNum = 5; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int localNum=5;
globalNum++;
localNum++;
	out.print(globalNum+"<br>");
	out.print(localNum+"<br>");
	
	
%>
</body>
</html>