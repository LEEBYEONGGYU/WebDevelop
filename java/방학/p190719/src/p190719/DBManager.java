package p190719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBManager {
	Connection con;
	ResultSet rs;
	Statement stmt;
	
	public void connect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:mysql://localhost:3306/yjc?useUnicode=true&characterEncoding=utf8";
		  con = DriverManager.getConnection(url, "root", "xampp");
		
	}
	public void modify(String sql) throws Exception {
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	public int inam() throws Exception {
		System.out.println("°Å·¡³»¿ª»Õ»Õ");
		System.out.println("°èÁÂ¹øÈ£ÀÔ·Â ¤¡¤¡");
		Scanner acno = new Scanner(System.in); //°èÁÂ¹øÈ£ÀÔ·Â
		int accno = acno.nextInt();

		stmt = con.createStatement();
		 rs = stmt.executeQuery("select * from Trade where no="+accno+" order by tDate desc");
			
			while(rs.next()) {
				Trade item = new Trade();
				item.no = rs.getInt("no");
				item.tDate = rs.getDate("tDate");
				item.type = rs.getInt("type");
				item.amount = rs.getInt	("amount");
				item.memo = rs.getString("memo");
				System.out.print (item.no+" "+item.tDate+" "+item.type+" "+item.amount+" "+item.memo+"\n");
			}
		return 0;
	}

}
