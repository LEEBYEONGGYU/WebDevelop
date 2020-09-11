<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("utf-8"); %>

<%
	String id=request.getParameter("idt");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String tel = request.getParameter("tel");
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs=null;
	
	try{
		String url = "jdbc:mariadb://localhost:3306/yjc";
		String did="root";
		String pw="";
		
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url,did,pw);
		
		String sql = "select id, passwd from member where id=?";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1,id);
		rs=psmt.executeQuery();
		
		if(rs.next()){
			String rid=rs.getString("id");
			String rpwd = rs.getString("passwd");
			if(id.equals(rid) && passwd.equals(rpwd)){
				sql = "update member set name=?, address=?, tel=? where id=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1,name);
				psmt.setString(2,addr);
				psmt.setString(3,tel);
				psmt.setString(4,id);
				psmt.executeUpdate();
				out.println("member테이블의 레코드를 수정했습니다");
			}else
				out.println("패스워드가 틀렸습니다");
		}else
				out.println("아이디가 틀렸습니다");
	} catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs !=null){
			try{
				rs.close(); 
			}catch(SQLException sqle){}
			if(psmt !=null){
				try{psmt.close();}catch(SQLException sqle){}
				if(conn !=null){
					try{conn.close();}catch(SQLException sqle){}
				}
			}
		}
	}

%>