<?php

session_start();
/* fun, DB */
include_once "/bin/func.php";
include_once "/bin/db.php";


/* CLEAN URL */
if(get("q")){
	$url = explode("/",get("q"));
}

include_once "/include/header.php";

if(isset($url[1])){
	include_once "/page/sub.php";

}else{
	include_once "/page/main.php";
}
include_once "/include/footer.php";

?>