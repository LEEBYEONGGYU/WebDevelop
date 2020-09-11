package p190716;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;



class board {
	int idx; //글번호 기본키
	String title; //제목
	String name; //글쓴이
	Date date; //날짜
	String item;//내용
	int readCount;//조회수
	
	public void insert() {
		System.out.println(title);
	}
}
public class project190716 {
	public static void main(String[] args) throws Exception {
		board object = new board();
		// 1. JDBC 드라이버 적재
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  // 2. 데이터베이스 연결
		  Connection con ;  //Connection 객체변수 선언
		  String url = "jdbc:mysql://localhost:3306/yjc?useUnicode=true&characterEncoding=utf8";
		  con = DriverManager.getConnection(url, "root", "xampp");
		
		  // 3. SQL문장 작성 및 전송
		  Statement stmt;   //Statement 객체변수 선언
		  stmt = con.createStatement(); 
		  
		Date d = new Date(Calendar.getInstance().getTimeInMillis());
		System.out.print("1. 글쓰기, 2글목록 \n 메뉴를 선택하세요.");
		int inputValue;
		
		Scanner input = new Scanner(System.in);
		inputValue = input.nextInt();
		if(inputValue==1) {
			System.out.println("글을 작성합니다");
			//1. Content객체 저장
			
			//2. Content 객체의 각 내용을 사용자로 부터 입력받아 저장
			
			Scanner innum = new Scanner(System.in);
			System.out.println("글번호 : ");
			object.idx = innum.nextInt();
			
			Scanner intitle = new Scanner(System.in);
			System.out.println("제목 : ");
			object.title = intitle.nextLine();
			
			Scanner inname = new Scanner(System.in);
			System.out.println("글쓴이 : ");
			object.name = inname.nextLine();
			
			Scanner intem = new Scanner(System.in);
			System.out.println("내용 : ");
			object.item = intem.nextLine();
			
			object.readCount = 0; //조회수 초기값
			object.date = d; // 날짜

			  //4. sql문장 작성
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
		//db 연결종료
			stmt.close();
			  con.close();
	}


}
