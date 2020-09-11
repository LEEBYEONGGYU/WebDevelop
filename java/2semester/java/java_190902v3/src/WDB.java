

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class WDB {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:orcle:thin:@localhost:1521:orcl";
		String id = "WEB";
		String pw = "oracle";
		
		Connection conn;
		conn = DriverManager.getConnection(url,id,pw);
		Statement stmt;
		stmt = conn.createStatement();
		
		String sql = "insert into department(deptno, deptname, floor)values"
				+ "deptno=1, deptname='����',floor=8";
		
		stmt.executeUpdate(sql);
		
		stmt.close();
		conn.close();
		
		
		

	}

}
