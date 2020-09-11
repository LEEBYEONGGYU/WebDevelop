package p190718;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBManager {
	 Connection con; //con
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

	public int getBalance() throws Exception {
		stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery("select * from item order by idate desc limit 1");
		 int bal;
		 
		 if(rs.next()) {
			 bal = rs.getInt("balance");
		 }else {
			 bal = 0;
		 }
		 return bal; //int°ª ¹ÝÈ¯
	}

	public Item[] getList() throws Exception {
//		stmt = con.createStatement();
//		rs = stmt.executeQuery("select count(*) as cnt from item");
//		rs.next();
//		int count = rs.getInt("cnt");
//		rs.close();
		
		stmt = con.createStatement();
		
		Item[] items = new Item[10];
		Item object;
		
		rs = stmt.executeQuery("select * from item order by idate desc");
		int i=0;
		
		while(rs.next()) {
			object = new Item();
			object.idate = rs.getTime("idate");
			object.idate2 = rs.getDate("idate");
			object.gubon = rs.getInt("gubun");
			object.title = rs.getString("title");
			object.amount = rs.getInt("amount");
			object.balance = rs.getInt("balance");
			object.memo = rs.getString("memo");
			
			items[i] = object;
			i++;
		}
		stmt.close();
		  con.close();
		return items;
	}

	
}
