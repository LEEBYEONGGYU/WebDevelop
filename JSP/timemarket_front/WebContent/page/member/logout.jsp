<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    session.invalidate();
    	out.println("<script>alert('로그아웃  성공'); location.href='/timemarket_front/index.do'; </script>");
    %>
   