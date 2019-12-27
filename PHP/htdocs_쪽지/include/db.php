 <?php
  session_start();
  header('Content-Type: text/html; charset=utf-8'); // utf-8인코딩
  
  /* "호스트 주소","아이디","비밀번호","DB이름"*/
  $db = new mysqli("localhost","root","xampp","note_project");
  $db->set_charset("utf8");

  function mq($sql){
    global $db;
    return $db->query($sql);
  }

  ?>