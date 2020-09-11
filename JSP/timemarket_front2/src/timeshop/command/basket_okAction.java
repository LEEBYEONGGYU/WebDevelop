package timeshop.command;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.sql.*;
import java.text.SimpleDateFormat;

import shop.Action.Action;
import shop.DBAction.mainDBAction;
import shop.DBbean.basketokDBBean;

public class basket_okAction implements Action {
	
	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=null;
		Statement stmt;
		PreparedStatement psmt;
		ResultSet rs;
		String sql="";
		
		Context init = new InitialContext(); //
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jsptest"); //
		con = ds.getConnection(); //
		
		
		String procode = request.getParameter("pcode");
	    String pilsu = request.getParameter("pil");
	    String oplens = request.getParameter("opt1");
		String opsdcard = request.getParameter("opt2");
		String samgak = request.getParameter("opt3");
		
		
		if(samgak=="4. 삼각대 선택"){
			samgak="";
		}
		try {
			stmt = con.createStatement();
			String jannum = "c1234";
			String uid = "userid";
			int price = 2323232;
			int su = 10;
			int opsu = 20;
			String sql2="";
			int oppri = 20000;
			
				
			sql2 = "show table status where name = 'basket'";
			psmt = con.prepareStatement(sql2);
			rs = psmt.executeQuery();
			
			int dix=0;
			while(rs.next()){
				dix= rs.getInt("Auto_increment");
			}
			
			java.util.Date from = new java.util.Date();
	    	SimpleDateFormat transFormat = new java.text.SimpleDateFormat("yyyyMMddHHmm");

	    	String to = transFormat.format(from);
	    			
			String bs_code = to+dix;
			sql = "insert into basket (b_num, b_userid, b_name, b_price, b_count) values"+
					"('"+bs_code+
							"','"+uid+
							"','"+pilsu+
							"','"+price+
							"','"+su+
							"')";
			System.out.println(sql);
			
			
				if(samgak.equals("")){
					System.out.println("삼각대없음");
				}else{
					System.out.println("삼각대 있음");
				}
			
					stmt.executeUpdate(sql);
					stmt.executeUpdate(sql2);
					stmt.close();
					con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		return "/page/product/basket_ok.jsp";
	}


}
