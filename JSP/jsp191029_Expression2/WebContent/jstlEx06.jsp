<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:requestEncoding value="utf-8" />
		<h3>JSTL fmt 태그 예제 - requestEncoding</h3>
			<p>파라메터 : <c:out value="${param.name }" /></p>
			<form action="jstlEx06.jsp" method="post">
				<ul>
					<li><label for="name">이름</label></li>
					<input type="text" id="name" name="name" />
					<input type="submit" value="확인" />
				</ul>
			</form>
</body>
</html>