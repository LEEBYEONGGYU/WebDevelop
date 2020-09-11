package timeshop.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;
import shop.DBbean.MemberMyBuyBean;
import shop.DBbean.MemberMyBuyData;
public class membuyokAction implements Action{
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		MemberMyBuyData Purchase = new MemberMyBuyData();
		
		String userid = Purchase.setUserid(request.getParameter("userid"));
		String pro_name = Purchase.setPurproname(request.getParameter("bas_pname"));
		String bas_proop = Purchase.setPurop1(request.getParameter("bas_proop1"));
		String bas_proop2 = Purchase.setPurop2(request.getParameter("bas_proop2"));
		String bas_proop3 = Purchase.setPurop3(request.getParameter("bas_proop3"));
		String bas_proop4 = Purchase.setPurop4(request.getParameter("bas_proop4"));
		String pro_opprice = Purchase.setPuropprice(request.getParameter("bas_opprice1"));
		String pro_opprice2 = Purchase.setPuropprice2(request.getParameter("bas_opprice2"));
		String pro_opprice3 = Purchase.setPuropprice3(request.getParameter("bas_opprice3"));
		String pro_opprice4 = Purchase.setPuropprice4(request.getParameter("bas_opprice4"));
		String pro_price = Purchase.setPurpirce(request.getParameter("pro_price"));
		String pro_cot = Purchase.setPurcot(request.getParameter("pro_cot"));
		
		
		MemberMyBuyBean PurchaseBean = MemberMyBuyBean.getInstance();
		PurchaseBean.insertPurchase(Purchase);
		return "/page/member/mem_buyok.jsp";
	}
}
