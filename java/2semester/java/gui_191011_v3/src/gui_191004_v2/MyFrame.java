package gui_191004_v2;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	// Constructor
	public MyFrame() {
		setSize(1000, 600); //������ ũ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame�� �⺻������ CLOSE�� �߰��Ѵ�
		
		MyPanel panel = new MyPanel(); //MyPnael ��ü ����
		this.addKeyListener(panel); //���� Ű ������ panel�� ����
		add(panel); //panel�߰�
		this.requestFocus(); //���� ��Ŀ���� ��û
		setVisible(true); //GUIǥ��
	}
}


//�������� ���¿� � ������ �Ѵ�~~~~ ���������������S��