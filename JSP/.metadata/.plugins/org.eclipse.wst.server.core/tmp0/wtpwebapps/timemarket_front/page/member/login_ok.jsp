<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${check==1 }">
<c:set var="userid" value="${id}" scope="session" />

	<script>alert("로그인 되어습니다.");</script>
	<c:redirect url="/index.jsp" context="/timemarket_front" />
</c:if>

<c:if test="${check==0 }">
	<script>alert("아이디 및 비밀번호를 확인해주세요."); history.back();</script>
</c:if>