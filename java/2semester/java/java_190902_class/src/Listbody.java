

import java.sql.SQLException;

class Listbody {
	DBcon dbManager;
	public Listbody() {
		dbManager = new DBcon();
		dbManager.connect();
		
	}
	
	public void operate() throws Exception {
		int floor=5;
		String sql = "select * from DEPARTMENT where floor=?";
		
		try {
			dbManager.psmt = dbManager.con.prepareStatement(sql);
			dbManager.psmt.setInt(1, floor);
			dbManager.rs = dbManager.psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//�޾ƿ� ��� ó��
		if(dbManager.rs !=null) {
			try {
				while(dbManager.rs.next()) {
					int a = dbManager.rs.getInt("DEPTNO");
					String s = dbManager.rs.getString("DEPTNAME");
					int b = dbManager.rs.getInt("FLOOR");
					
					System.out.println(floor+"�� �μ���"+s+"�Դϴ�");
				}
				dbManager.rs.close();
				dbManager.psmt.close();
				dbManager.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}