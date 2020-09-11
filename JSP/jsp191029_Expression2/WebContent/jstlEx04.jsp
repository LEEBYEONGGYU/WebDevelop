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
	<h3>JSTL core 태그 예ㅔ -forTokens</h3>
		<c:forTokens var="tech" items="금강불괴, 허공답보, 열양기공, 천마군림보" delims=",">
			<p>익혀야할 기술 : <c:out value="${tech}" /></p>
		</c:forTokens>
</body>
</html>