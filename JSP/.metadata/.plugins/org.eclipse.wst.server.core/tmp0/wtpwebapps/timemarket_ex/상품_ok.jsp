<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>

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
    	
    	String today = null;
    	java.util.Date now = new java.util.Date(); 
    	System.out.println(now); 
    	SimpleDateFormat sdformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	Calendar cal2 = Calendar.getInstance(); 
    	
    	cal2.setTime(now); 
    	cal2.add(Calendar.HOUR, 8); 
    	today = sdformat.format(cal2.getTime()); 
    	System.out.println("8시간 후 : " + today); 
    	

			stmt = con.createStatement();
			sql = "insert into 일반상품 (상품코드, 제조사명, 상품명, 입고명, 재고수량, 가격, 마감일자, 상세정보) values"+
					"('"+request.getParameter("c_code")+
							"','"+request.getParameter("c_name")+
							"','"+request.getParameter("p_name")+
							"','"+request.getParameter("in_name")+
							"','"+request.getParameter("j_su")+
							"','"+request.getParameter("j_price")+
							"','"+today+
							"','"+request.getParameter("manu_info")+
							"')";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
			%>
			<script>alert('상품등록완료'); location.href="index.jsp";</script>
			<%
		}catch(Exception e) {
			%>
			<script>alert('등록에 실패했어요'); location.href="index.jsp";</script>
			<%
			e.printStackTrace();
			
		}
		%>
		