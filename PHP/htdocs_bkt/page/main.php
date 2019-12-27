<script>
		$(function(e){
	slider.on();
});
var slider = {
	on : function(){
		slider.off();
		this.timer = setTimeout(function(){
			animation("right")
		},3000)
	},
	off : function(){
			clearTimeout(this.timer)
		}
}
var pos = 1;
function animation(type){
	slider.off();
	switch(type){
		case "right":
			pos = pos == 3 ? 1 : pos + 1;
		break;
		case "left":
			pos = pos == 1 ? 3 : pos - 1;
		break;
		default:
			pos=parseInt(type);
		break;
	}	
	$(".visual").animate({
		marginLeft : "-" + (pos-1) * 100 + "%"
	},1000,function(){
		slider.on();
	});
}
</script>
<div class="visual_img">
	<ul class="visual">
		<li><img src="/imgs/visual.jpg" alt="visual" title="visual" /></li>
		<li><img src="/imgs/visual2.jpg" alt="visual2" title="visual2" /></li>
		<li><img src="/imgs/visual3.jpg" alt="visual3" title="visual3" /></li>
	</ul>
	<ul class="slider_position">
		<li><a href="javascript:animation(1);" class="now"><div></div></a></li>
		<li><a href="javascript:animation(2);"><div></div></a></li>
		<li><a href="javascript:animation(3);"><div></div></a></li>
	</ul>
</div>
<div class="content">
	<div class="content_in">
		<?php
			if(isset($_POST['id'])){
				$sql = mfa("select * from member where id='{$_POST['id']}'");
				if($sql && $sql['pw'] == $_POST['pw']){
				$_SESSION['id'] = $sql['id'];
				$_SESSION['pw'] = $sql['pw'];
			}
		}
	?>
	<?php if(isset($_SESSION['id'])){
	?>
	<div class="con_lay1_txt">
		<ul>
			<li>MY PAGE</li>
		</ul>
		</div>
		<!--- 로그인 유저 정보표시 =-->
			<?php
				$sql2 = mq("select * from member where id='{$_SESSION['id']}'");
				while($member = $sql2->fetch_array()){
			?>
			<div class="logi_user">	
				<div class="model_pic">
					<img src="/imgs/model/<?php echo $member['model'];?>.jpg" alt="model_name" title="model_name" width="70" height="100" />
				</div>
				<div class="hell">
					<ul>
						<li><?php echo "{$_SESSION['id']}" ?>님 환영합니다.</li>
						<li>사용모델명 : <?php echo $member['model'];?></li>
					</ul>
				</div>	
					<!--- 회원서비스 =-->
				<div class="mem_service">
					<ul>
						<li><a href="/member/logout" class="ad" style="margin-left:30px;">로그아웃</a></li>
						<li><a href="/member/modify" class="">개인정보 수정</a></li>
						<li><?php if($_SESSION['id'] == "admin"){?>
						<a href="/admin/admin" class="ad">관리자</a>
					<?php } ?></li>
				</ul>			
			</div>
		</div>
		<?php };?>
		<?php }else{?>
		<div class="con_lay1_txt">
			<ul>
				<li>LOGIN</li>
			</ul>
		</div>
										
		<form action="/member/login_ok" method="post">
		<div class="lo_id">
			<ul>
				<li><input type="text"  name="id" placeholder="아이디" maxlength="10" size="35" /></li>
				<li><input type="password"  name="pw" placeholder="비밀번호" maxlength="10" size="36" style="position:absolute; top:115px; "/></li>
			</ul>
		</div>
		<div class="lo_ok">
			<input type="image" src="/imgs/login_ok.jpg" />
		</div>
		</form>
		<div class="member_in">
			<ul class="login_bottom">
				<li><img src="/imgs/member_in.jpg" alt="member_in" title="member_in" /></li>
			</ul>
		</div>

<?php } ?>
		<div class="con_lay2_txt">
			<ul>
				<li>NOTICE</li>
			</ul>
		</div>
			<div class="more">
				<ul>
					<li>+more</li>
				</ul>
			</div>
					<div class="board_list">

			<?php
				$sql = mq("select * from notice order by idx desc limit 0,5");
				while($notice = $sql->fetch_array()){
					$title=$notice["title"]; 
					if(strlen($title)>10){
						$title=str_replace($notice["title"],mb_substr($notice["title"],0,10)."...",$notice["title"]);
					}
			?>
			<ul>
				<li class="board_t1"><a href="/comunity/notice_read/<?php echo $notice['idx'];?>"><?php echo $notice['title']; ?></a></li>
			</ul>
			<ul>
				<li class="board_t1 board_p"><?php echo $notice['date']; ?></li>
			</ul>
		<?php }?>
			
		</div>
