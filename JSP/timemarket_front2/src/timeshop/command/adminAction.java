package timeshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;
import shop.DBAction.mainDBAction;

public class adminAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		return "/page/admin/admin.jsp";
	}


}
