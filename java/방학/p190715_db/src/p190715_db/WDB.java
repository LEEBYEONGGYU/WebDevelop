package p190715_db;
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

public class WDB {

	public static void main(String[] args) throws Exception{
		Date d = new Date(Calendar.getInstance().getTimeInMillis());
		// DB�� ����ִ� �Խñ� ����Ʈ�� �о�ͼ�
		//�۸�� ���̺��� �����Ͻÿ�(html��)
		
		//1. jdbc ����̹� ����(mysql)
		Class.forName("com.mysql.jdbc.driver");
		//2. �����ͺ��̽� ����
		Connection con;
		String url = "jdbc:mysql://localhost:3306/yjc";
		con = DriverManager.getConnection(url,"root","");
		//3. sql���� �ۼ� �� ����
		Statement stmt;
		stmt = con.createStatement();
		//4. ������������ͼ� ���ڵ� �ϳ��� �����鼭 ��ü�� �����Ͽ� ���� ���� ��ü�� �迭�� ����
		board[] array = new board[100];
		
		
		System.out.print("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title>�Խ���</title>"
				+ "<body>"
				+ "<h1>�Խ���</h1>"
				+ "<table border='1'>");
		//���尴ü �迭�� ����?
		ResultSet rs = stmt.executeQuery("select * from javadb");
		
		int i=0;
		while(rs.next()) {
			board object = new board();
			object.title = rs.getString("title");
			object.name = rs.getString("name");
			object.date = rs.getDate("writeDate");
			object.item = rs.getString("item");
			object.readCount = rs.getInt("readCount");
			array[i] = object;
			i++;
		}
		for( i=0; i<100; i++) {
			
			
			System.out.println("<tr><td>"+array[i].title+"</td>"+"<td>"+array[i].name+"</td><td>"+array[i].date+"</td><td>"+array[i].item+"</td><td>"+array[i].readCount+"</td></tr>");
			
		}
		System.out.println("</table></body></html>");

		//5. �迭�� �ִ� ��ü�� �̿��Ͽ� HTML����
		  
		  // ������ �����Ѵ�.
		rs.close();
		  con.close();
	}

}
