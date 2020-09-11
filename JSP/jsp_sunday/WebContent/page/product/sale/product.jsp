<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!-- CONTENT -->
<div id="sub_content">
	<div id="sub_content_in">
	<div id="sub_con_t">우리 상품입니다.</div>
	<div id="sub_con_t2">판매리스트입니다. </div>

<% 
try {
	
	sql = "select * from 일반상품 order by 마감일자 desc ";
	psmt = con.prepareStatement(sql);
	//psmt.setString(1,"userid");
	rs = psmt.executeQuery();
	String 상품코드;
	String 제조사명;
	String 상품명;
	String 상품;
	String 마감시간;
	int 재고수량;
	int 가격;
		while(rs.next()){
			상품코드 = rs.getString("상품코드");
			제조사명= rs.getString("제조사명");
			상품명= rs.getString("상품명");
			가격=rs.getInt("가격");
			재고수량=rs.getInt("재고수량");
			마감시간=rs.getString("마감일자");
%>

	<a href="product_info.jsp?procode=<%=상품코드%>"><article class="arti">
		<span class="ja_name"><%=제조사명 %> <%=상품명 %></span>
		<p class="ja_info">이것은 카메라다</p>
		<p class="ja_price">가격 : <%=가격%></p>
		<p class="ja_img">IMG 160x160</p>
		<p class="ja_endtime">
		남은시간 : 
		<script>
			var stDate = new Date().getTime();
			var edDate = new Date('<%=마감시간%>').getTime(); // 종료날짜
			var RemainDate = edDate - stDate;
			
			var hours = Math.floor((RemainDate % (1000 * 60 * 60 * 24)) / (1000*60*60));
			var miniutes = Math.floor((RemainDate % (1000 * 60 * 60)) / (1000*60));
			var seconds = Math.floor((RemainDate % (1000 * 60)) / 1000);
			
			m = hours + "시간" +  miniutes + "분" + seconds + "초 남음" ; // 남은 시간 text형태로 변경
			document.write(m);   // div 영역에 보여줌 
			</script>
		</p>
		<p class="ja_suco"><%=재고수량 %> 개남음</p>
	 </article></a>
<% } }catch(Exception e){
	e.printStackTrace();
}%>
</div>
</div>
<%@ include file="/include/footer.jsp" %>