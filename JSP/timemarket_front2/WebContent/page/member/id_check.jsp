<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="com.google.gson.*"%>
    <% 
 	request.setCharacterEncoding("UTF-8");
    JsonObject JsonObject = new JsonObject();
    String st = "";
    try{
    	 Connection con=null;
    	 Statement stmt;
    	 PreparedStatement psmt;
    	 ResultSet rs;
    	 String sql="";
    	 
    	 Context init = new InitialContext(); //
    	 DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jsptest"); //
    	 con = ds.getConnection(); //
    	 
    	 
    		sql = "select userid from member where userid=?";
    		psmt = con.prepareStatement(sql);
    		String uid = request.getParameter("idck");
    		System.out.println(uid);
    		psmt.setString(1,uid);
    		rs = psmt.executeQuery();
    		String mem_id="";
    		String mem_pw="";
    			while(rs.next()){
    				mem_id = rs.getString("userid");
    				 System.out.println(mem_id);
    			}
    			
    			if(mem_id.equals("")){
    				st = "사용가능한 아이디입니다";
    				JsonObject.addProperty("proid",st);
    			}else{
    				st = "중복된 아이디입니다.";
    				JsonObject.addProperty("proid",st);
    			}
    			
    			out.print(JsonObject.toString());
    				 
    }catch(Exception e){
    	e.printStackTrace();
    }
	%>