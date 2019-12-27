<meta charset="utf-8" />
<?php

include "../db.php";
include "../password.php";

$userpw = password_hash($_POST['pw'], PASSWORD_DEFAULT);

$sql = mq("update member set pw='".$userpw."' where id = '".$_SESSION['uid']."'");
session_destroy();
echo "<script>alert('비밀번호를 변경했습니다.'); location.href='/index.php';</script>";

?>