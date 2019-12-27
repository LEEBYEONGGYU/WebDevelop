<?php
include $_SERVER['DOCUMENT_ROOT']."/header.php";
include $_SERVER['DOCUMENT_ROOT']."/db.php";
?>
<div id="board_area"> 
	<h1>회원레벨게시판</h1>
	<h4>회원레벨에 따라 이용하는 게시판입니다</h4>
		<span id="mem_info">
			<?php
				if(isset($_SESSION['userid'])){ //세션 userid가 있으면 페이지를 보여줍니다
					// lo_point변수에 sql쿼리결과를 저장
					$sql = mq("select * from levelpoint where userid='".$_SESSION['userid']."'");
					$lo_point = $sql->fetch_array();
			?>
			<?php echo $_SESSION['userid']; ?>님 어서오세요. &nbsp;&nbsp;&nbsp;<a href="/page/member/logout.php">로그아웃</a><br />
				<?php
					switch ($lo_point['point']) {
					case '0':
					echo "현재등급 : 새싹등급 0포인트";
					break;
							
					case '1':
					echo "현재등급 : 일반등급 1포인트";
					break;

					case '2':
					echo "현재등급 : 열심등급 2포인트";
					break;
					
					case '3';
					echo "현재등급 : 별신등급 3포인트";
					break;

					case '4';
					echo "현재등급 : 달신등급 4포인트";
					break;

					default:
					echo "현재등급 : 슈퍼등급 ",$lo_point['point'],"포인트";
					break;
				} //switch문 끝 
			?>
			<?php }else{ ?><!--세션 userid체크해서 세션값 없으면 로그인 폼 표시 -->
				<form action="/page/member/login_ok.php" method="post">
					<ul>
						<li><input type="text" name="userid" placeholder="아이디" required /></li>
						<li><input type="text" name="userpw" placeholder="비밀번호" required /></li>
						<li><input type="submit" value="로그인"></li>
						<li> <a href='/page/member/join_form.php'>회원가입</a></li>
					</ul>
				</form>
			<?php } ?>
		</span>
		<div id="board_list">
			<p><b>게시판 선택</b></p>
				<ul>
					<li><a href="/page/board/board.php">자유게시판</a></li>
					<li><a href="/page/board/board2.php">일반유저게시판</a></li>
					<li><a href="/page/board/board3.php">열심게시판</a></li>
					<li><a href="/page/board/board4.php">별신게시판</a></li>
					<li><a href="/page/board/board5.php">달신게시판</a></li>
				</ul>
			</div>
			<?php
				if(!isset($_SESSION['userid'])){
					echo "<div id='not_use'>로그인을 해야 볼 수 있습니다.</div>";
				}else if( $lo_point['point']=='4' || $lo_point['point']>'4'){
			?>
			<table class="list-table">
				<thead>
					<tr>
						<th width="70">번호</th>
						<th width="100">제목</th>
						<th width="120">글쓴이</th>
						<th width="100">작성일</th>
					</tr>
				</thead>
				<?php
					$sql = mq("select * from board order by idx desc limit 0,5");  
					while($board = $sql->fetch_array()){

					$title=$board["title"]; 
						if(strlen($title)>30){ 
							$title=str_replace($board["title"],mb_substr($board["title"],0,30,"utf-8")."...",$board["title"]);
						}
					?>
					<tbody>
						<tr>
							<td><?php echo $board['idx']; ?></td>
							<td><a href='#'><?php echo $title; ?></a></td>
							<td><?php echo $board['name']?></td>
							<td><?php echo $board['date']?></td>
						</tr>
					</tbody>
				<?php } ?>
			</table>
			<div id="write_btn">
				<a href="/page/board/write.php"><button>글쓰기</button></a>
			</div>
		</div>
		<?php }else{
			echo "<div id='not_use'>달신유저만 볼 수 있는 게시판입니다.<br />글을 작성해서 1포인트를 적립하세요.(달신등급 4포인트)</div>";
		}?>
</body>
</html>