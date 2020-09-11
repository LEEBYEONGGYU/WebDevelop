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
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("userid");
	String upw = request.getParameter("userpw");
	
	String userid = "normalUser";
	String userpw = "1234";
	
	String userid2 = "hardWorker";
	String userpw2 = "abcd";
	      	
	try {
		if(uid.equals(userid) && upw.equals(userpw)){
			session.setAttribute("id", uid);
  			out.println("<script type='text/javascript'>alert('로그인 완료');</script>");
  			response.sendRedirect("settingForm.jsp");
		if(uid.equals(userid2) && upw.equals(userpw2)){
			session.setAttribute("id", uid);
	  		out.println("<script type='text/javascript'>alert('로그인 완료');</script>");
	  		response.sendRedirect("settingForm.jsp");
			}else{
				//두번째 if문에 대한 else
				out.println(
				"<script type='text/javascript'>alert('아이디와 비밀번호가 틀렸습니다.'); location.href=('loginForm.jsp'); </script>");
			} 
		}else{
			//첫번째 if문에 대한 else
			out.println(
			"<script type='text/javascript'>alert('아이디와 비밀번호가 틀렸습니다.'); location.href=('loginForm.jsp'); </script>");
		}
  	} catch (Exception e){
  		//모두 틀렸을 때 
  		out.println(
				"<script type='text/javascript'>alert('아이디와 비밀번호가 틀렸습니다.'); location.href=('loginForm.jsp'); </script>");
  	}
    %>
</body>
</html>