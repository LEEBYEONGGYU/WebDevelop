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
			<li><br /></li>
			<li class="fil">파일 : <a href="/upload/board/<?php echo $board['file']; ?>" download="1"><?php echo $board['file']; ?></a></li>
		</ul>
	</div>

	<div class="board_service">
	<?php if(isset($_SESSION['id'])){ ?>
		<div class="bo_ser">
			<ul>
				<li><a href="/comunity/board">목록으로</a></li>
				<li><a href="/comunity/modify/<?php echo $board['idx']; ?>">수정</a></li>
				<li><a href="/comunity/delete/<?php echo $board['idx'];?>">삭제</a></li>
			</ul>
		</div>
		<?php } ?>
		<div class="dat_a">
		<ul>
			<li class="fl"><textarea name="content" id="reply_content" cols="40" rows="3"></textarea></li>
			<li><input type="button" onclick="reply_ok(<?php echo $url[2]; ?>)" value="댓글" /></li>
		</ul>
		<div class="reply_re">
			<?php
				$sql2 = mq("select * from reply where bno='".$url[2]."' order by idx desc");
				while($reply = $sql2->fetch_array()){
			?>
			<ul class="">
				<li class="fl w10"><?php echo $reply['name'] ?></li>
				<li class="w90"><?php echo $reply['content'] ?></li>
			</ul>
			<?php } ?>
		</div>
	</div>
	<script>
		function reply_ok(idx){
			var content = $("#reply_content").val();
			if(content == ""){
				alert("댓글을 작성해주세요.");
			}else{
			$.post("reply_ok.php",{bno:no,content:content},function(data){
				$("#reply_re").html(data);
					$("#reply_content").val("");
			});
			}
		}
	</script>