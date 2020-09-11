package timeshop.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import shop.Action.Action;
import shop.DBAction.mainDBAction;

public class gume_okAction implements Action {

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
		
		
		request.setCharacterEncoding("utf-8");
	    
	    String procode = request.getParameter("pcode");
	    String pilsu = request.getParameter("pil");
	    String oplens = request.getParameter("opt1");
		String opsdcard = request.getParameter("opt2");
		String samgak = request.getParameter("opt3");
		
		stmt = con.createStatement();
		int price = 0;
		try {
			
			String uid = "userid";
			
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
			String bs_code = procode+to+dix;
			
			String sql2 = "";
			sql2 = "insert into purchase (purnum, puruserid, purproname, purprice) values"+
					"('"+bs_code+
							"','"+uid+
							"','"+pilsu+
							"','"+price+
							"')";
			System.out.println(sql2);
			stmt.executeUpdate(sql2);
			
			String sel="";
			sel = "select * from purchase order by purnum desc limit 1,1";
			psmt = con.prepareStatement(sel);
			ResultSet rs2 = psmt.executeQuery();
			String bix=""; 
			 
			while(rs2.next()){
				bix= rs2.getString("purnum");
			}
			
			///// 렌즈 //////
			if(oplens.equals("")){
				System.out.println("렌즈 빈 값");
			}else{                   
				String sql3 = "insert into purchase_op (puropnum, puropname, puropprice) values"+
						"('"+bs_code+
						"','"+oplens+
						"','"+price+
						"')";
				stmt.executeUpdate(sql3);
				System.out.println(sql3);
				
				String sel4="";
				sel4 = "select * from purchase_op where po_name=?";
				psmt.setString(1, oplens);
				psmt = con.prepareStatement(sel4);
				ResultSet rs4 = psmt.executeQuery();
				int sam=0; 
				 
				while(rs4.next()){
					sam= rs2.getInt("po_cot");
				}
				sam = sam-1;
				String sql4 = "update product_op set po_cot='"+sam+"'where po_name='"+oplens+"'";
				stmt.executeUpdate(sql4); 
				
				
			}
			
			///메모리카드///
			if(opsdcard.equals("")){
				System.out.println("메모리 빈 값");
			}else{
				String sql3 = "insert into purchase_op (puropnum, puropname, puropprice) values"+
						"('"+bs_code+
						"','"+opsdcard+
						"','"+price+
						"')";
				stmt.executeUpdate(sql3);
				
				String sel4="";
				sel4 = "select * from purchase_op where po_name=?";
				psmt.setString(1, opsdcard);
				psmt = con.prepareStatement(sel4);
				ResultSet rs4 = psmt.executeQuery();
				int sam=0; 
				 
				while(rs4.next()){
					sam= rs2.getInt("po_cot");
				}
				sam = sam-1;
				String sql4 = "update product_op set po_cot='"+sam+"' where po_name='"+opsdcard+"'";
				stmt.executeUpdate(sql4); 
				
				
				rs2.close();
				stmt.close();
				con.close();
			}
			
			///삼각대///
			if(samgak.equals("")){
				System.out.println(" 삼각빈 값");
			}else{
				String sql3 = "insert into purchase_op (puropnum, puropname, puropprice) values"+
						"('"+bs_code+
						"','"+samgak+
						"','"+price+
						"')";
				stmt.executeUpdate(sql3); 
				
				String sel4="";
				sel4 = "select * from purchase_op where po_name=?";
				psmt.setString(1, samgak);
				psmt = con.prepareStatement(sel4);
				ResultSet rs4 = psmt.executeQuery();
				int sam=0; 
				 
				while(rs4.next()){
					sam= rs2.getInt("po_cot");
				}
				sam = sam-1;
				String sql4 = "update product_op set po_cot='"+sam+"'where po_name='"+samgak+"'";
				stmt.executeUpdate(sql4); 
				System.out.println(sql4);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return "/page/product/gume_ok.jsp";
	}


}
