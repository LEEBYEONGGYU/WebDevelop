package p190716;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;



class board {
	int idx; //�۹�ȣ �⺻Ű
	String title; //����
	String name; //�۾���
	Date date; //��¥
	String item;//����
	int readCount;//��ȸ��
	
	public void insert() {
		System.out.println(title);
	}
}
public class project190716 {
	public static void main(String[] args) throws Exception {
		board object = new board();
		// 1. JDBC ����̹� ����
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  // 2. �����ͺ��̽� ����
		  Connection con ;  //Connection ��ü���� ����
		  String url = "jdbc:mysql://localhost:3306/yjc?useUnicode=true&characterEncoding=utf8";
		  con = DriverManager.getConnection(url, "root", "xampp");
		
		  // 3. SQL���� �ۼ� �� ����
		  Statement stmt;   //Statement ��ü���� ����
		  stmt = con.createStatement(); 
		  
		Date d = new Date(Calendar.getInstance().getTimeInMillis());
		System.out.print("1. �۾���, 2�۸�� \n �޴��� �����ϼ���.");
		int inputValue;
		
		Scanner input = new Scanner(System.in);
		inputValue = input.nextInt();
		if(inputValue==1) {
			System.out.println("���� �ۼ��մϴ�");
			//1. Content��ü ����
			
			//2. Content ��ü�� �� ������ ����ڷ� ���� �Է¹޾� ����
			
			Scanner innum = new Scanner(System.in);
			System.out.println("�۹�ȣ : ");
			object.idx = innum.nextInt();
			
			Scanner intitle = new Scanner(System.in);
			System.out.println("���� : ");
			object.title = intitle.nextLine();
			
			Scanner inname = new Scanner(System.in);
			System.out.println("�۾��� : ");
			object.name = inname.nextLine();
			
			Scanner intem = new Scanner(System.in);
			System.out.println("���� : ");
			object.item = intem.nextLine();
			
			object.readCount = 0; //��ȸ�� �ʱⰪ
			object.date = d; // ��¥

			  //4. sql���� �ۼ�
			 String sql = "INSERT INTO javadb"
			  +"(idx, title, name, writeDate, item, readCount) value ('"
					 +object.idx+"','"+object.title+"','"+object.name+"','"+object.date+"','"+object.item+"','"
			  +object.readCount+"')";
			 
			 System.out.println(sql);
			 stmt.executeUpdate(sql);
		}else {
			ResultSet rs = stmt.executeQuery("select * from javadb");

			while(rs.next()) {
				object.idx = rs.getInt("idx");
				object.title = rs.getString("title");
				object.name = rs.getString("name");
				object.date = rs.getDate("writeDate");
				object.item = rs.getString("item");
				object.readCount = rs.getInt("readCount");
				System.out.println(object.idx+" "+object.title+" "+object.name+" "+object.date+" "+object.item+" "+object.readCount);
			}
			System.out.println("</table></body></html>");
			
		}
		//db ��������
			stmt.close();
			  con.close();
	}


}
