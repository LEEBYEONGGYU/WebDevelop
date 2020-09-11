

import java.io.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DBManager extends JFrame {
	Connection con;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	String dbid = "";
	String dbpw = "";
	String sql="";

		public void connect() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@db-mtbcraft.cn9efomxqp95.ap-northeast-2.rds.amazonaws.com:1521:orcl","mtbcraft","mtbcraft3wh");
				stmt = con.createStatement();
			} catch (Exception e) {
				System.out.println("DB접속성공");
			}
		}
		
	public void loginok(String uid) {
		try {
			sql = "select * from member where userid=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,uid);
			rs = psmt.executeQuery();
				while(rs.next()){
					dbid = rs.getString("userid");
					dbpw = rs.getString("userpw");
				}
			System.out.println(""+dbid);
			System.out.println(dbpw);
			
			if(dbid.equals(uid)) {
				JOptionPane.showMessageDialog(null, "로그인 성공!");
				psmt.close();
				rs.close();
				con.close();
				
				SelectMode gl = new SelectMode(dbid);
			}else {
				JOptionPane.showMessageDialog(null, "아이디 및 비밀번호를 확인해주세요.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e1) {
			e1.printStackTrace();
	}
		
	}
	
	public void memberadd(String addid, String addpw, String addname) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##web","webuser");
			stmt = con.createStatement();
			String sql = "insert into member (userid, userpw, username) values"+
					"('"+addid+"','"+addpw+"','"+addname+"')";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void gameadd(String uid, String picname, String timerBuffer) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##web","webuser");
			stmt = con.createStatement();
			sql = "insert into game (userid, picture, finishtime, gamemode) values"+
					"('"+uid+"','"+picname+"','"+timerBuffer+"','싱글')";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void myinfo(String uid) {
		
		
	}
}