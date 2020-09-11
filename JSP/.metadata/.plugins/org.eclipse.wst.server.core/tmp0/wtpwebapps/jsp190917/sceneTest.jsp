<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%
request.setCharacterEncoding("utf-8");
String sel5 = request.getParameter("sel5");
String sel6 = request.getParameter("sel6");
String[] chkk = request.getParameterValues("chkk");
//String[] chkk = (String[])session.getAttribute("chk");
int i=0;
int cnt=0;
if(session.getAttribute("sel").equals(sel5)){
	cnt++;
}

if(session.getAttribute("sel2").equals(sel6)){
	cnt++;
}
for( i=0; i<chkk.length; i++){
	if(session.getAttribute("chk").equals(chkk[i])){
		cnt++;
	}else{
	}
}
out.println(cnt);

if(cnt==3){
	String tr = "true";
	session.setAttribute("true",tr);
	out.println("true");
	//response.sendRedirect("ending.jsp");
}else{
	String tr = "false";
	session.setAttribute("false",tr);
	out.println("false");
	//response.sendRedirect("ending.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>