package shop.DBbean;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import shop.DBbean.*;
public class Admin_qaBean {
	private static Admin_qaBean instance = new Admin_qaBean();
	
	//.jsp페이지에서 DB연동빈인 메소드에 접근시 필요한거
	public static Admin_qaBean getInstance() {
		return instance;
	}
	
	public Admin_qaBean() {}
	
	//커넥션 풀로부터 Connetion 객체를 얻어낸다
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		return ds.getConnection();
	}
	
	//옵션 상품 등록하기
	public void insertQADap(Admin_qadata AdQA) throws Exception {
		Connection conn= null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql="insert into qaboarddat (qa_idx, title, content) values (?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, AdQA.getA_idx());
			psmt.setString(2, AdQA.getA_title());
			psmt.setString(3, AdQA.getA_text());
			psmt.executeUpdate();
			
			Statement stmt = conn.createStatement();
			String sql2 = "update qaboard set qa_status='답변완료' where idx='"+AdQA.getA_idx()+"'";
			stmt.executeUpdate(sql2);
			stmt.close();
			conn.close();
			

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if( rs!=null)  try {rs.close(); }catch( SQLException ex){}
			if( psmt!=null)  try {psmt.close(); }catch( SQLException ex){}
			if( conn!=null)  try {conn.close(); }catch( SQLException ex){}
		}
}
}
