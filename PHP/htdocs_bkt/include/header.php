<!doctype html>
<html lang="kr">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="SubLime Text">
  <meta name="Author" content="lbk">
  <meta name="Keywords" content="Bk Telecom">
  <meta name="Description" content="BK Telecom페이지에 오신것을 환영합니다.">
  <title>BK Telecom</title>
    <!--- 모바일용 =-->
  <link rel="stylesheet" type="text/css" href="/css/mobile.css" />
  <link rel="stylesheet" type="text/css" href="/css/main.css" /><!--- main page css =-->
  <link rel="stylesheet" type="text/css" href="/css/sub.css" /><!--- sub page css =-->
  <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" /><!--- jquery ui =-->

  <script type="text/javascript" src="/js/jquery-2.2.1.min.js"></script>
  <script type="text/javascript" src="/js/jquery-ui.js"></script>
  <script type="text/javascript" src="/js/common.js"></script>
</head>
 <body>
<!-- 아이디 실시간 검사 
<script>

$(document).ready(function(e) {
	$(".check").on("keyup", function(){
		var self = $(this); 
		var userid; 
		
		if(self.attr("id") === "userid"){
			userid = self.val(); 
		} 
		
		$.post(
			"/member/id_check",
			{ userid : userid }, 
			function(data){ 
				if(data){
					self.parent().parent().find("li:last-child").html(data); 
					self.parent().parent().find("li:last-child").css("color", "#F00"); 
				}
			}
		);
	});
});
</script>=-->
<div id="join_frm">
	<form action="/member/join_ok" method="post">
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
				<li>모델명</li>
				<li><input type="text" name="model" id="model" value="" required style="ime-mode:disabled;"/></li>
				<li>※모델명은 영어로 적어주세요.</li>
			</ul>
			<ul>
				<li>전화번호</li>
				<li><input type="text" name="phone" id="phone" value=""  required size="5" maxlength="5" />-<input type="text" name="phone2" id="phone2" value="" required size="5" maxlength="5"/>-<input type="text" name="phone3" id="phone3" value=""  required size="5" maxlength="5" /></li>
			</ul>
			<ul>
				<li>이메일</li>
				<li><input type="text" name="email" id="email" value=""  required />@<select id="email2" name="email2"><option value="naver.com">naver.com</option><option value="daum.net">daum.net</option><option value="nate.com">nate.com</option></select></li>
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
<!--- 헤더 =-->
  	<div class="header">
		<div class="menu_b"><!--- 메뉴 백그라운드 =--></div>
	    	<div class="header_in">
	        	<div class="logo">
	            	<a href="/"><?php img("/imgs/logo.png","logo"); ?></a>
	            </div>
				<nav>
					<ul>
						<!--- 메인메뉴 DB 로드 =-->
						<?php
							$sql = mq("select * from menu where lv='0'");
							while($main = $sql->fetch_array()){
							$sql3 = mq("select * from menu where lv='0' && main='".$main['main']."'");
							$sub2 = $sql3->fetch_array()
					?>
					<li><a href="/<?php echo $main['main']; ?>/<?php echo $sub2['sub'] ?>"><?php echo $main['title']; ?></a>
						<ul>
							<?php
								$sql2 = mq("select * from menu where lv='1' && main='".$main['main']."'");
								while($sub = $sql2->fetch_array()){		
							?>
						<li><a href="/<?php echo $main['main']; ?>/<?php echo $sub['sub'] ?>"><?php echo $sub['title']; ?>	</a>
					</li>
				<?php   }?>
			</ul>
		</li>
		<?php	}?>
		</ul>
	</nav>		
</div>
</div>