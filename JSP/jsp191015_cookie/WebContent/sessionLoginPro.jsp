<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="logon.LogonDBBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% request.setCharacterEncoding("utf-8"); %>
<% 
	String uid = request.getParameter("uid");
	String passwd = request.getParameter("passwd");
	
	LogonDBBean logon = LogonDBBean.getInstance();
	int check = logon.userCheck(uid,passwd);
	
	if(check==1){
		session.setAttribute("uid",uid);
		response.sendRedirect("sessionLogin.jsp");
	}else if(check==0){%>
	
	<script>
		alert("비밀번호가 맞지 않습니다");
		history.go(-1);
	</script>
	<% }else{%>
	<script>
		alert("아이디가 맞지 않습니다");
		history.go(-1);
	</script>
	<% } %>
</body>
</html>