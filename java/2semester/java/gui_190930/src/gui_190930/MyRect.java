package gui_190930;

import java.awt.Graphics;
import java.awt.Color;

public class MyRect {
   int x, y, w, h;
   Color c;
   
   // ������
   public MyRect(int x, int y, int w, int h, Color c) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.c = c;
   }
   
   public void draw(Graphics g) {
      g.setColor(c);
      g.fillRect(x, y, w, h);
   }
   public void draw2(Graphics g) {
	      g.setColor(c);
	      g.fillRect(x, y, w, h);
	   }
   // ���� �ٲپ��ִ� setter

   public void setC(Color c) {
      this.c = c;
   }
   
   
}