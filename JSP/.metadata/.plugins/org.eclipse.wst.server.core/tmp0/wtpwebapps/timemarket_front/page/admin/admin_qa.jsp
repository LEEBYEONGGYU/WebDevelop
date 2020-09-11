<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.net.URLEncoder" %>
<jsp:include page="/include/header.jsp"></jsp:include>
<div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">관리자페이지 - QA답변</div>
	<div id="sub_con_t2">구매자님들의 물음에 답변합니다.</div>
		<jsp:include page="admin_menu.jsp"></jsp:include>
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
					<th width="300">파일</th>
					<th width="150">답변하기</th>
				</tr>
			</thead>
			<tbody>
			<sql:query var="rs" dataSource="jdbc/jsptest">
				select * from qaboard order by idx desc
			</sql:query>
			<c:forEach var="row" items="${rs.rows}">
				<tr>
					<td><c:out value='${row["idx"]}'/></td>
					<td><c:out value='${row["userid"]}'/></td>
					<td><a href="admin_qaread.do?idx=<c:out value='${row["idx"]}'/>"><c:out value='${row["title"]}'/></a></td>
					<td><c:out value='${row["indate"]}'/></td>
					<td><a href="../down.jsp?filename=${row['file']}" download><c:out value='${row["file"]}' /></a></td>
					<td><a href="admin_qaread.do?idx=<c:out value='${row["qa_status"]}'/>"><c:out value='${row["qa_status"]}'/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>