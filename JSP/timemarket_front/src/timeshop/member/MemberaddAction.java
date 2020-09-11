package timeshop.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;
import shop.DBbean.Admin_qaBean;
import shop.DBbean.Admin_qadata;
import shop.DBbean.DBBean;
import shop.DBbean.MemberDBBean;
import shop.DBbean.MemberData;
public class MemberaddAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		MemberData memberData = new MemberData();
		String userid = memberData.setUserid(request.getParameter("userid"));
		String userpw = memberData.setUserpw(request.getParameter("userpw"));
		String phone = request.getParameter("phone")+request.getParameter("phone2")+request.getParameter("phone3");
		
		String userphone = memberData.setUserphone(phone);
		String username = memberData.setUsername(request.getParameter("username"));
		String email = request.getParameter("useremail")+"@"+request.getParameter("useremail2");
		String useremail = memberData.setUseremail(email);
		
		MemberDBBean memAdd = MemberDBBean.getInstance();
		memAdd.insertMember(memberData);
		return "/page/member/join_ok.jsp";
	}


}
