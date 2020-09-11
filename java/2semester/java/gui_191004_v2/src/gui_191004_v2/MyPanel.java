package gui_191004_v2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {
	MyRect rects[][];
	final int ROWS = 120;
	final int COLS = 200;
	final int SIZE = 5;
	final int CATER_SIZE = 99;
	int cater[][];

	public MyPanel() {
		cater = new int[CATER_SIZE][2];
		for (int i = 0; i < CATER_SIZE; i++) {
			cater[i][0] = 60;
			cater[i][1] = 150 - i;
		}

		rects = new MyRect[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (i == 0 || j == 0 || i == ROWS - 1 || j == COLS - 1) {
					rects[i][j] = new MyRect(j * SIZE, i * SIZE, SIZE - 1, SIZE - 1, Color.RED);
				} else {
					rects[i][j] = new MyRect(j * SIZE, i * SIZE, SIZE - 1, SIZE - 1, Color.YELLOW);
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				rects[i][j].draw(g);
			}
		}

		// draw cater
		// change color
		for (int i = 0; i < CATER_SIZE; i++) {
			// rects[60][100].setC(Color.BLUE);
			rects[cater[i][0]][cater[i][1]].setC(Color.BLUE);
			rects[cater[i][0]][cater[i][1]].draw(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 일단 기존 지렁이를 지운다.
		for (int i = 0; i < CATER_SIZE; i++) {
			rects[cater[i][0]][cater[i][1]].setC(Color.YELLOW);
		}

		
		// 지렁이의 맨끝에 위치에서 부터 이전 좌표값으로 설정한다.  
		for (int i = 0; i < CATER_SIZE - 1; i++) {
			cater[CATER_SIZE - i - 1][0] = cater[CATER_SIZE - i - 2][0];
			cater[CATER_SIZE - i - 1][1] = cater[CATER_SIZE - i - 2][1];
		}
		switch (e.getKeyCode()) {
		case 39:
			System.out.println("Right");
			cater[0][1] = cater[0][1] + 1;
			break;
		case 37:
			System.out.println("Left");
			cater[0][1] = cater[0][1] - 1;
			break;
		case 38:
			System.out.println("up");
			cater[0][0] = cater[0][0] - 1;
			break;
		case 40:
			System.out.println("down");
			cater[0][0] = cater[0][0] + 1;
			break;
		}

		// 새로 설정된 지렁이 위치의 MyRect의 색깔을 바꾼다.
		for (int i = 0; i < CATER_SIZE; i++) {
			rects[cater[i][0]][cater[i][1]].setC(Color.BLUE);
		}
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}