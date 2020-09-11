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
String ppname = "";

String p_autonum = "";
String p_code="";

String p_manuf="";
String p_name="";
String p_wname="";
String p_cot = "";
String p_price="";
String p_enddate = "";
String p_text="";
String p_img = "";
String p_infoimg="";

String uploadPath = request.getRealPath("/upload/product/"); // upload는 폴더명 / 폴더의 경로를 구해옴
try {
	MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
			request, 
			uploadPath, // 파일을 저장할 디렉토리 지정
			8072 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
			"utf-8", // 인코딩 방식 지정
			new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
	);

	fid = multi.getParameter("pro_form"); // form의 name="id"인 값을 구함
	p_manuf = multi.getParameter("p_manuf");
	p_name = multi.getParameter("p_name");
	p_wname = multi.getParameter("p_wname");
	p_cot = multi.getParameter("p_cot");
	p_price = multi.getParameter("p_price");
	p_enddate = multi.getParameter("p_enddate");
	p_text = multi.getParameter("pcontent");
	
	p_img = multi.getFilesystemName("pfile"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
	p_img = multi.getOriginalFileName("pfile"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
	p_infoimg= multi.getFilesystemName("pfile2");
	p_infoimg = multi.getOriginalFileName("pfile2");
	
	if(p_img==null){
			p_img="";
	}
	if(p_infoimg==null){
		p_infoimg="";
	}
	
	sql = "show table status where name = 'product'";
	psmt = con.prepareStatement(sql);
	rs = psmt.executeQuery();
	int dix=0;
	while(rs.next()){
		dix= rs.getInt("Auto_increment");
		System.out.println(dix);
	}
	
	String wcode = "";
	if(p_wname.equals("카메라")){
		wcode = "cam";
	}else if(p_wname.equals("렌즈")){
		wcode = "lens";	
	}else if(p_wname.equals("메모리")){
		wcode = "memory";
	}else if(p_wname.equals("삼각대")){
		wcode = "tripod";
	}else{
		out.println("<script>alert('품목명을 올바르게 입력하세요'); history.back();</script>");
		return;
	}
	
	String ipde = wcode+dix;
	stmt = con.createStatement();
	sql = "insert into product (p_code, p_manuf, p_name, p_wname, p_cot, p_price, p_enddate, p_text, p_img, p_infoimg) values"+
			"('"+ipde+
					"','"+p_manuf+
					"','"+p_name+
					"','"+p_wname+
					"','"+p_cot+
					"','"+p_price+
					"','"+p_enddate+
					"','"+p_text+
					"','"+p_img+
					"','"+p_infoimg+
					"')";
	stmt.executeUpdate(sql);
	stmt.close();
	con.close();
	%>
	<script>alert('상품이 등록되었습니다.'); history.back();</script>
	<%
} catch (Exception e) {
	e.printStackTrace();
	%>
	<script>alert('실패'); history.back();</script>
	<%
} // 업로드 종료
%>