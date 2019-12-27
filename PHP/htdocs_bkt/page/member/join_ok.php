<?php
	$phone = $_POST['phone'].'-'.$_POST['phone2'].'-'.$_POST['phone3'];
	$email = $_POST['email'].'@'.$_POST['email2'];

$sql = mq("insert into member (id,pw,model,phone,email) values('".$_POST['userid']."','".$_POST['pw']."','".$_POST['model']."','".$phone."','".$email."')");

?>
<script type="text/javascript">alert('회원가입이 완료되었습니다.');</script>
<meta http-equiv="refresh" content="0 url=/">