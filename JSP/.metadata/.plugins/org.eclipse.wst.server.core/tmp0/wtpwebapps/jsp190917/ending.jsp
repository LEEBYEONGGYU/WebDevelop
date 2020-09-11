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
if(session.getAttribute("true").equals("true")){
	out.println(session.getAttribute("uname")+"! 정말 잘했어. 그럼 부탁할게!");
}else{
	out.println(session.getAttribute("uname")+"! 아직은 좀 더 연습이 필요한 것 같구나. 엄마랑 같이 가자!");
}
%>
</body>
</html>