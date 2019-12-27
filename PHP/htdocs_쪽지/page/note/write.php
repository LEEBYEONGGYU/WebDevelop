<?php 
include "../../include/db.php"; 
include "../../include/header.php"; 
include "../../include/menu.php";
//세션 userid가 있으면 내용표시
if(isset($_SESSION['userid']))
    {
?>
<!--- 2019.01.27 추가 --->
<script type="text/javascript">
    function adr_im(){ //adr_im 함수를 선언합니다.
        window.name="adrload"; //현재 윈도우 창의 이름은 write입니다.
        window.open("adress_import.php","주소록 가져오기","width=700, height=600"); //팝업창을 띄워주며 adress_import.php라는 페이지를 실행하고, 700x800 크기로 띄워줍니다.
    }
</script>
<!--- 2019.01.27 추가끝--->
<aside>
	<ul id="note_menu">
		<li><img src="/imgs/recv.png" alt="recv" title="recv"/><a href="../note.php">받은쪽지함</a></li>
		<li><img src="/imgs/send.png" alt="recv" title="recv"/><a href="../note_send.php">보낸쪽지함</a></li>
	</ul>
</aside>
<div id="write_note_in">
	<form action="write_ok.php" method="post" enctype="multipart/form-data">
        <div id="write_t">쪽지쓰기</div>
        <div id="write_form">
            <!--- 2019.01.27 추가 --->
            <?php
                if(isset($_POST['addck'])) //만약 POST값 ad_chk가 있다면
                {
                    $smt = $_POST['addck']; //smt변수에 POST값 ad_chk를 넣고
                }else{
                    $smt=""; //없다면 $smt변수에는 빈값이 들어갑니다
                }?>
            <div class="wr_ip"><input type="text" name="recv_name" placeholder="받는사람" value="<?php echo $smt;?>" required /><span id="add_bt" onclick="adr_im();" />가져오기</span></div>
            <!--- <input>태그에서 value속성을 추가하여 $emt변수를 echo출력할 수 있게 만들고 <span>태그로 가져오기 버튼을 만듭니다. onclick은 해당 태그를 클릭했을 때 반응하는 속성입니다. 
                클릭하면 스크립트의 adr_im함수가 실행됩니다. 
                2019.01.27 추가끝--->
            <div class="wr_ip wr_ip_top"><input type="text" name="title" placeholder="제목" required/></div>
            <div class="wr_ip wr_ip_top"><textarea name="content" placeholder="내용" required></textarea></div>
            <button type="submit" class="wri_bt wr_ip_top">보내기</button>
        </div>
    </form>
<?php 
//세션 userid가 없으면 경고창과 함께 뒤로보내기
    }else{
         echo "<script>alert('잘못된 접근입니다.'); history.back();</script>"; 
     } 
     include "../../include/footer.php";
?>