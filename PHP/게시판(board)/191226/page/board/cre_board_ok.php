<?php
include $_SERVER['DOCUMENT_ROOT']."/db.php";

$b_name = $_POST['b_name']; //게시판 테이블 이름
//CREATE문으로 $b_name테이블 이름을 만들어서 idx칼럼에 int형 길이 11, NULL허용, 자동증가값, 기본키를 부여
$sql = mq("CREATE TABLE $b_name (`idx` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
			`title` varchar(100) NOT NULL,
			`name` varchar(100) NOT NULL,
			`content` text NOT NULL,
			`date` date NOT NULL) ENGINE=InnoDB ");

//위 CREATE문이 성공했다면
if($sql==1){
	$date = date("y-m-d");
	//board_list테이블에 게시판 목록 작성
	$sql2 = mq("insert into board_list(board_name,date) values ('".$b_name."',now())"); 

	//파일에 체크했다면 테이블 구조 수정
	if(isset($_POST['b_file'])){
		$b_file = $_POST['b_file']; 
		$sql7 = mq("ALTER TABLE $b_name ADD COLUMN $b_file varchar(100) DEFAULT NULL;");
	}else{
		$b_file = "";
	}

	//글 보호에 체크했다면 테이블 구조 수정
	if(isset($_POST['b_lock'])){
		$b_lock = $_POST['b_lock']; //게시판 글 보호
		$sql8 = mq("ALTER TABLE $b_name ADD COLUMN $b_lock int(11) NOT NULL DEFAULT '0';");
	}else{
		$b_lock = "";
	}

	echo "<script>alert('게시판이 생성되었습니다.'); location.href='/page/board/board.php?bname=$b_name';</script>";
}else{
	echo "<script>alert('게시판 생성에 실패했습니다.'); history.back();</script>";
}
?>