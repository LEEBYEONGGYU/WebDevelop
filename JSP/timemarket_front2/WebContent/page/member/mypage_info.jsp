do<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">마이페이지 - 회원정보</div>
	<div id="sub_con_t2">나의 활동을 관리합니다.</div>
	<div id="mymenu">
		<ul>
			<a href="mypage.do"><li id="my_basket" class="fl"></li></a>
			<a href="gumelist.do"><li id="my_gume" class="fl"></li></a>
			<a href="qaboard.do"><li id="my_qa" class="fl"></li></a>
			<a href="mypage_info.do"><li id="my_info" class="fl"></li></a>
		</ul>
	</div>
	</div>
	</div>
	<div id="my_content">
		<script>alert("준비중입니다"); history.back();</script>
	</div>
	<%@ include file="/include/footer.jsp" %>