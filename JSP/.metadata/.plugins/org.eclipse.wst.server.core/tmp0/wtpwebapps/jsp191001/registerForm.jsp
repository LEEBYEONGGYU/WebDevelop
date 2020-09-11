<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="registerPro.jsp">
		<table>
			<tr>
				<td><label for="idt">아이디</label></td>
				<td><input type="text" id="idt" name="idt" size="20" maxlength="30" placehoder="df" autofocus required></td>
			</tr>
			<tr>
				<td><label for="passwd">비밀번호</label></td>
				<td><input type="password" id="passwd" name="passwd" size="20" placeholder="비밀번호" /></td>
			</tr>
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" id="name" name="name" size="20" placeholder="이름" /></td>
			</tr>
			<td><input type="submit" value="회원가입"></td>
		</table>
	</form>
</body>
</html>