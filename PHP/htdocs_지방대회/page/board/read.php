<!--- 게시판 읽기 =-->
<?php
	mysql_connect("localhost","root","xampp");
	mysql_select_db("skills");
	mysql_query("set names utf8");

/* 조회수 */
	$hit = mysql_fetch_array(mysql_query("select * from board where no ='".$url[2]."'"));

	$hit = $hit['hit'] + 1;
	$fet = mysql_query("update board set hit = '".$hit."' where no = '".$url[2]."'");

	$board = mysql_fetch_array(mysql_query("select * from board where no='".$url[2]."'"));
	extract($board);

?>
<form action="/page/board/dat.php" method="post" id="dat_frm">
<ul class="lh20">
	<li class="read w10 fl">제목</li>
	<li class="read_con">&nbsp;<?php echo $board['title'];?></li>
	<li class="read w5 fl">번호</li>
	<li class="read_con"><?php echo $board['no'];?></li>
</ul>
<ul>
	<li class="read w10 fl">작성자</li>
	<li class="read_con">&nbsp;<?php echo $board['name'];?></li>
	<li class="read w10 fl">등록일</li>
	<li class="read_con"><?php echo $board['date'];?></li>
	<li class="read w10 fl">조회수</li>
	<li class="read_con"><?php echo $board['hit'];?></li>
</ul>
<ul>
	<li class="read_nl fl">내용</li>
	<li class="read_nl_con"><?php echo $board['content']; ?></li>
</ul>
<div id="dat_b">

<ul>
	<li class="bo_t">댓글</li><input type="hidden" name="pno" id="pno" value="<?php echo $url[2];?>">
	<li class="bo_te"><textarea cols="50" rows="3" id="content" title="content" name="content" onkeydown="if(event.keyCode=='13') document.getElementById('dat_frm').submit();"></textarea></li>
	<li class="do_im"><input type="image" src="/imgs/dot.jpg" /></li>
</ul>
<!--- onkeydown="if(event.KeyCode=='13') document.getElementById('dat_frm').submit(); " --->
</form>
</div>
<div id="dot_l">

<!--- 댓글관련 php =-->
	<?php
	/* dat의 고유번호 */
		$sql2 = "select * from dat where pno='".$url[2]."'";
		$res2 = mysql_query($sql2. "limit 0,5");
		while($comment = mysql_fetch_array($res2)){
	?>
	<!--- comment 불러옴 =-->
		<li class="doat"><?php echo $comment['content'];?><br/></li>
	<?php }?>
</div>
<ul>
	<li class="read_txt"><a href="/board/board/">[목록]</a><a href="">[글쓰기]</a><a href="modify.php<?=$no;?>">[수정]</a><a href="/delete/<?=$no;?>">[삭제</a></li>
</ul>