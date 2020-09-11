<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 파일 업로드 처리를 위함 -->
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<% 
	String uploadpath="/upload/board";
	int size = 10*1024*1024;
	
	MultipartRequest multi = new MultipartRequest(request, uploadpath, size, "euc-kr", new DefaultFileRenamePolicy());
	
	String bo_title = request.getParameter("title");
	String bo_name = request.getParameter("name");
	String bo_content = request.getParameter("content");
	String bo_file="";
	
	Enumeration files = multi.getFileNames();
	String file = (String)files.nextElement();
	bo_file = multi.getFilesystemName(file);
try{
	System.out.println(bo_file);
}catch(Exception e){
	e.printStackTrace();
}
 %>