<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
	<form action="setting.jsp" method="post">
		<span>이름</span><input type="text" name="uname" placeholder="이름" requried />
		<span>캐릭터</span>
		<input type="radio" name="chra" value="boy"/><img src="imgs/boy.png" alt="boy" name="boy" />
		<input type="radio" name="chra" value="girl"/><img src="imgs/girl.png" alt="girl" name="girl" />
		<input type="submit" value="확인" />
		</form>
	</section>
</body>
</html>