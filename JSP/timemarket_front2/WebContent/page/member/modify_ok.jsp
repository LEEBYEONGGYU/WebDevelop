<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 파일 업로드 처리를 위함 -->
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.sql.*" %>
<%@ include file="/include/db.jsp" %>


<script>alert("문의글이 수정되었습니다"); location.href="qaboard.do";</script>