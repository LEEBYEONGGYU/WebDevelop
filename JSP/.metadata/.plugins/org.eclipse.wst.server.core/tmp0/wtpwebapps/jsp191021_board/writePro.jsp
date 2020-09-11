<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ch12.board.BoardDBBean" %>
<%@ page import = "java.sql.Timestamp" %>

<% request.setCharacterEncoding("utf-8");%>

<%-- 글쓰기 폼에 입력한 값을 갖고 BoardDataBean클래스 객체 article을 생성 --%>
<jsp:useBean id="article" scope="page" class="ch12.board.BoardDataBean">
   <jsp:setProperty name="article" property="*"/>
</jsp:useBean>
 
<%
 String id = "";
 try{
   	id = (String)session.getAttribute("id");//세션에서 얻어낸 사용자 아이디
 }catch(Exception e){}
 
 //폼으로부터 넘어오지 않는 값을 데이터저장빈 BoardDataBean객체 article에 직접저장
 article.setWriter(id);
 article.setReg_date(new Timestamp(System.currentTimeMillis()) );
 article.setIp(request.getRemoteAddr());

 //DB처리빈의 객체를 얻어냄
 BoardDBBean dbPro = BoardDBBean.getInstance();
 //DB처리빈 BoardDBBean클래스의 insertArticle()메소드를 호출해서 레코드 추가
 //이때 추가될 레코드내용 article을 매개변수로 가짐
 //이 메소드의 처리 결과는 check변수에 저장
 int check = dbPro.insertArticle(article);
 
 //이 페이지를 호출한 write.js로 처리결과값 check를 반환
 out.println(check);
%>