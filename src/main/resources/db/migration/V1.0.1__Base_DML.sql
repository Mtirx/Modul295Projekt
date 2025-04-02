-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server-Version:               10.6.4-MariaDB-1:10.6.4+maria~focal - mariadb.org binary distribution
-- Server-Betriebssystem:        debian-linux-gnu
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Exportiere Daten aus Tabelle product-manager.category: ~3 rows (ungefähr)
INSERT INTO `category` (`active`, `id`, `name`) VALUES
	(1, 53, 'Gaming'),
	(1, 54, 'PCs'),
	(1, 56, 'Handys');

-- Exportiere Daten aus Tabelle product-manager.category_seq: ~1 rows (ungefähr)
INSERT INTO `category_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(151, 1, 9223372036854775806, 1, 50, 0, 0, 0);

-- Exportiere Daten aus Tabelle product-manager.product: ~8 rows (ungefähr)
INSERT INTO `product` (`active`, `category_id`, `id`, `price`, `stock`, `description`, `image`, `name`, `sku`) VALUES
	(1, 53, 53, 100, 200, 'Gute Tastatur', NULL, 'Gaming-Tastatur3000', 'jsjfa'),
	(1, 53, 54, 100, 200, 'Gute Maus', NULL, 'Gaming-Maus-3001', 'aiojfa'),
	(1, 53, 56, 300, 20, 'Guter Monitor', NULL, 'Gaming-Monitor-5000', 'fsiaf'),
	(1, 54, 58, 6000, 1, 'Intel i9 14th Gen, RTX5090 64 GB RAM 4TB Festplatte', NULL, 'Marco-Gaming-PC', 'fhaoofaf'),
	(1, 54, 60, 2, 1, 'Intel i3 1th Gen, GeForce 256, 64 MB RAM 512MB Festplatte', NULL, 'Joel-Gaming-PC', 'asfsfsaf'),
	(1, 56, 61, 500, 20, 'Super Iphone', NULL, 'Iphone 15', 'safsafs'),
	(1, 56, 62, 400, 2, 'Super Iphone', NULL, 'Iphone 14', 'fsfasf'),
	(0, 56, 64, 120210, 0, 'Super Iphone', NULL, 'Iphone 16', 'asaf');

-- Exportiere Daten aus Tabelle product-manager.product_seq: ~1 rows (ungefähr)
INSERT INTO `product_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(151, 1, 9223372036854775806, 1, 50, 0, 0, 0);

-- Exportiere Daten aus Tabelle product-manager.user: ~3 rows (ungefähr)
INSERT INTO `user` (`id`, `email`, `password`, `role`, `username`) VALUES
	(102, 'admin@test.ch', '$2a$10$y9nxg.6ehpx5P3lGadmf0.cBBNL4aTvPsmjjzJ6kKBU/vB0Rp13yC', 'admin', 'Admin'),
	(103, 'marco@test.ch', '$2a$10$hM7a3xBr9RM5v4RrVuZJOuH7H6egkIaMbeehft9MaGnjq9feks5Fy', 'user', 'Marco'),
	(104, 'joel@test.ch', '$2a$10$NBEYd8Cjc64zMKn5cKsf3eTIHl/iiu03bixzvCanigfelsI4.tFjO', 'user', 'Joel');

-- Exportiere Daten aus Tabelle product-manager.user_seq: ~1 rows (ungefähr)
INSERT INTO `user_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(201, 1, 9223372036854775806, 1, 50, 0, 0, 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
