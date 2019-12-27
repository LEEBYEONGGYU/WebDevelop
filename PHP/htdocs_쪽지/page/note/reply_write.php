<?php 
include "../../include/db.php"; 
include "../../include/header.php";
include "../../include/menu.php";

if(isset($_SESSION['userid']))
    {
  $bno = $_GET['idx']; /* bno함수에 idx값을 받아와 넣음*/
  $sql = mq("select * from recv_note where idx='".$bno."'");
  $recv = $sql->fetch_array();
?>
<aside>
	<ul id="note_menu">
		<li><img src="/imgs/recv.png" alt="recv" title="recv" /><a href="../note.php">받은쪽지함</a></li>
		<li><img src="/imgs/send.png" alt="recv" title="recv"  /><a href="../note_send.php">보낸쪽지함</a></li>
	</ul>
</aside>
<div id="write_note_in">
	<form action="write_ok.php" method="post" enctype="multipart/form-data">
        <div id="write_t">답장쓰기</div>
        <div id="write_form">
            <div class="wr_ip"><input type="text" name="recv_name" value="<?php echo $recv['send_id']; ?>" required readonly/></div>
            <div class="wr_ip wr_ip_top"><input type="text" name="title" value="RE:"required/></div>
            <div class="wr_ip wr_ip_top"><textarea name="content" placeholder="내용" required></textarea></div>
            <button type="submit" class="wri_bt wr_ip_top">보내기</button>
        </div>
    </form>
</div>
    <?php 
    }else{
         echo "<script>alert('잘못된 접근입니다.'); history.back();</script>"; 
    } 
    include "../../include/footer.php";
?>