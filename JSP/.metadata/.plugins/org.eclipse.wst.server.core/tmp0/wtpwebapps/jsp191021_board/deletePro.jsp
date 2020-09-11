<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ch12.board.BoardDBBean" %>

<% request.setCharacterEncoding("utf-8");%>
<%
  int num = Integer.parseInt(request.getParameter("num"));
  String passwd = request.getParameter("passwd");
  
  BoardDBBean dbPro = BoardDBBean.getInstance();
  //글 삭제 처리후 결과를 check변수에 저장
  int check = dbPro.deleteArticle(num, passwd);
  
  //이 페이지를 호출한 delete.js로 처리결과값 check를 반환
  out.println(check);
 %>