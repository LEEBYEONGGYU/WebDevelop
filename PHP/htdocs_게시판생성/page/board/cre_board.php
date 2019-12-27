<?php include $_SERVER['DOCUMENT_ROOT']."/header.php"; ?>
	<div id="board_write">
		<h1><a href="/">게시판 생성</a></h1>
		<h4>게시판을 생성합니다.</h4>
			<div id="write_area">
				<form action="cre_board_ok.php" method="post">
					<div id="in_title">
						
						<input type="text" size="30" placeholder="게시판 제목을 입력합니다" name="b_name"/>
					</div>
					<div class="wi_line"></div>
					<div id="in_content">
						<h4>게시판에 포함할 항목을 선택합니다</h4> <br />
						<input type="checkbox" name="b_title" value="title"  checked="checked" /> 제목
						<input type="checkbox" name="b_write" value="name"  checked="checked"/> 글쓴이
						<input type="checkbox" name="b_content" value="content"  checked="checked"/> 내용
						<input type="checkbox" name="b_date" value="date"  checked="checked"/> 날짜
						<input type="checkbox" name="b_file" value="file" /> 파일
						<input type="checkbox" name="b_lock" value="lock_sta" /> 글 보호
					</div>
					<div class="bt_se">
						<button type="submit">글 작성</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>