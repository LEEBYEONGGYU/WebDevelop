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
		System.out.println("�̸��� �Է��ϼ���");
		Scanner input = new Scanner(System.in); //�̸��Է�
		obj.name = input.nextLine();
		System.out.println("����Ͻ� ���¹�ȣ�� �Է��ϼ���");
		Scanner accnum = new Scanner(System.in); //���¹�ȣ�Է�
		obj.no = accnum.nextInt();
		System.out.println("���ּ���");
		Scanner acbal = new Scanner(System.in); //���¹�ȣ�Է�
		obj.balance = acbal.nextInt();
		
		String memo = "�Ա�";
		String sql = "insert into Account(no, name, balance) values"
				+ "('"+obj.no+"','"+obj.name+"','"+obj.balance+"')" ;
		 
		System.out.println(obj.no+obj.name+obj.balance);
		System.out.println(sql);

		 dbManager.modify(sql);
	}

}
