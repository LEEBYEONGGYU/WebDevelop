<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>식당</h1>
	<ul>
		<li><a href="index.do">Home</a></li>
		<li><a href="menu.do">Menu</a></li>
	</ul>
	<c:if test="${not empty requestScope.page}">
		<c:import url="${requestScope.page }" />
	</c:if>
	<c:if test="${empty requestScope.page}">
		<p>Error</p>
	</c:if>
	
	<footer>footer</footer>
</body>
</html>