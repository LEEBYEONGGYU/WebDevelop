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
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String phone = request.getParameter("phone");
String phone2 = request.getParameter("phone2");
String phone3 = request.getParameter("phone3");
String pnum = phone+'-'+phone2+'-'+phone3;

session.setAttribute("id",id);
session.setAttribute("pw",pw);
session.setAttribute("pnum",pnum);

%>

<form method="post" action="membercheck.jsp">

	 	<fieldset>
	 	<legend><h2>회원가입</h2></legend>
	 	<dl>
	 		<dd>
	 			<label for="id">관심사</label>
	 			<input type="checkbox" name="hobby" id="hobby" value="축구"  />축구 
	 			<input type="checkbox" name="hobby" id="hobby" value="족구"  />족구 
	 			<input type="checkbox" name="hobby" id="hobby" value="자전거" />자전거
	 			<input type="checkbox" name="hobby" id="hobby" value="달리기" />달리기
	 		</dd>
	 	</dl>
	 	<dl>
	 		<dd>
	 			이용약관
	 			<textarea>당신은 개인정보 제공에 동의하십니까</textarea>
	 			<input type="radio" name="agr" id="agr" value="예">예<input type="radio" name="agr" id="agr" value="아니오">아니오
	 		</dd>
	 	</dl>
	 	<dl>
	 		<dd>
	 	<input type="submit" value="확인"> <input type="reset" value="다시쓰기" />
	 	</dd></dl>
	 	</fieldset>
	 </form>
</body>
</html>