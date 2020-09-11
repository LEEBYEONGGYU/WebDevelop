package p190717;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class Item{
	Date idate;
	int gubon;
	String title;
	int amount;
	int valance;
	String memo;
}
//----------------------------------------------------------------//
class DBManager{
	/* db manager 
	 con, rs, stmt����
	 */
	Connection con;
	 ResultSet rs;
	 Statement stmt;
	 
	 public void connect() throws Exception{ //db���Ӱ���
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		  // 2. �����ͺ��̽� ����
		  Connection con ;  //Connection ��ü���� ����
		  String url = "jdbc:mysql://localhost:3306/yjc?useUnicode=true&characterEncoding=utf8";
		  con = DriverManager.getConnection(url, "root", "xampp");
	 }
	 
	 public void modify(String sql) throws Exception { //��������
		 stmt = con.createStatement();
		 stmt.executeUpdate(sql);
		 stmt.close();
	 }
	 
	 //�ܾ�Ȯ���ϱ�
	 public int getbalance() throws Exception{
		 stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery("select * from item order by idate desc limit 1");
		 int bal;
		 
		 if(rs.next()) {
			 bal = rs.getInt("balance");
		 }else {
			 bal = 0;
		 }
		 return bal; //int�� ��ȯ
	 }
}
//----------------------------------------------------------------//

class Gagebu {
	 DBManager dbManager;
	 public Gagebu() throws Exception {
	  dbManager = new DBManager();
	  dbManager.connect();//dbManager��ü�� connect�޼ҵ�
	 }
	 
	 
public class project190717 {
	public void main(String[] args) throws Exception {
		// 1. JDBC ����̹� ����
		  
		
		  // 3. SQL���� �ۼ� �� ����
		  Statement stmt;   //Statement ��ü���� ����
		  stmt = con.createStatement(); 
		  
		
		// Date today = new Date();
		  Item object = new Item();
		  Date d = new Date(Calendar.getInstance().getTimeInMillis()); 
		    //SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
		  object.idate = d;
		  
		System.out.printf("�׸��� �����ϼ��� \n 1. �Ա�   2. ���");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		
		if(select==1) {
			object.gubon = 1;
			
			System.out.println("������ �Է��ϼ��� : ");
			Scanner title = new Scanner(System.in);
			object.title = title.nextLine();
			
			System.out.println("�ݾ��� �Է��ϼ��� : ");
			Scanner amount = new Scanner(System.in);
			object.amount = amount.nextInt();
			
			System.out.println("�޸��� �Է��ϼ��� : ");
			Scanner memo = new Scanner(System.in);
			object.memo = memo.nextLine();
			
			int ins=0;
			ResultSet rs = stmt.executeQuery("select * from item order by idate desc limit 1");
				
			if(rs.next()) {
					object.valance = rs.getInt("balance");
				}else {
					object.valance = 0;
				}
			
			object.valance = object.valance+object.amount;
			
			 String sql = "insert into item (gubun, title, amount, balance, memo) value"
					  + "('"+object.gubon+"','"+object.title+"','"+object.amount+"','"+object.valance+"','"+object.memo+"')";
			
			System.out.println(sql);
			 stmt.executeUpdate(sql);
			//System.out.println("������ "+object.title+"�ݾ��� "+object.amount+"�޸�� "+object.memo);
		}else {
			object.gubon = 2;
			System.out.println("������ �Է��ϼ��� : ");
			Scanner title = new Scanner(System.in);
			object.title = title.nextLine();
			
			System.out.println("�ݾ��� �Է��ϼ��� : ");
			Scanner amount = new Scanner(System.in);
			object.amount = amount.nextInt();
			
			System.out.println("�޸��� �Է��ϼ��� : ");
			Scanner memo = new Scanner(System.in);
			object.memo = memo.nextLine();
			
			int res=0;
			ResultSet rs = stmt.executeQuery("select * from item order by idate desc limit 1");
			while(rs.next()) {
				object.valance = rs.getInt("balance");
				
				res = object.valance-object.amount;
			}
			System.out.println("�ܾװ��"+res);
			
			 String sql2 = "insert into item (gubun, title, amount, balance, memo) value"
					 + "('"+object.gubon+"','"+object.title+"','"+object.amount+"','"+res+"','"+object.memo+"')";
			 stmt.executeUpdate(sql2);
//������
		}
	}
}
		
		//stmt.close();
		//con.close();
	//}
