<?php
 include "../../include/db.php"; 

if(isset($_SESSION['userid'])){

  $sen_id = $_POST['fr_name'];
  $uname = $_POST['u_name'];
  $umail = $_POST['u_mail'];

  $fr_chk = mq("select * from friends where fri_name='$sen_id'");
  $frk = $fr_chk->fetch_array();
	if($frk >= 1){
		echo "<script>alert('이미 추가되어있습니다.'); history.back();</script>";
	}else{

		$sql2 = mq("insert into friends(user,fri_name,name,email) values('".$_SESSION['userid']."','".$sen_id."','".$uname."','".$umail."')");

		echo "<script>alert('사용자를 추가했습니다.');</script> <meta http-equiv='refresh'content='0 url=../note.php' />";
	}
}else{
	echo "<script>alert('잘못된 접근입니다.'); location.href='/index.php'; </script>";
} 
?>
