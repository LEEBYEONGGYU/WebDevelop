<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"
	session="true"
	buffer="8kb"
	autoFlush="true"
	isThreadSafe="true"%>
    <%@ page import="java.sql.Timestamp" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page디렉티브2</title>
</head>
<body>
<%
	Timestamp now = new Timestamp(System.currentTimeMillis());
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String strDate = format.format(now);
	%>
	
	오늘은 <%=strDate %>입니다
</body>
</html>