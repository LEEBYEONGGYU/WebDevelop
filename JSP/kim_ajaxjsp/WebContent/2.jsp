<%@ page language="java" contentType="javascript/jsonp; charset=utf-8"
    pageEncoding="utf-8" import="doa.*,org.json.simple.*" %>

<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String callback = request.getParameter("callback");
  
    DAO dao = new DAO();       
  
    JSONObject loginResult = dao.loginPro(id, pw);
  
    out.println(callback + "(");
 out.println(loginResult);
    out.println(")");

    %>