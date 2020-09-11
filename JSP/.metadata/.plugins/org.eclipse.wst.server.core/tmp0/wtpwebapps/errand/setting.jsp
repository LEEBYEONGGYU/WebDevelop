<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("uname");
String ch = request.getParameter("chra");

session.setAttribute("uname",name);
session.setAttribute("uimg",ch);

out.println("당신의 이름은"+session.getAttribute("uname"));
out.println("당신의 캐릭터는"+session.getAttribute("uimg"));
response.sendRedirect("main.jsp");
%>
</body>
</html>