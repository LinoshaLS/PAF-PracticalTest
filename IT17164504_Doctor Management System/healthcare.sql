-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 04:03 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `docId` int(5) NOT NULL,
  `docName` varchar(50) NOT NULL,
  `docNIC` varchar(10) NOT NULL,
  `specialization` varchar(50) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `phoneNo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`docId`, `docName`, `docNIC`, `specialization`, `gender`, `phoneNo`) VALUES
(81, 'Kasun+Lakmal+Perera', '886325493V', 'Cardiologist', 'Male', '0112298075'),
(82, 'Mashi+Silva', '923564821V', 'Gastroenterologist', 'Female', '0169548320'),
(83, 'Nisal Fernando', '912548963V', 'Nephrologist', 'Male', '0112298045'),
(84, 'Chanaka Weerasinghe', '892354625V', 'Neurologist', 'Male', '0777756923'),
(86, 'Tharindu+Silva', '902356842V', 'ENT+Pediatrician', 'Male', '0777659245'),
(87, 'Kasuni Rajapaksha', '875632144V', 'Gastroenterologist', 'Female', '0715698235');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `customerId` varchar(10) NOT NULL,
  `pamentRef` varchar(10) NOT NULL,
  `paymentAmount` varchar(10) NOT NULL,
  `paymentDesc` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `channeling`
--
ALTER TABLE `channeling`
  ADD PRIMARY KEY (`channelingCode`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`docId`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`pamentRef`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `channeling`
--
ALTER TABLE `channeling`
  MODIFY `channelingCode` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `docId` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
