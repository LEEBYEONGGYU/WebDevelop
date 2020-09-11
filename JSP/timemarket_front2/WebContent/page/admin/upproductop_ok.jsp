<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 파일 업로드 처리를 위함 -->
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.sql.*" %>
<%@ include file="/include/db.jsp" %>
<% 
String fid = "";
String po_code;
String po_manuf="";
String po_name="";
String po_wname="";
String po_cot="";
String po_price="";
String pofile="";
String pofile2="";

String uploadPath = request.getRealPath("/upload/product/"); // upload는 폴더명 / 폴더의 경로를 구해옴
try {
	MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
			request, uploadPath, // 파일을 저장할 디렉토리 지정
			8072 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
			"utf-8", // 인코딩 방식 지정
			new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
	);

	fid = multi.getParameter("fid"); // form의 name="id"인 값을 구함
	po_code = multi.getParameter("po_code");
	po_manuf = multi.getParameter("po_manuf");
	po_name = multi.getParameter("po_name");
	po_wname = multi.getParameter("po_wname");
	po_cot = multi.getParameter("po_cot");
	po_price = multi.getParameter("po_price");
	
	pofile = multi.getFilesystemName("pofile"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
	pofile = multi.getOriginalFileName("pofile"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
	pofile2= multi.getFilesystemName("pofile2");
	pofile2 = multi.getOriginalFileName("pofile2");
	
	if(pofile==null){
		pofile="";
	}
	if(pofile2==null){
		pofile2="";
	}
	
	sql = "show table status where name = 'product_op'";
	psmt = con.prepareStatement(sql);
	rs = psmt.executeQuery();
	
	int dix=0;
	while(rs.next()){
		dix= rs.getInt("Auto_increment");
	}
	
	String wcode = "";
	String ipde="";
	 if(po_wname.equals("렌즈")){
		wcode = "lens";	
	}else if(po_wname.equals("메모리")){
		wcode = "memory";
	}else if(po_wname.equals("삼각대")){
		wcode = "tripod";
	}else{
		out.println("<script>alert('품목명을 올바르게 입력하세요'); history.back();</script>");
		return;
	}
	 
	 if(po_code.equals("")){
		 po_code = "";
		 ipde = wcode+dix;
	 }else {
		 ipde = po_code;
	 }
	 
	
	stmt = con.createStatement();
	sql = "insert into product_op (po_code, po_manuf, po_name, po_wname, po_cot, po_price, po_img, po_infoimg) values"+
			"('"+ipde+
					"','"+po_manuf+
					"','"+po_name+
					"','"+po_wname+
					"','"+po_cot+
					"','"+po_price+
					"','"+pofile+
					"','"+pofile2+
					"')";
	stmt.executeUpdate(sql);
	stmt.close();
	con.close();
	%>
	<script>alert('옵션상품이 등록되었습니다.'); history.back();</script>
	<%
} catch (Exception e) {
	e.printStackTrace();
	%>
	<script>alert('실패'); history.back();</script>
	<%
} // 업로드 종료
%>