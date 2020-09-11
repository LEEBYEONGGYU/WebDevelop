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
<h3>jstl CORE 태그 예제 - set, out, remove</h3>
<p>브라우저 변수값 설정</p>
<c:set var="browser" value="${header['User-Agent']}" /><br />
<c:out value="${browser} }" />

<p>browser변수값 제거 후</p>
<c:remove var="browser" />
<c:out value="${browser}" />
</body>
</html>