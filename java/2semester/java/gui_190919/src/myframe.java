

import javax.swing.JFrame;

public class myframe extends JFrame {
//������
	
	public myframe() {
		setTitle("BK�� �׸���");
		setSize(900,1000);
		setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		
		//���� ���� �г��� �����ӿ� �߰�����
		Mypanel panel = new Mypanel();
		add(panel);
		
		setVisible(true);
	}
}