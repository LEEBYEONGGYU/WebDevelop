<?php 
include "../../include/db.php"; 
include "../../include/header.php";
include "../../include/menu.php";

if(isset($_SESSION['userid']))
    {

  $bno = $_GET['idx']; /* bno함수에 idx값을 받아와 넣음*/

  $sql = mq("select * from send_note where idx='".$bno."'");
  $recv = $sql->fetch_array();
?>
<aside>
	<ul id="note_menu">
		<li><img src="/imgs/recv.png" alt="recv" title="recv" /><a href="/page/note.php">받은쪽지함</a></li>
		<li><img src="/imgs/send.png" alt="recv" title="recv" /><a href="/page/note_send.php">보낸쪽지함</a></li>
	</ul>
</aside>
<div id="note_read">
	<div id="note_read_bt">
		<a href="send_delete.php?idx=<?php echo $recv['idx']; ?>" class="del_bt">삭제</a>
	</div>
	<div id="no_ri_line"></div>
	<div id="note_info">
		<div id="user_info">
			<ul>
				<li><b>보낸사람</b>&nbsp;&nbsp;&nbsp;<?php echo $recv['send_id']; ?></li>
				<li><b>받는사람</b>&nbsp;&nbsp;&nbsp;<?php echo $recv['recv_id']; ?></li>
				<li><b>보낸시간</b>&nbsp;&nbsp;&nbsp;<?php echo $recv['send_date']; ?></li>
				<li><b>보낸파일</b>&nbsp;&nbsp;&nbsp;<a href="../../upload/<?php echo $recv['file'];?>" download><?php echo $recv['file']; ?></a></li>
			</ul>
			<div id="no_ri_line"></div>
		</div>
		<div id="bo_content">
			<?php echo nl2br("$recv[content]"); ?>
		</div>
	</div>
</div>
    <?php 
    }else{
         echo "<script>alert('잘못된 접근입니다.'); history.back();</script>"; 
     } 
     include "../../include/footer.php";
?>