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
	<sql:query var="rs" dataSource="jdbc/jsptest">
	select * from qaboard where idx=?
	<sql:param value="${param.idx}"></sql:param>
</sql:query>

<c:forEach var="row" items="${rs.rows}"> 
	<div id="board_read">
	<h1><c:out value='${row["title"]}'/></h1>
		<div id="user_info">
			<c:out value='${row["indate"]}'/>
				<div id="bo_line"></div>
			</div>
			<div>
				파일 : <a href="../down.do?filename=<c:out value='${row["file"]}'/>"><c:out value='${row["file"]}'/></a>
			</div>
			<div id="bo_content">
				<c:out value='${row["text"]}'/>
			</div>
	<!-- 목록, 수정, 삭제 -->
	<div id="bo_ser">
		<ul>
			<li><a href="../member/mem_myqa.do">[목록으로]</a></li>
			<li><a href="bo_modify.do?idx=<c:out value='${row["idx"]}'/>">[수정]</a></li>
			<li><a href="bo_delete.do?idx=<c:out value='${row["idx"]}'/>">[삭제]</a></li>
		</ul>
	</div>
	</div>
</c:forEach>
<!-- 글 불러오기 -->
	
	
	
	<sql:query var="rs" dataSource="jdbc/jsptest">
		select * from qaboarddat where qa_idx=?
	<sql:param value="${param.idx}"></sql:param>
	</sql:query>
	<c:forEach var="row" items="${rs.rows}"> 
<h2>A. <c:out value='${row["title"]}'/>	</h2>
	<div id="qaboline"></div>
	<div id="qaatext">
		<c:out value='${row["content"]}'/>
	
	</div>
	<br />
	<span>답변일자 : <c:out value='${row["bo_date"]}'/></span>


</c:forEach>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>