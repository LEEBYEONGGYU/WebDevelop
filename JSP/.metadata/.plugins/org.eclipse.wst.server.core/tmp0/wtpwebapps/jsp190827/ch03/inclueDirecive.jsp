<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="color.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include디렉티브</title>
</head>
<body bgcolor="<%=bodyback_c%>">
	<form action="">
		<dl>
			<dd>
				<label for="id">아이디</label>
				<input id="id" type="email" placeholder="example@aaaa.com" required>
			</dd>
			<dd>
				<label for="pass">비밀번호</label>
				<input id="pass" type="password" placeholder="비밀번호" required">
			</dd>
			<dd>
				<label for="pass">이름</label>
				<input id="name" type="text" placeholder="이름" required">
			</dd>
			<dd>
				<input type="submit" value="등록"> <input type="reset" value="다시쓰기">
			</dd>
		</dl>
	</form>
	<div style="background:<%=back_c%>; width:500px; height:100px;">back_c</div>
	<div style="background:<%=title_c%>; width:500px; height:100px;">title_c</div>
	<div style="background:<%=value_c%>; width:500px; height:100px;">value_c</div>
	<div style="background:<%=bar%>; width:500px; height:100px;">bar</div>
	
</body>
</html>