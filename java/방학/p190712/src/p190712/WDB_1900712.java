package p190712;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WDB_1900712 {

	public static void main(String[] args) throws Exception {
		// 1. JDBC ����̹� ����
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  // 2. �����ͺ��̽� ����
		  Connection con ;  //Connection ��ü���� ����
		  String url = "jdbc:mysql://localhost:3306/post_board";
		  con = DriverManager.getConnection(url, "root", "xampp");
		
		  
		  // 3. SQL���� �ۼ� �� ����
		  Statement stmt;   //Statement ��ü���� ����
		  stmt = con.createStatement(); 
		  
		  ResultSet rs =
		   stmt.executeQuery("select * from free_board");
		  // ResultSet ��ü�� ���� ����� �����´�.
		  while(rs.next()) {  // ù��° ��� ������ �̵��Ѵ�.
		   System.out.print( rs.getInt("idx") + " ");
		   System.out.print( rs.getString("title") + " ");
		   System.out.print( rs.getString("name") + " ");
		   System.out.print( rs.getString("content") + " ");
		   System.out.print( rs.getString("file") + " ");
		   System.out.print( rs.getInt("date") + "\n");
		  }
		  
		  // ������ �����Ѵ�.
		  rs.close();
		  con.close();
		  
	}

}
