<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="/include/db.jsp" %>
 <% request.setCharacterEncoding("utf-8"); 

 
 try {
		sql = "select 아이디, 비밀번호 from 회원 where 아이디=?";
		psmt = con.prepareStatement(sql);
		String uid = request.getParameter("userid");
		String upw = request.getParameter("userpw");
		System.out.println(uid);
		psmt.setString(1,uid);
		rs = psmt.executeQuery();
		String mem_id="";
		String mem_pw="";
			while(rs.next()){
				mem_id = rs.getString("아이디");
				 mem_pw = rs.getString("비밀번호");
				System.out.println(mem_id+" "+mem_pw);
			}
			
			if(mem_id.equals(uid) && mem_pw.equals(upw)){	
 %>
 <script>alert("로그인 성공"); history.back();</script>
 <% 
 session.setAttribute("userid",mem_id);
			
			
			}else{ %>
	  <script>alert("로그인 실패"); </script>
	<% } }catch(Exception e){
		 e.printStackTrace();
 }
 %>
 