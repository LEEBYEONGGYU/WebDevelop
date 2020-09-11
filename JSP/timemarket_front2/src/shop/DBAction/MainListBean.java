package shop.DBAction;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;
public class MainListBean {
	public static MainListBean instance = new MainListBean();
	Connection con=null;
	PreparedStatement psmt = null;
	public static MainListBean getInstance() {
		return instance;
	}
	
	private MainListBean() {}
	
public Connection getConnection() throws Exception {
	
		Context init = new InitialContext(); //
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jsptest"); //
		con = ds.getConnection(); //
		return ds.getConnection();
	}

public void Mainprolist() {
	String sql = "select * from product order by p_enddate desc limit 0,3";
 	PreparedStatement psmt = null;
	try {
		psmt = con.prepareStatement(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	try {
		ResultSet rs = psmt.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
