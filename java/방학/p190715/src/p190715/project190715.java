package p190715;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

class board {
	String title;
	String name;
	Date date;
	String item;
	int readCount;
	
	public void title() {
		System.out.println(title);
	}
	
	public void name() {
		System.out.println(name);
	}
	public void date() {
		System.out.println(date);
	}
	public void item() {
		System.out.println(item);
	}
	public void readCount() {
		System.out.println(readCount);
	}
}
public class project190715 {
	public static void main(String[] args) throws Exception {
		//1. �� 100���� ������ �迭 ����
		board[] array = new board[100];
		//2. �� ��ü ���� �� �ʱ�ȭ �ѵ� �۹迭 ���ҿ� ����
		//���� ��¥�� �ش��ϴ� date ��ü ���� ���
		Date d = new Date(Calendar.getInstance().getTimeInMillis());
		
		 
		  
		 
		  
		for (int i = 0; i < 100; i++) {
			board object = new board();
			array[i] = object;
			
			object.title = "������" +i;
			object.name = "�̺���" +i;
			object.item = "test board"+i;
			object.date = d;
			object.readCount = i;
			
			
			// 1. JDBC ����̹� ����
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  // 2. �����ͺ��̽� ����
			  Connection con ;  //Connection ��ü���� ����
			  String url = "jdbc:mysql://localhost:3306/post_board?useUnicode=true&characterEncoding=utf8";
			  con = DriverManager.getConnection(url, "root", "xampp");
			
			  // 3. SQL���� �ۼ� �� ����
			  Statement stmt;   //Statement ��ü���� ����
			  stmt = con.createStatement(); 
			  
			  //4. sql���� �ۼ�
			 String sql = "INSERT INTO javadb"+"(title, name, writeDate, item, readCount) value ('"+object.title+"','"+object.name+"','"+object.date+"','"+object.item+"','"+object.readCount+"')";
			 // sql = sql + array[0].title;
			  //sql = sql + "','";
			  //sql = sql + array[0].name;
			  //sql = sql + "'.d,'";
			  //sql = sql + array[0].item;
			 // sql = sql + "',";
			 // sql = sql + array[0].readCount;
			 // sql = sql + ")";
			  stmt.executeUpdate(sql);
				stmt.close();
				  con.close();
			//System.out.println(object.title + " "+ object.name + " "+ object.item + " "+ object.date + " "+ object.readCount);
		}
	}
}
