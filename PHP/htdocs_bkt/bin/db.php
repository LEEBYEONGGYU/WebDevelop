<?php
//db
	$db = new mysqli("localhost","root","","telecom");
	$db->set_charset("utf8");

	function mq($sql){
		global $db;
		return $db->query($sql);
	}

function mfa($sql){
	$rs = mq($sql);

	if(!!$rs && ($rs->num_rows>0)){
		return $rs->fetch_array();
	}
}

	function mnr($sql){
		$rs = mq($sql);

		if(!!$rs){
			return $rs->num_rows;
		}
		return false;
	}

?>