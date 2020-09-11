<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

    <% 
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");%>
    
    <p>포함되는 페이지 includeTest.jsp입니다</p><b><%=name %></b>님 환영!