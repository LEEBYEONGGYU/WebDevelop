package gui_0920;

import java.awt.Color;
import java.awt.Graphics;

public class MyRect extends Mypanel{
	int a,b,c,d;
	Color e;
	public MyRect(int q, int w, int e, int r,Color o) {
		this.a=q;
		this.b=w;
		this.c=e;
		this.d=r;
		this.e=o;
	}

	public void draw(Graphics g) {
			g.setColor(e);
			g.fillRect(a, b, c, d);
	}
	public void draw2(Graphics g) {
		g.setColor(e);
		g.fillRect(a, b, c, d);
}
	public void draw3(Graphics g) {
		g.setColor(e);
		g.fillRect(a, b, c, d);
}
	public void draw4(Graphics g) {
		g.setColor(e);
		g.fillRect(a, b, c, d);
}

}
