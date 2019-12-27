<meta charset="utf-8" />

<?php	

	if($_POST["id"] == "" || $_POST["pw"] == ""){
		echo '<script type="text/javascript"> alert("아이디나 패스워드 입력하세요"); history.back(); </script>';
	}else{



	$sql = mq("select * from member where id='".$_POST['id']."' && pw='".$_POST['pw']."'");
	$member = $sql->fetch_array();

	

	if($member){
		$_SESSION['id'] = $member["id"];
		$_SESSION['pw'] = $member["pw"];

	}else{
?>

<script type="text/javascript">
	alert("존재하지 않은 아이디나 비밀번호가 틀렸습니다.");
	location.href='/';

</script>
<?php
	}
	}

?> 
	<script type="text/javascript">
	alert("로그인되었습니다.");
	location.href="/";
	</script>