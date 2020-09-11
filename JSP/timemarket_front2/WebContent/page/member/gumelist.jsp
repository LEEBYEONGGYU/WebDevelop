<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">마이페이지 - 구매내역</div>
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
	<th width="250">구매날짜</th>
	<th width="500">상품정보</th>
	<th width="100">상태</th>
	</tr>
	
</thead>
<tbody>

<sql:query var="rs" dataSource="jdbc/jsptest">
	select * from purchase order by purnum desc
</sql:query>
<c:forEach var="row" items="${rs.rows}">  
<tr>
		<td><c:out value='${row["purindate"]}'/></td>
		<td>
		<p style="width:150px; height:100px; border:solid 1px green;"></p>
		<ul>
			<li><c:out value='${row["purindate"]}'/></li>
			<li>수량 : 1개 / 구매번호 : <c:out value='${row["purnum"]}'/></li>
			<li>
   
   <sql:query var="rs" dataSource="jdbc/jsptest">
	select * from purchase_op where puropnum=? order by puropnum desc
	<sql:param value="${purnum }" />
	</sql:query>
	
   	<c:forEach var="row" items="${rs.rows}"> 
   	
   	<p>옵션 : <c:out value='${row["puropname"]}'/></p>
   		</c:forEach>
			</li>
			<li><b> <c:out value='${row["purprice"]}'/></li>
		</ul></td>
		<td>구매완료</td>
	</tr>
   </c:forEach>
</tbody>
</table>
	</div>
	<%@ include file="/include/footer.jsp" %>