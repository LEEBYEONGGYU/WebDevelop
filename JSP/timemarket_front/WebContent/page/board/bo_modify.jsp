<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<jsp:include page="/include/header.jsp"></jsp:include>
<div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">마이페이지 - 문의내역</div>
	<div id="sub_con_t2">나의 활동을 관리합니다.</div>
		<jsp:include page="../sub_pmenu.jsp"></jsp:include>
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
            
                <form action="bo_modifyok.do?idx=<c:out value='${row["idx"]}'/>" method="post" enctype="multipart/form-data">
                <input type="hidden" name="qa_idx" value="<c:out value='${row["idx"]}'/>" />
                    <div class="in_text">
                        <textarea name="qa_title" rows="1" cols="55"  maxlength="100" required><c:out value='${row["title"]}'/></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="qa_text" rows="1" cols="55" required style="height:300px;"><c:out value='${row["content"]}'/></textarea>
                    </div>
                    <div class="in_text in_date">
                    	<input type="file" name="qa_file" value="<c:out value='${row["file"]}'/>" /> <span>현재 파일 : <c:out value='${row["file"]}'/></span>
                    </div>
                    <div class="bt_se">
                        <button type="submit">글 작성</button>
                    </div>
                </form>
               
            </div>
             </c:forEach>
        </div>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>