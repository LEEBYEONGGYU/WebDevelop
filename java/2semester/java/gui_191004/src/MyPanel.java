

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener{
   final int ROWS = 120;
   final int COLS = 200;
   MyRect rects[][];   // 사각형 객체를 12x10개 만든다.
   
   int shape[][] = {{100,60},{100,59},{100,58},{100,57},{100,56},{100,55},{100,54},{100,53},{100,52},{100,51}};
   // 생성자 myrect 객체 120개를 만든다.
   
   final int CATER_SIZE = 20;
   int cater[][] = {{60,100},{59,100},{58,100},{57,100},{56,100},{55,100},{54,100},{53,100},{52,100},{51,100}};
   public MyPanel() {
      rects = new MyRect[ROWS][COLS];
      for(int i=0; i<ROWS; i++) {
         for(int j=0; j<COLS; j++) {
        	 if(i==0 || i==ROWS-1 || j==0 || j==COLS-1) {
        		 rects[i][j] = new MyRect(j*6, i*6, 5, 5, Color.red);
        	 }else {
        		 rects[i][j] = new MyRect(j*6, i*6, 5, 5, Color.yellow);
        	 }
         }
      }
   }
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      for(int i=0; i<10; i++) {
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
for(int i=0; i<10; i++) {
	  rects[shape[i][0]] [shape[i][1]].setC(Color.yellow);
  }
	if(input==40) {
		for(int i=0; i<10; i++) {
			  shape[i][0]+=1;
		  }

		//방향키 위에꺼
	}else if(input==38) {
		for(int i=0; i<10; i++) {
			
			 cater[0][i]+=1;
		    }
	}else if(input==37) {
		for(int i=0; i<10; i++) {
		  	  shape[i][1]-=1;
		    }

		//방향키 오른쪽꺼
	}else if(input==39) {
		for(int i=0; i<10; i++) {
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