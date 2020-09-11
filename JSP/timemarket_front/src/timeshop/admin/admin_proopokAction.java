package timeshop.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.Action.Action;
import shop.DBbean.Admin_productopBean;
import shop.DBbean.Admin_productopdata;
import shop.DBbean.DBBean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
public class admin_proopokAction implements Action {

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
			
			
			
			Admin_productopdata option = new Admin_productopdata();
			String fid = multi.getParameter("fid"); // form의 name="id"인 값을 구함  
			String pofile = multi.getFilesystemName("pofile");
			String pof = "";
			if(pofile==null){ 
				pofile=" ";
				pof = option.setPo_img(pofile);
			}else {
				pofile = option.setPo_img(multi.getFilesystemName("pofile"));
				
			}
			System.out.println("이미지는 "+pofile);
			String po_code = option.setPo_code(multi.getParameter("po_code"));
			String po_manuf = option.setPo_manuf(multi.getParameter("po_manuf"));
			String po_name = option.setPo_name(multi.getParameter("po_name"));
			String po_wname = option.setPo_wname(multi.getParameter("po_wname"));
			String po_cot = option.setPo_cot(multi.getParameter("po_cot"));
			String po_price = option.setPo_price(multi.getParameter("po_price"));
			
			Admin_productopBean productop = Admin_productopBean.getInstance();
			productop.insertOption(option);
			
	}catch(Exception e) {
		e.printStackTrace();
	}
		return "/page/admin/admin_proopok.jsp";
}
}
