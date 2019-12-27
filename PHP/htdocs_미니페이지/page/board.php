<!-- 미완성페이지 -->
<?php if($board_idx == NULL){ ?>
<!-- BorderList -->
<div class="board_list">
	<div class="board_head">
        <ul>
            <li>순서</li>
            <li>제목</li>
            <li>내용</li>
            <li>작성날짜</li>
        </ul>
    </div>
    <div class="board_body">
		<?php
            $board_list = $db->query("select * from board order by bidx desc");
            $board_count = $board_list;
            if($board_count >= 1){
            for($i = $board_count; $list = $board_list->fetch(2); $i--){
        ?>
        <ul>
            <li><?php echo $i; ?></li>
            <li><a href="/board/<?php echo $list['bidx']; ?>" title="<?php echo $list['title']; ?>"><?php echo $list['title']; ?></a></li>
            <li><?php echo $list['content']; ?></li>
            <li><?php echo $list['date']; ?></li>
        </ul>
        <?php } ?>
        <?php } else { ?>
        <ul>
            <li><p>현재 작성된 글이 없습니다.</p></li>
        </ul>
        <?php } ?>
    </div>
</div>
<!--// BorderList -->
<?php
} else {
	$board_view = $pdo->query("select * from board where bidx='{$board_idx}'")->fetch(2);
?>
<!-- BorderView -->
<div class="board_view">
	<div class="board_view_top">
        <ul>
            <li>제목</li>
            <li><?php echo $board_view['title']; ?></li>
        </ul>
        <ul>
        	<li>날짜</li>
            <li><?php echo $board_view['date']; ?></li>
        </ul>
    </div>
    <div class="board_view_content">
    	<p><?php echo $board_view['content']; ?></p>
    </div>
</div>
<!-- //BorderView -->
<!-- BoardCommont -->
<div class="board_comment">
	<p>+ 댓글</p>
</div>
<!-- //BoardCommont -->
<?php } ?>