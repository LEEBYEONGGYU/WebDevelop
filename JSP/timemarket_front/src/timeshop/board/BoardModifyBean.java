package timeshop.board;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import shop.DBbean.BoardModifyData;

public class BoardModifyBean {
	private static BoardModifyBean instance = new BoardModifyBean();
	public static BoardModifyBean getInstance() {
		return instance;
	}
	
	public BoardModifyBean() {}
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		return ds.getConnection();
	}
	
	public void modifyQa(BoardModifyData BoardData) throws Exception{
		Connection conn= null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "update qaboard set title=?, content=?, file=? where idx=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, BoardData.getQa_title());
			psmt.setString(2, BoardData.getQa_text());
			psmt.setString(3, BoardData.getFile());
			psmt.setString(4, BoardData.getQa_idx());
			psmt.executeUpdate();

			System.out.println("제목수정"+ BoardData.getQa_title());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("제목수정 "+ BoardData.getQa_title());
			System.out.println("내용수정 "+ BoardData.getQa_text());
			System.out.println("파일수정 "+ BoardData.getFile());
			System.out.println("글번호 "+ BoardData.getQa_idx());
		}finally {
			if( rs!=null)  try {rs.close(); }catch( SQLException ex){}
			if( psmt!=null)  try {psmt.close(); }catch( SQLException ex){}
			if( conn!=null)  try {conn.close(); }catch( SQLException ex){}
		}
		
	}
	
}
