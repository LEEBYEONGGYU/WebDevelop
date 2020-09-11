package shop.DBbean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductBasketBean {
	private static ProductBasketBean instance = new ProductBasketBean();
	public static ProductBasketBean getInstance() {
		return instance;
	}
		
		public ProductBasketBean() {}
		
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
			return ds.getConnection();
		}
		
		public void insertBasket(ProductBasketData basket) throws Exception {
			Connection conn= null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				
				String sql = "show table status where name='basket'";
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				int dix=0;
				while(rs.next()) {
					dix = rs.getInt("Auto_increment");
				}
				rs.close();
				stmt.close();
				
				String pcode = basket.getB_num();
				Date from = new Date();
				SimpleDateFormat transFormat = new java.text.SimpleDateFormat("yyMMdd");
				String pnum = pcode+transFormat.format(from)+dix;
				
				String sql2 = "insert into basket (b_num, b_userid, b_name, b_price, b_count) values (?,?,?,?,?)";
				psmt = conn.prepareStatement(sql2);
				
				psmt.setString(1, pnum);
				psmt.setString(2, basket.getUserid());
				psmt.setString(3, basket.getB_name());
				psmt.setString(4, basket.getB_price());
				psmt.setInt(5, 0);
				//psmt.setString(5, basket.getB_count());
				psmt.executeUpdate();
				
				psmt.close();
				
				//옵션부분//
				if(!basket.getOpt1().equals("")) {
					String sql3 = "insert into basket_op (bo_num, bo_name, bo_price) values(?,?,?)";
					psmt = conn.prepareStatement(sql3);
					
					psmt.setString(1, pnum);
					psmt.setString(2, basket.getOpt1());
					//psmt.setString(3, basket.getOp_price());
					
					psmt.executeUpdate();
					
					psmt.close();
				}
				
				if(!basket.getOpt2().equals("")) {
					String sql3 = "insert into basket_op (bo_num, bo_name, bo_price) values(?,?,?)";
					psmt = conn.prepareStatement(sql3);
					
					psmt.setString(1, pnum);
					psmt.setString(2, basket.getOpt2());
					//psmt.setString(3, basket.getOp_price());
					psmt.executeUpdate();
					
					psmt.close();
				}
				
				if(!basket.getOpt3().equals("")) {
					String sql3 = "insert into basket_op (bo_num, bo_name, bo_price) values(?,?,?)";
					psmt = conn.prepareStatement(sql3);
					
					psmt.setString(1, pnum);
					psmt.setString(2, basket.getOpt3());
					//psmt.setString(3, basket.getOp_price());
					
					psmt.executeUpdate();
					
					psmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
	
	
	
