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
<div id="sub_content">
	<div id="sub_content_in">
	
	<!-- sql쿼리 -->
	<sql:query var="rs" dataSource="jdbc/jsptest">
		select * from product where p_code=?
		<sql:param value="${param.p_code}" />
	</sql:query>
   
   <!-- 남은시간 -->
   <c:forEach var="row" items="${rs.rows}">  
   
	<div id="pro_infoimg">
					<img src="/timemarket_front/upload/product/<c:out value='${row["p_img"]}'/>" alt="<c:out value='${row["p_img"]}'/>" title="<c:out value='${row["p_img"]}'/>" width="400" height="402"/>
	<div id="pro_infobox">
		<div id="pro_infot1">
			<h2>[<c:out value='${row["p_manuf"]}'/>] <c:out value='${row["p_name"]}'/><input type="hidden" value="<c:out value='${row["p_code"]}'/>" id="pcode" /></h2>
			<span id="pro_infocode">상품코드 : <c:out value='${row["p_code"]}'/></span>
		</div>
		<div id="pro_infoprice"><c:out value='${row["p_price"]}'/>원</div>
		
		<div id="pro_infentime"><b>남은시간 :</b></div>
		 <script>
		$(document).ready(function(){
			tid=setInterval('msg_time()',1000); // 타이머 1초간격으로 수행
		});
		
		function msg_time() {
			
			var stDate = new Date().getTime();
 			var edDate = new Date('<c:out value='${row["p_enddate"]}'/>').getTime(); // 종료날짜
			var RemainDate = edDate - stDate;
		var hours = Math.floor((RemainDate % (1000 * 60 * 60 * 24)) / (1000*60*60));
		var miniutes = Math.floor((RemainDate % (1000 * 60 * 60)) / (1000*60));
		var seconds = Math.floor((RemainDate % (1000 * 60)) / 1000);
		m = hours + "시간" +  miniutes + "분" + seconds + "초" ; // 남은 시간 text형태로 변경
		document.getElementById("pro_infentime").innerHTML="<b>남은시간 : "+m;   // div 영역에 보여줌
		if (RemainDate < 0) {      
			 // 시간이 종료 되었으면..
			 clearInterval(tid);   // 타이머 해제
		}else{
			RemainDate = RemainDate - 1000; // 남은시간 -1초
		}
	} 
		</script>
		</c:forEach>
   
   	<!--  옵션선택 부분 -->
		<div id="pro_infoopt">
			<ul>
				<li class="fl">옵션선택 : </li>
				<li>
				<select name="pil" id="pil" style="margin-left:80px; width:200px; height:30px;">
				<option value="1. 필수선택">1. 필수선택</option>
				<c:forEach var="row" items="${rs.rows}">  
   		<div class="pro_1 fl" style="margin-left:70px;">
			<img src="upload/product/<c:out value='${row["p_img"]}'/>" alt="" title="" width="200" height="170" style="margin-left:50px;"/>
 			<p style=" font-size: 24px; font-weight:bold;"></p>
			<p style=" font-size: 24px; color:red;">남은시간 : <span id="timer"></span></p>
 		</div>
   </c:forEach>

				<c:forEach var="row" items="${rs.rows}">  
			   		<option value="<c:out value='${row["p_name"]}'/>"><c:out value='${row["p_name"]}'/>[단품]</option>
				</c:forEach>
				</select>
				
				</li>
			</ul>
			<ul>
				<li style="margin-left:150px;">
				<select name="lens" id="lens" style="width:200px; height:30px;">
				<option>2. 렌즈선택</option>
				
				<sql:query var="rs" dataSource="jdbc/jsptest">
					select * from product_op where po_code=? and po_wname=?
					<sql:param value="${param.p_code}" />
					<sql:param value="${ '렌즈'}" />
				</sql:query>
				<c:forEach var="row" items="${rs.rows}">  
					<option value="<c:out value='${row["po_name"]}'/>"><c:out value='${row["po_name"]}'/></option>
				</c:forEach>
				</select>
				</li>
				
				<li style="margin-left:150px;">
				<select name="sdcard" id="sdcard" style="width:200px; height:30px;">
				<option>3. 메모리카드 선택</option>
				<sql:query var="rs" dataSource="jdbc/jsptest">
					select * from product_op where po_code=? and po_wname=?
					<sql:param value="${param.p_code}" />
					<sql:param value="${ '메모리카드'}" />
				</sql:query>
				<c:forEach var="row" items="${rs.rows}">  
					<option value="<c:out value='${row["po_name"]}'/>"><c:out value='${row["po_name"]}'/></option>
				</c:forEach>
				</select></li>
				
				
				<li style="margin-left:150px;">
				<select name="tridae" id="tridae" style="width:200px; height:30px;">
				<option>4. 삼각대 선택</option>
				<sql:query var="rs" dataSource="jdbc/jsptest">
					select * from product_op where po_code=? and po_wname=?
					<sql:param value="${param.p_code}" />
					<sql:param value="${ '삼각대'}" />
				</sql:query>
				<c:forEach var="row" items="${rs.rows}">  
					<option value="<c:out value='${row["po_name"]}'/>"><c:out value='${row["po_name"]}'/></option>
				</c:forEach>
				</select></li>
			</ul>
		</div>
		<div id="pro_infototal">
			<ul>
				<li>총 수량 : 0개</li>
				<li>총 상품금액 : 23232원</li>
			</ul>
		</div>
		

		<div id="">
			<input type="submit" value="구매하기" id="pro_infogubt"/>
			<input type="button" value="장바구니" id="pro_jangbt"/>
		</div>
	</div>
	</div>
	
	<sql:query var="rs" dataSource="jdbc/jsptest">
					select * from product where p_code=?
					<sql:param value="${param.p_code}" />
				</sql:query>	
				
	<div id="pro_infocontent">
	<c:forEach var="row" items="${rs.rows}">  
	<img src="/timemarket_front/upload/product/<c:out value='${row["p_img"]}'/>" alt="<c:out value='${row["p_img"]}'/>" title="<c:out value='${row["p_img"]}'/>" width="162" height="162"/>
	</c:forEach>
	</div>
</div>
</div>

<!--  jqueryui dialog를 위한 거 -->
<div id="basket_succ" style="display:none;">
	선택한 상품이 장바구니에 담겼습니당 아이좋아~
</div>
<div id="gume_succ" style="display:none;">
	구매가 완료되었습니다
</div>
<%@ include file="/include/footer.jsp" %>