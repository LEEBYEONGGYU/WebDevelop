
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;
public class Client{

final int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;

//툴킷으로 컴퓨터의 해상도를 받아옴 (화면 캡쳐에 필요해)

JFrame frame;

JTextField text;

JButton button;

//창, ip를 입력할 텍스트필드, 접속버튼


public static void main(String[] args) {

new Client();

//메인에서는 클라이언트 생성자만 실행시켜주면 됌

}


//메인에서 호출시킨 생성자부분

public Client() {

frame = new JFrame("Client"); //창 생성

frame.setBounds(0, 0, 300, 100);//창 위치,크기 조절

frame.setLayout(null); //레이아웃 없게 함.

//JFrame 윈도우창 초기화


text = new JTextField(); //텍스트공간 생성

text.setVisible(true); //보이

text.setBounds(25, 15, 100, 50);//위치 크기 조절

//ip를 입력할 텍스트필드 생성


button = new JButton("접속");

button.setVisible(true);

button.setBounds(125, 15, 50, 50);

button.addActionListener(new ActionListener() {

//액션리스너 익명클래로 버튼이 클릭되었을때 행동을 정해줘


@Override

public void actionPerformed(ActionEvent arg0) {

//이렇게 오버라이드 해서 일회용으로 생성해주는거야

// TODO Auto-generated method stub

Client.this.client_work();

//간단하게 밑에 클라이언트 기능을 합쳐놓은 메소드 호출

}

});

frame.add(text);

frame.add(button);

frame.setVisible(true);

//프레임(윈도우 창)에 텍스트공간하고 버튼을 추가한 후 보이게 설정.

}


//클라이언트의 기능들을 때려 박아놓은 창고

public void client_work() {

String serverip = text.getText();//텍스트상자에서 텍스트를 받아와서 넣음

Socket socket = null;

System.out.println("클라이언트 준비완료");//일단 소켓생성

try {

socket = new Socket(serverip, 12345);

//위에 텍스트상자에서 받아온 아이피로 접속

System.out.println("접속완료 - 클라이언트");


//BufferedImage image = new BufferedImage(1280, 720, BufferedImage.TYPE_3BYTE_BGR);

BufferedImage image; //스크린샷이 저장될 버퍼공간

Robot r = new Robot(); //스크린샷을 찍는 로봇클래스


BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());

//아웃풋스트림을 버퍼아웃풋으로

while(true) {

//image.getGraphics().drawImage(r.createScreenCapture(new Rectangle(0,0,w,h)).getScaledInstance(1280, 720, Image.SCALE_SMOOTH), 0, 0, null);

image = r.createScreenCapture(new Rectangle(0, 0, w, h));

//스크린샷을 찍어서 image에 저장해

ImageIO.write(image, "bmp", bout);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌

bout.flush();   //버퍼에 쓰인 이미지를 서버로 보냄

}

} catch (Exception e) {

e.printStackTrace(); //오류 처리

System.out.println("접속실패 - 클라이언트");

}

}

 

}