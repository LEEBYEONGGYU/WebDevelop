<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<% 
Connection con=null;
Statement stmt;
PreparedStatement psmt;
ResultSet rs;
String sql="";
try {

	Class.forName("org.mariadb.jdbc.Driver");

	con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoptest","root","");

	stmt = con.createStatement();
}catch(Exception e){
	System.out.println("<h3>연결에실패하였습니다.</h3>");
	System.out.println(e.getMessage());
}

%>