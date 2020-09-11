<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/include/header.jsp" %>
    <% 
    String pro_code = request.getParameter("procode");
    System.out.println(pro_code);
    
    %>
<div id="sub_content">
	<div id="sub_content_in">

	
<% 
session.setAttribute("userid","uid");
String 상품코드;
String 제조사명;
String 상품명;
String 상품;
String 마감시간;
int 재고수량;
int 가격;
try {
	
	sql = "select * from 일반상품 where 상품코드=?";
	psmt = con.prepareStatement(sql);
	psmt.setString(1,pro_code);
	rs = psmt.executeQuery();
	
		while(rs.next()){
			상품코드 = rs.getString("상품코드");
			제조사명= rs.getString("제조사명");
			상품명= rs.getString("상품명");
			가격=rs.getInt("가격");
			재고수량=rs.getInt("재고수량");
			마감시간=rs.getString("마감일자");
			%>
				<div id="pro_infoimg">
					<h3>제품이미지가 들어감<br /> 502 X 402</h3>
	<div id="pro_infobox">
		<div id="pro_infot1">
			<h2>[<%=제조사명 %>] <%=상품명 %><input type="hidden" value="<%=상품코드%>" id="pcode" /></h2>
			<span id="pro_infocode">상품코드 : <%=상품코드 %></span>
		</div>
		<div id="pro_infoprice"><%=가격 %>원</div>
		
		<div id="pro_infentime"><b>남은시간 :</b></div>
		<script>
		$(document).ready(function(){
			tid=setInterval('msg_time()',1000); // 타이머 1초간격으로 수행
		});
		
		function msg_time() {
			
			var stDate = new Date().getTime();
			var edDate = new Date('<%=마감시간%>').getTime(); // 종료날짜
			var RemainDate = edDate - stDate;
		var days = Math.floor((RemainDate % (1000 * 60 * 60)) / (1000*60));
		var hours = Math.floor((RemainDate % (1000 * 60 * 60 * 24)) / (1000*60*60));
		var miniutes = Math.floor((RemainDate % (1000 * 60 * 60)) / (1000*60));
		var seconds = Math.floor((RemainDate % (1000 * 60)) / 1000);
		m = days + "일" +hours + "시간" +  miniutes + "분" + seconds + "초" ; // 남은 시간 text형태로 변경
		document.getElementById("pro_infentime").innerHTML="<b>남은시간 : "+m;   // div 영역에 보여줌
		if (RemainDate < 0) {      
			 // 시간이 종료 되었으면..
			 clearInterval(tid);   // 타이머 해제
		}else{
			RemainDate = RemainDate - 1000; // 남은시간 -1초
		}
	}
		</script>
		<div id="pro_infoopt">
			<ul>
				<li class="fl">옵션선택 : </li>
				<li>
				<select name="pil" id="pil" style="margin-left:80px; width:200px; height:30px;">
					<option>1. 필수선택</option>
					<option value="<%=상품명 %>"><%=상품명 %>[단품]</option>
					<option value="<%=상품명 %>"><%=상품명 %>+<%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %>+<%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %>+<%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %>+<%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %>+<%=상품명 %></option>
				</select></li>
			</ul>
			<ul>
				<li style="margin-left:150px;">
				<select name="lens" id="lens" style="width:200px; height:30px;">
					<option>2. 렌즈선택</option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
				</select>
				</li>
				
				<li style="margin-left:150px;">
				<select name="sdcard" id="sdcard" style="width:200px; height:30px;">
				<option>3. 메모리카드 선택</option>
					<option value="<%=상품명 %>"><%=상품명 %>[단품]</option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
				</select></li>
				
				
				<li style="margin-left:150px;">
				<select name="tridae" id="tridae" style="width:200px; height:30px;">
					<option>4. 삼각대 선택</option>
					<option value="<%=상품명 %>"><%=상품명 %>[단품]</option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
					<option value="<%=상품명 %>"><%=상품명 %></option>
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
	
	<div id="pro_infocontent">
	<h3>여긴 상품상세이미지가 들어감</h3>
	</div>
			
			<%
		} 
	}catch(Exception e){
			e.printStackTrace();
		}
%>

</div>
</div>

<!--  jqueryui dialog를 위한 거 -->
<div id="basket_succ" style="display:none;">
	선택한 상품이 장바구니에 담겼습니당 아이좋아~
</div>


<div id="gume_frm" style="display:none;">
	<ul>
		<li></li>
		<li></li>
	</ul>
</div>
<%@ include file="/include/footer.jsp" %>