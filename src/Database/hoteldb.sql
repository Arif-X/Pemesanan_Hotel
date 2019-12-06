-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.7-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for tels
DROP DATABASE IF EXISTS `tels`;
CREATE DATABASE IF NOT EXISTS `tels` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tels`;

-- Dumping structure for function tels.autoInc
DROP FUNCTION IF EXISTS `autoInc`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` FUNCTION `autoInc`() RETURNS int(10)
BEGIN
        DECLARE getCount INT(10);

        SET getCount = (SELECT id_hotel FROM hotel ORDER BY id_Hotel desc LIMIT 1);

        RETURN getCount;
    END//
DELIMITER ;

-- Dumping structure for event tels.hapus_pesanan
DROP EVENT IF EXISTS `hapus_pesanan`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` EVENT `hapus_pesanan` ON SCHEDULE EVERY 1 SECOND STARTS '2019-11-27 00:00:00' ON COMPLETION PRESERVE ENABLE COMMENT 'Hapus data yang hari ini' DO DELETE FROM pemesanan WHERE tgl_check_out < NOW()//
DELIMITER ;

-- Dumping structure for table tels.harga_kamar_hotel
DROP TABLE IF EXISTS `harga_kamar_hotel`;
CREATE TABLE IF NOT EXISTS `harga_kamar_hotel` (
  `id_harga` int(11) NOT NULL AUTO_INCREMENT,
  `id_hotel` bigint(11) NOT NULL,
  `harga_standart_room` int(11) NOT NULL,
  `harga_superrior_room` int(11) NOT NULL,
  `harga_deluxe_room` int(11) NOT NULL,
  `harga_studio_room` int(11) NOT NULL,
  `harga_suite_room` int(11) NOT NULL,
  `harga_presidential_room` int(11) NOT NULL,
  PRIMARY KEY (`id_harga`),
  KEY `id_hotel` (`id_hotel`),
  CONSTRAINT `harga_kamar_hotel_ibfk_2` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table tels.hotel
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE IF NOT EXISTS `hotel` (
  `id_hotel` bigint(11) NOT NULL AUTO_INCREMENT,
  `nama_hotel` varchar(50) NOT NULL,
  `alamat_hotel` varchar(100) NOT NULL,
  `no_telp_hotel` bigint(14) NOT NULL,
  `email_hotel` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `pengelola` varchar(50) NOT NULL,
  PRIMARY KEY (`id_hotel`),
  KEY `nama_hotel` (`nama_hotel`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table tels.ketersediaan_kamar
DROP TABLE IF EXISTS `ketersediaan_kamar`;
CREATE TABLE IF NOT EXISTS `ketersediaan_kamar` (
  `id_hotel` bigint(20) NOT NULL,
  `standart_room` enum('Tersedia','Tidak Tersedia') NOT NULL,
  `superrior_room` enum('Tersedia','Tidak Tersedia') NOT NULL,
  `deluxe_room` enum('Tersedia','Tidak Tersedia') NOT NULL,
  `studio_room` enum('Tersedia','Tidak Tersedia') NOT NULL,
  `suite_room` enum('Tersedia','Tidak Tersedia') NOT NULL,
  `presidential_room` enum('Tersedia','Tidak Tersedia') NOT NULL,
  PRIMARY KEY (`id_hotel`),
  CONSTRAINT `FK_ketersediaan_kamar_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table tels.pemesanan
