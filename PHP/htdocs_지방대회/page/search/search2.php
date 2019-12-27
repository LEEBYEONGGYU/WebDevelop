<?php
	if(isset($_POST['content'])) {
		$sql = "select * from board where content='".$_POST['content']."'"; 
		echo $sql;

}
?>
<form action="" method="post">
<ul>
	<li>검색</li>
	<li><input type="text" id="content" name="content" /></li>
</ul>
<ul>
	<li><input type="submit" value="검색" /></li>
</ul>
</form>
<ul>
	<li><?php echo $_POST['content']; ?></li>
</ul>