<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="/include/db.jsp" %>
    <% 
    
    request.setCharacterEncoding("utf-8");
    String procode = request.getParameter("pcode");
    String pilsu = request.getParameter("pil");
    String oplens = request.getParameter("opt1");
	String opsdcard = request.getParameter("opt2");
	String samgak = request.getParameter("opt3");
	
    %>