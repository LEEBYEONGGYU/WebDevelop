<?php
	session_start();
	include "../../bin/db.php"

	$bno = $_POST['bno'];
	$content = $_POST['content'];
	$sql = mq("insert into reply(bno,name,content) values('".$bno."','".$_SESSION['id']"','".$content."')")
?>
<div id="reply_re">
	<?php
		$sql2 = mq("select * from reply where bno='".$_POST['bno']."'order by idx desc");
		while($reply = $sql2->fetch_array()){
	?>
	<ul class="hh1">
		<li class="fl w10"><?php echo $reply['name']; ?></li>
		<li class="w90"><?php echo $reply['content']; ?></li>
	</ul>
</div>