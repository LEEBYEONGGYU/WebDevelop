<?php
	include "../../include/db.php"; 
	
	$bno = $_GET['idx'];
	$sql = mq("delete from recv_note where idx='$bno';");
?>
<script type="text/javascript">alert("삭제되었습니다.");</script>
<meta http-equiv="refresh" content="0 url=../note.php" />