package gui_190930;

import javax.swing.JFrame;

public class myframe extends JFrame {
//생성자
	
	public myframe() {
		setTitle("사각형그리기");
		setSize(550,670);
		setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		
		//내가 만든 패널을 프레임에 추가하자
		MyPanel panel = new MyPanel();
		add(panel);
		this.addKeyListener(panel);
		this.requestFocus();

		setVisible(true);
	}
}