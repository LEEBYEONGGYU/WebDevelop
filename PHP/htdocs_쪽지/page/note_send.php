<?php 
include "../include/db.php";
include "../include/header.php";
include "../include/menu.php";

if(isset($_SESSION['userid']))
    {
?>
<aside>
  <ul id="note_menu">
    <li><img src="/imgs/recv.png" alt="recv" title="recv" /><a href="note.php">받은쪽지함</a></li>
    <li><img src="/imgs/send.png" alt="recv" title="recv"  /><a href="note_send.php"><b>보낸쪽지함</b></a></li>
  </ul>
</aside>
<div id="main_in">
  <table class="list-table">
    <thead>
      <tr>
        <th width="50" class="tc"><input type="checkbox" /></th>
        <th width="150" class="tl">받는사람</th>
        <th width="600" class="tl">내용</th>
        <th width="200" class="tc">날짜</th>
        <th width="100" class="tc">수신여부</th>
      </tr>
    </thead>
    <?php
    //send_note 보낸쪽지함 데이터 가져오기
    //send_note recv_id가 세션userid와 같은것만 가져오기
    $sql = mq("select * from send_note where send_id = '".$_SESSION['userid']."' order by idx desc"); 
    while($recv = $sql->fetch_array()){
      $note_title=$recv["title"]; 
        if(strlen($note_title)>30)
          { 
            $note_title=str_replace($recv["title"],mb_substr($recv["title"],0,30,"utf-8")."...",$recv["title"]);
          }
        ?>
      <tbody>
        <tr>
          <td class="tc"><input type="checkbox" /></td> <!---체크박스 -->
            <td><?php echo $recv['recv_id'];?></td> <!---받는이 -->
            <td><a href='/page/note/send_read.php?idx=<?php echo $recv['idx']; ?>'><?php echo $note_title; ?></a></td> <!---제목 -->
            <td class="tc"><?php echo $recv['send_date']; ?></td> <!---보낸시간 -->
          <td class="tc">
            <?php 
              if($recv['recv_chk'] == "0")
              {
                echo "읽지않음";
              }else{ 
                echo "읽음";
              }
            ?>
          </td>
        </tr>
      </tbody>
    <?php } ?>
  </table>
  <div id="note_bt">
      <ul>
        <li id="wri_m_bt"><a href="note/write.php">쪽지쓰기</a></li>
      </ul>
    </div>
  </div>
<?php 
  }else{
    echo "<script>alert('잘못된 접근입니다.'); history.back();</script>"; 
  } 
include "../include/footer.php";
?>