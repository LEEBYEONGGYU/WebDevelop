<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
설문조사 결과 <br>
<%
	String name = request.getParameter("name");
	out.print("이름은"+name+"<br>");
	String gender = request.getParameter("gender");
	if(gender=="girl"){
		gender = "여자";
	}else{
		gender ="남자";
	}
	out.print("성별은"+gender+"<br>");
	String seasonArr[] = request.getParameterValues("season");
	String seasonName[] = {"봄","여름","가을","겨울"};
	if(seasonArr == null)
		out.println("선택한 계절이 없습니다");
	else{
		out.println("당신이 선택한 계절은");
		for(String s:seasonArr){
			out.println(seasonName[Integer.parseInt(s)]+" ");
		}
		out.println("입니다");
	}
%>
</body>
</html>