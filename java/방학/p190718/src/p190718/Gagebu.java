package p190718;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Gagebu {
	DBManager dbManager;

	public Gagebu() throws Exception {
		dbManager = new DBManager();
		dbManager.connect();
	}

	public void operate() throws Exception {

		printMenu();

		int inputValue;
		Scanner input = new Scanner(System.in);
		inputValue = input.nextInt();

		System.out.println(inputValue);

		switch (inputValue) {
		case 1:
			�ŷ�(1);
			break;
		case 2:
			�ŷ�(2);
			break;
		case 3:
			�ŷ�����();
			break;
		}
	}

	private void �ŷ�����() throws Exception {

		Item[] items = dbManager.getList();
		for (Item object : items) {
			if (object != null) {
				System.out.printf(object.idate2 + " ");
				System.out.printf(object.idate + " ");
				
				System.out.printf(object.gubon + " ");
				System.out.printf(object.title + " ");
				System.out.printf(object.amount + " ");
				System.out.printf(object.balance + " ");
				System.out.printf(object.memo + "\n");
			}
		}
	}

	private void �ŷ�(int gubun) throws Exception {
		// 1. Content��ü�� �����Ѵ�.
		Item object = new Item();
		// 2. Content��ü�� �� ������ ����ڷ� ���� �Է¹޾� ����
		Scanner input = new Scanner(System.in);

		System.out.print("������ �Է��ϼ���");
		object.title = input.nextLine();
		System.out.println("�޸� �Է��ϼ���");
		object.memo = input.nextLine();
		System.out.println("�ݾ׸� �Է��ϼ���");
		object.amount = input.nextInt();

		object.gubon = gubun; // 1:���� 2:����

		object.balance = dbManager.getBalance();

		// 4. SQL���� ����

		// INSERT INTO Item VALUES (sysdate,1,'����',30000, 30000, '�޸�' );	 
	
	
	object.balance = object.balance+object.amount;
	
	 String sql = "insert into item (gubun, title, amount, balance, memo) value"
			  + "('"+object.gubon+"','"+object.title+"','"+object.amount+"','"+object.balance+"','"+object.memo+"')";
	}

	private void printMenu() {

		// TODO Auto-generated method stub

		System.out.println("1.�Ա�, 2.���, 3.�ŷ�����\n"

				+ "�޴��� �����ϼ��� :");

	}

}