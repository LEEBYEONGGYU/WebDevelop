<?php
	if(isset($_POST['title'])) {
		$sql = "select * from board where title='".$_POST['title']; 
		echo $sql;
}
?>
<form action="" method="post">
<ul>
	<li>검색</li>
	<li><input type="text" id="title" name="title" /></li>
</ul>
<ul>
	<li><input type="submit" value="" /></li>
</ul>
</form>
<ul>
	<li><?php echo $_POST['title']; ?></li>
</ul>
