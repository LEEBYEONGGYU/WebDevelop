<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="com.google.gson.*"%>
<% 
JsonObject os = new JsonObject();
try {
	request.setCharacterEncoding("UTF-8");
	 Connection con=null;
	 Statement stmt;
	 PreparedStatement psmt;
	 ResultSet rs;
	 String sql="";
	 
	 Context init = new InitialContext(); //
	 DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jsptest"); //
	 con = ds.getConnection(); //
	 
	String a_idx = request.getParameter("qidx");
	String a_title = request.getParameter("qtitle");
	String a_text = request.getParameter("qtext");
	String sql2 = "";
	String okt = "답변완료";
	stmt = con.createStatement();
	sql = "insert into qaboarddat (qa_idx, title, content) values"+
			"('"+a_idx+"','"+a_title+"','"+a_text+"')";
	stmt.executeUpdate(sql);
	
	sql2 = "update qaboard set qa_status='"+okt+"' where idx='"+a_idx+"'";
	stmt.executeUpdate(sql2);
	stmt.close();
	con.close();
	
	String qaok = "답변 처리되었습니다";
	
	
	 os.addProperty("qa",qaok);
	
	 out.println(os.toString());
	 System.out.println(os.toString());
} catch (Exception e) {
	e.printStackTrace(); 
}
%>