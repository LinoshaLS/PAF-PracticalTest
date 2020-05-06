-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 03:58 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

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
-- Table structure for table `channeling`
--

CREATE TABLE `channeling` (
  `channelingCode` int(10) NOT NULL,
  `patientName` varchar(20) NOT NULL,
  `doctorName` varchar(20) NOT NULL,
  `hospitalName` varchar(20) NOT NULL,
  `specialization` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `channeling`
--

INSERT INTO `channeling` (`channelingCode`, `patientName`, `doctorName`, `hospitalName`, `specialization`, `date`) VALUES
(10, 'Piumi Perera', 'Palitha Nayana', 'Central', 'Ortho', '30/03/2020'),
(12, 'Akhila Saranga', 'Nuwan Pradeep', 'Asiri', 'Cardio', '30/06/2010'),
(15, 'Thisuri Gamage', 'Mahesh Sampath', 'Asiri', 'Cardio', '04/05/2020'),
(16, 'Manel Jayanthi', 'Haren Silva', 'Nawaloka', 'Eye', '02/02/2020'),
(17, 'Asith Wickrama', 'Pasan Perera', 'Central', 'Cardio', '03/04/20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `channeling`
--
ALTER TABLE `channeling`
  ADD PRIMARY KEY (`channelingCode`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `channeling`
--
ALTER TABLE `channeling`
  MODIFY `channelingCode` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
