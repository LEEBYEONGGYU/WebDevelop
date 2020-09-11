<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<jsp:include page="/include/header.jsp"></jsp:include>
<jsp:include page="/include/db.jsp"></jsp:include>
<div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">마이페이지 - 문의내역</div>
	<div id="sub_con_t2">나의 활동을 관리합니다.</div>
	<div id="mymenu">
		<ul>
			<a href="mypage.do"><li id="my_basket" class="fl"></li></a>
			<a href="gume.do"><li id="my_gume" class="fl"></li></a>
			<a href="qaboard.do"><li id="my_qa" class="fl"></li></a>
			<a href="mypage_info.do"><li id="my_info" class="fl"></li></a>
		</ul>
	</div>
	</div>
	</div>
	<div id="my_content">
	<div id="modify_write">
	
	<sql:query var="rs" dataSource="jdbc/jsptest">
		select * from qaboard where idx=?
		<sql:param value="${param.idx}"></sql:param>
	</sql:query>
<c:forEach var="row" items="${rs.rows}"> 
        <h1>문의글 수정</h1>
            <div id="modify_area">
            
                <form action="modify_ok.do?idx=<c:out value='${row["idx"]}'/>" name="bo_form" method="post" enctype="multipart/form-data">
                <input type="hidden" name="userid" value="<%=session.getAttribute("userid") %>" />
                    <div class="in_text">
                        <textarea name="qa_title" rows="1" cols="55" placeholder="<c:out value='${row["title"]}'/>" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="qa_text" rows="1" cols="55" placeholder="<c:out value='${row["content"]}'/>" required style="height:300px;"></textarea>
                    </div>
                    <div class="in_text in_date">
                    	<input type="file" name="qa_file" /> <span>현재 파일 : <c:out value='${row["file"]}'/></span>
                    </div>
                    <div class="bt_se">
                        <button type="submit">글 작성</button>
                    </div>
                </form>
               
            </div>
             </c:forEach>
        </div>
	</div>
	<%@ include file="/include/footer.jsp" %>