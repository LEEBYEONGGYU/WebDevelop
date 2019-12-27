<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<?php

/* DB */

	mysql_connect("localhost","root","xampp");
	mysql_select_db("skills");
	mysql_query("set names utf8");

	$sql = "select * from member where id= '".$_POST['id']."'";
	$res = mysql_query($sql);
	$member = mysql_fetch_array($res);

/* id가 중복될때 */
	if($member > 0){
		echo '<script type="text/javascript"> alert("같은 아이디가 존재합니다."); history.back(); </script>';
	}else{

		$sql = "select * from member where id='".$_POST['id']."'";
		$res = mysql_query($sql);
		$member = mysql_num_rows($res);
/*  */
		$birth = $_POST['birth'].'년'.$_POST['birth'].'월'.$_POST['birth'].'일';
		$email = $_POST['email'].'@'.$_POST['email2'];
		$phone = $_POST['p_num'].'-'.$_POST['p_num2'].'-'.$_POST['p_num3'];

/*insert md5*/

$sql = mysql_query('insert into member(id,pw,name,adress,email,p_num)values("'.$_POST['id'].'","'.md5($_POST['pw']).'","'.$_POST['name'].'","'.$birth.'","'.$email.'","'.$phone.'")');
	
	}

?>
<script type="text/javascript">alert("가입이 완료되었습니다.");</script>
<script type="text/javascript"> 

location.href='/index.php';

</script>