<meta charset="utf-8" />
<?php

include "../db.php";
include "../password.php";

$userpw = password_hash($_POST['userpw'], PASSWORD_DEFAULT);
$username = $_POST['name'];
$adress = $_POST['adress'];
$sex = $_POST['sex'];

$sql = mq("update member set pw='".$userpw."', name='".$username."', adress='".$adress."',sex='".$sex."',email='".$_POST['email']."' where id='".$_SESSION['userid']."'");
echo "<script>alert('정보변경이 완료되었습니다 	'); history.back();</script>";

?>