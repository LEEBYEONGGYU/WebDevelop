<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewpart" content="width=device-width,initial-scale=1.0"/>
<title>Insert title here</title>
</head>
<body>
	<h2>주석 예제</h2>
	<%
	//자바 주석임
	//문자열 변수 선언 및 초기화 할당함
	String str1 = "소스보기를 하면 화면에 표시됨";
	String str2 = "소스보기를 해도 화면에 안보임";
	%>
	
	<!-- HTML주석이다<%=str1%>-->
	<%--JSP주석임<%=str2%> --%>
</body>
</html>