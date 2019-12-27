-- phpMyAdmin SQL Dump
-- version 4.1.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 19, 2019 at 09:40 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `skills`
--

-- --------------------------------------------------------

--
-- Table structure for table `board`
--

CREATE TABLE IF NOT EXISTS `board` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `name` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `hit` int(11) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `board`
--

INSERT INTO `board` (`no`, `title`, `content`, `name`, `date`, `hit`) VALUES
(35, '자유게시판 테스트', '자유게시판 테스트', 'ㄴㅁㅇ', '2014-04-03', 1),
(37, '자유게시판 테스트', '자유게시판 테스트', 'ㄴㅁㅇ', '2014-04-03', 1),
(38, '123', '123', '123', '2015-01-30', 2);

-- --------------------------------------------------------

--
-- Table structure for table `dat`
--

CREATE TABLE IF NOT EXISTS `dat` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `pno` int(11) NOT NULL,
  `content` text NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=100 ;

--
-- Dumping data for table `dat`
--

INSERT INTO `dat` (`no`, `pno`, `content`, `name`) VALUES
(99, 31, '테스트중', '');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(100) NOT NULL,
  `pw` varchar(250) NOT NULL,
  `name` varchar(100) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `p_num` varchar(100) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`no`, `id`, `pw`, `name`, `adress`, `email`, `p_num`) VALUES
(1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '관리자', '1997년1997월1997일', 'bgpoilkj@naver.com', '010-4752-7613'),
(7, '', 'd41d8cd98f00b204e9800998ecf8427e', '', '1960년1960월1960일', '@', '010--'),
(8, '123', '123', '123', '123', '123', '123');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `main` varchar(100) NOT NULL,
  `sub` varchar(100) NOT NULL,
  `desc` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `lv` int(11) NOT NULL,
  `type` varchar(250) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`no`, `title`, `main`, `sub`, `desc`, `content`, `lv`, `type`) VALUES
