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

//�г��� �̿��� �׸��������

public class test extends JPanel implements MouseListener {
 
 int count=0,game[];  // count : ��������, game : ���� ����� ��
 int row=4,col=4;  // ��, ��
 Image original;   // ���� �̹���
 BufferedImage img[];  // ���� �̹����� �߶� ������ �迭
 int width,height;   // �߶� �׸� 1���� ũ��
 int clickCount,oldNum;  // Ŭ���� ī��Ʈ, ������ Ŭ���� ��ġ
 
 
 public test() {
  
  // ���� �׸� �б�
  MediaTracker tracker = new MediaTracker(this);    ////�̹������� ����Ǵ� �����忪�� �ܵ�����ؾ���
   /* �̹����� �÷����µ��� �κ������� �������°��� �����ִ�. �̷������� �����ϱ����� MediaTracker�� ����Ѵ�.
      MediaTracker�� �׸��� ������ �÷����� ���̹����� �����ش�.  */

  original = Toolkit.getDefaultToolkit().getImage("1.jpg");                                //1.jpg��� �׸������� ������Ʈ �ȿ� �־�� ��
  tracker.addImage(original, 0);
     try { 
      tracker.waitForAll();       //waitForAll(); : Starts loading all images tracked by this media tracker.
     } catch (InterruptedException e) { ; }
     width = original.getWidth(this)/col;
     height = original.getHeight(this)/row;
     setSize(new Dimension(width*col,height*row));
     
     // �̹����� �߶� ����
     img = new BufferedImage[row*col];
     int cnt=0;
     for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
       img[cnt] = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
       Graphics g = img[cnt].getGraphics();
       
       // �����̹������� �ʿ��� �κи� �߶� �׸���
       g.drawImage(original, 0, 0,  width, height,    //�׷��� ��ġ
             j*width, i*height,(j+1)*width, (i+1)*height,this);  //�׸��� �߶󳾺κ�
       cnt++;
      }
     }
   
     shuffle();    //���� ����
  addMouseListener(this); // ���콺 ������ ���
  setVisible(true);
 }
 
 
 //game�迭�� ���� ����
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
 
 
 // �׸��� �ڵ忡 paint�� �����ش�.
 public void paint(Graphics g) {
  int cnt=0;
  for(int i=0;i<row;i++){
   for(int j=0;j<col;j++){
    g.drawImage(img[game[cnt]],
     j*width, i*height, (j+1)*width, (i+1)*height, //�׷�����ġ
     0,0,width,height,this);       //�߶󳾺κ�
    cnt++;
   }
  }
 }
 public static void main(String[] args) {
  test pane = new test();
  JFrame frame = new JFrame("�׸����� ");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(pane.width*pane.col, pane.height*pane.row);
  frame.setResizable(false);     //�������� ũ�⸦ �����Ҽ� ����(false)
  Container panel = frame.getContentPane();
  panel.add(pane);
  frame.setVisible(true);
 }
 
 // ���콺 ������ ����
 public void mouseClicked(MouseEvent e) {
  int x = e.getX();   // x��ǥ
  int y = e.getY();   // y��ǥ
  int r = y/height;   // �׸� �Ѱ��� ���̷� ������
  int c = x/width;   // �׸� �Ѱ��� ������ ������
  int imgNo = r*row + c;  // �迭 ÷��
  String coord = "(" + x + ", " + y  + 
    ") - (" + r + ", " + c + ") - " + imgNo + " : " + game[imgNo]; 
  System.out.println(coord);
  
  //=======================================================
  
  if(clickCount==0){ // ù��° Ŭ���̸�
   clickCount++;
      oldNum = imgNo;
  }else{ // �ι�° Ŭ���̸�
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
 
 
 // ���� ���Ḧ Ȯ���ϴ� �޼ҵ�
 private void endGame() {
  boolean endGame = true;
  for(int i=0; i<game.length; i++){
   if(i != game[i]){
    endGame = false;
   }
  }
  if(endGame){         //if(���ǽ�)���� ���ǽ��� true�� if������
   JOptionPane.showMessageDialog(this, "�¸�");
   //���� ������� Ȯ��
   int reStart = JOptionPane.showConfirmDialog(this, "�ٽ� ����?", "����Ȯ��", JOptionPane.YES_NO_OPTION);
   if(reStart == JOptionPane.YES_OPTION){
    //�迭�� �ٽ� ���� �ٽ� �׸��⸦ �Ѵ�
    shuffle();   //����
    repaint();   //�ٽ� �׸���
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