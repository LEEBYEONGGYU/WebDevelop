<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String uid="";
try{
	uid = (String)session.getAttribute("uid");
	if(uid == null || uid.equals("")){
%>
<form method="post" action="sessionLoginPro.jsp">
	<table>
		<tr>
			<td class="label"><label for="id">아이디</label>
			<td class="content"><input type="text" id="uid" name="uid" size="20" maxlength="50" placeholder="아이디를 입력해" autofocus required />
			
		</tr>
		<tr>
			<td class="label"><label for="passwd">비밀번호</label></td>
			<td class="content"><input id="passwd" name="passwd" type="password" size="20" placeholder="6~16자 입력" required /></td>
		</tr>
		<tr>
			<td class="label2" colspan="2"><input type="submit" value="로그인"></td>
			<td><input type="reset" value="다시작성" /></td>
		</tr>
	</table>
</form>

<% }else{ %>

<b><%=uid%></b>님이 로그인하셨습니다
<form method="post" action="sessionLogout.jsp">
	<input type="submit" value="로그아웃" />
</form>
<%
}
}catch(Exception e){
	e.printStackTrace();
}
%>
</body>
</html>