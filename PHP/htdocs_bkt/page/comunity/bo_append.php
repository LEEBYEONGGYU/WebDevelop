<?php
	session_start();
	include "../../bin/db.php";

	$start = $_POST['start'];
	$list = $_POST['list'];
	$sql = mq("select * from board order by idx desc limit {$start},{$list}");
	while($board = $sql->fetch_array()){
		$title=$board["title"]; 
					if(strlen($title)>10){
						$title=str_replace($board["title"],mb_substr($board["title"],0,30,"utf-8")."...",$board["title"]);
					}
			?>
<table class="list-table">
	<tbody>
	<tr>
            	<td width="70"><?php echo $board['idx']; ?></td>
                <td width="500"><a href="/comunity/bo_read/<?php echo $board['idx'];?>"><?php echo $title;?></a></td>
                <td width="120"><?php echo $board['name']?></td>
                <td width="100"><?php echo $board['date']?></td>
                <td width="100"><?php echo $board['hit']; ?></td>
            </tr>
	</tbody>
</table>
<?php } ?>