<?php

include "../db.php";
$sql = mq("insert into product (pro_pic,pro_name,price,pro_count,date) values('".$_POST['pr_img']."','".$_POST['pr_name']."','".$_POST['pr_price']."','".$_POST['pro_count']."',now())");
?>
<script>alert("등록되었습니다");</script>
<meta http-equiv="refresh" content="0 url=mypage.php">