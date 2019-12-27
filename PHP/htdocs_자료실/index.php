<?php include $_SERVER['DOCUMENT_ROOT']."/db.php"; "db.php"; ?>
<?php include $_SERVER['DOCUMENT_ROOT']."/include/header.php"; ?>

<!-- visual -->
<div id="visual">
	<div id="visual_t">안녕하세요. S Writer 자료실입니다.</div>
	<div id="visual_t2">모든 자료는 자유롭게 사용 가능합니다</div>
</div>
<!-- visual end -->

<!-- main -->
<div id="main">
	<div id="main_in">
		<section id="con_lay1">
			<span class="con_t">PHP게시판</span><span class="con_more"><a href="page/file/phpboard.php">+더보기</a></span>
				<div class="main_board">
					<ul>
						<li class="title w60 t_line t_top_line">번호</li>
						<li class="title w270 t_line t_top_line">이름</li>
						<li class="title w200 t_top_line">업로드 날짜</li>
					</ul>
						<?php 
						$sql = mq("select * from board order by idx desc limit 0,5");
						while($board = $sql->fetch_array()){
					?>
					<ul>
						<li class="list w60 lt_line"><?php echo $board['idx']; ?></li>
						<li class="list w270 lt_line"><a href="page/file/bo_read.php?idx=<?php echo $board['idx'];?>"><?php echo $board['title']; ?></a></li>
						<li class="	list w200 lt_line"><?php echo $board['date']; ?></li>
					</ul>
				<?php } ?>
			</div>
		</section>
		<section id="con_lay2">
			<span class="con_t">PHP쪽지</span><span class="con_more"><a href="page/file/phpnote.php">+더보기</a></span>
			<div class="main_board">
					<ul>
						<li class="title w60 t_line t_top_line">번호</li>
						<li class="title w270 t_line t_top_line">이름</li>
						<li class="title w200 t_top_line">업로드 날짜</li>
					</ul>
						<?php 
							$sql = mq("select * from note order by idx desc limit 0,5");
							while($note = $sql->fetch_array()){
						?>
					<ul>
						<li class="list w60 lt_line"><?php echo $note['idx']; ?></li>
						<li class="list w270 lt_line"><a href="page/file/not_read.php?idx=<?php echo $note['idx']; ?>"><?php echo $note['title']; ?></a></li>
						<li class="list w200 lt_line"><?php echo $note['date']; ?></li>
					</ul>
				<?php } ?>
			</div>
		</section>
	</div>
</div>
<!--main end-->
<?php include "include/footer.php";?>