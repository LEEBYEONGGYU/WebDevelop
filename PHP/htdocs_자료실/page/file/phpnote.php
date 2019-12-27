<?php include $_SERVER['DOCUMENT_ROOT']."/db.php"; ?>
<?php include $_SERVER['DOCUMENT_ROOT']."/include/header.php"; ?>
	<div id="sub_visual">
	</div>
	<!--- main --->
	<div id="sub_main">
		<div id="sub_main_in">
			<div id="sub_con_t">
				<b>PHP쪽지</b>
			</div>
			<h5>쪽지관련 자료파일입니다.</h5>
			<table class="list-table_sub">
						<thead>
							<th width="60">번호</th>
							<th width="500">이름</th>
							<th width="200">업로드 날짜</th>
						</thead>
						<?php
							$sql = mq("select * from note order by idx desc limit 0,6");
							while($note = $sql->fetch_array()){
						?>
						<tbody>
							<tr>
								<td><?php echo $note['idx']; ?></td>
								<td><a href="not_read.php?idx=<?php echo $note['idx'];?>"><?php echo $note['title']; ?></a></td>
								<td><?php echo $note['date']; ?></td>
							</tr>
						</tbody>
					<?php }?>
				</table>
		</div>
	</div>
	<!---main end--->
	<?php include "../../include/footer.php"; ?>