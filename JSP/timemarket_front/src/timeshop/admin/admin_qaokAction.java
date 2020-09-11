package timeshop.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;
import shop.DBbean.Admin_productopBean;
import shop.DBbean.Admin_productopdata;
import shop.DBbean.Admin_qaBean;
import shop.DBbean.Admin_qadata;
import shop.DBbean.DBBean;
public class admin_qaokAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Admin_qadata AdQa = new Admin_qadata();
		String a_idx = AdQa.setA_idx(request.getParameter("q_idx"));
		String a_title = AdQa.setA_title(request.getParameter("a_title"));
		String a_text = AdQa.setA_text(request.getParameter("a_text"));
		
		Admin_qaBean QaDap = Admin_qaBean.getInstance();
		QaDap.insertQADap(AdQa);
		return "/page/admin/admin_qaok.jsp";
	}


}
