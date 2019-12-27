<?php
$db = new mysqli("127.0.0.1","root","xampp","big");
	$db->set_charset("utf8");

	function mq($sql){
		global $db;
		return $db->query($sql);
	}

	function mfa($sql){
		$rs = mq($sql);

		if(!!$rs || $rs->num_rows > 0){
			return $rs->fetch_array();
		}
		return false;
	}

	function mnr($sql){
		$rs = mq($sql);

		if(!!$rs){
			return $rs->num_rows;
		}
		return false;
	}

if($_POST['userid'] != NULL){
	$userid_check = $db->query("select * from member where qwdid='{$_POST['userid']}'");
	if($userid_check >= 1){
		echo "존재하는 아이디입니다.";
	} else {
		echo "존재하지 않는 아이디입니다.";
	}
} else if($_POST['pw'] != NULL){
	// $_POST['pw'] = md5($_POST['pw']); // 원래는 암호화 해야는데 DB => pw열 값을 모르니까. 안함
	$pw_chkeck = $db->query("select * from member where wqdpw='{$_POST['pw']}'");
	if($pw_chkeck >= 1){
		echo "존재하는 비밀번호입니다.";
	} else {
		echo "존재하지 않는 비밀번호입니다.";
	}
}
