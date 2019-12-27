<!--- 게시판 =-->
<ul class="board">
	<li class="title1 w5 ti_color wline">번호</li>
	<li class="title2 b_name ti_color wline">제목</li>
	<li class="title1 w100 ti_color wline">이름</li>
	<li class="title2 w17 ti_color wline">날짜</li>
	<li class="title1 w5 ti_color wline">조회</li>
</ul>

<?php
	$sql = "select * from board order by no desc";
	$res = mysql_query($sql." limit 0,10");
	while($board  = mysql_fetch_array($res)){
?>
<ul class="board">
	<li class="list w5 title1_1 wline"><?php echo $board['no']; ?></li>
	<li class="list b_name title2_1 wline"><a href="read/<?php echo $board['no'];?>"><?php echo $board['title']; ?></a></li>
	<li class="list w100 title1_1 wline"><a href=""><?php echo $board['name']; ?></a></li>
	<li class="list w17 title2_1 wline"><a href=""><?php echo $board['date']; ?></a></li>
	<li class="list w5 title1_1 wline"><a href=""><?php echo $board['hit']; ?></a></li>
</ul>
<?php } ?>
<ul>
	<li id="write_g"><a href="/board/write">글쓰기</a></li>
</ul>