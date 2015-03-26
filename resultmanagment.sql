-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 03, 2014 at 02:34 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `resultmanagment`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `course_code` varchar(20) CHARACTER SET latin1 NOT NULL,
  `title` varchar(50) CHARACTER SET latin1 NOT NULL,
  `year` varchar(5) CHARACTER SET latin1 DEFAULT NULL,
  `credit` decimal(2,1) DEFAULT NULL,
  `semester` varchar(5) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_code`, `title`, `year`, `credit`, `semester`) VALUES
('cse-401', 'cse', '4th', 3.0, '2nd');

-- --------------------------------------------------------

--
-- Table structure for table `courseteacher`
--

CREATE TABLE IF NOT EXISTS `courseteacher` (
  `course_code` varchar(20) NOT NULL,
  `session` varchar(30) NOT NULL,
  `id` int(6) DEFAULT NULL,
  PRIMARY KEY (`course_code`,`session`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courseteacher`
--

INSERT INTO `courseteacher` (`course_code`, `session`, `id`) VALUES
('cse-401', '2013-2014', 2);

-- --------------------------------------------------------

--
-- Table structure for table `examcommittee`
--

CREATE TABLE IF NOT EXISTS `examcommittee` (
  `chairmanId` int(6) DEFAULT NULL,
  `firstMemberId` int(6) DEFAULT NULL,
  `secondMemberId` int(6) DEFAULT NULL,
  `year` varchar(5) NOT NULL DEFAULT '',
  `session` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`year`,`session`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `examcommittee`
--


-- --------------------------------------------------------

--
-- Table structure for table `finalexammarks`
--

CREATE TABLE IF NOT EXISTS `finalexammarks` (
  `course_code` varchar(20) NOT NULL,
  `session` varchar(30) NOT NULL,
  `exam_roll` varchar(10) NOT NULL,
  `examinerId` int(6) NOT NULL,
  `questionOneMarks` decimal(5,2) DEFAULT NULL,
  `questionTwoMarks` decimal(5,2) DEFAULT NULL,
  `questionThreeMarks` decimal(5,2) DEFAULT NULL,
  `questionFourMarks` decimal(5,2) DEFAULT NULL,
  `questionFiveMarks` decimal(5,2) DEFAULT NULL,
  `questionSixMarks` decimal(5,2) DEFAULT NULL,
  `totalMarks` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`course_code`,`session`,`exam_roll`,`examinerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `finalexammarks`
--


-- --------------------------------------------------------

--
-- Table structure for table `incoursemark`
--

CREATE TABLE IF NOT EXISTS `incoursemark` (
  `course_code` varchar(20) NOT NULL,
  `session` varchar(30) NOT NULL,
  `dept_roll` varchar(10) NOT NULL,
  `incourse_exam` decimal(5,2) DEFAULT NULL,
  `viva` decimal(5,2) DEFAULT NULL,
  `attendance` decimal(5,2) DEFAULT NULL,
  `assignment` decimal(5,2) DEFAULT NULL,
  `presentation` decimal(5,2) DEFAULT NULL,
  `suddent_test` decimal(5,2) DEFAULT NULL,
  `totalMarks` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`course_code`,`session`,`dept_roll`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `incoursemark`
--


-- --------------------------------------------------------

--
-- Table structure for table `incoursemarkingscale`
--

CREATE TABLE IF NOT EXISTS `incoursemarkingscale` (
  `course_code` varchar(20) NOT NULL,
  `session` varchar(30) NOT NULL,
  `incourse_exam` decimal(5,2) DEFAULT NULL,
  `viva` decimal(5,2) DEFAULT NULL,
  `attendance` decimal(5,2) DEFAULT NULL,
  `assignment` decimal(5,2) DEFAULT NULL,
  `presentation` decimal(5,2) DEFAULT NULL,
  `suddent_test` decimal(5,2) DEFAULT NULL,
  `totalMarks` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`course_code`,`session`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `incoursemarkingscale`
--


-- --------------------------------------------------------

--
-- Table structure for table `lab`
--

CREATE TABLE IF NOT EXISTS `lab` (
  `firstExaminerId` int(6) unsigned NOT NULL,
  `secondExaminerId` int(6) unsigned NOT NULL,
  `course_code` varchar(20) NOT NULL,
  `session` varchar(30) NOT NULL,
  PRIMARY KEY (`course_code`,`session`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lab`
--


-- --------------------------------------------------------

--
-- Table structure for table `markingstructure`
--

CREATE TABLE IF NOT EXISTS `markingstructure` (
  `course_code` varchar(20) NOT NULL,
  `session` varchar(30) NOT NULL,
  `structure` blob,
  PRIMARY KEY (`course_code`,`session`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `markingstructure`
--


-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `name` varchar(50) NOT NULL,
  `dept_roll` varchar(10) NOT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `session` varchar(30) NOT NULL,
  `batch` varchar(6) NOT NULL,
  `exam_roll` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `year` varchar(5) NOT NULL DEFAULT '',
  `semester` varchar(5) DEFAULT NULL,
  `pre_session` varchar(30) DEFAULT NULL,
  `pre_roll` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`dept_roll`,`year`,`session`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`name`, `dept_roll`, `gender`, `session`, `batch`, `exam_roll`, `email`, `phone`, `year`, `semester`, `pre_session`, `pre_roll`) VALUES
('shamim', '10', 'Male', '2013-2014', '17', '42', 'mfhf', '0165', '4th', '2nd', NULL, NULL),
('reza', '17', 'Male', '2013-2014', '17', '50', 'bdghdsg', '0145', '4th', '2nd', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `dept_name`, `name`, `email`, `phone`) VALUES
(2, 'cse', 'nhm', 'sadfg', '0124');

-- --------------------------------------------------------

--
-- Table structure for table `theorysubject`
--

CREATE TABLE IF NOT EXISTS `theorysubject` (
  `firstExaminerId` int(6) unsigned NOT NULL,
  `secondExaminerId` int(6) unsigned DEFAULT NULL,
  `course_code` varchar(20) NOT NULL,
  `session` varchar(30) NOT NULL,
  PRIMARY KEY (`course_code`,`session`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `theorysubject`
--


-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(10) NOT NULL,
  `PassWord` varchar(30) NOT NULL,
  `Type` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `PassWord`, `Type`) VALUES
(1, '1', 'official'),
(2, '2', 'teacher');
