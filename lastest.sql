-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 22, 2024 at 04:29 PM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lastest`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `email`, `name`, `phone`) VALUES
(1, 'bob@example.com', 'Charlie Brown', '(312) 312-2222'),
(2, 'willms.braulio@johns.com', 'Finn Ruiz', '+1.451.663.4298'),
(3, 'zelma.weimann@gmail.com', 'Carter Walker', '(396) 866-2159'),
(4, 'hammes.gwendolyn@roberts.com', 'Maeve Mckinney', '+15622804178'),
(5, 'fgottlieb@hotmail.com', 'Rafael Robinson', '(542) 378-3047 x09138');

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
CREATE TABLE IF NOT EXISTS `delivery` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_date` varchar(255) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `order_quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `delivery`
--

INSERT INTO `delivery` (`id`, `order_date`, `product_id`, `status`, `order_quantity`) VALUES
(1, '23/11/2022', 1, 'Delivered', 9),
(2, '13/04/2023\r\n', 4, 'Delivered', 1),
(3, '28/09/2023', 5, 'Waiting Confirmation', 2),
(4, '11/11/2023\r\n', 3, 'Cancelled', 20),
(5, '23/07/2023', 1, 'Waiting Confirmation', 5);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `quantity`) VALUES
(1, 'Cosmic Dreamcatcher', 350000, 25),
(2, 'Espresso-infused Chocolate Truffles', 190000, 8),
(3, 'Rainbow-colored Wind Chimes', 275000, 10),
(4, 'Self-watering Plant Pot Trio', 500000, 7),
(5, 'Pocket-sized Star Projector', 150000, 42);

-- --------------------------------------------------------

--
-- Table structure for table `shipper`
--

DROP TABLE IF EXISTS `shipper`;
CREATE TABLE IF NOT EXISTS `shipper` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `shipper`
--

INSERT INTO `shipper` (`id`, `name`, `phone`) VALUES
(1, 'Luna Vega', '(415) 555-0123'),
(2, 'Silas Blackwood', '(20) 7946-0987'),
(3, 'Amara Rose', '(3) 9876-5432'),
(4, 'Kai Nakamura', '(3) 3456-7890'),
(5, 'Elowen Greythorne', '(30) 1234-5678');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
