<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <% request.setCharacterEncoding("utf-8"); %>
 <%
 	String resultStr = "처리결과 : <br />";
 	String name = request.getParameter("name");
 	String stus = request.getParameter("stus");
 	
 	String uid = "admin";
 	
 	if(uid.equals(name)){
 		resultStr+="아이디는 "+name+"이고,<br>";
 		resultStr+="아이디가 중복됨<br />";
 	 	resultStr+="현재상태는"+stus;
 	}else{
 		resultStr+="아이디는 "+name+"이고,<br>";
 		resultStr+="사용가능한 아이디<br />";
 	 	resultStr+="현재상태는"+stus;
 	}
 	
 	out.println(resultStr);
 %>