package client;

import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.User;

public class RoomWindow extends JFrame {
	private JPanel contentPane;
	private JLabel me;
	public RoomWindow(User user, Socket socket) {
		
		setTitle("Yahtzee");
		setBounds(0,0,450,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		me = new JLabel(user.getNickname());
		add(me);
		setVisible(true);
	}
	
}
