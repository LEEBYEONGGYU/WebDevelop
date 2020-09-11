package gui_0923_v2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class MyFrame extends JFrame implements KeyListener{
	JButton button1;
	JButton button2;
	JButton button3;
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	
	public MyFrame() {
		setSize(600, 300);
		setTitle("BK");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		button1 = new JButton("노란색");
		button2 = new JButton("핑크색");
		button3 = new JButton("검은색");
		MyListener myListener = new MyListener();
		
		//2. 연결
		button1.addActionListener(myListener);
		button2.addActionListener(myListener);
		panel.addKeyListener(this);
		//button3.addActionListener(myListener);

		//레이아웃잡기
//		panel.setLayout(new FlowLayout());
//		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
//		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		this.add(panel);
		panel.setFocusable(true);
		setVisible(true);
	}
	//내부 클래스
	class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("이벤트 리스너가 실행됨");
			
			if(e.getSource()==button1) {
				panel.setBackground(Color.yellow);
			}else{
				panel.setBackground(Color.pink);
			}
				panel.requestFocus();
			}
			
		}
		
	@Override
	public void keyPressed(KeyEvent e) {
		button3.setText(" "+e.getKeyChar());
		panel.setBackground(Color.black);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		button2.setText(" "+e.getKeyChar());
		panel.setBackground(Color.white);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		button1.setText(" "+e.getKeyChar());
		panel.setBackground(Color.black);
		
	}
}
