package timeshop.admin;

import javax.servlet.http.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import shop.Action.Action;
import shop.DBbean.*;
public class admin_proupokAction implements Action {
	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String uploadPath = request.getRealPath("/upload/product/"); // upload는 폴더명 / 폴더의 경로를 구해옴
		
		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, uploadPath, // 파일을 저장할 디렉토리 지정
					8072 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);
			
			Admin_productdata product = new Admin_productdata();
			
			String p_img = multi.getFilesystemName("pfile"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
			String p_infoimg= multi.getFilesystemName("pfile2");
			if(p_img==null){
				p_img=product.setP_img("");
			}else {
				p_img = product.setP_img(multi.getFilesystemName("pfile"));
			}
			if(p_infoimg==null){
				p_infoimg=product.setP_img("");
			}else {
				p_infoimg = product.setP_infoimg(multi.getFilesystemName("pfile"));
			}
			
			String p_wname = multi.getParameter("p_wname");
			String wcode = "";
			if(p_wname.equals("카메라")){
				wcode = "cam";
			}else if(p_wname.equals("렌즈")){
				wcode = "lens";	
			}else if(p_wname.equals("메모리")){
				wcode = "memory";
			}else if(p_wname.equals("삼각대")){
				wcode = "tripod";
			}

			String p_code = product.setP_code(wcode);
			String p_manuf = product.setP_manuf(multi.getParameter("p_manuf"));
			String p_wname1 = product.setP_wname(multi.getParameter("p_wname"));
			String p_name = product.setP_name(multi.getParameter("p_name"));
			String p_cot = product.setP_cot(multi.getParameter("p_cot"));
			String p_price = product.setP_price(multi.getParameter("p_price"));
			String p_enddate = product.setP_enddte(multi.getParameter("p_enddate"));
			String p_text = product.setP_text(multi.getParameter("pcontent"));
			
			Admin_productBean productok = Admin_productBean.getInstance();
			productok.insertProduct(product);
			
	}catch(Exception e) {
		e.printStackTrace();
	}
		return "/page/admin/admin_proupok.jsp";
}
}
