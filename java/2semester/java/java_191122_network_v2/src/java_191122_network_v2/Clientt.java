package java_191122_network_v2;




import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Clientt {

   public static void main(String[] args) {
       // 클라이언트 : 서버에 접속하여 여러 메시지를 보낼 수 있다
// exit를 입력하면 서버에 eit를 보내고 close하고 종료한다
      Scanner input = new Scanner(System.in);
      String data=null;
      // 1. 소켓생성
      try {
         Socket socket = new Socket("127.0.0.1",320);
         OutputStream os = socket.getOutputStream();
         PrintWriter pw = new PrintWriter(os);
         while(true){
         // 2. 키보드로 부터 내용을 입력받는다.
         data=input.next();
          pw.write(data);
            pw.flush();
            System.out.println("클라이언트 데이터 전송완료");
         // 3. exit 메세지가 나오면 종료, 그러치 않으면 서버에 전송 
         if(data.equals("exit")) {
            break;
         }else {
            // 4. 서버에 데이터를 보낸다.   
         }
         }
          pw.close();
         
      } catch (UnknownHostException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   
}
}