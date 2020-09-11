package timeshop.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;

public class boardmodifyAction implements Action{
public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/page/board/bo_modify.jsp";
	}
}
