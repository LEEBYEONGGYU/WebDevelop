package gui_190930;

import javax.swing.JFrame;

public class myframe extends JFrame {
//������
	
	public myframe() {
		setTitle("�簢���׸���");
		setSize(550,670);
		setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		
		//���� ���� �г��� �����ӿ� �߰�����
		MyPanel panel = new MyPanel();
		add(panel);
		this.addKeyListener(panel);
		this.requestFocus();

		setVisible(true);
	}
}