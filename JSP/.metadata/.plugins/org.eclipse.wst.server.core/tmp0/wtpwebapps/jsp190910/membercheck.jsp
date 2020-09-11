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
request.setCharacterEncoding("UTF-8");
String hobby[] = request.getParameterValues("hobby");
String dong = request.getParameter("agr");%>

<form method="post" action="reset.jsp">
	 	<fieldset>
	 	<legend><h2>입력한 내용 확인</h2></legend>
	 	<dl>
	 		<dd>
	 			<label for="id">아이디 : </label>
	 			<span><%=session.getAttribute("id") %></span>
	 		</dd>
	 	</dl>
	 	<dl>
	 		<dd>
	 			<label for="pw">비밀번호 : </label>
	 			<span><%=session.getAttribute("pw")%></span>
	 		</dd>
	 	</dl>
	 	<dl>
	 		<dd>
	 			<label for="phone">전화번호 : </label>
	 			<span><%=session.getAttribute("pnum")%></span>
	 		</dd>
	 	</dl>
	 	
	 	<dl>
	 		<dd>
	 			<label for="id">관심사 : </label>
	 			<span><%
	 			if(hobby !=null){
	 				for(String val : hobby){
						out.println(val+", ");
					}
	 			}else{
	 				out.print("없음");
	 			}
					%></span>
	 		</dd>
	 	</dl>
	 	<dl>
	 		<dd>
	 			이용약관 동의 : 
	 			<span><%=dong %></span>
	 		</dd>
	 	</dl>
	 	<dl>
	 		<dd>
	 	<input type="submit" value="확인">
	 	</dd></dl>
	 	</fieldset>
	 </form>
</body>
</html>