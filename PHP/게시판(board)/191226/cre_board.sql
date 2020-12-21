-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2019 at 07:27 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cre_board`
--
CREATE DATABASE IF NOT EXISTS `cre_board` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cre_board`;

-- --------------------------------------------------------

--
-- Table structure for table `board_list`
--

CREATE TABLE `board_list` (
  `idx` int(11) NOT NULL,
  `board_name` varchar(200) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `board_list`
--

INSERT INTO `board_list` (`idx`, `board_name`, `date`) VALUES
(46, 'teeeee', '2019-12-25'),
(47, 'dfgh', '2019-12-25'),
(49, 'test3', '2019-12-26'),
(50, '테스트', '2019-12-26'),
(51, '라스트', '2019-12-26');

-- --------------------------------------------------------

--
-- Table structure for table `dfgh`
--

CREATE TABLE `dfgh` (
  `date` date NOT NULL,
  `content` text NOT NULL,
  `name` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `idx` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ggggg`
--

CREATE TABLE `ggggg` (
  `idx` int(11) NOT NULL,
  `e` int(11) NOT NULL,
  `df` int(11) NOT NULL,
  `sdf` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `teeeee`
--

CREATE TABLE `teeeee` (
  `file` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `content` text NOT NULL,
  `name` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `idx` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `teeeee`
--

INSERT INTO `teeeee` (`file`, `date`, `content`, `name`, `title`, `idx`) VALUES
('', '2019-12-25', 'tr4t5y6u7i8', 'test', 'wewret5yr', 1);

-- --------------------------------------------------------

--
-- Table structure for table `test3`
--

CREATE TABLE `test3` (
  `idx` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `라스트`
--

CREATE TABLE `라스트` (
  `idx` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `file` varchar(100) DEFAULT NULL,
  `lock_sta` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `테스트`
--

CREATE TABLE `테스트` (
  `idx` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `file` varchar(100) DEFAULT NULL,
  `lock_sta` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `board_list`
--
ALTER TABLE `board_list`
  ADD PRIMARY KEY (`idx`);

--
-- Indexes for table `dfgh`
--
ALTER TABLE `dfgh`
  ADD PRIMARY KEY (`idx`);

--
-- Indexes for table `teeeee`
--
ALTER TABLE `teeeee`
  ADD PRIMARY KEY (`idx`);

--
-- Indexes for table `test3`
--
ALTER TABLE `test3`
  ADD PRIMARY KEY (`idx`);

--
-- Indexes for table `라스트`
--
ALTER TABLE `라스트`
  ADD PRIMARY KEY (`idx`);

--
-- Indexes for table `테스트`
--
ALTER TABLE `테스트`
  ADD PRIMARY KEY (`idx`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `board_list`
--
ALTER TABLE `board_list`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `dfgh`
--
ALTER TABLE `dfgh`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `teeeee`
--
ALTER TABLE `teeeee`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `test3`
--
ALTER TABLE `test3`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `라스트`
--
ALTER TABLE `라스트`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `테스트`
--
ALTER TABLE `테스트`
  MODIFY `idx` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
