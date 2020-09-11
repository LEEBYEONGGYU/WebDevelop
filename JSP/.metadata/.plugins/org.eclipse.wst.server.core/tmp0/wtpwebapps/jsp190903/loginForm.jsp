<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
</script>
</head>
<body>
<fieldset>
	<form action="testLogin.jsp" method="post">
		<legend>로그인</legend>
		ID <input type="text" placeholder="아이디 " name="userid" /> <br />
		PW <input type="password" placeholder="비밀번호" name="upw" /> <br />
		<input type="submit" value="로그인" onclick="loginbt();" id="umit"/>
	</form>
</fieldset>
</body>
</html>