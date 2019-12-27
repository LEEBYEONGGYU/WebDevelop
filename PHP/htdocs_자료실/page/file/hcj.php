<?php include $_SERVER['DOCUMENT_ROOT']."/db.php"; ?>
<?php include $_SERVER['DOCUMENT_ROOT']."/include/header.php"; ?>
	<!--- header end -->
	<div id="sub_visual"></div>
	<!--- main --->
	<div id="sub_main">
		<div id="sub_main_in">
			<div id="sub_con_t">
				<b>Web기타</b>	
			</div>
			<h5>Web 기타 자료파일입니다.</h5>
			<table class="list-table_sub">
						<thead>
							<th width="60">번호</th>
							<th width="500">이름</th>
							<th width="200">업로드 날짜</th>
						</thead>
						<?php
							$sql = mq("select * from subfile order by idx desc");
							while($subfile = $sql->fetch_array()){
						?>
						<tbody>
							<tr>
								<td><?php echo $subfile['idx']; ?></td>
								<td><a href="hcj_read.php?idx=<?php echo $subfile['idx']; ?>"><?php echo $subfile['title']; ?></a></td>
								<td><?php echo $subfile['date']; ?></td>
							</tr>
						</tbody>
					<?php }?>
				</table>
		</div>
	</div>
	<!---main end--->
	<?php include "../../include/footer.php"; ?>