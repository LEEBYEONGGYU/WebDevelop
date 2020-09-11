
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class Myinfo extends JFrame {
	//공통변수
	Image img = null;
	int level=1;
	private Font f1,f2,f3,f4;
	Connection con;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	String dbid = "";
	String dbpw = "";
	String sql="";
	String dbtime="";
	String dbmode="";
	String muluid="";
	public Myinfo(String userid) {
		System.out.println("myinfo클래스"+userid);
		JPanel panel = new JPanel();
		panel.setLayout(null); //
		f1 = new Font("Malgun gothic",Font.BOLD,27);

		JLabel label = new JLabel("내 점수보기");
		add(label);
		label.setFont(f1);
		
		JButton bt = new JButton("처음으로");
		add(bt);
		bt.setBounds(480, 74, 120, 30); 
		
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SelectMode(userid);
				//new Picture_Select(userid);
			}
		});
		
		
		label.setBounds(280, 74, 300, 50); 
		
		
		JLabel did = new JLabel("아이디");
		JLabel dpic = new JLabel("그림이름");
		JLabel dtime = new JLabel("경과시간");
		JLabel dmode = new JLabel("게임모드");
		JLabel dmid = new JLabel("상대방 아이디");
		
		f2 = new Font("Malgun gothic", Font.BOLD,17);
		did.setFont(f2);
		did.setBounds(50, 130, 60, 50);
		dpic.setFont(f2);
		dpic.setBounds(170, 130, 100, 50);
		dtime.setFont(f2);
		dtime.setBounds(320, 130, 100, 50);
		dmode.setFont(f2);
		dmode.setBounds(450, 130, 100, 50);
		dmid.setFont(f2);
		dmid.setBounds(560, 130,  150, 50);
		
		
		
		add(did);
		add(dpic);
		add(dtime);
		add(dmode);
		add(dmid);
		
		/* 기록 출력 */
		
		
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##web","webuser");
			stmt = con.createStatement();
			
			sql = "select * from game where userid=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,userid);
			rs = psmt.executeQuery();
			
				int i=0;
				while(rs.next()){
					dbid = rs.getString("userid");
					dbpw = rs.getString("picture");
					dbtime = rs.getString("finishtime");
					dbmode = rs.getString("gamemode");
					
					i++;
					JLabel didget = new JLabel(dbid);
					JLabel dpicget = new JLabel(dbpw);
					JLabel dtimeget = new JLabel(dbtime);
					JLabel dmodeget = new JLabel(dbmode);
					
					f2 = new Font("Malgun gothic", Font.BOLD,17);
					didget.setFont(f2);
					didget.setBounds(50, 170+(i*30), 60, 50);
					dpicget.setFont(f2);
					dpicget.setBounds(170, 170+(i*30), 100, 50);
					dtimeget.setFont(f2);
					dtimeget.setBounds(320, 170+(i*30), 100, 50);
					dmodeget.setFont(f2);
					dmodeget.setBounds(450, 170+(i*30), 100, 50);
					
					
					add(didget);
					add(dpicget);
					add(dtimeget);
					add(dmodeget);

					System.out.println(dbid+dbpw+dbtime+dbmode);
					
				}
		}catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(sql);
	}
		
		add(panel);
		setSize(700,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("게임모드 선택");
		setVisible(true);
	}

}
