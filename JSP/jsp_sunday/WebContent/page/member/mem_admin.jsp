<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">관리자페이지 - 회원관리</div>
	<div id="sub_con_t2">홈페이지를 관리합니다.</div>
	<div id="mymenu">
		<ul>
			<a href="admin.jsp"><li id="my_basket" class="fl"></li></a>
			<a href="upproduct.jsp"><li id="my_gume" class="fl"></li></a>
			<a href="mem_admin.jsp"><li id="my_qa" class="fl"></li></a>
		</ul>
	</div>
	</div>
	</div>
	<div id="my_content">
		<table class="list-table">
<thead>
<tr>
	<th>장바구니번호</th>
	<th>사용자아이디</th>
	<th>상품명</th>
	<th>가격</th>
	<th>수량</th>
	<th>구매</th>
	</tr>
	
</thead>
<tbody>
<% 
try {
	
	sql = "select * from 장바구니 order by 장바구니번호 desc ";
	psmt = con.prepareStatement(sql);
	//psmt.setString(1,"userid");
	rs = psmt.executeQuery();
		while(rs.next()){
			String 장바구니번호= rs.getString("장바구니번호");
			String 사용자아이디= rs.getString("사용자아이디");
			String 상품명= rs.getString("상품명");
			String 가격= rs.getString("가격");
			String 수량= rs.getString("수량");
%>
<form action="구매form.jsp" method="post">
	<tr>
	
		<td><%=장바구니번호 %></td>
		<td><%=사용자아이디 %></td>
		<td><%=상품명 %><input type="hidden" name="pro_name" value="<%=상품명 %>" /></td>
		<td><%=가격 %><input type="hidden" name="pro_price" value="<%=가격 %>" /></td>
		<td><%=수량 %><input type="hidden" name="pro_price" value="<%=수량 %>" /></td>
		<td><input type="submit" value="구매" /></td>
	
</tr>
</form>
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