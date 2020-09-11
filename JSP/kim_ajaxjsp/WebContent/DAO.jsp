<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@page import="org.json.simple.*"%>
<%@ page import="java.sql.*, javax.sql.*, javax.naming.*"%>

<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
 
 String callback = request.getParameter("callback");
 
 Connection conn = null;
 PreparedStatement pstmt = null;
 ResultSet rs = null;
 JSONObject jsonObject;
 JSONArray jsonArray = new JSONArray();
 
 try {

  Class.forName("org.mariadb.jdbc.Driver");

  String url = "jdbc:mariadb://localhost:33060/person";
  String id = "root";
  String pw = "1234";
  conn = DriverManager.getConnection(url, id, pw);

  pstmt = conn.prepareStatement("select * from Person");
  rs = pstmt.executeQuery();

  while (rs.next()) {
   jsonObject = new JSONObject();
   jsonObject.put("pname", rs.getString("pname"));
   jsonObject.put("age", rs.getInt("age"));
   jsonArray.add(jsonObject);

  }

 } catch (Exception e) {
  out.println(e);
 } finally {
  if (rs != null)
   try {
    rs.close();
   } catch (SQLException ex) {
   }
  if (pstmt != null)
   try {
    pstmt.close();
   } catch (SQLException ex) {
   }
  if (conn != null)
   try {
    conn.close();
   } catch (SQLException ex) {
   }
 }

 out.println(callback + "(");
 out.println(jsonArray);
 out.println(")");
%>
