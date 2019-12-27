<meta charset="utf-8" />
<?php
	session_start();

/*DB LOAD */
mysql_connect("localhost","root","xampp");
mysql_select_db("skills");
mysql_query("set names utf8");


/* id, pw값이 비어있다면 경고창 */
	if($_POST["id"] == "" || $_POST["pw"] == ""){
		echo '<script type="text/javascript"> alert("아이디나 패스워드 입력하세요"); history.back(); </script>';
	}else{


	/*Query*/

	$sql = "select * from member where id='".$_POST['id']."' && pw='".md5($_POST['pw'])."'";
	$res = mysql_query($sql);
	$member = mysql_fetch_array($res);

	
/* SESSION id, pw와 member table의 id,pw를 확인*/

	if($member){
		$_SESSION['id'] = $member["id"];
		$_SESSION['pw'] = $member["pw"];

	}else{
		
?>

<!---id나 pw가 불일치 할때--->
<script type="text/javascript">
	alert("존재하지 않은 아이디나 비밀번호가 틀렸습니다/.");
	location.href='/';

</script>
<?php
	}
	}

?> 

<!---id와 pw가 일치할때 index.php로 이동--->
<script type="text/javascript">
	location.href='/index.php';
</script>