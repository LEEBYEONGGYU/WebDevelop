<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    <%
    	String name = request.getParameter("name");
    	String pageName = request.getParameter("pageName");
    
    %>
    파라미터 값을 전달받아 실행되는<br />
   포함되는 페이지 <%=pageName %> 입니다<br />
   <p><b><%=name %></b>환영!</p>