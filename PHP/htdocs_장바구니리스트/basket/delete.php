<?php
include "../db.php";
$pno = $_GET["idx"];
$sql = mq("delete from product where idx=$pno;");
?>
<script type="text/javascript">alert("삭제되었습니다"); history.back();</script>