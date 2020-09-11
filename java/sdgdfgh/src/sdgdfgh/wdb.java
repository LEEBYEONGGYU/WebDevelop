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

public class wdb extends JFrame implements ActionListener, Runnable {

   private JTextArea area;
   private JTextField feild;
   private JButton button;

   private int port;
   private InetAddress address;

   private DatagramSocket sct;
   private DatagramPacket sPct;
   private DatagramPacket rPct;
   
   private byte[] buf1;
   private byte[] buf2;
   
   private String name;

   public wdb(String name, int port, String addr) {
      this.name =name;
      this.port = port;
      
      try {
         this.address = InetAddress.getByName(addr);
         this.sct = new DatagramSocket(port);
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (SocketException e) {
         e.printStackTrace();
      }

      new Thread(this).start();
      
      area= new JTextArea();
      feild= new JTextField();
      button= new JButton("보내기");
      
      button.addActionListener(this);
      
      this.add(area, BorderLayout.CENTER);
      this.add(feild, BorderLayout.SOUTH);
      this.add(button, BorderLayout.NORTH);
      
      this.setSize(500, 500);
      this.setResizable(false);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }

   @Override
   public void run() {
      while (true) {
         buf1  = new byte[256];

         try {
            rPct = new DatagramPacket(buf1, buf1.length);
            sct.receive(rPct);
            area.append(new String(buf1) + "\n");
         } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      }

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println("click!");
      if(e.getSource()==button) {
         buf2 = (name + " : " + feild.getText()).getBytes();
         
         try {
            sPct = new DatagramPacket(buf2, buf2.length, address, port);
            sct.send(sPct);
            area.append(new String(buf2));
            feild.selectAll();
            feild.setText("");
         } catch (IOException e2) {
            e2.printStackTrace();
         }
      }
   }

}