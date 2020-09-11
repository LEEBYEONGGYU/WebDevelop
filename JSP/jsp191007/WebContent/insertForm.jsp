<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="insertPro.jsp">
	<table>
		<tr>
			<td class="label"><label for="idt">아이디</label></td>
			<td class="cotent"><input type="text" id="idt" name="idt" size="20" maxlength="50" placeholder="example@kings.com" autofocus required></td>
		</tr>
		<tr>
			<td class="label"><label for="passwd">비밀번호</label></td>
			<td class="cotent"><input type="password" id="passwd" name="passwd" size="20" maxlength="16" placeholder="6~16자 숫자/문자" required></td>
		</tr>
		<tr>
			<td class="label"><label for="name">이름</label></td>
			<td class="cotent"><input type="text" id="name" name="name" size="20" maxlength="10" placeholder="킹도라" required></td>
		</tr>
		<tr>
			<td class="label"><label for="addr">주소</label></td>
			<td class="cotent"><input type="text" id="addr" name="addr" size="20" maxlength="100" placeholder="서울시" autofocus required></td>
		</tr>
		<tr>
			<td class="label"><label for="tel">전화번호</label></td>
			<td class="cotent"><input type="text" id="tel" name="tel" size="20" maxlength="20" placeholder="010-1111-1111" required></td>
		</tr>
		<tr>
			<td class="label2" colspan="2"><input type="submit" value="입력완료">
			<input type="reset" value="다시작성" /></td>
		</tr>
	</table>

</form>
</body>
</html>