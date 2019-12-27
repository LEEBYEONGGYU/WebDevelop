<?php

//isset
function val(&$name,$df=''){
	return isset($name) ? $name : $df;
}

//post
function post($name){
	return val($_POST["$name"]);
}

//get
function get($name){
	return val($_GET["$name"]);
}

//session
function session($name){
	return val($_SESSION["$name"]);
}

//xss
function strop_tag($srt){
	$regx = array(
		'@<script[^>]*?>.*?</sccript>@si',
		'@<iframe[^>}*?>.*?</iframe>@si',
		'@<script|iframe)[^>]*?>@si',
		'@</(script|iframe)>@si'
	);
	return htmlspecialchars (preg_replace($regx,'',$srt));
}

//img
function img($src,$title,$etc=false){
	echo '<img src="'.$src.'"title="'.$title.'"alt="'.$title.'"';
	if($etc){
		echo $etc;
	}
	echo '/>';
}

?>