-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 06, 2020 at 06:02 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `customerId` varchar(10) NOT NULL,
  `pamentRef` int(10) NOT NULL AUTO_INCREMENT,
  `paymentAmount` varchar(10) NOT NULL,
  `paymentDesc` varchar(100) NOT NULL,
  `PID` int(10) DEFAULT NULL,
  PRIMARY KEY (`pamentRef`)
) ENGINE=InnoDB AUTO_INCREMENT=555663 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`customerId`, `pamentRef`, `paymentAmount`, `paymentDesc`, `PID`) VALUES
('C001', 555660, '1000.00', 'abc', NULL),
('C002', 555661, '1.00', 'xyz', NULL),
('C003', 555662, '2000.00', 'abc', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
