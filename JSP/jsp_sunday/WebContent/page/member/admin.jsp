<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">관리자페이지 - 판매현황</div>
	<div id="sub_con_t2">홈페이지를 관리합니다.</div>
	<div id="mymenu">
		<ul>
			<a href="admin.jsp"><li id="ad_proout" class="fl"></li></a>
			<a href="upproduct.jsp"><li id="ad_proup" class="fl"></li></a>
			<a href="mem_admin.jsp"><li id="ad_mem" class="fl"></li></a>
		</ul>
	</div>
	</div>
	</div>
	<div id="my_content">
		<table class="list-table">
<thead>
<tr>
	<th width="150">구매자아이디</th>
	<th width="150">상품코드</th>
	<th width="150">상품명</th>
	<th width="150">구매날짜</th>
	<th width="150">가격</th>
	</tr>
	
</thead>
<tbody>
<% 
try {
	
	sql = "select * from 판매 order by 날짜 desc ";
	psmt = con.prepareStatement(sql);
	//psmt.setString(1,"userid");
	rs = psmt.executeQuery();
		while(rs.next()){
			String 구매자아이디= rs.getString("구매자아이디");
			String 상품코드= rs.getString("상품코드");
			String 상품명= rs.getString("상품명");
			String 구매날짜= rs.getString("날짜");
			String 가격= rs.getString("가격");
%>
	<tr>
	
		<td><%=구매자아이디 %></td>
		<td><%=상품코드 %></td>
		<td><%=상품명 %></td>
		<td><%=구매날짜 %></td>
		<td><%=가격 %>원</td>
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