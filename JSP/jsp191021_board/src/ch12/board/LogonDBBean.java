package ch12.board;
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;
import org.apache.commons.codec.digest.DigestUtils;

public class LogonDBBean {

	private static LogonDBBean instance = new LogonDBBean();
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	private LogonDBBean() {}
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource)envCtx.lookup("jdbc/jsptest");
		return ds.getConnection();
	}
	
	
	public int userCheck(String uid, String passwd) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int x=-1;
		
		try {
			conn = getConnection();
			String orgPass = passwd;
			String shaPss = DigestUtils.sha256Hex(orgPass);
			psmt = conn.prepareStatement("select passwd from member where id=?");
			psmt.setString(1, uid);
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				String bpasswd = rs.getString("passwd");
				if(shaPss.equals(bpasswd))
					x=1;
				else 
					x=0;
				}else
					x=-1;
			}catch(Exception ex) {
				ex.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close(); } catch(SQLException ex) {} 
			if(psmt !=null) try { psmt.close(); } catch(SQLException ex) {}
			if(conn !=null) try {conn.close(); } catch(SQLException ex) {}
		}
		return x;
	}
}
