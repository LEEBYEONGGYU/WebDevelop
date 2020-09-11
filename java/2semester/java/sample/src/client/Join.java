package client;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.User;

public class Join extends JFrame {

	private JPanel contentPane;
	private JLabel lb_id, lb_pass, lb_name, lb_nickname, lb_email, lb_title;
	private JTextField tf_id, tf_name, tf_nickname, tf_email;
	private JPasswordField tf_pass;
	private JButton bt_dupCheck, bt_join, bt_cancel;
	private GridBagConstraints gc;
	private GridBagLayout layout;

	public Join(LoginWindow pane, Socket socket) {
		setBounds(0, 0, 300, 220);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.BLACK);
		layout = new GridBagLayout();
		setLayout(layout);
		gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(4, 4, 4, 4);
		lb_id = new JLabel("아이디", JLabel.CENTER);
		lb_id.setForeground(Color.white);
		lb_pass = new JLabel("비밀번호", JLabel.CENTER);
		lb_pass.setForeground(Color.WHITE);
		lb_name = new JLabel("이름", JLabel.CENTER);
		lb_name.setForeground(Color.WHITE);
		lb_nickname = new JLabel("별명", JLabel.CENTER);
		lb_nickname.setForeground(Color.WHITE);
		lb_email = new JLabel("이메일", JLabel.CENTER);
		lb_email.setForeground(Color.WHITE);
		lb_title = new JLabel("회원가입", JLabel.CENTER);
		lb_title.setForeground(Color.WHITE);

		tf_id = new JTextField();
		tf_pass = new JPasswordField();
		tf_name = new JTextField();
		tf_nickname = new JTextField();
		tf_email = new JTextField();

		bt_dupCheck = new JButton("중복확인");
		bt_dupCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dupCheck(socket);
			}
		});
		bt_cancel = new JButton("취소");

		addC(lb_title, 0, 0, 3, 1, 0.1);
		addC(lb_id, 0, 1, 1, 1, 0.1);
		addC(tf_id, 1, 1, 1, 1, 0.6);
		addC(bt_dupCheck, 2, 1, 1, 1, 0.1);
		addC(lb_pass, 0, 2, 1, 1, 0.1);
		addC(tf_pass, 1, 2, 1, 1, 0.1);
		addC(lb_name, 0, 3, 1, 1, 0.1);
		addC(tf_name, 1, 3, 1, 1, 0.1);
		addC(lb_nickname, 0, 4, 1, 1, 0.1);
		addC(tf_nickname, 1, 4, 1, 1, 0.1);
		addC(lb_email, 0, 5, 1, 1, 0.1);
		addC(tf_email, 1, 5, 1, 1, 0.2);

		bt_join = new JButton("회원가입");
		bt_join.setEnabled(false);
		bt_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String a = join(socket);
				if (a.equals("1")) {
					enable_login(pane);
				} else {
					JOptionPane.showMessageDialog(null, "작성내용을 확인해주세요");
				}
			}
		});
		bt_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enable_login(pane);
			}
		});
		addC(bt_cancel, 2, 6, 1, 1, 0.2);
		addC(bt_join, 1, 6, 1, 1, 0.2);

		setVisible(true);
	}

	private void addC(Component c, int x, int y, int w, int h, double wx) {
		gc.weightx = wx;
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = w;
		gc.gridheight = h;
		layout.setConstraints(c, gc);
		add(c);
	}

	private void dupCheck(Socket socket) {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);
			String request = "dupC::" + tf_id.getText();
			pw.println(request);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

			if (br.readLine().contentEquals("1")) {
				JOptionPane.showMessageDialog(null, "사용중인 아이디 입니다.");
				bt_join.setEnabled(false);
			} else {
				bt_join.setEnabled(true);
				JOptionPane.showMessageDialog(null, "사용하실 수 있는 아이디 입니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String join(Socket socket) {
		char[] pass = tf_pass.getPassword();
		String Apass = new String(pass);
		String isSuccess = null;
		String request = "join::" + tf_id.getText() + "::" + Apass + "::" + tf_name.getText() + "::"
				+ tf_nickname.getText() + "::" + tf_email.getText();

		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
			pw.println(request);
			isSuccess = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private void enable_login(LoginWindow pane) {
		pane.bt_login.setEnabled(true);
		pane.bt_pwf.setEnabled(true);
		pane.bt_idf.setEnabled(true);
		pane.bt_join.setEnabled(true);
		pane.tf_id.setEnabled(true);
		pane.tf_passwd.setEnabled(true);
		this.dispose();
	}
}
