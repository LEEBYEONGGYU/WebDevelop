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
		<table class="list-table">
<thead>

<tr>
	<th width="70">번호</th>
	<th width="150">아이디</th>
	<th width="350">제목</th>
	<th width="240">문의날짜</th>
	<th width="200">답변상태</th>
	<th width="300">파일</th>
	</tr>
	
</thead>
<tbody>

<sql:query var="rs" dataSource="jdbc/jsptest">
	select * from qaboard where userid=? order by idx desc
	<sql:param value="${sessionScope.userid}"></sql:param>
</sql:query>

<c:forEach var="row" items="${rs.rows}"> 
	<tr>
		<td><c:out value='${row["idx"]}'/></td>
		<td><c:out value='${row["userid"]}'/></td>
		<td><a href="../board/bo_read.do?idx=<c:out value='${row["idx"]}'/>"><c:out value='${row["title"]}'/></a></td>
		<td><c:out value='${row["indate"]}'/></td>
		<td><c:out value='${row["qa_status"]}'/></td>
		<td><a href="../down.jsp?filename=<c:out value='${row["file"]}'/>"><c:out value='${row["file"]}'/></a></td>
	</tr>
	</c:forEach>
</tbody>
</table>
	</div>
<jsp:include page="/include/footer.jsp"></jsp:include>