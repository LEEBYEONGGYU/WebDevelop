<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ch12.board.BoardDBBean" %>
<%@ page import = "ch12.board.BoardDataBean" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="../css/style.css"/>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="list.js"></script>

<% request.setCharacterEncoding("utf-8");%>
<%
String id = "";
int pageSize = 3;//한페이지에 표시할 글의 수 
SimpleDateFormat sdf = 
    new SimpleDateFormat("yyyy-MM-dd HH:mm");//날짜데이터 표시형식지정

String pageNum = request.getParameter("pageNum");//화면에 표시할 페이지번호
if (pageNum == null) //페이지번호가 없으면 1페이지의 내용이 화면에 표시
    pageNum = "1";

int count = 0;//전체글의 수
int currentPage = Integer.parseInt(pageNum);//숫자로 파싱
    
List<BoardDataBean> articleList = null;//글목록을 저장
BoardDBBean dbPro = BoardDBBean.getInstance();
count = dbPro.getArticleCount();//전체글수 얻어냄

if(count == (currentPage-1)*pageSize)
   currentPage -=1;
  
int startRow = (currentPage - 1) * pageSize + 1;//현재 페이지에서의 시작글번호

try{
  if(count > 0)//테이블에 저장된 글이 있으면, 테이블에서 글목록을 가져옴
    articleList = dbPro.getArticles(startRow, pageSize);

  if(articleList.isEmpty())//테이블에 저장된 글이 없으면, 전체글 수 : 0
    count = 0;
}catch(Exception e){}%>

<div id="list_head" class="box2">
   <h3 class="inline">글목록(전체 글:<%=count%>)</h3>
   <button id="new">글쓰기</button>
</div>

<% if (count == 0){//게시판에 글이 없는 경우%>
<div id="list_article" class="box2">
  <ul>
    <li><p>게시판에 저장된 글이 없습니다.
  </ul>
</div>
<%}else{//게시판에 글이 있는 경우%>
<div id="list_article" class="box2">
<% 
  //글목록을 반복처리
  for (int i = 0 ; i < articleList.size() ; i++) {
     BoardDataBean article = articleList.get(i);
%>
   <ul class="article">  
    <li class="layout_f">
     <%String writer = article.getWriter();
       out.println(writer.substring(0, 4) + "****");
     %>
    <li class="layout_f">
     <%
	 int wid=0; 
	 if(article.getRe_level()>0){
	    wid=5*(article.getRe_level());
	 %>
	    <img src="../images/level.gif" width="<%=wid%>">
	    <img src="../images/re.gif">
	<%}else{%>
	   <img src="../images/level.gif" width="<%=wid%>" height="16">
	<%}%>
	
	<% int num = article.getNum();
	   int ref = article.getRef();
	   int re_step = article.getRe_step();
	   int re_level = article.getRe_level();
	%>
	<%=article.getSubject()%>
	<p class="date"><%=sdf.format(article.getReg_date())%><br>
	<pre><%=article.getContent()%></pre><br>
	<%try{
    	id = (String)session.getAttribute("id");
      }catch(Exception e){}%>
	<%if(id.equals(writer)) {%>
	  <button id="edit" 
	   name="<%=num+","+pageNum%>" onclick="edit(this)">수정</button>
	  <button id="delete" 
	   name="<%=num+","+pageNum%>" onclick="del(this)">삭제</button>
	<%}else{ %>
	  <button id="reply" 
	   name="<%=num+","+ref+","+re_step+","+re_level+","+pageNum%>" 
	  onclick="reply(this)">댓글쓰기</button>
	<%}%>
  </ul>
<%}%>
</div>
<%}%>

<%-- 페이지 이동 처리 --%>
<div id="jump" class="box3">
<%
if (count > 0) {
   int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
   int startPage = 1;
		
   if(currentPage % pageSize != 0)
      startPage = (int)(currentPage/pageSize)*pageSize + 1;
   else
      startPage = ((int)(currentPage/pageSize)-1)*pageSize + 1;
	
   int pageBlock = 3; //페이지들의 블럭단위 지정
   int endPage = startPage + pageBlock-1;
   
   if (endPage > pageCount) endPage = pageCount;
        
   if (startPage > pageBlock) {%>
      <button id="juP" name="<%=startPage - pageBlock%>" 
          onclick="p(this)" class="w2">이전</button>
      &nbsp;
<% }
   for (int i = startPage ; i <= endPage ; i++) {  
     if(currentPage == i){%>
      <button id="ju" name="<%=i%>" 
         onclick="p(this)" class="w1"><%=i%></button>
    <%}else{ %> 
      <button id="ju" name="<%=i%>" 
         onclick="p(this)" class="w"><%=i%></button>
    <%}%>
      &nbsp; 
<% }
   if (endPage < pageCount) {  %>
      &nbsp;
      <button id="juN" name="<%=startPage + pageBlock%>" 
           onclick="p(this)" class="w2">다음</button>
<%
   }
}//108라인 if꺼
%>
</div>