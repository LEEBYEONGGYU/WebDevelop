<?php
$db = new mysqli("127.0.0.1","root","xampp","big");
	$db->set_charset("utf8");

	function mq($sql){
		global $db;
		return $db->query($sql);
	}

	function mfa($sql){
		$rs = mq($sql);

		if(!!$rs || $rs->num_rows > 0){
			return $rs->fetch_array();
		}
		return false;
	}

	function mnr($sql){
		$rs = mq($sql);

		if(!!$rs){
			return $rs->num_rows;
		}
		return false;
	}
?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>제목따윈 없다.</title>
<link rel="stylesheet" href="/common/css/common.css">
<script src="/common/js/jquery-1.11.2.js"></script>
</head>

<body>
	<div id="wrap">
    	<div id="wrap_area">
        	<header id="header">
                <nav id="menu">
                    <ul>
                        <li><a href="/" title="홈으로">홈으로</a></li>
                        <li><a href="/join" title="회원가입">회원가입</a></li>
                        <li><a href="/board" title="게시판">게시판</a></li>
                    </ul>
                </nav>
            </header>
            <div id="contents">
            	<?php
				if(isset($_GET['page'])){
					$get = explode("/", $_GET['page']);	
					$main_idx = isset($get[0]) ? $get[0] : NULL;
					$board_idx = isset($get[1]) ? $get[1] : NULL;
					include_once("{$_SERVER['DOCUMENT_ROOT']}/page/{$main_idx}.php");
				} else { 
				?>
            	<div id="main">
                	<p>홈페이지 메인화면</p>
                </div>
                <?php } ?>
            </div>
            <footer id="footer">
                <p>Copyright (c) 제목따윈 없다. All Right Reserved</p>
            </footer>
        </div>
    </div>
</body>
</html>