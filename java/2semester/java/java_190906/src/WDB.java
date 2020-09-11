

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class WDB {

	public static void main(String[] args) {
		
		/* 3����
		//����ó��
		// �� ���� �Է¹޾� ù° ���� ��° ���� ���� ������ ����ϴ� ����
		int x, y, z = 0;		
		Scanner input = new Scanner(System.in);
		x = input.nextInt();
		y = input.nextInt();
		
		try {
			z = x/y;
		} catch (Exception e) {
			System.out.println("0���� �������� ");
			//e.printStackTrace();
		} finally {
			System.out.println(x + "/"+y+"="+z+"�Դϴ�");
		}
	
		//������ �迭 100���� �����Ͽ� �� ���ҿ� 0���� 99������ ���� �����սô�
		
		int array[] = new int[100];
			for(int i=0; i<100; i++){
				array[i]=i;	
				
			}
			
			
		//OO���Ҹ� ���
			System.out.println();
			try {
				System.out.println(array[99]);
				System.out.println(array[100]);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("�迭�ʰ�");
				//e.printStackTrace();
			}
			*/
		Connection conn;
		PreparedStatement psmt = null;
		ResultSet rs= null ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:orcl","WEB","oracle");
			
			//�μ���ȣ�� �Է°����� ū �μ��� ������ ����սô�
			String sql = "select * from department where deptno>?";
			psmt = conn.prepareStatement(sql);
			//�Է¹���
			
			System.out.println("�Է�");
			Scanner input = new Scanner(System.in);
			int in = input.nextInt();
			psmt.setInt(1,in);
			rs = psmt.executeQuery();
			
			
	
		
			try {
				while(rs.next()) {
					int a = rs.getInt("DEPTNO");
					String s = rs.getString("DEPTNAME");
					int b = rs.getInt("FLOOR");
					System.out.println("�μ���ȣ"+in+"�̻��� �μ��� "+a+"�� "+s+"�Դϴ�");
				}
				rs.close();
				psmt.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("��¿� ����");
				//e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("�Է°��� �ʰ�����!");
			e.printStackTrace();
		} 
	}

}
