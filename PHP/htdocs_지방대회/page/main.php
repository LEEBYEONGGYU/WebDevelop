<div id="flash">
	<div id="flash_inner">
		<?php img("/imgs/m_flash.jpg","s_flash","s_flash");?>
	</div>
</div>
<div id="content">
	<div id="content_inner">
	<!---content lay1=-->
		<div id="con_lay1">
			<div class="con_t">
				<ul>
					<li>로그인</li>
				</ul>
			</div>
			<form action="/page/login_ok.php" method="post">
			<div id="ip_form">
			<?php
			/* login될시 */
				if(isset($_SESSION['id'])){
					echo $_SESSION['id']."님 환영합니다.";
					echo "<li class='navi_lo'><a href='/page/logout.php'>로그아웃</a></li>";
		}else{
			?>
				<ul>
					<li><input type="text" id="id" name="id" title="id" value="아이디" onfocus="this.value='';" size="17" /></li>
					<li id="itop"><input type="password" id="pw" name="pw" title="pw" value="비밀번호" onfocus="this.value='';" size="18" /></li> 
				</ul>
			</div>
			<div id="login_bt">
				<input type="image" src="/imgs/login_bt.jpg" alt="login_bt" title="login_bt" />
			</div>
		</form>
		<div id="ip_service">
			<ul>
				<li><a href="/page/ip_service.php">아이디/비밀번호 찾기</a></li>
				<li><a href="/member/member/member">회원가입</a></li>
			</ul>
					<?php }?>

		</div>
	</div>
	<!---con lay1 end=-->
	<!--- content lay2 =-->
	<div id="con_lay2">
		<div class="con_t">
			<ul>
				<li>쇼핑정보</li>
			</ul>
		</div>
		<div id="arrow">
			<a href="/"><?php img("/imgs/arrow.jpg","arrow","arrow"); ?></a>
		</div>
		<div id="shop_info">
			<ul id="info_p">
				<li><?php img("/imgs/ame.jpg","ame","ame");?></li>
				<li class="info_pa">상품명: 아메리카노</li>
				<li class="">원산지 : 수단</li>
				<li class="">가격 : 2,000원</li>
			</ul>
			<ul id="info_p2">
				<li><?php img("/imgs/rate.jpg","rate","rate");?></li>
				<li class="info_pa">상품명 : 라테</li>
				<li class="">원산지 : 국내</li>
				<li class="">가격 : 2,000원</li>
			</ul>
			<ul id="info_p3">
				<li><?php img("/imgs/keyfoo.png","keyfoo","keyfoo");?></li>
				<li class="info_pa">상품명 : 키푸치노</li>
				<li>원산지 : 미국</li>
				<li>가격 : 2,000원</li>
			</ul>
		</div>
		<div id="arrow2">
			<a href="/"><?php img("imgs/arrow2.jpg","arrow2","arrow2"); ?></a>
		</div>
	</div>
	<!---content_lay2 end=-->
	<!---content_lay3=-->
	<div id="con_lay3">
		<div class="con_t">
			<ul>
				<li>빠른메뉴</li>
			</ul>
		</div>
		<div id="quick_bt">
			<ul>
				<li class="bt"><a href="/cafe/infomation"><?php img("/imgs/quick_bt.png","quick_bt","quick_bt");?></a></li>
				<li class="bt2"><a href="/active/basket"><?php img("/imgs/quick_bt2.jpg","quick_bt2","quick_bt2");?></a></li>
				<li class="bt3"><a href="/board/board"><?php img("/imgs/quick_bt3.jpg","quick_bt3","quick_bt3"); ?></a></li>
				<li class="bt4"><a href="/search/search"><?php img("/imgs/quick_bt4.jpg","quick_bt4","quick_bt4");?></a></li>
			</ul>
		</div>
	</div>
	<!---content_lay3 end=-->
	<!---content_lay4 =-->
	<div id="con_lay4">
		<div class="con_t">
			<ul>
				<li>고객센터</li>
			</ul>
		</div>
		<div id="cphone">
			<?php img("/imgs/cphone.jpg","cphone","cphone"); ?>
		</div>
		<div id="cnum">
			<ul>
				<li>문의주시면 친절하게</li>
				<li>상담해드립니다.</li>
				<li class="cnum2">1544-7575</li>
			</ul>
		</div>
	</div>
		<div id="con_lay5">
			<div class="con_t">
				<ul>
					<li>자유게시판</li>
				</ul>
			</div>
			<div id="bo_b">
			<?php
				$sql = "select * from board order by no desc";
				$res = mysql_query($sql. " limit 0,5");
				while($board = mysql_fetch_array($res)){
			?>
			<ul>
				<li class="board_t1"><a href="/board/read/<?php echo $board['no'];?>"><?php echo $board['title']; ?></a></li>
			</ul>
			<ul>
				<li class="board_t1 board_p"><?php echo $board['date']; ?></li>
			</ul>
		<?php }?>
		</div>
	</div>
	<!---content_lay4 end=-->
	<!---banner=-->
	<div id="banner">
	<!--- php img --->
		<?php img("/imgs/banner.jpg","banner","banner");?>
	</div>
		<div id="memsu">
		<ul>
			<li>회원 수 : 50</li>
			<li>판매제품 갯수 : 48</li>
			<li>등록된 제품 갯수 : 52</li>
		</ul>
	</div>
</div>
</div>