<?php include $_SERVER['DOCUMENT_ROOT']."/db.php"; ?>
<?php include $_SERVER['DOCUMENT_ROOT']."/include/header.php"; ?>
	<div id="sub_visual"></div>
	<!-- main -->
	<div id="sub_main">
	<?php
		$bno = $_GET['idx']; /* bno함수에 idx값을 받아와 넣음*/
		$sql = mq("select * from subfile where idx='".$bno."'"); /* 받아온 idx값을 선택 */
		$subfile = $sql->fetch_array();
	?>
<!-- 글 불러오기 -->
<div id="board_read">
	<h2><?php echo $subfile['title']; ?></h2>
		<div id="user_info">
			<?php echo $subfile['name']; ?> <?php echo $subfile['date']; ?>
				<div id="bo_line"></div>
			</div>
			<div>
				파일 : <a href="../../file/subfile/<?php echo $subfile['file'];?>" download><?php echo $subfile['file']; ?></a>
			</div>
			<div id="bo_content">
				<?php echo nl2br("$subfile[content]"); ?>
			</div>
			<div id="bo_ser"><a href="hcj.php">[목록으로]</a></div>
			<div style="height:40px;"></div>
		</div>
	</div>
	<!---main end--->
	<?php include "../../include/footer.php"; ?>