(1, '카페소개', 'cafe', 'hello', '카페소개 페이지', '', 1, 'main'),
(2, '아카데미', 'academy', 'handdrip', '아카데미 페이지', '', 1, 'main'),
(3, '쇼핑', 'shop', 'shop', '쇼핑페이지', '', 1, 'main'),
(4, '회원활동', 'active', 'basket', '회원활동 페이지', '', 1, 'main'),
(5, '자유게시판', 'board', 'board', '자유게시판 페이지', '', 1, 'main'),
(6, '통합검색', 'search', 'search', '통합검색 페이지', '', 1, 'main'),
(7, '인사말', 'cafe', 'hello', '인사말 페이지', '	<div id="hello">\r\n		<?php img("/imgs/hello.png","hello","hello");?>	</div>\r\n	<div id="hello_t">\r\n		<ul>\r\n			<li>"Always beside you, HANKOOK COFFEE 늘 여러분 곁에 있는 한국 커피가 되겠습니다"</li>\r\n			<li>한국커피아카데미는 2001년 3월 대구 신평동점 오픈을 시작으로 치열한 국내 커피 전문점 시장속에</li>\r\n			<li>2013년 10월 국내에서는 처음으로 1,000 호를 돌파하였습니다.</li>\r\n			<li>한국커피는 지난 시간 동안 늘 고객님들과 함께 했습니다. 최고의 커피를 좋은 가격에 제공한다는</li>\r\n			<li>원칙 아래 고객님들의 입맛을 사로잡기 위해 노력해 온 한국커피는 이제 ''정직한 커피''의 가치를 뛰어넘어</li>\r\n			<li>''늘 고객 곁에 있는'' 대한민국 대표 커피 브랜드로서 성장을 거듭하고 있습니다.</li>\r\n			<li><br /></li>\r\n			<li><br /></li>\r\n			<li>Always beside you. 한국커피의 슬로건에 드러나 있듯이 한국커피는 고객님과 늘 가까이하기 위해 </li>\r\n			<li>노력합니다.</li>\r\n			<li>더욱 겸손하게 커피전문점의 기본인 맛에 충실하고. 더욱 친근하게 고객님의 말씀에 귀 기울이며,</li>\r\n			<li>더욱 따뜻하게 고객님들께 받았던 사랑을 다시 나누는 한국 커피가 되도록 하겠습니다.</li>\r\n			<li>늘 커피향기 가득한 따뜻한 삶 되시길 기원합니다.</li>\r\n			<li><br /></li>\r\n			<li><br /></li>\r\n			<li><br /></li>\r\n			<li>감사합니다.</li>\r\n			<li>대표이사 류진우</li>\r\n		</ul>\r\n	</div>\r\n', 1, 'html'),
(8, '이용안내', 'cafe', 'infomation', '이용안내 페이지', '<div id="gayo">\r\n<ul>\r\n	<li  class="gayo_p">ㅇ 개요</li>\r\n	<li class=" gayo_pf gayo_f ">한국커피 아카데미는 핸드드립, 프렌치 프레스, 모카 포트등을 이용하여 커피의 대중화에 기반한 커피문화 학대 및 브랜드 경쟁력 강화를 위해 설립한 바리스타 양성 아카데미이며 좋은커피와 재료를 제공하는 곳입니다.</li>\r\n	<li  class=" gayo_f">올바른 커피문화 정착과 참된 바리스타 육성을 위하여 기본을 중시한 다양한 교육 프로그램으로 구성되어 있으며, 눈높이에 맞춘 커피교육을 단계별로 진행하고 있습니다.</li>\r\n	<li class=" gayo_f">한잔의 커피를 만들기 위한 준비부터 추출의 기본원리, 기기관리 및 커피 전반에 걸친 메뉴 제조의 실습위주로 진행됩니다.</li>\r\n	<li class=" gayo_f">그리고 좋은 커피와 알맞은 기기를 판매함으로써 커피 대중화에 더 노력하겠습니다.</li>\r\n	<li class=" gayo_f">ㅇ 교육과정</li>\r\n	<li class=" gayo_f">제1과정 - 커피이론</li>\r\n	<li class=" gayo_f">제2과정 - 운영실무</li>\r\n</ul>\r\n<ul>\r\n	<li class=" gayo_p gayo_pa">ㅇ 쇼핑몰</li>\r\n	<li class=" gayo_pf gayo_f">커피 판매를 위한 쇼핑몰을 운영하여 양질의 커피재료를 제공하고 있습니다.</li>\r\n	<li class=" gayo_f">쇼핑몰은 회원제, 비회원제로 운영되고 있으며 최고의 품질만을 판매하도록 하겠습니다.</li>\r\n	<li class=" gayo_f">ㅇ 판매제품</li>\r\n	<li class=" gayo_f">커피원료 - 미국산, 콜롬비아산, 아프리카산</li>\r\n	<li class=" gayo_f">축출기</li>\r\n<ul>\r\n</div>', 1, 'html'),
(9, '핸드 드립', 'academy', 'handdrip', '핸드드립 페이지', '<div id="hand">\r\n	<ul id="hand_img">\r\n		<li><img src="/imgs/hand.png" alt="hand" title="hand" /></li>\r\n	</ul>\r\n	<ul>\r\n		<li>Hand Drip은 드리퍼(Dripper)와 종이 필터를 사용하여 커피를 추출하는 것을 말한다.</li>\r\n	</ul>\r\n</div>', 1, 'html'),
(10, '프렌치 프레스', 'academy', 'french', '프렌치 프레스 페이지', '<div id="hand">\r\n	<ul id="freanch_img">\r\n		<li><img src="/imgs/freanch.jpg" alt="freanch" title="freanch" /></li>\r\n	</ul>\r\n	<ul id="freanch_t">\r\n		<li>프렌치프레스는 원래 플런저 포트라는 생소한 이름을 갖고 있는데 프랑스 사람들이 이 기구를 즐겨 사용하였다고 하여 프렌치 프레스라는 별칭으로 더 흔히 불린다.\r\n		<li>시초는 프랑스이지만 1930년경 이탈리아에서 개량되었다.</li>\r\n		<li>그 후 1950년대에 프랑스의 메리오르사에 의해 대중화되었고 덴마크의 보덤사에 의해 유럽 전역에서 인기를 끌게 되었다. 다양한 브랜드에서 프렌치 프레스를 내놓고 있지만 ''프렌치프레세 = 보덤'' 이란 공식이 생길 정도로 대표적인 브랜드로 꼽힌다.</li>\r\n	</ul>\r\n</div>', 1, 'html'),
(11, '모카 포트', 'academy', 'moka', '모카 포트 페이지', '<div id="hand">\r\n	<ul id="moka_img">\r\n		<li><img src="/imgs/moka.jpg" alt="moka" title="moka" /></li>\r\n	</ul>\r\n	<ul id="moka_t">\r\n		<li>모카포트는 이탈리아 가정에서 많이 쓰는 에스프레소 추출 기구로, 기구 아래쪽의 보일러에 물을 채우고 가열하면 압력이 증가하며 증기가 위로 치솟아 에스프레소가 추출되는 원리다.</li>\r\n		<li>가격이 저렴하고 구조도 단순해 고장 날염려도 없는 것이 장점.</li>\r\n	</ul>\r\n</div>', 1, 'html'),
(12, '장바구니', 'active', 'basket', '장바구니 페이지', '', 1, 'html'),
(13, '주문정보', 'active', 'buyinfo', '주문정보 페이지', '<div id="hand">\r\n	<ul>\r\n		<li>주문정보</li>\r\n	</ul>\r\n</div>', 1, 'html'),
(14, '회원정보', 'member', 'member', '', '', 0, 'main'),
(15, '회원가입', 'member', 'member', '회원가입을 위한 페이지 입니다.', '', 0, 'join'),
(17, '자유게시판', 'board', 'board', '자유게시판 페이지', '', 0, 'boa'),
(18, '쇼핑', '', 'shop', '쇼핑페이지', '', 0, 'html'),
(19, '통합검색', 'search', 'search', '통합검색 페이지', '', 0, 'search'),
(21, '자유게시판 쓰기', 'board', 'write', '자유게시판 페이지', '', 0, 'boa');

-- --------------------------------------------------------

--
-- Table structure for table `shop`
--

CREATE TABLE IF NOT EXISTS `shop` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `photo` varchar(250) NOT NULL,
  `word` varchar(100) NOT NULL,
  `amout` varchar(50) NOT NULL,
  `wot` varchar(250) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `shop`
--

INSERT INTO `shop` (`no`, `name`, `photo`, `word`, `amout`, `wot`) VALUES
(39, 'Coffee', '1396495582533cd4de6913a.jpg', '', '2000원', '국내산'),
(40, 'Coffee', '1396495594533cd4ea2ed61.jpg', '', '3000원', '국내산'),
(41, 'Coffee', '1396495614533cd4fe8ea6b.jpg', '', '1000원', '국내산'),
(42, 'Coffee', '1396496382533cd7fe4a0ee.jpg', '', '2000원', '국내산'),
(43, 'Coffee', '1396496500533cd874f329e.jpg', '', '1000원', '국내산'),
(44, 'sdf', '1396516740533d2784921f6.jpg', '', '2000원', '국내산');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
