<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><p>표현식 = 값</p></li>
		<li><p>\${2+5} = ${2+5}</p></li>
		<li><p>\${4/5} = ${4/5}</p></li>
		<li><p>\${7 mod 5} = ${7 mod 5}</p></li>
		<li><p>\${2<3} = ${2<5}</p></li>
		<li><p>\${3.1 le 3.2} = ${3.1 le 3.2}</p></li>
		<li><p>\${(5>3) ? 5:3} = ${(5>3) ? 5:3}</p></li>
	</ul>
</body>
</html>