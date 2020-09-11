

import javax.swing.JFrame;

public class myframe extends JFrame {
//생성자
	
	public myframe() {
		setTitle("BK의 그리기");
		setSize(900,1000);
		setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		
		//내가 만든 패널을 프레임에 추가하자
		Mypanel panel = new Mypanel();
		add(panel);
		
		setVisible(true);
	}
}