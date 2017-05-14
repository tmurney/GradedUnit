-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2017 at 02:13 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gradedunit`
--

-- --------------------------------------------------------

--
-- Table structure for table `moneyin`
--

CREATE TABLE `moneyin` (
  `TransactionID` int(11) NOT NULL,
  `Value` float DEFAULT NULL,
  `Reason` varchar(20) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `moneyout`
--

CREATE TABLE `moneyout` (
  `TransactionID` int(11) NOT NULL,
  `Value` float NOT NULL,
  `Date` date NOT NULL,
  `Reason` varchar(20) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `savingsgoal`
--

CREATE TABLE `savingsgoal` (
  `GoalID` int(11) NOT NULL,
  `Goal Name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `Goal Amount` float DEFAULT NULL,
  `Goal Deadline` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserID` int(4) NOT NULL,
  `Username` varchar(16) DEFAULT NULL,
  `Password` varchar(24) NOT NULL DEFAULT 'password',
  `First Name` varchar(9) DEFAULT NULL,
  `Last Name` varchar(9) DEFAULT NULL,
  `Balance` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `Username`, `Password`, `First Name`, `Last Name`, `Balance`) VALUES
(1, 'admin', 'password', 'thomas', 'murney', 50);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `savingsgoal`
--
ALTER TABLE `savingsgoal`
  ADD PRIMARY KEY (`GoalID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `savingsgoal`
--
ALTER TABLE `savingsgoal`
  MODIFY `GoalID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
