package p190712;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WDB_1900712 {

	public static void main(String[] args) throws Exception {
		// 1. JDBC 드라이버 적재
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  // 2. 데이터베이스 연결
		  Connection con ;  //Connection 객체변수 선언
		  String url = "jdbc:mysql://localhost:3306/post_board";
		  con = DriverManager.getConnection(url, "root", "xampp");
		
		  
		  // 3. SQL문장 작성 및 전송
		  Statement stmt;   //Statement 객체변수 선언
		  stmt = con.createStatement(); 
		  
		  ResultSet rs =
		   stmt.executeQuery("select * from free_board");
		  // ResultSet 객체로 부터 결과를 가져온다.
		  while(rs.next()) {  // 첫번째 결과 행으로 이동한다.
		   System.out.print( rs.getInt("idx") + " ");
		   System.out.print( rs.getString("title") + " ");
		   System.out.print( rs.getString("name") + " ");
		   System.out.print( rs.getString("content") + " ");
		   System.out.print( rs.getString("file") + " ");
		   System.out.print( rs.getInt("date") + "\n");
		  }
		  
		  // 연결을 종료한다.
		  rs.close();
		  con.close();
		  
	}

}
