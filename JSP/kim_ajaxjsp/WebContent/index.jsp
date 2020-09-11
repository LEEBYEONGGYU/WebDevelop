<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@page import="org.json.simple.*"%>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
 String myData = request.getParameter("myData");

 String callback = request.getParameter("callback");

 JSONObject jsonObject = new JSONObject();
 jsonObject.put("result", myData);

 out.println(callback + "(");
 out.println(jsonObject);
 out.println(")");
%>