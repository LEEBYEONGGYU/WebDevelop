package gui_0920;

import javax.swing.JFrame;

public class myframe extends JFrame {
//������
	
	public myframe() {
		setTitle("�簢���׸���");
		setSize(600,800);
		setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		
		//���� ���� �г��� �����ӿ� �߰�����
		Mypanel panel = new Mypanel();
		add(panel);
		
		setVisible(true);
	}
}