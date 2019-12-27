<?php
	session_start();
	include "../../bin/db.php";

	$start = $_POST['start'];
	$list = $_POST['list'];
	$sql = mq("select * from notice order by idx desc limit {$start},{$list}");
	while($notice = $sql->fetch_array()){
		$title=$notice["title"]; 
					if(strlen($title)>10){
						$title=str_replace($notice["title"],mb_substr($notice["title"],0,30,"utf-8")."...",$notice["title"]);
					}
			?>
<table class="list-table">
	<tbody>
	<tr>
            	<td width="70"><?php echo $notice['idx']; ?></td>
                <td width="600"><a href="/comunity/read/<?php echo $notice['idx'];?>"><?php echo $title;?></a></td>
                <td width="80"><?php echo $notice['name']?></td>
                <td width="100"><?php echo $notice['date']?></td>
                <td width="100"><?php echo $notice['hit']; ?></td>
            </tr>
	</tbody>
</table>
<?php } ?>