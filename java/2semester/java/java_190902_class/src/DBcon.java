

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcon {
	//1. ����̹� �ε�
	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement psmt;
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB���� ������");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "WEB";
			String pw = "oracle";
			try {
				con = DriverManager.getConnection(url, id, pw);
				System.out.println("DB���� ��ġ");
			} catch (SQLException e) {
				System.out.println("DB���� Ȯ���ʿ�");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DB������п�");
			e.printStackTrace();
		}
	}
}
