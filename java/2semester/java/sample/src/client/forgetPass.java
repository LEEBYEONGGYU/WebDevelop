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
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class forgetPass extends JFrame {

	private JPanel contentPane;
	private JLabel lb_id, lb_email, lb_title;
	private JTextField tf_id, tf_email;
	private JButton bt_confirm, bt_cancel;
	private GridBagConstraints gc;
	private GridBagLayout layout;
	
	public forgetPass(LoginWindow pane, Socket socket) {
		setBounds(0, 0, 230, 180);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.black);
		layout = new GridBagLayout();
		setLayout(layout);
		gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(4, 4, 4, 4);
		lb_id = new JLabel("아이디", JLabel.CENTER);
		lb_id.setForeground(Color.WHITE);
		lb_email = new JLabel("이메일", JLabel.CENTER);
		lb_email.setForeground(Color.WHITE);
		lb_title = new JLabel("비밀번호 찾기", JLabel.CENTER);
		lb_title.setForeground(Color.white);

		tf_id = new JTextField();
		tf_email = new JTextField();
		
		bt_confirm = new JButton("찾기");
		bt_cancel = new JButton("취소");
		
		//버튼액션
		bt_confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
					String request = "f_pass::"+tf_id.getText()+"::"+tf_email.getText();
					pw.println(request);
					BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
					String response = br.readLine();
					if("1".contentEquals(response)) {
						String newpass = JOptionPane.showInputDialog(null,"새로운 비밀번호를 입력해 주세요");
						request = "c_pass::"+tf_id.getText()+"::"+newpass;
						pw.println(request);
						enable_login(pane);
					}else {
						JOptionPane.showMessageDialog(null, "입력 정보를 확인해 주세요");
					}
				}catch(IOException e1){
					e1.printStackTrace();
				}
				
			}
		});
		bt_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enable_login(pane);
			}
		});
		
		addC(lb_title,0,0,2,1,0.2);
		addC(lb_id,0,2,1,1,0.1);
		addC(tf_id,1,2,1,1,0.2);
		addC(lb_email,0,3,1,1,0.1);
		addC(tf_email,1,3,1,1,0.2);
		addC(bt_confirm,0,5,1,1,0.1);
		addC(bt_cancel,1,5,1,1,0.1);
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
