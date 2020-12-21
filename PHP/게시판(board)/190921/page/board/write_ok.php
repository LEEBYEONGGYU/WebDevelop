<?php

include $_SERVER['DOCUMENT_ROOT']."/db.php";
$date = date('Y-m-d');

$mqq = mq("alter table board auto_increment =1"); //auto_increment 값 초기화

$sql= mq("insert into board(name,title,content,date) values('".$_SESSION['userid']."','".$_POST['title']."','".$_POST['content']."',now())");
$sql= mq("insert into levelpoint(userid,point) values('".$_SESSION['userid']."','".$_POST['title']."','".$_POST['content']."',now())");
echo "<script>alert('글쓰기 완료되었습니다.');</script>";

$hit = mysqli_fetch_array(mq("select * from levelpoint where userid ='".$_SESSION['userid']."'"));
$hit = $hit['point'] + 1;
$fet = mq("update levelpoint set point = '".$hit."' where userid = '".$_SESSION['userid']."'");


?>
<meta http-equiv="refresh" content="0 url=/" />