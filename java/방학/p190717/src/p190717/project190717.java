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
	 con, rs, stmt선언
	 */
	Connection con;
	 ResultSet rs;
	 Statement stmt;
	 
	 public void connect() throws Exception{ //db접속관련
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		  // 2. 데이터베이스 연결
		  Connection con ;  //Connection 객체변수 선언
		  String url = "jdbc:mysql://localhost:3306/yjc?useUnicode=true&characterEncoding=utf8";
		  con = DriverManager.getConnection(url, "root", "xampp");
	 }
	 
	 public void modify(String sql) throws Exception { //쿼리실행
		 stmt = con.createStatement();
		 stmt.executeUpdate(sql);
		 stmt.close();
	 }
	 
	 //잔액확인하기
	 public int getbalance() throws Exception{
		 stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery("select * from item order by idate desc limit 1");
		 int bal;
		 
		 if(rs.next()) {
			 bal = rs.getInt("balance");
		 }else {
			 bal = 0;
		 }
		 return bal; //int값 반환
	 }
}
//----------------------------------------------------------------//

class Gagebu {
	 DBManager dbManager;
	 public Gagebu() throws Exception {
	  dbManager = new DBManager();
	  dbManager.connect();//dbManager객체에 connect메소드
	 }
	 
	 
public class project190717 {
	public void main(String[] args) throws Exception {
		// 1. JDBC 드라이버 적재
		  
		
		  // 3. SQL문장 작성 및 전송
		  Statement stmt;   //Statement 객체변수 선언
		  stmt = con.createStatement(); 
		  
		
		// Date today = new Date();
		  Item object = new Item();
		  Date d = new Date(Calendar.getInstance().getTimeInMillis()); 
		    //SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
		  object.idate = d;
		  
		System.out.printf("항목을 선택하세요 \n 1. 입금   2. 출금");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		
		if(select==1) {
			object.gubon = 1;
			
			System.out.println("제목을 입력하세요 : ");
			Scanner title = new Scanner(System.in);
			object.title = title.nextLine();
			
			System.out.println("금액을 입력하세요 : ");
			Scanner amount = new Scanner(System.in);
			object.amount = amount.nextInt();
			
			System.out.println("메모을 입력하세요 : ");
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
			//System.out.println("제목은 "+object.title+"금액은 "+object.amount+"메모는 "+object.memo);
		}else {
			object.gubon = 2;
			System.out.println("제목을 입력하세요 : ");
			Scanner title = new Scanner(System.in);
			object.title = title.nextLine();
			
			System.out.println("금액을 입력하세요 : ");
			Scanner amount = new Scanner(System.in);
			object.amount = amount.nextInt();
			
			System.out.println("메모을 입력하세요 : ");
			Scanner memo = new Scanner(System.in);
			object.memo = memo.nextLine();
			
			int res=0;
			ResultSet rs = stmt.executeQuery("select * from item order by idate desc limit 1");
			while(rs.next()) {
				object.valance = rs.getInt("balance");
				
				res = object.valance-object.amount;
			}
			System.out.println("잔액계산"+res);
			
			 String sql2 = "insert into item (gubun, title, amount, balance, memo) value"
					 + "('"+object.gubon+"','"+object.title+"','"+object.amount+"','"+res+"','"+object.memo+"')";
			 stmt.executeUpdate(sql2);
//갓병규
		}
	}
}
		
		//stmt.close();
		//con.close();
	//}
