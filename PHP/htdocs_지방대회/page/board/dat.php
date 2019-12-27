<?php
/*db*/
	mysql_connect("localhost","root","xampp");
	mysql_select_db("skills");
	mysql_query("set names utf8");


/* sql */
	$sql = "insert into dat(pno,content) values('".$_POST['pno']."','".$_POST['content']."')";
	$res = mysql_query($sql);
		
?>

<meta http-equiv="refresh" content="0 url=/board/read/<?php echo $_POST['pno']; ?>"/>