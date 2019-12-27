<?php
session_start();
//함수호출
include "func.php";
include "db.php"; 
	
	//단축URL
		$url = explode("/",get("q"));

	if(isset($url[1])){
		include_once "/page/sub.php";
	}else{
		include "./include/header.php";
		include "./page/main.php";
	}
	include "./include/footer.php";

	?>
