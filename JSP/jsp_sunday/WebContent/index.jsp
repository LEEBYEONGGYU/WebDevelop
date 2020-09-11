<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp" %>
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
	<div id="trash1"></div>
	<div id="trash2"></div>

	<div id="trash3"></div>
	<div id="trash4"></div>

	<div id="trash5"></div>
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
<script type="text/javascript">
	$(document).ready(function(){
		tid=setInterval('msg_time()',1000); // 타이머 1초간격으로 수행
	});

	var stDate = new Date().getTime();
	var edDate = new Date('2019-12-07 15:00:00').getTime(); // 종료날짜
	var RemainDate = edDate - stDate;

	function msg_time() {
		var hours = Math.floor((RemainDate % (1000 * 60 * 60 * 24)) / (1000*60*60));
		var miniutes = Math.floor((RemainDate % (1000 * 60 * 60)) / (1000*60));
		var seconds = Math.floor((RemainDate % (1000 * 60)) / 1000);
		
		m = hours + ":" +  miniutes + ":" + seconds ; // 남은 시간 text형태로 변경
		document.all.timer.innerHTML = m;   // div 영역에 보여줌 

		if (RemainDate < 0) {      
		 // 시간이 종료 되었으면..
		 clearInterval(tid);   // 타이머 해제
	}else{
		RemainDate = RemainDate - 1000; // 남은시간 -1초
	}
}
</script>
<div id="con_back2"></div><!-- 사다리꼴 배경 -->
	<!--첫번째 상품 -->
	<section>
		<div id="pro_1">
			<h3 style="text-align: center; line-height: 200px;"></h3>
			<p style=" font-size: 24px; color:red;">남은시간 : <span id="timer"></span></p>
		</div>
		<!--두번째 상품 -->
		<div id="pro_2">
			<h3 style="text-align: center; line-height: 200px;"></h3>        
		</div>
		<!--세번째 상품 -->
		<div id="pro_3">
			<h3 style="text-align: center; line-height: 200px;"></h3>
		</div>
	</section>
	<div id="con_t2">한번봐라</div>
<div id="content_in">
	<article class="arti">
		<h3 style="text-align: center; line-height: 200px;"></h3>
	 </article>
	 <article class="arti_2">
	 	<h3 style="text-align: center; line-height: 200px;"></h3>
		</article>
		<article class="arti">
			<h3 style="text-align: center; line-height: 200px;"></h3>
	 	</article>
	 	<article class="arti_2">
	 		<h3 style="text-align: center; line-height: 200px;"></h3>
		</article>
	</div>
<%@ include file="/include/footer.jsp" %>