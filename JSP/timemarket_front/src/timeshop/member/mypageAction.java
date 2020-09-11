package timeshop.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;

public class mypageAction implements Action{
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/page/member/mem_mypage.jsp";
	}
}
