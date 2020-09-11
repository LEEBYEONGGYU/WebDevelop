

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Guiwork extends JFrame implements ActionListener{
   JLabel label�й�,label�̸�,label����,label����;
   JTextField tf�й�,tf�̸�,tf����,tf����;
    JButton b����, b�ҷ�����, b����, b����;
    JPanel panel1,panel2,panel3,panel4;
    
    ArrayList<Student> members;
    int position = -1;
    //������
    
   public Guiwork() {
   members = new ArrayList<Student>();
   setTitle("UI");
   setSize(400,400);   
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLayout(new GridLayout(3,4));
   panel1 = new JPanel(); panel2 = new JPanel();panel3 = new JPanel();
   panel4 = new JPanel();
   
   label�й� = new JLabel("�й�");
   label�̸� = new JLabel("�̸�");
   label���� = new JLabel("����");
   label���� = new JLabel("����");
   tf�й� = new JTextField("20191101");
   tf�̸� = new JTextField("ȫ�浿");
   tf���� = new JTextField("100");
   tf���� = new JTextField("100");
   b���� = new JButton("����"); b����.addActionListener(this);
   b�ҷ����� = new JButton("�ҷ�����"); b�ҷ�����.addActionListener(this);
   b���� = new JButton("����"); b����.addActionListener(this);
   b���� = new JButton("����"); b����.addActionListener(this);
   
   this.add(label�й�);
   this.add(tf�й�);
   this.add(label�̸�);
   this.add(tf�̸�);
   
   this.add(label����);
   this.add(tf����);
   this.add(label����);
   this.add(tf����);
   
   this.add(b����);
   this.add(b�ҷ�����);
   this.add(b����);
   this.add(b����);
   this.setFocusable(true);
   this.setVisible(true);
   }
   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.b����) {
           System.out.println("���� ��ư�� Ŭ���Ǿ����ϴ�. ");
           method����();
        } else if (e.getSource() == this.b�ҷ�����) {
           System.out.println("�ҷ����� ��ư�� Ŭ���Ǿ����ϴ�. ");
           method�ҷ�����();
        } else if (e.getSource() == this.b����) {
           System.out.println("���� ��ư�� Ŭ���Ǿ����ϴ�. ");
           method����();
        } else {
           System.out.println("���� ��ư�� Ŭ���Ǿ����ϴ�. ");
           method����();
        }
     }
    

   private void method����() {
      if(position == members.size() -1) {
         String st = "�� ���Դϴ�.";
         JOptionPane.showMessageDialog(null, st);
         return;
      }
        position++;
        Student s = members.get(position);
        tf����.setText("" + s.get����());
        tf����.setText("" + s.get����());
        tf�̸�.setText(s.get�̸�());
        tf�й�.setText("" + s.get�й�());
     }
   
   private void method����() {
      if(position == 0) {
         String st = "��ó���Դϴ�.";
         JOptionPane.showMessageDialog(null, st);
         return;
      }
      position--;
      Student s = members.get(position);
      tf����.setText("" + s.get����());
      tf����.setText("" + s.get����());
      tf�̸�.setText(s.get�̸�());
      tf�й�.setText("" + s.get�й�());
      

   }

   private void method����() {
      // TODO Auto-generated method stub
      // 1. Student��ü����
      Student s = new Student();
      // 2. �й�,�ؽ�Ʈ �ʵ忡 ã�� ������ Student��ü�� ����
      s.�й� = Integer.parseInt(tf�й�.getText());
      s.set�̸�(tf�̸�.getText());
      s.set����(Integer.parseInt(tf����.getText()));
      s.set����(Integer.parseInt(tf����.getText()));
      // 3. ������ ����� ��ü�� ArrayList�� ����
      members.add(s);
      method���();
      method��������();
      position++;
      
      tf�й�.setText(""+(s.get�й�()+1) );
   }

   private void method���() {
      for(Student s : members) {
         System.out.printf("%d,%s,%d,%d",s.�й�,s.�̸�,s.����,s.����);
         }
   }
   
   private void method��������() {
      
      DataOutputStream dos;
      BufferedOutputStream bos;
      FileOutputStream fos;
      
      try {
            fos = new FileOutputStream("d:\\member.bin");
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
            
            dos.writeInt(members.size());

            for(Student s : members) {
               dos.writeInt(s.get�й�());
               dos.writeUTF(s.get�̸�());
               dos.writeInt(s.get����());
               dos.writeInt(s.get����());
            }
            dos.close();
            
            
         } catch (Exception e) {
            e.printStackTrace();
         }
      
   }
   
    private void method�ҷ�����() {
      // TODO Auto-generated method stub
       DataInputStream dis;
      BufferedInputStream bis;
      FileInputStream fis;
      
      try {
            fis = new FileInputStream("d:\\member.bin");
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            
            int n = dis.readInt();
            System.out.format("������л���:" +"%d" + "\n", n);

            members.clear();
            Student s;
            for(int i=0; i<n; i++) {
               s = new Student();
               s.set�й�(dis.readInt());
               s.set�̸�(dis.readUTF());
               s.set����(dis.readInt());
               s.set����(dis.readInt());
               
               System.out.println(i+"��°:" + s.get�й�() + s.get�̸�() +
                     s.get����() + s.get����());
            }
            
         } catch (Exception e) {
            e.printStackTrace();
         }
   }
   
    
}
