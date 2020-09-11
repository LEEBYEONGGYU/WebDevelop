import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//패널을 이용한 그림퍼즐게임

public class test extends JPanel implements MouseListener {
 
 int count=0,game[];  // count : 증가변수, game : 실제 저장된 값
 int row=4,col=4;  // 행, 열
 Image original;   // 원본 이미지
 BufferedImage img[];  // 원본 이미지를 잘라 저장할 배열
 int width,height;   // 잘라낸 그림 1개의 크기
 int clickCount,oldNum;  // 클릭수 카운트, 이전에 클릭한 위치
 
 
 public test() {
  
  // 원본 그림 읽기
  MediaTracker tracker = new MediaTracker(this);    ////이미지에만 적용되는 쓰레드역할 단독사용해야함
   /* 이미지가 올려지는동안 부분적으로 보여지는것을 볼수있다. 이런현상을 방지하기위해 MediaTracker를 사용한다.
      MediaTracker는 그림이 완전히 올려지면 그이미지를 보여준다.  */

  original = Toolkit.getDefaultToolkit().getImage("1.jpg");                                //1.jpg라는 그림파일을 프로젝트 안에 넣어야 함
  tracker.addImage(original, 0);
     try { 
      tracker.waitForAll();       //waitForAll(); : Starts loading all images tracked by this media tracker.
     } catch (InterruptedException e) { ; }
     width = original.getWidth(this)/col;
     height = original.getHeight(this)/row;
     setSize(new Dimension(width*col,height*row));
     
     // 이미지를 잘라 넣자
     img = new BufferedImage[row*col];
     int cnt=0;
     for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
       img[cnt] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
       Graphics g = img[cnt].getGraphics();
       
       // 원본이미지에서 필요한 부분만 잘라서 그리기
       g.drawImage(original, 0, 0,  width, height,    //그려질 위치
             j*width, i*height,(j+1)*width, (i+1)*height,this);  //그림을 잘라낼부분
       cnt++;
      }
     }
   
     shuffle();    //숫자 섞기
  addMouseListener(this); // 마우스 리스너 등록
  setVisible(true);
 }
 
 
 //game배열의 숫자 섞기
 private void shuffle() {
     game = new int[row*col];  
  Random rnd = new Random();
  for(int i=0;i<row*col;i++) game[i] = 0; 
  for(int i=0;i<row*col;i++){
   int temp = 0;
   do{
    temp = rnd.nextInt(row*col);
   }while(game[temp]!=0);
   game[temp] = i;
  }
  //System.out.println(Arrays.toString(game));
 }
 
 
 // 그리기 코드에 paint에 몰아준다.
 public void paint(Graphics g) {
  int cnt=0;
  for(int i=0;i<row;i++){
   for(int j=0;j<col;j++){
    g.drawImage(img[game[cnt]],
     j*width, i*height, (j+1)*width, (i+1)*height, //그려질위치
     0,0,width,height,this);       //잘라낼부분
    cnt++;
   }
  }
 }
 public static void main(String[] args) {
  test pane = new test();
  JFrame frame = new JFrame("그림퍼즐 ");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(pane.width*pane.col, pane.height*pane.row);
  frame.setResizable(false);     //프레임의 크기를 변경할수 없다(false)
  Container panel = frame.getContentPane();
  panel.add(pane);
  frame.setVisible(true);
 }
 
 // 마우스 리스너 구현
 public void mouseClicked(MouseEvent e) {
  int x = e.getX();   // x좌표
  int y = e.getY();   // y좌표
  int r = y/height;   // 그림 한개의 높이로 나눈다
  int c = x/width;   // 그림 한개의 폭으로 나눈다
  int imgNo = r*row + c;  // 배열 첨자
  String coord = "(" + x + ", " + y  + 
    ") - (" + r + ", " + c + ") - " + imgNo + " : " + game[imgNo]; 
  System.out.println(coord);
  
  //=======================================================
  
  if(clickCount==0){ // 첫번째 클릭이면
   clickCount++;
      oldNum = imgNo;
  }else{ // 두번째 클릭이면
   if(oldNum!=imgNo){
    int temp = game[oldNum];
    game[oldNum] = game[imgNo];
    game[imgNo] = temp;
    repaint();
   
    endGame();
   }
   clickCount = 0;
  }
 }
 
 
 // 게임 종료를 확인하는 메소드
 private void endGame() {
  boolean endGame = true;
  for(int i=0; i<game.length; i++){
   if(i != game[i]){
    endGame = false;
   }
  }
  if(endGame){         //if(조건식)에서 조건식이 true면 if문실행
   JOptionPane.showMessageDialog(this, "승리");
   //게임 재시작을 확인
   int reStart = JOptionPane.showConfirmDialog(this, "다시 시작?", "종료확인", JOptionPane.YES_NO_OPTION);
   if(reStart == JOptionPane.YES_OPTION){
    //배열을 다시 섞고 다시 그리기를 한다
    shuffle();   //섞기
    repaint();   //다시 그리기
   }else{
    System.exit(0);
   }
  }
 }
 public void mousePressed(MouseEvent e) {
  
 }
 public void mouseReleased(MouseEvent e) {
  
 }
 public void mouseEntered(MouseEvent e) {
  
 }
 public void mouseExited(MouseEvent e) {
  
 }
}