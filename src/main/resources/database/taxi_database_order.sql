-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taxi_database
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `id_order` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_status` varchar(45) NOT NULL,
  `id_client` int(10) unsigned NOT NULL,
  `id_driver` int(10) unsigned DEFAULT NULL,
  `id_adress_departure` int(10) unsigned NOT NULL,
  `id_adress_arrive` int(10) unsigned NOT NULL,
  `id_coupon` int(10) unsigned DEFAULT NULL,
  `cost` double unsigned NOT NULL,
  `cost_with_discount` double unsigned NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `fk_order_client1_idx` (`id_client`),
  KEY `fk_order_coupon1_idx` (`id_coupon`),
  KEY `fk_order_adress2_idx` (`id_adress_departure`),
  KEY `fk_order_driver1_idx1` (`id_driver`),
  KEY `fk_order_adress3_idx` (`id_adress_arrive`),
  CONSTRAINT `fk_order_adress2` FOREIGN KEY (`id_adress_departure`) REFERENCES `address` (`id_adress`),
  CONSTRAINT `fk_order_adress3` FOREIGN KEY (`id_adress_arrive`) REFERENCES `address` (`id_adress`),
  CONSTRAINT `fk_order_client1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  CONSTRAINT `fk_order_coupon1` FOREIGN KEY (`id_coupon`) REFERENCES `coupon` (`id_coupon`),
  CONSTRAINT `fk_order_driver1` FOREIGN KEY (`id_driver`) REFERENCES `driver` (`id_driver`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (4,'execute',3,1,1,4,1,100,90),(5,'execute',2,1,3,2,NULL,100,100),(6,'execute',4,2,4,5,2,120,100),(7,'execute',2,3,3,4,NULL,120,120);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-27 18:36:14
