import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main extends JFrame {
	//공통 변수 모음
	Image img = null;
	private Font f1,f2,f3,f4; //폰트 설정
	Connection con;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	String dbid = "";
	String dbpw = "";
	String sql="";
	
	//생성자
	public Main() {
		DBManager dbManager;
		dbManager = new DBManager();
		JPanel panel = new JPanel(); 
		panel.setLayout(null); 
		
		JLabel ImageLabel = new JLabel(new ImageIcon("src/imgs/back.png"));
		add(ImageLabel);
		
		f1 = new Font("Malgun gothic",Font.BOLD,20); 
		JLabel t1 = new JLabel("그림퍼즐맞추기에 오신것을 환영합니다."); 
		t1.setFont(f1);
		add(t1);
		
		f2 = new Font("Malgun gothic",Font.PLAIN,16);
		JLabel t2 = new JLabel("아이디");
		t2.setFont(f1);
		add(t2);
		
		JLabel t3 = new JLabel("비밀번호");
		t3.setFont(f1);
		add(t3);
		
		JTextField txf = new JTextField();
		add(txf);
		JPasswordField txf2 = new JPasswordField();
		add(txf2);
		
		JButton bt = new JButton("로그인");
		add(bt);
		JButton bt2 = new JButton("회원가입");
		add(bt2);
		
		ImageLabel.setBounds(-3, -120, 700, 600); //이미지 위치
		t1.setBounds(130, 366, 380,20);
		t2.setBounds(115, 448, 100,20);
		t3.setBounds(90, 487, 110,20);
		txf.setBounds(200, 445, 200, 30);
		txf2.setBounds(200, 485, 200, 30);
		bt.setBounds(430, 445, 90, 30);
		bt2.setBounds(430, 485, 90, 30);
		
		add(panel);
		setSize(700,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("퍼즐맞추기 환영합니다.");
		setVisible(true);
		
		//로그인 버튼 누를때
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbManager.connect();
				dbManager.loginok(txf.getText());
			}
		});//로그인 버튼 리스터 끝
		
		
		//회원가입 버튼 클릭 시
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberAdd memadd = new MemberAdd();
			}
		});// 회원가입 버튼 리스너 끝
		
	} //생성자 끝
	public static void main(String[] args) {
		new Main();
	}
}
