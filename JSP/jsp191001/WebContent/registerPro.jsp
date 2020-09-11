<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.Timestamp"%>

    <% request.setCharacterEncoding("utf-8");%>
    
    <jsp:useBean id="registerBean" class="jsp191001.RegesterBean">
    	<jsp:setProperty name="registerBean" property="*" />
    </jsp:useBean>
    <%//현재 날짜와 시간을 가입일로 지정
   registerBean.setReg_date(new Timestamp(System.currentTimeMillis())); %>
   
   <table>
   	<tr>
   		<td>아이디</td>
   		<td><jsp:getProperty name="registerBean" property="idt" /></td>
   	</tr>
   	<tr>
   		<td>비밀번호</td>
   		<td><jsp:getProperty name="registerBean" property="passwd" /></td>
   	</tr>
   	<tr>
   		<td>이름</td>
   		<td><jsp:getProperty name="registerBean" property="name" /></td>
   	</tr>
   	<tr>
   		<td>가입일</td>
   		<td><jsp:getProperty name="registerBean" property="reg_date" /></td>
   	</tr>
   
   </table>