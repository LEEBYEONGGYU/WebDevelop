<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! 
    String str="안녕하세요";
    int num=5;
    public int square(int n) {return n*n; }%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.print(str+"<br>");
	out.print(num+"의 제곱="+ square(num));%>
</body>
</html>