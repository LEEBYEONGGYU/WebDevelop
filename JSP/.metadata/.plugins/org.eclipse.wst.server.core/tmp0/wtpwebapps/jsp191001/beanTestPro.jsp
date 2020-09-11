<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% request.setCharacterEncoding("utf-8"); %>
    
    <jsp:useBean id="testBean" class="jsp191001.TestBean">
    	<jsp:setProperty name="testBean" property="id" />
    </jsp:useBean>
    
    입력한 아이디 : <jsp:getProperty name="testBean" property="id" />