<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="header.jsp"%>
<form action="loginTest.jsp" method="post">
	<div id="login">
		<ul id="lo_form">
			<li id="lo_id">아이디 <input type="text" name="userid" placeholder="아이디" required /></li>
			<li id="lo_pw">비밀번호 <input type="password" name="userpw" placeholder="비밀번호" required /></li>
			<li><input type="submit" value="로그인"  id="lo_bt"/></li>
		</ul>
	</div>
</form>
</body>
</html>