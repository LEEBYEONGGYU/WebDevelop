<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Generator" content="editplus" />
<meta name="Author" content="lbk" />
<meta name="Keywords" content="스킬스 커피 skills coffee skills coffee 커피 스킬스" />
<meta name="Description" content="스킬스 커피홈페이지에 오신것을 환영합니다." />
<title>스킬스 커피</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<link rel="stylesheet" type="text/css" href="/css/sub.css" />
<link rel="stylesheet" type="text/css" href="/css/board.css" />
<link rel="stylesheet" type="text/css" href="/css/member.css" />
<script type="text/javascript" src="/js/common.js"></script>
</head>
<body>
	<div id="header">
		<div id="header_b">
			<div id="header_inner">
				<div id="navi">
					<ul>
						<li><a href="/page/login.php"><?PHP
							if(isset($_SESSION['id'])){
								echo $_SESSION['id']."님 환영합니다.";
								echo "<a href='/page/logout.php'>로그아웃</a></li>";
								}else{
								?> Login</a></li>
			
						<li><a href="/member/member/member">Join</a></li>
						<?php }?>
						<li><a href="/cafe/search">Search</a></li>
						<li><a href="/cafe/sitemap">iteMap</a></li>
						<li><a href="mail2">contact</a></li>
					</ul>
				</div>
				<div id="logo">
					<a href="/"><?php /*php img */img("/imgs/logo.png","logo","logo");?></a>
				</div>
				<div id="menu_t">
					<ul>
					<!--- 메뉴 --->
						<?php
							$sql = "select * from menu where lv='1' && type='main'";
							$res = mysql_query($sql);
							while($menu = mysql_fetch_array($res)){
						?>
						<li><a href="/<?php echo $menu['main']?>/<?php echo $menu['sub'];?>"><?php echo $menu['title'];?></a>
							<ul>
 								<?php
									$sql2 = "select * from menu where lv='1' && main='".$menu['main']."' && type!='main'";
									$res2 = mysql_query($sql2);
									while($sub_menu = mysql_fetch_array($res2)){
								?>
								<li><a href="/<?php echo $sub_menu['main']?>/<?php echo $sub_menu['sub'];?>"><?php echo $sub_menu['title'];?></a></li>
							<?php }?>
						</ul>
					</li>
					<?php } ?>
				</ul>
			</div>
		</div>
	</div>
	<