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
    int age = Integer.parseInt(request.getParameter("age"));
    if (age < 20){
    	
    	out.println("<script>alert('20세미만 입장불가'); history.back();</script>");
	} else  {
		   request.setAttribute("name", "user");
		   RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");
		   dispatcher.forward(request, response);
		  }

	%>
</body>
</html>