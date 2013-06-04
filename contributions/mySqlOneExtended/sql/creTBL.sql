-- SQL File
-- Yves Dupont <ydupont@uni-koblenz.de>
--
-- Host: yd.wks001.int.ngineer.de
-- Generation Time: Jan 19, 2013 at 10:51 AM
-- MySQL server version: 5.5.28

--
-- Attention: Script will drop existing tables
--

USE `MySQLOneExtended`;

DROP TABLE IF EXISTS bonus;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS jobdescription;


--
-- Table structure for table `bonus`
--

CREATE TABLE IF NOT EXISTS `bonus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double unsigned NOT NULL,
  `payed` bool NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`)
);


--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `did` (`did`)
);


--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `salary` double NOT NULL,
  `manager` bool NOT NULL,
  `did` int(11) NOT NULL,
  `jid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `did` (`did`),
  KEY `jid` (`jid`)
);


--
-- Table structure for table `jobdescription`
--

CREATE TABLE IF NOT EXISTS `jobdescription` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);


--
-- Table structure for table `review`
--

CREATE TABLE IF NOT EXISTS `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` year(4) NOT NULL,
  `skill` tinyint(1) NOT NULL,
  `understanding` tinyint(1) NOT NULL,
  `knowledge` tinyint(1) NOT NULL,
  `teamwork` tinyint(1) NOT NULL,
  `attendance` tinyint(1) NOT NULL,
  `comment` text NOT NULL,
  `signed` bool NOT NULL DEFAULT '0',
  `eid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `eid` (`eid`)
);

