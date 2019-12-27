-- phpMyAdmin SQL Dump
-- version 4.7.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- 생성 시간: 18-10-11 19:33
-- 서버 버전: 5.6.20
-- PHP 버전: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `post_board`
--
CREATE DATABASE IF NOT EXISTS `post_board` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `post_board`;

-- --------------------------------------------------------

--
-- 테이블 구조 `board`
--

CREATE TABLE `board` (
  `idx` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `pw` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `hit` int(11) NOT NULL,
  `lock_post` int(11) NOT NULL,
  `file` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `board`
--

INSERT INTO `board` (`idx`, `name`, `pw`, `title`, `content`, `date`, `hit`, `lock_post`, `file`) VALUES
(1, 'admin', '$2y$10$M/BYVLi/qIFRnDxawWFkyeDTO4g.GDr9kFSlyjDumrHaBp0xzYcOi', '게시판이 최적화되었습니다.', '게시판 디자인이 최적화되었습니다. Write(글 쓰기)페이지 및 modify(글 수정), read(글 읽기)페이지가 깔끔하게 정리하였습니다. \r\n참고바랍니다.', '2018-03-29', 238, 0, ''),
(2, 'admin', '$2y$10$uuac3Ri9oJDoLSM2Sd2qnujTJbhLsy/a5pzf1Ong04g/3xTDKHD/6', 'DB이름 변경안내', '혼란을 방지하기 위해 DB이름을 이제부터 post_board로 통일하겠습니다.', '2018-03-29', 62, 0, ''),
(3, 'admin', '$2y$10$R/BA/R/6hgMLyB8.vUIK8u6LappBCwqqXJd.ELX1m2I71ukLBtJOS', '게시판 댓글달기', '게시판 글에 댓글을 달 수 있습니다.', '2018-03-29', 53, 0, ''),
(4, 'admin', '$2y$10$82fYMBPnl20iP0sU9PyCwu4sd018ITh34Vex0Mkj7n.S3bNZdufIq', '포스팅 준비중', '마지막 버그 및 오류를 확인 후 포스팅 준비하고 있습니다.', '2018-03-30', 18, 1, ''),
(5, 'admin', '$2y$10$fn1bvh39a69.A0Rya5vjxuCKDXDNnEvsUAPqdlQ0KoiiqP4SFM2r.', '댓글 테스트를 위한 글!', '댓글 테스트를 위한 글입니다!', '2018-04-02', 16, 0, ''),
(6, '관리자', '$2y$10$DToCDjmmM9NP81Qkq7XvoOWzcnRE.j97/tFZ1Mt5T/tPzS7IKCtUe', 'ajax테스트!', 'ajax테스트!', '2018-04-08', 3, 0, ''),
(7, '관리자', '$2y$10$C8FJ2VNT9rnaZd5NGBYet.I6hdQv38FsLA9AY2qNG.wtW6XeO33w2', 'Now페이지 완료', 'Now페이지 완료', '2018-04-08', 15, 0, ''),
(8, '관리자', '$2y$10$op.6lKkv9beMiaykBSOM0u5UXv321j98/zKu24yhdYkOe1Y6mnvze', 'Now페이지 테스트완료', 'Now페이지 테스트완료', '2018-04-08', 38, 0, ''),
(9, 'admin', '$2y$10$KSxT8K1hfFp2N3AAGJV4w.E87wqE6vlywPYMvn9HYctSmvkjoy6qS', '4월 23일', '4월 23일', '2018-04-23', 70, 0, ''),
(10, 'member2', '$2y$10$2UDn6.z/jDKtSa9OLsx97uYr2sDzavHs6oTVy8piQF.nZipY7R10e', 'member2', 'dfasdf', '2018-04-23', 17, 0, ''),
(11, 'admin', '$2y$10$3JCBZZYh9dmR/l4OXI8SM.DU/VQz.aXJBeC1kguCLhLsSVk6NXItu', '게시판 댓글 카운트', '게시판 댓글 카운트', '2018-04-23', 20, 0, 'test_php.bat'),
(12, 'admin', '$2y$10$HkA5mPAbG65Y.bTi5isWTes5R.q35bOE8sQadEHqJLO00hnYlt0wS', '간단한 파일 업로드', '파일 업로드 테스트', '2018-05-12', 3, 0, 'rt.txt'),
(13, 'admin', '$2y$10$4EGQ7WMSD5Rd8t57Gt4TfeJKjgab6ItTYJl.MZ.Y4NwhS01miHld2', '1234', '1234', '2018-05-13', 1, 0, 'AA.txt'),
(14, 'admin', '$2y$10$2nrsp0kcoxg8rr1Dpjy9MePFDzoaXqznCgKzSQhe8PaKSbLrdqip2', '1234', '1234', '2018-05-13', 17, 0, 'AA.txt'),
(15, 'admin', '$2y$10$ghMJtjJ23XGj/k8OcmiBI.CbJHk0f8Cvz5nV5ux.Tyl.12ptAdVQ2', '4', '4', '2018-05-13', 2, 0, 'AA.txt'),
(16, 'admin', '$2y$10$oxl7S1UQh4yi98a/ERe9Z.PjaC1mTFZADLfWu94f6qNWPUkGYD5GG', '마지막 테스트', '마지막 테스트', '2018-05-15', 1, 0, 'AA.txt'),
(17, 'admin', '$2y$10$JuR6Q2/4ZAaxc1xmetRtMOAIMljsi8aa4ulDcOJ/lD1vpTMgJe22a', '한글 파일 업로드 테스트', '한글 파일 업로드 테스트', '2018-05-16', 32, 0, '34ㅇㅇㄹㅇㄹ.txt'),
(18, 'S Writer', '$2y$10$XKH.xfTeRS2uVaVMXSObJeNU2weSTX6Unc1K3/iSC/846afXfIHTu', '새 글 표시 테스트', '새 글 표시 테스트', '2018-07-25', 286, 0, ''),
(19, '234', '$2y$10$1zs3WJULDcJ9Om5pyF1qjOhbwI5tZvZ/5kMPV7WUexvg0kBWWn/eq', '324', '234234', '2018-07-31', 17, 0, ''),
(20, '423423', '$2y$10$OGg0NRk34kFywvKFRSImuuyuiEPeDqgEhug1yyFbEQ8nAEHSjIm3y', '242', '4234234234', '2018-07-31', 2, 0, 'readme_de.txt'),
(21, 'ㅁㄴㅇㄻㄴㅇㄹ', '$2y$10$9QIL1zhUYDU.tog33lwhVueeHOzH/yQlNeaRRaz7F.NkiDLha68D2', 'N표시 테스트', 'N표시 테스트', '2018-08-01', 0, 0, ''),
(22, '나', '$2y$10$nHfLwdaiIqMjALFlHhkpqeehTOBkcbAi9KJ8t9JwPj1YnTEH6/YXi', 'N표시 테스트2', 'N표시 테스트2', '2018-08-01', 0, 0, '');

-- --------------------------------------------------------

--
-- 테이블 구조 `reply`
--

CREATE TABLE `reply` (
  `idx` int(11) NOT NULL,
  `con_num` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `pw` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `board`
--
ALTER TABLE `board`
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
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- 테이블의 AUTO_INCREMENT `reply`
--
ALTER TABLE `reply`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
