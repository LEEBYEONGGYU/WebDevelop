package ja_test;

import java.awt.*;
import javax.swing.*;

class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("GridLayoutTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 3));
		
		add(new JButton("button1"));
		add(new JButton("button2"));
		add(new JButton("button3"));
		add(new JButton("b4"));
		add(new JButton("Long button5"));
		pack();
		setVisible(true);
	}
	
}
public class WDB {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();

	}
}
