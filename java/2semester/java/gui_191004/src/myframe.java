

import javax.swing.JFrame;

public class myframe extends JFrame {
//������
	
	public myframe() {
		setTitle("�簢���׸���");
		setSize(1300,800);
		setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		
		//���� ���� �г��� �����ӿ� �߰�����
		MyPanel panel = new MyPanel();
		add(panel);
		this.addKeyListener(panel);
		this.requestFocus();

		setVisible(true);
	}
}