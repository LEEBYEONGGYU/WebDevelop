import java.io.IOException;
import java.io.*;
import java.net.*;

public class WDB {

	public static void main(String[] args) {
		//1. ������ �����Ѵ�(������ �ּҶ� ��Ʈ�� ������Ѵ�)
		try {
			Socket socket = new Socket("39.127.8.230",320);
			//2. ������ �̿��Ͽ� ������ �����͸� ������
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("����");
			//3. ������ �����Ѵ�
			pw.close();
			socket.close();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	

	}

}
