<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1. 첫번째는 아이디, 비밀번호, 전화번호를 입력 
	 2. 두번째는 체크박스로 관심사나 약관 동의
	 3. 마지막 체크하고 가입시켜버리기
	 
	 세션과 리다이렉트 사용하기	-->
	 <% if(session.getAttribute("id")==null){ //세션이 설정되지 않을 경우 %>
	 <form method="post" action="membertwo.jsp">
	 	<fieldset>
	 	<legend><h2>회원가입</h2></legend>
	 	<dl>
	 		<dd>
	 			<label for="id">아이디</label>
	 			<input type="text" name="id" id="id" placeholder="아이디" required />
	 		</dd>
	 	</dl>
	 	<dl>
	 		<dd>
	 			<label for="pw">비밀번호</label>
	 			<input type="text" name="pw" id="id" placeholder="아이디" required />
	 		</dd>
	 	</dl>
	 	<dl>
	 		<dd>
	 			<label for="phone">전화번호</label>
	 			<select name="phone">
	 				<option value="010">010</option>
	 				<option value="011">011</option>
	 				<option value="016">016</option>
	 			</select>
	 			-<input type="text" name="phone2" id="phone2" placeholder="전화번호" requried />-<input type="text" name="phone3" id="phone3" placeholder="전화번호" requried />
	 		</dd>
	 	</dl>
	 	<dl>
	 		<dd>
	 	<input type="submit" value="다음단계로"> <input type="reset" value="다시쓰기" />
	 	</dd></dl>
	 	</fieldset>
	 </form>
	 <% }else{ %>
<form method="post" action="reset.jsp">
	<%=session.getAttribute("id") %>님 환영합니다~
	<input type="submit" value="로그아웃" />
</form>
<% } %>

</body>
</html>