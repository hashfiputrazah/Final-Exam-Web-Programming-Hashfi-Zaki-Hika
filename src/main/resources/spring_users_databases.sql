-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2021 at 03:58 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spring_users_databases`
--

-- --------------------------------------------------------

--
-- Table structure for table `ref_book_storage`
--

CREATE TABLE `ref_book_storage` (
  `id_book` bigint(20) NOT NULL,
  `book_name` varchar(50) DEFAULT NULL,
  `book_genre` int(11) DEFAULT NULL,
  `book_author` varchar(50) DEFAULT NULL,
  `book_image` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ref_book_storage`
--

INSERT INTO `ref_book_storage` (`id_book`, `book_name`, `book_genre`, `book_author`, `book_image`) VALUES
(147, 'Greatest Showman', 8, 'IDK', NULL),
(202, 'Dragon Moon', 6, 'Drag', NULL),
(3453535, 'League of legends', 1, 'Reza', NULL),
(2342423423, 'jekyl and hide', 1, 'Jekyllx', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ref_genre`
--

CREATE TABLE `ref_genre` (
  `id_genre` int(11) NOT NULL,
  `genre_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ref_genre`
--

INSERT INTO `ref_genre` (`id_genre`, `genre_name`) VALUES
(1, 'Adventure'),
(2, 'Horror'),
(3, 'Romance'),
(4, 'Thriller'),
(5, 'Comedy'),
(6, 'Sci-fi'),
(7, 'Gore'),
(8, 'Documentary'),
(9, 'Slice of life');

-- --------------------------------------------------------

--
-- Table structure for table `sys_role`
--

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sys_role`
--

INSERT INTO `sys_role` (`role_id`, `role_name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `sys_user`
--

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(40) NOT NULL,
  `user_full_name` varchar(50) DEFAULT NULL,
  `user_email` varchar(250) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `stat_actice` int(11) DEFAULT NULL,
  `current_login` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `ip_address` varchar(125) DEFAULT NULL,
  `browser` varchar(125) DEFAULT NULL,
  `operating_system` varchar(125) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sys_user`
--

INSERT INTO `sys_user` (`user_id`, `user_name`, `user_full_name`, `user_email`, `password`, `stat_actice`, `current_login`, `last_login`, `ip_address`, `browser`, `operating_system`) VALUES
(2107278548, 'admin123', 'Administrator', NULL, '$2a$12$6SEloy1xKuZCClmWcBNwBe0IlC9hW5Xn131GG5/6VmjZ6AbKxy562', NULL, NULL, NULL, NULL, NULL, NULL),
(2107278550, 'agyl123', NULL, NULL, '$2a$12$uJWTnWbGTytSgDRB4lZXQebvPiTckDK977P6COyf44aCBe4WHt9im', NULL, NULL, NULL, NULL, NULL, NULL),
(2107278547, 'Hasfi', 'Admin', 'test@test.com', '$2a$10$/A6XnEogH9PdKGuOhHWY7undEXQKRC9.pGIkNeIVIguutgpWcjoke', 1, '2021-12-19 09:13:51', '2021-12-19 09:12:29', '0:0:0:0:0:0:0:1', 'Chrome-96.0.4664.110', 'Windows'),
(2107278549, 'Reviz', 'Reviz', NULL, '$2a$12$7rbwx.de.OdqfKbRyQviUOjj.kgh7QimMKgzdFk.ok1sfHrfb4RAC', NULL, '2021-12-18 12:33:30', '2021-12-18 12:33:30', '0:0:0:0:0:0:0:1', 'Chrome-96.0.4664.110', 'Windows');

-- --------------------------------------------------------

--
-- Table structure for table `sys_user_forgot`
--

CREATE TABLE `sys_user_forgot` (
  `forgot_id` int(11) NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(36) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sys_user_role`
--

CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sys_user_role`
--

INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES
(2107278547, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ref_book_storage`
--
ALTER TABLE `ref_book_storage`
  ADD PRIMARY KEY (`id_book`);

--
-- Indexes for table `ref_genre`
--
ALTER TABLE `ref_genre`
  ADD PRIMARY KEY (`id_genre`);

--
-- Indexes for table `sys_role`
--
ALTER TABLE `sys_role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `sys_user`
--
ALTER TABLE `sys_user`
  ADD PRIMARY KEY (`user_name`),
  ADD UNIQUE KEY `KEY_sys_user_user_id` (`user_id`),
  ADD UNIQUE KEY `KEY_sys_user_user_email` (`user_email`);

--
-- Indexes for table `sys_user_forgot`
--
ALTER TABLE `sys_user_forgot`
  ADD PRIMARY KEY (`forgot_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ref_genre`
--
ALTER TABLE `ref_genre`
  MODIFY `id_genre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `sys_user`
--
ALTER TABLE `sys_user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2107278551;

--
-- AUTO_INCREMENT for table `sys_user_forgot`
--
ALTER TABLE `sys_user_forgot`
  MODIFY `forgot_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
