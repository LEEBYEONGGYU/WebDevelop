package shop.DBbean;

import java.sql.*;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

public class basketokDBBean {
	Connection con=null;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	String sql="";
	private static basketokDBBean instance = new basketokDBBean();
	
	public static basketokDBBean getInstance() {
		return instance; 
		
	}
	private basketokDBBean() {}
	
	private Connection getConection() throws Exception {
		Connection con=null;
		Context init = new InitialContext(); //
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jsptest"); //
		con = ds.getConnection(); //
		return ds.getConnection();
		
	}
	
	public void insertBasket(basketokBean basket) {
		try {
			con = getConection();
			stmt = con.createStatement();
			int price = 0;
			
			sql = "show table status where name = 'basket'";
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
			String bs_code = basket.getProcode()+to+dix;
			
			String sql2 = "";
			sql2 = "insert into basket (b_num, b_userid, b_name, b_price, b_count) values"+
					"('"+bs_code+
							"','"+basket.getuid()+
							"','"+basket.getPilsu()+
							"','"+basket.getprice()+
							"','"+su+
							"')";
			System.out.println(sql2);
			stmt.executeUpdate(sql2);
			
			String sel="";
			sel = "select * from basket order by b_num desc limit 1,1";
			psmt = con.prepareStatement(sel);
			ResultSet rs2 = psmt.executeQuery();
			String bix=""; 
			 
			while(rs2.next()){
				bix= rs2.getString("b_num");
			}
			
			///// 렌즈 //////
			if(basket.getOplens().equals("")){
				System.out.println("렌즈 빈 값");
			}else{                   
				String sql3 = "insert into basket_op (bo_num, bo_name, bo_count, bo_price) values"+
						"('"+bs_code+
						"','"+basket.getOplens()+
						"','"+su+
						"','"+basket.getprice()+
						"')";
				stmt.executeUpdate(sql3);
				System.out.println(sql3);
			}
			
			///메모리카드///
			if(basket.getOpsdcard().equals("")){
				System.out.println("메모리 빈 값");
			}else{
				String sql3 = "insert into basket_op (bo_num, bo_name, bo_count, bo_price) values"+
						"('"+bs_code+
						"','"+basket.getOpsdcard()+
						"','"+su+
						"','"+basket.getprice()+
						"')";
				stmt.executeUpdate(sql3); System.out.println(sql3);
				rs2.close();
				stmt.close();
				con.close();
			}
			
			///삼각대///
			if(basket.getSamgak().equals("")){
				System.out.println(" 삼각빈 값");
			}else{
				String sql3 = "insert into basket_op (bo_num, bo_name, bo_count, bo_price) values"+
						"('"+bs_code+
						"','"+basket.getSamgak()+
						"','"+su+
						"','"+basket.getprice()+
						"')";
				stmt.executeUpdate(sql3); System.out.println(sql3);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
