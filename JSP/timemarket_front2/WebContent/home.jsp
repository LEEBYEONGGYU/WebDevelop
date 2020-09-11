<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="include/header.jsp"></jsp:include>
<!-- VISUAL IMAGE -->
<div id="slide">
	<ul id="slider">
		<li ><img src="/timemarket_front/imgs/visual1.png" title="img1" alt="img1" style="z-index:-10;"/></li>
		<li ><img src="/timemarket_front/imgs/visual1.png" title="img1" alt="img1" style="z-index:-10;"/></li>
		<li style="z-index:-10;"><img src="/timemarket_front/imgs/visual1.png" title="img1" alt="img1" style="z-index:-10;"/></li>
	</ul>
	<!-- 슬라이드 버튼 -->
	<ul id="slide_index">
		<li><a href="javascript:animation(1)" class="now" title="animate">첫번째로</a></li>
		<li><a href="javascript:animation(2)" title="animate">두번째로</a></li>
		<li><a href="javascript:animation(3)" title="animate">세번째로</a></li>
	</ul>
	
	<!-- 슬라이드 왼쪽 오른쪽 버튼 -->
	<div id="slide_button">
		<a href="javascript:animation('left')" title="left" id="left_button"><img src="imgs/left.png"></a>
		<a href="javascript:animation('right')" title="left" id="right_button"><img src="imgs/right.png"></a>
	</div>
	
	<!-- 슬라이드 박스 효과 -->
	<div id="trash6"></div>
	<div id="trash7"></div>
</div>
<!-- VISUAL IMAGE END -->

<!-- CONTENT -->
<div id="con_line"></div>
<!--라인 그림자 효과 -->
<div id="con_back_t">
	<div id="con_t">
		마감임박
	</div>
</div>

<div id="con_back2"></div><!-- 사다리꼴 배경 -->
<section>
	<sql:query var="rs" dataSource="jdbc/jsptest">
		select * from product order by p_enddate desc limit 0,3
	</sql:query>
	<c:forEach var="row" items="${rs.rows}">  
   		<div class="pro_1 fl" style="margin-left:70px;">
			<img src="upload/product/<c:out value='${row["p_img"]}'/>" alt="" title="" width="200" height="170" style="margin-left:50px;"/>
 			<p style=" font-size: 24px; font-weight:bold;"></p>
			<p style=" font-size: 16px; color:red;">남은시간 : 
				<script>
					var stDate = new Date().getTime();
		 			var edDate = new Date('<c:out value='${row["p_enddate"]}'/>').getTime(); // 종료날짜 --%>
		 			var RemainDate = edDate - stDate;
					
		 			var hours = Math.floor((RemainDate % (1000 * 60 * 60 * 24)) / (1000*60*60));
					var miniutes = Math.floor((RemainDate % (1000 * 60 * 60)) / (1000*60));
		 			var seconds = Math.floor((RemainDate % (1000 * 60)) / 1000);
					
		 			m = hours + "시간" +  miniutes + "분" + seconds + "초 남음" ; // 남은 시간 text형태로 변경
		 			document.write(m);   // div 영역에 보여줌 
				</script>
			<span id="timer"></span></p>
 		</div>
   </c:forEach>
</section>

<div id="con_t2">한번봐라</div>
	<div id="content_in">
		<sql:query var="rs" dataSource="jdbc/jsptest">
			select * from product order by p_enddate desc limit 0,4
		</sql:query>
  		<c:forEach var="row" items="${rs.rows}">  
			<a href="page/product/product_info.do?p_code=<c:out value='${row["p_code"]}'/>"> 
				<article class="arti">
					<span class="ja_name"><c:out value='${row["p_manuf"]}'/> <c:out value='${row["p_name"]}'/></span>
					<p class="ja_info"></p>
					<p class="ja_price">가격 : <c:out value='${row["p_price"]}'/>원</p>
					<p class="ja_img"><img src="upload/product/<c:out value='${row["p_img"]}'/>" alt="<c:out value='${row["p_img"]}'/>" title="<c:out value='${row["p_img"]}'/>" width="162" height="142"/></p>
					<p class="ja_endtime">남은시간 : 
			 		<script> 
			 			var stDate = new Date().getTime();
			 			var edDate = new Date('<c:out value='${row["p_enddate"]}'/>').getTime(); // 종료날짜 --%>
			 			var RemainDate = edDate - stDate;
						
			 			var hours = Math.floor((RemainDate % (1000 * 60 * 60 * 24)) / (1000*60*60));
						var miniutes = Math.floor((RemainDate % (1000 * 60 * 60)) / (1000*60));
			 			var seconds = Math.floor((RemainDate % (1000 * 60)) / 1000);
						
			 			m = hours + "시간" +  miniutes + "분" + seconds + "초 남음" ; // 남은 시간 text형태로 변경
			 			document.write(m);   // div 영역에 보여줌 
			 		</script>
				</p>
			</article></a> 
		</c:forEach>
	</div>
	<jsp:include page="include/footer.jsp"></jsp:include>