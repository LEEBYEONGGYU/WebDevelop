package gui_0923;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
//�̺�Ʈ ó��
//1. �̺�Ʈ ������ Ŭ������ �ۼ��Ѵ�(�̺�Ʈ�� �߻����� �� ó���ϴ� �޼ҵ�(ActionPerformed�� �����ϴ� �κ�)
//�߻�޼���� �ٵ� ���������Ѵ�
class MyListener implements ActionListener{
	int cnt=0;
	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ ��ü�� ���� � ��ư�� ���������� �˾ƿ´�.
		
		Object o = e.getSource();
		JButton button = (JButton)o;//���� �� ��ȯ
		
		cnt++;
		//��ư�� �ؽ�Ʈ�� �ٲ۴�
		//button.setText("X");
		
		int a = cnt%2;
		//Ŭ��Ƚ���� ����
		if(a==1) {
			button.setText("X");


		}else{
			button.setText("O");
		}
		
	}
}
*/
//2. �̺�Ʈ �����ʸ� �̺�Ʈ �ҽ��� ����Ѵ�
public class MyFrame extends JFrame {
	private JButton button;
	public MyFrame() {
		setSize(300, 200);
		setTitle("�̺�Ʈ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		button = new JButton("O");
		JLabel label = new JLabel();
		
		//�̺�Ʈ�� �������ִ� �۾���~
		//�ܺ�Ŭ���� button.addActionListener(new MyListenerin());
		//����Ŭ����button.addActionListener(new MyListenerin());
		
		add(button);
		add(label);
		
		setVisible(true);
	}
	
	//�̺�Ʈ ������ Ŭ������ ���� Ŭ������ �����ϴ� ���
	//MyFrameŬ������ ��� ������ ���ϰ� ���� �� �� �ִ�. 
	class MyListenerin implements ActionListener{
		int cnt=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			//�̺�Ʈ ��ü�� ���� � ��ư�� ���������� �˾ƿ´�.
			
			Object o = e.getSource();
			JButton button = (JButton)o;//���� �� ��ȯ
			
			cnt++;
			//��ư�� �ؽ�Ʈ�� �ٲ۴�
			//button.setText("X");
			
			int a = cnt%2;
			//Ŭ��Ƚ���� ����
			if(a==1) {
				button.setText("X");


			}else{
				button.setText("O");
			}
			
		}
	}
}
