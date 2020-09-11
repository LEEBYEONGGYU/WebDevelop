package timeshop.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;
import shop.DBbean.ProductBasketBean;
import shop.DBbean.ProductBasketData;

public class basket_okAction implements Action{
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		ProductBasketData basket = new ProductBasketData();
		
		String userid = basket.setUserid(request.getParameter("userid"));
		String b_num = basket.setB_num(request.getParameter("pcode"));
		String pilsu = basket.setB_name(request.getParameter("pil"));
		String option1 = basket.setOpt1(request.getParameter("opt1"));
		String option2 = basket.setOpt2(request.getParameter("opt2"));
		String option3 = basket.setOpt3(request.getParameter("opt3"));
		
		ProductBasketBean basketDB = new ProductBasketBean();
		basketDB.insertBasket(basket);
		System.out.println(basket.getB_name());
	return "/page/product/product_info.jsp";
	}
}
