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
<!-- CONTENT -->
<div id="sub_content">
	<div id="sub_content_in">
	<div id="sub_con_t">우리 상품입니다.</div>
	<div id="sub_con_t2">판매리스트입니다. </div>

<% String imgsrc = request.getRealPath("/upload/product/"); %>
<sql:query var="rs" dataSource="jdbc/jsptest">
select * from product order by p_enddate desc
</sql:query>
   
   <c:forEach var="row" items="${rs.rows}">  
   		<a href="product_info.do?p_code=<c:out value='${row["p_code"]}'/>">
	<article class="arti">
		<span class="ja_name"><c:out value='${row["p_manuf"]}'/> <c:out value='${row["p_name"]}'/></span>
		<p class="ja_info"></p>
		<p class="ja_price">가격 : <c:out value='${row["p_price"]}'/></p>
		<p class="ja_img"><img src="/timemarket_front/upload/product/<c:out value='${row["p_img"]}'/>" alt="<c:out value='${row["p_img"]}'/>" title="<c:out value='${row["p_img"]}'/>" width="162" height="162"/></p>
		<p class="ja_endtime">
		남은시간 : 
		<script> 
			var stDate = new Date().getTime();
			var edDate = new Date('<c:out value='${row["p_enddate"]}'/>').getTime(); // 종료날짜
			var RemainDate = edDate - stDate;
			
			var hours = Math.floor((RemainDate % (1000 * 60 * 60 * 24)) / (1000*60*60));
			var miniutes = Math.floor((RemainDate % (1000 * 60 * 60)) / (1000*60));
			var seconds = Math.floor((RemainDate % (1000 * 60)) / 1000);
			
			m = hours + "시간" +  miniutes + "분" + seconds + "초 남음" ; // 남은 시간 text형태로 변경
			document.write(m);   // div 영역에 보여줌 			
		</script>  
		</p>
		<p class="ja_suco"><c:out value='${row["p_cot"]}'/> 개남음</p>
	 </article></a>
   </c:forEach>
</div>
</div>
<%@ include file="/include/footer.jsp" %>