

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class WDB {

   public static void main(String[] args) {
      
      try {
         ServerSocket serverSocket = new ServerSocket(320);
         Socket socket = null;
         
         while((socket = serverSocket.accept()) != null) {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            String inLine = br.readLine();
            System.out.println(socket.getInetAddress());
            System.out.println(inLine);
         }
         
      }catch(IOException e) {
         e.printStackTrace();
      }

   }
}