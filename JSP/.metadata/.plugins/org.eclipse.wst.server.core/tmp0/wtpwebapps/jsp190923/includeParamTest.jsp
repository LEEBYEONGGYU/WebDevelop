<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8");
	
	String name = "���̿�����";
	String pageName = "includedParamTest.jsp";
	
	%>
	�����ϴ� ������ includeParamTest.jsp�Դϴ�<br />
	���ԵǴ� �������� �Ķ���� ���� �����մϴ�<br />
	<hr>
	<jsp:include page="<%=pageName %>" flush="false" >
		<jsp:param name="name" value="<%=name %>" />
		<jsp:param name="pageName" value="<%=pageName %>" />
	</jsp:include>
	includeParamTest.jsp�� ������ �����Դϴ�.
</body>
</html>