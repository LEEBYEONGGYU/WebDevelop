<?php

/* 자동가입방지 문자*/
	session_start();
	header('Content-Type: image/gif');

	$captcha = '';

	/*패턴*/
	$patten = '123456789QWEERTYUIOPASZDFGHJKLZMXNCBVqpwoeirutyalskdjfhgzmxncbv';
	for($i = 0, $len = strlen($patten) -1; $i < 6; $i++){
		$captcha .= $patten[rand(0, $len)];
	}

	$_SESSION['capt'] = $captcha;
	
	$img = imagecreatetruecolor(60, 20);
	imagefilledrectangle($img, 0,0,100,100,0xc80000);
	imagestring($img, 5, 2, 3, $captcha, 0xffffff);
	imageline($img,0,rand() % 20,100,rand() % 20, 0x001458);
	imagegif($img);
	imagedestroy($img);
?>