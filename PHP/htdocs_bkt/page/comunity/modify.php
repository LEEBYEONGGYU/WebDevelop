<?php
	$sql = mq("select * from board where idx='".$url[2]."'");
	$board = $sql->fetch_array();
?>
	<div class="wri_bottom">

<form action="/comunity/modify_ok/<?php echo $board['idx'];?>" method="post" enctype="multipart/form-data">
<div class="board_write">
	<div style="height:50px;"></div>
		<textarea name="title" id="te_title" placeholder="제목" cols="41" rows="1"></textarea>
		<textarea name="content" id="te_title2" placeholder="내용" cols="100" rows="20"></textarea>
	</div>
	<div class="file_in">
		<ul>
			<li><input type="file" name="pic" style="width:500px;" /></li>
		</ul>
	</div>
	<div class="wri_ok">
		<button>수정하기</button>
	</div>
</form>
</div>