-- phpMyAdmin SQL Dump
-- version 4.7.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 08, 2018 at 01:40 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `note_project`
--
CREATE DATABASE IF NOT EXISTS `note_project` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `note_project`;

-- --------------------------------------------------------

--
-- Table structure for table `friends`
--

CREATE TABLE `friends` (
  `idx` int(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `fri_name` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `friends`
--

INSERT INTO `friends` (`idx`, `user`, `fri_name`, `name`, `email`) VALUES
(1, 'admin', 'user', '일반유저', 'admin@naver.com'),
(2, 'user', 'admin', '관리자', 'admin@naver.com');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `idx` int(11) NOT NULL,
  `id` varchar(100) NOT NULL,
  `pw` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`idx`, `id`, `pw`, `name`, `email`) VALUES
(1, 'admin', '$2y$10$uuzp.rQ4C6wW4p8pwRSnB.dLOfJOsG4m7MhvRJ5cXssl/K8iJmoDG', '관리자', '관리자'),
(4, 'user', '$2y$10$Ru7Zj4ERrfDVvH3HZ.9FXe0I14Co76S92InNiYIwe976Ttpi7zDLW', '테스트user', 'dfadsf');

-- --------------------------------------------------------

--
-- Table structure for table `recv_note`
--

CREATE TABLE `recv_note` (
  `idx` int(11) NOT NULL,
  `recv_id` varchar(100) NOT NULL,
  `send_id` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `file` varchar(100) NOT NULL,
  `send_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recv_note`
--

INSERT INTO `recv_note` (`idx`, `recv_id`, `send_id`, `title`, `content`, `file`, `send_date`) VALUES
(2, 'admin', 'user', 'admin님!', 'admin님!admin님!', '', '2018-07-13 04:46:14'),
(3, 'admin', 'user', 'admin님 쪽지 간디요~~', 'admin님 쪽지 간디요~~', '', '2018-07-13 04:46:28'),
(9, 'user', 'admin', 'RE:user 답장받아라', 'RE:user 답장받아라', '', '2018-08-17 05:55:39'),
(10, 'admin', 'user', '234', '123', '', '2018-08-17 05:55:59'),
(12, 'admin', 'user', '9월 8일자 쪽지용~', '9월 8일자 쪽지용~', '', '2018-09-08 04:37:30');

-- --------------------------------------------------------

--
-- Table structure for table `send_note`
--

CREATE TABLE `send_note` (
  `idx` int(11) NOT NULL,
  `recv_id` varchar(100) NOT NULL,
  `send_id` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `recv_chk` int(11) NOT NULL,
  `file` varchar(100) NOT NULL,
  `send_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `send_note`
--

INSERT INTO `send_note` (`idx`, `recv_id`, `send_id`, `title`, `content`, `recv_chk`, `file`, `send_date`) VALUES
(4, 'user', 'admin', 'test', 'test', 1, '', '2018-07-16 06:13:31'),
(7, 'user', 'admin', 'user', 'user', 1, '', '2018-07-25 09:52:28'),
(8, 'user', 'admin', 'RE:답장테스트', 'RE:답장테스트', 1, '', '2018-08-17 05:46:52'),
(9, 'user', 'admin', 'RE:답장테스트', 'RE:답장테스트', 1, '', '2018-08-17 05:51:35'),
(10, 'user', 'admin', 'RE:user 답장받아라', 'RE:user 답장받아라', 1, '', '2018-08-17 05:55:39'),
(11, 'admin', 'user', '234', '123', 1, '', '2018-08-17 05:55:59'),
(12, 'admin', 'user', '5일의 쪽지', '5일의 쪽지', 1, '', '2018-09-05 09:38:54'),
(13, 'admin', 'user', '9월 8일자 쪽지용~', '9월 8일자 쪽지용~', 1, '', '2018-09-08 04:37:30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `friends`
--
ALTER TABLE `friends`
  ADD PRIMARY KEY (`idx`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`idx`);

--
-- Indexes for table `recv_note`
--
ALTER TABLE `recv_note`
  ADD PRIMARY KEY (`idx`);

--
-- Indexes for table `send_note`
--
ALTER TABLE `send_note`
  ADD PRIMARY KEY (`idx`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `friends`
--
ALTER TABLE `friends`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `recv_note`
--
ALTER TABLE `recv_note`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `send_note`
--
ALTER TABLE `send_note`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
