<?php
	$sql = mq("select * from board where idx='".$url[2]."'");
	$board = $sql->fetch_array();
	$tmpfile = $_FILES['pic']['tmp_name'];
$filename = $_FILES['pic']['name'];
$file_ext_arr = explode(".",$filename);
$ext = strtolower(end($file_ext_arr));

$_POST['pic'] = uniqid(time()).".".$ext;


move_uploaded_file($tmpfile,"./upload/board/".$_POST['pic']);

$sql2 = mq("update board set title='".$_POST['title']."',content='".$_POST['content']."',file='".$_POST['pic']."' where idx='".$url[2]."'");
echo "<script>alert('수정되었습니다.');</script>";
?>
<meta http-equiv="refresh" content="0 url=/comunity/board/read/<?php echo $url[2]; ?>" />
