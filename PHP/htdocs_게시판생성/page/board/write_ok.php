<?php

include $_SERVER['DOCUMENT_ROOT']."/db.php";
$date = date('Y-m-d');

$boardname = $_POST["bo_name"];
$mqq = mq("alter table board auto_increment =1"); //auto_increment 값 초기화
if(isset($_FILES['b_file'])){
	$o_name = $_FILES['b_file']['name'];
}

if(isset($_POST['lock_post'])){
	$lck = 1;
	$sql= mq("insert into $boardname (name,title,content,file,lock_sta,date) values('test','".$_POST['title']."','".$_POST['content']."','".$o_name."','".$lck."',now())");
}else{
	$sql= mq("insert into $boardname (name,title,content,date) values('test','".$_POST['title']."','".$_POST['content']."',now())");
}
?>
<script>alert("글이 게시되었습니다"); location.href="/page/board/board.php?bname=<?php echo $boardname; ?>";</script>