package java_191122_network_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class Client extends Thread{
	
   static Socket socket;

public  Client(Socket s) {
socket = s;
}
public void run() {
    //서버 : 각 클라이언트에 접속하는 socket에 대해 쓰레드로 처리한다
//각 쓰레드에서는 여러 메시지를 받아서 화면에 출력하고
//exit 메시지를 받으면 쓰레드를 종료한다
   super.run();

   try {
       ServerSocket serverSocket = new ServerSocket(320);
         Socket socket = null;
      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      
      String inLine = br.readLine();
      System.out.print(socket.getInetAddress()+":");
      
      System.out.println(inLine);
       System.out.println("서버켜짐");
      socket.close();
   }catch(IOException e) {
      e.printStackTrace();
   }
    
}

	
	
}
}
