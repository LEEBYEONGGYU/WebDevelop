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

			stmt = con.createStatement();
			sql = "insert into 옵션상품 (상품코드, 옵션상품명, 옵션종류, 옵션수량, 가격) values"+
					"('"+request.getParameter("co_code")+
							"','"+request.getParameter("co_name")+
							"','"+request.getParameter("op_jor")+
							"','"+request.getParameter("op_count")+
							"','"+request.getParameter("op_price")+
							"')";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
			
			%>
			<script>alert('옵션등록완료'); location.href="index.jsp";</script>
			<%
		}catch(Exception e) {
			%>
			<script>alert('등록에 실패했어요'); location.href="index.jsp";</script>
			<%
			e.printStackTrace();
			
		}%>