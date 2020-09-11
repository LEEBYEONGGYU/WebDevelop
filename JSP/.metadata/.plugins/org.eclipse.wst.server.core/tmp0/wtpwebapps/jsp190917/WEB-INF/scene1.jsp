<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
다음 둘 중에 마음에 드는 것으로 하나만<br>
선택해서 사야 해!<br>

<form action="" method="post">
	<input type="radio" name="sel" value="두부" />두부
	<input type="radio" name="sel" value="순두부" />순두부
	
	<img src="imgs/<%=session.getAttribute("uimg") %>.png" />
		<a href="scene1.jsp"><button type="submit">다음</button></a>
</form>
</body>
</html>