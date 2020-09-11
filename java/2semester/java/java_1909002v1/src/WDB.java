

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class WDB {

	public static void main(String[] args) throws Exception {
		//1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �߸���");
			e.printStackTrace();
		}
		
		
		//2. db����
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id="WEB";
		String pw="oracle";
		try {
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			System.out.println("�����߸���");
		}
		//3. ���� �ۼ�
		
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//4. ���� ���� �� ��� �޾ƿ���
		ResultSet resultset = null;
		//������ �������� �����
		//���� Statement��ü�� Ȱ������ �ʰ� 
		//PreparedStatement��ü�� Ȱ����
		int floor=7;
		PreparedStatement psmt = null;
		String sql = "select * from DEPARTMENT where floor=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, floor); //ù��° sql�� ?�� int���·� 7�� ��
			//stmt = conn.createStatement();
			//resultset = stmt.executeQuery(sql);
			resultset = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//5. �޾ƿ� ��� ó���ϱ�
		if(resultset !=null) {
			//Ŀ���� ù��° ���ڵ�� �ű��
			try {
				//Scanner input = 
				while(resultset.next()) {
					
					int a = resultset.getInt("DEPTNO");
					String s = resultset.getString("DEPTNAME");
					int b= resultset.getInt("FLOOR");
					
					System.out.println("7���� �μ���"+s+"�Դϴ�");
				}
				resultset.close();
				psmt.close();
				conn.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
