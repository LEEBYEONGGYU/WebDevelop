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
	<div id="sub_con_t">관리자페이지 - QA답변</div>
	<div id="sub_con_t2">구매자님들의 물음에 답변합니다.</div>
	<div id="mymenu">
		<ul>
			<a href="admin.do"><li id="ad_proout" class="fl"></li></a>
			<a href="upproduct.do"><li id="ad_proup" class="fl"></li></a>
			<a href="mem_admin.do"><li id="ad_mem" class="fl"></li></a>
			<a href="qa_admin.do"><li id="qa_admin" class="fl"></li></a>
		</ul>
	</div>
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
		<td><a href="qa_read.do?idx=<c:out value='${row["idx"]}'/>"><c:out value='${row["title"]}'/></a></td>
		<td><c:out value='${row["indate"]}'/></td>
		<td><a href="down.do?filename=<c:out value='${row["file"]}'/>"><c:out value='${row["file"]}'/></a></td>
		<td><a href="qa_read.do?idx=<c:out value='${row["qa_status"]}'/>"><c:out value='${row["qa_status"]}'/></a></td>
	</tr>
	</c:forEach>
</tbody>
</table>
	</div>
	<%@ include file="/include/footer.jsp" %>