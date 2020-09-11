

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class WDB {

   public static void main(String[] args) throws Exception {
      //1. JDBC ����̹��� ����
      Class.forName("oracle.jdbc.driver.OracleDriver");

      //2. oracle db ����
      String url = "jdbc:orcle:thin:@localhost:1521:orcl";
      String id = "WEB";
      String pw = "oracle";
      
      /* ���߿� PC�� �Ҷ� url�� net.yju.ac.kr:1521:orcl id�� s1601184
       * pw�� p1601184�� */ 
      Connection conn;
      conn = DriverManager.getConnection(url,id,pw);
      
      //3. ������
      Statement stmt;
      stmt = conn.createStatement();
      
      String sql="delete from books where book_id=1";
      stmt.executeUpdate(sql);
      
      //4. ��������
      stmt.close();
      conn.close();
      
   }

}