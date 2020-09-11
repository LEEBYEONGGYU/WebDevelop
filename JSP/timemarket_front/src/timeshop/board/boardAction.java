package timeshop.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;

public class boardAction implements Action{
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/page/board/board.jsp";
	}
}
