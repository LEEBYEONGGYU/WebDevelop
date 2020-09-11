package gui_191004_v2;

import java.awt.Color;
import java.awt.Graphics;

public class MyRect {
	int x, y, w, h;
	Color c;
	
	public MyRect(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	public void draw( Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, w, h);
	}
	
}
