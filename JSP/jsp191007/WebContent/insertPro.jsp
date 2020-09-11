<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<% request.setCharacterEncoding("utf-8"); %>
<%
String idt = request.getParameter("idt");
String passwd = request.getParameter("passwd");
String name = request.getParameter("name");
String addr = request.getParameter("addr");
String tel = request.getParameter("tel");
Timestamp register = new Timestamp(System.currentTimeMillis());

Connection conn = null;
PreparedStatement psmt = null;
String str="";
try{
	String url = "jdbc:mariadb://localhost:3306/yjc";
	String id="root";
	String pw="";
	
	Class.forName("org.mariadb.jdbc.Driver");
	conn=DriverManager.getConnection(url,id,pw);
	
	String sql = "insert into member values(?,?,?,?,?,?)";
	psmt = conn.prepareStatement(sql);
	psmt.setString(1,idt);
	psmt.setString(2,passwd);
	psmt.setString(3,name);
	psmt.setTimestamp(4,register);
	psmt.setString(5,addr);
	psmt.setString(6,tel);
	psmt.executeUpdate();
	
	out.println("member테이블에 새로운 레코드를 추가했습니다.");
	
	
}catch(Exception e){ //예외발생 시 처리
	e.printStackTrace();
	out.println("member테이블에 새로운 레코드 추가에 실패했습니다");
	}finally{
	if(psmt !=null){
	try{
		psmt.close();
	}catch(SQLException sqle){
		
	}
	}
	}
	if(conn !=null){
	try{conn.close();}catch(SQLException sqle){}
	
	}
	
	%>

	
	