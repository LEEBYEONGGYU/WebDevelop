package shop.DBbean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDBBean {
	private static MemberDBBean instance = new MemberDBBean();
	public static MemberDBBean getInstance() {
		return instance;
	}
	
	public MemberDBBean() {}
	
	//커넥션 풀로부터 Connetion 객체를 얻어낸다
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		return ds.getConnection();
	}
	
	public void insertMember(MemberData mem) throws Exception {
		Connection conn= null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql="insert into member (userid, userpw, userphone, username, useremail) values (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mem.getUserid());
			psmt.setString(2, mem.getUserpw());
			psmt.setString(3, mem.getUserphone());
			psmt.setString(4, mem.getUsername());
			psmt.setString(5, mem.getUseremail());
			
			psmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if( rs!=null)  try {rs.close(); }catch( SQLException ex){}
			if( psmt!=null)  try {psmt.close(); }catch( SQLException ex){}
			if( conn!=null)  try {conn.close(); }catch( SQLException ex){}
		}
}
}
