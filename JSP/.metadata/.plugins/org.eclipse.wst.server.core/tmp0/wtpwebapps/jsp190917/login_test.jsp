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
          	
	try {
  		if(uid.equals(userid)){
  			if(upw.equals(userpw)){
  				session.setAttribute("id", uid);
      			out.println("<script type='text/javascript'>alert('로그인 완료');</script>");
      			response.sendRedirect("settingForm.jsp");
  			}else{
  				out.println(
      					"<script type='text/javascript'>alert('비밀번호가 틀렸습니다.'); location.href=('login_form.jsp'); </script>");
  			}
  		}else{
  			out.println(
  					"<script type='text/javascript'>alert('아이디가 틀렸습니다.'); location.href=('login_form.jsp'); </script>");
  		}
  	} catch (Exception e){
  		out.println(
					"<script type='text/javascript'>alert('아이디와 비밀번호가 틀렸습니다.'); location.href=('index.jsp'); </script>");
  	}
    %>
</body>
</html>