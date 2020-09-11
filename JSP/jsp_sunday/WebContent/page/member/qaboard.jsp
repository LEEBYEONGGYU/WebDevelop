<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">마이페이지 - 문의내역</div>
	<div id="sub_con_t2">나의 활동을 관리합니다.</div>
	<div id="mymenu">
		<ul>
			<a href="mypage.jsp"><li id="my_basket" class="fl"></li></a>
			<a href="gume.jsp"><li id="my_gume" class="fl"></li></a>
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
	<th>구매번호</th>
	<th>구매아이디</th>
	<th>구매상품명</th>
	<th>구매방법</th>
	<th>구매금액</th>
	<th>배송지주소</th>
	<th>배송지전화번호</th>
	<th>배송방법</th>
	</tr>
	
</thead>
<tbody>
	<% 
try {
	
	sql = "select * from 구매 order by 구매번호 desc ";
	psmt = con.prepareStatement(sql);
	//psmt.setString(1,"userid");
	rs = psmt.executeQuery();
		while(rs.next()){
			String 구매번호= rs.getString("구매번호");
			String 구매아이디= rs.getString("구매아이디");
			String 구매상품명= rs.getString("구매상품명");
			String 구매방법= rs.getString("구매방법");
			String 구매금액= rs.getString("구매금액");
			String 배송지주소= rs.getString("배송지주소");
			String 배송지전화번호= rs.getString("배송지전화번호");
			String 배송방법= rs.getString("배송방법");
%>
	<tr>
		<td><%=구매번호 %></td>
		<td><%=구매아이디 %></td>
		<td><%=구매상품명 %></td>
		<td><%=구매방법 %></td>
		<td><%=구매금액 %></td>
		<td><%=배송지주소 %></td>
		<td><%=배송지전화번호 %></td>
		<td><%=배송방법 %></td>
	</tr>
	<% 
		}
}catch(Exception e1) {
	e1.printStackTrace();
}


%>
</tbody>
</table>
	</div>
	<%@ include file="/include/footer.jsp" %>