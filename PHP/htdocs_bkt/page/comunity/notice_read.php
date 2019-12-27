<?php
	/* 조회수 카운트 */
	$hit = mysqli_fetch_array(mq("select * from board where idx ='".$url[2]."'"));
	$hit = $hit['hit'] + 1;
	$fet = mq("update board set hit = '".$hit."' where idx = '".$url[2]."'");
	$sql = mq("select * from board where idx='".$url[2]."'");
	$board = $sql->fetch_array();
	?>
	<script>
	    $(function(){
        $(window).scroll(function(){
            var dh = $(document).height();
            var wh = $(window).height();
            var wt = $(window).scrollTop();
            if(dh == (wh + wt)){
            }
        });
    });
	</script>
<div class="board_read"></div>
	<div class="board_re_ar">
		<ul>
			<li class="tit_read"><?php echo $board['title']; ?></li>
			<li class="dat_read"><?php echo $board['date']; ?></li>
		</ul>
	</div>
	<div class="con_read">
		<ul>
			<li class=""><?php echo $board['content']; ?></li>
		</ul>
	</div>
	<div class="no_re_bo">
	</div>