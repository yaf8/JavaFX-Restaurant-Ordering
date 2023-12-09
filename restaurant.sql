-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2022 at 12:11 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` int(11) NOT NULL,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Phone` char(13) NOT NULL,
  `Gender` char(1) NOT NULL,
  `Subcity` varchar(50) NOT NULL,
  `Woreda` int(11) NOT NULL,
  `HouseNO` varchar(25) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `Fname`, `Lname`, `Email`, `Phone`, `Gender`, `Subcity`, `Woreda`, `HouseNO`, `Password`) VALUES
(1, 'Yafet', 'Abebe', 'yafetema15@gmail.com', '+251929344295', 'M', 'Bole', 8, 'new', 'YafetYafet'),
(2, 'Eyob', 'Abebe', 'EyobAbebe@gmail.com', '+251900000001', 'M', 'Yeka', 13, 'new', 'EyobEyob'),
(18, 'eyob', 'abebe', 'eyobema18@gmail.com', '+251924002136', 'M', 'bole', 8, 'new', '123456789'),
(19, 'Adi', 'Til', 'AdiTil@gmail.com', '+251911999999', 'M', 'none', 1, 'none', 'Adi'),
(21, 'metasebia', 'henok', 'metasebiahenok@gmail.com', '+251920000001', 'M', 'bole', 14, 'new', 'metasebia'),
(22, 'surafel', 'doju', 'surafeldoju@gmail.com', '+251969142453', 'M', 'lamikura', 5, '20', 'surafel1'),
(23, 'Mubarek', 'Jemal', 'Mubarekkhan36@gmail.com', '+251953421349', 'M', 'Nifas-Silk', 10, 'new', 'MubarekJemal'),
(24, 'Nathnael', 'Abebe', 'NathnaelAbebe@gmail.com', '+251920009293', 'M', 'Lemikura', 5, 'new', 'Nati'),
(25, 'Yohannis', 'Tilahun', 'YohannisTilahun@icloud.com', '+251911000005', 'M', 'Bole', 10, '449', 'Yohannis');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`,`Phone`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
