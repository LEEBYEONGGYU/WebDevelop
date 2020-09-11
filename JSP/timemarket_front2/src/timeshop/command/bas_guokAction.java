package timeshop.command;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;
import shop.DBAction.mainDBAction;

public class bas_guokAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=null;
		Statement stmt;
		PreparedStatement psmt;
		ResultSet rs;
		String sql="";
		
		Class.forName("org.mariadb.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shoptest","root","");

		stmt = con.createStatement();
		
	
		
		    	String b_name= request.getParameter("pro_name");
		    	String bo_name = request.getParameter("pro_op");
		    	String b_price = request.getParameter("pro_price");
		    	//String b_ot = request.getParameter("b_cot");
		    
		    
		    	sql = "show table status where name = 'purchase'";
				psmt = con.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				int dix=0;
				while(rs.next()){
					dix= rs.getInt("Auto_increment");
				}
				
				java.util.Date from = new java.util.Date();
		    	SimpleDateFormat transFormat = new java.text.SimpleDateFormat("yyMMdd");

		    	String to = transFormat.format(from);
		    	int su = 0;
				String bs_code = to+dix;
				
				
		    stmt = con.createStatement();
		    String uid = "userid";
			String sql2 = "insert into purchase (purnum, puruserid, purproname, purprice) values"+
					"('"+bs_code+"','"+uid+"','"+b_name+
							"','"+b_price+"')";
			System.out.println(sql2);
			
			
			String bnum = request.getParameter("b_num");
			String sql3 ="delete from basket where b_num='"+bnum+"'";
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.close();
			con.close();

		return "/page/member/bas_guok.jsp";
	}


}
