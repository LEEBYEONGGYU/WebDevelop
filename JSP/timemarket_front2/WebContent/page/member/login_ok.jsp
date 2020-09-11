<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="com.google.gson.*"%>
 <% request.setCharacterEncoding("utf-8"); 

 JsonObject JsonObject = new JsonObject(); 
 try {
	 Connection con=null;
	 Statement stmt;
	 PreparedStatement psmt;
	 ResultSet rs;
	 String sql="";
	 
	 Context init = new InitialContext(); //
	 DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jsptest"); //
	 con = ds.getConnection(); //
	 
	 
		sql = "select userid, userpw from member where userid=?";
		psmt = con.prepareStatement(sql);
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		psmt.setString(1,uid);
		rs = psmt.executeQuery();
		String mem_id="";
		String mem_pw="";
			while(rs.next()){
				mem_id = rs.getString("userid");
				 mem_pw = rs.getString("userpw");
				System.out.println(mem_id+" "+mem_pw);
			}
			
			if(mem_id.equals(uid) && mem_pw.equals(upw)){	
				 session.setAttribute("userid",mem_id);
				 String idk="1";
				
					JsonObject.addProperty("lo_ok",idk);
					out.println(JsonObject.toString());

			}else{ 
				 String idk="2";
					
					JsonObject.addProperty("lo_ok",idk);
					out.println(JsonObject.toString());
	 } }catch(Exception e){
		 e.printStackTrace();
 }
 %>
 