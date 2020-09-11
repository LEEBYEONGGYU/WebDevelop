<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
 <% request.setCharacterEncoding("utf-8"); %>
<%
Connection con=null;
Statement stmt;
PreparedStatement psmt;
ResultSet rs;
String dbid = "";
String dbpw = "";
String sql="";
try {
				Class.forName("org.mariadb.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoptest","root","");
				stmt = con.createStatement();
				System.out.println("db성공");
			} catch (Exception e) {
				e.printStackTrace();
			}

%>
    <% 
    try {
	String phone = request.getParameter("phone")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
	String email = request.getParameter("email")+"@"+request.getParameter("email2");
	String mem_gu = request.getParameter("mem_gu");
	
	if(mem_gu.equals("일반회원")){
		 mem_gu = "일반회원";
	}else{
		 mem_gu = "판매자";
	}
			stmt = con.createStatement();
			sql = "insert into 회원 (아이디, 비밀번호, 전화번호, 이름, 이메일, 회원구분) values"+
					"('"+request.getParameter("userid")+
							"','"+request.getParameter("pw")+
							"','"+phone+
							"','"+request.getParameter("name")+
							"','"+email+
							"','"+mem_gu+
							"')";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
			
			%>
			<script>alert('회원가입이 완료되었습니다.'); history.back();</script>
			<%
		}catch(Exception e) {
			%>
			<script>alert('회원가입에 실패했습니다.'); history.back();</script>
			<%
			e.printStackTrace();
			
		}%>