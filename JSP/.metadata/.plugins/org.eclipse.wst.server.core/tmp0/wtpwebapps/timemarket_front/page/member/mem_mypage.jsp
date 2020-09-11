<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<jsp:include page="/include/header.jsp"></jsp:include>
<div id="sub_content_my">
	<div id="sub_content_in">
		<div id="sub_con_t">마이페이지 - 장바구니</div>
		<div id="sub_con_t2">나의 활동을 관리합니다.</div>
		<jsp:include page="../sub_pmenu.jsp"></jsp:include>
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
				<form action="mem_buyok.do" method="post">
				<input type="hidden" name="userid" value="${sessionScope.userid}" /> 
					<tr>
						<td><c:out value='${row["b_num"]}' /><input type="hidden" value="<c:out value='${row["b_num"]}'/>" name="b_num" /></td>
						<td><img src="/timemarket_front/upload/product/<c:out value='${row["b_name"]}'/>.jpg" alt="<c:out value='${row["b_name"]}'/>" title="<c:out value='${row["b_name"]}'/>" width="400"	height="402" /><input type="hidden" value="<c:out value='${row["b_name"]}'/>" name="bas_pname" /></td>
						<td><c:out value='${row["b_num"]}' /><input type="hidden" name="pro_name" value="<c:out value='${row["b_num"]}'/>" />
							<p>옵션상품</p>
							
						
						
						<p>
						<sql:query var="rs2" dataSource="jdbc/jsptest">
							select * from basket_op order by bo_num desc
						</sql:query>
					<c:forEach var="row1" items="${rs2.rows}" varStatus="status">
					<c:out value='${row1["bo_name"]}' />
						<input type="hidden" name="bas_proop<c:out value="${status.count}" />" value="<c:out value='${row1["bo_name"]}' />" />
						<input type="hidden" name="bas_opprice<c:out value="${status.count}" />" value="<c:out value='${row1["bo_price"]}' />" />
					</c:forEach>
						</p></td>
						<td><c:out value='${row["b_price"]}' /><input type="hidden" name="pro_price" value="<c:out value='${row["b_price"]}'/>" /></td>
						<td><c:out value='${row["b_count"]}' /><input type="hidden" name="pro_cot" value="<c:out value='${row["b_count"]}'/>" /></td>
						<td><input type="submit" value="구매" /></td>
					</tr>
				</form>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>