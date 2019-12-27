<?php
session_start();

	mysql_connect("localhost","root","xampp");
	mysql_select_db("skills");
	mysql_query("set names utf8");

		$sql = mysql_query("insert into board(name,title,content,date) values('".$_POST['name']."','".$_POST['title']."','".$_POST['content']."',now())");
	
?>
<script type="text/javascript">
location.href='/index.php';
	</script>