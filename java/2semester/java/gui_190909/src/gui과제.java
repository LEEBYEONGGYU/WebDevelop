import java.awt.*;
import javax.swing.*;

class Guiwork extends JFrame{
	public Guiwork() {
		
		// ������ ����
		setTitle("�̺���");
		setSize(400, 200); //ũ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����
		
		//�г��߰�
		JPanel panel;
		panel = new JPanel();
		JPanel panel2;
		panel2 = new JPanel(); 
		JPanel panel3;
		panel3 = new JPanel();
		JPanel panel4;
		panel4 = new JPanel();
		
		//�� panel ���̾ƿ� ����
		panel.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//�гο� ���̺�� �Է�ĭ �߰�
		JTextField jTextField = new JTextField(13);
		jTextField.setText("1601184");

		JTextField jTextField2 = new JTextField(10);
		jTextField2.setText("�� ");
		
		JTextField jTextField3 = new JTextField(28);
		jTextField3.setText("�̺���");
		
		JTextField jTextField4 = new JTextField(9);
		jTextField4.setText(" ");
		JTextField jTextField5 = new JTextField(9);
		jTextField5.setText(" ");
		JTextField jTextField6 = new JTextField(9);
		jTextField6.setText(" ");
		
		JButton button2 = new JButton("Ȯ��");
		panel4.add(button2);
		
		JButton button3 = new JButton("���");
		panel4.add(button3);
		
		 JLabel l1=new JLabel("�й� : "); //��1 ����
	     JLabel l2=new JLabel("���� : "); //��2 ����
	     JLabel l3=new JLabel("�̸� : "); //��3 ����
	     JLabel l4=new JLabel("�ּ� : "); //��3 ����
	     
	  // panel�� �й� �ؽ�Ʈ�ʵ�� ���� �ؽ�Ʈ �ʵ�
	     panel.add(l1);
	     panel.add(jTextField);
	     panel.add(l2);
	     panel.add(jTextField2);
	     
	   //panel2�� �̸� �ʵ�
	     panel2.add(l3);
	     panel2.add(jTextField3);
	     
	   //panel3�� �ּ��ʵ�
	     panel3.add(l4);
	     panel3.add(jTextField4);
	     panel3.add(jTextField5);
	     panel3.add(jTextField6);
	    
	   
	    JPanel npanel = new JPanel(); //�� panel ����
		npanel.add(panel); //npanel�� panel�� add��
		npanel.add(panel2);
		npanel.add(panel3);
		npanel.add(panel4);
		
		add(npanel); //��� npane�� add�Ѵ�.
		setVisible(true); //GUIǥ�ÿ���
	}
}

public class gui과제 {

	public static void main(String[] args) {
		new Guiwork();
			}
}
