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
			<a href="mypage.jsp"><li id="my_basket" class="fl"></li></a>
			<a href="gumelist.jsp"><li id="my_gume" class="fl"></li></a>
			<a href="qaboard.jsp"><li id="my_qa" class="fl"></li></a>
			<a href="mypage_info.jsp"><li id="my_info" class="fl"></li></a>
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
		<td><a href="read.do?idx=<c:out value='${row["idx"]}'/>"><c:out value='${row["title"]}'/></a></td>
		<td><c:out value='${row["indate"]}'/></td>
		<td><c:out value='${row["qa_status"]}'/></td>
		<td><a href="down.do?filename=<c:out value='${row["file"]}'/>"><c:out value='${row["file"]}'/></a></td>
	</tr>
	</c:forEach>
</tbody>
</table>
	</div>
	<%@ include file="/include/footer.jsp" %>