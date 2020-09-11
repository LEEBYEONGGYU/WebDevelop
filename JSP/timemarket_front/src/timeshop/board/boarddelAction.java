package timeshop.board;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import shop.Action.Action;
import shop.DBbean.DBBean;
public class boarddelAction implements Action{
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		
			
			
	
		
		
		return "/page/board/bo_delete.jsp";
	}
}
