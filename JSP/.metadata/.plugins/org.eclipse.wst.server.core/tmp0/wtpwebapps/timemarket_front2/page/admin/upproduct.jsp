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
	<div id="sub_con_t">관리자페이지 - 상품등록</div>
	<div id="sub_con_t2">상품을 등록합니다.</div>
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
	<div id="my_content" >
		<h1>일반상품 목록</h1>
		
		<table class="list-table">
<thead>

<tr>
	<th width="100">상품코드</th>
	<th width="150">제조사명</th>
	<th width="250">상품명</th>
	<th width="180">품목명</th>
	<th width="180">재고수량</th>
	<th width="200">상품가격</th>
	<th width="200">입고날짜</th>
	<th width="200">마감날짜</th>
	</tr>
	
</thead>
<tbody>
<sql:query var="rs" dataSource="jdbc/jsptest">
	select * from product order by p_code desc
</sql:query>

<c:forEach var="row" items="${rs.rows}"> 
	<tr>
		<td><c:out value='${row["p_code"]}'/></td>
		<td><c:out value='${row["p_manuf"]}'/></td>
		<td><c:out value='${row["p_name"]}'/></td>
		<td><c:out value='${row["p_wname"]}'/></td>
		<td><c:out value='${row["p_cot"]}'/></td>
		<td><c:out value='${row["p_price"]}'/></td>
		<td><c:out value='${row["p_indate"]}'/></td>
		<td><c:out value='${row["p_enddate"]}'/></td>
	</tr>
</c:forEach>

	
</tbody>
</table>
<a href="product_form.do"><button>상품등록</button></a>
	<h1 style="margin-top:20px;">옵션상품 목록</h1>
		<table class="list-table">
<thead>

<tr>
	<th width="100">상품코드</th>
	<th width="150">제조사명</th>
	<th width="250">상품명</th>
	<th width="180">재고수량</th>
	<th width="200">옵션상품가격</th>
	<th width="200">입고날짜</th>
	</tr>
	
</thead>
<tbody>

<sql:query var="rs" dataSource="jdbc/jsptest">
	select * from product_op order by po_code desc
</sql:query>
<c:forEach var="row" items="${rs.rows}"> 
	<tr>
		<td><c:out value='${row["po_code"]}'/></td>
		<td><c:out value='${row["po_manuf"]}'/></td>
		<td><c:out value='${row["po_name"]}'/></td>
		<td><c:out value='${row["po_cot"]}'/></td>
		<td><c:out value='${row["po_price"]}'/></td>
		<td><c:out value='${row["po_indate"]}'/></td>
	</tr>
	</c:forEach>
</tbody>
</table>
<a href="productop_form.do"><button>옵션상품등록</button></a>
</div>
	<%@ include file="/include/footer.jsp" %>