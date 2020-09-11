

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Myframe extends JFrame{
	public Myframe() {
		//1. J�������� �̿��ؼ� 
				//JFrame frame = new JFrame("BK");
				setTitle("Turn OFF!!!");
				setSize(600, 400); //ũ��
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����
				
				//�������� ���̾ƿ��� �����Ѵ�
				
				setLayout(new FlowLayout(FlowLayout.TRAILING,50,50)); //LEADING �������� TRAILING ������ ����
				
				//��ư �߰�
				JButton button = new JButton("��ư");
				add(button);
				
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
				add(jTextField);
				
				//������ �г� ��ü�� �����̳ʿ� �߰���
				add(Jpanel);
				setVisible(true); //GUIǥ�ÿ���
	}
}
public class WDB {

	public static void main(String[] args) {
		Myframe fr = new Myframe();
		
	}

}
