

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.*;

//����Ŭ���� : label�� �����ϱ� �����
class MyThread extends Thread {
	JLabel label;
	public MyThread(JLabel l) {
		this.label = l;
	}
	public void run() {
		super.run();
		for(int i=0; i<10; i++) {
			
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		label.setText(""+(10-i));
		}
	}
}

public class MyFrame extends JFrame {
	JLabel label;
	public MyFrame() {
		setTitle("ī��Ʈ�ٿ�");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("�̰Ž� ���̴�");
		label.setFont(new Font("Serif",Font.BOLD, 100));
		add(label);
		MyThread myThread = new MyThread(label);
		myThread.start();
		setVisible(true);
	}
	//���� Ŭ���� : label �����ϱⰡ ����
	
	
	
}
