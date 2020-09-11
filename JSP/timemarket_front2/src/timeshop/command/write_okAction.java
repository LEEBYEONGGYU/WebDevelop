package timeshop.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import shop.Action.Action;
import shop.DBAction.mainDBAction;

public class write_okAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Connection con=null;
		Statement stmt;
		PreparedStatement psmt;
		ResultSet rs;
		String sql="";
		
		Context init = new InitialContext(); //
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jsptest"); //
		con = ds.getConnection(); //
		
		
		String uid ="";
		String id = "";
		String qatitle = "";
		String qatext = "";
		String qafile = "";
		String orifile = "";
		String def = "답변대기중";
		String uploadPath = request.getRealPath("/upload/board/"); // upload는 폴더명 / 폴더의 경로를 구해옴
		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, 
					uploadPath, // 파일을 저장할 디렉토리 지정
					10 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);
			uid=multi.getParameter("userid");
			id = multi.getParameter("bo_form"); // form의 name="id"인 값을 구함
			qatitle = multi.getParameter("qa_title");
			qatext = multi.getParameter("qa_text");
			qafile = multi.getFilesystemName("qa_file"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
			orifile = multi.getOriginalFileName("qa_file"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
			
			
			stmt = con.createStatement();
			sql = "insert into qaboard (userid, title, content, qa_status, file) values"+
					"('"+uid+"','"+qatitle+
							"','"+qatext+
							"','"+def+
							"','"+qafile+
							"')";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	
	
		return "/page/board/write_ok.jsp";
	}


}
