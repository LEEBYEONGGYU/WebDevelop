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
String sql2="";
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
	String gucode = "gc201";
			stmt = con.createStatement();
			sql = "insert into 구매 (구매번호, 구매아이디, 구매상품명, 구매방법, 구매금액, 배송지주소, 배송지전화번호, 배송방법) values"+
"('"+gucode+"','"+userid+"','"+request.getParameter("gu_pname")+"','"+request.getParameter("gu_if")+"','"+request.getParameter("gu_price")+
							"','"+request.getParameter("gu_price")+"','"+request.getParameter("gu_adress")+"','"+request.getParameter("ba_of")+"')";
			stmt.executeUpdate(sql);
			
			
			sql2 = "select 상품코드, 상품명  from 일반상품 where 상품명=?";
			psmt = con.prepareStatement(sql2);
			String sanname = request.getParameter("gu_pname");
			psmt.setString(1,sanname);
			rs = psmt.executeQuery();
			String code="";
				while(rs.next()){
					code= rs.getString("상품코드");
				}
			
			String gumeid = "panme";
			sql2 = "insert into 판매 (판매자아이디, 구매자아이디, 상품코드, 상품명, 가격) values"+
					"('"+gumeid+"','"+userid+"','"+code+"','"+request.getParameter("gu_pname")+
												"','"+request.getParameter("gu_price")+"')";
								stmt.executeUpdate(sql2);
			stmt.close();
			con.close();
			%>
			<script>alert('구매가 완료되었습니당'); location.href="index.jsp";</script>
			<%
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(sql);
		}
		%>