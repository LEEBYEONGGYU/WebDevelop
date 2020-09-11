package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.User;

public class LoginWindow extends JFrame {
	private JPanel contentPane, loginPane, idPane, passPane, buttonPane, inputPane;
	private ImageIcon background, titleimg;
	private JLabel title, lb_id, lb_passwd, lb_blank;
	public JTextField tf_id;
	public JPasswordField tf_passwd;
	public JButton bt_login, bt_join, bt_idf, bt_pwf;
	private int x = 340, y = 400;

	private Socket socket;
	private static final String SERVER_IP = "172.26.1.182";
	private static final int SERVER_PORT = 8888;
	private User user;

	public LoginWindow() {
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("connected successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setBounds(100, 100, x, y);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension di = e.getComponent().getSize();
				x = di.width;
				y = di.height;
			}
		});

		// JPanel 설정
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, x, y, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		idPane = new JPanel();
		idPane.setOpaque(false);
		passPane = new JPanel();
		passPane.setOpaque(false);
		loginPane = new JPanel(new BorderLayout(10, 10));
		loginPane.setOpaque(false);
		buttonPane = new JPanel();
		buttonPane.setOpaque(false);
		inputPane = new JPanel(new GridLayout(0, 1));
		inputPane.setOpaque(false);

		// 이미지 처리
		background = new ImageIcon("img/loginWindow.jpg");
		titleimg = new ImageIcon("img/title.png");
		title = new JLabel(titleimg);
		contentPane.add(title);
		contentPane.setLayout(new GridLayout(0, 1));

		// 라벨, 텍스트 필드 설정
		lb_id = new JLabel("아이디");
		lb_id.setForeground(Color.WHITE);
		lb_passwd = new JLabel("패스워드");
		lb_passwd.setForeground(Color.WHITE);
		tf_id = new JTextField(10);
		tf_passwd = new JPasswordField(10);
		tf_passwd.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10)
					login();
			}
		});
		idPane.add(lb_id);
		idPane.add(tf_id);
		passPane.add(lb_passwd);
		passPane.add(tf_passwd);

		// 버튼 설정
		bt_login = new JButton("로그인");
		bt_join = new JButton("회원가입");
		bt_idf = new JButton("아이디 찾기");
		bt_pwf = new JButton("비밀번호 찾기");
		loginPane.add(bt_login, BorderLayout.EAST);
		buttonPane.add(bt_join);
		buttonPane.add(bt_idf);
		buttonPane.add(bt_pwf);
		
		// 버튼 액션
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		LoginWindow a = this;
		bt_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Join(a, socket);
				dis_login();
			}
		});

		bt_idf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dis_login();
				new forgetID(a, socket);
			}
		});

		bt_pwf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dis_login();
				new forgetPass(a,socket);
			}
		});
		// 패널 추가
		lb_blank = new JLabel();
		contentPane.add(lb_blank);
		inputPane.add(idPane);
		inputPane.add(passPane);
		loginPane.add(inputPane, BorderLayout.CENTER);
		loginPane.add(buttonPane, BorderLayout.SOUTH);
		contentPane.add(loginPane);
		setContentPane(contentPane);
		setVisible(true);

		// 서버 접속
		
	}

	private void login() {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),true);
			char[] pass = tf_passwd.getPassword();
			String request = "login::" + tf_id.getText() + "::" + new String(pass, 0, pass.length);
			pw.println(request);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			if (br.readLine().contentEquals("1")) {
				System.out.println("로그인 성공");
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				try {
					user = (User) ois.readObject();
					new RoomList(user, socket);
					dispose();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해주세요");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void dis_login() {
		bt_login.setEnabled(false);
		bt_pwf.setEnabled(false);
		bt_idf.setEnabled(false);
		bt_join.setEnabled(false);
		tf_id.setEnabled(false);
		tf_passwd.setEnabled(false);
	}
}
