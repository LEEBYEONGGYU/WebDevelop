package timeshop.command;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;
import shop.DBAction.mainDBAction;

public class joinAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Connection con=null;
		Statement stmt;
		PreparedStatement psmt;
		ResultSet rs;
		String dbid = "";
		String dbpw = "";
		String sql="";
		try {
						Class.forName("org.mariadb.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoptest","root","");
						stmt = con.createStatement();
						System.out.println("db����");
					} catch (Exception e) {
						e.printStackTrace();
					}

	
		    try {
			String phone = request.getParameter("phone")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
			String email = request.getParameter("email")+"@"+request.getParameter("email2");
			String mem_gu = request.getParameter("mem_gu");
			
			if(mem_gu.equals("�Ϲ�ȸ��")){
				 mem_gu = "�Ϲ�ȸ��";
			}else{
				 mem_gu = "�Ǹ���";
			}
					stmt = con.createStatement();
					sql = "insert into member (userid, userpw, userphone, username, useremail) values"+
							"('"+request.getParameter("userid")+
									"','"+request.getParameter("pw")+
									"','"+phone+
									"','"+request.getParameter("name")+
									"','"+email+
									"')";
					stmt.executeUpdate(sql);
					stmt.close();
					con.close();
					
					
				}catch(Exception e) {
					
					
					
					e.printStackTrace();
					
				}
		
		return "/page/member/join_ok.jsp";
	}


}
