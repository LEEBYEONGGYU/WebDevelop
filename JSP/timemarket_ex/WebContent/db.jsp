<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<% 
Connection con=null;
Statement stmt;
PreparedStatement psmt;
ResultSet rs;
String dbid = "";
String dbpw = "";
String sql="";
String today = null;
String today2 = null;
try {
	Class.forName("org.mariadb.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoptest","root","");
	stmt = con.createStatement();
	System.out.println("db성공");
	} catch (Exception e) {
		e.printStackTrace();
}
%>