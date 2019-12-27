<?php 
include "../../include/db.php"; 
include "../../include/header.php";
include "../../include/menu.php";

if(isset($_SESSION['userid']))
    {

  $bno = $_GET['idx']; /* bno함수에 idx값을 받아와 넣음*/

  $sql = mq("select * from recv_note where idx='".$bno."'");
  $recv = $sql->fetch_array();

  $re_da = $recv['send_date']; //$re_da변수에 send_date값 넣음
  $rec_chk = 1; // rec_chk에 1을 넣음
  $fet = mq("update send_note set recv_chk = '".$rec_chk."' where send_date = '".$re_da."'");
  // send_note테이블의 recv_chk를 1로, send_date가 $re_da와 같은 데이터에 업데이트한다.
?>
<aside>
	<ul id="note_menu">
		<li><img src="/imgs/recv.png" alt="recv" title="recv" /><a href="/page/note.php">받은쪽지함</a></li>
		<li><img src="/imgs/send.png" alt="recv" title="recv" /><a href="/page/note_send.php">보낸쪽지함</a></li>
	</ul>
</aside>
<div id="note_read">
	<div id="note_read_bt">
		<a href="recv_delete.php?idx=<?php echo $recv['idx']; ?>" class="del_bt">삭제</a>
		<a href="reply_write.php?idx=<?php echo $recv['idx']; ?>" class="dap_bt">답장</a>
		<a class="dap_bt" id="fr_bt" href="#">주소록 추가</a><!--- 2018.09.08 추가 -->
	</div>
	<div id="frn_cre">
		<div id="frn_t">주소록 추가</div>
		<div id="no_ri_line"></div>
		<div id="frn_st">선택한 사용자를 추가합니다.</div>
			<form action="fri_ok.php" method="post">
				<table class="frn-table">
				    <thead>
				      <tr>
				        <th width="120" class="tc">아이디</th>
				        <th width="120" class="tc">이름</th>
				        <th width="120" class="tc">이메일</th>
				      </tr>
				    </thead>
				        <tbody>
				          <tr align="center">
				        	<td><input type="text" name="fr_name" required="required" value="<?php echo $recv['send_id']; ?>" size="15" readonly/></td>
				        	<td><input type="text" name="u_name" required="required" size="15" /></td>
				        	<td><input type="text" name="u_mail" required="required" size="15" /></td>
				          </tr>
				        </tbody>
					</table>
					<div id="frn_bt" class="tc">
						<button type="submit">확인</button>
						<button type="button" id="frn_set">취소</button>				
					</div>
				</form>
			</div>
			<!--- 2018.09.08 --->
	<div id="no_ri_line"></div>
	<div id="note_info">
		<div id="user_info">
			<ul>
				<li><b>보낸사람</b>&nbsp;&nbsp;&nbsp;<?php echo $recv['send_id']; ?></li>
				<li><b>받은시간</b>&nbsp;&nbsp;&nbsp;<?php echo $recv['send_date']; ?></li>
				<li><b>받은파일</b>&nbsp;&nbsp;&nbsp;<a href="../../upload/<?php echo $recv['file'];?>" download><?php echo $recv['file']; ?></a></li>
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