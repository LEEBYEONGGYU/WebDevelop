package gui_190916;

import javax.swing.JFrame;

public class myframe extends JFrame {
//생성자
	
	public myframe() {
		setTitle("이병규의 돼지그리기");
		setSize(900,1000);
		setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		
		//내가 만든 패널을 프레임에 추가하자
		Mypanel panel = new Mypanel();
		add(panel);
		
		setVisible(true);
	}
}