<?php
//업로드

$tmpfile = $_FILES['photo']['tmp_name'];
$filename = $_FILES['photo']['name'];
$file_ext_arr = explode(".",$filename);
$ext = strtolower(end($file_ext_arr));

$_POST['photo'] = uniqid(time()).".".$ext;


move_uploaded_file($tmpfile,"./upload/".$_POST['photo']);
$sql = mysql_query("insert into shop(name,photo,amout,intro) values('".$_POST['name']."','".$_POST['photo']."','".$_POST['amount']."','".$_POST['intro']."')");
 

?>
<script type="text/javascript"> location.href = "/shop/shop" </script>