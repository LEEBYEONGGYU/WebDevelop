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
	<div id="sub_con_t">관리자페이지 - 판매현황</div>
	<div id="sub_con_t2">판매현황을 관리합니다.</div>
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
	<th width="150">판매자아이디</th>
	<th width="150">구매자아이디</th>
	<th width="150">상품코드</th>
	<th width="150">상품명</th>
	<th width="150">판매날짜</th>
	<th width="150">가격</th>
	</tr>
	
</thead>
<tbody>
<sql:query var="rs" dataSource="jdbc/jsptest">
	select * from sale order by pandate desc
</sql:query>
<c:forEach var="row" items="${rs.rows}"> 
<tr>
		<td><c:out value='${row["panid"]}'/></td>
		<td><c:out value='${row["panuserid"]}'/></td>
		<td><c:out value='${row["panpcode"]}'/></td>
		<td><c:out value='${row["panpname"]}'/></td>
		<td><c:out value='${row["pandate"]}'/></td>
		<td><c:out value='${row["panprice"]}'/>원</td>
</tr>
</c:forEach>
</tbody>
</table>
	</div>
	<%@ include file="/include/footer.jsp" %>