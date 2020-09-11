package timeshop.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import shop.Action.Action;
import shop.DBbean.BoardModifyData;

public class boardmodifyokAction implements Action{
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String uploadPath = request.getRealPath("/upload/board/"); // upload는 폴더명 / 폴더의 경로를 구해옴
		
		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, uploadPath, // 파일을 저장할 디렉토리 지정
					8072 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);
			
			BoardModifyData BoardData = new BoardModifyData();
			
			String qa_idx = BoardData.setQa_idx(multi.getParameter("qa_idx"));
			String qa_title = BoardData.setQa_title(multi.getParameter("qa_title"));
			String qa_text = BoardData.setQa_text(multi.getParameter("qa_text"));
			String qa_file = BoardData.setFile(multi.getParameter("qa_file"));
			String pof = "";
			if(qa_file==null){ 
				qa_file=" ";
				pof = BoardData.setFile(pof);
			}else {
				pof = BoardData.setFile(multi.getParameter("qa_file"));
				
			}
			BoardModifyBean BoardMoBean = new BoardModifyBean();
			BoardMoBean.modifyQa(BoardData);
			
			request.setAttribute("ndx", qa_idx);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "/page/board/bo_modifyok.jsp";
	}
}
