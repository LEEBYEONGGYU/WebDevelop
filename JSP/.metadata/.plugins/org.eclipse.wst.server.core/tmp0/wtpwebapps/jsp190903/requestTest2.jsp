<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewpart" content="width=device-width,inital-scale-1.0" />

<title>Insert title here</title>
</head>
<body>

<%
	String names[] = {"프로토콜이름","서버이름","Method방식","컨텍스트 경로","URL","접속한 클라이언트의 IP"};
	String values[] = {request.getProtocol(),
			request.getServerName(),request.getMethod(),
			request.getContextPath(),request.getRequestURI(),
			request.getRemoteAddr()};
	
	Enumeration<String> en = request.getHeaderNames();
	String headerName ="";
	String headerValue ="";
%>

<h2>웹 브라우저와 웹 서버 정보 표시</h2>
<%
	for(int i=0; i<names.length;i++){
		out.println(names[i] + " : "+values[i]+"<br>");
	}
%>

<h2>헤더의 정보 표시</h2>
<%
	while(en.hasMoreElements()){
		headerName = en.nextElement();
		headerValue = request.getHeader(headerName);
		out.println(headerName + " : " + headerValue+"<br>");
	}
%>
</body>
</html>