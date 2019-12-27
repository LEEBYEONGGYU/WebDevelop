<?php
include $_SERVER['DOCUMENT_ROOT']."/db.php";

$page = $_GET['bname'];
$sql = mq("drop table $page");

$sql2 = mq("delete from board_list where board_name='$page'");
if($sql=1 && $sql2=1){
	echo "<script>alert('게시판 삭제완료'); location.href='/';</script>";
}else{
	echo "<script>alert('게시판 삭제실패'); history.back();</script>";
}
?>