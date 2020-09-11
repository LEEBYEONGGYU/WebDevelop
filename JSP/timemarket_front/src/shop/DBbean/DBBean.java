package shop.DBbean;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class DBBean {
	private static DBBean instance = new DBBean(); ///전역객체
	Connection con=null;
	PreparedStatement psmt = null;
	//DBBean객체 리턴 메서드
	public static DBBean getInstance() {
		return instance;
	}
	
	public DBBean() {}
	
	//커넥션 풀에서 객체 얻어냄 
	public Connection getConnection() {
		try {
			Context init = new InitialContext(); //
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jsptest"); //
			con = ds.getConnection(); //
			return ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
	}
		return con;
	}
	
}
