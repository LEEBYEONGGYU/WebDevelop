<!--- 모바일 영역 시작 =-->
<div class="intro_in">
	<div class="sub_bt">
		<ul>
			<li>모바일</li>
			<li class="sub_bt2">BK Telecom이 선호하는 모바일 플랫폼입니다.</li>
		</ul>
	</div>
	<div class="requ">
		<ul class="requ_sel">
		<?php
			$sql = mq("select * from mobile order by idx desc");
			while($mobile = $sql->fetch_array()){
		 ?>
			<li class="fl"><img src="/imgs/mobile/<?php echo $mobile['code'] ?>.jpg" alt="<?php echo $mobile['code'] ?>" width="150" height="150" data-src="<?php echo $mobile['code'] ?>" data-title="<?php echo $mobile['code'] ?>" data-area="<?php echo $mobile['code'] ?>" data-date="<?php echo $mobile['code'] ?>" /></li>
			<?php } ?>
		</ul>
	</div>


</div>
<!-- 모바일 영역끝 =-->