CREATE TABLE tbl_board (
	bno INT PRIMARY key AUTO_INCREMENT,
	title VARCHAR(200) NOT NULL,
	content VARCHAR(20000) NOT NULL,
	writer VARCHAR(50) NOT NULL,
	regdate DATETIME DEFAULT NOW(),
	updatedate DATETIME DEFAULT NOW()
	);