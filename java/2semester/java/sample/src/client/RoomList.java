package client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import common.GameRoom;
import common.User;

public class RoomList extends JFrame {
	private ArrayList<GameRoom> rooms;
	private JLabel lb_title, lb_uInfo;
	private JPanel contentPane;
	private GridBagConstraints gc;
	private GridBagLayout layout;
	private JList<String> list;
	private DefaultListModel<String> rm;
	private JButton bt_create, bt_logout, bt_refresh;
	private ImageIcon background, titleimg;
	private Socket socket;
	private User user;
	public RoomList(User user, Socket socket) {
		this.socket = socket;
		this.user = user;
		setTitle("Yahtzee 대기실");
		setBounds(0, 0, 450, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, 450, 600, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		setContentPane(contentPane);
		contentPane.setBackground(Color.black);
		titleimg = new ImageIcon("img/title.png");
		lb_title = new JLabel(titleimg);
		// 레이아웃 기본 설정
		layout = new GridBagLayout();
		gc = new GridBagConstraints();
		setLayout(layout);
		gc.insets = new Insets(4, 4, 4, 4);
		background = new ImageIcon("img/loginWindow.jpg");
		// 방 목록 초기화
		rooms = new ArrayList<GameRoom>();
		rm = new DefaultListModel<>();
		ScrollPane sc = new ScrollPane();
		sc.setBounds(0, 0, 300, 400);
		refresh();

		// 라벨
		int win = user.getWin();
		int lose = user.getLose();
		double rates;
		if (win + lose == 0) {
			rates = 0;
		} else {
			rates = ((double) win / (double) (win + lose)) * 100;
		}

		lb_uInfo = new JLabel("<html>" + user.getNickname() + "<br>" + "승 : " + win + "<br>" + "패 : " + lose + "<br>"
				+ "승률 : " + rates + "<br>" + "최고 득점 : " + user.getHigh() + "<br></html>");
		lb_uInfo.setForeground(Color.white);
		list = new JList<String>(rm);

		// 버튼
		bt_logout = new JButton("로그아웃");
		// 로그아웃 버튼 액션
		bt_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginWindow();
				dispose();
			}
		});

		bt_create = new JButton("방 만들기");
		// 방만들기 버튼 액션
		bt_create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String rName = JOptionPane.showInputDialog(null, "방 제목을 입력해 주세요");
				createRoom(rName);
				System.out.println("방 만듬");
			}
		});
		// 새로고침
		bt_refresh = new JButton("새로 고침");
		bt_refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		
		list.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int index = list.getSelectedIndex();
//					rm.remove(index);
					int seq = rooms.get(index).getSeq();
					System.out.println(seq);
					enterRoom(seq);
				}
			}
		});

		sc.add(list);
		addC(bt_logout, 1, 3, 1, 1, 0.2);
		addC(lb_title, 0, 0, 2, 1, 0.2);
		addC(sc, 0, 1, 1, 4, 0.2);
		addC(lb_uInfo, 1, 4, 1, 1, 0.2);
		addC(bt_create, 1, 1, 1, 1, 0.1);
		addC(bt_refresh, 1,2,1,1,0.2);
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

	private void refresh() {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			String request = "getlist::";
			pw.println(request);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			rooms = (ArrayList<GameRoom>) ois.readObject();
			rm.clear();
			for (GameRoom r : rooms) {
				rm.addElement(r.getrName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("number of rooms : "+rooms.size());
		for(GameRoom r: rooms) {
			System.out.println(r.getrName());
		}
	}

	private void createRoom(String rName) {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);
			String request = "create::"+rName;
			pw.println(request);
			new RoomWindow(user, socket);
			dispose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void enterRoom(int seq) {
		int result =0;
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			String request = "enter::"+seq;
			pw.println(request);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			result = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//result 0-성공/1-꽉참/2-방없음
		if(result==0) {
			new RoomWindow(user, socket);
			dispose();
		}else if(result ==1) {
			JOptionPane.showMessageDialog(null, "방이 꽉 찼습니다.");
			refresh();
		}else {
			JOptionPane.showMessageDialog(null, "방이 존재하지 않습니다");
			refresh();
		}
	}
}
