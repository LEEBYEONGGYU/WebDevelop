<?php include $_SERVER['DOCUMENT_ROOT']."/header.php"; ?>
	<div id="board_write">
		<h1><a href="/">자유게시판</a></h1>
		<h4>글을 작성하는 공간입니다.</h4>
			<div id="write_area">
				<form action="write_ok.php" method="post" enctype="multipart/form-data">
					<input type="hidden" name="bo_name" value="<?php echo $_POST['nowpage']; ?>">
					<div id="in_title">
						<textarea name="title" id="utitle" rows="1" cols="55" placeholder="제목" maxlength="100" required></textarea>
					</div>
					<div class="wi_line"></div>
					<div id="in_content">
						<textarea name="content" id="ucontent" placeholder="내용" required></textarea>
					</div>

					<?php
						$boname = $_POST['nowpage'];
						$sql = mq("show full columns from $boname");
						while($board=$sql->fetch_array()){

						if($board['Field']=='file'){ 
							echo '파일 : <input type="file" name="b_file" />';
						}
						if($board['Field']=='lock_sta'){
							echo '글 잠금 : <input type="checkbox" name="lock_post" />';
						}
					}
						?>
					<div class="bt_se">
						<button type="submit">글 작성</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>