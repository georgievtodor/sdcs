-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2017 at 01:31 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sdcs`
--

-- --------------------------------------------------------

--
-- Table structure for table `channels`
--

CREATE TABLE `channels` (
  `id` int(11) NOT NULL,
  `channelTypeId` int(11) NOT NULL,
  `label` varchar(50) NOT NULL,
  `command` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `channels`
--

INSERT INTO `channels` (`id`, `channelTypeId`, `label`, `command`) VALUES
(1, 5, 'Volume', '40'),
(2, 3, 'Song URL', 'https://sony.com'),
(3, 2, 'Song control', 'Pause');

-- --------------------------------------------------------

--
-- Table structure for table `channel_types`
--

CREATE TABLE `channel_types` (
  `id` int(11) NOT NULL,
  `channelType` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `channel_types`
--

INSERT INTO `channel_types` (`id`, `channelType`) VALUES
(1, 'DimmingChannel'),
(2, 'SongControlChannel'),
(3, 'SongURLChannel'),
(4, 'TriggerChannel'),
(5, 'VolumeChannel');

-- --------------------------------------------------------

--
-- Table structure for table `devices`
--

CREATE TABLE `devices` (
  `id` int(11) NOT NULL,
  `serialNumber` varchar(50) NOT NULL,
  `firmwareVersion` varchar(50) NOT NULL,
  `hardwareVersion` int(11) NOT NULL,
  `label` varchar(50) NOT NULL,
  `modelId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `devices`
--

INSERT INTO `devices` (`id`, `serialNumber`, `firmwareVersion`, `hardwareVersion`, `label`, `modelId`) VALUES
(2, '1st', 'some firmware version', 1, '90\'s best', 1);

-- --------------------------------------------------------

--
-- Table structure for table `devices_channels`
--

CREATE TABLE `devices_channels` (
  `deviceId` int(11) NOT NULL,
  `channelId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `devices_channels`
--

INSERT INTO `devices_channels` (`deviceId`, `channelId`) VALUES
(2, 1),
(2, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `manufacturers`
--

CREATE TABLE `manufacturers` (
  `id` int(11) NOT NULL,
  `manufacturerName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manufacturers`
--

INSERT INTO `manufacturers` (`id`, `manufacturerName`) VALUES
(1, 'Sony Ericsson');

-- --------------------------------------------------------

--
-- Table structure for table `models`
--

CREATE TABLE `models` (
  `id` int(11) NOT NULL,
  `modelName` varchar(50) NOT NULL,
  `manufacturerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `models`
--

INSERT INTO `models` (`id`, `modelName`, `manufacturerId`) VALUES
(1, 'Walkman', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `channels`
--
ALTER TABLE `channels`
  ADD PRIMARY KEY (`id`),
  ADD KEY `channelTypeId_2` (`channelTypeId`);

--
-- Indexes for table `channel_types`
--
ALTER TABLE `channel_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id`),
  ADD KEY `modelId` (`modelId`);

--
-- Indexes for table `devices_channels`
--
ALTER TABLE `devices_channels`
  ADD KEY `deviceId` (`deviceId`),
  ADD KEY `channelId` (`channelId`);

--
-- Indexes for table `manufacturers`
--
ALTER TABLE `manufacturers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `models`
--
ALTER TABLE `models`
  ADD PRIMARY KEY (`id`),
  ADD KEY `manufacturerId` (`manufacturerId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `channels`
--
ALTER TABLE `channels`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `channel_types`
--
ALTER TABLE `channel_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `devices`
--
ALTER TABLE `devices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `manufacturers`
--
ALTER TABLE `manufacturers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `models`
--
ALTER TABLE `models`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `channels`
--
ALTER TABLE `channels`
  ADD CONSTRAINT `channels_ibfk_2` FOREIGN KEY (`channelTypeId`) REFERENCES `channel_types` (`id`);

--
-- Constraints for table `devices`
--
ALTER TABLE `devices`
  ADD CONSTRAINT `devices_ibfk_1` FOREIGN KEY (`modelId`) REFERENCES `models` (`id`);

--
-- Constraints for table `devices_channels`
--
ALTER TABLE `devices_channels`
  ADD CONSTRAINT `devices_channels_ibfk_1` FOREIGN KEY (`channelId`) REFERENCES `channels` (`id`),
  ADD CONSTRAINT `devices_channels_ibfk_2` FOREIGN KEY (`deviceId`) REFERENCES `devices` (`id`);

--
-- Constraints for table `models`
--
ALTER TABLE `models`
  ADD CONSTRAINT `models_ibfk_1` FOREIGN KEY (`manufacturerId`) REFERENCES `manufacturers` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
