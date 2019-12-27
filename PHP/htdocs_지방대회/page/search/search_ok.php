<!--- search_ok =-->
<?php


	mysql_connect("localhost","root","xampp");
	mysql_select_db("skills");
	mysql_query("set names utf8");

	$sql = "select * from board where title='""'";

?>