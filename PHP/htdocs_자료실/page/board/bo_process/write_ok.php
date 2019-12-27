<?php

include $_SERVER['DOCUMENT_ROOT']."/db.php";
$userpw = password_hash($_POST['pw'], PASSWORD_DEFAULT);
if(isset($_POST['lockpost'])){
	$lo_post = '1';
}else{
	$lo_post = '0';
}

$tmpfile =  $_FILES['b_file']['tmp_name'];
$o_name = $_FILES['b_file']['name'];
$filename = iconv("UTF-8", "EUC-KR",$_FILES['b_file']['name']);
$folder = "../../upload/".$filename;
move_uploaded_file($tmpfile,$folder);

$sql = mq("insert into free_board(name,pw,title,content,lock_post,file) values('".$_POST['name']."','".$userpw."','".$_POST['title']."','".$_POST['content']."','".$lo_post."','".$o_name."')");
echo "<script>alert('글쓰기 완료되었습니다.');</script>"; 
?>
<meta http-equiv="refresh" content="0 url=../board.php" />