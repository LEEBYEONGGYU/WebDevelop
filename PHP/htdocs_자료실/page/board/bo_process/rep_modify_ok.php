<?php
include $_SERVER['DOCUMENT_ROOT']."/db.php";

$rno = $_POST['rno']; 
$sql = mq("select * from reply where idx='".$rno."'");
$reply = $sql->fetch_array();

$bno = $_POST['b_no'];
$sql2 = mq("select * from board where idx='".$bno."'");
$board = $sql2->fetch_array();


$hash_pw = $reply['pw']; //DB저장된 pw
$dat_pw = $_POST['pw']; //POST로 받아온 pw

if(password_verify($dat_pw, $hash_pw)){
	$sql3 = mq("update reply set content='".$_POST['content']."' where idx = '".$rno."'");
	echo "
	<script>alert('수정되었습니다.');
	history.back();
	</script>";
}else{
	echo "<script>alert('비밀번호가 틀렸습니다.'); history.back();</script>;";
}
