-- phpMyAdmin SQL Dump
-- version 4.7.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- 생성 시간: 18-05-29 11:06
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
-- 데이터베이스: `0811member`
--
CREATE DATABASE IF NOT EXISTS `0811member` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `0811member`;

-- --------------------------------------------------------

--
-- 테이블 구조 `member`
--

CREATE TABLE `member` (
  `idx` int(11) NOT NULL,
  `id` varchar(100) NOT NULL,
  `pw` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `member`
--

INSERT INTO `member` (`idx`, `id`, `pw`, `name`, `adress`, `sex`, `email`) VALUES
(1, 'admin', '$2y$10$crvWQLmA3Yew2wAaxtJqAeqC.3tpdpMNxXAbmmcAmqQAjbAiJv3ty', '관리자', '관리자 주소', '남', 'admin@naver.com'),
(2, 'test1', '$2y$10$diFbTu./6rrQoMLEjjkpLeYKGYojXyHmIySjHuDDnqfA3jDRFnf8O', '테스트계정', '대구', '남', 'leebkgyu97@gmail.com');

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`idx`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `member`
--
ALTER TABLE `member`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
