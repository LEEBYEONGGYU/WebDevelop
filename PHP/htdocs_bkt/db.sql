-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- 생성 시간: 19-09-25 17:40
-- 서버 버전: 10.4.6-MariaDB
-- PHP 버전: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `telecom`
--
CREATE DATABASE IF NOT EXISTS `telecom` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `telecom`;

-- --------------------------------------------------------

--
-- 테이블 구조 `board`
--

CREATE TABLE `board` (
  `idx` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `file` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `hit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `board`
--

INSERT INTO `board` (`idx`, `title`, `name`, `content`, `file`, `date`, `hit`) VALUES
(1, '게시판 쓰기 테스트중입니다.', 'user', '게시판 쓰기 테스트중입니다.', '1461662272571f3240d78ea.', '2016-04-26', 0),
(2, '게시판 쓰기 테스트합니다.', 'user', '게시판 쓰기 테스트합니다.', '1461662296571f325885ee8.', '2016-04-26', 0),
(3, '문자열 길이 테스트', 'user', '문자열 길이 테스트', '1461662314571f326a28475.', '2016-04-26', 0),
(4, 'DB 테스트', 'user', 'DB 테스트', '1461662328571f3278191bc.', '2016-04-26', 0),
(5, 'DB테스트', 'user', 'DB테스트', '1461662337571f32816f325.', '2016-04-26', 0),
(6, 'DB테스트', 'user', 'DB테스트', '1461662349571f328dbf242.', '2016-04-26', 1),
(7, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 0),
(8, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 2),
(9, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 11),
(10, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 11),
(11, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 11),
(12, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 16),
(13, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 14),
(14, '게시판 쓰기 테스트중입니다.', 'user', '게시판 쓰기 테스트중입니다.', '1461662272571f3240d78ea.', '2016-04-26', 0),
(15, '문자열 길이 테스트', 'user', '문자열 길이 테스트', '1461662314571f326a28475.', '2016-04-26', 0),
(16, '게시판 쓰기 테스트합니다.', 'user', '게시판 쓰기 테스트합니다.', '1461662296571f325885ee8.', '2016-04-26', 0),
(17, 'DB테스트', 'user', 'DB테스트', '1461662337571f32816f325.', '2016-04-26', 1),
(18, 'DB 테스트', 'user', 'DB 테스트', '1461662328571f3278191bc.', '2016-04-26', 0),
(19, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 0),
(20, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 1),
(21, '페이징 테스트', 'user', '페이징 테스트', '1461662437571f32e57a7d9.', '2016-04-26', 1),
(22, '이놈의 IE 스크립트 깨지네', 'user', '이놈의 IE 스크립트 깨지네', '1461663009571f3521971f7.', '2016-04-26', 1),
(23, 'read.php create', 'admin', 'read.php create', '1461663475571f36f37241f.', '2016-04-26', 124),
(24, '댓글기능 구현중', 'testuser', '댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...댓글기능 구현중...댓글기능 구현중...댓글기능 구현중...댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...\r\n댓글기능 구현중...댓글기능 구현중...', '1461668169571f4949c61f7.', '2016-04-26', 13),
(25, 'ㄴㅁㅇㄹ', 'user', 'ㅁㄴㅇㄹ', '1461683180571f83ec831b6.', '2016-04-26', 15),
(26, 'sadf', 'user', 'sdf', '1461802691572156c3bb66b.jpg', '2016-04-28', 7),
(27, 'sap', 'user', 'sap', '14618950415722bf8183d9d.png', '2016-04-29', 5),
(28, 'sd', 'user', 'sd', '14618950785722bfa68e626.jpg', '2016-04-29', 2),
(29, 'wer', 'user', 'q3wr', '14618951085722bfc475896.jpg', '2016-04-29', 0),
(30, 'w4erfe', 'user', '2erfdc', '14618951415722bfe580c65.png', '2016-04-29', 26),
(31, '234', 'user', '234', '14618951645722bffc2daa5.png', '2016-04-29', 4),
(32, '', 'user', '', '14675559655779207dcdabe.', '2016-07-03', 0);

-- --------------------------------------------------------

--
-- 테이블 구조 `member`
--

CREATE TABLE `member` (
  `idx` int(11) NOT NULL,
  `id` varchar(100) NOT NULL,
  `pw` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `member`
--

INSERT INTO `member` (`idx`, `id`, `pw`, `model`, `phone`, `email`) VALUES
(1, 'admin', 'admin1234', 'SM-N920S', '010-4752-7613', 'bgpoilkj@naver.com'),
(2, 'user', '1234', 'SM-N920S', '010-0000-000', 'bgpoilkj@naver.com'),
(3, 'testuser', '1234', 'SM-N920S', '010-0000-0000', 'bgpoilkj@naver.com'),
(4, 'admin1234', '1234', '123', '123-123-123', '123@naver.com');

-- --------------------------------------------------------

--
-- 테이블 구조 `menu`
--

CREATE TABLE `menu` (
  `idx` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `main` varchar(100) NOT NULL,
  `sub` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `lv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `menu`
--

INSERT INTO `menu` (`idx`, `title`, `main`, `sub`, `type`, `lv`) VALUES
(1, '회사소개', 'intro', 'intro', 'main', 0),
(2, '모바일 ', 'mobile', 'mobile', 'main', 0),
(3, '커뮤니티', 'comunity', 'notice', 'main', 0),
(4, '고객지원', 'afterservice', 'afterservice', 'main', 0),
(6, '공지사항', 'comunity', 'notice', 'sub', 1),
(7, '자유게시판', 'comunity', 'board', 'sub', 1);

-- --------------------------------------------------------

--
-- 테이블 구조 `notice`
--

CREATE TABLE `notice` (
  `idx` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `hit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `notice`
--

INSERT INTO `notice` (`idx`, `title`, `name`, `content`, `date`, `hit`) VALUES
(1, '공지사항 테스트합니다.', 'admin', '공지사항 테스트합니다.', '2016-04-26', 0),
(2, '공지사항 테스트합니다.', 'admin', '공지사항 테스트합니다.', '2016-04-26', 0),
(3, '공지사항 테스트합니다.', 'admin', '공지사항 테스트합니다.', '2016-04-26', 0),
(4, '공지사항 테스트합니다.', 'admin', '공지사항 테스트합니다.', '2016-04-26', 0),
(5, '공지사항 테스트합니다.', 'admin', '공지사항 테스트합니다.', '2016-04-26', 0),
(6, '공지사항 mb_substr 문자열테스트중입니다.', 'admin', '공지사항 mb_substr 문자열테스트중입니다.', '2016-04-26', 0),
(7, '공지사항 mb_substr 문자열테스트중입니다.', 'admin', '공지사항 mb_substr 문자열테스트중입니다.', '2016-04-26', 0),
(8, '공지사항 mb_substr 문자열테스트중입니다.', 'admin', '공지사항 mb_substr 문자열테스트중입니다.', '2016-04-26', 0),
(9, '공지사항 mb_substr 문자열테스트중입니다.', 'admin', '공지사항 mb_substr 문자열테스트중입니다.', '2016-04-26', 0),
(10, '공지사항 mb_substr 문자열테스트중입니다.', 'admin', '공지사항 mb_substr 문자열테스트중입니다.', '2016-04-26', 0),
(11, '공지사항 게시판 테스트완료되었습니다.', 'admin', '공지사항 게시판 테스트완료되었습니다.', '2016-04-26', 0),
(12, '자유게시판 테스트완료되었습니다.', 'admin', '공지사항 게시판 테스트완료되었습니다.', '2016-04-26', 0),
(13, '홈페이지 안정화', 'admin', '홈페이지 안정화', '2016-04-26', 0);

-- --------------------------------------------------------

--
-- 테이블 구조 `reply`
--

CREATE TABLE `reply` (
  `idx` int(11) NOT NULL,
  `bno` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `reply`
--

INSERT INTO `reply` (`idx`, `bno`, `name`, `content`) VALUES
(1, 30, 'user', 'user');

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `board`
--
ALTER TABLE `board`
  ADD PRIMARY KEY (`idx`);

--
-- 테이블의 인덱스 `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`idx`);

--
-- 테이블의 인덱스 `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`idx`);

--
-- 테이블의 인덱스 `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`idx`);

--
-- 테이블의 인덱스 `reply`
--
ALTER TABLE `reply`
  ADD PRIMARY KEY (`idx`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `board`
--
ALTER TABLE `board`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- 테이블의 AUTO_INCREMENT `member`
--
ALTER TABLE `member`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 테이블의 AUTO_INCREMENT `menu`
--
ALTER TABLE `menu`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- 테이블의 AUTO_INCREMENT `notice`
--
ALTER TABLE `notice`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- 테이블의 AUTO_INCREMENT `reply`
--
ALTER TABLE `reply`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
