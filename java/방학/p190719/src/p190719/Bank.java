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
		System.out.println("������ �ֽ��ϱ� ����?");
		System.out.println("������ 1, ������ 2�� �Է��ϼ���");
		int inputval;
		Scanner input = new Scanner(System.in);
		inputval = input.nextInt();
		
		switch(inputval) {
		case 1:
			�ŷ�(1);
			break;
		case 2:
			���尳��(2);
			break;
		}
	}
	Account obj = new Account();
	private void ���尳��(int gubon) throws Exception { //���尳��
		insert gs = new insert();
		gs.create();
	}

	private void �ŷ�(int gubon) throws Exception {
		Account obj2 = new Account();
		
		System.out.println("�Ա��ҷ��� 1, ����Ϸ��� 2, ���������� 3�� �Է��ϼ���.");
		int inputval2;
		Scanner input = new Scanner(System.in);
		inputval2 = input.nextInt();
		
		switch(inputval2) {
		case 1:
			�Ա�(1);
			break;
		case 2:
			���(2);
			break;
		case 3:
			�ŷ�����();
		}
	}
	
	Trade item = new Trade();
	private void �Ա�(int gubon) throws Exception {
		  
		System.out.println("�Ա��ص帱����");
		
		System.out.println("���¹�ȣ��");
		Scanner accnum = new Scanner(System.in); //���¹�ȣ�Է�
		item.no = accnum.nextInt();
		
		System.out.println("�ݾ��� �Է��ϼ���");
		Scanner inamount = new Scanner(System.in);
		item.amount = inamount.nextInt();
		
		System.out.println("ǥ���ҳ���");
		Scanner inmemo = new Scanner(System.in);
		item.memo = inmemo.nextLine();
		
		item.type = gubon;

		String sql = "insert into trade(no, type, amount, memo) values"
				+ "('"+item.no+"','"+item.type+"','"+item.amount+"','"+item.memo+"')" ;
		
		 dbManager.modify(sql);
	}
	private void ���(int gubon) throws Exception {
		System.out.println("����ص帱����");
		
		Trade item = new Trade();
		
		System.out.println("�ݾ��� �Է��ϼ���");
		Scanner inamount = new Scanner(System.in);
		item.amount = inamount.nextInt();
		
		System.out.println("ǥ���ҳ���");
		Scanner inmemo = new Scanner(System.in);
		item.memo = inmemo.nextLine();
		
		item.type = gubon;

		String sql = "insert into trade(no, type, amount, memo) values"
				+ "('"+item.no+"','"+item.type+"','"+item.amount+"','"+item.memo+"')" ;
		
		 dbManager.modify(sql);
	}

	private void �ŷ�����() throws Exception{
			  dbManager.inam();
	}
}
