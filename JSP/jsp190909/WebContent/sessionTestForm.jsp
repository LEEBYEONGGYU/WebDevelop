<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("id")==null){ //세션이 설정되지 않을 경우 %>
<form method="post" action="sessionTest.jsp">
	<div id="unauth">
		<labele for="id">아이디</labele>
		<input id="id" name="id" text="text" placehoder="아이디" autofocus required>
		<label for="pass">비밀번호</label>
		<input id="pass" name="pass" type="password" placehoder="1234" placeholder="비밀번호" required>
		<input type="submit" value="로그인" />
	</div>
</form>
<% }else{ %>
<form method="post" action="logout.jsp">
	<%=session.getAttribute("id") %>님 환영합니다~
	<input type="submit" value="로그아웃" />
</form>
<% } %>
</body>
</html>