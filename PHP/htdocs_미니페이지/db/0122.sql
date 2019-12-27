-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 15-01-22 15:22
-- 서버 버전: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `0122`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `board`
--

CREATE TABLE IF NOT EXISTS `board` (
  `bidx` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`bidx`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 테이블의 덤프 데이터 `board`
--

INSERT INTO `board` (`bidx`, `title`, `content`, `date`) VALUES
(1, '안녕...', '달콤한 일등', '2015-01-22'),
(2, '반가워', '이등도 달콤합니다.', '2015-01-22'),
(3, '아쉽다', '삼등은 아쉬울 뿐입니다.', '2015-01-22'),
(4, '게시판순서', '게시판 순서는 최근 게시판이 제일 위로 보입니다.', '2015-01-22');

-- --------------------------------------------------------

--
-- 테이블 구조 `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `midx` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(100) NOT NULL,
  `pw` varchar(100) NOT NULL,
  PRIMARY KEY (`midx`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 테이블의 덤프 데이터 `member`
--

INSERT INTO `member` (`midx`, `userid`, `pw`) VALUES
(1, 'admin', '1234');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
