package shop.DBbean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberMyBuyBean {
	private static MemberMyBuyBean instance = new MemberMyBuyBean();
	public static MemberMyBuyBean getInstance() {
		return instance;
	}
	
	public MemberMyBuyBean() {}
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		return ds.getConnection();
	}
	
	public void insertPurchase(MemberMyBuyData Purchase) throws Exception{
		Connection conn= null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "show table status where name='purchase'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int dix=0;
			while(rs.next()) {
				dix = rs.getInt("Auto_increment");
			}
			rs.close();
			stmt.close();
		
			Date from = new Date();
			SimpleDateFormat transFormat = new java.text.SimpleDateFormat("yyyyMMdd");
			String pnum = transFormat.format(from)+dix;
			
			String sql2 = "insert into purchase (purnum, puruserid, purproname, purprice) values (?,?,?,?)";
			psmt = conn.prepareStatement(sql2);
			
			psmt.setString(1, pnum);
			psmt.setString(2, Purchase.getUserid());
			psmt.setString(3, Purchase.getPurproname());
			psmt.setString(4, Purchase.getPurpirce());
			psmt.executeUpdate();
			
			psmt.close();
			
			System.out.println(sql2);

			////옵션받기////
			if(Purchase.getPurop1().equals("")) {
				System.out.println("옵션1번");
			}else {
				String sql3 = "insert into purchase_op (puropnum, puropname, puropprice) values (?,?,?)";
				psmt = conn.prepareStatement(sql3);
				
				psmt.setString(1, pnum);
				psmt.setString(2, Purchase.getPurop1());
				psmt.setString(3, Purchase.getPuropprice());
				psmt.executeUpdate();
				
				psmt.close();
				
				System.out.println(sql3);
				
				String sel4="select * from purchase_op where puropname=?";
				psmt = conn.prepareStatement(sel4);
				psmt.setString(1, Purchase.getPurop1());
				
				rs = psmt.executeQuery();
				int sam=0;
				
				while(rs.next()) {
					sam = rs.getInt("puropcot");
				}
				sam = sam-1;
				String sql4 = "update purchase_op set puropcot='?' where puropname='?'";
				psmt = conn.prepareStatement(sql4);
				
				psmt.setInt(1, sam);
				psmt.setString(2, Purchase.getPurop1());
				psmt.executeUpdate();
				
				psmt.close();
			}
			
			
		////옵션받기////
					if(Purchase.getPurop2().equals("")) {
						System.out.println("옵션2번");
					}else{
						String sql3 = "insert into purchase_op (puropnum, puropname, puropprice) values (?,?,?)";
						psmt = conn.prepareStatement(sql3);
						
						psmt.setString(1, pnum);
						psmt.setString(2, Purchase.getPurop2());
						psmt.setString(3, Purchase.getPuropprice2());
						psmt.executeUpdate();
						
						psmt.close();
						
						System.out.println(sql3);
						
						String sel4="select * from purchase_op where puropname=?";
						psmt.setString(1, Purchase.getPurop2());
						psmt = conn.prepareStatement(sel4);
						rs = psmt.executeQuery();
						int sam=0;
						
						while(rs.next()) {
							sam = rs.getInt("puropcot");
						}
						sam = sam-1;
						String sql4 = "update purchase_op set puropcot='?' where puropname='?'";
						psmt = conn.prepareStatement(sql4);
						
						psmt.setInt(1, sam);
						psmt.setString(2, Purchase.getPurop2());
						psmt.executeUpdate();
						
						psmt.close();
					}
					
					
				////옵션받기////
					if(Purchase.getPurop3().equals("")) {
						System.out.println("옵션3번");
					}else {
						String sql3 = "insert into purchase_op (puropnum, puropname, puropprice) values (?,?,?)";
						psmt = conn.prepareStatement(sql3);
						
						psmt.setString(1, pnum);
						psmt.setString(2, Purchase.getPurop3());
						psmt.setString(3, Purchase.getPuropprice3());
						psmt.executeUpdate();
						
						psmt.close();
						
						System.out.println(sql3);
						
						String sel4="select * from purchase_op where puropname=?";
						psmt.setString(1, Purchase.getPurop3());
						psmt = conn.prepareStatement(sel4);
						rs = psmt.executeQuery();
						int sam=0;
						
						while(rs.next()) {
							sam = rs.getInt("puropcot");
						}
						sam = sam-1;
						String sql4 = "update purchase_op set puropcot='?' where puropname='?'";
						psmt = conn.prepareStatement(sql4);
						
						psmt.setInt(1, sam);
						psmt.setString(2, Purchase.getPurop3());
						psmt.executeUpdate();
						
						psmt.close();
					}
					
					
				////옵션받기////
					if(Purchase.getPurop4().equals("")) {
						System.out.println("옵션4번");
					}else {
						String sql3 = "insert into purchase_op (puropnum, puropname, puropprice) values (?,?,?)";
						psmt = conn.prepareStatement(sql3);
						
						psmt.setString(1, pnum);
						psmt.setString(2, Purchase.getPurop4());
						psmt.setString(3, Purchase.getPuropprice4());
						psmt.executeUpdate();
						
						psmt.close();
						
						System.out.println(sql3);
						
						String sel4="select * from purchase_op where puropname=?";
						psmt.setString(1, Purchase.getPurop4());
						psmt = conn.prepareStatement(sel4);
						rs = psmt.executeQuery();
						int sam=0;
						
						while(rs.next()) {
							sam = rs.getInt("puropcot");
						}
						sam = sam-1;
						String sql4 = "update purchase_op set puropcot='?' where puropname='?'";
						psmt = conn.prepareStatement(sql4);
						
						psmt.setInt(1, sam);
						psmt.setString(2, Purchase.getPurop4());
						psmt.executeUpdate();
						
						psmt.close();
					}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if( rs!=null)  try {rs.close(); }catch( SQLException ex){}
			if( psmt!=null)  try {psmt.close(); }catch( SQLException ex){}
			if( conn!=null)  try {conn.close(); }catch( SQLException ex){}
		}
	}

}
