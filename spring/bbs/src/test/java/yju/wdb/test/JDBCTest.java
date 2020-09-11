package yju.wdb.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.junit.Test;

public class JDBCTest {
	Logger log = Logger.getLogger(JDBCTest.class);
	
	@Test
	public void testConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection con = DriverManager.getConnection
				("jdbc:mariadb://localhost:3306/springbbs", "web", "1234");
		
		log.info("Connection OK!!!");
	}

}
