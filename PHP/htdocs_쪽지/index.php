<?php 

include "/include/db.php";
include "/include/header.php"; 

//세션 userid가 있으면 경고창과 뒤로 이동
if(isset($_SESSION['userid'])){
	echo "<script>alert('잘못된 접근입니다.'); history.back();</script>"; 
}else{
?>
<div id="wrap">
	<div id="wrap_in">
		<div id="mem_t">Member Login</div>
		<!--- MemberLogin 텍스트와 input태그 사이 줄 긋기 -->
		<div id="mem_li"></div>
		<form action="/page/member/login_ok.php" method="post">
		<div id="in_box" class="idpw_box">
			<input type="text" name="userid" maxlength="20" placeholder="사용자 아이디" required />
			<input type="password" name="userpw" maxlength="20" placeholder="사용자 비밀번호" required/>
		</div>
		<span id="idpw_find"><a href="#">아이디나 비밀번호를 잊어버리셨나요?</a></span>
		<span id="join_mem"><a href="/page/member/join_form.php">회원가입</a></span>
		<div id="log_box_bot">
			<button>LOGIN</button>
		</div>
	</form>
</div><!--- wrap_in end -->
</div><!--- wrap end -->
<?php } include "include/footer.php"; ?>