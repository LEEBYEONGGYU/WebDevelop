package yju.wdb.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
	Logger log = Logger.getLogger(DataSourceTest.class);
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
//	@Test
	public void testConnection() throws SQLException {
		Connection con = dataSource.getConnection();

		log.info("Connection established!!!");
	}
	
	@Test
	public void textConnection2() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		Connection con = session.getConnection();
		log.info("Connection established!!!~");
	}

}
