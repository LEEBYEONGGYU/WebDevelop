<!---
<?php
include "/bin/db.php";
	if($_POST['userid'] != NULL){
	$id_check = $db->query("select * from member where id='{$_POST['userid']}'");
	if($id_check >= 1){
		echo "존재하는 아이디입니다.";
	} else {
		echo "존재하지 않는 아이디입니다.";
	}
} ?> =-->