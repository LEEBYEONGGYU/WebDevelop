package p190719;

import java.util.Scanner;

public class insert {
	DBManager dbManager;
	public void Bank() throws Exception {
		dbManager = new DBManager();
		dbManager.connect();
	}
	public void create() throws Exception {
		Account obj = new Account();
		System.out.println("이름을 입력하세요");
		Scanner input = new Scanner(System.in); //이름입력
		obj.name = input.nextLine();
		System.out.println("사용하실 계좌번호를 입력하세요");
		Scanner accnum = new Scanner(System.in); //계좌번호입력
		obj.no = accnum.nextInt();
		System.out.println("돈주세요");
		Scanner acbal = new Scanner(System.in); //계좌번호입력
		obj.balance = acbal.nextInt();
		
		String memo = "입금";
		String sql = "insert into Account(no, name, balance) values"
				+ "('"+obj.no+"','"+obj.name+"','"+obj.balance+"')" ;
		 
		System.out.println(obj.no+obj.name+obj.balance);
		System.out.println(sql);

		 dbManager.modify(sql);
	}

}
