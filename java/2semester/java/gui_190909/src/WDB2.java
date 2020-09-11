

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Myframe2 extends JFrame{
	public Myframe2() {
		//1. J�������� �̿��ؼ� 
				//JFrame frame = new JFrame("BK");
				setTitle("Turn OFF!!!");
				setSize(600, 400); //ũ��
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����
				
				//�������� ���̾ƿ��� �����Ѵ�
				setLayout(new BorderLayout()); 
				
				//��ư �߰�
				JButton button = new JButton("��ư");
				add(button,BorderLayout.PAGE_END);
				
				//�г��߰�
				JPanel Jpanel = new JPanel();
				
				//�гξȿ� ��ư
				JButton button1 = new JButton("�г��߰�");
				Jpanel.add(button1);
				
				//������ ����� ���´�
				int wh, hw;
				Toolkit kit = Toolkit.getDefaultToolkit();
				Dimension screenSize = kit.getScreenSize();
				wh = screenSize.width;
				hw = screenSize.height;
				System.out.println("width="+wh+" height="+hw);
				
				Image img = kit.getImage("d:\\off.png");
				setIconImage(img);
				
				//�гξȿ� ���̺��� �߰��Ѵ�
				JLabel jLabel = new JLabel("�гξȿ� ��");
				//JLabel.add(jLabel);
				
				//�����ӿ� �ؽ�Ʈ(�Է��� ����)
				JTextField jTextField = new JTextField();
				jTextField.setText("�ؽ�Ʈ�ʵ�");
				add(jTextField,BorderLayout.PAGE_START);
				
				//������ �г� ��ü�� �����̳ʿ� �߰���
				add(Jpanel,BorderLayout.LINE_START);
				
				//��ư 2�� �߰���
				JButton button2 = new JButton("�߰�");
				add(button2, BorderLayout.CENTER);
				//��ư3�� �����ʿ� LINE_END
				JButton button3 = new JButton("�߰�");
				add(button3, BorderLayout.LINE_END);
				
				setVisible(true); //GUIǥ�ÿ���
	}
}
public class WDB2 {

	public static void main(String[] args) {
		new Myframe2();
		
	}

}
