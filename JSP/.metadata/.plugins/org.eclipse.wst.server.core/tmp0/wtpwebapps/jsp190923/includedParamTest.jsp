<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    <%
    	String name = request.getParameter("name");
    	String pageName = request.getParameter("pageName");
    
    %>
    �Ķ���� ���� ���޹޾� ����Ǵ�<br />
   ���ԵǴ� ������ <%=pageName %> �Դϴ�<br />
   <p><b><%=name %></b>ȯ��!</p>