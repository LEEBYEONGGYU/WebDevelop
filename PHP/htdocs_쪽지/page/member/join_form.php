<?php 
include "../../include/db.php"; 
include "../../include/header.php"; 

if(isset($_SESSION['userid'])){
	echo "<script>alert('잘못된 접근입니다.'); history.back();</script>"; 
}else{
?>
<div id="wrap">
	<div id="join_form_in">
		<div id="mem_t" >회원가입</div>
			<form action="join_ok.php" method="post">
				<div id="join_f">
					<div class="form-group">
						<label for="userid">아이디</label>
						<div class="mb"><input type="text" class="inp" id="userid" name="userid" placeholder="아이디" /></div>
					</div>
					<div class="form-group">
						<label for="userpw">비밀번호</label>
						<div class="mb"><input type="password" class="inp" id="userpw" name="userpw" placeholder="비밀번호" /></div>
					</div>
					<div class="form-group">
						<label for="name">이름</label>
						<div class="mb"><input type="text" class="inp" id="name" name="name" placeholder="이름을 입력해 주세요" /></div>
					</div>
					<div class="form-group">
						<label for="e-mail">이메일</label>
				        <div class="mb"><input type="text" class="inp" id="e-mail" name="email" placeholder="이메일을 입력해주세요" /></div>
				    </div>
				    <div class="form_btn">
				    	<button type="submit" class="form_bt">회원가입</button>
				       	<button type="reset" class="form_bt2">가입취소</button>
				    </div>
				</div> <!-- join_f end -->
			</form>
		</div>
	</div><!--- wrap end -->
<?php } include "../../include/footer.php"; ?>