DROP TABLE IF EXISTS `pemesanan`;
CREATE TABLE IF NOT EXISTS `pemesanan` (
  `id_pemesanan` int(11) NOT NULL AUTO_INCREMENT,
  `email_pemesan` varchar(100) NOT NULL,
  `id_hotel` bigint(11) NOT NULL,
  `jenis_kamar` varchar(50) NOT NULL,
  `tgl_check_in` date NOT NULL,
  `tgl_check_out` date NOT NULL,
  `harga_permalam` int(11) DEFAULT NULL,
  `harga_total` int(11) NOT NULL,
  `ketersediaan` enum('Tersedia','Tidak Tersedia') NOT NULL,
  PRIMARY KEY (`id_pemesanan`),
  KEY `email_pemesan` (`email_pemesan`),
  KEY `id_hotel` (`id_hotel`),
  CONSTRAINT `pemesanan_ibfk_1` FOREIGN KEY (`email_pemesan`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pemesanan_ibfk_2` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for function tels.pesananBaru
DROP FUNCTION IF EXISTS `pesananBaru`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` FUNCTION `pesananBaru`() RETURNS int(10)
BEGIN
        DECLARE getCount INT(10);

        SET getCount = (SELECT id_pemesanan FROM pemesanan ORDER BY id_pemesanan desc LIMIT 1);

        RETURN getCount;
    END//
DELIMITER ;

-- Dumping structure for table tels.stok_kamar
DROP TABLE IF EXISTS `stok_kamar`;
CREATE TABLE IF NOT EXISTS `stok_kamar` (
  `id_stok` int(11) NOT NULL AUTO_INCREMENT,
  `id_hotel` bigint(11) NOT NULL,
  `stok_standart_room` int(11) NOT NULL,
  `stok_superrior_room` int(11) NOT NULL,
  `stok_deluxe_room` int(11) NOT NULL,
  `stok_studio_room` int(11) NOT NULL,
  `stok_suite_room` int(11) NOT NULL,
  `stok_presidential_room` int(11) NOT NULL,
  PRIMARY KEY (`id_stok`),
  KEY `id_hotel` (`id_hotel`),
  CONSTRAINT `stok_kamar_ibfk_1` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table tels.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `jenis_kelamin` enum('Laki-Laki','Perempuan') NOT NULL,
  `nik` bigint(12) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `agama` varchar(50) NOT NULL,
  `no_hp` bigint(15) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `email` (`email`),
  KEY `email_2` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for trigger tels.insert_sedia
DROP TRIGGER IF EXISTS `insert_sedia`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `insert_sedia` AFTER UPDATE ON `stok_kamar` FOR EACH ROW BEGIN
	IF (new.stok_standart_room = 0) THEN
		UPDATE ketersediaan_kamar SET standart_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;
		
	ELSEIF (new.stok_superrior_room = 0) THEN
		UPDATE ketersediaan_kamar SET superrior_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;	
	
	ELSEIF (new.stok_deluxe_room = 0) THEN
		UPDATE ketersediaan_kamar SET deluxe_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;	
		
	ELSEIF (new.stok_studio_room = 0) THEN
		UPDATE ketersediaan_kamar SET studio_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;	
		
	ELSEIF (new.stok_suite_room = 0) THEN
		UPDATE ketersediaan_kamar SET suite_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;	
		
	ELSEIF (new.stok_presidential_room = 0) THEN
		UPDATE ketersediaan_kamar SET presidential_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;								
	END IF;										
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger tels.pemesanan_stok_decrement
DROP TRIGGER IF EXISTS `pemesanan_stok_decrement`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `pemesanan_stok_decrement` AFTER INSERT ON `pemesanan` FOR EACH ROW IF (new.jenis_kamar = 'Standart Room') THEN
	UPDATE stok_kamar SET stok_standart_room = stok_standart_room - 1 WHERE id_hotel = new.id_hotel AND stok_standart_room > 0;	
	
ELSEIF (new.jenis_kamar = 'Superrior Room') THEN
	UPDATE stok_kamar SET stok_superrior_room = stok_superrior_room - 1 WHERE id_hotel = new.id_hotel AND stok_superrior_room > 0;	
	
ELSEIF (new.jenis_kamar = 'Deluxe Room') THEN
	UPDATE stok_kamar SET stok_deluxe_room = stok_deluxe_room - 1 WHERE id_hotel = new.id_hotel AND stok_deluxe_room > 0;	
	
ELSEIF (new.jenis_kamar = 'Studio Room') THEN
	UPDATE stok_kamar SET stok_studio_room = stok_studio_room - 1 WHERE id_hotel = new.id_hotel AND stok_studio_room > 0;	
	
ELSEIF (new.jenis_kamar = 'Suite Room') THEN
	UPDATE stok_kamar SET stok_suite_room = stok_suite_room - 1 WHERE id_hotel = new.id_hotel AND stok_suite_room > 0;	
	
ELSEIF (new.jenis_kamar = 'Presidential Room') THEN
	UPDATE stok_kamar SET stok_presidential_room = stok_presidential_room - 1 WHERE id_hotel = new.id_hotel AND stok_presidential_room > 0;	
END IF//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger tels.pemesanan_stok_increment
DROP TRIGGER IF EXISTS `pemesanan_stok_increment`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `pemesanan_stok_increment` AFTER DELETE ON `pemesanan` FOR EACH ROW IF (old.jenis_kamar = 'Standart Room') THEN
	UPDATE stok_kamar SET stok_standart_room = stok_standart_room + 1 WHERE id_hotel = old.id_hotel;	

ELSEIF (old.jenis_kamar = 'Superrior Room') THEN
	UPDATE stok_kamar SET stok_superrior_room = stok_superrior_room + 1 WHERE id_hotel = old.id_hotel;	

ELSEIF (old.jenis_kamar = 'Deluxe Room') THEN
	UPDATE stok_kamar SET stok_deluxe_room = stok_deluxe_room + 1 WHERE id_hotel = old.id_hotel;	
	
ELSEIF (old.jenis_kamar = 'Studio Room') THEN
	UPDATE stok_kamar SET stok_studio_room = stok_studio_room + 1 WHERE id_hotel = old.id_hotel;	

ELSEIF (old.jenis_kamar = 'Suite Room') THEN
	UPDATE stok_kamar SET stok_suite_room = stok_suite_room + 1 WHERE id_hotel = old.id_hotel;	

ELSEIF (old.jenis_kamar = 'Presidetial Room') THEN
	UPDATE stok_kamar SET stok_presidential_room = stok_presidential_room + 1 WHERE id_hotel = old.id_hotel;				
END IF//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger tels.pemesanan_trig
DROP TRIGGER IF EXISTS `pemesanan_trig`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `pemesanan_trig` BEFORE INSERT ON `pemesanan` FOR EACH ROW IF (new.ketersediaan = 'Tidak Tersedia') THEN
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Pesanan Tidak Valid Dikarenakan Tidak Tersedia';
ELSE
	SET new.ketersediaan = new.ketersediaan;
END IF//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger tels.stok_kamar_trig
DROP TRIGGER IF EXISTS `stok_kamar_trig`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `stok_kamar_trig` AFTER UPDATE ON `stok_kamar` FOR EACH ROW IF (new.stok_standart_room = 0) THEN
		UPDATE ketersediaan_kamar SET standart_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;
	
	ELSEIF (new.stok_superrior_room = 0) THEN
		UPDATE ketersediaan_kamar SET superrior_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;	
	
	ELSEIF (new.stok_deluxe_room = 0) THEN
		UPDATE ketersediaan_kamar SET deluxe_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;	
		
	ELSEIF (new.stok_studio_room = 0) THEN
		UPDATE ketersediaan_kamar SET studio_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;	
		
	ELSEIF (new.stok_suite_room = 0) THEN
		UPDATE ketersediaan_kamar SET suite_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;	
		
	ELSEIF (new.stok_presidential_room = 0) THEN
		UPDATE ketersediaan_kamar SET presidential_room = 'Tidak Tersedia' WHERE id_hotel = old.id_hotel;		
	
	
	
	ELSEIF (new.stok_standart_room > 0) THEN
		UPDATE ketersediaan_kamar SET standart_room = 'Tersedia' WHERE id_hotel = old.id_hotel;  
		
	ELSEIF (new.stok_superrior_room > 0) THEN
		UPDATE ketersediaan_kamar SET superrior_room = 'Tersedia' WHERE id_hotel = old.id_hotel;	
	
	ELSEIF (new.stok_deluxe_room > 0) THEN
		UPDATE ketersediaan_kamar SET deluxe_room = 'Tersedia' WHERE id_hotel = old.id_hotel;	
		
	ELSEIF (new.stok_studio_room > 0) THEN
		UPDATE ketersediaan_kamar SET studio_room = 'Tersedia' WHERE id_hotel = old.id_hotel;	
		
	ELSEIF (new.stok_suite_room > 0) THEN
		UPDATE ketersediaan_kamar SET suite_room = 'Tersedia' WHERE id_hotel = old.id_hotel;	
		
	ELSEIF (new.stok_presidential_room > 0) THEN
		UPDATE ketersediaan_kamar SET presidential_room = 'Tersedia' WHERE id_hotel = old.id_hotel;				
	
	END IF//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
