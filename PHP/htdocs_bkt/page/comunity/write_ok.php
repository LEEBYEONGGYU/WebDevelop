<?php

$tmpfile = $_FILES['pic']['tmp_name'];
$filename = $_FILES['pic']['name'];
$file_ext_arr = explode(".",$filename);
$ext = strtolower(end($file_ext_arr));

$_POST['pic'] = uniqid(time()).".".$ext;


move_uploaded_file($tmpfile,"./upload/board/".$_POST['pic']);


		$sql = mq("insert into board(title,name,content,file,date) values('".$_POST['title']."','".$_SESSION['id']."','".$_POST['content']."','".$_POST['pic']."',now())");
		echo "<script>alert('글쓰기 완료되었습니다.');</script>"; 
?>
<meta http-equiv="refresh" content="0 url=/comunity/board" />