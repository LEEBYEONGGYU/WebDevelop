<?php
	include_once "/include/header.php";
	?>
<div class="intro_b">
	<div class="intro_b_in">
	</div>
</div>
	<div class="s_content">
	<?php
		$sql = mq("select * from menu where sub='".$url[1]."' && lv='1'");
		$main = $sql->fetch_array();
	?>

<?php 
	include_once "/page/".$url[0]."/".$url[1].".php";
	?>
</div>
