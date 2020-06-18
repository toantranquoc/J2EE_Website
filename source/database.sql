-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlybanhang
-- ------------------------------------------------------
-- Server version	5.7.29-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Fullname` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Username` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `DateOfBirthday` datetime DEFAULT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PhoneNumber` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `CreatedBy` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IsActive` bit(1) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturers`
--

DROP TABLE IF EXISTS `manufacturers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufacturers` (
  `IDManufacturer` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Contact` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `IsActive` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IDManufacturer`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturers`
--

LOCK TABLES `manufacturers` WRITE;
/*!40000 ALTER TABLE `manufacturers` DISABLE KEYS */;
INSERT  IGNORE INTO `manufacturers` VALUES (1,'Dell',NULL,_binary ''),(2,'Asus',NULL,_binary ''),(3,'HP',NULL,_binary ''),(4,'Mac',NULL,_binary ''),(5,'Lenovo',NULL,_binary '');
/*!40000 ALTER TABLE `manufacturers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `IDOrder` int(11) NOT NULL,
  `IDProduct` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `UnitPrice` decimal(18,2) NOT NULL,
  PRIMARY KEY (`IDOrder`,`IDProduct`),
  KEY `fk_OrderDetails_Products` (`IDProduct`),
  CONSTRAINT `fk_OrderDetails_Orders` FOREIGN KEY (`IDOrder`) REFERENCES `orders` (`IDOrder`),
  CONSTRAINT `fk_OrderDetails_Products` FOREIGN KEY (`IDProduct`) REFERENCES `products` (`IDProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT  IGNORE INTO `orderdetails` VALUES (1,2,1,10000000.00);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `IDOrder` int(11) NOT NULL AUTO_INCREMENT,
  `Paid` varchar(50) CHARACTER SET utf8 NOT NULL,
  `OrderState` int(11) DEFAULT NULL,
  `OrderDate` datetime DEFAULT NULL,
  `DeliveryDate` datetime DEFAULT NULL,
  `IdUser` int(11) NOT NULL,
  `Receiver` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PhoneNumber` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Address` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`IDOrder`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT  IGNORE INTO `orders` VALUES (1,'Chua thanh toan',1,'2020-06-18 00:00:00','2020-06-20 00:00:00',1,'TÃ´ CÃ´ng Háº­u','16520359@gm.uit.edu.vn','0397596861','69/12T Ä?Æ°á»?ng 120, phÆ°á»?ng TÃ¢n PhÃº, quáº­n 9\r\nPhá»? Minh, Ä?á»©c Phá»?, Quáº£ng NgÃ£i');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photos`
--

DROP TABLE IF EXISTS `photos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Url` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Description` varchar(10000) CHARACTER SET utf8 DEFAULT NULL,
  `DateAdded` datetime DEFAULT NULL,
  `IsMain` bit(1) DEFAULT NULL,
  `IDProduct` int(11) NOT NULL,
  `PublicId` varchar(10000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_PhotoProduct` (`IDProduct`),
  CONSTRAINT `fk_PhotoProduct` FOREIGN KEY (`IDProduct`) REFERENCES `products` (`IDProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photos`
--

LOCK TABLES `photos` WRITE;
/*!40000 ALTER TABLE `photos` DISABLE KEYS */;
/*!40000 ALTER TABLE `photos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `IDProduct` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `Price` decimal(18,2) DEFAULT NULL,
  `Introduction` varchar(10000) CHARACTER SET utf8 DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `Updated` datetime DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `IsNew` bit(1) DEFAULT NULL,
  `Description` varchar(10000) CHARACTER SET utf8 DEFAULT NULL,
  `IDManufacturer` int(11) NOT NULL,
  PRIMARY KEY (`IDProduct`),
  KEY `fk_ProductManufacturer` (`IDManufacturer`),
  CONSTRAINT `fk_ProductManufacturer` FOREIGN KEY (`IDManufacturer`) REFERENCES `manufacturers` (`IDManufacturer`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT  IGNORE INTO `products` VALUES (1,'MacBook Air 2017 128GB (MQD32SA/A)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',1),(2,'MacBook Air 2017 128GB (MQD32SA/A)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',3),(3,'MacBook Air 2017 128GB (MQD32SA/A)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',1),(4,'MacBook Air 2017 128GB (MQD32SA/A)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',4),(5,'Asus VivoBook A512FA i3 8145U (EJ1868T)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',3),(6,'Asus VivoBook A512FA i3 8145U (EJ1868T)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',1),(7,'Asus VivoBook A512FA i3 8145U (EJ1868T)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',3),(8,'HP Pavilion 15 cs3119TX i5 1035G1 (9FN16PA)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',3),(9,'HP Pavilion 15 cs3119TX i5 1035G1 (9FN16PA)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',3),(10,'HP Pavilion 15 cs3119TX i5 1035G1 (9FN16PA)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',4),(11,'HP Pavilion 15 cs3012TU i5 1035G1/8GB/512GB/Win10 (8QP30PA)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',3),(12,'Asus VivoBook X409JA i5 1035G1 (EK052T)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',1),(13,'Asus VivoBook X409JA i5 1035G1 (EK052T)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',4),(14,'Lenovo Ideapad S145 15IWL i7 8565U (81MV00TAVN)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',3),(15,'Dell Vostro 3590 i7 10510U (GRMGK2)',10000000.00,'Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n','2019-09-23 00:00:00','2020-10-30 00:00:00',3,_binary '\0','Culpa veniam deserunt exercitation non excepteur laboris deserunt qui culpa cupidatat irure tempor officia. Qui mollit amet elit duis id adipisicing laborum velit aliquip officia in ea eiusmod quis. Dolor laboris do sint magna id eu. Ad ullamco labore ut cupidatat officia occaecat consequat tempor elit irure enim nulla magna.\n',1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Fullname` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Username` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DateOfBirthday` datetime DEFAULT NULL,
  `Email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PhoneNumber` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `LastActived` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT  IGNORE INTO `users` VALUES (1,NULL,'admin','12345',NULL,NULL,NULL,NULL,'2020-06-18 00:00:00',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'quanlybanhang'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-18 18:46:51
