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

	function img($src,$title,$pro=false){
		echo "<img src='".$src."' alt='".$title."' title='".$title."' ".$pro." />";
	}
    ?>