<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	String id = "admin";
	String upw = "1234";
	
	
	if(id.equals(request.getParameter("userid"))&&upw.equals(request.getParameter("upw"))){
		response.sendRedirect("main.jsp?id="+URLEncoder.encode(id, "UTF-8"));
	}else{
		out.println("<script>alert('로그인정보가 틀렸지롱~');</script>");
			response.sendRedirect("loginForm.jsp");
	}
		
	%>
	
	
</body>
</html>