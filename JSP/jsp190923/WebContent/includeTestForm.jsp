<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="includeTest.jsp">
	<dl>
		<dd>
			<label for="name">�̸�</label>
			<input id="name" name="name" type="text" placeholder="�谳��" autofocus required />
		</dd>
		<dd>
			<label for="pagename">������������</label>
			<input id="pagename" name="pageName" type="text" value="includedTest.jsp" required />
		</dd>
		<dd>
			<input type="submit" value="����" />
		</dd>
	</dl>
</form>
</body>
</html>