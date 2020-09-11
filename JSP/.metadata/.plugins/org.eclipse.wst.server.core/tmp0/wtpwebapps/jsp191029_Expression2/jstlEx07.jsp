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
	<h3>JSTL fmt태그예제 -bundle, message</h3>
	<%--<fmt:setLocale value="en" /> --%>
	<fmt:bundle basename="bundle.testBundle">
		<fmt:message key="name" />
		<fmt:message key="message" var="msg" />
		<p><c:out value="${msg }" /></p>
	</fmt:bundle>
</body>
</html>