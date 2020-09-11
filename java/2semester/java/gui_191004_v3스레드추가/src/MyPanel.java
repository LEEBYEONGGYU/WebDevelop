

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
	int direction = 40;
	// int cater[][] = { {60,100}, {60,99}, {60,98}, {60,97}, {60,96}, {60,95},
	// {60,94}, {60,93}, {60,92}, {60,91} } ;
	final int CATER_SIZE = 99;
	int cater[][];
	private boolean isPressed;
	private int keyCode;
	

	public MyPanel() {
		cater = new int[CATER_SIZE][2];
		for (int i = 0; i < CATER_SIZE; i++) {
			cater[i][0] = 60;
			cater[i][1] = 150 - i;
		}
//		cater[0][0] = 60;
//		cater[0][1] = 100;
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
		// �ϴ� ���� �����̸� �����.
		
//		for (int i = 0; i < CATER_SIZE; i++) {
//			rects[cater[i][0]][cater[i][1]].setC(Color.YELLOW);
//		}
		
		
			rects[cater[CATER_SIZE-1][0]][cater[CATER_SIZE-1][1]].setC(Color.YELLOW); //�������� �ǳ��� ���ӿ��� ���� ���� ��ǥ������ �����Ѵ�
		
		// �������� �ǳ��� ��ġ���� ���� ���� ��ǥ������ �����Ѵ�.
		for (int i = 0; i < CATER_SIZE - 1; i++) {
			cater[CATER_SIZE - i - 1][0] = cater[CATER_SIZE - i - 2][0];
			cater[CATER_SIZE - i - 1][1] = cater[CATER_SIZE - i - 2][1];
		}
		// ���� ����Ű�� ���������� Ȯ�� : �� ���������� ���������� �̵�
		if (!isPressed) {// �ȴ��� ������ {
			keyCode = direction;
		}
		isPressed = false;
		direction=keyCode;
		switch (direction) {
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
		
		//�������� ���ο� �Ӹ��� ������� �ƴϸ� ���� ����
		if(rects[cater[0][0]][cater[0][1]].getC()!=Color.yellow) {
			System.exit(0);
		}
		
		// ���� ������ ������ ��ġ�� MyRect�� ������ �ٲ۴�.
//		for (int i = 0; i < CATER_SIZE; i++) {
//			rects[cater[i][0]][cater[i][1]].setC(Color.BLUE);
//		}
	
			rects[cater[0][0]][cater[0][1]].setC(Color.BLUE);
		
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
		int k = e.getKeyCode();
		if (k == 37 || k == 38 || k == 39 || k == 40) {
			isPressed = true;
			keyCode = k;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
