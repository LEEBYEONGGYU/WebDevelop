<?php
	//include 파일들
	include $_SERVER['DOCUMENT_ROOT']."/header.php"; 
	include $_SERVER['DOCUMENT_ROOT']."/db.php"; 

	//만약 no가 있다면 $page변수에 GET으로 요청받은 no를 넣어준다.
	if(isset($_GET['bname'])){
		$page = $_GET['bname'];
	}else{
		//GET으로 요청받은 no가 없다면 board_list테이블에서 첫번째 행을 select한다
		$sql = mq("select * from board_list limit 1");
		$board = $sql->fetch_array();
		//$page변수에 select결과행에서 board_name컬럼을 선택하여 변수에 넣는다
		$page = $board["board_name"];
	}
?>
<div id="board_area"> 
	<h1>게시판 생성, 삭제</h1>
	<h4>게시판을 생성하고 삭제할 수 있습니다.</h4>
	<br />
	<h3 style="color:red;">현재 게시판 : <?php echo $page; ?></h3>
	<br />
		<div id="board_list">
			<div id="write_btn">
				<ul>
					<li><a href="/page/board/cre_board.php"><button>게시판 생성</button></a></li>
					<li><a href="/page/board/tbl_board_del.php?bname=<?php echo $page; ?>"><button>게시판 삭제</button></a></li>
					<li>
						<form action="/page/board/write.php" method="post">
							<input type="hidden" value="<?php echo $page; ?>" name="nowpage" />
							<button type="submit">글쓰기</button>
						</form>
					</li>
				</ul>
			</div>
			<div id="bo">
				<p><b>게시판 선택</b></p>
					<?php 
						$sql = mq("select * from board_list order by idx asc");
						while($board_list=$sql->fetch_array()){
					?>
				<ul>
					<li style="margin-left:10px;"><a href="/page/board/board.php?bname=<?php echo $board_list['board_name']; ?>"><?php echo $board_list['board_name']; ?></a></li>
				</ul>
			<?php } ?>
		</div>
		<div id="board_area_in">
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
					//만약 $page변수에 값이 있으면 게시판 리스트를 보여준다
					if(isset($page)){
						$sql3 = mq("select * from $page order by idx desc");
						while($board2=$sql3->fetch_array()){
					?>
					<tbody>
						<tr>
							<td><?php echo $board2['idx']; ?></td>
							<td>
								<?php 
									//만약 $page에 담긴 테이블에 lock_sta가 있으면 
									if(isset($board2['lock_sta'])){
										//만약 lock_sta값이 0과 같다면 title만 출력하고
										if($board2['lock_sta']==0){
											echo $board2['title'];
										}else{
											//아니면 title과 lock_sta값을 같이 출력
											echo $board2['title'], '[',$board2['lock_sta'],']'; 
										}
									}else{
										//lock_st가 없으면 title만 출력
										echo $board2['title'];
									}
								?>
							</td>
							<td><?php echo $board2['name']; ?></td>
							<td><?php echo $board2['date']; ?></td>
						</tr>
					</tbody>
				<?php } }?>
			</table>
		</div>
	</div><!---board_list end --->	
</body>
</html>