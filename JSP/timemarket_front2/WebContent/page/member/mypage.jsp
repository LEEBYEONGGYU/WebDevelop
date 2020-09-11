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
	<div id="sub_con_t">마이페이지 - 장바구니</div>
	<div id="sub_con_t2">나의 활동을 관리합니다.</div>
	<div id="mymenu">
		<ul>
			<a href="mypage.do"><li id="my_basket" class="fl"></li></a>
			<a href="gumelist.do"><li id="my_gume" class="fl"></li></a>
			<a href="qaboard.do"><li id="my_qa" class="fl"></li></a>
			<a href="mypage_info.do"><li id="my_info" class="fl"></li></a>
		</ul>
	</div>
	</div>
	</div>
	<div id="my_content">
		<table class="list-table">
<thead>
<tr>
	<th width="200">장바구니번호</th>
	<th width="200">상품이미지</th>
	<th width="200">상품명</th>
	<th width="200">가격</th>
	<th width="120">수량</th>
	<th width="100">구매</th>
	</tr>
	
</thead>
<tbody>
<sql:query var="rs" dataSource="jdbc/jsptest">
	select * from basket order by b_num desc
</sql:query>

<c:forEach var="row" items="${rs.rows}">  
 		<form action="bas_guok.do" method="post">
			<tr>
				<td><c:out value='${row["b_num"]}'/><input type="hidden" value="<c:out value='${row["b_num"]}'/>" name="b_num" /></td>
				<td><img src="/timemarket_front/upload/product/<c:out value='${row["b_name"]}'/>.jpg" alt="<c:out value='${row["b_name"]}'/>" title="<c:out value='${row["b_name"]}'/>" width="400" height="402"/></td>
				<td><c:out value='${row["b_num"]}'/><input type="hidden" name="pro_name" value="<c:out value='${row["b_num"]}'/>" />
				
		<p>옵션상품</p>
		
		<sql:query var="rs" dataSource="jdbc/jsptest">
			select * from basket_op where bo_num=? order by bo_num desc
				<sql:param value='${row["b_num"]}'></sql:param>
		</sql:query>
		
		<sql:query var="rs" dataSource="jdbc/jsptest">
	select * from basket order by b_num desc
</sql:query>



		<p><c:out value='${row["bo_name"]}'/><input type="hidden" name="pro_op" value="<c:out value='${row["bo_name"]}'/>" /></p>
		</td>
		<td><c:out value='${row["b_price"]}'/><input type="hidden" name="pro_price" value="<c:out value='${row["b_price"]}'/>" /></td>
		<td><c:out value='${row["b_count"]}'/><input type="hidden" name="pro_cot" value="<c:out value='${row["b_count"]}'/>" /></td>
		<td><input type="submit" value="구매" /></td>
</tr>
</form>
</c:forEach>
</tbody>
</table>
	</div>
	<%@ include file="/include/footer.jsp" %>