</div>
</div>

<div class="content2">
	<div class="content2_in">
		<div class="con2_b">
			<ul>
				<li>뛰어난 통신기술력</li>
			</ul>
		</div>
		<div class="con2_bl">
			<ul>
				<li>기존에 경험하지 못한 새로운 변화와 혁신이 처음에는 다소</li>
				<li>낮설은 이상한 시도로 보일 수 있겠지만 이러한 시도들이</li>
				<li>그 이상을 만들고 결국에는 이상을 이루는 것처럼 BK텔레콤</li>
				<li>도 이러한 변화와 혁신, 차별화를 통해 이상적인 통신화사로</li>
				<li>거듭나겠다는 의지를 표현합니다.</li>
			</ul>
		</div>

		<div class="con2_b2">
			<ul>
				<li>빠르고 최적하게</li>
			</ul>
		</div>
		<div class="con2_bb2">
			<ul>
				<li>전국,에서 유명한 카페, 패밀리 레스토랑, 극장, 지하철</li>
				<li>공공장소등에서 바르고 쾌적하게 무선 인터넷을 이용</li>
				<li>할 수 있게 해줍니다. 전국 주요 상권이나 프랜차이즈</li>
				<li>매장에서 까지 고객님들이 많이 방문하는 공공장소에서</li>
				<li>쾌적한 무선인터넷을 만날 수 있습니다.</li>
			</ul>
		</div>
	</div>
</div>
</div>
</div>


<div class="content3">
	<div class="content3_in">
		<div class="mobile_img">
			<ul class="mobile_slide">
				<li><img src="/imgs/note5.jpg" alt="note5" title="note5" /></li>
				<li><img src="/imgs/note5.jpg" alt="note5" title="note5" /></li>
				<li><img src="/imgs/note5.jpg" alt="note5" title="note5" /></li>
			</ul>
		</div>
		<div class="mobile_buy_bt">
			<ul>
				<li><a href=""><img src="/imgs/buy_bt.jpg" alt="buybt" title="buy_bt" /></a></li>
			</ul>
			
		</div>

<!--- tablet plan =-->
		<div class="tablet_kind">
			<ul>
				<li>Tablet Plan</li>
			</ul>
		</div>
		<div class="tablet_name">
			<ul>
				<li>Samsung Tablet 9</li>
			</ul>
		</div>
		<div class="tablet_won">
			<ul>
				<li>602,580원</li>
			</ul>
		</div>
		<div class="tablet_img">
			<?php img("/imgs/tablet.jpg	","tablet"); ?>
		</div>
		<div class="tablet_buy_bt">
			<?php img("/imgs/buy_bt.jpg","buybt"); ?>
		</div>

		</div>
	</div>

<!-- content3 =-->
<div class="content4">
	<div class="content4_in">
		<div class="con4_mt">
			<ul>
				<li>고객과의 약속 더 나은 미래를 열어가는 BK Telecom</li>
			</ul>
		</div>
		<div class="con4_st">
			<ul>
				<li>지난 30여년 동안 한결 같은 사랑과 성원을 보내주신 고객 여러분께 감사 드립니다. 고객 여러분의 변치 않은 마음 덕분에 여러 고객만족도 조사에서 오랜 기간 1위를 지켜왔고,</li>
				<li>국내외에서 명실상부한 대한민국 최고의 이동통신사로 인정받을 수 있었습니다.  앞으로 저희 SK텔레콤은 이에 안주하지 않고, 고객 여러분의 목소리에 더욱 귀 기울이고 긴밀하게 교감</li>
				<li>하여 차별화되고 혁신적인 상품과 서비스를 제공하는데 더욱 속도를 내도록 노력하겠습니다. 아울러, 이동 통신뿐 아니라 ICT 서비스 전방위에 걸쳐 ‘고객과의 새로운 관계’를 정립</li>
				<li>하는데 온 힘을 기울여, 고객들께서 저희 SK텔레콤을 통해 새로운 가치를 느끼고 일상 속에서 ICT의  윤택함을 더 많이 누리실 수 있도록 노력하겠습니다.  그리고 사회로부터 더욱</li>
				<li>신뢰받는 기업이 되기 위해 투명하고 윤리적인 경영을 강화 하고,  전통산업 중소기업, 스타트업 등과의 상생을 기반으로 한 선순환의 생태계를 선도하여  ‘ICT노믹스’의 실현을 앞당겨</li>
				<li>나갈 것입니다. </li>
			</ul>
		</div>
		<div class="con4_rt">
			<a href="/intro/intro"><?php img("/imgs/read_bt.jpg","read_bt"); ?></a>
		</div>
	</div>
</div>