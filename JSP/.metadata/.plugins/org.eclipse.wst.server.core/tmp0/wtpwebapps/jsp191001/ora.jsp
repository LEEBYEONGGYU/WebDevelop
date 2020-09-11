<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>

    
    <% 
    	Connection con = null;
    	try {
//     		Class.forName("com.mysql.jdbc.Driver");
//     		String url="jdbc:mysql://localhost:3306/yjc";
//     		String id="root";
//     		String pw="";
    		
Class.forName("oracle.jdbc.driver.OracleDriver");
    		String url="jdbc:oracle:thin:@localhost:1521:orcl";
    		String id="c##web";
    		String pw="oracle";
    		
    		con = DriverManager.getConnection(url,id,pw);
    		
    		
    		if(con!=null){
    			out.println("mysql connected<br>");
    			con.close();
    		}
    	}catch(Exception e){
    		out.println(e);
    		
    	}
    
    %>