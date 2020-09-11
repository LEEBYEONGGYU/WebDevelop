<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setCharacterEncoding("utf-8"); %>
 <%@ page import="java.sql.*" %>
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
	
    	String userid = (String)session.getAttribute("userid");
	String bascode = "c1604";
			stmt = con.createStatement();
			sql = "insert into 장바구니 (장바구니번호, 사용자아이디, 상품명, 가격, 수량) values"+
"('"+bascode+"','"+userid+"','"+request.getParameter("bas_name")+"','"+request.getParameter("bas_price")+"','"+request.getParameter("bas_count")+
							"')";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
			%>
			<script>alert('장바구니등록됨'); location.href="index.jsp";</script>
			<%
		}catch(Exception e) {
			%>
			<script>alert('등록에 실패했어요'); location.href="index.jsp";</script>
			<%
			e.printStackTrace();
			}%>