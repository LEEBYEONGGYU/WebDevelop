<?php include $_SERVER['DOCUMENT_ROOT']."/db.php"; ?>
<?php include $_SERVER['DOCUMENT_ROOT']."/include/header.php"; ?>
	<!--- header end -->
	<div id="sub_visual"></div>
	<!--- main --->
	<div id="sub_main">
		<div id="sub_main_in">
			<div id="sub_con_t">
				<b>PHP게시판</b>	
			</div>
			<h5>게시판관련 자료파일입니다.</h5>
			<table class="list-table_sub">
						<thead>
							<th width="60">번호</th>
							<th width="500">이름</th>
							<th width="200">업로드 날짜</th>
						</thead>
						<?php
							$sql = mq("select * from board order by idx desc");
							while($board = $sql->fetch_array()){
						?>
						<tbody>
							<tr>
								<td><?php echo $board['idx']; ?></td>
								<td><a href="bo_read.php?idx=<?php echo $board['idx']; ?>"><?php echo $board['title']; ?></a></td>
								<td><?php echo $board['date']; ?></td>
							</tr>
						</tbody>
					<?php }?>
				</table>
		</div>
	</div>
	<!---main end--->
	<?php include "../../include/footer.php"; ?>