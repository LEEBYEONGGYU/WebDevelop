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
	Cookie cookie = new Cookie("id", "userid");
cookie.setMaxAge(60*5);
response.addCookie(cookie);

out.println("쿠키가 생성되었습니다");
%>

<form method="post" action="useCookie.jsp">
	<table>
		<tr>
			<td><input type="submit" value="생성된 쿠기 확인" /></td>
		</tr>
	</table>
</form>
</body>
</html>