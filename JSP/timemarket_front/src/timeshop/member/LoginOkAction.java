package timeshop.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import shop.Action.Action;

public class LoginOkAction implements Action {
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		
		Connection conn= ds.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int check=0;
		try {
		String sql = "select userid userpw from member where userid=? and userpw=?";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, request.getParameter("userid"));
		psmt.setString(2, request.getParameter("userpw"));
		
		rs = psmt.executeQuery();
		String uid="";
		String upw="";
		
		while(rs.next()){
			uid= rs.getString("userid");
			upw = rs.getString("userpw");
		}
		
		if(uid.equals("") || upw.equals("")) {
			check=0;
			request.setAttribute("check", new Integer(0));
		}else {
			check=1;
			request.setAttribute("check", check);
			request.setAttribute("id", uid);
		}
		rs.close();
		psmt.close();
		
		System.out.println("check값은 "+check);
		System.out.println("request값은 "+request.getParameter("userid")+" "+request.getParameter("userpw"));
}catch(Exception e) {
			e.printStackTrace();
			System.out.println("catch문");
		}
		return "/page/member/login_ok.jsp";
	}
}
