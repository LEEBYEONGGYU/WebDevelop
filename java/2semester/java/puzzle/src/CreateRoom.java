import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class CreateRoom extends JFrame{
	private Font f1,f2,f3,f4;
	 int count=0,game[];  // count : 증가변수, game : 실제 저장된 값
	 int row=4,col=4;  // 행, 열
	 Image original;   // 원본 이미지
	 BufferedImage img[];  // 원본 이미지를 잘라 저장할 배열
	 int width,height;   // 잘라낸 그림 1개의 크기
	 int clickCount,oldNum;  // 클릭수 카운트, 이전에 클릭한 위치
	 int level=0;
	Connection con;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;

	String uid = "";
	String picname = "";
	 static String timerBuffer; // 04:11:15 등의 경과 시간 문자열이 저장될 버퍼 정의
	 static int oldTime; // 타이머가 ON 되었을 때의 시각을 기억하고 있는 변수
	public CreateRoom(String userid) {
		System.out.println("Level_select클래스"+userid);
		JPanel panel = new JPanel();
		panel.setLayout(null); //
		JLabel label = new JLabel("난이도를 선택하세요");
		f1 = new Font("Malgun gothic",Font.BOLD,27);
		label.setFont(f1);
		
		JButton bt = new JButton("쉬움");
		JButton bt2 = new JButton("어려움");
		JButton bt3 = new JButton("매우 어려움");
		
		label.setBounds(215, 165, 300, 50); 
		bt.setBounds(80,256,155,45);
		bt2.setBounds(273,256,155,45);
		bt3.setBounds(463,256,155,45);
		add(label);
		add(bt);
		add(bt2);
		add(bt3);
		add(panel);
		setSize(700,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("게임모드 선택");
		setVisible(true);
		
		//쉬움클릭 4x4
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Picture_Select(userid,4);
			}
		});
		
		//어려움 클릭 6x6
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Picture_Select(userid,6);
				
			}
			
		});
		
		//매우어려움 클릭 8x8
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Picture_Select(userid,8);
				
				
			}
			
		});
	}
}
