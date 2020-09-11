package shop.DBbean;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import shop.DBbean.*;
public class Admin_productopBean {
	private static Admin_productopBean instance = new Admin_productopBean();
	
	//.jsp페이지에서 DB연동빈인 메소드에 접근시 필요한거
	public static Admin_productopBean getInstance() {
		return instance;
	}
	
	public Admin_productopBean() {}
	
	//커넥션 풀로부터 Connetion 객체를 얻어낸다
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		return ds.getConnection();
	}
	
	//옵션 상품 등록하기
	public void insertOption(Admin_productopdata option) throws Exception {
		Connection conn= null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql="insert into product_op (po_code, po_manuf, po_name, po_wname, po_cot, po_price, po_img) values"+
					"(?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, option.getPo_code());
			psmt.setString(2, option.getPo_manuf());
			psmt.setString(3, option.getPo_name());
			psmt.setString(4, option.getPo_wname());
			psmt.setString(5, option.getPo_cot());
			psmt.setString(6, option.getPo_price());
			psmt.setString(7, option.getPo_img());
			psmt.executeUpdate();
			System.out.println(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if( rs!=null)  try {rs.close(); }catch( SQLException ex){}
			if( psmt!=null)  try {psmt.close(); }catch( SQLException ex){}
			if( conn!=null)  try {conn.close(); }catch( SQLException ex){}
		}
}
}
