package gui_190916;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Mypanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//���� �׸� �׸��� �׸��� �ȴ�
		g.fillRect(170, 40, 200, 30);
		g.drawRect(170, 40, 200, 30);
		g.drawRect(75, 70, 380, 30);
		g.drawString("�̺���", 250,90);
		g.drawOval(70, 100, 400, 400);
		
		//���ʴ�
		g.drawOval(160, 150, 50, 50);
		g.fillOval(170, 173, 30, 30);
		
		//������ ��
		g.drawOval(320, 150, 50, 50);
		g.fillOval(330, 173, 30, 30);
		
		//�� ��
		g.drawOval(190, 230, 150, 80);
		
		
		//�� 2��
		g.setColor(Color.red);
		g.fillOval(220, 250, 30, 30);
		g.setColor(Color.red);
		g.fillOval(280, 250, 30, 30);
		 
		
		//����
		g.drawLine(270, 700, 270, 500);
		g.drawLine(100, 580, 270, 500);
		g.setColor(Color.magenta);
		g.fillOval(80, 570, 30, 30);
		
		g.drawLine(400, 580, 270, 500);
		g.setColor(Color.magenta);
		g.fillOval(400, 570, 30, 30);
		
		g.drawLine(270, 700, 400, 800);
		g.drawLine(120,800, 270, 700);
		
		g.fillRect(100, 800, 40, 20);
		g.fillRect(385, 800, 40, 20);
		
		/*
		//������ �׸��� 0,0���� 500,500���� �׷�����.
		g.drawLine(0, 0, 500, 500);
		g.drawLine(0, 500, 500, 0);
		
		g.drawLine(250,0, 500, 500);
		g.drawLine(0, 500, 500, 500);
		
		g.drawLine(500, 0, 500, 500);
		g.drawLine(0, 500, 500, 500);
		
		
		
		//Ÿ�� �׸���
		//g.drawOval(0, 0, 500, 500);
		g.setColor(Color.cyan);
		g.fillOval(10, 10, 480, 480);
		*/
	}	
}