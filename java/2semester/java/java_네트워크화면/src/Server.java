

import java.awt.*;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;
public class Server {

final int w = 1280, h = 720;

final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

JFrame frame;

//������� �ػ󵵸� �޾ƿ��� â����


public static void main(String[] args) {

new Server(); //Ŭ���̾�Ʈ��İ� �Ȱ��� ������ ȣ��

}


public Server() {

frame = new JFrame("server");

frame.setBounds(x, y, w, h);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.setVisible(true);

//â�� �����


ServerSocket socket_s = null;

Socket socket = null;

try {

socket_s = new ServerSocket(12345);

socket = socket_s.accept();

System.out.println("접속했쪙" + socket);

//Ŭ���̾�Ʈ�� ������


BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());

//������ �Է½�Ʈ���� ���۽�Ʈ������

while(true) {

frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, w, h, frame);

//�̹����� �޾ƿ��� ���ÿ� ȭ�鿡 �׸�

}

} catch (Exception e) {

e.printStackTrace();

}

}

 

}