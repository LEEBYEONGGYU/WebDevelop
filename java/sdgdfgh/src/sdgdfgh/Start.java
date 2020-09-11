package sdgdfgh;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Start {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
 //     new CheatingEngine(6000,6000, "172.26.3.162");
	   new wdb("bk",9001,"172.26.3.162");
   }

}

class CheatingEngine extends JFrame implements Runnable, ActionListener{

   private static final long serialVersionUID = 1L;
   
   private JTextArea TakeF;
   private JTextField GiveF;
   private JButton button;
   
   private int send;
   private int recive;
   
   private DatagramSocket socket;
   private DatagramPacket sendPacket;
   private DatagramPacket recivePacket;
   
   private InetAddress address;
   
   public CheatingEngine(int my, int other, String addr) {
      
      this.send=other;
      this.recive=my;
      
      System.out.println("start!!");
      
      TakeF = new JTextArea();
      GiveF = new JTextField(); 
      button = new JButton("send");
      
      try {
         socket = new DatagramSocket(recive);
         address = InetAddress.getByName(addr);
      } catch (UnknownHostException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SocketException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      new Thread(this).start();
      
      System.out.println("middle");
      
      this.add(TakeF, BorderLayout.CENTER);
      this.add(GiveF, BorderLayout.SOUTH);
      this.add(button, BorderLayout.NORTH);
      
      System.out.println("bottom");
      
      button.addActionListener(this);
      
      this.setSize(500, 500);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
   
   public void run() {
      while (true) {
         byte[] buf = new byte[256];
         try {
            recivePacket = new DatagramPacket(buf, buf.length);
            socket.receive(recivePacket);
            TakeF.append("Re : " + new String(buf) + "\n");
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      
      System.out.println("in");
      if(e.getSource()==button) {
         String s = GiveF.getText();
         byte[] buffer = s.getBytes();
         try {
            sendPacket = new DatagramPacket (buffer, buffer.length, address, send);
            socket.send(sendPacket);
            TakeF.append("send : " + s + "\n");
            GiveF.selectAll();
            GiveF.setText("");
         } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      }
      
   }
}