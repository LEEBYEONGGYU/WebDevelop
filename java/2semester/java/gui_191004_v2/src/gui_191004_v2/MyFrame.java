package gui_191004_v2;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	// Constructor
	public MyFrame() {
		setSize(1000, 600); //사이즈 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame에 기본값으로 CLOSE를 추가한다
		
		MyPanel panel = new MyPanel(); //MyPnael 객체 생성
		this.addKeyListener(panel); //현재 키 반응을 panel에 넣음
		add(panel); //panel추가
		this.requestFocus(); //현재 포커스를 요청
		setVisible(true); //GUI표시
	}
}


//ㅋㅋㅋㅋ 유승우 운빨 ㅈ망겜 한다~~~~ 허허허허허허허헣허