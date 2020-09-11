-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.1-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- springbbs 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `springbbs`;
CREATE DATABASE IF NOT EXISTS `springbbs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `springbbs`;

-- 테이블 springbbs.tbl_board 구조 내보내기
DROP TABLE IF EXISTS `tbl_board`;
CREATE TABLE IF NOT EXISTS `tbl_board` (
  `bno` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` varchar(20000) NOT NULL,
  `writer` varchar(50) NOT NULL,
  `regdate` datetime DEFAULT current_timestamp(),
  `updatedate` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 테이블 데이터 springbbs.tbl_board:~3 rows (대략적) 내보내기
DELETE FROM `tbl_board`;
/*!40000 ALTER TABLE `tbl_board` DISABLE KEYS */;
INSERT INTO `tbl_board` (`bno`, `title`, `content`, `writer`, `regdate`, `updatedate`) VALUES
	(1, '새로 작성하는 글', '새로 작성하는 내용', 'newbie', '2020-04-04 13:23:58', '2020-04-06 12:15:43'),
	(3, '새로 작성하는 글 select key', '새로 작성하는 내용 select key', 'newbie', '2020-04-06 11:27:03', '2020-04-06 11:27:03'),
	(4, 'New article', 'New Content', 'Seungwoo', '2020-04-06 13:00:48', '2020-04-06 13:00:48');
/*!40000 ALTER TABLE `tbl_board` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
