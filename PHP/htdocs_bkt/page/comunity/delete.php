<?php
	$sql = mq("delete from board where idx='".$url[2]."'");
?>
<script>
	alert("삭제되었습니다.");location.href("/comunity/board");
</script>