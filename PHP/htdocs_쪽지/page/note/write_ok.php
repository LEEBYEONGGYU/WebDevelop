<?php
 include "../../include/db.php"; 

if(isset($_SESSION['userid'])){


$sql = mq("insert into send_note(recv_id,send_id,title,content,recv_chk) values('".$_POST['recv_name']."','".$_SESSION['userid']."','".$_POST['title']."','".$_POST['content']."','0')");
$sql2 = mq("insert into recv_note(recv_id,send_id,title,content) values('".$_POST['recv_name']."','".$_SESSION['userid']."','".$_POST['title']."','".$_POST['content']."')");
echo "<script>alert('쪽지를 보냈습니다.'); location.href='/page/note_send.php';</script>"; 
?>
<?php 
    }else{
      echo "<script>alert('잘못된 접근입니다.'); location.href='/index.php'; </script>";
    } 
?>