package shop.DBbean;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;
public class Admin_productBean {
	private static Admin_productBean instance = new Admin_productBean();
	
	//.jsp페이지에서 DB연동빈인 메소드에 접근시 필요한거
	public static Admin_productBean getInstance() {
		return instance;
	}
	
	public Admin_productBean() {}
	
	//커넥션 풀로부터 Connetion 객체를 얻어낸다
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		return ds.getConnection();
	}
	
	//옵션 상품 등록하기
	public void insertProduct(Admin_productdata product) throws Exception {
		Connection conn= null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			String sql = "show table status where name = 'product'"; //product테이블의 현재 상태를 가져온다.
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int dix=0;
			while(rs.next()){
				dix= rs.getInt("Auto_increment"); //현재 상태에서 Auto_increment항목을 추출해서 가져온다.
			}
			rs.close();
			stmt.close();
			
			String p_code = product.getP_code(); //
			String p_idx = p_code+dix;
			String sql2="insert into product (p_code, p_manuf, p_name, p_wname, p_cot, p_price, p_enddate, p_text, p_img, p_infoimg) values (?,?,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, p_idx);
			psmt.setString(2, product.getP_manuf());
			psmt.setString(3, product.getP_name());
			psmt.setString(4, product.getP_wname());
			psmt.setString(5, product.getP_cot());
			psmt.setString(6, product.getP_price());
			psmt.setString(7, product.getP_enddte());
			psmt.setString(8, product.getP_text());
			psmt.setString(9, product.getP_img());
			psmt.setString(10, product.getP_infoimg());
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
