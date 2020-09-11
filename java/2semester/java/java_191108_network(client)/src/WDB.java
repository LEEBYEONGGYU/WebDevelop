import java.io.IOException;
import java.io.*;
import java.net.*;

public class WDB {

	public static void main(String[] args) {
		//1. 소켓을 생성한다(서버와 주소랑 포트를 열어야한다)
		try {
			Socket socket = new Socket("39.127.8.230",320);
			//2. 소켓을 이용하여 서버에 ㄷ이터를 보낸다
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("나여");
			//3. 소켓을 종료한다
			pw.close();
			socket.close();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	

	}

}
