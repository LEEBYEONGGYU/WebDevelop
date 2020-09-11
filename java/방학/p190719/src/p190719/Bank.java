package p190719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Bank {
	DBManager dbManager;
	public Bank() throws Exception {
		dbManager = new DBManager();
		dbManager.connect();
	}
	
	public void operate() throws Exception {
		System.out.println("통장이 있습니까 고객님?");
		System.out.println("있으면 1, 없으면 2를 입력하세요");
		int inputval;
		Scanner input = new Scanner(System.in);
		inputval = input.nextInt();
		
		switch(inputval) {
		case 1:
			거래(1);
			break;
		case 2:
			통장개설(2);
			break;
		}
	}
	Account obj = new Account();
	private void 통장개설(int gubon) throws Exception { //통장개설
		insert gs = new insert();
		gs.create();
	}

	private void 거래(int gubon) throws Exception {
		Account obj2 = new Account();
		
		System.out.println("입금할려면 1, 출금하려면 2, 내역보려면 3을 입력하세요.");
		int inputval2;
		Scanner input = new Scanner(System.in);
		inputval2 = input.nextInt();
		
		switch(inputval2) {
		case 1:
			입금(1);
			break;
		case 2:
			출금(2);
			break;
		case 3:
			거래내역();
		}
	}
	
	Trade item = new Trade();
	private void 입금(int gubon) throws Exception {
		  
		System.out.println("입금해드릴께요");
		
		System.out.println("계좌번호요");
		Scanner accnum = new Scanner(System.in); //계좌번호입력
		item.no = accnum.nextInt();
		
		System.out.println("금액을 입력하세요");
		Scanner inamount = new Scanner(System.in);
		item.amount = inamount.nextInt();
		
		System.out.println("표시할내용");
		Scanner inmemo = new Scanner(System.in);
		item.memo = inmemo.nextLine();
		
		item.type = gubon;

		String sql = "insert into trade(no, type, amount, memo) values"
				+ "('"+item.no+"','"+item.type+"','"+item.amount+"','"+item.memo+"')" ;
		
		 dbManager.modify(sql);
	}
	private void 출금(int gubon) throws Exception {
		System.out.println("출금해드릴께요");
		
		Trade item = new Trade();
		
		System.out.println("금액을 입력하세요");
		Scanner inamount = new Scanner(System.in);
		item.amount = inamount.nextInt();
		
		System.out.println("표시할내용");
		Scanner inmemo = new Scanner(System.in);
		item.memo = inmemo.nextLine();
		
		item.type = gubon;

		String sql = "insert into trade(no, type, amount, memo) values"
				+ "('"+item.no+"','"+item.type+"','"+item.amount+"','"+item.memo+"')" ;
		
		 dbManager.modify(sql);
	}

	private void 거래내역() throws Exception{
			  dbManager.inam();
	}
}
