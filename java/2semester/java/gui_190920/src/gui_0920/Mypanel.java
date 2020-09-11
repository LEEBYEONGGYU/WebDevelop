package gui_0920;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Mypanel extends JPanel {

	protected void paintComponent(Graphics g) {		
		super.paintComponent(g);
		
		/* 단순 사각형 그리기
		g.setColor(Color.green);
		g.fillRect(50, 50, 50, 50);//x축, y축, width, height
		*/
		
		MyRect myRect;
		for(int i=0; i<14; i++) {
			for(int j=0; j<10; j++) {
				if(j==0 || j==9 || i==13) {
					myRect = new MyRect(10+51*j,10+51*i,50,50,Color.red);
				}else {
					myRect = new MyRect(10+51*j,10+51*i,50,50,Color.yellow);
				}
				myRect.draw(g);
			}
		}
	}
}