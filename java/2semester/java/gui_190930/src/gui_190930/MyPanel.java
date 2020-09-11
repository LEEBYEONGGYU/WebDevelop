package gui_190930;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
//implements �������̽� ���
public class MyPanel extends JPanel implements KeyListener{
   final int ROWS = 12;
   final int COLS = 10;
   MyRect rects[][];   // �簢�� ��ü�� 12x10�� �����.
   int shape[][] = {{2,5},{3,4},{3,5},{3,6}};
   // ������ myrect ��ü 120���� �����.
   
   public MyPanel() {
      rects = new MyRect[ROWS][COLS];
      for(int i=0; i<ROWS; i++) {
         for(int j=0; j<COLS; j++) {
        	 if(i==0 || i==ROWS-1 || j==0 || j==COLS-1) {
        		 rects[i][j] = new MyRect(j*51, i*51, 50, 50, Color.blue);
        	 }else {
        		 rects[i][j] = new MyRect(j*51, i*51, 50, 50, Color.yellow);
        	 }
         }
      }
   }
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      for(int i=0; i<4; i++) {
    	  rects[shape[i][0]] [shape[i][1]].setC(Color.red);
      }
      
      for(int i=0; i<ROWS; i++) {
    	  for(int j=0; j<COLS; j++) {
    		  rects[i][j].draw(g);
            }
         }
       addKeyListener(this);
   }

@Override
public void keyPressed(KeyEvent e) {
int input = e.getKeyCode();
	if(input==40) {
		for(int i=0; i<4; i++) {
		  	  rects[shape[i][0]] [shape[i][1]].setC(Color.yellow);
		  	  shape[i][0]+=1;
		    }
		
	}else if(input==38) {
		for(int i=0; i<4; i++) {
		  	  rects[shape[i][0]] [shape[i][1]].setC(Color.yellow);
		  	  shape[i][0]-=1;
		    }
	}else if(input==37) {
		for(int i=0; i<4; i++) {
		  	  rects[shape[i][0]] [shape[i][1]].setC(Color.yellow);
		  	  shape[i][0]-=1;
		    }
	}else if(input==39) {
		for(int i=0; i<4; i++) {
		  	  rects[shape[i][0]] [shape[i][1]].setC(Color.yellow);
		  	  shape[i][1]+=1;
		    }
	}
	
	repaint();
}

@Override
public void keyReleased(KeyEvent arg0) {
	
	
}

@Override
public void keyTyped(KeyEvent arg0) {

	
}
}