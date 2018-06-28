-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: baitaplon
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `tbl_admin`
--

DROP TABLE IF EXISTS `tbl_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_admin` (
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `roles` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_admin`
--

LOCK TABLES `tbl_admin` WRITE;
/*!40000 ALTER TABLE `tbl_admin` DISABLE KEYS */;
INSERT INTO `tbl_admin` VALUES ('admin','$2a$10$5jpXxEbhjfOxijh7rCR0De6iskoD8w4qHLqvy3u9UtPodBNdLOOuK','ROLE_ADMIN'),('manh','$2a$10$q/JAFVLJCQ8zEoTrvlRvoOSgfWih2vSioEB9zdFGkI.hFRroe/r3q','ROLE_ADMIN');
/*!40000 ALTER TABLE `tbl_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_noi_dung_de_xuat`
--

DROP TABLE IF EXISTS `tbl_noi_dung_de_xuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_noi_dung_de_xuat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `don_gia` int(11) DEFAULT NULL,
  `ghi_chu` varchar(45) DEFAULT NULL,
  `noi_dung_de_xuat` varchar(45) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `so_ngay` int(11) DEFAULT NULL,
  `thanh_tien` double DEFAULT NULL,
  `id_phieu_de_xuat` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_phieu_de_xuat` (`id_phieu_de_xuat`),
  CONSTRAINT `tbl_noi_dung_de_xuat_ibfk_1` FOREIGN KEY (`id_phieu_de_xuat`) REFERENCES `tbl_phieu_de_xuat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_noi_dung_de_xuat`
--

LOCK TABLES `tbl_noi_dung_de_xuat` WRITE;
/*!40000 ALTER TABLE `tbl_noi_dung_de_xuat` DISABLE KEYS */;
INSERT INTO `tbl_noi_dung_de_xuat` VALUES (28,11,'aaa','aaaaaaaaaaaaa',11,11,121,17),(29,22,'sssss','bbbbb',22,22,484,17),(30,11,'11','11',11,11,121,26),(31,22,'22','22',22,22,484,26),(32,110,'11','manhcanteam123',11,11,1210,27),(33,33,'33','manhcanteam123',33,33,1089,27),(34,11,'ahihi','ahihi',11,111,121,28),(35,22,'ahihi','ahihi',22,22,484,28),(36,33,'ahihi','ahihi',33,33,1089,28),(37,11,'ahihi','ahihi',11,111,121,29),(38,22,'ahihi','ahihi',22,22,484,29),(39,33,'ahihi','ahihi',33,33,1089,29),(40,11,'ahihi','ahihi',11,111,121,30),(41,11,'11','11',11,11,121,31),(42,11,'11','aa',11,11,121,32);
/*!40000 ALTER TABLE `tbl_noi_dung_de_xuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_phieu_chi`
--

DROP TABLE IF EXISTS `tbl_phieu_chi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_phieu_chi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dia_chi` varchar(45) DEFAULT NULL,
  `giam_doc` varchar(45) DEFAULT NULL,
  `hinh_anh` varchar(45) DEFAULT NULL,
  `ly_do_chi` varchar(45) DEFAULT NULL,
  `ngay_lap_phieu` date DEFAULT NULL,
  `nguoi_lap_phieu` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nguoi_nhan_tien` varchar(45) DEFAULT NULL,
  `so_tien` double DEFAULT NULL,
  `trang_thai` int(11) DEFAULT NULL,
  `viet_bang_chu` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `kem_theo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_phieu_chi`
--

LOCK TABLES `tbl_phieu_chi` WRITE;
/*!40000 ALTER TABLE `tbl_phieu_chi` DISABLE KEYS */;
INSERT INTO `tbl_phieu_chi` VALUES (5,'aaaaaaaa','aaaaaaaa','api.PNG','aaaaaaaa','2018-06-26','aaaaaaaa','aaaaaaaa',8,1,NULL,NULL);
/*!40000 ALTER TABLE `tbl_phieu_chi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_phieu_de_xuat`
--

DROP TABLE IF EXISTS `tbl_phieu_de_xuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_phieu_de_xuat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `de_Xuat_Ngay_Mua` date DEFAULT NULL,
  `giam_doc` varchar(45) DEFAULT NULL,
  `kinh_gui` varchar(45) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_de_xuat` date DEFAULT NULL,
  `ngay_hoan_thanh` date DEFAULT NULL,
  `nguoi_de_nghi` varchar(45) DEFAULT NULL,
  `nguoi_ke_toan` varchar(45) DEFAULT NULL,
  `noi_dung_de_xuat` varchar(45) DEFAULT NULL,
  `tong_tien` int(11) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT NULL,
  `y_kien_lanh_dao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_phieu_de_xuat`
--

LOCK TABLES `tbl_phieu_de_xuat` WRITE;
/*!40000 ALTER TABLE `tbl_phieu_de_xuat` DISABLE KEYS */;
INSERT INTO `tbl_phieu_de_xuat` VALUES (17,'2010-01-01','aaaaaaaaaaaaa','aaaaaaaaaaaaa','2018-01-01','2018-06-26','2018-01-01','aaaaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaaaa',605,1,'aaaaaaaaaaaaa'),(18,'2010-01-01','hihihi','hihihi','2018-01-01','2018-06-26','2019-02-02','hihihi','hihihi','hihihi',0,1,'hihihi'),(19,'2010-01-01','qqqqqqqqqqq','qqqqqqqqqqq','2018-01-02','2018-06-26','2018-01-02','qqqqqqqqqqq','qqqqqqqqqqq','qqqqqqqqqqq',0,0,'qqqqqqqqqqq'),(20,'2010-01-01','eeeeeee','eeeeeee','2018-01-01','2018-06-26','2018-01-01','eeeeeee','eeeeeee','eeeeeee',0,0,'eeeeeee'),(21,'2010-01-01','eeeeeee','eeeeeee','2018-01-01','2018-06-26','2018-01-01','eeeeeee','eeeeeee','eeeeeee',0,0,'eeeeeee'),(22,'2010-01-01','eeeeeee','eeeeeee','2018-01-01','2018-06-26','2018-01-01','eeeeeee','eeeeeee','eeeeeee',0,0,'eeeeeee'),(23,'2018-01-02','eeeeeee','eeeeeee','2018-01-02','2018-06-26','2018-01-02','eeeeeee','eeeeeee','eeeeeee',0,0,'eeeeeee'),(24,'2010-01-01','xxxxxxxxx','xxxxxxxxx','2018-01-02','2018-06-26','2018-01-02','xxxxxxxxx','xxxxxxxxx','xxxxxxxxx',0,0,'xxxxxxxxx'),(25,'2010-01-01','xxxxxxxxx','xxxxxxxxx','2018-01-02','2018-06-26','2018-01-02','xxxxxxxxx','xxxxxxxxx','xxxxxxxxx',0,0,'xxxxxxxxx'),(26,'2010-01-01','tttttttt','tttttttt','2018-01-02','2018-06-26','2018-01-02','tttttttt','tttttttt','tttttttt',605,0,'tttttttt'),(27,'2010-01-01','manhcanteam123','manhcanteam123','2018-01-02','2018-06-26','2018-01-02','manhcanteam123','manhcanteam123','manhcanteam123',2299,0,'manhcanteam123'),(28,'2010-01-01','ahihi','ahihi','2018-01-02','2018-06-27','2018-01-02','ahihi','ahihi','',1694,0,''),(29,'2010-01-01','ahihi','ahihi','2018-01-02','2018-06-27','2018-01-02','ahihi','ahihi','',1694,0,''),(30,'2010-01-01','ahihi','ahihi','2018-01-02','2018-06-27','2018-01-02','ahihi','ahihi','',121,0,''),(31,'2010-01-01','','ahihihi','2018-01-02','2018-06-27','2018-01-02','return checkPC()','','return checkPC()',121,0,'return checkPC()'),(32,'2010-01-01','aa','aa','2018-01-02','2018-06-27','2018-01-02','aa','aa','aa',121,0,'aa');
/*!40000 ALTER TABLE `tbl_phieu_de_xuat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-29  0:53:30
