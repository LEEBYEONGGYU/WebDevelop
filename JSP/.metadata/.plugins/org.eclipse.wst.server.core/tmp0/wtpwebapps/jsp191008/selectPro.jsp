<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr class="label">
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>가입일자</td>
			<td>주소</td>
			<td>전화번호</td>
		</tr>
			
			<%
			
				Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			
			try{
				String jdbcUrl="jdbc:mariadb://localhost:3306/yjc";
				String dbId="root";
				String dbpw="";
				
				Class.forName("org.mariadb.jdbc.Driver");
				conn=DriverManager.getConnection(jdbcUrl,dbId,dbpw);
				
				String sql ="select * from member order by reg_date desc";
				psmt = conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				
				while(rs.next()){
					String id=rs.getString("id");
					String passwd= rs.getString("passwd");
					String name = rs.getString("name");
					Timestamp register=rs.getTimestamp("reg_date");
					String address = rs.getString("address");
					String tel = rs.getString("tel");
				%>
				<tr>
					<td><%=id %></td>
					<td><%=passwd %></td>
					<td><%=name %></td>
					<td><%=register.toString() %></td>
					<td><%=address %></td>
					<td><%=tel %></td>
				</tr>
				<% }
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try{rs.close();}catch(SQLException sqle){}
					
					if(psmt !=null){
						try{psmt.close();}catch(SQLException sqle){}
						
						if(conn !=null){
							try{conn.close();}catch(SQLException sqle){}
						}
					}
				}
			}
			%>
		</tr>
	</table>
</body>
</html>