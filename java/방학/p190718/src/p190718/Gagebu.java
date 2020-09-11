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
			거래(1);
			break;
		case 2:
			거래(2);
			break;
		case 3:
			거래내역();
			break;
		}
	}

	private void 거래내역() throws Exception {

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

	private void 거래(int gubun) throws Exception {
		// 1. Content객체를 생성한다.
		Item object = new Item();
		// 2. Content객체의 각 내용을 사용자로 부터 입력받아 저장
		Scanner input = new Scanner(System.in);

		System.out.print("제목을 입력하세요");
		object.title = input.nextLine();
		System.out.println("메모를 입력하세요");
		object.memo = input.nextLine();
		System.out.println("금액를 입력하세요");
		object.amount = input.nextInt();

		object.gubon = gubun; // 1:수입 2:지출

		object.balance = dbManager.getBalance();

		// 4. SQL문장 전송

		// INSERT INTO Item VALUES (sysdate,1,'제목',30000, 30000, '메모' );	 
	
	
	object.balance = object.balance+object.amount;
	
	 String sql = "insert into item (gubun, title, amount, balance, memo) value"
			  + "('"+object.gubon+"','"+object.title+"','"+object.amount+"','"+object.balance+"','"+object.memo+"')";
	}

	private void printMenu() {

		// TODO Auto-generated method stub

		System.out.println("1.입금, 2.출금, 3.거래내역\n"

				+ "메뉴를 선택하세요 :");

	}

}