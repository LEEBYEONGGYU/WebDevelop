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
	
	String name = "제이에스피";
	String pageName = "includedParamTest.jsp";
	
	%>
	포함하는 페이지 includeParamTest.jsp입니다<br />
	포함되는 페이지에 파라미터 값을 전달합니다<br />
	<hr>
	<jsp:include page="<%=pageName %>" flush="false" >
		<jsp:param name="name" value="<%=name %>" />
		<jsp:param name="pageName" value="<%=pageName %>" />
	</jsp:include>
	includeParamTest.jsp의 나머지 내용입니다.
</body>
</html>