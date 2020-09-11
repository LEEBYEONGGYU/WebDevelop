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
		// DB에 들어있는 게시글 리스트를 읽어와서
		//글목록 테이블을 생성하시오(html로)
		
		//1. jdbc 드라이버 적재(mysql)
		Class.forName("com.mysql.jdbc.driver");
		//2. 데이터베이스 연결
		Connection con;
		String url = "jdbc:mysql://localhost:3306/yjc";
		con = DriverManager.getConnection(url,"root","");
		//3. sql문장 작성 및 전송
		Statement stmt;
		stmt = con.createStatement();
		//4. 쿼리결과가져와서 레코드 하나씩 읽으면서 객체를 생성하여 값을 저장 객체를 배열에 저장
		board[] array = new board[100];
		
		
		System.out.print("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title>게시판</title>"
				+ "<body>"
				+ "<h1>게시판</h1>"
				+ "<table border='1'>");
		//저장객체 배열에 저장?
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

		//5. 배열에 있는 개체를 이용하여 HTML생성
		  
		  // 연결을 종료한다.
		rs.close();
		  con.close();
	}

}
