package timeshop.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import shop.Action.Action;
import shop.DBAction.mainDBAction;

public class qadeleteAction implements Action {

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
		
			stmt = con.createStatement();
			sql = "delete from qaboard where idx='"+request.getParameter("idx")+"'";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
		return "/page/member/qadelete.jsp";
	}


}
