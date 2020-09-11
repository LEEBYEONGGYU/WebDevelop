

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

import javax.swing.JFrame;
class MyThread extends Thread {
	MyPanel panel;
	public MyThread(MyPanel a) {
		this.panel = a;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.repaint();
		}
	}
}



public class MyFrame extends JFrame{
	// Constructor
	public MyFrame() {
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel panel = new MyPanel();
		this.addKeyListener(panel);
		add(panel);
		this.requestFocus();
		MyThread myThead = new MyThread(panel);
		myThead.start();
		setVisible(true);
	}
}
