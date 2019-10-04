-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: Library
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `checkout_details`
--

DROP TABLE IF EXISTS `checkout_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checkout_details` (
  `TRANS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TRANS_CODE` varchar(30) DEFAULT NULL,
  `TRANS_DATE` date DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`TRANS_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `checkout_details_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkout_details`
--

LOCK TABLES `checkout_details` WRITE;
/*!40000 ALTER TABLE `checkout_details` DISABLE KEYS */;
INSERT INTO `checkout_details` VALUES (12,'43215','1988-01-22',17);
/*!40000 ALTER TABLE `checkout_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkout_items`
--

DROP TABLE IF EXISTS `checkout_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checkout_items` (
  `ITEM_ID` int(11) NOT NULL,
  `TRANS_ID` int(11) NOT NULL,
  KEY `TRANS_ID` (`TRANS_ID`),
  KEY `ITEM_ID` (`ITEM_ID`),
  CONSTRAINT `checkout_items_ibfk_1` FOREIGN KEY (`TRANS_ID`) REFERENCES `checkout_details` (`TRANS_ID`),
  CONSTRAINT `checkout_items_ibfk_2` FOREIGN KEY (`ITEM_ID`) REFERENCES `items` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkout_items`
--

LOCK TABLES `checkout_items` WRITE;
/*!40000 ALTER TABLE `checkout_items` DISABLE KEYS */;
INSERT INTO `checkout_items` VALUES (30,12),(31,12);
/*!40000 ALTER TABLE `checkout_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(128) NOT NULL,
  `ISBN` varchar(128) NOT NULL,
  `AUTHOR` varchar(64) NOT NULL,
  `SUBJECT` varchar(32) NOT NULL,
  `PUBLISHED` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (8,'C++: From Control Structures through Objects','978-0-13-449837-9','Tony Gaddis','2017','Computers Programming'),(9,'ASP.NET CORE IN ACTION','978-1-61729-461-77','Andrew Lock','2018','Computer Programming'),(30,'C++: From Control Structures through Objects','978-0-13-449837-9','Tony Gaddis','2017','Computers Programming'),(31,'ASP.NET CORE IN ACTION','978-1-61729-461-77','Andrew Lock','2018','Computer Programming');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Bill'),(2,'Bill'),(3,'Cameron'),(4,'Cameron'),(5,'Cameron'),(7,'Cameron'),(9,'Susan'),(17,'Daniel');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-04  5:09:53
