
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class MultiMode extends JFrame {
	//공통변수
	Image img = null;
	private Font f1,f2,f3,f4;
	Connection con;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	public MultiMode(String userid) {
		
		System.out.println("MultiMode 클래스");
		JPanel panel = new JPanel();
		panel.setLayout(null); //
		JLabel label = new JLabel("TEXT");
		f1 = new Font("Malgun gothic",Font.BOLD,27);
		label.setFont(f1);
		
		JButton bt = new JButton("방 만들기");
		JButton bt2 = new JButton("방 참여");
		
		label.setBounds(215, 165, 300, 50); 
		bt.setBounds(80,256,155,45);
		bt2.setBounds(273,256,155,45);
	
		add(label);
		add(bt);
		add(bt2);
		add(panel);
		setSize(700,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("게임모드 선택");
		setVisible(true);
		
		//방 만들기 클릭
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CreateRoom(userid);
			}
		});
		
		//방 참여 클릭
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MultiMode(userid);
				
			}
			
		});
	}
}
