<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/include/db.jsp" %>
    <%
    	String userid = (String)session.getAttribute("userid");
    	System.out.println("아이디는"+userid);
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>TIME MARKET</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="/timemarket_front/css/main.css">
<link rel="stylesheet" type="text/css" href="/timemarket_front/css/sub.css">
<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/timemarket_front/css/jquery.timepicker.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/timemarket_front/js/jquery.timepicker.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="/timemarket_front/js/script.js"></script>
</head>
<body>
	<!-- HEADER -->
	<header>
		<div id="header_in">
			<div id="nav_bt">
				<ul>
					<li class="sear_bt"><img src="/timemarket_front/imgs/search_b.png" alt="search_b" title="search_b" class="se_bt" /></li>
					<li><a href="/timemarket_front/page/member/mypage.jsp"><img src="/timemarket_front/imgs/shop_bt.png" alt="shop_bt" title="shop_bt"/></a></li>
					
					<%
					//만약 세션 유저아이디가 없다면
					if(session.getAttribute("userid")==null){%>
					<li class="login_bottom2"><img src="/timemarket_front/imgs/sign_bt.png" alt="sign_bt" title="sign_bt" /></li>
					
					<% }else if(session.getAttribute("userid").equals("admin")){ //유저아이디가 admin과 같다면 %>
					<li class=""><a href="/timemarket_front/page/member/admin.jsp"><img src="/timemarket_front/imgs/admin_bt.png" alt="" title="" /></a></li>
					<% }else{ //그게 아니라면  %>
						<li class=""><a href="/timemarket_front/page/member/mypage.jsp"><img src="/timemarket_front/imgs/mypage_bt.png" alt="" title="" /></a></li>
					<% }%>
				</ul>
			</div>
			<div id="logo"><a href="/timemarket_front/index.jsp">TIME MARKET</a></div>
			<nav>
				<ul>
					<li><a href="/timemarket_front/page/about/about.jsp">마켓소개</a></li>
					<li><a href="/timemarket_front/page/product/sale/product.jsp">제품</a></li>
					<li><a href="/timemarket_front/page/product/sale/sale.jsp">베스트 상품</a></li>
					<li><a href="/timemarket_front/page/board/board.jsp">고객센터</a></li>
				</ul>
			</nav>
		</div>
	</header>

<!--로그인 폼-->
<div class="join_frm2" id="login_2">
	<form action="/timemarket_front/page/member/login_ok.jsp" method="post">
		<div id="in_box" class="idpw_box">
			<input type="text" name="userid" maxlength="20" placeholder="사용자 아이디" required />
			<input type="password" name="userpw" maxlength="20" placeholder="사용자 비밀번호" required/>
		</div>
		<span id="idpw_find"><a href="#">아이디나 비밀번호를 잊어버리셨나요?</a></span>
		<span id="join_mem"><a href="#">회원가입</a></span>
		<div id="log_box_bot">
			<button>LOGIN</button>
		</div>
	</form>
</div>

<div id="join_frm">
	<form action="/timemarket_front/page/member/join_ok.jsp" method="post">
		<div id="frm_con">
			<ul>
				<li>아이디</li>
				<li><input type="text" id="userid" name="userid" title="아이디" value="" class="check"/></li>
				<li id="id_check"><!---+아이디를 체크합니다.=--></li>
			</ul>
			<ul>
				<li>비밀번호</li>
				<li><input type="password" name="pw" id="pw" value="" required /></li>
			</ul>
			<ul>
				<li>전화번호</li>
				<li>
					<input type="text" name="phone" id="phone" value=""  required size="5" maxlength="5" />-
					<input type="text" name="phone2" id="phone2" value="" required size="5" maxlength="5"/>-
					<input type="text" name="phone3" id="phone3" value=""  required size="5" maxlength="5" />
				</li>
			</ul>
			<ul>
				<li>이름</li>
				<li><input type="text" name="name" id="name" value=""  required size="5" maxlength="5" /></li>
			</ul>
			<ul>
				<li>이메일</li>
				<li><input type="text" name="email" id="email" value=""  required />@<select id="email2" name="email2"><option value="naver.com">naver.com</option><option value="daum.net">daum.net</option><option value="nate.com">nate.com</option></select></li>
			</ul>
			<ul>
				<li>회원구분</li>
				<li>
					<select name="mem_gu">
						<option value="일반회원">일반회원</option>
						<option value="판매자">판매자</option>
					</select>
			</ul>
		</div>
		<div id="join_bbb">
			<ul>
				<li><input type="submit" value="회원가입"  /></li>
				<li><input type="reset" value="다시쓰기" /></li>
			</ul>
		</div>
	</form>
</div>
<!-- HEADER END -->
