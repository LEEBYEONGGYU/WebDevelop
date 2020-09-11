<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 파일 업로드 처리를 위함 -->
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ include file="/include/db.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% 

String uid = (String)session.getAttribute("userid");
String id = "";
String ptitle = "";
String ppname = "";
String pinname = "";
String pcot = "";
String pprice = "";
String penddate = "";
String pendtime = "";
String pcontent = "";
String pfile = "";
String pfile2 = "";
String uploadPath = request.getRealPath("/upload/product/"); // upload는 폴더명 / 폴더의 경로를 구해옴
System.out.println(request.getParameter("qa_title"));
String matime="";
try {
	MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
			request, 
			uploadPath, // 파일을 저장할 디렉토리 지정
			10 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
			"utf-8", // 인코딩 방식 지정
			new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
	);

	id = multi.getParameter("bo_form"); // form의 name="id"인 값을 구함
	ptitle = multi.getParameter("ptitle");	
	ppname = multi.getParameter("ppname");
	pinname = multi.getParameter("pinname");
	pcot = multi.getParameter("pcot");
	pprice = multi.getParameter("pprice");
	penddate = multi.getParameter("penddate");
	pendtime = multi.getParameter("pendtime");
	pcontent = multi.getParameter("pcontent");
	pfile = multi.getFilesystemName("pfile"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
	pfile2 = multi.getOriginalFileName("pfile2"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
	
	
	stmt = con.createStatement();
	
	matime = penddate + " "+pendtime;
	sql = "insert into 일반상품 (제조사명, 상품명, 입고명, 재고수량, 가격, 마감일자, 상품이미지, 상세정보) values"+
			"('"+ppname+"','"+ptitle+
					"','"+pinname+
					"','"+pcot+
					"','"+pprice+
					"','"+matime+
					"','"+pfile+
					"','"+pfile2+
					"')";
	stmt.executeUpdate(sql);
	stmt.close();
	con.close();
	%>
	<script></script>
	<%
} catch (Exception e) {
	e.printStackTrace(); 
	
	matime = penddate + " "+pendtime;
	sql = "insert into 일반상품 (제조사명, 상품명, 입고명, 재고수량, 가격, 마감일자, 상품이미지, 상세정보) values"+
			"('"+ppname+"','"+ptitle+
					"','"+pinname+
					"','"+pcot+
					"','"+pprice+
					"','"+matime+
					"','"+pfile+
					"','"+pfile2+
					"')";
	
	
	System.out.println(sql);
	System.out.println(matime);
	
	String from = matime+":00";
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date to = transFormat.parse(from);
	
	System.out.println(from);
	%>
	
	<script></script>
	
	<%
} // 업로드 종료
%>