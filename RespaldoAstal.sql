-- MariaDB dump 10.18  Distrib 10.4.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: fincalab_astal
-- ------------------------------------------------------
-- Server version	10.4.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividadesbh`
--

DROP TABLE IF EXISTS `actividadesbh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividadesbh` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Actividad` varchar(45) NOT NULL,
  `Descripcion` varchar(65) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividadesbh`
--

LOCK TABLES `actividadesbh` WRITE;
/*!40000 ALTER TABLE `actividadesbh` DISABLE KEYS */;
INSERT INTO `actividadesbh` VALUES (1,'Envio De Muestra','Enviar Muestra Al Laboratorio',1,1,'2019-08-14','11:51:57','','',1,1),(2,'Almacenamiento','Resguardo Del Cafe Seco',1,1,'2019-08-14','11:52:13','','',1,1),(3,'Lavado Mecanico','Lavado Por Una Maquiaria',1,1,'2019-08-14','11:52:53','','',1,1),(4,'Lavado Tradicional','Lavado En Pilas De Fermento',1,1,'2019-08-14','11:53:10','','',1,1),(5,'Secado','Proceso Para Tener La Humedad Optima Del Cafe',1,1,'2019-08-14','11:53:57','','',1,1),(6,'Despulpar','Despulpado De Cafe Cereza',1,1,'2019-08-14','11:54:14','','',1,1),(7,'Floteo','Separacion Por Densimetrico De Agua',1,1,'2019-08-14','11:54:39','','',1,1),(8,'Separaacion De Verdes','Separacion Por Densidad?',1,1,'2019-08-14','11:54:58','','',1,1),(9,'Trasporte Por Bomba','Trasporte Usando Una Bomba',1,1,'2019-08-14','11:55:25','','',1,1),(10,'Trasnposte Por Elecoidal','Trasnsporte Usando Un \"gusano\" Elecoidal',1,1,'2019-08-14','11:56:19','','',1,1),(11,'Recepción','Recibir El Café',1,1,'2019-08-14','11:56:36','','',1,1);
/*!40000 ALTER TABLE `actividadesbh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividadesparcelas`
--

DROP TABLE IF EXISTS `actividadesparcelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividadesparcelas` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Actividad` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(65) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividadesparcelas`
--

LOCK TABLES `actividadesparcelas` WRITE;
/*!40000 ALTER TABLE `actividadesparcelas` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividadesparcelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `almacenes`
--

DROP TABLE IF EXISTS `almacenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `almacenes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idResponsable` int(11) NOT NULL,
  `idCapturista` int(11) NOT NULL,
  `nombreAlmacen` varchar(100) NOT NULL,
  `domicilio` varchar(250) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `idSociedad` int(11) NOT NULL,
  `idLocalidad` int(11) NOT NULL,
  `externo` tinyint(1) NOT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacenes`
--

LOCK TABLES `almacenes` WRITE;
/*!40000 ALTER TABLE `almacenes` DISABLE KEYS */;
INSERT INTO `almacenes` VALUES (1,0,0,'AL-AD-1','Conocido S/N','0',2,23,0,1),(2,0,0,'AL-CT-2','Paulino (Conocido S/N)','0',3,4,0,1),(3,0,0,'AL-CT-3','Piña (Conocido S/N)','0',3,4,0,1),(4,0,0,'AL-CS-4','Arrocera (Bravo # 35)','3271013377',4,1,0,1),(5,0,0,'AL-CS-5','Duende (Carretera Vallarta - Chapalila S/N)','327273847',4,1,0,1),(6,0,0,'AL-C-6','Presidio (Conocido S/N)','0',6,9,1,1),(7,0,0,'AL-C-7','Guajolote (Conocido S/N)','0',6,9,0,1),(8,0,0,'AL-C-8','Sombrero (Conocido S/N)','0',6,9,0,1),(9,0,0,'AL-C-9','Banco Colorado (Conocido S/N)','0',6,9,0,1),(10,0,0,'AL-C-10','Tempizque (Conocido S/N)','0',6,9,0,1),(11,0,0,'AL-C-11','Banco Colorado 2 (Conocido S/N)','0',6,9,0,1),(12,0,0,'AL-AI-12','Conocido S/N','0',7,23,0,1);
/*!40000 ALTER TABLE `almacenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areaalmacen`
--

DROP TABLE IF EXISTS `areaalmacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areaalmacen` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Almacen` varchar(45) NOT NULL,
  `Clave` varchar(3) NOT NULL,
  `Area` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areaalmacen`
--

LOCK TABLES `areaalmacen` WRITE;
/*!40000 ALTER TABLE `areaalmacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `areaalmacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignacionespersona`
--

DROP TABLE IF EXISTS `asignacionespersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignacionespersona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `codigo` varchar(35) NOT NULL,
  `puesto` varchar(35) NOT NULL,
  `tipoPersona` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=405 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignacionespersona`
--

LOCK TABLES `asignacionespersona` WRITE;
/*!40000 ALTER TABLE `asignacionespersona` DISABLE KEYS */;
INSERT INTO `asignacionespersona` VALUES (1,1,'Prodcutor','Productor',1),(2,2,'Productor','Productor',1),(3,3,'Productor','Productor',1),(4,4,'Productor','Productor',1),(5,5,'Productor','Productor',1),(6,6,'Productor','Productor',1),(7,7,'Productor','Productor',1),(8,8,'Productor','Productor',1),(9,9,'Productor','Productor',1),(10,10,'Productor','Productor',1),(11,11,'Productor','Productor',1),(12,12,'Productor','Productor',1),(13,13,'Productor','Productor',1),(14,14,'Productor','Productor',1),(15,15,'Productor','Productor',1),(16,16,'Productor','Productor',1),(17,17,'Productor','Productor',1),(18,18,'Productor','Productor',1),(19,19,'Productor','Productor',1),(20,20,'Productor','Productor',1),(21,21,'Productor','Productor',1),(22,22,'Productor','Productor',1),(23,23,'Productor','Productor',1),(24,24,'Productor','Productor',1),(25,25,'Productor','Productor',1),(26,26,'Productor','Productor',1),(27,27,'Productor','Productor',1),(28,28,'Productor','Productor',1),(29,29,'Productor','Productor',1),(30,30,'Productor','Productor',1),(31,31,'Productor','Productor',1),(32,32,'Productor','Productor',1),(33,33,'Productor','Productor',1),(34,34,'Productor','Productor',1),(35,35,'Productor','Productor',1),(36,36,'Productor','Productor',1),(37,37,'Productor','Productor',1),(38,38,'Productor','Productor',1),(39,39,'Productor','Productor',1),(40,40,'Productor','Productor',1),(41,41,'Productor','Productor',1),(42,42,'Productor','Productor',1),(43,43,'Productor','Productor',1),(44,44,'Productor','Productor',1),(45,45,'Productor','Productor',1),(46,46,'Productor','Productor',1),(47,47,'Productor','Productor',1),(48,48,'Productor','Productor',1),(49,49,'Productor','Productor',1),(50,50,'Productor','Productor',1),(51,51,'Productor','Productor',1),(52,52,'Productor','Productor',1),(53,53,'Productor','Productor',1),(54,54,'Productor','Productor',1),(55,55,'Productor','Productor',1),(56,56,'Productor','Productor',1),(57,57,'Productor','Productor',1),(58,58,'Productor','Productor',1),(59,59,'Productor','Productor',1),(60,60,'Capturista Recepcion','Capturista de Recepción',1),(61,61,'Productor','Productor',1),(62,62,'Productor','Productor',1),(63,63,'Productor','Productor',1),(64,64,'Productor','Productor',1),(65,65,'Productor','Productor',1),(66,66,'Productor','Productor',1),(67,67,'Productor','Productor',1),(68,69,'Productor','Productor',1),(69,68,'Productor','Productor',1),(70,70,'Productor','Productor',1),(71,71,'Productor','Productor',1),(72,72,'Productor','Productor',1),(73,73,'Productor','Productor',1),(74,74,'Productor','Productor',1),(75,75,'Productor','Productor',1),(76,76,'Productor','Productor',1),(77,77,'Productor','Productor',1),(78,78,'Productor','Productor',1),(79,79,'Productor','Productor',1),(80,80,'Productor','Productor',1),(81,81,'Productor','Productor',1),(82,82,'Productor','Productor',1),(83,83,'Productor','Productor',1),(84,84,'Productor','Productor',1),(85,85,'Productor','Productor',1),(86,86,'Productor','Productor',1),(87,87,'Productor','Productor',1),(88,88,'Productor','Productor',1),(89,89,'Productor','Productor',1),(90,90,'Productor','Productor',1),(91,91,'Productor','Productor',1),(92,92,'Productor','Productor',1),(93,93,'Productor','Productor',1),(94,94,'Productor','Productor',1),(95,95,'Productor','Productor',1),(96,96,'Productor','Productor',1),(97,97,'Productor','Productor',1),(98,98,'Productor','Productor',1),(99,99,'Productor','Productor',1),(100,100,'Productor','Productor',1),(101,101,'Productor','Productor',1),(102,102,'Productor','Productor',1),(103,103,'Productor','Productor',1),(104,104,'Productor','Productor',1),(105,105,'Productor','Productor',1),(106,106,'Productor','Productor',1),(107,107,'Productor','Productor',1),(108,108,'Productor','Productor',1),(109,109,'Productor','Productor',1),(110,110,'Productor','Productor',1),(111,111,'Productor','Productor',1),(112,112,'Productor','Productor',1),(113,113,'Productor','Productor',1),(114,114,'Productor','Productor',1),(115,115,'Productor','Productor',1),(116,116,'Productor','Productor',1),(117,117,'Productor','Productor',1),(118,118,'Productor','Productor',1),(119,119,'Productor','Productor',1),(121,120,'Productor','Productor',1),(122,121,'Productor','Productor',1),(123,122,'Productor','Productor',1),(124,123,'Productor','Productor',1),(126,124,'Productor','Productor',1),(127,125,'Productor','Productor',1),(128,126,'Productor','Productor',1),(129,127,'Productor','Productor',1),(130,128,'Productor','Productor',1),(131,129,'Productor','Productor',1),(132,130,'Productor','Productor',1),(133,131,'Productor','Productor',1),(134,132,'Productor','Productor',1),(135,133,'Productor','Productor',1),(136,134,'Productor','Productor',1),(137,135,'Productor','Productor',1),(138,136,'Productor','Productor',1),(139,137,'Productor','Productor',1),(140,138,'Productor','Productor',1),(141,139,'Productor','Productor',1),(142,140,'Productor','Productor',1),(143,141,'Productor','Productor',1),(144,142,'Productor','Productor',1),(145,143,'Productor','Productor',1),(146,144,'Productor','Productor',1),(147,145,'Productor','Productor',1),(148,146,'Productor','Productor',1),(149,147,'Productor','Productor',1),(150,148,'Productor','Productor',1),(151,149,'Productor','Productor',1),(152,150,'Productor','Productor',1),(153,151,'Productor','Productor',1),(154,152,'Productor','Productor',1),(155,153,'Productor','Productor',1),(156,154,'Productor','Productor',1),(157,155,'Productor','Productor',1),(158,156,'Productor','Productor',1),(159,157,'Productor','Productor',1),(160,158,'Productor','Productor',1),(161,159,'Productor','Productor',1),(162,160,'Productor','Productor',1),(163,161,'Productor','Productor',1),(164,162,'Productor','Productor',1),(165,163,'Productor','Productor',1),(166,164,'Productor','Productor',1),(167,165,'Productor','Productor',1),(168,166,'Productor','Productor',1),(169,167,'Productor','Productor',1),(170,168,'Productor','Productor',1),(171,169,'Productor','Productor',1),(172,170,'Productor','Productor',1),(173,171,'Productor','Productor',1),(174,172,'Productor','Productor',1),(175,173,'Productor','Productor',1),(176,174,'Productor','Productor',1),(177,175,'Productor','Productor',1),(178,176,'Productor','Productor',1),(179,177,'Productor','Productor',1),(180,178,'Productor','Productor',1),(181,179,'Productor','Productor',1),(182,180,'Productor','Productor',1),(183,181,'Productor','Productor',1),(184,182,'Productor','Productor',1),(185,183,'Productor','Productor',1),(186,184,'Productor','Productor',1),(187,185,'Productor','Productor',1),(188,186,'Productor','Productor',1),(189,187,'Productor','Productor',1),(190,188,'Productor','Productor',1),(191,189,'Productor','Productor',1),(192,190,'Productor','Productor',1),(193,191,'Productor','Productor',1),(194,192,'Productor','Productor',1),(195,193,'Productor','Productor',1),(196,194,'Productor','Productor',1),(197,195,'Productor','Productor',1),(198,196,'Productor','Productor',1),(199,197,'Productor','Productor',1),(200,198,'Productor','Productor',1),(201,199,'Productor','Productor',1),(202,200,'Productor','Productor',1),(203,201,'Productor','Productor',1),(204,202,'Productor','Productor',1),(205,203,'Productor','Productor',1),(206,204,'Productor','Productor',1),(207,205,'Productor','Productor',1),(208,206,'Productor','Productor',1),(209,207,'Productor','Productor',1),(210,208,'Productor','Productor',1),(211,209,'Productor','Productor',1),(212,210,'Capturista Recepcion','Capturista de Recepción',1),(213,210,'Capturista Beneficio','Capturista de Beneficio Húmedo',1),(214,211,'Encargado Beneficio','Encargado de Beneficio Húmedo',1),(215,212,'Productor','Productor',1),(216,213,'Productor','Productor',1),(217,214,'Productor','Productor',1),(218,215,'Productor','Productor',1),(219,216,'Productor','Productor',1),(220,217,'Productor','Productor',1),(221,218,'Productor','Productor',1),(222,219,'Productor','Productor',1),(223,220,'Productor','Productor',1),(224,221,'Productor','Productor',1),(225,222,'Productor','Productor',1),(226,223,'Productor','Productor',1),(227,224,'Productor','Productor',1),(228,225,'Productor','Productor',1),(229,226,'Productor','Productor',1),(230,227,'Productor','Productor',1),(231,228,'Productor','Productor',1),(232,229,'Productor','Productor',1),(233,230,'Productor','Productor',1),(234,231,'Productor','Productor',1),(235,232,'Productor','Productor',1),(236,233,'Productor','Productor',1),(237,234,'Productor','Productor',1),(238,235,'Productor','Productor',1),(239,236,'Productor','Productor',1),(240,237,'Productor','Productor',1),(241,238,'Productor','Productor',1),(242,239,'Productor','Productor',1),(243,240,'Productor','Productor',1),(244,241,'Productor','Productor',1),(245,242,'Productor','Productor',1),(246,243,'Productor','Productor',1),(247,244,'Productor','Productor',1),(248,245,'Productor','Productor',1),(249,246,'Productor','Productor',1),(250,247,'Productor','Productor',1),(251,248,'Productor','Productor',1),(252,249,'Productor','Productor',1),(253,250,'Productor','Productor',1),(254,251,'Productor','Productor',1),(255,252,'Productor','Productor',1),(256,253,'Productor','Productor',1),(257,254,'Productor','Productor',1),(258,255,'Productor','Productor',1),(259,256,'Productor','Productor',1),(260,257,'Capturista Recepcion','Capturista de Recepción',1),(261,258,'Productor','Productor',1),(262,259,'Productor','Productor',1),(263,260,'Productor','Productor',1),(264,261,'Productor','Productor',1),(265,262,'Productor','Productor',1),(266,263,'Productor','Productor',1),(267,264,'Productor','Productor',1),(268,265,'Productor','Productor',1),(269,266,'Productor','Productor',1),(270,267,'Productor','Productor',1),(271,268,'Productor','Productor',1),(272,269,'Productor','Productor',1),(273,270,'Productor','Productor',1),(274,271,'Productor','Productor',1),(275,272,'Productor','Productor',1),(276,273,'Productor','Productor',1),(277,274,'Productor','Productor',1),(278,275,'Productor','Productor',1),(279,276,'Productor','Productor',1),(280,277,'Productor','Productor',1),(281,278,'Productor','Productor',1),(282,279,'Productor','Productor',1),(283,280,'Productor','Productor',1),(284,281,'Productor','Productor',1),(285,282,'Productor','Productor',1),(286,283,'Productor','Productor',1),(287,284,'Productor','Productor',1),(288,285,'Productor','Productor',1),(289,286,'Productor','Productor',1),(290,287,'Productor','Productor',1),(291,288,'Productor','Productor',1),(292,289,'Productor','Productor',1),(293,290,'Productor','Productor',1),(294,291,'Productor','Productor',1),(295,292,'Productor','Productor',1),(296,293,'Productor','Productor',1),(297,294,'Productor','Productor',1),(298,295,'Productor','Productor',1),(299,296,'Productor','Productor',1),(300,297,'Productor','Productor',1),(301,298,'Productor','Productor',1),(302,299,'Productor','Productor',1),(303,300,'Productor','Productor',1),(304,301,'Productor','Productor',1),(305,302,'Productor','Productor',1),(306,303,'Productor','Productor',1),(308,305,'Productor','Productor',1),(309,306,'Productor','Productor',1),(310,307,'Productor','Productor',1),(311,308,'Productor','Productor',1),(312,309,'Productor','Productor',1),(313,310,'Productor','Productor',1),(314,311,'Productor','Productor',1),(315,312,'Productor','Productor',1),(316,313,'Productor','Productor',1),(317,314,'Productor','Productor',1),(318,315,'Productor','Productor',1),(319,316,'Productor','Productor',1),(320,317,'Productor','Productor',1),(321,318,'Productor','Productor',1),(322,319,'Productor','Productor',1),(323,320,'Productor','Productor',1),(324,321,'Productor','Productor',1),(325,322,'Productor','Productor',1),(326,323,'Productor','Productor',1),(327,324,'Productor','Productor',1),(328,325,'Productor','Productor',1),(329,326,'Productor','Productor',1),(330,327,'Productor','Productor',1),(331,328,'Productor','Productor',1),(332,329,'Productor','Productor',1),(333,330,'Productor','Productor',1),(334,331,'Productor','Productor',1),(335,332,'Productor','Productor',1),(336,333,'Productor','Productor',1),(337,334,'Productor','Productor',1),(338,335,'Productor','Productor',1),(339,336,'Productor','Productor',1),(340,337,'Productor','Productor',1),(341,338,'Productor','Productor',1),(342,339,'Productor','Productor',1),(343,340,'Productor','Productor',1),(344,341,'Productor','Productor',1),(345,342,'Productor','Productor',1),(346,343,'Productor','Productor',1),(347,344,'Productor','Productor',1),(348,345,'Productor','Productor',1),(349,346,'Productor','Productor',1),(350,347,'Productor','Productor',1),(351,348,'Productor','Productor',1),(352,349,'Productor','Productor',1),(353,350,'Productor','Productor',1),(354,350,'Capturista Recepcion','Capturista de Recepción',1),(355,351,'Productor','Productor',1),(356,352,'Productor','Productor',1),(357,353,'Productor','Productor',1),(358,354,'Productor','Productor',1),(359,355,'Productor','Productor',1),(360,356,'Productor','Productor',1),(361,357,'Productor','Productor',1),(362,358,'Productor','Productor',1),(363,359,'Productor','Productor',1),(364,360,'Productor','Productor',1),(365,361,'Productor','Productor',1),(366,362,'Productor','Productor',1),(367,363,'Productor','Productor',1),(368,304,'Productor','Productor',1),(369,364,'Productor','Productor',1),(370,365,'Productor','Productor',1),(371,366,'Productor','Productor',1),(372,367,'Productor','Productor',1),(373,368,'Productor','Productor',1),(374,369,'Productor','Productor',1),(375,370,'Productor','Productor',1),(376,371,'Productor','Productor',1),(377,372,'Productor','Productor',1),(378,373,'Productor','Productor',1),(379,374,'Productor','Productor',1),(380,375,'Productor','Productor',1),(381,376,'Productor','Productor',1),(382,377,'Productor','Productor',1),(383,378,'Productor','Productor',1),(384,379,'Productor','Productor',1),(385,380,'Productor','Productor',1),(386,381,'Productor','Productor',1),(387,382,'Productor','Productor',1),(388,386,'Productor','Productor',1),(389,387,'Productor','Productor',1),(390,388,'Productor','Productor',1),(391,389,'Productor','Productor',1),(392,390,'Productor','Productor',1),(393,391,'Productor','Productor',1),(394,392,'Productor','Productor',1),(395,393,'Productor','Productor',1),(396,394,'Productor','Productor',1),(397,395,'Productor','Productor',1),(398,371,'Encargado Beneficio','Encargado de Beneficio Húmedo',1),(399,349,'Encargado Recepcion','Encargado de Recepción',1),(400,350,'Capturista Beneficio','Capturista de Beneficio Húmedo',1),(401,396,'Productor','Productor',1),(402,397,'Productor','Productor',1),(403,61,'Encargado Recepcion','Encargado de Recepción',1),(404,398,'Productor','Productor',1);
/*!40000 ALTER TABLE `asignacionespersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atributospersona`
--

DROP TABLE IF EXISTS `atributospersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atributospersona` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributospersona`
--

LOCK TABLES `atributospersona` WRITE;
/*!40000 ALTER TABLE `atributospersona` DISABLE KEYS */;
/*!40000 ALTER TABLE `atributospersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beneficioshumedos`
--

DROP TABLE IF EXISTS `beneficioshumedos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beneficioshumedos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPersonaCapturista` int(11) NOT NULL,
  `idPersonaEncargada` int(11) NOT NULL,
  `idSociedad` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `nombrecorto` varchar(55) NOT NULL,
  `domicilio` varchar(150) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `localizacion` varchar(100) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `idLocalidad` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficioshumedos`
--

LOCK TABLES `beneficioshumedos` WRITE;
/*!40000 ALTER TABLE `beneficioshumedos` DISABLE KEYS */;
INSERT INTO `beneficioshumedos` VALUES (1,563,76,1,'BH-AS-1','','Patios Jacinto (Conocido S/N)','0','0','',17,1),(2,718,563,1,'BH-AS-2','','Patios Agustina (Conocido S/N)','0','0','',17,1),(3,714,142,2,'BH-AD-3','','Basilio/Sandia (Conocido S/N)','0','0','',23,1),(4,24,10,4,'BH-CS-4','','CSM/Sandia (Conocido S/N)','0','0','',23,1),(5,716,26,3,'BH-CT-5','','Patios Paulino (Conocido S/N)','0','0','',4,1),(6,716,26,3,'BH-CT-6','','Piña (Conocido S/N)','0','0','',4,1),(7,448,448,4,'BH-CS-7','','Arrocerra (bravo # 23)','3272770921','0','',1,1),(8,448,448,4,'BH-CS-8','','Duende (Carretera Vallarta - Chapalilla S/N)','3272774827','0','',1,1),(9,24,251,5,'BH-CC-9','','Pantano (Conocido S/N)','0','0','',22,1),(10,191,201,6,'BH-C-10','','Guajolote (Conocido S/N)','0','0','',9,1),(11,191,211,6,'BH-C-11','','Sombrero (Conocido S/N)','0','0','',9,1),(12,191,195,6,'BH-C-12','','Banco Colorado (Conocido S/N)','0','0','',9,1),(13,191,194,6,'BH-C-13','','Tempizque (Conocido S/N)','0','0','',9,1),(14,191,198,6,'BH-C-14','','Banco Colorado 2 (Conocido S/N)','0','0','',9,1),(15,350,371,7,'BH-AI-15','Beneficio Rustico','Rustico (Conocido S/N)','0','0','',23,1),(16,0,0,8,'BH-AG-16','','Pa-Techos_Riviera (Conocido S/N)','0','0','',23,2),(17,714,6,8,'BH-AG-17','','Pa-Techos_Ricardo (Conocido S/N)','0','0','',23,1),(18,712,84,1,'BH-AS-18','Beneficio Israel','Patio Israel (Conocido S/N)','0','0','',17,1);
/*!40000 ALTER TABLE `beneficioshumedos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacoralab`
--

DROP TABLE IF EXISTS `bitacoralab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacoralab` (
  `id_bitacora` int(11) NOT NULL AUTO_INCREMENT,
  `id_muestra` int(11) DEFAULT NULL,
  `fecha_llegada` varchar(50) DEFAULT NULL,
  `tipocafe` varchar(50) DEFAULT NULL,
  `forma` varchar(50) DEFAULT NULL,
  `beneficio` varchar(50) DEFAULT NULL,
  `dueño` varchar(50) DEFAULT NULL,
  `lote` int(10) DEFAULT NULL,
  `peso` varchar(100) DEFAULT NULL,
  `sacos` varchar(100) DEFAULT NULL,
  `comunidad` varchar(50) DEFAULT NULL,
  `estatus` varchar(50) DEFAULT NULL,
  `observaciones` varchar(250) DEFAULT NULL,
  `taza` varchar(10) DEFAULT NULL,
  `aspecto` varchar(10) DEFAULT NULL,
  `Metodosecado` varchar(45) DEFAULT NULL,
  `calidadcereza` varchar(45) DEFAULT NULL,
  `pesomuestra` varchar(45) DEFAULT NULL,
  `ubicacioncafe` varchar(45) DEFAULT NULL,
  `nomlote` varchar(45) DEFAULT NULL,
  `predio` varchar(45) DEFAULT NULL,
  `productor` varchar(45) DEFAULT NULL,
  `fechalote` varchar(45) DEFAULT NULL,
  `terminosecado` varchar(45) DEFAULT NULL,
  `tomademuestra` varchar(45) DEFAULT NULL,
  `fechacosecha` varchar(45) DEFAULT NULL,
  `tomadapor` varchar(45) DEFAULT NULL,
  `recibidapor` varchar(45) DEFAULT NULL,
  `transportadapor` varchar(45) DEFAULT NULL,
  `certificado` varchar(45) DEFAULT NULL,
  `sabores` varchar(250) DEFAULT NULL,
  `mezcla` varchar(45) DEFAULT NULL,
  `mezasig` varchar(10) DEFAULT NULL,
  `idlote` varchar(45) DEFAULT NULL,
  `Kgconfirm` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_bitacora`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoralab`
--

LOCK TABLES `bitacoralab` WRITE;
/*!40000 ALTER TABLE `bitacoralab` DISABLE KEYS */;
INSERT INTO `bitacoralab` VALUES (11,1,'18-ago-2019','L','C','BH-C1-2','Astal',15,'1550','20','El CuarenteÃ±o','L',NULL,'0','0','al sol','Azul','15','AL-GT-4','SubLote','la magnolia','Maria NuÃ±ez Jimenez','09-ago-2019','09-ago-2019','16-ago-2019','15-ago-2019','Re-Sandia/Edwin','Re-Sandia/Edwin','adasd','AA',NULL,NULL,'0','','1'),(12,2,'14-ago-2019','N','C','BH-C1-2','Riviera',13,'5000','100','El CuarenteÃ±o','A',NULL,'0','1','al sol','Azul','500','','SubLote','','Maria NuÃ±ez Jimenez','02-ago-2019','02-ago-2019','01-ago-2019','15-ago-2019','','','','AC',NULL,NULL,'0','','0'),(13,3,'03-ago-2019','L','P','BH-R1-3','Astal',12,'12000','20','Colorado De La Mora','Disp',NULL,'1','1','Guardiolas','Azul','5','Conocido S/N','SubLote','','','03-ago-2019','null','null','null','Re-Sandia/Edwin','Re-CSM/Carlos','','AB','Dry:Raspberry,Blueberry,Strawberry;Wet:Blackberry,Raspberry,Blueberry;Break:Raspberry,Blueberry,Strawberry;Flavor:Brown Sugar,Carmelized,Vanilla;Aftertaste=Brown Sugar,Maple Sugar,Honey;Acidity:Rancid butter(Butyric Acid);Body:Heavy;',NULL,'0','','1'),(14,4,'02-ago-2019','N','C','BH-B1-1','Riviera',18,'20000','60','Cora De Abajo','Asignada',NULL,'1','1','camas africanas','Azul','300','Conocido S/N','SubLote','','','02-ago-2019','null','null','null','','','','AB','Dry:Brown Sugar,Molasses,Carmelized;Wet:Brown Sugar,Molasses,Carmelized;Break:Molasses,Carmelized;Flavor:Almond,Chocolate,Dark Chocolate;Aftertaste=Almond,Chocolate,Dark Chocolate,finish:Short;Acidity:Rancid Cheese(Isovaleric Acid);Body:Heavy;','AA','1','','1'),(15,5,'10-jul-2019','N','C','BH-B1-1','Riviera',20,'5655','32','El CuarenteÃ±o','Desactivada',NULL,'0','0','al sol','Azul','3255','AL-Naranja','SubLote','','','09-ago-2018','null','null','null','','','','AC',NULL,NULL,'0','','1'),(16,6,'30-ago-2019','T','C','BH-C1-2','Astal',1,'1000','6','El CuarenteÃ±o','L',NULL,'0','0','Guardiolas','Azul','3','AL-GT-4','','','','09-ago-2019','09-ago-2019','09-ago-2019','09-ago-2019','asd','asd','asd','AA',NULL,NULL,'0','','0'),(19,7,'29-ago-2019','T','C','BH-C1-2','Astal',1,'1000','6','El CuarenteÃ±o','L',NULL,'0','0','Guardiolas','Azul','3','AL-GT-4','','','','09-ago-2019','09-ago-2019','09-ago-2019','09-ago-2019','asd','asd','asd','AA',NULL,NULL,'0','1','1'),(20,8,'03-sep-2019','T','C','BH-C1-2','Astal',2,'2000','12','El CuarenteÃ±o','L',NULL,'0','0','Guardiolas','Azul','3','AL-GT-4','','','','09-ago-2019','09-ago-2019','09-ago-2019','09-ago-2019','asd','asd','asd','AA',NULL,NULL,'0','2','1');
/*!40000 ALTER TABLE `bitacoralab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletaentradabh`
--

DROP TABLE IF EXISTS `boletaentradabh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletaentradabh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idBeneficio` varchar(35) NOT NULL,
  `idBoleta` varchar(25) NOT NULL,
  `idLote` varchar(25) NOT NULL,
  `idBoletaManual` varchar(25) NOT NULL,
  `fechaBoletaManual` varchar(25) NOT NULL,
  `fechaEntrada` varchar(25) NOT NULL,
  `kgRecibidos` varchar(25) NOT NULL,
  `costalesRecibidos` varchar(25) NOT NULL,
  `estadoCafe` varchar(25) NOT NULL,
  `estatus` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletaentradabh`
--

LOCK TABLES `boletaentradabh` WRITE;
/*!40000 ALTER TABLE `boletaentradabh` DISABLE KEYS */;
INSERT INTO `boletaentradabh` VALUES (1,'BH-AI-15','BOL-AI-0-0-1','AI14-21025-AB-1','','','2021-04-26','319.0','11','Fresco','1'),(2,'BH-AI-15','BOL-AI-0-0-1','AI14-21025-AB-1','','','2021-04-26','319.0','11','Seco','1'),(3,'BH-AI-15','BOL-AI-0-0-2','AI14-21026-AB-1','','','2021-04-26','151.0','7','Humedo','1'),(4,'BH-AI-15','BOL-AI-0-0-2','AI14-21026-AC-1','','','2021-04-26','57.0','2','Humedo','1');
/*!40000 ALTER TABLE `boletaentradabh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletasalidareceptor`
--

DROP TABLE IF EXISTS `boletasalidareceptor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletasalidareceptor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idRecepcion` varchar(35) NOT NULL,
  `idSociedad` int(11) NOT NULL,
  `idBoleta` varchar(25) NOT NULL,
  `idLote` varchar(25) NOT NULL,
  `idBoletaManual` varchar(25) DEFAULT NULL,
  `idTransporte` int(11) NOT NULL,
  `fecha` varchar(25) NOT NULL,
  `horaActual` varchar(20) NOT NULL,
  `fechaBoletaManual` varchar(25) NOT NULL,
  `horaBoletaManual` varchar(35) NOT NULL,
  `totalSacos` varchar(25) NOT NULL,
  `totalKg` varchar(25) NOT NULL,
  `origen` varchar(100) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `tipoLugar` varchar(2) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `transporteLimpio` tinyint(1) NOT NULL,
  `sacosEnviados` varchar(25) NOT NULL,
  `kilosEnviados` varchar(25) NOT NULL,
  `estatus` varchar(50) NOT NULL,
  `boletamultiple` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletasalidareceptor`
--

LOCK TABLES `boletasalidareceptor` WRITE;
/*!40000 ALTER TABLE `boletasalidareceptor` DISABLE KEYS */;
INSERT INTO `boletasalidareceptor` VALUES (1,'RE-AS-18',1,'BOL-AS-0-0-1','AS18-22010-AB-2','',6,'2022-01-10','19:03:15','','','5','213.0','RE-AS-18','BH-AS-18','B','',1,'5','213','1',0),(2,'RE-AS-18',1,'BOL-AS-0-0-2','AS18-22011-AB-2','',6,'2022-01-11','18:17:13','','','9','373.0','RE-AS-18','BH-AS-18','B','',1,'8','349','1',0),(3,'RE-AS-18',1,'BOL-AS-0-0-2','AS18-22011-AD-2','',6,'2022-01-11','18:17:13','','','9','373.0','RE-AS-18','BH-AS-18','B','',1,'1','24','1',0),(4,'RE-AS-18',1,'BOL-AS-0-0-3','AS18-22013-AB-2','',6,'2022-01-13','17:51:16','','','8','324.0','RE-AS-18','BH-AS-18','B','',1,'6','262','1',0),(5,'RE-AS-18',1,'BOL-AS-0-0-3','AS18-22013-AD-2','',6,'2022-01-13','17:51:16','','','8','324.0','RE-AS-18','BH-AS-18','B','',1,'2','62','1',0),(6,'RE-AS-18',1,'BOL-AS-0-0-4','AS18-22014-AD-3','',6,'2022-01-14','17:46:26','','','11','384.0','RE-AS-18','BH-AS-18','B','',1,'5','163','1',0),(7,'RE-AS-18',1,'BOL-AS-0-0-4','AS18-22014-AD-2','',6,'2022-01-14','17:46:26','','','11','384.0','RE-AS-18','BH-AS-18','B','',1,'2','69','1',0),(8,'RE-AS-18',1,'BOL-AS-0-0-4','AS18-22014-AB-3','',6,'2022-01-14','17:46:26','','','11','384.0','RE-AS-18','BH-AS-18','B','',1,'4','152','1',0),(9,'RE-AS-18',1,'BOL-AS-0-0-5','AS18-22015-AD-3','',6,'2022-01-15','17:06:39','','','18','670.0','RE-AS-18','BH-AS-18','B','',1,'10','325','1',0),(10,'RE-AS-18',1,'BOL-AS-0-0-5','AS18-22015-AB-3','',6,'2022-01-15','17:06:39','','','18','670.0','RE-AS-18','BH-AS-18','B','',1,'8','345','1',0),(11,'RE-AS-18',1,'BOL-AS-0-0-6','AS18-22017-AD-3','',6,'2022-01-17','17:55:17','','','28','930.0','RE-AS-18','BH-AS-18','B','',1,'9','334','1',0),(12,'RE-AS-18',1,'BOL-AS-0-0-6','AS18-22017-AB-3','',6,'2022-01-17','17:55:17','','','28','930.0','RE-AS-18','BH-AS-18','B','',1,'11','365','1',0),(13,'RE-AS-18',1,'BOL-AS-0-0-6','AS18-22017-AD-2','',6,'2022-01-17','17:55:17','','','28','930.0','RE-AS-18','BH-AS-18','B','',1,'8','231','1',0),(14,'RE-AS-18',1,'BOL-AS-0-0-7','AS18-22018-AD-2','',6,'2022-01-18','18:15:39','','','29','1097.0','RE-AS-18','BH-AS-18','B','',1,'10','402','1',0),(15,'RE-AS-18',1,'BOL-AS-0-0-7','AS18-22018-AB-2','',6,'2022-01-18','18:15:39','','','29','1097.0','RE-AS-18','BH-AS-18','B','',1,'7','240','1',0),(16,'RE-AS-18',1,'BOL-AS-0-0-7','AS18-22018-AB-3','',6,'2022-01-18','18:15:39','','','29','1097.0','RE-AS-18','BH-AS-18','B','',1,'6','205','1',0),(17,'RE-AS-18',1,'BOL-AS-0-0-7','AS18-22018-AD-3','',6,'2022-01-18','18:15:39','','','29','1097.0','RE-AS-18','BH-AS-18','B','',1,'6','250','1',0),(18,'RE-AS-18',1,'BOL-AS-0-0-8','AS18-22019-AB-2','',6,'2022-01-19','19:14:35','','','34','1294.0','RE-AS-18','BH-AS-18','B','',1,'11','441','1',0),(19,'RE-AS-18',1,'BOL-AS-0-0-8','AS18-22019-AB-3','',6,'2022-01-19','19:14:35','','','34','1294.0','RE-AS-18','BH-AS-18','B','',1,'7','235','1',0),(20,'RE-AS-18',1,'BOL-AS-0-0-8','AS18-22019-AD-3','',6,'2022-01-19','19:14:35','','','34','1294.0','RE-AS-18','BH-AS-18','B','',1,'10','368','1',0),(21,'RE-AS-18',1,'BOL-AS-0-0-8','AS18-22019-AD-2','',6,'2022-01-19','19:14:35','','','34','1294.0','RE-AS-18','BH-AS-18','B','',1,'6','250','1',0),(22,'RE-AS-18',1,'BOL-AS-0-0-9','AS18-22020-AB-3','',6,'2022-01-20','18:26:31','','','34','1222.0','RE-AS-18','BH-AS-18','B','',1,'5','197','1',0),(23,'RE-AS-18',1,'BOL-AS-0-0-9','AS18-22020-AD-3','',6,'2022-01-20','18:26:31','','','34','1222.0','RE-AS-18','BH-AS-18','B','',1,'6','208','1',0),(24,'RE-AS-18',1,'BOL-AS-0-0-9','AS18-22020-AD-2','',6,'2022-01-20','18:26:31','','','34','1222.0','RE-AS-18','BH-AS-18','B','',1,'8','280','1',0),(25,'RE-AS-18',1,'BOL-AS-0-0-9','AS18-22020-AB-2','',6,'2022-01-20','18:26:31','','','34','1222.0','RE-AS-18','BH-AS-18','B','',1,'15','537','1',0),(26,'RE-AS-18',1,'BOL-AS-0-0-10','AS18-22021-AD-2','',6,'2022-01-21','17:52:40','','','23','864.0','RE-AS-18','BH-AS-18','B','',1,'6','261','1',0),(27,'RE-AS-18',1,'BOL-AS-0-0-10','AS18-22021-AB-2','',6,'2022-01-21','17:52:40','','','23','864.0','RE-AS-18','BH-AS-18','B','',1,'17','603','1',0),(28,'RE-AS-18',1,'BOL-AS-0-0-11','AS18-22022-AD-2','',6,'2022-01-22','17:37:33','','','13','469.0','RE-AS-18','BH-AS-18','B','',1,'6','212','1',0),(29,'RE-AS-18',1,'BOL-AS-0-0-11','AS18-22022-AB-2','',6,'2022-01-22','17:37:33','','','13','469.0','RE-AS-18','BH-AS-18','B','',1,'7','257','1',0),(30,'RE-AS-18',1,'BOL-AS-0-0-12','AS18-22024-AB-2','',6,'2022-01-24','18:04:27','','','26','977.0','RE-AS-18','BH-AS-18','B','',1,'10','375','1',0),(31,'RE-AS-18',1,'BOL-AS-0-0-12','AS18-22024-AD-2','',6,'2022-01-24','18:04:27','','','26','977.0','RE-AS-18','BH-AS-18','B','',1,'8','316','1',0),(32,'RE-AS-18',1,'BOL-AS-0-0-12','AS18-22024-AB-3','',6,'2022-01-24','18:04:27','','','26','977.0','RE-AS-18','BH-AS-18','B','',1,'8','286','1',0),(33,'RE-AS-18',1,'BOL-AS-0-0-13','AS18-22025-AD-3','',6,'2022-01-25','18:23:34','','','59','2244.0','RE-AS-18','BH-AS-18','B','',1,'1','42','1',0),(34,'RE-AS-18',1,'BOL-AS-0-0-13','AS18-22025-AD-2','',6,'2022-01-25','18:23:34','','','59','2244.0','RE-AS-18','BH-AS-18','B','',1,'22','846','1',0),(35,'RE-AS-18',1,'BOL-AS-0-0-13','AS18-22025-AB-2','',6,'2022-01-25','18:23:34','','','59','2244.0','RE-AS-18','BH-AS-18','B','',1,'27','1039','1',0),(36,'RE-AS-18',1,'BOL-AS-0-0-13','AS18-22025-AB-1','',6,'2022-01-25','18:23:34','','','59','2244.0','RE-AS-18','BH-AS-18','B','',1,'9','317','1',0),(37,'RE-AS-18',1,'BOL-AS-0-0-14','AS18-22026-AB-3','',6,'2022-01-26','18:45:13','','','53','2053.0','RE-AS-18','BH-AS-18','B','',1,'10','365','1',0),(38,'RE-AS-18',1,'BOL-AS-0-0-14','AS18-22026-AB-2','',6,'2022-01-26','18:45:13','','','53','2053.0','RE-AS-18','BH-AS-18','B','',1,'16','629','1',0),(39,'RE-AS-18',1,'BOL-AS-0-0-14','AS18-22026-AD-2','',6,'2022-01-26','18:45:13','','','53','2053.0','RE-AS-18','BH-AS-18','B','',1,'9','361','1',0),(40,'RE-AS-18',1,'BOL-AS-0-0-14','AS18-22026-AB-1','',6,'2022-01-26','18:45:13','','','53','2053.0','RE-AS-18','BH-AS-18','B','',1,'5','217','1',0),(41,'RE-AS-18',1,'BOL-AS-0-0-14','AS18-22026-AD-1','',6,'2022-01-26','18:45:13','','','53','2053.0','RE-AS-18','BH-AS-18','B','',1,'13','481','1',0),(42,'RE-AS-18',1,'BOL-AS-0-0-15','AS18-22027-AD-1','',6,'2022-01-27','18:44:36','','','51','1943.0','RE-AS-18','BH-AS-18','B','',1,'10','408','1',0),(43,'RE-AS-18',1,'BOL-AS-0-0-15','AS18-22027-AB-2','',6,'2022-01-27','18:44:36','','','51','1943.0','RE-AS-18','BH-AS-18','B','',1,'27','987','1',0),(44,'RE-AS-18',1,'BOL-AS-0-0-15','AS18-22027-AD-2','',6,'2022-01-27','18:44:36','','','51','1943.0','RE-AS-18','BH-AS-18','B','',1,'5','227','1',0),(45,'RE-AS-18',1,'BOL-AS-0-0-15','AS18-22027-AB-1','',6,'2022-01-27','18:44:36','','','51','1943.0','RE-AS-18','BH-AS-18','B','',1,'9','321','1',0),(46,'RE-AS-18',1,'BOL-AS-0-0-16','AS18-22028-AD-2','',6,'2022-01-28','19:14:10','','','37','1187.0','RE-AS-18','BH-AS-18','B','',1,'8','311','1',0),(47,'RE-AS-18',1,'BOL-AS-0-0-16','AS18-22028-AB-2','',6,'2022-01-28','19:14:10','','','37','1187.0','RE-AS-18','BH-AS-18','B','',1,'9','324','1',0),(48,'RE-AS-18',1,'BOL-AS-0-0-16','AS18-22028-AD-1','',6,'2022-01-28','19:14:10','','','37','1187.0','RE-AS-18','BH-AS-18','B','',1,'3','77','1',0),(49,'RE-AS-18',1,'BOL-AS-0-0-16','AS18-22028-AB-1','',6,'2022-01-28','19:14:10','','','37','1187.0','RE-AS-18','BH-AS-18','B','',1,'11','340','1',0),(50,'RE-AS-18',1,'BOL-AS-0-0-16','AS18-22028-AD-3','',6,'2022-01-28','19:14:10','','','37','1187.0','RE-AS-18','BH-AS-18','B','',1,'6','135','1',0),(51,'RE-AS-18',1,'BOL-AS-0-0-17','AS18-22029-AB-2','',6,'2022-01-29','17:29:36','','','29','1066.0','RE-AS-18','BH-AS-18','B','',1,'5','178','1',0),(52,'RE-AS-18',1,'BOL-AS-0-0-17','AS18-22029-AD-2','',6,'2022-01-29','17:29:36','','','29','1066.0','RE-AS-18','BH-AS-18','B','',1,'7','257','1',0),(53,'RE-AS-18',1,'BOL-AS-0-0-17','AS18-22029-AD-1','',6,'2022-01-29','17:29:36','','','29','1066.0','RE-AS-18','BH-AS-18','B','',1,'12','417','1',0),(54,'RE-AS-18',1,'BOL-AS-0-0-17','AS18-22029-AB-1','',6,'2022-01-29','17:29:36','','','29','1066.0','RE-AS-18','BH-AS-18','B','',1,'5','214','1',0),(55,'RE-AS-18',1,'BOL-AS-0-0-18','AS18-22031-AD-1','',6,'2022-01-31','18:16:36','','','49','1742.0','RE-AS-18','BH-AS-18','B','',1,'17','637','1',0),(56,'RE-AS-18',1,'BOL-AS-0-0-18','AS18-22031-AB-1','',6,'2022-01-31','18:16:36','','','49','1742.0','RE-AS-18','BH-AS-18','B','',1,'26','869','1',0),(57,'RE-AS-18',1,'BOL-AS-0-0-18','AS18-22031-AB-3','',6,'2022-01-31','18:16:36','','','49','1742.0','RE-AS-18','BH-AS-18','B','',1,'3','100','1',0),(58,'RE-AS-18',1,'BOL-AS-0-0-18','AS18-22031-AD-2','',6,'2022-01-31','18:16:36','','','49','1742.0','RE-AS-18','BH-AS-18','B','',1,'3','136','1',0);
/*!40000 ALTER TABLE `boletasalidareceptor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calidadcereza`
--

DROP TABLE IF EXISTS `calidadcereza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calidadcereza` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Clave` int(2) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Minima` float NOT NULL,
  `Maxima` float NOT NULL,
  `Rango` float NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calidadcereza`
--

LOCK TABLES `calidadcereza` WRITE;
/*!40000 ALTER TABLE `calidadcereza` DISABLE KEYS */;
INSERT INTO `calidadcereza` VALUES (1,1,'Azul',80,100,1,1,1,'2019-08-14','11:40:37','','',1,1),(2,2,'Amarillo',50.99,79.99,1,1,1,'2019-08-14','11:40:57','','',1,1),(3,3,'Rosa',0.98,50.98,1,1,1,'2019-08-14','11:41:15','','',1,1);
/*!40000 ALTER TABLE `calidadcereza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calidadseco`
--

DROP TABLE IF EXISTS `calidadseco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calidadseco` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Clave` varchar(2) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Maxima` float NOT NULL,
  `Minima` float NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calidadseco`
--

LOCK TABLES `calidadseco` WRITE;
/*!40000 ALTER TABLE `calidadseco` DISABLE KEYS */;
/*!40000 ALTER TABLE `calidadseco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calidadsombra`
--

DROP TABLE IF EXISTS `calidadsombra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calidadsombra` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_TipoSombra` int(10) unsigned NOT NULL,
  `Estrellas` int(2) unsigned NOT NULL,
  `AlturaSombraMetros` int(3) unsigned NOT NULL,
  `Cobertura` int(3) unsigned NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calidadsombra`
--

LOCK TABLES `calidadsombra` WRITE;
/*!40000 ALTER TABLE `calidadsombra` DISABLE KEYS */;
INSERT INTO `calidadsombra` VALUES (1,1,1,5,25,1,1,'2019-08-13','15:01:56','','',1,1),(2,3,2,8,40,1,1,'2019-08-13','15:04:16','','',1,1),(3,2,3,15,80,1,1,'2019-08-13','15:04:37','','',1,1),(4,4,4,30,90,1,1,'2019-08-13','15:04:57','','',1,1);
/*!40000 ALTER TABLE `calidadsombra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargosenmoral`
--

DROP TABLE IF EXISTS `cargosenmoral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargosenmoral` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(50) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargosenmoral`
--

LOCK TABLES `cargosenmoral` WRITE;
/*!40000 ALTER TABLE `cargosenmoral` DISABLE KEYS */;
/*!40000 ALTER TABLE `cargosenmoral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catacion`
--

DROP TABLE IF EXISTS `catacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catacion` (
  `id_catacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_bitacora` int(11) DEFAULT NULL,
  `niveltostado` int(11) DEFAULT NULL,
  `uniformidadtostado` int(11) DEFAULT NULL,
  `quakers` int(11) DEFAULT NULL,
  `Puntuacion` varchar(30) DEFAULT NULL,
  `numerotazas` int(11) DEFAULT NULL,
  `defectos` int(11) DEFAULT NULL,
  `numtazasdefect` int(11) DEFAULT NULL,
  `intensidaddef` int(11) DEFAULT NULL,
  `uniformidadtaza` int(11) DEFAULT NULL,
  `tazalimpia` int(11) DEFAULT NULL,
  `dulzor` int(11) DEFAULT NULL,
  `dry` varchar(30) DEFAULT NULL,
  `wet` varchar(30) DEFAULT NULL,
  `break` varchar(30) DEFAULT NULL,
  `fragance` varchar(30) DEFAULT NULL,
  `flavor` varchar(30) DEFAULT NULL,
  `aftertaste` varchar(30) DEFAULT NULL,
  `acidity` varchar(30) DEFAULT NULL,
  `intensidadacidit` varchar(30) DEFAULT NULL,
  `body` varchar(30) DEFAULT NULL,
  `intensidadbody` varchar(30) DEFAULT NULL,
  `balance` varchar(30) DEFAULT NULL,
  `catador` varchar(30) DEFAULT NULL,
  `catadornom` varchar(45) DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `densidadtostado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_catacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catacion`
--

LOCK TABLES `catacion` WRITE;
/*!40000 ALTER TABLE `catacion` DISABLE KEYS */;
INSERT INTO `catacion` VALUES (3,13,5,5,10,'84',3,1,1,1,3,2,3,'9.0','8.5','9.0','8.8','8.5','8.0','8.0','3','8.0','3','8.5','8.5','Consenso','19-ago-2019',NULL),(4,14,5,5,3,'80.5',3,0,0,0,3,2,3,'8.0','8.5','8.5','8.3','7.5','7.5','7.5','3','7.5','3','8.0','7.5','Consenso','19-ago-2019',NULL);
/*!40000 ALTER TABLE `catacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalogos`
--

DROP TABLE IF EXISTS `catalogos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalogos` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogos`
--

LOCK TABLES `catalogos` WRITE;
/*!40000 ALTER TABLE `catalogos` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoriadearchivos`
--

DROP TABLE IF EXISTS `categoriadearchivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoriadearchivos` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `Productores` bit(1) NOT NULL,
  `Parcelas` bit(1) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriadearchivos`
--

LOCK TABLES `categoriadearchivos` WRITE;
/*!40000 ALTER TABLE `categoriadearchivos` DISABLE KEYS */;
INSERT INTO `categoriadearchivos` VALUES (1,'Certificado Parcelario','','',1,1,'2020-10-08','15:24:21','','',1,1);
/*!40000 ALTER TABLE `categoriadearchivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificado`
--

DROP TABLE IF EXISTS `certificado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificado` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Clave` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificado`
--

LOCK TABLES `certificado` WRITE;
/*!40000 ALTER TABLE `certificado` DISABLE KEYS */;
INSERT INTO `certificado` VALUES (1,'AA','Sin certificado',1,1,'2019-08-12','10:11:53','','',1,1),(2,'UO','Usda Organic',1,1,'2019-08-13','15:06:53','','',1,1),(3,'CS','Cas Cuatroc',1,1,'2019-08-16','12:13:48','','',1,1),(4,'UC','Utz Certified',1,1,'2019-08-16','12:48:04','','',1,1),(5,'CM','Café De Mujeres',1,1,'2019-08-16','12:48:30','','',1,1),(6,'SM','Sagarpa México',1,1,'2019-08-16','12:48:50','','',1,1),(7,'EU','EU Organic',1,1,'2019-08-16','12:49:12','','',1,1),(8,'CC','Calidad Certificada',1,1,'2019-08-16','12:49:24','','',1,1);
/*!40000 ALTER TABLE `certificado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificadocerficadora`
--

DROP TABLE IF EXISTS `certificadocerficadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificadocerficadora` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Certificado` int(10) unsigned NOT NULL,
  `Certificadora` int(10) unsigned NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificadocerficadora`
--

LOCK TABLES `certificadocerficadora` WRITE;
/*!40000 ALTER TABLE `certificadocerficadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificadocerficadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificadora`
--

DROP TABLE IF EXISTS `certificadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificadora` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Clave` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificadora`
--

LOCK TABLES `certificadora` WRITE;
/*!40000 ALTER TABLE `certificadora` DISABLE KEYS */;
INSERT INTO `certificadora` VALUES (1,'AA','Sin certificadora',1,1,'2019-08-12','10:12:18','','',1,1),(2,'CS','Cafesumex',1,1,'2019-08-12','10:15:16','','',1,1),(3,'MA','Mayacert',1,1,'2019-08-12','10:15:38','','',1,1),(4,'BI','Bioagricert',1,1,'2019-08-16','12:52:08','','',1,1),(5,'ME','Metrocert',1,1,'2019-08-16','12:52:25','','',1,1),(6,'BL','Biolatina',1,1,'2019-08-16','12:52:37','','',1,1),(7,'CT','Certimex',1,1,'2019-08-16','12:52:49','','',1,1);
/*!40000 ALTER TABLE `certificadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificadosparcelas`
--

DROP TABLE IF EXISTS `certificadosparcelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificadosparcelas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_parcela` int(11) NOT NULL,
  `id_certificado` int(11) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificadosparcelas`
--

LOCK TABLES `certificadosparcelas` WRITE;
/*!40000 ALTER TABLE `certificadosparcelas` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificadosparcelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clima`
--

DROP TABLE IF EXISTS `clima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clima` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Clave` varchar(45) NOT NULL,
  `Clima` varchar(85) DEFAULT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `HoraCreacion` time(6) NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clima`
--

LOCK TABLES `clima` WRITE;
/*!40000 ALTER TABLE `clima` DISABLE KEYS */;
/*!40000 ALTER TABLE `clima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigo_relacion`
--

DROP TABLE IF EXISTS `codigo_relacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codigo_relacion` (
  `codigo` varchar(5) NOT NULL,
  `certificado` varchar(50) DEFAULT NULL,
  `certificadora` varchar(50) DEFAULT NULL,
  `alcance` varchar(150) DEFAULT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigo_relacion`
--

LOCK TABLES `codigo_relacion` WRITE;
/*!40000 ALTER TABLE `codigo_relacion` DISABLE KEYS */;
INSERT INTO `codigo_relacion` VALUES ('AD','Cadé De Mujeres','Cafesumex','Lop-mex',1,1,'2019-08-16','14:24:03','','',1,1),('AE','Sin certificado','Mayacert','Nop - Usda',1,1,'2019-08-16','14:31:44','','',1,1),('AF','Sin certificado','Mayacert','Nop - Usda',1,1,'2019-08-16','14:32:09','','',1,1),('AG','Sin certificado','Mayacert','Nop - Usda',1,1,'2019-08-16','14:32:21','','',1,1),('AA','Sin Certificacion','Sin Certificador','Lop-mex',1,1,'2020-02-29','09:21:19','','',1,1),('AA','Sin certificado','Sin certificadora','Lop-mex',1,1,'2020-02-29','09:21:19','','',1,1),('AC','Usda Organic','Mayacert','Nop - Usda',1,1,'2020-02-29','09:21:59','','',1,1),('AB','Sin Certificacion','Sin Certificador','Lop-mex',1,1,'2020-02-29','09:22:28','','',1,1),('AB','Sin certificado','Sin certificadora','Nop - Usda',1,1,'2020-02-29','09:22:28','','',1,1);
/*!40000 ALTER TABLE `codigo_relacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigos_certificacion`
--

DROP TABLE IF EXISTS `codigos_certificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codigos_certificacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(5) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigos_certificacion`
--

LOCK TABLES `codigos_certificacion` WRITE;
/*!40000 ALTER TABLE `codigos_certificacion` DISABLE KEYS */;
INSERT INTO `codigos_certificacion` VALUES (1,'AA','Sin Certificacion',1,1,'2019-08-16','14:18:31','','',1,1),(2,'AB','Convencional',1,1,'2019-08-16','14:20:08','','',1,1),(3,'AC','Organico',1,1,'2019-08-16','14:20:54','','',1,1),(4,'AD','cafe mujeres',1,1,'2019-08-16','14:23:37','','',1,1),(5,'AE','Transicion 1',1,1,'2019-08-16','14:31:42','','',1,1),(6,'AF','Transicion 2',1,1,'2019-08-16','14:32:06','','',1,1),(7,'AG','Transicion 3',1,1,'2019-08-16','14:32:20','','',1,1);
/*!40000 ALTER TABLE `codigos_certificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controlmaleza`
--

DROP TABLE IF EXISTS `controlmaleza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controlmaleza` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controlmaleza`
--

LOCK TABLES `controlmaleza` WRITE;
/*!40000 ALTER TABLE `controlmaleza` DISABLE KEYS */;
/*!40000 ALTER TABLE `controlmaleza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cortesdeldia`
--

DROP TABLE IF EXISTS `cortesdeldia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cortesdeldia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fechaCreacion` varchar(25) NOT NULL,
  `julianDate` varchar(5) NOT NULL,
  `idLote` varchar(25) NOT NULL,
  `sociedad` varchar(50) NOT NULL,
  `formaCafe` varchar(50) NOT NULL,
  `sacos` varchar(25) NOT NULL,
  `kg` varchar(25) NOT NULL,
  `costoAcumulado` varchar(25) NOT NULL,
  `estatus` varchar(25) NOT NULL,
  `calificacion` varchar(11) NOT NULL,
  `certificacion` varchar(5) NOT NULL,
  `idRecepcion` varchar(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cortesdeldia`
--

LOCK TABLES `cortesdeldia` WRITE;
/*!40000 ALTER TABLE `cortesdeldia` DISABLE KEYS */;
INSERT INTO `cortesdeldia` VALUES (1,'2022-01-10','010','AS18-22010-AB-2','Astal','Cereza','5','213','2130','Inactivo','2 Amarillo','AB','RE-AS-18'),(2,'2022-01-11','011','AS18-22011-AB-2','Astal','Cereza','8','349','3490','Inactivo','2 Amarillo','AB','RE-AS-18'),(3,'2022-01-11','011','AS18-22011-AD-2','Astal','Cereza','1','24','240.00','Inactivo','2 Amarillo','AD','RE-AS-18'),(4,'2022-01-13','013','AS18-22013-AB-2','Astal','Cereza','6','262','2620','Inactivo','2 Amarillo','AB','RE-AS-18'),(5,'2022-01-13','013','AS18-22013-AD-2','Astal','Cereza','2','62','620.00','Inactivo','2 Amarillo','AD','RE-AS-18'),(6,'2022-01-14','014','AS18-22014-AD-3','Astal','Cereza','5','163','1630','Inactivo','3 Rosa','AD','RE-AS-18'),(7,'2022-01-14','014','AS18-22014-AD-2','Astal','Cereza','2','69','690.00','Inactivo','2 Amarillo','AD','RE-AS-18'),(8,'2022-01-14','014','AS18-22014-AB-3','Astal','Cereza','4','152','1520','Inactivo','3 Rosa','AB','RE-AS-18'),(9,'2022-01-15','015','AS18-22015-AD-3','Astal','Cereza','10','325','3250','Inactivo','3 Rosa','AD','RE-AS-18'),(10,'2022-01-15','015','AS18-22015-AB-3','Astal','Cereza','8','345','3450','Inactivo','3 Rosa','AB','RE-AS-18'),(11,'2022-01-17','017','AS18-22017-AD-3','Astal','Cereza','9','334','3340','Inactivo','3 Rosa','AD','RE-AS-18'),(12,'2022-01-17','017','AS18-22017-AB-3','Astal','Cereza','11','365','3650','Inactivo','3 Rosa','AB','RE-AS-18'),(13,'2022-01-17','017','AS18-22017-AD-2','Astal','Cereza','8','231','2310','Inactivo','2 Amarillo','AD','RE-AS-18'),(14,'2022-01-18','018','AS18-22018-AD-2','Astal','Cereza','10','402','4020','Inactivo','2 Amarillo','AD','RE-AS-18'),(15,'2022-01-18','018','AS18-22018-AB-2','Astal','Cereza','7','240','2400','Inactivo','2 Amarillo','AB','RE-AS-18'),(16,'2022-01-18','018','AS18-22018-AB-3','Astal','Cereza','6','205','2050.00','Inactivo','3 Rosa','AB','RE-AS-18'),(17,'2022-01-18','018','AS18-22018-AD-3','Astal','Cereza','6','250','2500.00','Inactivo','3 Rosa','AD','RE-AS-18'),(18,'2022-01-19','019','AS18-22019-AB-2','Astal','Cereza','11','441','4410','Inactivo','2 Amarillo','AB','RE-AS-18'),(19,'2022-01-19','019','AS18-22019-AB-3','Astal','Cereza','7','235','2350','Inactivo','3 Rosa','AB','RE-AS-18'),(20,'2022-01-19','019','AS18-22019-AD-3','Astal','Cereza','10','368','3680','Inactivo','3 Rosa','AD','RE-AS-18'),(21,'2022-01-19','019','AS18-22019-AD-2','Astal','Cereza','6','250','2500','Inactivo','2 Amarillo','AD','RE-AS-18'),(22,'2022-01-20','020','AS18-22020-AB-3','Astal','Cereza','5','197','1970.00','Inactivo','3 Rosa','AB','RE-AS-18'),(23,'2022-01-20','020','AS18-22020-AD-3','Astal','Cereza','6','208','2080','Inactivo','3 Rosa','AD','RE-AS-18'),(24,'2022-01-20','020','AS18-22020-AD-2','Astal','Cereza','8','280','2800','Inactivo','2 Amarillo','AD','RE-AS-18'),(25,'2022-01-20','020','AS18-22020-AB-2','Astal','Cereza','15','537','5370','Inactivo','2 Amarillo','AB','RE-AS-18'),(26,'2022-01-21','021','AS18-22021-AD-2','Astal','Cereza','6','261','3132','Inactivo','2 Amarillo','AD','RE-AS-18'),(27,'2022-01-21','021','AS18-22021-AB-2','Astal','Cereza','17','603','7236','Inactivo','2 Amarillo','AB','RE-AS-18'),(28,'2022-01-22','022','AS18-22022-AD-2','Astal','Cereza','6','212','2544','Inactivo','2 Amarillo','AD','RE-AS-18'),(29,'2022-01-22','022','AS18-22022-AB-2','Astal','Cereza','7','257','3084','Inactivo','2 Amarillo','AB','RE-AS-18'),(30,'2022-01-24','024','AS18-22024-AB-2','Astal','Cereza','10','375','4500','Inactivo','2 Amarillo','AB','RE-AS-18'),(31,'2022-01-24','024','AS18-22024-AD-2','Astal','Cereza','8','316','3792','Inactivo','2 Amarillo','AD','RE-AS-18'),(32,'2022-01-24','024','AS18-22024-AB-3','Astal','Cereza','8','286','3432.00','Inactivo','3 Rosa','AB','RE-AS-18'),(33,'2022-01-25','025','AS18-22025-AD-3','Astal','Cereza','1','42','504.00','Inactivo','3 Rosa','AD','RE-AS-18'),(34,'2022-01-25','025','AS18-22025-AD-2','Astal','Cereza','22','846','10152','Inactivo','2 Amarillo','AD','RE-AS-18'),(35,'2022-01-25','025','AS18-22025-AB-2','Astal','Cereza','27','1039','12468','Inactivo','2 Amarillo','AB','RE-AS-18'),(36,'2022-01-25','025','AS18-22025-AB-1','Astal','Cereza','9','317','3804','Inactivo','1 Azul','AB','RE-AS-18'),(37,'2022-01-26','026','AS18-22026-AB-3','Astal','Cereza','10','365','4380','Inactivo','3 Rosa','AB','RE-AS-18'),(38,'2022-01-26','026','AS18-22026-AB-2','Astal','Cereza','16','629','7548','Inactivo','2 Amarillo','AB','RE-AS-18'),(39,'2022-01-26','026','AS18-22026-AD-2','Astal','Cereza','9','361','4332','Inactivo','2 Amarillo','AD','RE-AS-18'),(40,'2022-01-26','026','AS18-22026-AB-1','Astal','Cereza','5','217','2604','Inactivo','1 Azul','AB','RE-AS-18'),(41,'2022-01-26','026','AS18-22026-AD-1','Astal','Cereza','13','481','5772','Inactivo','1 Azul','AD','RE-AS-18'),(42,'2022-01-27','027','AS18-22027-AD-1','Astal','Cereza','10','408','4896','Inactivo','1 Azul','AD','RE-AS-18'),(43,'2022-01-27','027','AS18-22027-AB-2','Astal','Cereza','27','987','11844','Inactivo','2 Amarillo','AB','RE-AS-18'),(44,'2022-01-27','027','AS18-22027-AD-2','Astal','Cereza','5','227','2724','Inactivo','2 Amarillo','AD','RE-AS-18'),(45,'2022-01-27','027','AS18-22027-AB-1','Astal','Cereza','9','321','3852','Inactivo','1 Azul','AB','RE-AS-18'),(46,'2022-01-28','028','AS18-22028-AD-2','Astal','Cereza','8','311','3732','Inactivo','2 Amarillo','AD','RE-AS-18'),(47,'2022-01-28','028','AS18-22028-AB-2','Astal','Cereza','9','324','3888','Inactivo','2 Amarillo','AB','RE-AS-18'),(48,'2022-01-28','028','AS18-22028-AD-1','Astal','Cereza','3','77','924','Inactivo','1 Azul','AD','RE-AS-18'),(49,'2022-01-28','028','AS18-22028-AB-1','Astal','Cereza','11','340','4080','Inactivo','1 Azul','AB','RE-AS-18'),(50,'2022-01-28','028','AS18-22028-AD-3','Astal','Cereza','6','135','1620.00','Inactivo','3 Rosa','AD','RE-AS-18'),(51,'2022-01-29','029','AS18-22029-AB-2','Astal','Cereza','5','178','2136','Inactivo','2 Amarillo','AB','RE-AS-18'),(52,'2022-01-29','029','AS18-22029-AD-2','Astal','Cereza','7','257','3084','Inactivo','2 Amarillo','AD','RE-AS-18'),(53,'2022-01-29','029','AS18-22029-AD-1','Astal','Cereza','12','417','5004','Inactivo','1 Azul','AD','RE-AS-18'),(54,'2022-01-29','029','AS18-22029-AB-1','Astal','Cereza','5','214','2568','Inactivo','1 Azul','AB','RE-AS-18'),(55,'2022-01-31','031','AS18-22031-AD-1','Astal','Cereza','17','637','7644','Inactivo','1 Azul','AD','RE-AS-18'),(56,'2022-01-31','031','AS18-22031-AB-1','Astal','Cereza','26','869','10428','Inactivo','1 Azul','AB','RE-AS-18'),(57,'2022-01-31','031','AS18-22031-AB-3','Astal','Cereza','3','100','1200.00','Inactivo','3 Rosa','AB','RE-AS-18'),(58,'2022-01-31','031','AS18-22031-AD-2','Astal','Cereza','3','136','1632','Inactivo','2 Amarillo','AD','RE-AS-18');
/*!40000 ALTER TABLE `cortesdeldia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cribas`
--

DROP TABLE IF EXISTS `cribas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cribas` (
  `id_cribas` int(11) NOT NULL AUTO_INCREMENT,
  `id_bitacora` int(11) NOT NULL,
  `criba` varchar(20) DEFAULT NULL,
  `datos` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_cribas`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cribas`
--

LOCK TABLES `cribas` WRITE;
/*!40000 ALTER TABLE `cribas` DISABLE KEYS */;
INSERT INTO `cribas` VALUES (43,12,'19','50,1,2,5,5,3,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1'),(44,12,'18','30,1,2,0,2,2,0,1,0,1,0,1,0,1,0,0,1,1,0,0,1,0,0,1'),(45,12,'17','50,2,5,0,2,0,1,0,0,0,1,1,1,0,1,1,1,0,0,0,0,1,1,1'),(46,12,'16','10,1,1,0,3,0,0,0,1,1,0,1,0,1,0,0,0,1,1,1,1,0,0,1'),(47,12,'15','40,0,0,1,0,2,0,1,0,0,1,0,1,0,0,1,1,1,0,0,0,1,1,1'),(48,12,'F','50,1,0,0,0,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1'),(49,12,'TOTAL','230,1,1,6,4,0,1,0,0,1,0,0,0,0,3,0,1,1,0,0,0,0,0,6'),(50,13,'19','80,2,1,1,2,1,1,1,0,0,0,1,1,0,1,0,0,0,0,0,0,0,1,0'),(51,13,'18','80,1,1,1,2,1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,0,1,1,1'),(52,13,'17','10,2,1,2,1,1,0,1,0,0,0,1,0,1,1,1,1,1,1,1,11,1,1,1'),(53,13,'16','10,2,1,2,1,1,1,0,1,1,0,1,1,1,0,1,11,1,1,1,1,1,0,1'),(54,13,'15','80,2,1,1,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,1,0,0,1,0'),(55,13,'F','50,2,1,1,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0'),(56,13,'TOTAL','310,2,0,8,2,4,1,0,0,1,0,0,0,0,4,0,2,0,0,0,2,0,0,3'),(57,14,'19','50,0,1,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0'),(58,14,'18','20,1,5,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0'),(59,14,'17','30,1,5,1,0,1,0,1,0,1,0,0,1,0,1,1,0,1,0,1,1,0,1,0'),(60,14,'16','50,1,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0'),(61,14,'15','50,2,1,0,0,0,0,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,0,1'),(62,14,'F','50,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0'),(63,14,'TOTAL','250,1,1,4,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1');
/*!40000 ALTER TABLE `cribas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cultivos`
--

DROP TABLE IF EXISTS `cultivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cultivos` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cultivos`
--

LOCK TABLES `cultivos` WRITE;
/*!40000 ALTER TABLE `cultivos` DISABLE KEYS */;
INSERT INTO `cultivos` VALUES (1,'Café',1,1,'2019-08-13','15:49:41','','',1,1),(2,'Platano',1,1,'2019-08-13','15:49:49','','',1,1),(3,'Citricos',1,1,'2019-08-13','15:49:58','','',1,1),(4,'Mandarina ',1,1,'2019-08-13','15:50:06','','',1,1),(5,'Durazno',1,1,'2019-08-13','15:50:13','','',1,1),(6,'Ahuacate',1,1,'2019-08-13','15:50:21','','',1,1),(7,'Cacahuate',1,1,'2019-08-13','15:50:28','','',1,1),(8,'Jitomate',1,1,'2019-08-13','15:50:35','','',1,1),(9,'Guanabana',1,1,'2019-08-13','15:50:46','','',1,1),(10,'Naranja',1,1,'2019-08-13','15:50:52','','',1,1),(11,'Chayote',1,1,'2019-08-13','15:51:00','','',1,1),(12,'Jicama',1,1,'2019-08-13','15:51:06','','',1,1),(13,'Chile',1,1,'2019-08-13','15:51:14','','',1,1),(14,'Té De Limón',1,1,'2019-08-13','15:51:35','','',1,1),(15,'Pimienta',1,1,'2019-08-13','15:51:53','','',1,1),(16,'Sandia',1,1,'2019-08-13','15:51:58','','',1,1),(17,'Franbuesa',1,1,'2019-08-13','15:52:08','','',1,1);
/*!40000 ALTER TABLE `cultivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datosev`
--

DROP TABLE IF EXISTS `datosev`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datosev` (
  `id_datos` int(11) NOT NULL AUTO_INCREMENT,
  `id_muestra` int(11) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `uniformidad` int(10) DEFAULT NULL,
  `humedad_o` varchar(50) DEFAULT NULL,
  `humedad_c` varchar(50) DEFAULT NULL,
  `color` int(10) DEFAULT NULL,
  `evaluador` varchar(100) DEFAULT NULL,
  `puntuacion` varchar(100) DEFAULT NULL,
  `id_bitacora` int(11) DEFAULT NULL,
  `PesoEv` varchar(45) DEFAULT NULL,
  `Densidadoro` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_datos`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datosev`
--

LOCK TABLES `datosev` WRITE;
/*!40000 ALTER TABLE `datosev` DISABLE KEYS */;
INSERT INTO `datosev` VALUES (7,12,'20-ago-2019',1,'10','15',5,'Jacob Frankel','21',12,'350',NULL),(8,13,'20-ago-2019',5,'10','15',7,'Carlos bustamante','27',13,'350',NULL),(9,14,'20-ago-2019',1,'10','10',6,'Gigi Mengistu','8',14,'250',NULL);
/*!40000 ALTER TABLE `datosev` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_rutabh`
--

DROP TABLE IF EXISTS `detalle_rutabh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_rutabh` (
  `idRuta` int(11) NOT NULL,
  `actividad` varchar(10) NOT NULL,
  `maquinaria` varchar(10) NOT NULL,
  `formaSalida` varchar(10) NOT NULL,
  `claveSalida` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_rutabh`
--

LOCK TABLES `detalle_rutabh` WRITE;
/*!40000 ALTER TABLE `detalle_rutabh` DISABLE KEYS */;
INSERT INTO `detalle_rutabh` VALUES (2,'7','20','Cereza','S1'),(2,'5','48','Pergamino','S1'),(3,'7','20','Cereza','S2'),(3,'9','21','Cereza','S1'),(3,'6','4','Cereza','S1'),(3,'8','43','Cereza','S1'),(3,'8','52','Pergamino','S1');
/*!40000 ALTER TABLE `detalle_rutabh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diseñoplantacion`
--

DROP TABLE IF EXISTS `diseñoplantacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diseñoplantacion` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(85) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diseñoplantacion`
--

LOCK TABLES `diseñoplantacion` WRITE;
/*!40000 ALTER TABLE `diseñoplantacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `diseñoplantacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentosparcelas`
--

DROP TABLE IF EXISTS `documentosparcelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentosparcelas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_parcela` int(11) NOT NULL,
  `tipoArchivo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `ruta` varchar(250) NOT NULL,
  `archivo` longblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentosparcelas`
--

LOCK TABLES `documentosparcelas` WRITE;
/*!40000 ALTER TABLE `documentosparcelas` DISABLE KEYS */;
/*!40000 ALTER TABLE `documentosparcelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejidocolonia`
--

DROP TABLE IF EXISTS `ejidocolonia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ejidocolonia` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  `ID_Localidad` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejidocolonia`
--

LOCK TABLES `ejidocolonia` WRITE;
/*!40000 ALTER TABLE `ejidocolonia` DISABLE KEYS */;
INSERT INTO `ejidocolonia` VALUES (1,'Centro',1,1,'2019-07-17','10:18:58','','',1,1,1),(2,'El Duende',1,1,'2019-07-17','10:19:15','','',1,1,1),(3,'Centro',1,1,'2019-07-17','10:20:22','','',1,1,2),(4,'Chimaltita',1,1,'2019-07-17','10:26:13','','',1,1,3),(5,'Cordón Del Jilguero',1,1,'2019-07-17','10:31:06','','',1,1,4),(6,'El Refugio',1,1,'2019-07-17','10:32:00','','',1,1,5),(7,'El Taixte',1,1,'2019-07-17','10:32:43','','',1,1,6),(8,'El Venado',1,1,'2019-07-17','10:33:13','','',1,1,7),(9,'La Bolita',1,1,'2019-07-17','10:33:38','','',1,1,8),(10,'Banco Colorado',1,1,'2019-07-17','10:34:42','','',1,1,9),(11,'Centro',1,1,'2019-07-17','10:35:00','','',1,1,9),(12,'Guajolote',1,1,'2019-07-17','10:35:24','','',1,1,9),(13,'Presidio De Los Reyes',1,1,'2019-07-17','10:36:08','','',1,1,9),(14,'Sombrero',1,1,'2019-07-17','10:36:28','','',1,1,9),(15,'Puerta De Platanares',1,1,'2019-07-17','10:37:06','','',1,1,10),(16,'Centro',1,1,'2019-07-17','10:40:47','','',1,1,11),(17,'El Cora',1,1,'2019-07-17','10:41:16','','',1,1,11),(18,'Centro',1,1,'2019-07-17','10:41:50','','',1,1,12),(19,'Huaynamota',1,1,'2019-07-17','10:45:15','','',1,1,12),(20,'Centro',1,1,'2019-07-17','10:45:45','','',1,1,13),(21,'Jacocotan',1,1,'2019-07-17','10:46:19','','',1,1,13),(22,'La Libertad',1,1,'2019-07-17','10:47:01','','',1,1,14),(23,'Barrio El Mole',1,1,'2019-07-17','10:47:42','','',1,1,15),(24,'Mecatan',1,1,'2019-07-17','10:48:15','','',1,1,15),(25,'Pintadeño',1,1,'2019-07-17','10:48:47','','',1,1,16),(26,'Centro',1,1,'2019-07-17','12:43:32','','',1,1,17),(27,'La Yerba',1,1,'2019-07-17','12:44:02','','',1,1,17),(28,'Centro',1,1,'2019-07-17','12:44:34','','',1,1,18),(29,'Lindavista',1,1,'2019-07-17','12:45:29','','',1,1,18),(30,'Lo De Garcia',1,1,'2019-07-17','12:46:36','','',1,1,19),(31,'Dos De Agosto',1,1,'2019-07-17','12:48:55','','',1,1,20),(32,'Adolfo Lopez Mateos',1,1,'2019-07-17','12:49:24','','',1,1,20),(33,'Cd. Industrial',1,1,'2019-07-17','12:49:48','','',1,1,20),(34,'Centro',1,1,'2019-07-17','12:50:14','','',1,1,20),(35,'Morelos',1,1,'2019-07-17','12:51:14','','',1,1,20),(36,'Robles',1,1,'2019-07-17','12:51:28','','',1,1,20),(37,'Tepic',1,1,'2019-07-17','12:51:46','','',1,1,20),(38,'Vistas De La Cantera Dos',1,1,'2019-07-17','12:52:19','','',1,1,20),(39,'Venustiano Carranza',1,1,'2019-07-17','12:53:27','','',1,1,21),(40,'Centro',1,1,'2019-07-17','12:56:17','','',1,1,22),(41,'Bajo',1,1,'2019-07-17','12:56:59','','',1,1,23),(42,'Centro',1,1,'2019-07-17','12:57:19','','',1,1,23),(43,'El Cuarenteño',1,1,'2019-07-17','12:57:57','','',1,1,23),(44,'Centro',1,1,'2019-07-17','12:58:26','','',1,1,24),(45,'El Corral',1,1,'2019-07-17','12:59:06','','',1,1,24),(46,'Centro',1,1,'2019-07-17','13:00:07','','',1,1,25),(47,'San Antonio',1,1,'2019-07-17','13:00:46','','',1,1,26);
/*!40000 ALTER TABLE `ejidocolonia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfermedadplaga`
--

DROP TABLE IF EXISTS `enfermedadplaga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfermedadplaga` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(85) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermedadplaga`
--

LOCK TABLES `enfermedadplaga` WRITE;
/*!40000 ALTER TABLE `enfermedadplaga` DISABLE KEYS */;
/*!40000 ALTER TABLE `enfermedadplaga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entradasmaquinaria`
--

DROP TABLE IF EXISTS `entradasmaquinaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entradasmaquinaria` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idMaquinaria` int(11) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `formacafe` varchar(35) NOT NULL,
  `procesocafe` varchar(35) NOT NULL,
  `estadocafe` varchar(35) NOT NULL,
  `datoEvaluar` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradasmaquinaria`
--

LOCK TABLES `entradasmaquinaria` WRITE;
/*!40000 ALTER TABLE `entradasmaquinaria` DISABLE KEYS */;
INSERT INTO `entradasmaquinaria` VALUES (1,1,'E1','Cereza','Sin Proceso','Fresco',''),(2,27,'E1','Cereza','Sin Proceso','Fresco',''),(3,40,'E1','Cereza','Sin Proceso','Fresco',''),(4,20,'E1','Cereza','Sin Proceso','Fresco',''),(5,4,'E1','Cereza','Sin Proceso','Fresco',''),(6,29,'E1','Cereza','Sin Proceso','Fresco',''),(7,42,'E1','Cereza','Sin Proceso','Fresco','');
/*!40000 ALTER TABLE `entradasmaquinaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) NOT NULL,
  `UsuarioCreacion` int(10) NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  `ID_Pais` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Nayarit',1,1,'2019-07-17','10:13:19','','',1,1,1);
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadocafe`
--

DROP TABLE IF EXISTS `estadocafe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadocafe` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Clave` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadocafe`
--

LOCK TABLES `estadocafe` WRITE;
/*!40000 ALTER TABLE `estadocafe` DISABLE KEYS */;
INSERT INTO `estadocafe` VALUES (1,'FR','Fresco',1,1,'2019-08-14','13:00:01','','',1,1),(2,'SE','Seco',1,1,'2019-08-14','14:06:22','','',1,1),(3,'OR','Oreado',1,1,'2019-10-04','10:42:51','','',1,1),(4,'ES','Escurrido',1,1,'2019-10-04','10:43:01','','',1,1),(5,'HU','Humedo',1,1,'2019-10-04','10:43:11','','',1,1);
/*!40000 ALTER TABLE `estadocafe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadometeorologico`
--

DROP TABLE IF EXISTS `estadometeorologico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadometeorologico` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Meses` varchar(45) NOT NULL,
  `TemperaturaMaxima` int(3) NOT NULL,
  `TemperaturaMinima` int(3) NOT NULL,
  `Precipitacion` int(3) NOT NULL,
  `Humedad` int(3) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadometeorologico`
--

LOCK TABLES `estadometeorologico` WRITE;
/*!40000 ALTER TABLE `estadometeorologico` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadometeorologico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estandarescert`
--

DROP TABLE IF EXISTS `estandarescert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estandarescert` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Clave` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estandarescert`
--

LOCK TABLES `estandarescert` WRITE;
/*!40000 ALTER TABLE `estandarescert` DISABLE KEYS */;
INSERT INTO `estandarescert` VALUES (1,'NO','Nop - Usda',1,1,'2019-08-13','15:25:06','','',1,1),(2,'DA','Da-eu',1,1,'2019-08-16','13:50:23','','',1,1),(3,'JA','Jas',1,1,'2019-08-16','13:50:42','','',1,1),(4,'LM','Lop-mex',1,1,'2019-08-16','13:51:01','','',1,1);
/*!40000 ALTER TABLE `estandarescert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factorforma`
--

DROP TABLE IF EXISTS `factorforma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factorforma` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_Forma1` int(10) unsigned NOT NULL,
  `ID_Forma2` int(10) unsigned NOT NULL,
  `Formula` varchar(100) NOT NULL,
  `Factor` float NOT NULL,
  `porcentaje` float NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factorforma`
--

LOCK TABLES `factorforma` WRITE;
/*!40000 ALTER TABLE `factorforma` DISABLE KEYS */;
/*!40000 ALTER TABLE `factorforma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fertilizante`
--

DROP TABLE IF EXISTS `fertilizante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fertilizante` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(65) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fertilizante`
--

LOCK TABLES `fertilizante` WRITE;
/*!40000 ALTER TABLE `fertilizante` DISABLE KEYS */;
/*!40000 ALTER TABLE `fertilizante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formacafe`
--

DROP TABLE IF EXISTS `formacafe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formacafe` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Clave` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formacafe`
--

LOCK TABLES `formacafe` WRITE;
/*!40000 ALTER TABLE `formacafe` DISABLE KEYS */;
INSERT INTO `formacafe` VALUES (1,'CT','Cereza',1,1,'2019-08-14','10:25:26','','',1,1),(5,'PT','Pergamino',1,1,'2019-08-14','10:27:49','','',1,1),(10,'BT','Capulin',1,1,'2019-08-14','10:30:27','','',1,1),(14,'OT','Oro',1,1,'2019-08-14','10:32:32','','',1,1);
/*!40000 ALTER TABLE `formacafe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formaevaluacion`
--

DROP TABLE IF EXISTS `formaevaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formaevaluacion` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_Forma` int(10) unsigned NOT NULL,
  `ID_Evaluacion` int(10) unsigned NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formaevaluacion`
--

LOCK TABLES `formaevaluacion` WRITE;
/*!40000 ALTER TABLE `formaevaluacion` DISABLE KEYS */;
INSERT INTO `formaevaluacion` VALUES (1,1,14,1,1,'2019-10-21','11:17:39','','',1,1);
/*!40000 ALTER TABLE `formaevaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formaproceso`
--

DROP TABLE IF EXISTS `formaproceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formaproceso` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_Forma` int(10) unsigned NOT NULL,
  `ID_Proceso` int(10) unsigned NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formaproceso`
--

LOCK TABLES `formaproceso` WRITE;
/*!40000 ALTER TABLE `formaproceso` DISABLE KEYS */;
/*!40000 ALTER TABLE `formaproceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotosprueba`
--

DROP TABLE IF EXISTS `fotosprueba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fotosprueba` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foto` longblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotosprueba`
--

LOCK TABLES `fotosprueba` WRITE;
/*!40000 ALTER TABLE `fotosprueba` DISABLE KEYS */;
/*!40000 ALTER TABLE `fotosprueba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `girodemoral`
--

DROP TABLE IF EXISTS `girodemoral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `girodemoral` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `girodemoral`
--

LOCK TABLES `girodemoral` WRITE;
/*!40000 ALTER TABLE `girodemoral` DISABLE KEYS */;
/*!40000 ALTER TABLE `girodemoral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `herbicidas`
--

DROP TABLE IF EXISTS `herbicidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `herbicidas` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `herbicidas`
--

LOCK TABLES `herbicidas` WRITE;
/*!40000 ALTER TABLE `herbicidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `herbicidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialpreciocafesociedad`
--

DROP TABLE IF EXISTS `historialpreciocafesociedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialpreciocafesociedad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSociedad` int(11) NOT NULL,
  `idFormaCafe` int(11) NOT NULL,
  `idRetencion` int(11) NOT NULL,
  `precioKg` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `fechaModificacion` varchar(25) NOT NULL,
  `horaModificacion` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialpreciocafesociedad`
--

LOCK TABLES `historialpreciocafesociedad` WRITE;
/*!40000 ALTER TABLE `historialpreciocafesociedad` DISABLE KEYS */;
INSERT INTO `historialpreciocafesociedad` VALUES (1,1,1,1,5,'Usuario Modificacion','2019-09-06','09:34:09'),(2,3,1,1,5,'Usuario Modificacion','2019-10-29','08:26:24'),(3,9,1,1,5,'Usuario Modificacion','2019-10-29','08:29:37'),(4,2,1,1,5,'Usuario Modificacion','2019-10-29','08:30:24'),(5,5,1,1,5,'Usuario Modificacion','2019-10-29','08:30:38'),(6,7,1,1,5,'Usuario Modificacion','2019-10-29','08:30:52'),(7,8,1,1,5,'Usuario Modificacion','2019-10-29','08:31:06'),(8,6,1,1,5,'Usuario Modificacion','2019-10-29','08:32:43'),(9,4,1,1,6,'Usuario Modificacion','2019-12-30','14:06:25');
/*!40000 ALTER TABLE `historialpreciocafesociedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialsublotes`
--

DROP TABLE IF EXISTS `historialsublotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialsublotes` (
  `idOrigen` varchar(35) NOT NULL,
  `idSubLote` varchar(35) NOT NULL,
  `formaCafe` varchar(35) NOT NULL,
  `estadoCafe` varchar(35) NOT NULL,
  `kilosTotales` double NOT NULL,
  `fecha` varchar(25) NOT NULL,
  `estatus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialsublotes`
--

LOCK TABLES `historialsublotes` WRITE;
/*!40000 ALTER TABLE `historialsublotes` DISABLE KEYS */;
INSERT INTO `historialsublotes` VALUES ('AS8-20074-AA-2','AS8-20074-AA-2','AA','Cereza',362,'2020-Ago-07',1),('AS8-20074-AA-2','SLot-BH-AS-18-Div-2','AA','AA',300,'2020-Ago-07',1),('AS8-20074-AA-1','AS8-20074-AA-1','AA','Cereza',117,'2020-Ago-07',1),('AS8-20090-AD-1','AS8-20090-AD-1','AD','Cereza',126,'2020-Ago-08',1),('AS8-20090-AA-1','AS8-20090-AA-1','Cereza','Fresco',250,'2020-Ago-08',1),('AS8-20090-AA-1','SLot-BH-AS-18-Div-3','Cereza','Fresco',200,'2020-Ago-08',1),('AS8-20090-AA-1','SLot-BH-AS-18-Div-19','Cereza','Fresco',125,'2020-Ago-08',1),('AS8-20090-AA-1','SLot-BH-AS-18-Div-20','Cereza','Fresco',75,'2020-Ago-08',1),('AS8-20090-AA-1','SLot-BH-AS-18-Div-2','Cereza','Fresco',50,'2020-Ago-08',1),('AS8-20088-AD-1','AS8-20088-AD-1','Cereza','Fresco',178,'2020-Ago-08',1),('AS8-20088-AA-1','AS8-20088-AA-1','Cereza','Fresco',111,'2020-Ago-08',1),('AS8-20088-AD-1','SLot-BH-AS-18-Div-5','Cereza','Fresco',100,'2020-Ago-08',1),('AS8-20088-AD-1','SLot-BH-AS-18-Div-22','Cereza','Fresco',80,'2020-Ago-08',1),('AI14-21026-AC-1','AI14-21026-AC-1','Cereza','Humedo',47,'2021-04-26',1),('AI14-21025-AB-1','AI14-21025-AB-1','Cereza','Fresco',200,'2021-04-27',1),('AI14-21025-AB-1','SLot-BH-AI-15-Frg1-5','Cereza','Escurrido',119,'2021-04-27',1);
/*!40000 ALTER TABLE `historialsublotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idioma`
--

DROP TABLE IF EXISTS `idioma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idioma` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idioma`
--

LOCK TABLES `idioma` WRITE;
/*!40000 ALTER TABLE `idioma` DISABLE KEYS */;
/*!40000 ALTER TABLE `idioma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidad`
--

DROP TABLE IF EXISTS `localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidad` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(60) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  `ID_Municipio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidad`
--

LOCK TABLES `localidad` WRITE;
/*!40000 ALTER TABLE `localidad` DISABLE KEYS */;
INSERT INTO `localidad` VALUES (1,'Compostela',1,1,'2019-07-17','10:17:58','','',1,1,1),(2,'El Refilion',1,1,'2019-07-17','10:18:16','','',1,1,1),(3,'Chimaltita',1,1,'2019-07-17','10:25:19','','',1,1,2),(4,'Cordón Del Jilguero',1,1,'2019-07-17','10:27:42','','',1,1,2),(5,'El Refugio',1,1,'2019-07-17','10:28:06','','',1,1,2),(6,'El Taixte',1,1,'2019-07-17','10:28:32','','',1,1,2),(7,'El Venado',1,1,'2019-07-17','10:28:46','','',1,1,2),(8,'La Bolita',1,1,'2019-07-17','10:29:00','','',1,1,2),(9,'Presidio De Los Reyes',1,1,'2019-07-17','10:29:20','','',1,1,2),(10,'Puerta De Platanares',1,1,'2019-07-17','10:29:37','','',1,1,2),(11,'El Cora',1,1,'2019-07-17','10:37:58','','',1,1,3),(12,'Huaynamota',1,1,'2019-07-17','10:38:22','','',1,1,3),(13,'Jalcocotan',1,1,'2019-07-17','10:38:54','','',1,1,3),(14,'La Libertad',1,1,'2019-07-17','10:39:13','','',1,1,3),(15,'Mecatan',1,1,'2019-07-17','10:39:30','','',1,1,3),(16,'Pintadeño',1,1,'2019-07-17','10:39:52','','',1,1,3),(17,'La Yerba',1,1,'2019-07-17','12:41:25','','',1,1,4),(18,'Lindavista',1,1,'2019-07-17','12:41:54','','',1,1,4),(19,'Lo De Garcia',1,1,'2019-07-17','12:42:13','','',1,1,4),(20,'Tepic',1,1,'2019-07-17','12:42:35','','',1,1,4),(21,'Venustiano Carranza',1,1,'2019-07-17','12:42:58','','',1,1,4),(22,'Cofradia De Chocolon',1,1,'2019-07-17','12:54:18','','',1,1,5),(23,'El Cuarenteño',1,1,'2019-07-17','12:54:43','','',1,1,5),(24,'El Italiano',1,1,'2019-07-17','12:55:00','','',1,1,5),(25,'El Malinal',1,1,'2019-07-17','12:55:21','','',1,1,5),(26,'San Antonio',1,1,'2019-07-17','12:55:43','','',1,1,5);
/*!40000 ALTER TABLE `localidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lotesprocesosecado`
--

DROP TABLE IF EXISTS `lotesprocesosecado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lotesprocesosecado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idLoteOrigen` varchar(50) NOT NULL,
  `idBeneficio` varchar(20) NOT NULL,
  `idSubLote` varchar(50) NOT NULL,
  `idRuta` int(11) NOT NULL,
  `fecha` varchar(25) NOT NULL,
  `formaCafe` varchar(30) NOT NULL,
  `estadoCafe` varchar(30) NOT NULL,
  `kilosEntrantes` double NOT NULL,
  `formaSalidaFinal` varchar(45) NOT NULL,
  `lugarsecado` varchar(55) NOT NULL,
  `fechaInicioSecado` varchar(25) NOT NULL,
  `estatus` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lotesprocesosecado`
--

LOCK TABLES `lotesprocesosecado` WRITE;
/*!40000 ALTER TABLE `lotesprocesosecado` DISABLE KEYS */;
INSERT INTO `lotesprocesosecado` VALUES (1,'AI14-21026-AC-1','BH-AI-15','AI14-21026-AC-1',2,'2021-04-26','Cereza','Humedo',47,'Cereza','0',' ',0),(2,'AI14-21025-AB-1','BH-AI-15','AI14-21025-AB-1',2,'2021-04-27','Cereza','Fresco',200,'Cereza','SASE01','2021-04-28',0),(3,'AI14-21025-AB-1','BH-AI-15','SLot-BH-AI-15-Frg1-5',2,'2021-04-27','Cereza','Escurrido',119,'Cereza','RUPA01','2021-04-27',0);
/*!40000 ALTER TABLE `lotesprocesosecado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maquinariabh`
--

DROP TABLE IF EXISTS `maquinariabh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maquinariabh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idActividad` int(11) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `serie` varchar(50) NOT NULL,
  `capacidad` varchar(10) NOT NULL,
  `tiempoevaluacion` int(11) NOT NULL,
  `entradas` int(11) NOT NULL,
  `salidas` int(11) NOT NULL,
  `sobrante` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `generarLote` char(1) NOT NULL,
  `restarInmediato` char(1) NOT NULL,
  `id_situacion` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maquinariabh`
--

LOCK TABLES `maquinariabh` WRITE;
/*!40000 ALTER TABLE `maquinariabh` DISABLE KEYS */;
INSERT INTO `maquinariabh` VALUES (1,7,'SASI01','Sifón (Sep/Den/Agua) Sandia','Hario','UBH-2','SSI001','5',7,1,2,1,'','1','1',1),(2,11,'SABA01','Báscula Sandia','Revuelta','Piso','310','1',7,0,0,0,'','0','0',1),(3,5,'AAPA01','Patio Arrocera','N/A','N/A','N/A','1',7,0,0,0,'','0','0',1),(4,6,'SADP01','Despulpadora','COMEK','N/A','500a','5',5,1,0,0,'','0','0',1),(5,5,'SASE01','Secadora_H','S/N','S/N','S/N','2',7,0,0,0,'','0','0',1),(6,2,'BG01','Bodega','S/N','S/N','S/N','0',1,0,0,0,'','0','0',1),(7,2,'BG02','Bodega','S/N','S/N','S/N','20',1,0,0,0,'','0','0',1),(8,5,'DUCA01','Cama Susp. Malla 1','S/N','S/N','S/N','1',1,0,0,0,'','0','0',1),(9,5,'SASE02','Secadora_M','S/N','S/N','S/N','2',7,0,0,0,'','0','0',1),(10,5,'SASE03','Secadora_Y','S/N','S/N','S/N','2',7,0,0,0,'','0','0',1),(11,5,'DUSG01','Secadora Guardiola S1','N/A','N/A','N/A','3',7,0,0,0,'','0','0',1),(12,5,'DUSG02','Secadora Guardiola S2','N/A','N/A','N/A','2',7,0,0,0,'','0','0',1),(13,5,'DUSG03','Secadora Guardiola S3','N/A','N/A','N/A','2',7,0,0,0,'','0','0',1),(14,5,'DuSG04','Secadora Guardiola S4','N/A','N/A','N/A','2',7,0,0,0,'','0','0',1),(15,5,'DUCA02','Cama susp. Malla 2','N/A','N/A','N/A','1',1,0,0,0,'','0','0',1),(16,5,'DUCA03','Cama Susp. Malla 3','N/A','N/A','N/A','1',0,0,0,0,'','0','0',1),(17,5,'SAPA01','Patio Sandia','N/A','N/A','S/S','1',7,0,0,0,'','0','0',1),(18,11,'DUBA01','Báscila Duende','Pendiente','Pendiente','Pendiente','1',7,0,0,0,'','0','0',1),(19,11,'AABA01','Báscula Arrocera','Pendiente','Pendiente','S/S','1',7,0,0,0,'','0','0',1),(20,7,'SIF01','Sifón (Sep/Den/Agua) ','Pendiente','Pendiente','Pendiente','5',7,1,2,1,'','1','1',1),(21,9,'SABH01','Bomba Hidráulica','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(22,10,'SAEL01','Elecoidal 1','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(23,3,'SALA01','Lavadora Sandia','Pendiente','Pendiente','Pendiente','0',7,0,0,4,'','1','0',1),(24,10,'SAEL02','Elecoidal 2','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(25,8,'SASV01','Separadora de Verdes','Pendiente','Pendiente','Pendiente','0',7,0,0,2,'','1','0',1),(26,11,'RUBA01','Báscula Rústico','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(27,7,'RUSI01','Sifon (Sep/Den/Agua) Rústico','Pendeinte','Pendiente','Pendiente','5',7,1,2,1,'','1','1',1),(28,10,'RUEL01','Elecoidal Rústico Procaa','Pendiente','Pendiente','Pendiente','0',0,0,0,0,'','0','0',1),(29,6,'RUDE','Despulpadora Rústico','Pendiente','Pendiente','Pendiente','5',7,1,0,0,'','0','0',1),(30,8,'RUSV01','Separadora De Verdes','Pendiente','Pendiente','Pendiente','0',7,0,0,2,'','1','0',1),(31,3,'RULA01','Lavadora Rústico','Pendiente','Pendiente','Pendiente','0',7,0,0,4,'','1','0',1),(32,9,'RUBS01','Bomba Sumergible Rústico','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(33,5,'RUPA01','Patio Rústico','S/M','S/M','S/S','5',7,0,0,0,'','0','0',1),(34,5,'RIPA01','Patio Techos Riviera','S/M','S/M','S/S','0',7,0,0,0,'','0','0',1),(35,11,'ASBA01','Báscula Jacinto','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(36,5,'ASPA01','Patio Jacinto','S/M','S/M','S/S','0',7,0,0,0,'','0','0',1),(37,11,'ASBA02','Báscula Agustina','S/M','S/M','S/S','0',7,0,0,0,'','0','0',1),(38,5,'ASPA02','Patio Agustina','S/M','S/M','S/S','0',7,0,0,0,'','0','0',1),(39,11,'PIBA01','Báscula Piña','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(40,7,'PISI01','Sifón (Sep/Den/Agua) Piña','Pendiente','Pendiente','Pendiente','5',7,1,2,1,'','1','1',1),(41,10,'PIEL01','Elecoidal','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(42,6,'PIDE01','Despuladora Piña','Pendiente','Pendiente','Pendiente','5',7,1,0,0,'','0','0',1),(43,8,'PISV01','Separadora De Verdes','Pendiente','Pendiente','Pendiente','0',7,0,0,2,'','1','0',1),(44,3,'PILA01','Lavadora Piña','Pendiente','Pendiente','Pendiente','0',7,0,0,4,'','1','0',1),(45,11,'COBA01','Báscula Cordon','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(46,5,'COPA01','Patio Cordon','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(47,11,'MEBA01','Báscula Melon','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(48,5,'MEPA01','Patio Melon','Pendiente','Pendiente','Pendiente','0',7,0,0,0,'','0','0',1),(49,5,'PIPA01','patio Piña','S/M','S/M','S/S','0',7,0,0,0,'','0','0',1),(50,11,'HEBA01','Báscula Hector','Pendiente','Pendiente','Pendiente','1',7,0,0,0,'','0','0',1),(51,5,'HEPA01','Patio Techo Hector','S/M','S/M','S/S','1',7,0,0,0,'','0','0',1);
/*!40000 ALTER TABLE `maquinariabh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maquinariaherramienta`
--

DROP TABLE IF EXISTS `maquinariaherramienta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maquinariaherramienta` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maquinariaherramienta`
--

LOCK TABLES `maquinariaherramienta` WRITE;
/*!40000 ALTER TABLE `maquinariaherramienta` DISABLE KEYS */;
/*!40000 ALTER TABLE `maquinariaherramienta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maximorendimiento`
--

DROP TABLE IF EXISTS `maximorendimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maximorendimiento` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Rendimiento` int(3) NOT NULL,
  `ID_Proceso` int(10) unsigned NOT NULL,
  `ID_Forma` int(10) unsigned NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maximorendimiento`
--

LOCK TABLES `maximorendimiento` WRITE;
/*!40000 ALTER TABLE `maximorendimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `maximorendimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maximotamañopromedio`
--

DROP TABLE IF EXISTS `maximotamañopromedio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maximotamañopromedio` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MaximoTamaño` int(3) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maximotamañopromedio`
--

LOCK TABLES `maximotamañopromedio` WRITE;
/*!40000 ALTER TABLE `maximotamañopromedio` DISABLE KEYS */;
/*!40000 ALTER TABLE `maximotamañopromedio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivoplantacion`
--

DROP TABLE IF EXISTS `motivoplantacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motivoplantacion` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  `ID_Estado` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivoplantacion`
--

LOCK TABLES `motivoplantacion` WRITE;
/*!40000 ALTER TABLE `motivoplantacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `motivoplantacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muestrasenviadas`
--

DROP TABLE IF EXISTS `muestrasenviadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muestrasenviadas` (
  `id_muestrasE` int(11) NOT NULL AUTO_INCREMENT,
  `idlote` int(11) DEFAULT NULL,
  `tipocafe` varchar(45) DEFAULT NULL,
  `forma` varchar(45) DEFAULT NULL,
  `beneficio` varchar(45) DEFAULT NULL,
  `dueño` varchar(45) DEFAULT NULL,
  `lote` varchar(45) DEFAULT NULL,
  `peso` varchar(45) DEFAULT NULL,
  `sacos` varchar(45) DEFAULT NULL,
  `comunidad` varchar(45) DEFAULT NULL,
  `observaciones` varchar(45) DEFAULT NULL,
  `Metodosecado` varchar(45) DEFAULT NULL,
  `calidadcereza` varchar(45) DEFAULT NULL,
  `pesomuestra` varchar(45) DEFAULT NULL,
  `ubicacioncafe` varchar(45) DEFAULT NULL,
  `fechalote` varchar(45) DEFAULT NULL,
  `terminosecado` varchar(45) DEFAULT NULL,
  `tomademuestra` varchar(45) DEFAULT NULL,
  `fechacosecha` varchar(45) DEFAULT NULL,
  `tomadapor` varchar(45) DEFAULT NULL,
  `recibidapor` varchar(45) DEFAULT NULL,
  `transportadapor` varchar(45) DEFAULT NULL,
  `certificado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_muestrasE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muestrasenviadas`
--

LOCK TABLES `muestrasenviadas` WRITE;
/*!40000 ALTER TABLE `muestrasenviadas` DISABLE KEYS */;
/*!40000 ALTER TABLE `muestrasenviadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multipleboletasalidarecepcion`
--

DROP TABLE IF EXISTS `multipleboletasalidarecepcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `multipleboletasalidarecepcion` (
  `id` int(11) NOT NULL,
  `idBoleta` varchar(35) NOT NULL,
  `idTransporte` int(11) NOT NULL,
  `sacosEnviados` int(11) NOT NULL,
  `kilosEnviados` varchar(15) NOT NULL,
  `sacosRecibidos` int(11) NOT NULL,
  `kilosRecibidos` varchar(15) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multipleboletasalidarecepcion`
--

LOCK TABLES `multipleboletasalidarecepcion` WRITE;
/*!40000 ALTER TABLE `multipleboletasalidarecepcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `multipleboletasalidarecepcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipio` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  `ID_Estado` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES (1,'Compostela',1,1,'2019-07-17','10:15:44','','',1,1,1),(2,'Ruíz',1,1,'2019-07-17','10:16:08','','',1,1,1),(3,'San Blas',1,1,'2019-07-17','10:16:23','','',1,1,1),(4,'Tepic',1,1,'2019-07-17','10:16:41','','',1,1,1),(5,'Xalisco',1,1,'2019-07-17','10:16:58','','',1,1,1);
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nativofauna`
--

DROP TABLE IF EXISTS `nativofauna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nativofauna` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nativofauna`
--

LOCK TABLES `nativofauna` WRITE;
/*!40000 ALTER TABLE `nativofauna` DISABLE KEYS */;
INSERT INTO `nativofauna` VALUES (1,'Venado',1,1,'2019-08-13','12:00:08','','',1,2),(2,'Venado',1,1,'2019-08-28','14:13:20','','',1,1),(3,'Jaguar',1,1,'2019-10-03','12:29:52','','',1,1),(4,'Zorrillo',1,1,'2019-10-03','12:30:00','','',1,1),(5,'Tejon',1,1,'2019-10-03','12:30:08','','',1,1),(6,'Coyote',1,1,'2019-10-03','12:30:14','','',1,1),(7,'Conejo',1,1,'2019-10-03','12:30:20','','',1,1),(8,'Vibora',1,1,'2019-10-03','12:30:27','','',1,1),(9,'Ardilla',1,1,'2019-10-03','12:30:32','','',1,1),(10,'Tigre',1,1,'2019-10-03','12:30:38','','',1,1),(11,'Chachalaca',1,1,'2019-10-03','12:30:49','','',1,1),(12,'Jabali',1,1,'2019-10-03','12:30:55','','',1,1),(13,'Pajaro Bobo',1,1,'2019-10-03','12:31:06','','',1,1),(14,'Aguila',1,1,'2019-10-03','12:31:13','','',1,1),(15,'Leon',1,1,'2019-10-03','12:31:17','','',1,1);
/*!40000 ALTER TABLE `nativofauna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nativoflora`
--

DROP TABLE IF EXISTS `nativoflora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nativoflora` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nativoflora`
--

LOCK TABLES `nativoflora` WRITE;
/*!40000 ALTER TABLE `nativoflora` DISABLE KEYS */;
INSERT INTO `nativoflora` VALUES (1,'Agrimonia',1,1,'2019-08-12','15:15:28','','',1,1),(2,'Palo Blanco',1,1,'2019-08-12','15:15:39','','',1,1),(3,'Pino',1,1,'2019-08-12','15:15:45','','',1,1),(4,'Aliso',1,1,'2019-08-12','15:15:52','','',1,1),(5,'Ceiba',1,1,'2019-08-12','15:15:59','','',1,1),(6,'Roble',1,1,'2019-08-12','15:16:06','','',1,1),(7,'Encino',1,1,'2019-08-12','15:16:13','','',1,1),(8,'Enebro',1,1,'2019-08-12','15:16:20','','',1,1),(9,'Pastizales',1,1,'2019-08-12','15:16:31','','',1,1),(10,'Huanacastle',1,1,'2019-08-12','15:16:41','','',1,1),(11,'Tuno Roso',1,1,'2019-08-12','15:17:04','','',1,1),(12,'Girasoles',1,1,'2019-08-12','15:17:11','','',1,1);
/*!40000 ALTER TABLE `nativoflora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  `ISO` varchar(3) NOT NULL,
  `UE` varchar(3) NOT NULL,
  `OIC` varchar(3) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'México',1,1,'2019-07-17','10:10:46','','',1,1,'','','');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcelas`
--

DROP TABLE IF EXISTS `parcelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parcelas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `tipoPersona` varchar(5) NOT NULL,
  `clave_parcela` varchar(45) NOT NULL,
  `clave_certificacion` varchar(5) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `altura` varchar(45) NOT NULL,
  `area` varchar(45) NOT NULL,
  `numCafetos` int(11) NOT NULL,
  `id_pais` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  `id_municipio` int(11) NOT NULL,
  `id_localidad` int(11) NOT NULL,
  `id_sociedad` int(11) NOT NULL,
  `Id_tipoSuelo` int(11) DEFAULT NULL,
  `Id_tipoSombra` int(11) DEFAULT NULL,
  `Sector` varchar(20) DEFAULT NULL,
  `Id_sistemaProduccion` varchar(20) DEFAULT NULL,
  `Edad` varchar(10) DEFAULT NULL,
  `longitud` varchar(30) NOT NULL,
  `latitud` varchar(30) NOT NULL,
  `observaciones` varchar(250) DEFAULT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=662 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcelas`
--

LOCK TABLES `parcelas` WRITE;
/*!40000 ALTER TABLE `parcelas` DISABLE KEYS */;
INSERT INTO `parcelas` VALUES (1,2,'1','CG01P09494','AB','Crucero Del Pintadeño','0','0',0,1,1,4,17,1,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-07-14','10:13:20','','',1,1),(2,2,'1','CG01P09496','AB','El Tanque','0','0',0,1,1,4,17,1,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-07-14','10:13:56','','',1,1),(3,2,'1','CG01P09500','AB','Los Pericos','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:14:40','','',1,1),(4,3,'1','CG01P22441','AD','Los Tanques','904','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:21:43','','',1,1),(5,4,'1','CG01P09507','AB','El Astal','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:29:49','','',1,1),(6,5,'1','CG01P09532','AB','Astal','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:35:38','','',1,1),(7,5,'1','CG01P09533','AB','El Pozo De Tirzo','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:36:17','','',1,1),(8,6,'1','CG01P09495','AD','El Tanque','0','1.54',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:40:43','','',1,1),(9,6,'1','CG01P09499','AD','El Zapote','0','1.02',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:41:21','','',1,1),(10,6,'1','CG01P09504','AD','El Tanque II','0','0.80',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:42:21','','',1,1),(11,9,'1','CG01P09490','AD','El Astal','933','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:52:56','','',1,1),(12,9,'1','CG01P09491','AD','El Tepetitle','1033','1.45',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','10:53:42','','',1,1),(13,10,'1','CG01P09520','AD','Perla','969','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:01:42','','',1,1),(14,11,'1','CG01P09538','AD','El Astal','865','0.80',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:05:01','','',1,1),(15,11,'1','CG01P09564','AD','Palo Solo','980','2',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:05:38','','',1,1),(16,12,'1','CG01P16545','AB','El Palo Solo','988','0.58',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:14:16','','',1,1),(17,12,'1','TEMP140721','AB','Tepetitle','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:20:03','','',1,1),(18,13,'1','CG01P09487','AB','El Tanque I','980','2.59',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:23:40','','',1,1),(19,13,'1','CG01P09489','AB','El Tanque II','1063','4.92',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:24:40','','',1,1),(20,15,'1','CG01P22251','AB','El Beneficio','806','0.49',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:31:05','','',1,1),(21,16,'1','703803478','AB','Tepetitle','1046','0.93',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:37:00','','',1,1),(22,17,'1','CG01P09577','AB','La Perla','0','0.91',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:39:30','','',1,1),(23,17,'1','CG01P09578','AB','Cerro De Pericos','0','7.48',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:40:11','','',1,1),(24,18,'1','CG01P09481','AD','Palo Solo','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:43:25','','',1,1),(25,18,'1','CG01P09482','AD','El Crucero Del Pintadeño','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:43:59','','',1,1),(26,18,'1','CG01P09484','AD','El Sapote','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:44:31','','',1,1),(27,19,'1','CG01P09517','AB','Cerro Bola','960','1.73',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:49:23','','',1,1),(28,19,'1','CG01P24640','AB','Las Avestruces','882','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:50:02','','',1,1),(29,20,'1','CG01P22133','AD','Guayabos','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:53:23','','',1,1),(30,20,'1','CG01P24642','AD','La Lima','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:53:48','','',1,1),(31,20,'1','CG01P24682','AD','Cerro De Pericos','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','11:54:21','','',1,1),(32,21,'1','CG01P09505','AD','Tepetilte','1009','5.13',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:02:38','','',1,1),(33,22,'1','TEMP88','AB','Tepetilte','0','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:09:38','','',1,1),(34,23,'1','CG01P09536','AD','Cerro De La','1201','1.56',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:12:38','','',1,1),(35,23,'1','CG01P23753','AD','Don Carlos','894','2.96',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:13:16','','',1,1),(36,24,'1','CG01P22132','AB','Cerro De La Yesca','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:24:56','','',1,1),(37,24,'1','TEMP86','AB','Pozo De Tirzo','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:25:39','','',1,1),(38,25,'1','CG01P09199','AB','El Beneficio','931','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:34:27','','',1,1),(39,26,'1','CG01P09570','AB','El Pozo De','1053','1.70',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:37:20','','',1,1),(40,28,'1','CG01P09543','AD','El Tanque','0','1.83',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:47:54','','',1,1),(41,30,'1','CG01P09681','AB','Tepetilte','997','1.49',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-14','12:57:27','','',1,1),(42,31,'1','CG1P09682','AB','El Coyote','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','10:03:36','','',1,1),(43,35,'1','TEMP111','AB','Palo Solo','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','10:25:02','','',1,1),(44,37,'1','CG01P24682T','AB','Cerro Los Pericos','906','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','10:34:46','','',1,1),(45,38,'1','CG01P09685','AB','Cerro De La Yerba','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:18:39','','',1,1),(46,38,'1','CG01P09686','AB','Tepetilte','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:19:18','','',1,1),(47,39,'1','CG01P09486','AB','Tepetilte','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:30:32','','',1,1),(48,40,'1','CG01P09515','AB','La Rinconada','0','3',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:33:00','','',1,1),(49,41,'1','TEMP333','AD','Tepetitle','0','0',0,1,1,4,17,1,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-07-15','12:41:14','','',1,1),(50,42,'1','CG01P09680','AB','La Perla','902','0.74',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:44:56','','',1,1),(51,43,'1','CG01P09492','AB','El Cerro Del Perico','1223','1.99',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:46:48','','',1,1),(52,43,'1','CG01P09493','AB','El Pozo De Tirzo','1019','0.57',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:47:25','','',1,1),(53,44,'1','TEMP1507211','AD','Tepetilte','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:52:27','','',1,1),(54,44,'1','TEMP1507212','AD','Las Canitas','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:53:20','','',1,1),(55,44,'1','TEMP1507213','AB','Astal','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:53:50','','',1,1),(56,45,'1','CG01P09512','AB','Beneficio','829','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:58:12','','',1,1),(57,45,'1','CG01P09513','AB','El Tepetilte','1070','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:58:57','','',1,1),(58,45,'1','CG01P23750','AB','Carranza','923','0.36',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','12:59:37','','',1,1),(59,46,'1','CG01P09574','AB','La Primer Curva','1031','1.1',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:13:21','','',1,1),(60,46,'1','CG01P09575','AB','La Amarilla','888','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:14:00','','',1,1),(61,47,'1','CG01P09561','AB','Cerro De La Yerba','990','1.90',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:16:47','','',1,1),(62,47,'1','CG01P09562','AB','Cerro De Perillo','1000','1.96',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:17:26','','',1,1),(63,47,'1','CG01P09563','AB','El Pozo De Tirzo','1073','2',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:18:09','','',1,1),(64,48,'1','CG01P22244','AB','El Palo Solo','852','0.78',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:20:43','','',1,1),(65,49,'1','CG01P09615','AB','La Tigra','999','2',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:27:19','','',1,1),(66,50,'1','CG01P09587','AB','La Tigra','0','0.50',0,1,1,5,23,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:32:49','','',1,1),(67,50,'1','CG01P10301','AB','Canolitas','1043','1.09',1050,1,1,5,23,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:34:00','','',1,1),(68,50,'1','CG01P22438','AB','El Beneficio','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:34:38','','',1,1),(69,50,'1','TEMP1507214','AB','Tepetilte','0','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','13:35:22','','',1,1),(70,51,'1','CG01P09583','AB','La Tigra','1012','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','14:19:39','','',1,1),(71,51,'1','CG10P22250','AB','Beneficio','800','0.50',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','14:59:27','','',1,1),(72,52,'1','TEMP87','AB','Palo Solo','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:01:14','','',1,1),(73,53,'1','CG01P09591','AB','El Beneficio','822','1.03',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:03:19','','',1,1),(74,53,'1','CG01P23748','AB','El Beneficio II','897','0.25',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:04:07','','',1,1),(75,54,'1','TEMP85','AD','Cerro Pericos','0','1.20',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:07:18','','',1,1),(76,55,'1','CG01P09592','AB','La Porqueriza','892','1.24',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:09:44','','',1,1),(77,55,'1','CG01P09595','AB','El Astal','893','2.39',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:10:21','','',1,1),(78,56,'1','TEMP82','AB','La Tarjea','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:23:36','','',1,1),(79,57,'1','CG01P09576','AD','Curva Del V','1068','0.59',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:26:41','','',1,1),(80,58,'1','TEMPC3','AB','Cerro Perico','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:31:06','','',1,1),(81,58,'1','TEMPC4','AB','Cerro Bola','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:31:40','','',1,1),(82,59,'1','2019011801','AD','El Pozo De Tirzo','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:34:03','','',1,1),(83,61,'1','CG01P09488','AB','La Perla','1015','2',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:48:42','','',1,1),(84,61,'1','CG01P21692','AB','Astal','890','0.75',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-15','15:49:13','','',1,1),(85,62,'1','CG01P02522','AC','El Crucero','1102','2.59',3000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-16','10:31:38','','',1,1),(86,62,'1','CG01P02523','AC','La Magnolia','1066','0.33',600,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-16','10:32:10','','',1,1),(87,62,'1','CG01P02524','AC','El Barranco','908','1',1000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-16','10:32:40','','',1,1),(88,63,'1','CG01P02464','AC','Crucero','1168','1.57',1700,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','09:43:39','','',1,1),(89,64,'1','CG01P02916','AC','El Barranco','944','0.72',950,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:11:04','','',1,1),(90,64,'1','CG01P02917','AC','Faizan','832','0.68',1000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:11:48','','',1,1),(91,64,'1','CG01P02918','AC','La Tarjea','978','0.84',3000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:12:24','','',1,1),(92,65,'1','CG01P02559','AB','Chapulin','985','0.41',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:16:45','','',1,1),(93,65,'1','CG01P02594','AB','Trompetas','1147','0.50',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:17:21','','',1,1),(94,65,'1','CG01P02595','AB','Trompetas II','1065','0.77',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:18:04','','',1,1),(95,65,'1','CG01P02596','AB','Hastal','859','0.50',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:18:40','','',1,1),(96,66,'1','CG01P02939','AB','La Tarjea','0','0.50',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:28:22','','',1,1),(97,66,'1','CG01P02940','AB','Magnolia','0','0.50',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:28:58','','',1,1),(98,66,'1','CG01P02943','AB','Patagona','0','0.50',0,1,1,5,23,2,0,0,'Seleccione','0','','0','00','',1,1,'2021-07-17','10:29:35','','',1,1),(99,67,'1','CG01P03853','AB','La Magnolia','0','1',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:32:17','','',1,1),(100,67,'1','CG01P03854','AB','La Patagonia','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:32:41','','',1,1),(101,67,'1','CG01P03856','AB','La Tarjea','0','1',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','10:33:11','','',1,1),(102,69,'1','TEMP96','AB','El Barrial','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','12:24:14','','',1,1),(103,70,'1','TEMP98','AB','La Soledad','0','1.08',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','12:29:16','','',1,1),(104,70,'1','TEMP99','AB','Las Trompetas','0','0.50',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','12:29:52','','',1,1),(105,71,'1','TEMP100','AB','El Astal','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','12:32:09','','',1,1),(106,72,'1','TEMP101','AB','La Soledad','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-17','12:38:20','','',1,1),(107,75,'1','CG01P03825','AB','Higuerilla','922','0.50',500,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','12:54:45','','',1,1),(108,75,'1','CG01P03826','AB','Los Llanitos','1238','1.28',1300,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','12:55:31','','',1,1),(109,76,'1','CG01P07204','AB','Piedras Negras','7.98','2.99',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','12:58:42','','',1,1),(110,76,'1','CG01P07206','AB','Escaleritas','920','0.34',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','12:59:24','','',1,1),(111,76,'1','TEMP95','AB','Guamaritas','900','2.5',5000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','13:00:05','','',1,1),(112,77,'1','TEMP94','AB','Piedras Negras','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:21:59','','',1,1),(113,78,'1','CG01P02579','AB','Escaleritas','963','1.31',2000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:26:06','','',1,1),(114,79,'1','CG01P02853','AB','Escaleritas','946','0.38',300,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:28:21','','',1,1),(115,79,'1','CG01P02855','AB','Puente','890','1.24',700,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:28:59','','',1,1),(116,80,'1','TEMP09','AB','Guamaritas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:33:10','','',1,1),(117,81,'1','P18000062','AC','El Barranco','959','1.04',2000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:45:12','','',1,1),(118,82,'1','CG01P02859','AC','Las Trompetas','1105','1.44',2000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:53:37','','',1,1),(119,82,'1','CG01P02860','AC','Los Llanitos','1307','1.56',3000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:54:14','','',1,1),(120,82,'1','CG01P03855','AC','Los Llanitos II','1296','1.56',3000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:54:57','','',1,1),(121,83,'1','CG01P02856','AC','Guamaritas','1088','377',3000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:57:25','','',1,1),(122,83,'1','CG01P02857','AC','Oreja Del Raton','905','0.78',900,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','14:58:09','','',1,1),(123,84,'1','TEMP97','AB','Oreja Del Raton','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:04:53','','',1,1),(124,85,'1','CG01P02461','AB','Escaleras','947','0.49',1500,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:07:41','','',1,1),(125,85,'1','CG01P23901','AB','El Puente','816','0.43',3000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:08:24','','',1,1),(126,86,'1','CG01P10282','AB','El Barranco','923','1',1500,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:17:12','','',1,1),(127,87,'1','C0160180057','AB','Los Llanitos','0','1',2000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:31:03','','',1,1),(128,88,'1','F016P018G008A0038','AC','El Barranco','1050','2',2200,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:33:03','','',1,1),(129,88,'1','TEMP03','AC','Las Trompetas','0','0.75',900,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:39:43','','',1,1),(130,89,'1','20190507','AB','La Cachucha','0','1.50',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:43:53','','',1,1),(131,89,'1','F016P018G008A0039','AC','Los Llanitos','0','1',1000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:44:21','','',1,1),(132,90,'1','CG01P07200','AB','El Crucero','1047','0.60',1000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-19','15:51:50','','',1,1),(133,91,'1','CG01P02915','AB','Los Llanitos','1272','0.69',800,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','08:49:50','','',1,1),(134,91,'1','TEMP07','AB','La Tarjea','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','08:50:21','','',1,1),(135,92,'1','CG01P02913','AC','Barranco','960','3.15',9000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','08:53:23','','',1,1),(136,93,'1','CG01P02921','AB','La Peña','869','1.22',2200,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','08:55:23','','',1,1),(137,93,'1','TEMP08','AB','Canolitas','1102','0.66',1300,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','08:56:04','','',1,1),(138,94,'1','CG01P02919','AB','Los Llanitos','1259','0.87',700,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:19:01','','',1,1),(139,94,'1','CG01P02920','AC','El Barranco','295','.57',3000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:19:45','','',1,1),(140,95,'1','CG01P02580','AC','Barrial','1100','0.97',2120,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:30:36','','',1,1),(141,95,'1','CG01P02581','AB','La Tarjea','1067','0.61',1983,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:31:28','','',1,1),(142,96,'1','CG01P03851','AB','Puente','0','0.50',1024,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:34:04','','',1,1),(143,96,'1','CG01P03852','AB','Trompetas','1069','0.78',3000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:34:50','','',1,1),(144,97,'1','CG01P07598','AB','El Puente','891','2',1000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:36:52','','',1,1),(145,97,'1','CG01P23891','AB','La Loma','977','0.50',500,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:37:27','','',1,1),(146,97,'1','CG01P23892','AB','Bermejo','1007','1.20',3500,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:37:59','','',1,1),(147,98,'1','CG01P02922','AB','Canollitas','1102','0.99',1300,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:43:19','','',1,1),(148,98,'1','CG01P07209','AC','La Peña','869','0.98',800,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:43:53','','',1,1),(149,98,'1','TEMP06','AB','El Barranco','1100','0.98',700,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','09:44:23','','',1,1),(150,99,'1','F016P018G008AJC15','AC','Crucero','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','10:20:30','','',1,1),(151,99,'1','TEMP04','AB','Crucero II','1200','1',1000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','10:21:19','','',1,1),(152,100,'1','TEMP329','AB','Los Llanitos','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','10:23:53','','',1,1),(153,101,'1','CG01P02894','AB','Oreja Del Raton','978','0.48',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','10:28:39','','',1,1),(154,101,'1','CG01P02895','AC','Escaleritas','1009','0.40',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','10:29:12','','',1,1),(155,102,'1','CPTEMP210322','AB','Tarjea','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:02:03','','',1,1),(156,103,'1','CG01P02861','AC','La Patagonia','1222','1.36',1000,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:09:15','','',1,1),(157,104,'1','TEMP48','AB','Guamaritas','0','0.23',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:17:39','','',1,1),(158,105,'1','CPTEMP1701211','AB','Escaleritas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:22:46','','',1,1),(159,106,'1','TEMP2102181','AB','Guasimas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:27:42','','',1,1),(160,106,'1','TEMP2102182','AB','Guamaritas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:28:06','','',1,1),(161,106,'1','TEMP2102183','AB','Cuamil De Valles','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:28:44','','',1,1),(162,106,'1','TEMP2102184','AB','Ahuacate','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:29:15','','',1,1),(163,107,'1','TEMP2102186','AB','Magnolia','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:32:05','','',1,1),(164,107,'1','TEMP2102187','AB','Guamaritas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:32:27','','',1,1),(165,107,'1','TEMP2102188','AB','Guasimas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:33:35','','',1,1),(166,108,'1','TEMP21021810','AB','Escaleritas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:39:53','','',1,1),(167,108,'1','TEMP21021811','AB','La Sidra','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:40:23','','',1,1),(168,108,'1','TEMP21021812','AB','El Crucero','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:40:55','','',1,1),(169,108,'1','TEMP21021813','AB','Cuamil De Valles','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:41:38','','',1,1),(170,109,'1','CG01P02830','AB','Pisoneño','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:46:15','','',1,1),(171,109,'1','TEMP49','AB','Los Otatitos','0','0.22',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:48:25','','',1,1),(172,110,'1','TEMP2102191','AB','Escaleritas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:50:48','','',1,1),(173,110,'1','TEMP2102192','AB','La Cachucha','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:51:14','','',1,1),(174,110,'1','TEMP2102193','AB','Llanitos','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:51:59','','',1,1),(175,111,'1','TMEP2102196','AB','Otatitos','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','11:59:56','','',1,1),(176,112,'1','TEMP2102201','AB','Capulin','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:03:16','','',1,1),(177,112,'1','TEMP2102202','AB','Otatitos','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:03:40','','',1,1),(178,113,'1','TEMP2102221','AB','Arroyo Frio','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:07:15','','',1,1),(179,114,'1','TEMP2102222','AB','Capulin','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:10:48','','',1,1),(180,115,'1','TEMP2102224','AB','Sidra','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:16:10','','',1,1),(181,116,'1','TEMP2102226','AB','Escaleritas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:17:58','','',1,1),(182,117,'1','TEMP2102227','AB','Barrial','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:19:52','','',1,1),(183,118,'1','TEMP2102231','AB','Astal','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:21:55','','',1,1),(184,119,'1','TEMP2102233','AB','Guamaritas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:23:26','','',1,1),(185,120,'1','CG01P02928','AB','Los Charcos','0','0.68',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:26:17','','',1,1),(186,120,'1','CG01P02929','AB','El Pisoneño','0','0.38',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:26:54','','',1,1),(187,120,'1','CG01P02930','AB','La Tarjea','0','0.50',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:27:41','','',1,1),(188,121,'1','TEMP2102251','AB','El Mermejo','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:52:04','','',1,1),(189,122,'1','TEMP2102261','AB','Escaleritas','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:55:04','','',1,1),(190,123,'1','TEMP2102263','AB','Charcos','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','12:57:32','','',1,1),(191,124,'1','TEMP2103051','AB','Los Llanitos','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:05:38','','',1,1),(192,124,'1','TEMP210305','AB','La Tarjea','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:06:00','','',1,1),(193,125,'1','TEMP2103101','AB','Magnolia','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:11:24','','',1,1),(194,125,'1','TEMP2103102','Se','El Cafesal','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:12:04','','',1,1),(195,126,'1','CG01P02839','AB','La Cachucha','0','0.82',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:22:37','','',1,1),(196,126,'1','CG01P02840','AB','El Barranco','0','0.65',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:23:17','','',1,1),(197,126,'1','CG01P02841','AB','Trompetas','0','1.08',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:24:02','','',1,1),(198,126,'1','CG01P02842','AB','Los Limos','0','1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:25:19','','',1,1),(199,127,'1','TEMP2103191','AB','La Sidra','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:28:05','','',1,1),(200,128,'1','TEMP2103052','AB','Los Llanitos','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:34:20','','',1,1),(201,129,'1','TEMP2104071','AB','La Sidra','0','0',0,1,1,5,23,2,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','13:44:15','','',1,1),(202,131,'1','704047884','AB','Alejandro','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:25:17','','',1,1),(203,131,'1','CG01P04097','AB','Tepehuaje','909','0.49',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:25:51','','',1,1),(204,131,'1','CG01P04100','AB','Arroyo Seco','998','1.25',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:26:47','','',1,1),(205,131,'1','CG01P22091','AB','La Orilla Del Rancho','1051','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:27:22','','',1,1),(206,132,'1','CG01P03925','AB','La Higuera','977','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:30:42','','',1,1),(207,132,'1','CG01P03926','AB','La Cruz','1056','0.30',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:31:32','','',1,1),(208,133,'1','CG01P04099','AB','El Manguito','1067','2.74',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:39:25','','',1,1),(209,134,'1','TEMP286','AB','Guayabito','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:50:09','','',1,1),(210,134,'1','TEMP287','AB','Arroyos El Chocolon','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:51:46','','',1,1),(211,134,'1','TEMP288','AB','La Levadura','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:52:01','','',1,1),(212,135,'1','CG01P03955','AB','Los Llanitos','994','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:54:57','','',1,1),(213,135,'1','CG01P03957','AB','El Arroyo Seco','989','1.20',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:55:26','','',1,1),(214,135,'1','CG01P03958','AB','Los Colomos','859','0.25',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','14:56:19','','',1,1),(215,136,'1','CG01P03954','AB','El Arroyo Seco','1042','0.90',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:00:31','','',1,1),(216,137,'1','CG01P24051','AB','El Cerrito','892','1',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:10:00','','',1,1),(217,138,'1','CG01P03941','AB','El Arroyo Seco','1075','4.28',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:19:07','','',1,1),(218,138,'1','CG01P03942','AB','El Raton','1085','1.45',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:19:45','','',1,1),(219,138,'1','CG01P03943','AB','La Guamera','1069','3.29',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:20:35','','',1,1),(220,139,'1','CG01P03930','AB','La Astona','1012','1.90',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:28:39','','',1,1),(221,139,'1','CG01P03935','AB','El Pertigo','1038','0.49',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:29:10','','',1,1),(222,139,'1','CG01P03937','AB','Los Terrenos','1054','0.19',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:30:10','','',1,1),(223,139,'1','TEMP272','AB','El Sapote','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:30:42','','',1,1),(224,141,'1','CG01P03917','AB','La Cruz','1029','0.35',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:44:52','','',1,1),(225,141,'1','CG01P03919','AB','El Hobo','723','0.59',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:45:32','','',1,1),(226,141,'1','CG01P03921','AB','Los Colomos','1036','0.17',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','15:46:09','','',1,1),(227,142,'1','CG01P04096','AB','El Arroyo Seco','909','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','16:06:28','','',1,1),(228,143,'1','CG01P04093','AB','El Arroyo Seco','1054','1.07',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','16:17:14','','',1,1),(229,144,'1','TEMP277','AB','El Limon','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','16:22:44','','',1,1),(230,145,'1','TEMP278','AB','Banderita','0','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','16:25:37','','',1,1),(231,146,'1','CG01P08427','AB','Arroyo Hondo','1039','2.38',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-20','16:29:53','','',1,1),(232,147,'1','PCTEMPCV11','AB','La Dijunta','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:11:52','','',1,1),(233,148,'1','CG01P04058','AB','La Abuja','756','1.06',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:27:23','','',1,1),(234,149,'1','CG01P22051','AB','Los Cafeces','963','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:37:01','','',1,1),(235,149,'1','CG01P22914','AB','La Presa','986','1',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:37:28','','',1,1),(236,150,'1','CG01P03975','AB','El Chocolon','844','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:40:34','','',1,1),(237,151,'1','CG01P03992','AB','Difunta','1091','0.38',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:45:18','','',1,1),(238,151,'1','CG01P22387','AB','El Guamuchil','696','2',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:46:20','','',1,1),(239,152,'1','CG01P04076','AB','Ciruela','1069','0.80',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:51:50','','',1,1),(240,152,'1','CG01P04077','AB','Las Canelillas','985','0.31',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:52:42','','',1,1),(241,152,'1','CG01P04078','AB','Los Postes','964','0.23',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','09:54:29','','',1,1),(242,153,'1','CG01P08538','AB','Terrero','987','4.38',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','10:00:08','','',1,1),(243,154,'1','CPTEMPJC120221','AB','Pertigo','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','10:02:18','','',1,1),(244,155,'1','CG01P04034','AB','Los Terreros','859','0.25',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','10:20:42','','',1,1),(245,155,'1','CG01P04035','AB','El Arroyo Seco','934','0.70',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','10:21:20','','',1,1),(246,156,'1','CPTEMPCV1','AB','Los Sauces','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','10:25:52','','',1,1),(247,157,'1','TEMP305','AB','El Arroyo Seco','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:02:20','','',1,1),(248,158,'1','CG01P03939','AB','El Pertigo','1061','1.95',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:04:59','','',1,1),(249,159,'1','TEMP291','AB','La Banderita','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:15:52','','',1,1),(250,160,'1','CG01P03901','AB','Pertigo','1009','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:18:14','','',1,1),(251,160,'1','CG01P03903','AB','Difunta','1094','1.11',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:18:44','','',1,1),(252,161,'1','TEMP292','AB','La Presa','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:43:30','','',1,1),(253,162,'1','CG01P04007','AB','La Ahuacatera','1071','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:45:29','','',1,1),(254,162,'1','CG01P04008','AB','El Portigo','1069','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:45:56','','',1,1),(255,162,'1','CG01P08570','AB','Arroyo Seco','917','0.58',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:46:24','','',1,1),(256,162,'1','TEMP293','AB','La Huerta','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:46:47','','',1,1),(257,163,'1','TEMP294','AB','El Italiano','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:49:02','','',1,1),(258,164,'1','CG01P03972','AB','La Magnolia','1024','1.45',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:50:59','','',1,1),(259,165,'1','TEMP296','AB','El Rancho Viejo','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:53:08','','',1,1),(260,166,'1','TEMP297','AB','La Presa','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:55:35','','',1,1),(261,166,'1','TEMP298','AB','Los Canelillos','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:56:01','','',1,1),(262,167,'1','TEMP299','AB','El Guamuchil','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','11:58:00','','',1,1),(263,168,'1','CG01P08861','AB','La Levadura','999','0.83',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:00:21','','',1,1),(264,168,'1','CG01P08862','AB','Arroyo Del Chocolon','984','0.41',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:01:14','','',1,1),(265,168,'1','TEMP275','AB','Arroyo Seco','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:01:40','','',1,1),(266,169,'1','CG01P04059','AB','La Banderita','1055','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:03:49','','',1,1),(267,169,'1','CG01P24140','AB','Alejandro','1039','0.12',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:04:20','','',1,1),(268,169,'1','TEMP276','AB','La Abuja','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:04:45','','',1,1),(269,170,'1','TEMP300','AB','La Canada','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:06:54','','',1,1),(270,170,'1','TEMP301','AB','Las Taguacas','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:07:24','','',1,1),(271,171,'1','CG01P03908','AB','La Abuja','858','1.68',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:09:23','','',1,1),(272,172,'1','CG01P03997','AB','El Guamuchil','973','0.40',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:20:24','','',1,1),(273,172,'1','TEMP302','AB','Los Colomos','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','12:20:46','','',1,1),(274,150,'1','CG01P03973','AB','La Banderita','1100','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','13:23:57','','',1,1),(275,174,'1','TEMP210721','AB','El Pertigo','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-21','14:51:03','','',1,1),(276,175,'1','TEMP303','AB','La Guamera','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:21:02','','',1,1),(277,176,'1','CG01P22926','AB','Ojo De Agua','850','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:23:35','','',1,1),(278,176,'1','TEMP304','AB','El Chocolon','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:25:20','','',1,1),(279,177,'1','CG01P22390','AB','El Paranal','923','1.02',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:29:52','','',1,1),(280,177,'1','CG01P22392','AB','Palos Verdes','791','0.53',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:30:33','','',1,1),(281,177,'1','CG01P22395','AB','La Bajada Del Pleito','905','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:31:42','','',1,1),(282,178,'1','CG01P04048','AB','Las Pinas','918','1.15',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:35:55','','',1,1),(283,178,'1','CG01P04053','AB','La Dijunta','1050','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:36:42','','',1,1),(284,178,'1','CG01P04054','AB','El Pertigo','1039','0.79',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:37:22','','',1,1),(285,178,'1','CG01P04055','AB','El Pozo','986','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:37:57','','',1,1),(286,178,'1','TEMP307','AB','El Puente','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:38:22','','',1,1),(287,179,'1','TEMP308','Se','El Pertigo','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:41:16','','',1,1),(288,180,'1','TEMP271','AB','La Banderita','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:43:25','','',1,1),(289,180,'1','TEMP309','AB','Los Colomos','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:44:03','','',1,1),(290,181,'1','CG01P04092','AB','Canelillo','1029','2.44',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','10:46:37','','',1,1),(291,182,'1','TEMP310','AB','El Molino','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','11:48:18','','',1,1),(292,183,'1','TEMP311','AB','El Arroyo Seco','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','11:53:06','','',1,1),(293,184,'1','CG01P04030','AB','La Canada','1069','0.93',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','11:58:54','','',1,1),(294,184,'1','TEMP313','AB','El Tamalero','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','11:59:25','','',1,1),(295,185,'1','TEMP314','AB','Las Ciruelas','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','12:01:30','','',1,1),(296,186,'1','TEMP315','AB','El Ciruelo','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','12:07:30','','',1,1),(297,186,'1','TEMPC1','AB','La Bajada Del Chocolon','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','12:07:59','','',1,1),(298,186,'1','TEMPC2','AB','Los Canelillos','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','12:08:24','','',1,1),(299,186,'1','TEMPC','AB','La Presa','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','12:10:13','','',1,1),(300,187,'1','TEMP280','AB','La Banderita','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','12:12:41','','',1,1),(301,187,'1','TEMP281','AB','Arroyo Seco','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','12:12:59','','',1,1),(302,187,'1','TEMP282','AB','El Huanacastle','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','12:13:49','','',1,1),(303,188,'1','CG01P04011','AB','Los Colomos','1009','0.25',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:14:52','','',1,1),(304,188,'1','CG01P04021','AB','La Bajada Del Pleito','895','0.55',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:15:25','','',1,1),(305,188,'1','TEMP317','AB','La Bajada Del Chocolon','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:16:02','','',1,1),(306,188,'1','TEMP318','AB','El Club','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:16:20','','',1,1),(307,189,'1','TEMP319','AB','El Italiano','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:17:56','','',1,1),(308,190,'1','CG01P03950','AB','El Pertigo','1042','1.46',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:19:48','','',1,1),(309,190,'1','CG01P04087','AB','El Pertigo II','1014','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:20:17','','',1,1),(310,190,'1','TEMP289','AB','El Cerrito','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:20:47','','',1,1),(311,191,'1','CG01P03916','AB','La Banderita','1055','1.58',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:22:26','','',1,1),(312,191,'1','CG01P03918','AB','La Guamera','972','0.58',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:23:18','','',1,1),(313,191,'1','CG01P03920','AB','La Palma','1044','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:23:45','','',1,1),(314,192,'1','CG01P03914','AB','Los Canelillos','997','2.15',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:25:35','','',1,1),(315,193,'1','CG01P03907','AB','Abuja','768','1.19',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:28:13','','',1,1),(316,193,'1','CG01P04098','AB','La Difunta','1004','0.72',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:29:15','','',1,1),(317,194,'1','CG01P03973*','AB','La Banderita','1100','0.25',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:40:13','','',1,1),(318,194,'1','CG01P03974','AB','La Bajada Del Chocolon','974','1',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:41:41','','',1,1),(319,194,'1','CG01P03976','AB','El Tepehuaje','1029','0.38',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:42:09','','',1,1),(320,194,'1','CG01P03978','AB','Palos Verdes','790','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:42:36','','',1,1),(321,194,'1','CG01P24621','AB','La Ahuja','883','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:43:08','','',1,1),(322,195,'1','CG01P03947','AB','El Pertigo','1025','4.55',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:45:54','','',1,1),(323,195,'1','CG01P03948','AB','La Quartilla','885','0.90',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:46:33','','',1,1),(324,195,'1','CG01P03949','AB','El Tanque','932','2.04',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:47:08','','',1,1),(325,196,'1','CG01P04004','AB','El Pertigo','1083','0.89',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:49:05','','',1,1),(326,196,'1','CG01P04023','AB','La Cruz','1024','1',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:49:33','','',1,1),(327,197,'1','CG01P22092','AB','El Chocolon','978','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:51:25','','',1,1),(328,197,'1','TEMP210722','AB','El Italiano','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:58:23','','',1,1),(329,197,'1','TEMP320','AB','El Arroyo Seco','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','14:58:46','','',1,1),(330,198,'1','CG01P03953','AB','El Guamito','894','2',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','15:00:30','','',1,1),(331,198,'1','CG01P22385','AB','Las Higueras','978','3',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','15:00:57','','',1,1),(332,199,'1','TEMP321','AB','Elastona','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','15:07:32','','',1,1),(333,201,'1','CG01P03985','AB','El Chocolon','809','0.25',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','15:15:54','','',1,1),(334,201,'1','CG01P04094','AB','Pertigo','1064','1.65',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','15:16:22','','',1,1),(335,201,'1','CG01P04095','AB','La Presa','911','0.99',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','15:16:43','','',1,1),(336,202,'1','TEMP322','AB','La Banderita','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','15:18:09','','',1,1),(337,203,'1','CG01P04000','AB','Los Terrenos','1003','1.28',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','15:24:15','','',1,1),(338,203,'1','TEMP274','AB','La Difunta','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-22','15:24:33','','',1,1),(339,204,'1','CG01P04047','AB','El Pertigo','1053','1.97',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','08:55:45','','',1,1),(340,204,'1','CG01P22397','AB','La Hasta Hueca','793','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','08:56:16','','',1,1),(341,205,'1','CG01P04050','AB','Los Terrenos','1062','1.85',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','08:58:24','','',1,1),(342,205,'1','CG01P04051','AB','La Presa','912','1.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','08:58:47','','',1,1),(343,205,'1','CG01P04052','AB','El Pertigo','958','0.50',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','08:59:21','','',1,1),(344,205,'1','TEMP285','AB','La Higuera','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','08:59:45','','',1,1),(345,206,'1','CG01P03964','AB','Los Cafeces','912','1.40',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:02:26','','',1,1),(346,207,'1','TEMP323','AB','El Arroyo Seco','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:04:10','','',1,1),(347,208,'1','CPTEMPCV12','AB','La Dijunta','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:10:01','','',1,1),(348,208,'1','TEMP327','AB','Los Canelillos','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:10:25','','',1,1),(349,208,'1','TEMP328','AB','La Toma','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:10:47','','',1,1),(350,209,'1','TEMP306','AB','El Ocote Del Rayo','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:12:20','','',1,1),(351,209,'1','TEMP324','AB','El Arroyo Ondo','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:12:44','','',1,1),(352,209,'1','TEMP325','AB','La Higuerita','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:13:12','','',1,1),(353,212,'1','CPTEMPCV13','AB','La Dijunta','0','0',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:19:21','','',1,1),(354,213,'1','CG01P03956','AB','La Abuja','855','2.10',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:25:11','','',1,1),(355,213,'1','CG01P04036','AB','La Canada','1047','0.63',0,1,1,5,22,5,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:26:02','','',1,1),(356,214,'1','CG01P05293','AC','Mujarra','424','1.02',0,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:47:25','','',1,1),(357,214,'1','CG01P24251','AC','Banco Colorado','967','1.15',2300,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:48:05','','',1,1),(358,215,'1','CG01P05271','AC','Guajolote','743','3.92',7840,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','09:54:12','','',1,1),(359,216,'1','CG01P05184','AC','Banco Colorado','804','3.34',6560,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','10:36:40','','',1,1),(360,217,'1','CG01P05277','AC','Sombrero','831','2.93',860,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','10:39:52','','',1,1),(361,217,'1','GERM570504','AC','Cerro De Gualamo','909','1.0',0,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','10:40:26','','',1,1),(362,218,'1','CG01P05275','AC','Cerro De Los Cuernos','905','1.65',0,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','10:43:31','','',1,1),(363,218,'1','CG01P05278','AC','Sombrero','851','10.22',20440,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','10:44:21','','',1,1),(364,219,'1','CG01P05263','AC','Sombrero','883','2.8',5600,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','10:47:19','','',1,1),(365,220,'1','CG01P05185','AC','Banco Colorado','728','1.91',0,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','10:49:44','','',1,1),(366,221,'1','CG01P05274','AC','Banco Colorado','874','3.39',6780,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','10:52:29','','',1,1),(367,222,'1','CG01P05288','AC','Sombrero','957','4.82',9640,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','10:54:41','','',1,1),(368,223,'1','TEMP01','AC','Sombrero','980','3',0,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:03:24','','',1,1),(369,224,'1','CG01P05268','AC','Guajolote','668','2.15',4300,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:05:33','','',1,1),(370,225,'1','CG01P05294','AC','Guajolote','895','5.99',11980,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:07:43','','',1,1),(371,226,'1','TEMP02','AC','Guajolote','681','3.78',0,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:10:23','','',1,1),(372,227,'1','CG01P05183','AC','Sombrero','955','5.92',11840,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:18:50','','',1,1),(373,228,'1','CG01P05280','AC','Guajolote','699','2.62',5240,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:22:05','','',1,1),(374,229,'1','CG01P05279','AC','Sombrero','894','5.4',10800,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:24:40','','',1,1),(375,230,'1','CG01P05299','AC','Tempisque','5.28','1.82',3640,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:27:21','','',1,1),(376,231,'1','CG01P05261','AC','Banco Colorado','791','5.59',11180,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:30:52','','',1,1),(377,232,'1','CG01P05292','AC','Sombrero','925','4.2',8400,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:37:03','','',1,1),(378,233,'1','CG01P05300','AC','Sombrero','920','4.45',0,1,1,2,9,6,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','11:48:43','','',1,1),(379,234,'1','TEMP330','AB','El Guaco','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','13:17:11','','',1,1),(380,234,'1','TEMP331','AB','El Tajito','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','13:17:41','','',1,1),(381,235,'1','CG01P09089','AB','La Esperanza','790','0.86',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','13:24:37','','',1,1),(382,235,'1','CPTEMPJC4','AB','Los Pretiles','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','13:25:03','','',1,1),(383,236,'1','CG01P09020','AB','San Bartolo','1042','0.25',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:07:23','','',1,1),(384,236,'1','CG01P09021','AB','Malinal Viejo','991','1.61',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:07:55','','',1,1),(385,236,'1','CG01P09022','AB','La Ladrillera','921','0.50',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:08:40','','',1,1),(386,237,'1','CG01P09029','AB','El Tunel','951','1.02',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:11:03','','',1,1),(387,237,'1','CG01P09030','AB','La Yunta','598','0.50',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:11:38','','',1,1),(388,237,'1','CG01P09031','AB','El Salto','945','3.72',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:12:08','','',1,1),(389,238,'1','CG01P08258','AB','La Patagona','979','1.32',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:14:28','','',1,1),(390,238,'1','CPTEMPJC3','AB','La Llamacoa','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:14:50','','',1,1),(391,238,'1','CPTEMPJC5','AB','San Bartolo','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:15:08','','',1,1),(392,239,'1','CG01P04209','AB','La Esperanza','827','2.30',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:17:20','','',1,1),(393,239,'1','CPTEMPJC160221','AB','San Bartolo','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:17:40','','',1,1),(394,240,'1','CG01P08280','AB','Los Fresnos','1053','1.79',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:51:23','','',1,1),(395,240,'1','CG01P08281','AB','Laberintos','1005','3.70',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:52:53','','',1,1),(396,240,'1','CG01P08282','AB','Arroyo Del Malinal','732','0.21',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','14:55:11','','',1,1),(397,241,'1','CG01P09008','AB','Los Fresnos','901','3.29',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','15:51:40','','',1,1),(398,241,'1','CG01P09009','AB','La Himalaco','957','0.57',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','15:52:50','','',1,1),(399,242,'1','CG01P04255','AB','Capulin','648','4.14',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','15:58:25','','',1,1),(400,242,'1','CG01P04256','AB','San Bartolo','1039','0.50',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','15:59:18','','',1,1),(401,242,'1','CG01P04257','AB','Laberinto','1005','0.25',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','15:59:44','','',1,1),(402,242,'1','CG01P04258','AB','La Esperanza','835','0.25',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:00:08','','',1,1),(403,242,'1','CPTEMPJC2','AB','La Guamera','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:00:33','','',1,1),(404,243,'1','CG01P09050','AB','Los Fresnos','1041','1.22',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:07:52','','',1,1),(405,244,'1','CG01P04104','AB','El Tunel','943','1.17',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:09:25','','',1,1),(406,244,'1','CG01P04105','AB','Los Fresnos','1093','0.70',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:09:50','','',1,1),(407,245,'1','CG01P09054','AB','Los Fresnos','1085','0.77',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:13:53','','',1,1),(408,246,'1','TEMP210723','AB','La Jabalina','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:16:54','','',1,1),(409,246,'1','TEMP332','AB','Los Pretiles','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:17:50','','',1,1),(410,247,'1','CG01P04106','AB','San Geronimo','527','2.58',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:21:26','','',1,1),(411,247,'1','CPTEMP202121JC','AB','Los Fresnos','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-23','16:21:44','','',1,1),(412,251,'1','CPTEMPJC1602213','AB','El Tunel','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','11:28:48','','',1,1),(413,252,'1','CPTEMPJC090321','AB','El Refugio','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','11:41:52','','',1,1),(414,252,'1','TEMP120','AB','Ciencinco','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','11:42:16','','',1,1),(415,252,'1','TEMP121','AB','Sampallo','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','11:42:34','','',1,1),(416,253,'1','TEMP56','Se','La Gloria','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','11:49:46','','',1,1),(417,254,'1','TEMP64','AB','Raton','0','1.0',0,1,1,5,25,11,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-07-24','11:53:55','','',1,1),(418,255,'1','TEMP68','AB','Los Fresnos','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','11:58:21','','',1,1),(419,255,'1','TEMP69','AB','Pata De Ganzo','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','11:58:42','','',1,1),(420,256,'1','TEMP130','AB','Pretiles','0','1',0,1,1,5,25,11,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-07-24','12:05:25','','',1,1),(421,258,'1','CPTEMPJC1','AB','El Tunel','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','12:09:59','','',1,1),(422,259,'1','CPTEMPJC130221','AB','Belenes','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','12:21:00','','',1,1),(423,259,'1','CPTEMPJC1302212','AB','El Raton','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','12:21:21','','',1,1),(424,259,'1','CPTEMPJC1602212','AB','El Tunel','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','12:22:26','','',1,1),(425,259,'1','CPTEMPJC6','AB','La Esperanza','0','0',0,1,1,5,25,11,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-24','12:24:02','','',1,1),(426,260,'1','TEMP30','AB','Guamaritas','0','1.5',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','09:28:23','','',1,1),(427,260,'1','TEMP31','AB','Las Trompetas','0','2',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','09:28:48','','',1,1),(428,260,'1','TEMP32','AB','Canoyitas','0','3',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','09:29:07','','',1,1),(429,261,'1','CG01P02506','AB','Patagona','0','1',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','10:17:21','','',1,1),(430,261,'1','CG01P02530','AB','Canollitas','0','1',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','10:17:48','','',1,1),(431,261,'1','CG01P02532','AB','Trompetas','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','10:18:13','','',1,1),(432,262,'1','TEMP52','AB','Los Cuarentas','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','10:26:36','','',1,1),(433,263,'1','CG01P02501','AB','La Sidra','1105','0.21',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','10:28:46','','',1,1),(434,263,'1','CG01P02531','AB','Magnolio','1145','3.45',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','10:34:13','','',1,1),(435,264,'1','TEMP53','AB','Canollitas','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','10:35:53','','',1,1),(436,265,'1','TEMP54','AB','Canollitas','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','10:39:53','','',1,1),(437,266,'1','CG01P02514','AB','La Loma','0','0.88',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:17:03','','',1,1),(438,266,'1','CG01P02515','AB','Descanso','829','0.24',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:17:28','','',1,1),(439,266,'1','CG01P02889','AB','Magnolia','1033','0.50',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:17:55','','',1,1),(440,266,'1','TEMP80','AB','Los Charcos','0','3',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:18:21','','',1,1),(441,267,'1','CG01P07182','AB','Canollitas','1041','1.48',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:23:06','','',1,1),(442,267,'1','CG01P07183','AB','Pozo','0','0.61',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:23:30','','',1,1),(443,267,'1','CG01P07184','AB','Higuerilla','0','1.23',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:23:59','','',1,1),(444,267,'1','CG01P07186','AB','Oreja Del Raton','968','0.57',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:24:32','','',1,1),(445,268,'1','TEMP55','AB','El Barranco','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:26:15','','',1,1),(446,269,'1','TEMP210726','AB','Guamaritas','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:39:35','','',1,1),(447,270,'1','CG01P09175','AB','Canollitas','1032','0.48',800,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:42:11','','',1,1),(448,271,'1','CG01P09200','AB','Las Baranas','0','4',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:43:45','','',1,1),(449,272,'1','CG01P02513','AB','Cuarenta','840','1.93',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:45:48','','',1,1),(450,272,'1','CG01P07168','AB','El Faizan','942','0.50',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:46:20','','',1,1),(451,273,'1','TEMP57','AB','Canollitas','0','1.98',1500,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:49:21','','',1,1),(452,274,'1','CG01P02500','AB','Canollitas','1072','2.29',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:52:20','','',1,1),(453,274,'1','CG01P02534','AB','Escalerita','976','0.72',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:52:52','','',1,1),(454,275,'1','TEMP58','AB','La Yuka','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:55:11','','',1,1),(455,276,'1','TEMP59','AB','El Sombrero','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:57:45','','',1,1),(456,277,'1','TEMP60','AB','La Yuka','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','11:59:14','','',1,1),(457,278,'1','TEMP61','AB','El Sombrero','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:00:56','','',1,1),(458,279,'1','TEMP62','AB','La Esperanza','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:02:28','','',1,1),(459,280,'1','TEMP63','AB','El Sombrero','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:11:11','','',1,1),(460,281,'1','CG01P10738','AB','La Esperanza','416','1',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:43:09','','',1,1),(461,282,'1','TEMP65','AB','El Sombrero','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:44:51','','',1,1),(462,283,'1','TEMP66','AB','La Esperanza','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:46:25','','',1,1),(463,284,'1','TEMP67','AB','El Sombrero','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:48:16','','',1,1),(464,285,'1','CG01P09393','AB','La Esperanza','433','0.33',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:50:03','','',1,1),(465,286,'1','TEMP70','AB','La Yuka','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:52:04','','',1,1),(466,287,'1','TEMP71','AB','La Esperanza','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:53:58','','',1,1),(467,288,'1','TEMP72','AB','La Yuka','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','12:55:37','','',1,1),(468,289,'1','TEMP73','AB','El Sombrero','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','13:17:03','','',1,1),(469,290,'1','TEMP74','AB','El Sombrero','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','13:18:48','','',1,1),(470,291,'1','TEMP75','AB','El Sombrero','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','13:20:26','','',1,1),(471,292,'1','CG01P09392','AB','La Yuka','354','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','13:21:56','','',1,1),(472,293,'1','TEMP77','AB','La Esperanza','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','13:23:38','','',1,1),(473,294,'1','TEMP78','AB','El Sombrero','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','13:25:18','','',1,1),(474,295,'1','TEMP79','AB','La Yuka','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:10:56','','',1,1),(475,296,'1','CG01P09379','AB','La Esperanza','265','0.50',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:12:44','','',1,1),(476,297,'1','CG01P24134','AB','El Pizoneno','1090','0.78',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:14:46','','',1,1),(477,298,'1','CG01P02507','AB','Las Trompetas','1082','0.67',0,1,1,5,23,8,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-07-26','14:16:53','','',1,1),(478,298,'1','CG01P10289','AB','Las Trompetas II','1010','0.92',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:17:23','','',1,1),(479,298,'1','CG01P10290','AB','El Pizoneno','1095','0.93',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:18:09','','',1,1),(480,298,'1','CG01P24134 II','AB','El Pizoneno II','1090','0.78',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:22:09','','',1,1),(481,299,'1','CG01P07172','AB','Otatito','790','0.50',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:24:16','','',1,1),(482,299,'1','CG01P07173','AB','Trompetas','1077','0.52',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:24:40','','',1,1),(483,300,'1','TEMP90','AB','El Solar','0','0.1',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:26:04','','',1,1),(484,300,'1','TEMP91','AB','Los Llanitos','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:26:20','','',1,1),(485,301,'1','CG01P02806','AB','El Bermejo','1001','0.50',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:27:54','','',1,1),(486,301,'1','CG01P02807','AB','El Barrial','956','0.74',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:28:24','','',1,1),(487,302,'1','CG01P07185','AB','La Higuerilla','940','1.99',0,1,1,5,23,8,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-07-26','14:30:22','','',1,1),(488,302,'1','CG01P07187','AB','Oreja Del Raton','966','0.57',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:30:53','','',1,1),(489,302,'1','CG01P07188','AB','Guamaritas','911','4',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:31:23','','',1,1),(490,302,'1','CG01P07189','AB','Escaleritas','946','0.88',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:31:48','','',1,1),(491,302,'1','CG01P07190','AB','La Magnolia','1108','0.51',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:32:12','','',1,1),(492,303,'1','CG01P08425','AB','Escaleritas','946','0.88',1300,1,1,5,23,8,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-07-26','14:34:43','','',1,1),(493,303,'1','CG01P08426','AB','La Higuerilla','911','4',5000,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:35:07','','',1,1),(494,304,'1','CG01P02556','AB','Los Charcos','0','0',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:38:28','','',1,1),(495,304,'1','TEMP35','Se','Canollitas','0','0.22',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:38:49','','',1,1),(496,304,'1','TEMP36','AB','El Panteon','0','0.22',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:39:11','','',1,1),(497,304,'1','TEMP37','AB','Guamaritas','0','1',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:39:26','','',1,1),(498,304,'1','TEMP38','AB','La Soledad','0','0.50',0,1,1,5,23,8,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-26','14:39:42','','',1,1),(499,305,'1','CG01P05717','AB','Agua Verde','780','13.95',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','09:06:39','','',1,1),(500,306,'1','CG01P05784','AB','Palo Solo','0','0',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','09:08:38','','',1,1),(501,307,'1','TEMP116','AB','La Higuera','0','20',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','09:11:26','','',1,1),(502,308,'1','TEMP117','AB','Cerro De Los Orcones','0','0',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','09:15:21','','',1,1),(503,309,'1','CG01P01425','AB','Palo Solo','852','0.66',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','10:40:20','','',1,1),(504,309,'1','CG01P05779','AB','Palo Solo II','907','0.50',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','10:40:44','','',1,1),(505,309,'1','CG01P07898','AB','Palo Solo III','853','4.26',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','10:41:26','','',1,1),(506,309,'1','CG01P08634','AB','Palo Solo IV','806','0.50',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','10:42:11','','',1,1),(507,310,'1','CG01P22872','AB','Agua Verde','0','3.60',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','10:46:18','','',1,1),(508,311,'1','TEMP118','AB','Palo Solo','0','0',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','10:47:54','','',1,1),(509,312,'1','CG01P05746','AB','Agua Verde','823','3.75',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','10:50:19','','',1,1),(510,312,'1','CG01P05747','AB','Palo Solo','954','4',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','10:50:57','','',1,1),(511,313,'1','CG01P08621','AB','Palo Solo','892','0.50',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','10:53:22','','',1,1),(512,314,'1','CG01P08626...','AB','La Pedregoza','833','3.49',0,1,1,3,12,9,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-07-27','10:56:21','','',1,1),(513,315,'1','TEMP210727','AB','La Pedregoza','0','0',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','11:00:33','','',1,1),(514,316,'1','CG01P05789','AB','Agua Verde','911','0.80',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','11:15:51','','',1,1),(515,316,'1','CG01P08620','AB','Palo Solo','660','0.50',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','11:23:14','','',1,1),(516,317,'1','CG01P05710','AB','La Pedregoza','754','1.48',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','11:26:30','','',1,1),(517,317,'1','CG01P08626','AB','La Pedregoza','833','3.49',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-07-27','12:09:15','','',1,1),(518,318,'1','CG01P05788','AB','Agua Verde','815','1',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','09:36:45','','',1,1),(519,318,'1','CG01P08629','AB','Palo Solo','950','3',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','09:37:32','','',1,1),(520,319,'1','TEMP122','AB','Palo Solo','0','0',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','09:42:23','','',1,1),(521,320,'1','CG01P07884','AB','El Tambor','572','3',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','09:50:32','','',1,1),(522,320,'1','CG01P08623','AB','El Parejo','556','0.5',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','09:51:27','','',1,1),(523,321,'1','CG01P01412','AB','Palo Solo','900','2.5',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','09:54:46','','',1,1),(524,321,'1','CG01P23948','AB','Palo Solo II','1000','1.75',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','09:55:34','','',1,1),(525,322,'1','CG01P05715','AB','Palo Solo','0','1.48',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','09:58:40','','',1,1),(526,322,'1','CG01P22866','AB','Palo Solo II','0','0.48',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','09:59:18','','',1,1),(527,323,'1','TEMP123','AB','La Pedregoza','0','3.13',0,1,1,3,12,9,0,0,'Seleccione','0','','0','00','',1,1,'2021-11-10','10:05:56','','',1,1),(528,324,'1','CG01P01417','AB','Palo Solo','956','1.75',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','10:49:10','','',1,1),(529,324,'1','CG01P07880','AB','Palo Solo II','929','2.25',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','10:49:49','','',1,1),(530,325,'1','CG01P05714','AB','Palo Solo','827','2.30',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','10:57:59','','',1,1),(531,326,'1','TEMP124','AB','Las Trancas','0','0',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:02:47','','',1,1),(532,327,'1','CG01P01420','AB','Palo Solo','888','3.09',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:06:06','','',1,1),(533,328,'1','CG01P07888','AB','Las Trancas','0','0.77',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:10:33','','',1,1),(534,329,'1','CG01P07821','AB','Agua Bendita','465','13.2',0,1,1,3,16,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:13:57','','',1,1),(535,330,'1','CG01P01533','AB','Barranca Honda','527','2.65',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:17:57','','',1,1),(536,330,'1','CG01P07890','AB','Parejo','554','1',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:18:27','','',1,1),(537,330,'1','CG01P08630','AB','Palo Solo','981','2',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:19:03','','',1,1),(538,330,'1','TEMP126','AB','La Pedregoza','0','1',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:19:35','','',1,1),(539,331,'1','CG01P07806','AB','Agua Bendita','421','2.97',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:22:50','','',1,1),(540,332,'1','CG01P10175','AB','La Cora','414','0.40',0,1,1,3,15,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:26:55','','',1,1),(541,333,'1','TEMP127','AB','La Barranquilla','0','0',0,1,1,3,16,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:36:59','','',1,1),(542,334,'1','CG01P05748','AB','Palo Solo','963','1.12',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:41:39','','',1,1),(543,334,'1','CG01P05758','AB','Palo Solo II','976','1.96',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:42:16','','',1,1),(544,334,'1','CG01P07887','AB','La Bulera','768','1.46',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:42:56','','',1,1),(545,335,'1','CG01P05756','AB','Palo Solo','952','1.20',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:47:02','','',1,1),(546,335,'1','CG01P07891','AB','Palo Solo II','1107','1.53',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:47:39','','',1,1),(547,335,'1','CG01P07892','AB','Palo Solo III','1003','0.25',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:48:24','','',1,1),(548,336,'1','CG01P05716','AB','Agua Verde','878','0.50',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:51:19','','',1,1),(549,337,'1','CG01P05709','AB','Agua Verde','786','9',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:54:34','','',1,1),(550,337,'1','TEMP128','AB','La Pedregoza','0','4',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:54:59','','',1,1),(551,338,'1','TEMP129','AB','La Pedregoza','0','0.55',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','11:58:31','','',1,1),(552,339,'1','CG01P05766','AB','Agua Sarca','835','0.88',0,1,1,3,12,9,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-10','12:01:55','','',1,1),(553,340,'1','CG01P02485','AC','La Cruz','876','0.50',1038,1,1,5,23,7,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-11-19','10:54:30','','',1,1),(554,340,'1','CG01P02486','AC','El Crucero','1222','0.98',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','10:57:20','','',1,1),(555,340,'1','CG01P02487','AC','La Patagonia','1226','0.67',1400,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','10:57:59','','',1,1),(556,340,'1','CPTEMP1702215','AC','Las Cruces','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','10:58:22','','',1,1),(557,341,'1','CG01P02494','AC','Arroyo Frio','965','0.4',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:27:49','','',1,1),(558,341,'1','CG01P02498','AC','El Triangulo','929','0.7',1460,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:28:30','','',1,1),(559,341,'1','CG01P02502','AC','Higuerilla','941','0.6',1196,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:29:11','','',1,1),(560,341,'1','CG01P02503','AC','Coamil De Valles','972','0.8',1620,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:30:05','','',1,1),(561,342,'1','TEMP10','AB','El Pozo','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:33:35','','',1,1),(562,342,'1','TEMP11','AB','Piedras Negras','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:33:58','','',1,1),(563,343,'1','CG01P04056','AB','La Telesecundaria','1105','0.40',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:36:50','','',1,1),(564,343,'1','CG01P04074','AB','Arroyo Frio','956','0.31',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:47:40','','',1,1),(565,343,'1','TEMP12','AB','El Solar','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:49:50','','',1,1),(566,344,'1','TEMP13','AB','La Tarjea','1200','2',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:52:28','','',1,1),(567,345,'1','CG01P03898','AB','Otatitos','781','1.02',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:54:54','','',1,1),(568,346,'1','CG01P02817','AB','La Patagona','1380','1.1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:58:12','','',1,1),(569,346,'1','CG01P02819','AB','Piedras Negras','824','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:58:48','','',1,1),(570,346,'1','CG01P02821','AB','La Soledad','791','1.2',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','11:59:24','','',1,1),(571,346,'1','CG01P02850','AB','Magnolia','993','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:02:47','','',1,1),(572,346,'1','CG01P03872','AB','Oreja Del Raton','915','0.8',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:03:21','','',1,1),(573,346,'1','CG01P10276','AB','El Puente','831','0.6',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:04:01','','',1,1),(574,346,'1','CG01P10278','AB','El Capulin','984','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:04:43','','',1,1),(575,347,'1','CG01P10277','AB','La Soledad','802','0.35',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:08:04','','',1,1),(576,348,'1','CG01P03900','AB','Barrial','932','1.68',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:10:30','','',1,1),(577,348,'1','CG01P08439','AB','Los Llanitos','1300','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:11:15','','',1,1),(578,349,'1','CG01P03829','AB','Triangulo','917','1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:13:47','','',1,1),(579,350,'1','TEMP14','AB','La Loma','1100','1.1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:16:47','','',1,1),(580,350,'1','TEMP15','AB','Patagona','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:17:14','','',1,1),(581,351,'1','CG01P03832','AB','La Tarjea','1049','1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:20:55','','',1,1),(582,351,'1','CG01P03837','AB','Capulin','988','1.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:21:33','','',1,1),(583,352,'1','CG01P03815','AB','Escaleritas','951','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:24:44','','',1,1),(584,352,'1','CG01P03816','AB','Piedras Negras','735','0.4',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:25:30','','',1,1),(585,352,'1','CG01P03817','AB','San Juan','777','1.6',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:31:52','','',1,1),(586,353,'1','CG01P03871','AB','Los Llanitos','1269','3.1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:35:40','','',1,1),(587,354,'1','TEMP19','AB','El Llanito','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:38:13','','',1,1),(588,354,'1','TEMP20','AB','La Soledad','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:38:31','','',1,1),(589,354,'1','TEMP21','AB','La Secundaria','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:38:50','','',1,1),(590,355,'1','TEMP22','AB','El Salto','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:41:40','','',1,1),(591,356,'1','TEMP23','AB','Escalerita','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:43:54','','',1,1),(592,357,'1','CG01P03818','AB','Don Jorge','1044','2',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:46:30','','',1,1),(593,357,'1','CG01P03819','AB','El Guayabo','971','2',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:47:04','','',1,1),(594,358,'1','201902019','AB','El Pisoñero','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:49:54','','',1,1),(595,358,'1','CP1702212','AB','Guamaritas','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:50:23','','',1,1),(596,358,'1','CP1702213','AB','El Triangulo','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:51:19','','',1,1),(597,358,'1','TEMP25','AB','Los Llanitos','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:51:49','','',1,1),(598,358,'1','TEMP26','AB','La Loma','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','12:52:12','','',1,1),(599,359,'1','TEMP27','AB','Canollitas','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','13:01:07','','',1,1),(600,360,'1','TEMP28','AB','Piedras Negras II','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:11:38','','',1,1),(601,361,'1','TEMP29','AB','Piedras Negras','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:14:14','','',1,1),(602,362,'1','CG01P07254','AB','Los Llanitos','1273','1.45',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:16:45','','',1,1),(603,362,'1','CG01P07256','AB','Arroyo Frio','823','0.63',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:17:41','','',1,1),(604,362,'1','CG01P07258','AB','La Tarjea','988','0.61',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:18:15','','',1,1),(605,362,'1','CG01P07259','AB','Piedras Negras','826','0.50',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:18:46','','',1,1),(606,363,'1','TEMP33','AB','Guamaritas','0','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:33:33','','',1,1),(607,363,'1','TEMP34','AB','La Tarjea','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:33:54','','',1,1),(608,364,'1','CG01P02873','AB','La Magnolia','0','3',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:46:31','','',1,1),(609,365,'1','CG01P03865','AB','Pisoneño','0','0.65',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:51:29','','',1,1),(610,365,'1','TEMP39','AB','La Tarjea','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','14:51:53','','',1,1),(611,366,'1','CG01P02843','AB','La Patagona','0','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','15:04:40','','',1,1),(612,366,'1','CG01P02844','AB','Cafetal Viejo','0','2.91',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','15:05:07','','',1,1),(613,366,'1','CG01P02845','AB','La Tarjea','0','1.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','15:05:34','','',1,1),(614,366,'1','CG01P02846','AB','La Magnolia','0','0.94',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','15:06:04','','',1,1),(615,366,'1','CG01P02847','AB','La Loma','0','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','15:06:38','','',1,1),(616,367,'1','TEMP41','AB','La Loma','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','15:21:32','','',1,1),(617,367,'1','TEMP40','AB','Guamaritas','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','15:22:09','','',1,1),(618,367,'1','TEMP42','AB','Los Llanitos','0','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','15:22:32','','',1,1),(619,368,'1','TEMP43','AB','La Carbonera','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','18:16:06','','',1,1),(620,369,'1','CG01P03828','AB','Barrial','0','1.68',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','18:21:40','','',1,1),(621,370,'1','TEMP44','AB','La Cachucha','0','0.1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','18:36:01','','',1,1),(622,370,'1','TEMP45','AB','La Tarjea','0','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','18:36:30','','',1,1),(623,371,'1','TEMP46','AB','Escaleritas','951','0.50',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','18:44:53','','',1,1),(624,372,'1','TEMP0602211','AB','El Solar','1000','0.50',500,1,1,5,23,7,0,0,'Seleccione','0','','1000','1000','',1,1,'2021-11-19','18:57:05','','',1,1),(625,372,'1','TEMP090221','AB','Escaleritas','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','18:58:54','','',1,1),(626,372,'1','TEMP47','AB','La Tarjea','0','0.23',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','18:59:28','','',1,1),(627,373,'1','TEMP191121','AB','Cuamil De Valles','0','0.52',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','19:14:52','','',1,1),(628,374,'1','CG01P02526','AB','Guamaritas','0','1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','19:25:30','','',1,1),(629,374,'1','CG01P02527','AB','Aguacate','0','1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','19:26:02','','',1,1),(630,374,'1','TEMP50','AB','Canollitas','0','1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','19:27:52','','',1,1),(631,374,'1','TEMP51','AB','La Trozada','0','0.12',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','19:28:24','','',1,1),(632,375,'1','CG01P02483','AB','Oreja De Raton','934','2.98',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','19:42:26','','',1,1),(633,376,'1','TEMP981','AB','La Soledad','0','1.08',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','19:54:09','','',1,1),(634,377,'1','CG01P07180','AB','Guamaritas','855','0.4',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','20:04:30','','',1,1),(635,378,'1','TEMP102','AB','La Tarjea','0','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','20:09:36','','',1,1),(636,379,'1','TEMP103','AB','Las Trompetas','0','0.23',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','20:24:40','','',1,1),(637,380,'1','CG01P07181','AB','Guamaritas','864','4.47',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','20:29:45','','',1,1),(638,381,'1','CG01P02598','AB','Cafetal Viejo','0','1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','20:43:15','','',1,1),(639,381,'1','CG01P02801','AB','Guasimas','0','2',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','20:43:47','','',1,1),(640,381,'1','TEMP104','AB','El Pozo','0','0.53',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','20:44:45','','',1,1),(641,381,'1','TEMP105','AB','La Soledad','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','20:45:09','','',1,1),(642,382,'1','CG01P02586','AB','La Higuerilla','0','2',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','21:11:40','','',1,1),(643,382,'1','CG01P02587','AB','Triangulo','0','1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','21:12:01','','',1,1),(644,382,'1','CG01P02588','AB','La Loma','0','1',1,1,1,5,23,7,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-11-19','21:12:22','','',1,1),(645,386,'1','CG01P02456','AB','Escaleritas','984','1.11',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-19','21:39:00','','',1,1),(646,387,'1','TEMP030221','AB','El Puente','1000','1',1000,1,1,5,23,7,0,0,'Seleccione','0',' ','0','0',' ',1,1,'2021-11-19','21:48:17','','',1,1),(647,388,'1','TEMP16','AB','Escaleritas','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','00:29:42','','',1,1),(648,388,'1','TEMP17','AB','Los Llanitos','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','00:30:06','','',1,1),(649,388,'1','TEMP18','AB','Magnolia','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','00:31:05','','',1,1),(650,389,'1','CG01P07255','AB','Guamaritas','884','2.70',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','00:33:52','','',1,1),(651,390,'1','CG01P03897','AB','Magnolia','0','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','00:38:18','','',1,1),(652,390,'1','CG01P03899','AB','El Pomarroso','0','0.5',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','00:40:37','','',1,1),(653,391,'1','CG01P038240','AB','El Parejo','983','6',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','00:46:05','','',1,1),(654,392,'1','CG01P03873','AB','Las Trompetas','1000','1',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','00:49:52','','',1,1),(655,393,'1','TEMP24','AB','La Trozada','1100','3',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','01:00:05','','',1,1),(656,394,'1','TEMP1002212','AB','Oreja De Raton','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2021-11-20','01:05:52','','',1,1),(657,395,'1','CPTEMPY0403211','AC','Oreja De Raton','1000','2',1500,1,1,5,23,7,0,0,'Seleccione','0','','1000','1000','',1,1,'2021-11-20','01:09:48','','',1,1),(658,396,'1','TEMP040122','AB','Piedras Negras','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2022-01-05','14:23:06','','',1,1),(659,397,'1','TEMP0401221','AB','El Crucero','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2022-01-05','14:25:31','','',1,1),(660,395,'1','CPTEMP100122','AB','La Telesecundaria','0','0',0,1,1,5,23,7,0,0,'Seleccione','0','','0','0','',1,1,'2022-01-10','09:02:47','','',1,1),(661,398,'1','CPTEMP180122','AD','Tepetilte','0','0',0,1,1,4,17,1,0,0,'Seleccione','0','','0','0','',1,1,'2022-01-18','14:26:04','','',1,1);
/*!40000 ALTER TABLE `parcelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfiles` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_TipoPersona` int(10) unsigned NOT NULL,
  `Nombre` varchar(65) DEFAULT NULL,
  `ApellidoPaterno` varchar(85) DEFAULT NULL,
  `ApellidoMaterno` varchar(85) DEFAULT NULL,
  `RazonSocial` varchar(95) DEFAULT NULL,
  `NombreCorto` varchar(45) NOT NULL,
  `ClaveCorte` varchar(1) DEFAULT NULL,
  `ID_GiroDeMoral` int(11) DEFAULT NULL,
  `RegistroDePoblacion` varchar(45) DEFAULT NULL,
  `IdentificacionFiscal` varchar(45) NOT NULL,
  `ID_Genero` int(11) DEFAULT NULL,
  `id_documento` int(11) NOT NULL,
  `productor` int(1) NOT NULL,
  `socio` int(1) NOT NULL,
  `Telefono` varchar(13) DEFAULT NULL,
  `telefonoMovil` varchar(13) NOT NULL,
  `Email` blob DEFAULT NULL,
  `PaginaWeb` blob DEFAULT NULL,
  `Direccion` varchar(85) NOT NULL,
  `CodigoPostal` varchar(25) NOT NULL,
  `ID_Pais` int(10) unsigned NOT NULL,
  `ID_Estado` int(10) unsigned NOT NULL,
  `ID_Municipio` int(10) unsigned NOT NULL,
  `ID_Localidad` int(10) unsigned NOT NULL,
  `ID_EjidoColonia` int(10) unsigned NOT NULL,
  `Foto` longblob DEFAULT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaf`
--

DROP TABLE IF EXISTS `personaf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personaf` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(65) DEFAULT NULL,
  `ApellidoPaterno` varchar(85) DEFAULT NULL,
  `ApellidoMaterno` varchar(85) DEFAULT NULL,
  `RegistroDePoblacion` varchar(45) DEFAULT NULL,
  `IdentificacionFiscal` varchar(45) NOT NULL,
  `ID_Genero` int(11) DEFAULT NULL,
  `Telefono` blob DEFAULT NULL,
  `telefonoMovil` blob DEFAULT NULL,
  `Direccion` varchar(85) NOT NULL,
  `CodigoPostal` varchar(25) NOT NULL,
  `ID_Pais` int(10) unsigned NOT NULL,
  `ID_Estado` int(10) unsigned NOT NULL,
  `ID_Municipio` int(10) unsigned NOT NULL,
  `ID_Localidad` int(10) unsigned NOT NULL,
  `ID_EjidoColonia` int(10) unsigned NOT NULL,
  `Foto` longblob DEFAULT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  `estadoSocio` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=399 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaf`
--

LOCK TABLES `personaf` WRITE;
/*!40000 ALTER TABLE `personaf` DISABLE KEYS */;
INSERT INTO `personaf` VALUES (1,'Carlos German','Valdez','Correa','VACC940421HNTLRR03','VACC940421HX9',1,NULL,NULL,'Tequesquite #125 Depto 2','63197',1,1,4,20,37,NULL,1,1,'2021-07-14','09:40:48','','',1,1,2),(2,'Antonio','Bañuelos','Castañeda','BXCA350902HJCXSN02','BACA3509025L1',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','10:11:25','','',1,1,1),(3,'Eloisa','Avila','Vazquez','AIVE600414MJCVZL00','S/D',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','10:19:10','','',1,1,1),(4,'Jorge Luis','Bañuelos','Mendoza','BAMJ740927HJCXNR06','BAMJ7409278R6',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','10:26:10','','',1,1,1),(5,'Pascual','Avila','Vazquez','AIVP500517HNTVZS06','S/D',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','10:32:29','','',1,1,1),(6,'Maria Guadalupe De Jesus','Carrillo','Najera','CANG370604MCHRJD04','CANG370604H06',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','10:37:57','','',1,1,1),(7,'Antonio','Celis','Miranda','CEMA610227HNTLRN09','CEMA610227F61',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','10:44:02','','',1,1,1),(8,'Rigoberto','Chavez','Carrillo','CACM640414HCHHRN16','CACM640414SK5',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','10:46:58','','',1,1,1),(9,'Agustina','Chavez','Martinez','CAMA550828MCHHRG00','CAMA550828H70',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','10:51:37','','',1,1,1),(10,'Anacleta','Chavez','Martinez','CAMA660713MCHHRN08','CAMA660713TE5',2,'0','3112637326','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:00:01','','',1,1,1),(11,'Andrea','Flores','De La O','FOOA660227MNTLXN01','FOOA660227HU7',2,'0','3111138931','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:03:45','','',1,1,1),(12,'Agustin','Gomez','Hernandez','GOHA640505HCHMRG07','GOHA640505HB8',1,'0','0','Loc La Yerba','63519',1,1,4,17,1,'NO',1,1,'2021-07-14','11:12:50','','',1,1,1),(13,'Antoliano','Hernandez','Andrade','HEAA380206HNTRNN06','HEAA380206BN9',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:22:26','','',1,1,1),(14,'Juan Ignacio','Isidro','Castañeda','IICJ441027HZSSSN08','IICF360207RP7',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:28:18','','',1,1,1),(15,'Jose Miguel','Lizama','Villegas','LIVM701105HMNZLG08','S/D',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:29:58','','',1,1,1),(16,'Pedro','Lopez','De La O','LOOP710110HNTPXD03','LOOP710110QR4',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:35:35','','',1,1,1),(17,'Constantino','Martinez','Meza','MAMC451028HJCRZN03','MAMC451028SS7',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:38:24','','',1,1,1),(18,'Maria Aurora','Najera','Martinez','NAMA540325MCHJRR01','NAMA540325ST1',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:41:48','','',1,1,1),(19,'Juan Manuel','Najera','Ochoa','NAOJ610912HCHJCNII','NAOJ610912SJ6',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:48:13','','',1,1,1),(20,'Efigenia','Ochoa','Cardoza','OOCE430921MCHCRF19','OOCE430921IA1',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','11:52:24','','',1,1,1),(21,'Felipa','Rodriguez','De La Cruz','ROCF390525MJCDRL04','ROCF390525V7',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:01:15','','',1,1,1),(22,'Jose Antonio','Marin','Aguilar','MAAA780110HNTRGN01','MAAA780110471',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:04:53','','',1,1,1),(23,'Ma Julia','Lopez','De La O','LOOJ580313MNTPXL02','S/D',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:11:17','','',1,1,1),(24,'J Felix','Llamas','De La O','LAOF510502HNTLXL26','LAOJ510502571',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:21:54','','',1,1,1),(25,'Ernesto','Hernandez','Celedon','HECE691107HNTRLR02','HACE691107DK6',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:31:01','','',1,1,1),(26,'Santiago','Hernandez','Ahumada','HEAS660725HNTRHN03','HEAS660725315',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:35:52','','',1,1,1),(27,'Luis','Gaytan','Villegas','S/D','S/D',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:39:32','','',1,1,1),(28,'Lucia','Chavez','Chavez','CACL391213MCHHHCD9','CACL39121317O',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:46:52','','',1,1,1),(29,'Luis Fernando','Gaytan','Chavez','GACL840530HNTYHS09','GACL840530HR9',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:51:18','','',1,1,1),(30,'Pedro','Panfilo','Salomon','PASP440629HJCNLD12','PASP440629GQ9',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-14','12:56:14','','',1,1,1),(31,'Leonardo','Perez','Peña','PEPL491106HNTRXN19','PEPL491106BVA',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','10:02:25','','',1,1,1),(32,'Pedro','Perez','Peña','PEPP640629HNTRXD05','PEPP6404293B4',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','10:04:28','','',1,1,1),(33,'Simon','Plasencia','Lopez','PALS690928HNTLPM07','PALS690928JQ8',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','10:16:41','','',1,1,1),(34,'Miguel','Ramirez','Mora','RAMM580608HNTMRG05','RAMM580608PX7',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','10:19:00','','',1,1,1),(35,'Jose Asencion','Plasencia','Lopez','S/D','S/D',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','10:24:16','','',1,1,1),(36,'Pomposo','Perez','Peña','PEPP560918HNTRXM00','S/D',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','10:26:23','','',1,1,1),(37,'Juan','Najera','Peinado','NAPJ330624HCHJNN04','NAPJ330624DM9',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','10:32:07','','',1,1,1),(38,'Ramon','Caro','Zarate','CAZR480215HJCRRM02','CAZR480215NU1',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','12:17:56','','',1,1,1),(39,'Ramon','Carranza','Bañuelos','CABR670527HJCRXM02','CABR670527KR8',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','12:21:54','','',1,1,1),(40,'Ruperto','Carrillo','Najera','CANR521022HCHRJP04','CANR521022KW2',1,'0','0','Loc La Yerba','63159',1,1,4,17,27,'NO',1,1,'2021-07-15','12:32:12','','',1,1,1),(41,'Genoveva','Casteñeda','Lopez','CALG741026MJCSPN03','CALG741026ICA',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','12:39:57','','',1,1,1),(42,'Santiago','Gaytan','Villegas','GAVS610725HMNYLN00','GAVS610725I67',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','12:43:55','','',1,1,1),(43,'Loreto','Gomez','Hernandez','GOHL560205HCHMRR07','GOHA640505HB8',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','12:45:58','','',1,1,1),(44,'Maria Cristina','Hernandez','Chavez','HECF550215HCHRHS00','HECF550215H97',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','12:50:53','','',1,1,1),(45,'J Jesus','Jimenez','Esparza','JIEJ600129HJCMSS03','JIEJ600129R71',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','12:56:45','','',1,1,1),(46,'Pascual','Marin','Miramontes','MAXP390323HNTRX501','MAPA390323QB0',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','13:12:14','','',1,1,1),(47,'Nicolas','Perez','Llanos','PELN220322HNTRLC01','PELN220322AP3',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','13:15:42','','',1,1,1),(48,'Sergio','Plasencia','Lopez','PALS660614HNTLPR07','PALS660614TB4',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','13:19:37','','',1,1,1),(49,'Bibiano','Silbestre','Solis','SISB391201HNTLLB02','SISB391201K5',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','13:25:34','','',1,1,1),(50,'Marcos Bartolo','Urias','Chavez','UICM760329HCHRHR00','UICM760329FX6',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','13:29:05','','',1,1,1),(51,'Socorro','Urias','Chavez','UICS750227HCHRHC05','UICS750227RT4',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','14:18:51','','',1,1,1),(52,'Humberto','Hernandez','Chavez','HECH760325HNTRHM04','S/D',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:00:24','','',1,1,1),(53,'Jacinto','Mendez','Flores','MEFJ490130HCHNLC00','MEFJ490130H52',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:02:17','','',1,1,1),(54,'Liliana Guadalupe','Llamas','Valdez','LAVL790411MNTLLL08','LAVL7904111C5',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:06:27','','',1,1,1),(55,'Oliverio','Hernandez','Chavez','HECO510528HCHRHL06','HECO510528693',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:08:40','','',1,1,1),(56,'Manuel','Martinez','Meza','S/D','S/D',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:22:46','','',1,1,1),(57,'Yesenia','Martinez','Covarrubias','S/D','S/D',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:25:23','','',1,1,1),(58,'Martin','Lopez','Bogarin','LOXM450108HJCPXR08','LOMA450108IB6',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:30:16','','',1,1,1),(59,'Maria Magdalena','Hernandez','Chavez','HECM521023MCHRHG01','HECM521023QD8',2,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:33:07','','',1,1,1),(60,'Sandra Yadira','Estrada','Cruz','S/D','S/D',2,'0','3118518266','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:38:27','','',1,1,1),(61,'Jose Israel','Vergara','Martinez','VEMI791028HNTRRS09','VEMI791028210',1,'0','0','Loc La Yerba','63519',1,1,4,17,27,'NO',1,1,'2021-07-15','15:47:43','','',1,1,1),(62,'Marco Antonio','Salas','Chavez','SACM781006HNTLHR04','SACM781006',1,'0','3112407963','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-16','10:21:30','','',1,1,1),(63,'Cesar','Chavez','Reyna','CARC450612HNTHYS02','CARC4506123L0',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-17','09:41:50','','',1,1,1),(64,'Hector','Ojeda','Razo','OERH690528HNTJZT09','OERH690528QR3',1,'0','3112674169','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-17','10:09:38','','',1,1,1),(65,'Jaime Humberto','Castro','Hernandez','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-17','10:14:54','','',1,1,1),(66,'Jose Cruz','Bermudez','Arroyo','BEAC580503HNTRRR05','BEAJ580503TH5',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-17','10:21:41','','',1,1,2),(67,'Alberto','Bermudez','Arroyo','BEAA650406HNTRRL05','BEAA650406RJ7',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-17','10:31:26','','',1,1,2),(68,'Manuel','Arroyo','Altamirano','S/D','AOAM370911',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-17','12:13:07','','',1,1,2),(69,'Sergio','Balvuena','Sergio','HEBS841215HNTRLR07','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-17','12:23:11','','',1,1,2),(70,'Marcelina','Hernadez','De Dios','HEDM490602MNTRSR04','HEDM490602BZ3',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-17','12:27:58','','',1,1,2),(71,'Yuriana','Mora','Bermudez','MOBY820325MNTRRR09','MOBY8203256V1',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-17','12:31:30','','',1,1,2),(72,'Higinio','Ramirez','Carabantes','RACH370111HNTMRG09','RACH370111PW6',1,'0','0','El Llano','63778',1,1,5,23,43,'NO',1,1,'2021-07-17','12:37:40','','',1,1,2),(73,'Juan','Rodriguez','Arroyo','ROAJ630324HNTDRN08','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','09:20:14','','',1,1,1),(74,'J Asuncion','Dado','Marquez','DAMA430815HNTDRS05','DAMJ430815LT2',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','11:52:36','','',1,1,1),(75,'Licarina','Arroyo','Altamirano','AOAL440607MNTRLC14','AOAL440607LF4',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','12:53:44','','',1,1,1),(76,'Petra','Bermudez','Gonzalez','BEGP640608MNTRNT05','BEGP640608NL0',2,'0','0','Col Lomas Del Valle','63066',1,1,5,23,43,'NO',1,1,'2021-07-19','12:57:05','','',1,1,1),(77,'Daniel','Chaparro','Bermudez','CABD890712HCHHRN01','CABD890712884',1,'0','0','Col Lomas Bonitas','63062',1,1,5,23,43,'NO',1,1,'2021-07-19','14:20:56','','',1,1,1),(78,'Francisca','Chaparro','Corral','CACF660604MCHHRR00','CACF660604DK1',2,'0','0','El Cuarenteño','63065',1,1,5,23,43,'NO',1,1,'2021-07-19','14:24:54','','',1,1,1),(79,'Manuel','Chaparro','Corral','CACM700901HCHHRN08','CACM700901QS3',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','14:27:15','','',1,1,1),(80,'Angel','Chaparro','Olivas','CA0A950520HNTHLN03','CA0A950520',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','14:31:28','','',1,1,1),(81,'Sergio','Chavez','Armenta','CAAS730802HNTHRR08','CAAS730802LR8',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','14:40:26','','',1,1,1),(82,'Avelino','Chavez','Reyna','CARA521116HNTHYV05','CARA521116LJ3',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','14:51:05','','',1,1,1),(83,'Angel','Corral','Flores','COFA481116HCHRLN07','COFA4811167G8',1,'0','0','Col Lopez Mateos','63021',1,1,5,23,43,'NO',1,1,'2021-07-19','14:56:21','','',1,1,1),(84,'Raul','Corral','Sanchez','COSR830126HNTRNL07','COSR830126',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','15:03:58','','',1,1,2),(85,'Pascacio','Garcia','Corral','GACP630222HCHRRS06','GACP630222AG1',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','15:06:34','','',1,1,1),(86,'Maria Estela','Hernandez','De Dios','HEDE641207MNTRSS05','HEDE641207GZA',2,'0','0','El Cuarenteño','63790',1,1,5,23,43,'NO',1,1,'2021-07-19','15:16:02','','',1,1,1),(87,'Cecilio','Islas','Arroyo','IAAC820107HNTSRC04','IAAC820107',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','15:30:11','','',1,1,1),(88,'Martin','Islas','Arroyo','IAAN760426HNTSRR04','IAAN760426V91',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','15:32:14','','',1,1,1),(89,'Zoila Trinidad','Lopez','Covarrubias','LOCZ811012MNTPVL10','LOCZ811012931',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','15:42:01','','',1,1,1),(90,'Cecilia','Martinez','Bernal','MABC781112MNTRRC00','MABC781112',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-19','15:50:49','','',1,1,1),(91,'Milton Arturo','Ojeda','De Dios','OERH690528HNTJZT09','OERH690528QR3',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','08:48:42','','',1,1,1),(92,'Gregorio','Ojeda','Padilla','OEPG421220HNTJDR02','OEPG421220',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','08:51:56','','',1,1,1),(93,'Gregorio','Orozco','Parra','OOPG660312HNTRRR03','OOPG6603121W3',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','08:54:22','','',1,1,1),(94,'Jaime','Ojeda','Razo','OERJ790228HNTJZM08','OERJ790228911',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','09:17:51','','',1,1,1),(95,'Adan','Ojeda','Salas','OESA550421HNTJLD05','OESA550421646',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','09:21:09','','',1,1,1),(96,'Francisco','Orozco','Almeida','OOAF750402HNTRLR00','OOAF7504027M4',1,'0','0','El Cuarenteño','63173',1,1,5,23,43,'NO',1,1,'2021-07-20','09:33:12','','',1,1,1),(97,'Antonio','Orozco','Anaya','OONA420715HNTRYN07','OONA420715R23',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','09:35:53','','',1,1,1),(98,'Jhonny Jaziel','Orozco','Castro','OOCJ920105HNTRSH06','OOCJ920105',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','09:42:19','','',1,1,1),(99,'Mariela','Ortega','Ocegueda','OEOM791031MNTRCR07','OEOM791031',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','10:19:50','','',1,1,1),(100,'Jesus Antonio','Chavez','Bermudez','CABJ9403303R5','CABJ9403303R5',1,'0','0','El Cuarenteño','63000',1,1,5,23,43,'NO',1,1,'2021-07-20','10:23:03','','',1,1,1),(101,'Ignacio','Macias','Covarrubias','MACI520731HJCCVG03','MACI520731740',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','10:27:51','','',1,1,1),(102,'Karla','Cuevas','Ayala','S/D','S/D',2,'0','3111411363','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','10:58:37','','',1,1,1),(103,'Jose Avelino','Chavez','Bermudez','CABA840319HNTHRV00','CABA840319NE2',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','11:08:16','','',1,1,1),(104,'Mario','Ojeda','Padilla','OEPM500912HNTJDR01','OEPM500912HTA',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','11:13:38','','',1,1,1),(105,'Ana Bertha','Ojeda','Salas','S/D','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','11:21:02','','',1,1,1),(106,'Carlos','Ojeda','Padilla','OEPC441104HNTJDR01','OEPC441104JE8',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','11:25:29','','',1,1,1),(107,'Carlos','Ojeda','Salas','OESC740307HNTJLR02','OESC740307V16',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','11:31:24','','',1,1,1),(108,'Gregorio','Razo','Gonzalez','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','11:38:18','','',1,1,1),(109,'Catalina','Rodriguez','Mayorga','ROMC660430MNTDYT01','ROMC660430TN6',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','11:45:22','','',1,1,2),(110,'Angelica','Mora','Martinez','S/D','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','11:49:43','','',1,1,1),(111,'Maria Dolores','De Dios','Ortega','S/D','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','11:59:07','','',1,1,1),(112,'Maria Guadalupe','Ojeda','Salas','OESG800410MNTJLD07','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:02:25','','',1,1,1),(113,'Ernesto','Lopez','Huizar','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:04:46','','',1,1,1),(114,'Miguel Angel','Ojeda','Salas','OESM750724HNTJLG08','OESM750724LV1',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:09:45','','',1,1,1),(115,'Miguel','Razo','Gonzalez','RAGM750719HNTZNG02','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:15:24','','',1,1,1),(116,'Felix','Mora','Martinez','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:17:11','','',1,1,1),(117,'Cindy','Talavera','Salas','S/D','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:18:47','','',1,1,1),(118,'Rogelio','Ojeda','Salas','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:21:11','','',1,1,1),(119,'Fabiola','Arroyo','Soto','S/D','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:22:49','','',1,1,1),(120,'Blanca Isela','Ojeda','Salas','OESB760218MNTJLL04','OESB7602186B0',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:24:42','','',1,1,1),(121,'Dionisia','Hernandez','B','S/D','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:51:15','','',1,1,1),(122,'Magdalena','Gonzalez','Rodriguez','GORM410719MZSNDG05','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:54:17','','',1,1,1),(123,'Iris','De Dios','Fuerte','S/D','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','12:55:55','','',1,1,1),(124,'Guillermo','Ojeda','Altamirano','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','13:01:01','','',1,1,2),(125,'Luis','Salas','Altamirano','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','13:07:57','','',1,1,2),(126,'Leonardo','Islas','Bañuelos','IABL431009HNTSXN00','IABL431009616',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','13:19:33','','',1,1,2),(127,'Emilia','Lizama','Aquino','S/D','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','13:26:44','','',1,1,2),(128,'Martina','De Dios','Bermudez','S/D','S/D',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','13:30:29','','',1,1,2),(129,'Juan Gerardo','Razo','Bernal','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','13:38:47','','',1,1,2),(130,'Diego','Talavera','Rodriguez','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-20','13:47:15','','',1,1,2),(131,'Arnulfo','Aquino','Lizama','AULA730527HNTQZR02','AULA7305272Y3',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','14:23:57','','',1,1,2),(132,'Baudelio','Pulido','Lizama','PULB470109HNTLZD00','PULB470109JI9',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','14:29:39','','',1,1,2),(133,'Eugenio','Navarro','Ramirez','NARE331111HNTVMG02','NARE331111QA4',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','14:38:10','','',1,1,2),(134,'Maria Faustina','Pulido','Bermudez','PUBF530902MNTLRS07','PUBF5309024M9',2,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','14:41:34','','',1,1,2),(135,'Jose Manuel','Martinez','Pulido','MAPM531114HNTRLN00','MAPM531114LCS',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','14:53:50','','',1,1,2),(136,'Joel','Aquino','Navarro','AUNJ630715HNTQVL02','AUNJ630715F25',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','14:59:35','','',1,1,2),(137,'Luis','Bermudez','Alvarez','BEAL570826HNTRLS08','BEAL5708261K1',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','15:09:03','','',1,1,2),(138,'Nicolas','Isiordia','Hermosillo','IIHN440322HNTSRC04','IIHN4403225Z9',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','15:18:11','','',1,1,2),(139,'Raymundo','Lizama','Diaz','LIDR540123HNTZZY02','LIDR540123MI3',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','15:27:48','','',1,1,2),(140,'Zenorino','Lizama','Ramirez','LIRZ671007HNTZMN12','LIRZ6710077S5',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','15:33:24','','',1,1,2),(141,'Victoriano','Navarro','Pulido','NAPV650718HNTVLC05','NAPV650718TMA',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','15:43:44','','',1,1,2),(142,'Tomas','Pulido','Bermudez','PUBT720919HNTLRM05','PUBT720919',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','16:05:39','','',1,1,2),(143,'Francisco','Zepeda','Munguia','ZEMF711211HNTPNR00','ZEMF7112116G0',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','16:16:15','','',1,1,2),(144,'Fernando','Hernandez','Delgadillo','HEDF160305HNTKST65','HEDF160305',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','16:21:31','','',1,1,2),(145,'Guillermo','Cedano','Lizama','CELG570210HNTDZL16','CELG570210U68',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','16:24:37','','',1,1,2),(146,'Juan Lumperto','Garcia','Castillo','GACL190306HNTWSK75','GACL190306',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-20','16:29:01','','',1,1,2),(147,'Jose Luis','Nava','Rodarte','NARL510210HSLVDS04','NARL510210',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','09:08:50','','',1,1,2),(148,'Maria Guadalupe','Martinez','Lizama','MALG651105','MALG651105AV5',2,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','09:26:14','','',1,1,2),(149,'Patricio','Pulido','Navarro','PUNP750317HNTLVT08','PUNP750317FP0',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','09:36:03','','',1,1,2),(150,'Roberto Antonio','Cedano','Lizama','CELR670607HNTDBZ07','CELR6706073Q6',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','09:39:52','','',1,1,2),(151,'Juventino','Nuñez','Curiel','NYCH680409HNTXRV04','NUCJ6804099P4',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','09:44:15','','',1,1,2),(152,'Jose','Lizama','Orozo','LIOJ430204HNTZRS02','LIOJ430204FY9',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','09:50:53','','',1,1,2),(153,'Carlos','Ibarra','Arce','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','09:59:07','','',1,1,2),(154,'Roberto','Flores','Mendoza','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','10:01:00','','',1,1,2),(155,'Zenaida','Pulido','Lizama','PULZ31120MNTLZN06','PULZ31120KM0',2,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','10:19:47','','',1,1,2),(156,'Aquiles','Lizama','Alvarado','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','10:25:02','','',1,1,2),(157,'Francisco Javier','Aquino','Zambrano','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:01:00','','',1,1,2),(158,'Jose','Bermudez','Navarro','BENJ400108HNTRVS00','BENJ400108QV6',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:04:03','','',1,1,2),(159,'Abel','Navarro','Carranza','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:07:39','','',1,1,2),(160,'Alejo','Carranza','Parra','CAPA440707HNTRRL08','CAPA4407079S6',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:17:26','','',1,1,2),(161,'Alfonso','Alvarez','A','AAXA430919HNTLXL00','AAAL430919196',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:42:44','','',1,1,2),(162,'Alfredo','Pulido','Soto','PUSA690909HNTLTL05','PUSA6909096XA',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:44:35','','',1,1,2),(163,'Antonio','Pintado','Isiordia','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:48:15','','',1,1,2),(164,'Asencion','Navarro','Ramirez','NARA190304HNTHSR27','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:50:11','','',1,1,2),(165,'Brijido','Lizama','Ulloa','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:52:26','','',1,1,2),(166,'Carlos','Lizama','Garcia','LIGC190305HNTQPL67','LIGC190305',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:54:49','','',1,1,2),(167,'Cayetana','Mojica','Gutierrez','S/D','S/D',2,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:57:21','','',1,1,2),(168,'Efren','Gomez','Pulido','GOPE760123HNTMLF01','GOPE760123HGA',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','11:59:22','','',1,1,2),(169,'Eliseo','Aquino','Lizama','AULE690204HNTQZL09','AULE690204N8A',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','12:02:56','','',1,1,2),(170,'Emilio','Pulido','Bermudez','AULE690204HNTQZL09','PUBE640627AM5',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','12:06:01','','',1,1,2),(171,'Epigmenio','Navarro','Ramirez','NARE530324HJCVMP03','NARE530324AK6',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','12:08:32','','',1,1,2),(172,'Ernesto Santos','Lizama','Villa','LIVE671003HNTZLR05','LIVE671003FA2',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','12:14:40','','',1,1,2),(173,'Roberto Antonio','Cedano','Lizama','CELR670607HNTDZB07','CELR6706073Q6',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','13:20:31','','',1,2,2),(174,'Maria Celia','Martinez','Pulido','MAPC560918MNTRLL05','MAPC560918KW0',2,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-21','13:28:29','','',1,1,2),(175,'Felipe De Jesus','Aquino','Navarro','AUNF730205HNTQVL03','AUNF730205',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','10:19:56','','',1,1,2),(176,'Fernando','Martinez','Garcia','MAGF660530HNTRRR03','MAGF660530DD2 ',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','10:22:21','','',1,1,2),(177,'Francisco','Pulido','Lizama','PULF490807HNTLZR00','PULF4908074G1',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','10:28:41','','',1,1,2),(178,'Geronimo','Pulido','Bermudez','PUBG420719HNTLRR01','PUBG420719171',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','10:34:39','','',1,1,2),(179,'Gonzalo','Pulido','Bermudez','PUBG560707HNTLRN08','PUBG560707JS7',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','10:39:48','','',1,1,2),(180,'Gustavo','Cedano','Rivera','CERG730323HNTDVS04','CERG730323JU7',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','10:42:34','','',1,1,2),(181,'J Santos','Lizama','Diaz','LIDS451001HNTZZN19','LIDJ451001TY9',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','10:45:39','','',1,1,2),(182,'Javier','Zepeda','Pulido','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','11:47:35','','',1,1,2),(183,'Joaquin','Aquino','Navarro','AQNJ190304HNTOSL57','AQNJ190304',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','11:52:22','','',1,1,2),(184,'Jose Marcos','Delgado','Lizama','LIXM190304HNTRFS58','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','11:55:41','','',1,1,2),(185,'Jose Moises','Lizama','Martinez','LIMM760811HNTZRS05','LIMM760811',1,'0','0','Cofradia Del Chocolon','63973',1,1,5,22,1,'NO',1,1,'2021-07-22','12:00:51','','',1,1,2),(186,'Juan Carlos','Lizama','Garcia','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','12:06:49','','',1,1,2),(187,'Juan Manuel','Aquino','Navarro','AUNJ680123HNTQVN05','AUNJ6801238C5',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','12:11:32','','',1,1,2),(188,'Julian','Nuñez','Curiel','NUCJ580109HNTXRL04','NUCJ5801097A3',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:14:07','','',1,1,2),(189,'Leonardo','Diaz','Martinez','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:17:19','','',1,1,2),(190,'Luis','Bermudez','Navarro','BENL520819HNTRVS04','BENL5208195J2',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:19:02','','',1,1,2),(191,'Manuel','Aquino','Pulido','AUPM350616HNTQLN05','AUPM350616IP8',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:21:40','','',1,1,2),(192,'Manuel','Lizama','Diaz','LIDM471105HNTZZN03','LIDM471105QA0',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:24:48','','',1,1,2),(193,'Maria Asuncion','Ramirez','Solis','RASA440815MNTMLS03','RASA44081529A',2,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:27:07','','',1,1,2),(194,'Maribel','Alvarado','Garcia','AAGM700429MNTLRR03','AAGM700429541',2,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:33:08','','',1,1,2),(195,'Martin','Soria','Meza','SOMM550130HNTRZR02','SOMM55013067A',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:44:45','','',1,1,2),(196,'Norberto','Flores','Mendoza','FOMN490606HNTLNR07','FOMN490606KL6',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:48:18','','',1,1,2),(197,'Olivia','Lizama','Ramirez','LIRO680418MNTZML01','LIRO680418AS6',2,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:50:45','','',1,1,2),(198,'Pedro','Ramirez','Miramontes','RAMP470801HNTMRD02','RAMP470801178',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','14:59:53','','',1,1,2),(199,'Reimundo','Lizama','Diaz','LIDR121212HNTMNB32','LIDR121212',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','15:06:04','','',1,1,2),(200,'Santos','Lizama','Diaz','LIDS451001HNTZZN19','LIDJ451001TY9',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','15:08:23','','',1,1,2),(201,'Saul','Pulido','Bermudez','PUBS740828HNTLRL07','PUBS740828F29',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','15:14:39','','',1,1,2),(202,'Saul ','Aguilar','Lopez','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','15:17:37','','',1,1,2),(203,'Sebastian','Zepeda','Pulido','ZEPS510120HNTPLB05','ZEPS510120D78',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-22','15:23:26','','',1,1,2),(204,'Sergio','Pulido','Lizama','PULS660705HNTLZR00','PULS660705PE6',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-23','08:54:47','','',1,1,2),(205,'Trinidad','Lizama','Orozco','LIOT400718MNTZRR08','LIOT400718E51',1,'0','0','Cofradia Del Chocolon','637936',1,1,5,22,1,'NO',1,1,'2021-07-23','08:57:29','','',1,1,2),(206,'Vicente','Martinez','Salazar','MASV561027HNTRLC00','MASV5610277B6',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-23','09:01:12','','',1,1,2),(207,'Aurelio','Pulido','Bermudez','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-23','09:03:24','','',1,1,2),(208,'Rolando','Lizama','Diaz','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-23','09:09:19','','',1,1,2),(209,'Genaro','Chavez','Vazquez','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-23','09:11:40','','',1,1,2),(210,'Mario','Osoria','Garcia','S/D','S/D',1,'0','3111917532','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-23','09:15:21','','',1,1,2),(211,'Jose Alfredo','Pulido','Ramirez','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-23','09:17:27','','',1,1,2),(212,'Rolando','Lizama','Villa','S/D','S/D',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-23','09:18:41','','',1,1,2),(213,'Jose','Delgado','Lizama','DELJ560918HNTLZS05','DELJ560918J7A',1,'0','0','Cofradia Del Chocolon','63793',1,1,5,22,1,'NO',1,1,'2021-07-23','09:24:16','','',1,1,2),(214,'Irinio','Lamas','Diaz','LADI690705HNTMZR06','LADI690705MC7',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,10,'NO',1,1,'2021-07-23','09:45:54','','',1,1,1),(215,'Silvestre','Vargas','Flores','VRLLSL60123118H500','VAFS6012311B3',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,12,'NO',1,1,'2021-07-23','09:53:02','','',1,1,1),(216,'Clemente','Gonzalez','Lopez','GOLC330912HNTNPL04','GOLC330912DY3',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,12,'NO',1,1,'2021-07-23','10:15:12','','',1,1,1),(217,'Monica','Geronimo','Rodriguez','GERM570504MNTRDN06','GERM570504',2,'0','0','Presidio De Los Reyes','63621',1,1,2,9,14,'NO',1,1,'2021-07-23','10:38:44','','',1,1,1),(218,'Diego','Flores','Geronimo','FOGD740225HNTLRG05','FOGD7402255G5',1,'0','3192331458 ','Presidio De Los Reyes','63621',1,1,2,9,14,'NO',1,1,'2021-07-23','10:42:34','','',1,1,1),(219,'Jesus','Estrada','Lamas','EALJ741225HNTSMS01','EALJ7412254Z6',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,14,'NO',1,1,'2021-07-23','10:46:17','','',1,1,1),(220,'Nolberto','Gonzalez','Flores','GOFN590413HNTNLL05','GOFN590413UJ7',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,10,'NO',1,1,'2021-07-23','10:48:47','','',1,1,1),(221,'Bonifacio','Gonzalez','Lopez','GOLB440510HNTNPN08','GOLB440510PI1',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,10,'NO',1,1,'2021-07-23','10:51:25','','',1,1,1),(222,'Jose','Flores','Vargas','FOVJ421106HNTLRS08','FOVJ421106NH3',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,14,'NO',1,1,'2021-07-23','10:53:39','','',1,1,1),(223,'Onorio','Flores','Rodriguez','FORO861221HNTLDN06','FORO861221EJ1',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,14,'NO',1,1,'2021-07-23','11:02:42','','',1,1,1),(224,'Griseldo','Lamas','Pizano','LAPG650815HNTMZR05','LAPG650815LD5',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,12,'NO',1,1,'2021-07-23','11:04:43','','',1,1,1),(225,'Eusebio','De Jesus','Gonzalez','JEGE550415HNTSNS09','JEGE5504155S8',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,12,'NO',1,1,'2021-07-23','11:06:51','','',1,1,1),(226,'Amador','Flores','Garcia','FOGA750430HNTLRM02','S/D',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,12,'NO',1,1,'2021-07-23','11:09:31','','',1,1,1),(227,'Victor','Estrada','Lamas','EALV670121HNTSMC01','EALV670121MU0',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,14,'NO',1,1,'2021-07-23','11:17:52','','',1,1,1),(228,'Dionicio','Flores','Flores','FOFD700408HNTLLN01','FOFD700408AFA',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,12,'NO',1,1,'2021-07-23','11:21:03','','',1,1,1),(229,'Bernabe','Flores','Geronimo','FOGB751102HNTLRR05','FOGB7511027W9',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,14,'NO',1,1,'2021-07-23','11:23:47','','',1,1,1),(230,'Delfino','Garcia','Pizano','GAPD521225HNTRZL02','GAPD521225NP4',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,1,'NO',1,1,'2021-07-23','11:26:24','','',1,1,1),(231,'Agustin','Gonzalez','Flores','GOFA690528HNTNLG05','GOFA690528',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,10,'NO',1,1,'2021-07-23','11:30:00','','',1,1,1),(232,'Magdaleno','Flores','Geronimo','FOGM720529HNTLRG07','FOGM720529CM7',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,14,'NO',1,1,'2021-07-23','11:35:43','','',1,1,1),(233,'Herculano','Lamas','Estrada','EALH601207HNTSMR02','EALH601207',1,'0','0','Presidio De Los Reyes','63621',1,1,2,9,14,'NO',1,1,'2021-07-23','11:48:03','','',1,1,1),(234,'Ismael','Ramirez','Miranda','RAMI521113HNTMRS02','RAMI521213U20',1,'0','0','El Malinal','63794',1,1,5,25,1,'NO',1,1,'2021-07-23','13:07:35','','',1,1,1),(235,'Fermin','Garcia','Torres','GATF430721HNTRRR03','GAFT430621RI7',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','13:18:51','','',1,1,1),(236,'Miguel','Castellon','Moreno','CAMM561022HNTSRG02','CAMM561022NX6',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','14:06:20','','',1,1,1),(237,'Benjamin','Valdez','Ureña','VAUB341219HNTLRN01','VAUB341219',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','14:10:18','','',1,1,1),(238,'Ismael','Godinez','Pulido','GOPI550730HNTDLS06','GOPI550730TY0',1,'0','3232825815','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','14:13:36','','',1,1,1),(239,'J Jesus','Gonzalez','Azpeitia','GOAJ370107HNTNZS02','GOAJ370107HU7',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','14:16:31','','',1,1,1),(240,'Lucio','Miranda','Rodriguez','MIRL391213HNTRDC00','MIRL391213J68',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','14:19:11','','',1,1,1),(241,'Santiago','Jimenez','Isiordia','JIIS411127HNTMSN02','JIIS411127IV2',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','15:46:40','','',1,1,1),(242,'Leonardo','Lopez','Ramirez','LORL561109HNTPMN08','LORL561109',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','15:55:51','','',1,1,1),(243,'Eleazar','Garcia','Contreras','GACE690313HNTRNL15','GACE690313TR6',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','16:07:02','','',1,1,1),(244,'Ramon','Garcia','Rea','GARR560830HNTRXM09','GARR560830',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','16:08:40','','',1,1,1),(245,'Jose Leonel','Ramirez','Miranda','RAML700126HNTMRN08','RAML700126',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','16:13:11','','',1,1,1),(246,'Eloy Sadap','Ramirez','Miranda','RAME781204HNTMRL00','RAME781204CDA',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','16:14:46','','',1,1,1),(247,'Tomas','Jimenez','Isiordia','JIIT500426HNTMSM07','JIIT5004262W8',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-23','16:20:41','','',1,1,1),(248,'Jose Maria','Gonzalez','Azpeitia','GOAM390818HNTNZR16','GOAM390818',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','11:10:31','','',1,1,1),(249,'Leonel Alejandro','Ramirez','Lopez','S/D','S/D',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','11:20:11','','',1,1,1),(250,'Maria Guadalupe','Montes','Montes','MOMG590620MNTNND01','MOMG590620',2,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','11:26:00','','',1,1,1),(251,'Juan','Valenzuela','Flores','VAFJ500809HNTLLN05','VAFJ500809J44',1,'0','0','El Malinal','63000',1,1,5,25,1,'NO',1,1,'2021-07-24','11:28:09','','',1,1,1),(252,'Senorino','Godinez','Pulido','GOPS610203HNTDLN05','GOPS610203R94',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','11:41:14','','',1,1,1),(253,'Jose Alfredo','Castellon','Blancarte','CABA580804HNTSLL19','CABA5808045D4',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','11:49:05','','',1,1,1),(254,'Sergio','Garcia','Contreras','GACS550924HNTRNR02','GACS550924386',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','11:53:18','','',1,1,1),(255,'Jose Magdaleno','Renteria','Garcia','REGM550717HNTNRG05','REGM550717C41',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','11:57:35','','',1,1,1),(256,'Bryan Eliazar','Garcia','Pulido','GAPB000105HNTRLRA0','S/D',1,'0','0','El Malinal','63000',1,1,5,25,1,'NO',1,1,'2021-07-24','12:00:04','','',1,1,1),(257,'Keila Alinne','Garcia','Pulido','S/D','S/D',2,'0','3111507466','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','12:08:19','','',1,1,2),(258,'Jose De Jesus','Becerra','Casas','S/D','S/D',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','12:09:25','','',1,1,1),(259,'Arturo Daniel','Zepeda','Jimenez','S/D','S/D',1,'0','0','El Malinal','63790',1,1,5,25,1,'NO',1,1,'2021-07-24','12:19:21','','',1,1,1),(260,'Carmen Celina','Arroyo','Soto','AOSC731106MNTRTR06','AOSC731106HHO',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','09:26:58','','',1,1,2),(261,'Martin Edgardo','De Dios','Ojeda','DIOM830113HNTSJR09','DIOM830113193',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','10:16:32','','',1,1,2),(262,'Zulema Yudith','De Dios','Ojeda','DIOZ781203MNTSJL06','DIOZ781203DP7',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','10:25:55','','',1,1,2),(263,'Francisco','De Dios','Padilla','DIPF470402HNTSDR02','DIPF470402KK0',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','10:27:52','','',1,1,2),(264,'Braulio','De Dios','Razo','DIRB841126HNTSZR06','DIRB841126',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','10:35:19','','',1,1,2),(265,'Eladio','De Dios','Razo','DIRE800321HNTSZL09','DIRE800321',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','10:37:14','','',1,1,2),(266,'Emilio','De Dios','Ojeda','DIOE770405HNTSJM08','DIOE770405RJ4',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','11:16:22','','',1,1,2),(267,'J Guadalupe','De Dios','Contreras','DICJ531212HNTSND04','DICJ5312129A3',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','11:22:09','','',1,1,2),(268,'Jose Ernesto','Garcia','Hernandez','GAHE870609HNTRRR07','GAHE870609',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','11:25:34','','',1,1,2),(269,'Ma Fidelia','Landin','Olivera','LAOF550618MJCNLD05','LAOF550618',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','11:32:40','','',1,1,2),(270,'Yesica Mireya','Ojeda','Salas','OESY770123MNTJLS03','OESY770123DK9',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','11:40:48','','',1,1,2),(271,'Ricardo','Peña','Landin','PELR760615HJCXNC02','PELR760615QF9',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','11:43:04','','',1,1,2),(272,'Martha','Razo','Gonzalez','RAGM770210MNTZNR06','RAGM7702105Z8',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','11:45:00','','',1,1,2),(273,'Monica','Castro','Altamirano','CAAM770504MNTSLN09','CAAM770504',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','11:48:29','','',1,1,2),(274,'Efren','De Dios','Ojeda','DIOE740608HNTSJF09','DIOE740608IB6',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','11:51:23','','',1,1,2),(275,'Arturo','Ruelas','Gonzalez','RUGA540719HNTLNR05','RUGA540719LK1',1,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','11:54:29','','',1,1,2),(276,'Santiago','Ramos','Mendiola','RAMS370128HNTMNN05','RAMS370128HM1',1,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','11:57:10','','',1,1,2),(277,'Sandra Patricia','Ramos','Luna','RALS751228MNTMNN08','RALS751228PKO',2,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','11:58:39','','',1,1,2),(278,'Rito','Perez','Gomez','PEGR500524HNTRMT10','PEGR500524NP4',1,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','12:00:13','','',1,1,2),(279,'J Joel','Paez','Esquivel','PAEJ610811HNTZSL03','PAEJ610811AM6',1,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','12:01:48','','',1,1,2),(280,'Esmeralda','Paez','Ayon','PAAE750116MNTZYS00','PAAE7501162G7',2,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','12:10:36','','',1,1,2),(281,'Agustin','Olvera','Casillas','OECA690328HNTLSG08','OECA690328FM1',1,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','12:42:27','','',1,1,2),(282,'Angel','Mauriño','Ocampo','MAOA410518HNTRCN04','MAOA410518QF9',1,'0','0','El Cora','63773',1,1,5,23,43,'NO',1,1,'2021-07-26','12:44:13','','',1,1,2),(283,'Isidro','Luna','Simeria','LUSI430530HNTNMS04','S/D',1,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','12:45:44','','',1,1,2),(284,'Guadalupe','Jimenez','Paez','JIPG430215MNTMZD04','JIPG430215MJ1',2,'0','0','El Cora','63773',1,1,5,23,43,'NO',1,1,'2021-07-26','12:47:45','','',1,1,2),(285,'Juan Manuel','Gutierrez','Rodriguez','GURO720730HNTTDN03','S/D',1,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','12:49:15','','',1,1,2),(286,'Doroteo','Gutierrez','Jimenez','GUJD500605HNTTMR06','GUJD500605LM6',1,'0','0','El Cora','63773',1,1,5,23,43,'NO',1,1,'2021-07-26','12:51:25','','',1,1,2),(287,'Maria Consuelo','Gonzalez','Hernandez','GOHC550926MNTNRN04','GOHC5509265L0',2,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','12:53:24','','',1,1,2),(288,'Maria Delfina','Martinez','Gonzalez','MAGD541029MNTRNL06','MAGD541029QE6',2,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','12:55:00','','',1,1,2),(289,'Alejandro','Gonzalez','Barrios','GOBA640529HNTNRL02','GOBA640529TE3',1,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','13:16:31','','',1,1,2),(290,'Maria','Gaeta','Sandoval','GASM450808MNTTNR04','GASM450808FZ4',2,'0','0','El Cora','63778',1,1,5,23,43,'NO',1,1,'2021-07-26','13:18:06','','',1,1,2),(291,'Adan','Cortes','Moreno','COMA580719HNTRRD07','COMA5807191D4',1,'0','0','El Cora','63773',1,1,5,23,43,'NO',1,1,'2021-07-26','13:19:53','','',1,1,2),(292,'Anselmo','Covarrubias','Gutierrez','COGA410421HNTVTN05','COGA410421SK5',1,'0','0','El Cora','63773',1,1,5,23,43,'NO',1,1,'2021-07-26','13:21:23','','',1,1,2),(293,'Juan Carlos','Castillon','Cortes','CACJ721112HNTSRN17','CACJ7211128J5',1,'0','0','El Cora','63773',1,1,5,23,43,'NO',1,1,'2021-07-26','13:23:02','','',1,1,2),(294,'Juan De La Cruz','Castillon','Araisa','CACJ721112HNTSRN17','CAAJ351124KS3',1,'0','0','El Cora','63773',1,1,5,23,43,'NO',1,1,'2021-07-26','13:24:36','','',1,1,2),(295,'Ramon','Castellon','Cortes','CACR740327HNTSRM06','CACR740327HJ7',1,'0','0','El Cora','63773',1,1,5,23,43,'NO',1,1,'2021-07-26','14:10:21','','',1,1,2),(296,'J Guadalupe','Sanchez','Hernandez','SAHG440305HNTNRD15','SAHJ440305GD2',1,'0','0','El Cora','63773',1,1,5,23,43,'NO',1,1,'2021-07-26','14:11:59','','',1,1,2),(297,'Gonzalo','Salas','Altamirano','SAAG650721HNTLLN08','SAAG650721HS8',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','14:13:57','','',1,1,2),(298,'Francisco','Salas','Altamirano','SAAF570513HNTLLR00','SAAF570513JD2',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','14:16:13','','',1,1,2),(299,'Margarito','Topete','Gonzalez','TOGM621217HJCPNR05','TOGM6212171G0',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','14:23:34','','',1,1,2),(300,'Michael Margarito','Topete','Ojeda','TOOM901024HNTPJC02','TOOM901024GZ0',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','14:25:36','','',1,1,2),(301,'Florencio','Vidal','Mundo','VIMF540902HNTDNL05','VIMF540902GX8',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','14:27:10','','',1,1,2),(302,'Raul Cristobal','Bustamante','R','BUXR551210HNTSXL01','BURA551210I46',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','14:29:41','','',1,1,2),(303,'Ramona','De Dios','Razo','DIRR770209MNTSZM08','DIRR770209616',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','14:34:01','','',1,1,2),(304,'Rafael','Arroyo','Soto','AOSR700702HNTRTF06','AOSR700702F60',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-07-26','14:37:52','','',1,1,1),(305,'Pedro','Cabrales','Torres','CATP280610HNTBRD03','CATP280610JD6',1,'0','0','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-07-27','09:05:42','','',1,1,2),(306,'Raul','Contreras','Herrera','COHR630209HNTNRL04','S/D',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-07-27','09:07:43','','',1,1,2),(307,'Pablo','Cruz','P','CUXP400618HNTRXB03','CUPA400618SK5',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-07-27','09:10:42','','',1,1,2),(308,'Praxedis','Gonzalez','Contreras','GOCP540415HJCNNR02','GOCP540415JD2',1,'0','0','Puerto De Lindavista','63765',1,1,3,12,19,'NO',1,1,'2021-07-27','09:14:32','','',1,1,2),(309,'Guillermo','Hernandez','Moreno','HEMG460220HHGRRL02','HEMG460220BP8',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-07-27','09:18:46','','',1,1,2),(310,'Magadaleno','Iñiguez','Orenday','IIOM581002HNTXRG09','IGOM601001',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-07-27','10:45:13','','',1,1,2),(311,'Benjamin','Limon','Flores','LILB691121HNTMPN02','LILB691121E33',1,'0','3111193712','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-07-27','10:47:20','','',1,1,2),(312,'Reynaldo','Limon','Nuñez','LINR310120HJCMXY00','LINR310120SC4',1,'0','0','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-07-27','10:49:25','','',1,1,2),(313,'Isidro','Orenday','Uribe','OEUI540515HJCRRS04','S/D',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-07-27','10:52:25','','',1,1,2),(314,'Silvestre','Orendain','Ibarra','OEIS411231HJCRBL09','OEIS4112319L1',1,'0','0','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-07-27','10:55:03','','',1,1,2),(315,'Juan','Orendain','Uribe','OEUJ671009HNTRRN05','OEUJ671009U30',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-07-27','10:59:34','','',1,1,2),(316,'Miguel','Orendain','Uribe','OEUM700929HNTRRG01','S/D',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-07-27','11:14:55','','',1,1,2),(317,'Ambrocio','Orendain','Ibarra','OEIA461207HJCRBM02','OEIA4612077M3',1,'0','0','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-07-27','11:24:50','','',1,1,2),(318,'Jose','Meza','Limon','MELJ370619HJCZMS09','MELJ370619DJA',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','09:27:37','','',1,1,1),(319,'Juan Carlos','Limon','Torres','LITJ850422HNTMRN04','LITJ8504223I2 ',1,'0','3111748196','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-11-10','09:41:27','','',1,1,1),(320,'Andres Jaime','Limas','Elizondo','LIEA611130HNTMLN02','LIEA611130BF6',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','09:45:19','','',1,1,1),(321,'Reynaldo','Limon','Lopez','LILR710927HNTMPY01','LILR710927UK2',1,'0','0','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-11-10','09:53:26','','',1,1,1),(322,'Maria Ofelia','Limas','Elizondo','LIEO561009MNTMLF00','LIEO561009EH6',2,'0','0','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-11-10','09:57:11','','',1,1,1),(323,'Apolonio','Rosales','Bogarin','RXBA550415HZSSGP09','ROBA550415CG2',1,'0','0','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-11-10','10:02:37','','',1,1,1),(324,'Jose Manuel','Ramirez ','Flores','RAFM600220HNTMLN00','RAFM600220GZ2',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','10:47:55','','',1,1,1),(325,'Ricardo','Ramirez','Becerra','RABR690214HNTMCC00','S/D',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','10:56:30','','',1,1,1),(326,'Maria Leticia','Ramirez','Becerra','RABL640526MNTMCT05','RABL640526T60',2,'0','0','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-11-10','11:02:00','','',1,1,1),(327,'Jose Cruz','Ramirez','Becerra','RABC551020HNTMCR04','RABC551020RE7',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','11:05:10','','',1,1,1),(328,'Manuel','Ramirez','Garcia','RAXM330903HNTMXN03','RAMA330903LR5',1,'0','0','Huaynamota','63763',1,1,3,12,19,'NO',1,1,'2021-11-10','11:09:42','','',1,1,1),(329,'J Sergio','Quiroz','Flores','QUFS631003HNTRLR05','QUFS631003',1,'0','0','El Pintadeño','63765',1,1,3,16,25,'NO',1,1,'2021-11-10','11:12:52','','',1,1,1),(330,'Jose','Pulido','Lizama','PULJ440310HNTLZS00','PULJ4403101PA',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','11:16:51','','',1,1,1),(331,'Ricardo','Parra','Ocegueda','PAOR330206HNTRCC04','PAOR330206JY5',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','11:21:51','','',1,1,1),(332,'Eligio','Orozco','Villareal','OOVE521211HJCRLL06','OOVE521211SK9',1,'0','0','Mecatan','63766',1,1,3,15,24,'NO',1,1,'2021-11-10','11:25:48','','',1,1,1),(333,'Maria Isabel','Zavala','Parra','ZAPI490718MNTVRS08','ZAPI490718JL2',2,'0','0','Pintadeño','63766',1,1,3,16,25,'NO',1,1,'2021-11-10','11:36:05','','',1,1,1),(334,'Jose','Torres','Robles','TORJ540619HZSRBS00','S/D',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','11:40:41','','',1,1,1),(335,'Fernando','Torres','Robles','TORF470215HZSRBR08','S/D',1,'0','0','Huaynamota','63010',1,1,3,12,19,'NO',1,1,'2021-11-10','11:46:08','','',1,1,1),(336,'Ramon','Santana','Solano','SASR780721HNTNLM04','SASR780721KDA',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','11:50:29','','',1,1,1),(337,'Ramon','Santana','Alvarez','SAAR350111HJCNLM05','SAAR350111581',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','11:52:49','','',1,1,1),(338,'Juan','Santana','Alvarez','SAAJ400308HJCNLN03','SAAJ380806HQ2',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','11:57:25','','',1,1,1),(339,'Ernesto','Sanchez','Orenday','SAOE811010HNTNRR03','SAOE8110104D3',1,'0','0','Huaynamota','63766',1,1,3,12,19,'NO',1,1,'2021-11-10','12:01:01','','',1,1,1),(340,'Lorenzo','Altamirano','De Dios','AADL510810HNTLSR04','AADL510810IE1',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','10:53:17','','',1,1,1),(341,'Alma Delia','Ojeda','Salas','OESA720117MNTJLL01','OESA720117',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','11:26:41','','',1,1,1),(342,'Higinio','Altamirano','Dueñas','AADH880221HNTLXG04','AADH8802214L2',1,'0','0','El Cuarenteño','63794',1,1,5,23,43,'NO',1,1,'2021-11-19','11:32:28','','',1,1,1),(343,'Alejandro','Altamirano','Estrada','AAEA741120HNTLSL02','AAEA741120TT9',1,'3111651613','3111071247','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','11:35:26','','',1,1,1),(344,'Eduardo','Altamirano','Estrada','AAEE740317HNTLSD11','AAEE740317Q34',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','11:51:42','','',1,1,1),(345,'Irma','Altamirano','Estrada','AAEI651008MNTLSR01','AAEI651008II7',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','11:53:30','','',1,1,1),(346,'Jose Arturo','Altamirano','Estrada','AAEA621007HNTLSR09','AAEA621007PE0',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','11:56:51','','',1,1,1),(347,'Jose De Jesus','Altamirano','Estrada','AAEJ610609HNTLSS10','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:06:53','','',1,1,1),(348,'Lucio','Altamirano','Estrada','AAEL680624HNTLSC08','AAEL680625HY5',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:09:28','','',1,1,1),(349,'Luis Humberto','Altamirano','Estrada','AAEL7003006HNTLSS01','AAEL700306B4A ',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:12:40','','',1,1,1),(350,'Yeni Fabiola','Altamirano','Estrada','AAEY790402MNTLSN07','AAEY790402GT5',2,'0','3111685493','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:15:41','','',1,1,1),(351,'Alberto','Altamirano','Huerta','AAHA750509HNTLRL02','AAHA7505099C2',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:19:34','','',1,1,1),(352,'Fermin','Avila','Hernandez','AIHF591011HNTVRR06','AIHF5910112T9',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:23:43','','',1,1,1),(353,'Maria Luisa','Estrada','Padilla','EAPL430825MNTSDS08','EAPL430825',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:34:40','','',1,1,1),(354,'Antonio Bibiano','Estrada','Padilla','EAPA540118HNTSDN04','EAPA540118F56',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:37:28','','',1,1,1),(355,'Maria De Lourdes','Ojeda','Salas','OESL700731MNTJLR09','OESL700731AB1',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:40:44','','',1,1,1),(356,'Matilde','Rodriguez','Arroyo','ROAM680124MNTDRT02','ROAM680124BP3',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:43:01','','',1,1,1),(357,'Jaime Francisco','Altamirano','Estrada','AAEJ760704HNTLSM08','AAEJ760704T21',1,'0','3111659158','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:45:30','','',1,1,1),(358,'Osiris Absalon','Altamirano','De Anda','AAAO87031718H901','S/D',1,'0','3111746238','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','12:48:45','','',1,1,1),(359,'Francisco Javier','Ponce','Ojeda','POOF850131HNTNCR01','POOF850131NJ2',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','13:00:24','','',1,1,1),(360,'Jose Arturo','Altamirano','Dueñas','AADA864410HNTLXR08','AADA861101H87',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','14:10:16','','',1,1,1),(361,'Luis Miguel','Ojeda','Peña','OEPL84071518H500','OEPL8407155B2',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','14:13:08','','',1,1,1),(362,'Benigno','Altamirano','Estrada','AAEB670207HNTLSN04','AAEB670207U61',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','14:15:37','','',1,1,1),(363,'Jose De Jesus','Altamirano','Martinez','AAMJ810922HNTLRS00','AAMJ8109222L9',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','14:32:32','','',1,1,1),(364,'Pedro','Cortez','Ojeda','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','14:45:50','','',1,1,1),(365,'Jose Ramon','Bermudez','Arroyo','BEAR700705HNTRRM09','BEAR7007056A5',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','14:50:07','','',1,1,1),(366,'Gilberto','De Dios','Ramirez','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','15:02:16','','',1,1,2),(367,'Maria Elena','De Dios','Contreras','DICE690307MNTSNL04','DICE690307A50',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','15:20:43','','',1,1,2),(368,'Francisco','Estrada','Padilla','EAPF520131HNTSDR03','EAPF520131JX8',1,'0','0','El Cuarenteñ0','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','18:12:44','','',1,1,2),(369,'Dorotea Isabel','Garcia','Isiordia','GAID730925MNTRSR01','GAID730925580',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','18:19:26','','',1,1,2),(370,'Eduardo','Islas','Arroyo','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','18:34:15','','',1,1,2),(371,'Nelson','Ledesma','Aleman','LEAN781222HNTDLL06','LEAN781222ET9',1,'0','0','Puerta De Platanares','63613',1,1,5,23,43,'NO',1,1,'2021-11-19','18:43:51','','',1,1,1),(372,'Aurelio','Mora','Martinez','MOMA570926HNTRRR00','MOMA5709266Y5',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','18:52:18','','',1,1,2),(373,'Maria De Jesus','Rosales','Estrada','ROEJ731006MSLSSS06','ROED7310061X7',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','19:13:40','','',1,1,2),(374,'Mirna Isabel','Soto','Isiordia','SOIM711108MNTTSR09','SOIM711108K80',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','19:21:56','','',1,1,2),(375,'Ana Maria','Estrada','Padilla','EAPA500728MNTSDN00','EAPA5007281K9',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','19:41:33','','',1,1,1),(376,'Marcelina','Hernandez','De Dios','HEDM490602MNTRSR04','HEDM490602BZ3',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','19:51:15','','',1,1,2),(377,'Alberto','Altamirano','De Dios','AADA470507HNTLSL06','AADA470407',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','19:57:24','','',1,1,2),(378,'Jose Manuel','Castro','Altamirano','CAAM711222HNTSLN06','CAAM7112223N1',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','20:08:20','','',1,1,2),(379,'Juan','Hernandez','Padilla','HEPJ611226HNTRDN02','HEPJ6112269W5',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','20:17:39','','',1,1,2),(380,'Maria Concepcion','Huerta','Benavides','HUBC510524MNTRNN09','HUBC510524',2,'0','0','El Cuarenteño','63782',1,1,5,23,43,'NO',1,1,'2021-11-19','20:28:41','','',1,1,2),(381,'Avelina','Ojeda','Padilla','OEPA670225MNTJDV04','OEPA670225JJ7',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','20:38:31','','',1,1,2),(382,'Lauro','Ojeda','Padilla','OEPL521210HNTJDR03','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','21:10:12','','',1,1,2),(386,'Armando','Ojeda','Salas','OESA641130HNTJLR09','OESA6411301J0',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','21:38:08','','',1,1,2),(387,'Erika Paloma','Ocampo','Castro','OACE871214MNTCSR08','OACE871214QL4',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-19','21:47:15','','',1,1,1),(388,'Zulma Lizeth','Dueñas ','Ojeda','DUOZ801216MNTXJL','DUOZ801216UC6',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-20','00:28:51','','',1,1,1),(389,'Maria Del Socorro','De Anda','Ocegueda','AAOS690731MNTNCC02','AAOS690731HR2',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-20','00:33:00','','',1,1,1),(390,'Maria Clara','Altamirano','Estrada','AAEC650812MNTLSL03','AAEC6408122G6',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-20','00:37:30','','',1,1,1),(391,'Ana Luisa','Altamirano','Estrada','AAEA710629MNTLSN01','AAEA710629NHA',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-20','00:41:42','','',1,1,1),(392,'Eva Luz','Altamirano','Estrada','AAEE780327MNTLSV04','AAEE780327SN9',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-20','00:48:46','','',1,1,1),(393,'Ivonne Graciela','Ruiz','Martinez','RUMI730116MNTZRV00','RUMI7301167W8',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-20','00:58:12','','',1,1,1),(394,'Maria Teresa','Dueñas','Ojeda','DUOT631015MNTXJR02','DUOT6310154J0',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-20','01:04:22','','',1,1,1),(395,'Ana Karina','Altamirano','Estrada','AAEA840811MNTLSN08','AAEA840811RI7',2,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2021-11-20','01:08:32','','',1,1,1),(396,'Angel Fernando','Altamirano','Dueñas','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2022-01-05','14:21:20','','',1,1,1),(397,'Gabriel','Rodriguez','Mora','S/D','S/D',1,'0','0','El Cuarenteño','63783',1,1,5,23,43,'NO',1,1,'2022-01-05','14:23:57','','',1,1,2),(398,'Juana Patricia','Castañeda','Lopez','S/D','S/D',2,'0','0','La Yerba','63519',1,1,4,17,27,'NO',1,1,'2022-01-18','10:44:32','','',1,1,1);
/*!40000 ALTER TABLE `personaf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personam`
--

DROP TABLE IF EXISTS `personam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personam` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RazonSocial` varchar(95) DEFAULT NULL,
  `NombreCorto` varchar(45) NOT NULL,
  `ClaveCorte` varchar(5) DEFAULT NULL,
  `IdentificacionFiscal` varchar(45) NOT NULL,
  `Telefono` blob DEFAULT NULL,
  `Email` blob DEFAULT NULL,
  `PaginaWeb` blob DEFAULT NULL,
  `Direccion` varchar(85) NOT NULL,
  `CodigoPostal` varchar(25) NOT NULL,
  `ID_Pais` int(10) unsigned NOT NULL,
  `ID_Estado` int(10) unsigned NOT NULL,
  `ID_Municipio` int(10) unsigned NOT NULL,
  `ID_Localidad` int(10) unsigned NOT NULL,
  `ID_EjidoColonia` int(10) unsigned NOT NULL,
  `Foto` longblob DEFAULT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  `estadoSocio` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personam`
--

LOCK TABLES `personam` WRITE;
/*!40000 ALTER TABLE `personam` DISABLE KEYS */;
INSERT INTO `personam` VALUES (1,'Cafetaleros El Astal S.P.R De R.L.','Astal','AS','CAS120109E85',' ',' ',' ','Conocido S/N','0',1,1,4,17,27,'NO',1,1,'2020-10-08','14:39:36','','',1,1,0),(2,'Basilio De Dios Ortega Del Cuarenteño','Basilio','AD','BDO940522U76','','','','Conocido S/N','0',1,1,5,23,43,'NO',1,1,'2020-10-08','14:42:45','','',1,1,0),(3,'Cafeticultores De Cordon Del Jilguero S.P.R De R.L','Cafeico','CT','CCJ970627AM7','','','','Conocido S/N','',1,1,2,4,5,'NO',1,1,'2020-10-08','14:44:08','','',1,2,0),(4,'Cafes Sustentables De Mexico S. De R.L. De C.V','Cafesumex','CS','CSM0305269J3','2103599','','www.cafesumex.com','Nayarit #290 ','63117',1,1,4,20,37,'NO',1,1,'2020-10-08','14:45:44','','',1,1,0),(5,'Cofradia De Chocolon','Caldio','CC','CFC120228CC1','','','','Conocido S/N','0',1,1,5,22,1,'NO',1,1,'2020-10-08','14:49:06','','',1,1,0),(6,'Cerro De Los Cuernos S.P.R. De R.L.','Cuerno','C','S/D',' ',' ',' ','Conocido S/N','0',1,1,2,9,13,'NO',1,1,'2020-10-08','14:50:44','','',1,1,0),(7,'Productores Del Campo Cafe Aguacate Y Mas S.P.R. De R.L','Procaa','AI','PCC0702191LO','','','','Conocido S/N','0',1,1,5,23,43,'NO',1,1,'2020-10-08','14:52:01','','',1,1,0),(8,'Productores De Cafe De La Riviera De Xalisco S.P.R De R.L.','Riviera','AG','PCR111208KA0','','','','Conocido S/N','0',1,1,5,23,43,'NO',1,1,'2020-10-08','14:53:43','','',1,1,0),(9,'Cerro Del Tambor S.P.R. De R.L.','Tambor','TA','CTA020508UD2','','','','Conocido S/N','0',1,1,3,12,19,'NO',1,1,'2020-10-08','14:54:30','','',1,1,0),(10,'Grupo Terruño Nayarita  S. De R.L. De C.V.','GTN','S/C','S/D','3112103599','','www.gtnay.com','Nayarit #290','63160',1,1,4,20,37,'NO',1,1,'2020-10-08','14:55:52','','',1,1,0),(11,'El Malinal','Malinal','MA','0','0','0','0','El Malinal','637000',1,1,5,25,1,'NO',1,1,'2020-11-11','11:29:34','','',1,1,0);
/*!40000 ALTER TABLE `personam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personatree`
--

DROP TABLE IF EXISTS `personatree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personatree` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `ID_Padre` int(10) unsigned NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `HoraCreacion` time(6) NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personatree`
--

LOCK TABLES `personatree` WRITE;
/*!40000 ALTER TABLE `personatree` DISABLE KEYS */;
/*!40000 ALTER TABLE `personatree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `porcentaje_cultivos`
--

DROP TABLE IF EXISTS `porcentaje_cultivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `porcentaje_cultivos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_parcela` int(11) NOT NULL,
  `id_cultivo` int(11) NOT NULL,
  `porcentaje` double NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `porcentaje_cultivos`
--

LOCK TABLES `porcentaje_cultivos` WRITE;
/*!40000 ALTER TABLE `porcentaje_cultivos` DISABLE KEYS */;
INSERT INTO `porcentaje_cultivos` VALUES (5,1,1,80,1,1,'2021-07-14','10:14:50','','',1,1),(6,1,2,20,1,1,'2021-07-14','10:14:50','','',1,1);
/*!40000 ALTER TABLE `porcentaje_cultivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `porcentaje_variedades`
--

DROP TABLE IF EXISTS `porcentaje_variedades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `porcentaje_variedades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_parcela` int(11) NOT NULL,
  `id_variedad` int(11) NOT NULL,
  `porcentaje` double NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `porcentaje_variedades`
--

LOCK TABLES `porcentaje_variedades` WRITE;
/*!40000 ALTER TABLE `porcentaje_variedades` DISABLE KEYS */;
INSERT INTO `porcentaje_variedades` VALUES (5,1,24,90,1,1,'2021-07-14','10:14:50','','',1,1),(6,1,1,10,1,1,'2021-07-14','10:14:50','','',1,1);
/*!40000 ALTER TABLE `porcentaje_variedades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preciocafesociedad`
--

DROP TABLE IF EXISTS `preciocafesociedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preciocafesociedad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_Sociedad` int(11) NOT NULL,
  `id_formaCafe` int(11) NOT NULL,
  `id_Retencion` int(11) NOT NULL,
  `precioKg` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preciocafesociedad`
--

LOCK TABLES `preciocafesociedad` WRITE;
/*!40000 ALTER TABLE `preciocafesociedad` DISABLE KEYS */;
INSERT INTO `preciocafesociedad` VALUES (1,1,1,1,'12'),(2,3,1,1,'6.5'),(3,9,1,1,'6.5'),(4,2,1,1,'6.5'),(5,5,1,1,'6.5'),(6,7,1,1,'10'),(7,8,1,1,'6.5'),(8,6,1,1,'6.5'),(9,4,1,1,'6.5');
/*!40000 ALTER TABLE `preciocafesociedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procesocafe`
--

DROP TABLE IF EXISTS `procesocafe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procesocafe` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Clave` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procesocafe`
--

LOCK TABLES `procesocafe` WRITE;
/*!40000 ALTER TABLE `procesocafe` DISABLE KEYS */;
INSERT INTO `procesocafe` VALUES (1,'PR','Sin Proceso',1,1,'2019-08-12','09:34:33','','',1,1),(2,'NL','No Lavado',1,1,'2019-08-12','09:35:03','','',1,1),(3,'SL','Semi Lavado',1,1,'2019-08-12','09:35:27','','',1,1),(4,'LA','Lavado',1,1,'2019-08-12','09:35:51','','',1,1);
/*!40000 ALTER TABLE `procesocafe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productor`
--

DROP TABLE IF EXISTS `productor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `clave_productor` varchar(45) NOT NULL,
  `tipoPersona` int(11) NOT NULL,
  `id_situacion` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=391 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productor`
--

LOCK TABLES `productor` WRITE;
/*!40000 ALTER TABLE `productor` DISABLE KEYS */;
INSERT INTO `productor` VALUES (1,1,'CPCGVALDEZ21',1,1),(2,2,'703802532',1,1),(3,3,'704047066',1,1),(4,4,'703802616',1,1),(5,5,'703803362',1,1),(6,6,'703802599',1,1),(7,7,'TEMP01',1,1),(8,8,'703817751',1,1),(9,9,'703802472',1,1),(10,10,'703802392',1,1),(11,11,'703803403',1,1),(12,12,'703821278',1,1),(13,13,'703802870',1,1),(14,14,'TEMP02',1,1),(15,15,'704048103',1,1),(16,16,'703803478',1,1),(17,17,'703802542',1,1),(18,18,'705034452',1,1),(19,19,'703802372',1,1),(20,20,'703802691',1,1),(21,21,'F18000019',1,1),(22,22,'703803495',1,1),(23,23,'703803417',1,1),(24,24,'704047061',1,1),(25,25,'704165197',1,1),(26,26,'703802536',1,1),(27,27,'TEMP30',1,1),(28,28,'703803440',1,1),(29,29,'TEMP31',1,1),(30,30,'703817726',1,1),(31,31,'700252137',1,1),(32,32,'703802406',1,1),(33,33,'TEMP32',1,1),(34,35,'703798158',1,1),(35,36,'TEMP39',1,1),(36,37,'703802691',1,1),(37,38,'703817722',1,1),(38,39,'703802529',1,1),(39,40,'703802354',1,1),(40,41,'703802563',1,1),(41,42,'703817765',1,1),(42,43,'703802482',1,1),(43,44,'F18000684',1,1),(44,45,'703802567',1,1),(45,46,'703802331',1,1),(46,47,'703803456',1,1),(47,48,'704426113',1,1),(48,49,'703814393',1,1),(49,50,'703817281',1,1),(50,51,'703802345',1,1),(51,52,'704165194',1,1),(52,53,'703802651',1,1),(53,54,'TEMP29',1,1),(54,55,'703814401',1,1),(55,56,'703802504',1,1),(56,57,'703802621',1,1),(57,58,'TEMP03',1,1),(58,59,'2019011801',1,1),(59,61,'703802462',1,1),(60,62,'704839956',1,1),(61,63,'703806013',1,1),(62,64,'703808944',1,1),(63,65,'703808994',1,1),(64,66,'703808925',1,1),(65,67,'703817279',1,1),(66,69,'TEMP73',1,1),(67,68,'TEMP72',1,1),(68,70,'704338563',1,1),(69,71,'TEMP75',1,1),(70,72,'TEMP76',1,1),(71,73,'703818530',1,1),(72,74,'703802179',1,1),(73,75,'700194505',1,1),(74,76,'703814619',1,1),(75,77,'TEMP34',1,1),(76,78,'703809480',1,1),(77,79,'700194159',1,1),(78,80,'TEMP12',1,1),(79,81,'F18000119',1,1),(80,82,'703805790',1,1),(81,83,'703806106',1,1),(82,84,'TEMP74',1,1),(83,85,'703806010',1,1),(84,86,'703818559',1,1),(85,87,'TEMP09',1,1),(86,88,'TEMP07',1,1),(87,89,'TEMP06',1,1),(88,90,'703814447',1,1),(89,91,'TEMP11',1,1),(90,92,'700007869',1,1),(91,93,'703796047',1,1),(92,94,'703796062',1,1),(93,95,'703808976',1,1),(94,96,'703809000',1,1),(95,97,'704165213',1,1),(96,98,'TEMP10',1,1),(97,99,'TEMP08',1,1),(98,100,'TEMP94',1,1),(99,101,'703803661',1,1),(100,102,'TEMP210322',1,1),(101,103,'F18000133',1,1),(102,104,'704338555',1,1),(103,105,'CTEMP1702211',1,1),(104,106,'TEMP210218',1,1),(105,107,'TEMP2102185',1,1),(106,108,'TEMP2102189',1,1),(107,109,'703808989',1,1),(108,110,'TEMP210219',1,1),(109,111,'TEMP2102195',1,1),(110,112,'TEMP210220',1,1),(111,113,'TEMP210222',1,1),(112,114,'703797990',1,1),(113,115,'TEMP2102223',1,1),(114,116,'TEMP2102225',1,1),(115,117,'TEMP2102226',1,1),(116,118,'TEMP210223',1,1),(117,119,'TEMP2102232',1,1),(118,120,'703796052',1,1),(119,121,'TEMP210225',1,1),(120,122,'TEMP210226',1,1),(121,123,'TEMP2102262',1,1),(122,124,'TEMP210305',1,1),(123,125,'TEMP210310',1,1),(124,126,'703794153',1,1),(125,127,'TEMP210319',1,1),(126,128,'TEMP210305',1,1),(127,129,'TEMP210407',1,1),(128,130,'TEMP210406',1,1),(129,131,'704047884',1,1),(130,132,'703809573',1,1),(131,133,'703809506',1,1),(132,134,'F18000409',1,1),(133,135,'703809628',1,1),(134,136,'700251781',1,1),(135,137,'F18000382',1,1),(136,138,'703809761',1,1),(137,139,'700251897',1,1),(138,140,'700008154',1,1),(139,141,'703809635',1,1),(140,142,'701212282',1,1),(141,143,'703809684',1,1),(142,144,'704047927',1,1),(143,145,'703809516',1,1),(144,146,'704048133',1,1),(145,147,'703809526',1,1),(146,148,'703809589',1,1),(147,149,'704047888',1,1),(148,150,'703809725',1,1),(149,151,'703809704',1,1),(150,152,'703809478',1,1),(151,153,'703817607',1,1),(152,154,'TEMP80',1,1),(153,155,'703809758',1,1),(154,156,'TEMP84',1,1),(155,157,'TEMP89',1,1),(156,158,'703809614',1,1),(157,159,'704047855',1,1),(158,160,'703809699',1,1),(159,161,'703809686',1,1),(160,162,'F18000020',1,1),(161,163,'TEMP184',1,1),(162,164,'703809745',1,1),(163,165,'TEMP91',1,1),(164,166,'TEMP65',1,1),(165,167,'TEMP92',1,1),(166,168,'703821577',1,1),(167,169,'703809750',1,1),(168,170,'703811503',1,1),(169,171,'703809619',1,1),(170,172,'701864207',1,1),(171,173,'703809725',1,2),(172,174,'TEMP74',1,1),(173,175,'704233244',1,1),(174,176,'700008749',1,1),(175,177,'700008894',1,1),(176,178,'703809494',1,1),(177,179,'703821941',1,1),(178,180,'704233246',1,1),(179,181,'700008916',1,1),(180,182,'704233246',1,1),(181,183,'TEMP62',1,1),(182,184,'1821828',1,1),(183,185,'TEMP69',1,1),(184,186,'TEMP90',1,1),(185,187,'703811478',1,1),(186,188,'703809484',1,1),(187,189,'TEMP71',1,1),(188,190,'700065327',1,1),(189,191,'701149823',1,1),(190,192,'700251869',1,1),(191,193,'703809715',1,1),(192,194,'704841465',1,1),(193,195,'703809523',1,1),(194,196,'700251847',1,1),(195,197,'704047867',1,1),(196,198,'703809731',1,1),(197,199,'700251897',1,1),(198,200,'700008916',1,1),(199,201,'703809633',1,1),(200,202,'TEMP147',1,1),(201,203,'1825397',1,1),(202,204,'700251939',1,1),(203,205,'F18000306',1,1),(204,206,'703809645',1,1),(205,207,'TEMP182',1,1),(206,208,'TEMP86',1,1),(207,209,'TEMP81',1,1),(208,212,'CPTEMPCV1',1,1),(209,213,'703809518',1,1),(210,214,'700246675',1,1),(211,215,'703809491',1,1),(212,216,'1795304',1,1),(213,217,'F1800617',1,1),(214,218,'700274917',1,1),(215,219,'700330644',1,1),(216,220,'703809531',1,1),(217,221,'700274931',1,1),(218,222,'1795370',1,1),(219,223,'TEMP01',1,1),(220,224,'700267759',1,1),(221,225,'1795320',1,1),(222,226,'TEMP02',1,1),(223,227,'1795369',1,1),(224,228,'700274859',1,1),(225,229,'703809499',1,1),(226,230,'1795344',1,1),(227,231,'700246609',1,1),(228,232,'703809524',1,1),(229,233,'1795616',1,1),(230,234,'703809035',1,1),(231,235,'700279135',1,1),(232,236,'703508360',1,1),(233,237,'703809033',1,1),(234,238,'700279085',1,1),(235,239,'703808921',1,1),(236,240,'703817824',1,1),(237,241,'703809049',1,1),(238,242,'1821816',1,1),(239,243,'703814688',1,1),(240,244,'703809019',1,1),(241,245,'703809060',1,1),(242,246,'TEMP93',1,1),(243,247,'703805925',1,1),(244,248,'703809016',1,1),(245,249,'TEMP95',1,1),(246,250,'TEMP18',1,1),(247,251,'TEMP16',1,1),(248,252,'1821915',1,1),(249,253,'TEMP51',1,1),(250,254,'703514692',1,1),(251,255,'TEMP51',1,1),(252,256,'TEMP55',1,1),(253,258,'CTEMPJC1',1,1),(254,259,'PTEMPJC2',1,1),(255,260,'TEMP16',1,1),(256,261,'703808983',1,1),(257,262,'TEMP23',1,1),(258,263,'1777439',1,1),(259,264,'TEMP24',1,1),(260,265,'TEMP25',1,1),(261,266,'703806037',1,1),(262,267,'1777412',1,1),(263,268,'TEMP26',1,1),(264,269,'F18000594',1,1),(265,270,'704165235',1,1),(266,271,'704165221',1,1),(267,272,'703794166',1,1),(268,273,'TEMP27',1,1),(269,274,'703794167',1,1),(270,275,'700251587',1,1),(271,276,'703811506',1,1),(272,277,'703811534',1,1),(273,278,'703811509',1,1),(274,279,'700189122',1,1),(275,280,'703818532',1,1),(276,281,'701193499',1,1),(277,282,'1824270',1,1),(278,283,'703811518',1,1),(279,284,'700189502',1,1),(280,285,'703811516',1,1),(281,286,'700061834',1,1),(282,287,'703809763',1,1),(283,288,'703814363',1,1),(284,289,'TEMP28',1,1),(285,290,'703811481',1,1),(286,291,'702306418',1,1),(287,292,'1824268',1,1),(288,293,'700251653',1,1),(289,294,'703818465',1,1),(290,295,'703818500',1,1),(291,296,'703811529',1,1),(292,297,'704338697',1,1),(293,298,'703818522',1,1),(294,299,'704338697',1,1),(295,300,'TEMP33',1,1),(296,301,'703797969',1,1),(297,302,'703798030',1,1),(298,303,'703821942',1,1),(299,304,'703809022',1,1),(300,305,'703817664',1,1),(301,306,'F18000066',1,1),(302,307,'703817659',1,1),(303,308,'700194861',1,1),(304,309,'703817571',1,1),(305,310,'704165163',1,1),(306,311,'TEMP89',1,1),(307,312,'700195549',1,1),(308,313,'703817587',1,1),(309,314,'703817525',1,1),(310,315,'TEMP92',1,1),(311,316,'703817657',1,1),(312,317,'703817525',1,1),(313,318,'703817612',1,1),(314,319,'TEMP93',1,1),(315,320,'F18000029',1,1),(316,321,'1823729',1,1),(317,322,'703817654',1,1),(318,323,'704165133',1,1),(319,324,'703817617',1,1),(320,325,'703817702',1,1),(321,326,'TEMP95',1,1),(322,327,'703817595',1,1),(323,328,'703817643',1,1),(324,329,'1823775',1,1),(325,330,'703802063',1,1),(326,331,'1777234',1,1),(327,332,'703817665',1,1),(328,333,'TEMP99',1,1),(329,334,'703817623',1,1),(330,335,'703817558',1,1),(331,336,'703817672',1,1),(332,337,'1823742',1,1),(333,338,'1823785',1,1),(334,339,'703817554',1,1),(335,340,'703805833',1,1),(336,341,'703797922',1,1),(337,342,'F18000494',1,1),(338,343,'703822156',1,1),(339,344,'703805876',1,1),(340,345,'703798016',1,1),(341,346,'703794164',1,1),(342,347,'703818538',1,1),(343,348,'703805904',1,1),(344,349,'703797918',1,1),(345,350,'703798003',1,1),(346,351,'703806108',1,1),(347,352,'703808942',1,1),(348,353,'703805902',1,1),(349,354,'703806085',1,1),(350,355,'703814629',1,1),(351,356,'703797954',1,1),(352,357,'703796065',1,1),(353,358,'TEMP13',1,1),(354,359,'TEMP14',1,1),(355,360,'F18000493',1,1),(356,361,'TEMP15',1,1),(357,362,'703814631',1,1),(358,363,'704048007',1,1),(359,364,'703805779',1,1),(360,365,'703808107',1,1),(361,366,'703797941',1,1),(362,367,'704095152',1,1),(363,368,'703805993',1,1),(364,369,'703806003',1,1),(365,370,'TEMP20',1,1),(366,371,'TEMP21',1,1),(367,372,'703814446',1,1),(368,373,'TEMP21',1,1),(369,374,'703809024',1,1),(370,375,'703808998',1,1),(371,376,'704338563',1,1),(372,377,'703794156',1,1),(373,378,'703809007',1,1),(374,379,'703821933',1,1),(375,380,'703798027',1,1),(376,381,'703806072',1,1),(377,382,'700007801',1,1),(378,386,'703808965',1,1),(379,387,'TEMP030221',1,1),(380,388,'703805766',1,1),(381,389,'703814627',1,1),(382,390,'TEMP18',1,1),(383,391,'703821574',1,1),(384,392,'703806080',1,1),(385,393,'703821571',1,1),(386,394,'TEMP1002212',1,1),(387,395,'TEMPY0403211',1,1),(388,396,'TEMP040122',1,1),(389,397,'TEMP0401221',1,1),(390,398,'TEMP180122',1,1);
/*!40000 ALTER TABLE `productor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puestos`
--

DROP TABLE IF EXISTS `puestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puestos` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puestos`
--

LOCK TABLES `puestos` WRITE;
/*!40000 ALTER TABLE `puestos` DISABLE KEYS */;
/*!40000 ALTER TABLE `puestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recepciones`
--

DROP TABLE IF EXISTS `recepciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recepciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSociedad` int(11) NOT NULL,
  `nombrecorto` varchar(50) NOT NULL,
  `idRecepcion` varchar(45) NOT NULL,
  `idResponsable` int(11) NOT NULL,
  `idCapturista` int(11) NOT NULL,
  `domicilio` varchar(85) NOT NULL,
  `telefono` int(11) NOT NULL,
  `idLocalidad` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recepciones`
--

LOCK TABLES `recepciones` WRITE;
/*!40000 ALTER TABLE `recepciones` DISABLE KEYS */;
INSERT INTO `recepciones` VALUES (1,1,'','RE-AS-1',76,563,'Re-Yerba/Jacinto (Conocido S/N)',0,17,'',2),(2,1,'','RE-AS-2',563,718,'Re-Yerba/Fernando (Conocido S/N)',0,17,'',2),(3,2,'Recepcion Sandia','RE-AD-3',8,714,'Sandia/Basilio (Conocido S/N)',0,23,'',1),(4,3,'','RE-CT-4',26,716,'Paulino (Conocido S/N)',0,4,'',2),(5,3,'','RE-CT-5',715,716,'Piña (Conocido S/N)',0,4,'',2),(6,4,'Recepcion CSM','RE-CS-6',10,24,'Sandia/Hector (Conocido S/N)',0,23,'',1),(7,5,'Recepcion Pantano','RE-CC-7',719,24,'Pantano (Conocido S/N)',0,22,'',1),(8,6,'Recepcion B Colorado 2','RE-C-8',191,191,'Presidio/Diego (Conocido S/N)',0,9,'',1),(9,6,'Recepcion Guajolote','RE-C-9',201,191,'Guajolote/Griseldo (Conocido S/N)',0,9,'',1),(10,6,'Recepcion Sombrero','RE-C-10',211,191,'Sombrero/Magdaleno (Conocido S/N)',0,9,'',1),(11,6,'Recepcion B Colorado','RE-C-11',195,191,'BColorado/Agustin (Conocido S/N)',0,9,'',1),(12,6,'Recepcion Tempizque','RE-C-12',194,191,'Tempizque/Delfino (Conocido S/N)',0,9,'',1),(13,6,'','RE-C-13',198,191,'BColorado2/Bonifacio (Conocido S/N)',0,9,'',2),(14,7,'Recepcion Rustico','RE-AI-14',349,350,'Rustico (Conocido S/N)',0,23,'',1),(15,8,'','RE-AG-15',8,714,'Sandia/Riviera (Conocido S/N)',0,23,'',2),(16,8,'Recepcion Cora','RE-AG-16',146,714,'El Cora (Conocido S/N)',0,23,'',1),(17,9,'Recepcion Melon','RE-TA-17',265,496,'Tambor (Conocido S/N)',0,12,'',1),(18,1,'Recepcion Israel','RE-AS-18',61,60,'Recepción Israel (Conocido S/N)',0,17,'',1);
/*!40000 ALTER TABLE `recepciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibos`
--

DROP TABLE IF EXISTS `recibos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idRecepcion` varchar(35) NOT NULL,
  `idLote` varchar(25) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `idParcela` int(11) NOT NULL,
  `idSociedad` int(11) NOT NULL,
  `folioManual` varchar(10) NOT NULL,
  `formaCafe` varchar(55) NOT NULL,
  `sacos` int(30) NOT NULL,
  `kgRecibidos` int(30) NOT NULL,
  `totalBruto` varchar(30) NOT NULL,
  `retencion` varchar(30) NOT NULL,
  `total` varchar(30) NOT NULL,
  `precioNeto` varchar(10) NOT NULL,
  `verdes` varchar(25) NOT NULL,
  `inmaduros` varchar(25) NOT NULL,
  `brocados` varchar(25) NOT NULL,
  `calificacion` varchar(25) NOT NULL,
  `personaEntrego` varchar(100) NOT NULL,
  `personaRecibio` varchar(100) NOT NULL,
  `observaciones` varchar(500) NOT NULL,
  `fechaRecepcion` varchar(50) NOT NULL,
  `horaRecepcion` varchar(35) NOT NULL,
  `fechaCreacion` varchar(50) NOT NULL,
  `horaCreacion` varchar(20) NOT NULL,
  `precioBrutoKgSociedad` varchar(15) NOT NULL,
  `precioNetoKgSociedad` varchar(15) NOT NULL,
  `retencionKgSociedad` varchar(15) NOT NULL,
  `id_situacion` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibos`
--

LOCK TABLES `recibos` WRITE;
/*!40000 ALTER TABLE `recibos` DISABLE KEYS */;
INSERT INTO `recibos` VALUES (1,'RE-AS-18','AS18-22010-AB-2',50,66,1,'','Cereza',1,45,'450.00','.00','450.00','10.00','0','35','6','2 Amarillo','Marcos Bartolo Urias Chavez','Jose Israel Vergara Martinez','','2022-01-10','','2022-01-10','18:53:54','10.00','10.00','.00',1),(2,'RE-AS-18','AS18-22010-AB-2',53,73,1,'','Cereza',4,168,'1680.00','.00','1680.00','10.00','0','35','9','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-10','','2022-01-10','18:56:51','10.00','10.00','.00',1),(3,'RE-AS-18','AS18-22011-AB-2',50,66,1,'','Cereza',1,43,'430.00','.00','430.00','10.00','0','31','5','2 Amarillo','Marcos Bartolo Urias Chavez','Jose Israel Vergara Martinez','','2022-01-11','','2022-01-11','15:32:04','10.00','10.00','.00',1),(4,'RE-AS-18','AS18-22011-AD-2',54,75,1,'','Cereza',1,24,'240.00','.00','240.00','10.00','0','38','3','2 Amarillo','Savino Delfin','Jose Israel Vergara Martinez','','2022-01-11','','2022-01-11','15:50:19','10.00','10.00','.00',1),(5,'RE-AS-18','AS18-22011-AB-2',53,73,1,'','Cereza',2,96,'960.00','.00','960.00','10.00','0','40','9','2 Amarillo','Nelson  Mendez ','Jose Israel Vergara Martinez','','2022-01-11','','2022-01-11','16:23:39','10.00','10.00','.00',1),(6,'RE-AS-18','AS18-22011-AB-2',47,63,1,'','Cereza',5,210,'2100.00','.00','2100.00','10.00','0','44','4','2 Amarillo','Maria Felix Lopez De La O','Jose Israel Vergara Martinez','','2022-01-11','','2022-01-11','16:31:43','10.00','10.00','.00',1),(7,'RE-AS-18','AS18-22013-AB-2',53,73,1,'','Cereza',4,178,'1780.00','.00','1780.00','10.00','0','38','11','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-13','','2022-01-13','15:56:52','10.00','10.00','.00',1),(8,'RE-AS-18','AS18-22013-AD-2',54,75,1,'','Cereza',2,62,'620.00','.00','620.00','10.00','0','43','3','2 Amarillo','Sabino Delfin','Jose Israel Vergara Martinez','','2022-01-13','','2022-01-13','16:33:53','10.00','10.00','.00',1),(9,'RE-AS-18','AS18-22013-AB-2',40,48,1,'','Cereza',2,84,'840.00','.00','840.00','10.00','0','44','5','2 Amarillo','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-13','','2022-01-13','16:38:44','10.00','10.00','.00',1),(10,'RE-AS-18','AS18-22014-AD-3',6,9,1,'','Cereza',3,105,'1050.00','.00','1050.00','10.00','0','70','6','3 Rosa','Gonzalo Aldair Portillo','Jose Israel Vergara Martinez','','2022-01-14','','2022-01-14','15:29:42','10.00','10.00','.00',1),(11,'RE-AS-18','AS18-22014-AD-3',18,26,1,'','Cereza',2,58,'580.00','.00','580.00','10.00','0','50','8','3 Rosa','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-14','','2022-01-14','15:34:51','10.00','10.00','.00',1),(12,'RE-AS-18','AS18-22014-AD-2',41,49,1,'','Cereza',2,69,'690.00','.00','690.00','10.00','0','28','3','2 Amarillo','Benjamin Carrillo','Jose Israel Vergara Martinez','','2022-01-14','','2022-01-14','15:39:08','10.00','10.00','.00',1),(13,'RE-AS-18','AS18-22014-AB-3',53,73,1,'','Cereza',1,42,'420.00','.00','420.00','10.00','0','57','16','3 Rosa','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-14','','2022-01-14','15:51:29','10.00','10.00','.00',1),(14,'RE-AS-18','AS18-22014-AB-3',40,48,1,'','Cereza',3,110,'1100.00','.00','1100.00','10.00','0','60','9','3 Rosa','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-14','','2022-01-14','16:28:59','10.00','10.00','.00',1),(15,'RE-AS-18','AS18-22015-AD-3',54,75,1,'','Cereza',1,37,'370.00','.00','370.00','10.00','0','15','51','3 Rosa','Sabino Delfin','Jose Israel Vergara Martinez','','2022-01-15','','2022-01-15','13:22:58','10.00','10.00','.00',1),(16,'RE-AS-18','AS18-22015-AB-3',47,63,1,'','Cereza',5,197,'1970.00','.00','1970.00','10.00','0','115','8','3 Rosa','Maria Felix Lopez De La O','Jose Israel Vergara Martinez','','2022-01-15','','2022-01-15','13:29:58','10.00','10.00','.00',1),(17,'RE-AS-18','AS18-22015-AB-3',53,73,1,'','Cereza',2,68,'680.00','.00','680.00','10.00','0','52','4','3 Rosa','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-15','','2022-01-15','13:34:57','10.00','10.00','.00',1),(18,'RE-AS-18','AS18-22015-AD-3',41,49,1,'','Cereza',2,46,'460.00','.00','460.00','10.00','2','40','6','3 Rosa','Alma Casteñeda Lopez','Jose Israel Vergara Martinez','','2022-01-15','','2022-01-15','13:44:34','10.00','10.00','.00',1),(19,'RE-AS-18','AS18-22015-AD-3',18,26,1,'','Cereza',1,45,'450.00','.00','450.00','10.00','0','48','4','3 Rosa','Domimgo Sanchez','Jose Israel Vergara Martinez','','2022-01-15','','2022-01-15','14:10:17','10.00','10.00','.00',1),(20,'RE-AS-18','AS18-22015-AD-3',6,9,1,'','Cereza',6,197,'1970.00','.00','1970.00','10.00','2','80','16','3 Rosa','Jaciel Velasquez Potillo','Jose Israel Vergara Martinez','','2022-01-15','','2022-01-15','14:59:09','10.00','10.00','.00',1),(21,'RE-AS-18','AS18-22015-AB-3',40,48,1,'','Cereza',1,80,'800.00','.00','800.00','10.00','0','70','4','3 Rosa','Rodolfo  Carrillo ','Jose Israel Vergara Martinez','','2022-01-15','','2022-01-15','15:29:39','10.00','10.00','.00',1),(22,'RE-AS-18','AS18-22017-AD-3',11,15,1,'','Cereza',5,175,'1750.00','.00','1750.00','10.00','0','72','3','3 Rosa','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-17','','2022-01-17','15:53:20','10.00','10.00','.00',1),(23,'RE-AS-18','AS18-22017-AD-3',6,9,1,'','Cereza',4,159,'1590.00','.00','1590.00','10.00','0','62','13','3 Rosa','Gonzalo Aldair Velazquez','Jose Israel Vergara Martinez','','2022-01-17','','2022-01-17','16:02:46','10.00','10.00','.00',1),(24,'RE-AS-18','AS18-22017-AB-3',45,57,1,'','Cereza',5,133,'1330.00','.00','1330.00','10.00','0','46','13','3 Rosa','J Jesus Jimenez Esparza','Jose Israel Vergara Martinez','','2022-01-17','','2022-01-17','16:22:16','10.00','10.00','.00',1),(25,'RE-AS-18','AS18-22017-AB-3',53,73,1,'','Cereza',3,117,'1170.00','.00','1170.00','10.00','0','56','3','3 Rosa','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-17','','2022-01-17','16:33:12','10.00','10.00','.00',1),(26,'RE-AS-18','AS18-22017-AB-3',40,48,1,'','Cereza',3,115,'1150.00','.00','1150.00','10.00','0','55','2','3 Rosa','Rodolfo  Carrillo ','Jose Israel Vergara Martinez','','2022-01-17','','2022-01-17','16:41:33','10.00','10.00','.00',1),(27,'RE-AS-18','AS18-22017-AD-2',9,12,1,'','Cereza',6,164,'1640.00','.00','1640.00','10.00','0','15','8','2 Amarillo','Agustina Chavez Martinez','Jose Israel Vergara Martinez','','2022-01-17','','2022-01-17','16:54:45','10.00','10.00','.00',1),(28,'RE-AS-18','AS18-22017-AD-2',41,49,1,'','Cereza',2,67,'670.00','.00','670.00','10.00','0','16','5','2 Amarillo','Alma  Casteñeda Lopez','Jose Israel Vergara Martinez','','2022-01-17','','2022-01-17','17:06:45','10.00','10.00','.00',1),(29,'RE-AS-18','AS18-22018-AD-2',54,75,1,'','Cereza',1,43,'430.00','.00','430.00','10.00','0','45','4','2 Amarillo','Sabino Delfin','Jose Israel Vergara Martinez','','2022-01-18','','2022-01-18','16:01:22','10.00','10.00','.00',1),(30,'RE-AS-18','AS18-22018-AB-2',45,57,1,'','Cereza',4,144,'1440.00','.00','1440.00','10.00','3','35','5','2 Amarillo','J Jesus Jimenez Esparza','Jose Israel Vergara Martinez','','2022-01-18','','2022-01-18','16:09:55','10.00','10.00','.00',1),(31,'RE-AS-18','AS18-22018-AB-2',53,73,1,'','Cereza',2,74,'740.00','.00','740.00','10.00','0','35','4','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-18','','2022-01-18','16:17:53','10.00','10.00','.00',1),(32,'RE-AS-18','AS18-22018-AD-2',18,25,1,'','Cereza',4,166,'1660.00','.00','1660.00','10.00','0','25','10','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-18','','2022-01-18','16:27:15','10.00','10.00','.00',1),(33,'RE-AS-18','AS18-22018-AB-3',40,48,1,'','Cereza',6,205,'2050.00','.00','2050.00','10.00','3','45','19','3 Rosa','Rodolfo  Carrillo ','Jose Israel Vergara Martinez','','2022-01-18','','2022-01-18','16:39:20','10.00','10.00','.00',1),(34,'RE-AS-18','AS18-22018-AB-2',2,1,1,'','Cereza',1,22,'220.00','.00','220.00','10.00','0','27','2','2 Amarillo','Antonio Bañuelos ','Jose Israel Vergara Martinez','','2022-01-18','','2022-01-18','16:47:29','10.00','10.00','.00',1),(35,'RE-AS-18','AS18-22018-AD-2',9,12,1,'','Cereza',5,193,'1930.00','.00','1930.00','10.00','0','25','9','2 Amarillo','Agustina Chavez Martinez','Jose Israel Vergara Martinez','','2022-01-18','','2022-01-18','16:55:31','10.00','10.00','.00',1),(36,'RE-AS-18','AS18-22018-AD-3',6,9,1,'','Cereza',6,250,'2500.00','.00','2500.00','10.00','3','73','26','3 Rosa','Gonzalo Aldair Velazquez','Jose Israel Vergara Martinez','','2022-01-18','','2022-01-18','17:33:08','10.00','10.00','.00',1),(37,'RE-AS-18','AS18-22019-AB-2',45,57,1,'','Cereza',6,212,'2120.00','.00','2120.00','10.00','1','35','13','2 Amarillo','J Jesus Jimenez Esparza','Jose Israel Vergara Martinez','','2022-01-19','','2022-01-19','16:16:02','10.00','10.00','.00',1),(38,'RE-AS-18','AS18-22019-AB-3',40,48,1,'','Cereza',3,111,'1110.00','.00','1110.00','10.00','0','48','8','3 Rosa','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-19','','2022-01-19','16:23:02','10.00','10.00','.00',1),(39,'RE-AS-18','AS18-22019-AD-3',6,9,1,'','Cereza',8,309,'3090.00','.00','3090.00','10.00','0','65','11','3 Rosa','Gonzalo Aldair Velazquez','Jose Israel Vergara Martinez','','2022-01-19','','2022-01-19','16:30:25','10.00','10.00','.00',1),(40,'RE-AS-18','AS18-22019-AD-2',9,12,1,'','Cereza',3,122,'1220.00','.00','1220.00','10.00','0','30','15','2 Amarillo','Agustina Chavez Martinez','Jose Israel Vergara Martinez','','2022-01-19','','2022-01-19','16:53:57','10.00','10.00','.00',1),(41,'RE-AS-18','AS18-22019-AB-3',53,73,1,'','Cereza',1,38,'380.00','.00','380.00','10.00','0','70','2','3 Rosa','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-19','','2022-01-19','17:13:31','10.00','10.00','.00',1),(42,'RE-AS-18','AS18-22019-AB-3',51,70,1,'','Cereza',3,86,'860.00','.00','860.00','10.00','0','55','7','3 Rosa','Socorro Urias Chavez','Jose Israel Vergara Martinez','','2022-01-19','','2022-01-19','17:36:12','10.00','10.00','.00',1),(43,'RE-AS-18','AS18-22019-AB-2',51,70,1,'','Cereza',5,229,'2290.00','.00','2290.00','10.00','0','25','5','2 Amarillo','Socorro Urias Chavez','Jose Israel Vergara Martinez','','2022-01-19','','2022-01-19','17:38:03','10.00','10.00','.00',1),(44,'RE-AS-18','AS18-22019-AD-3',18,25,1,'','Cereza',2,59,'590.00','.00','590.00','10.00','0','36','15','3 Rosa','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-19','','2022-01-19','18:56:36','10.00','10.00','.00',1),(45,'RE-AS-18','AS18-22019-AD-2',41,49,1,'','Cereza',3,128,'1280.00','.00','1280.00','10.00','0','30','5','2 Amarillo','Benjamin Carrillo','Jose Israel Vergara Martinez','','2022-01-19','','2022-01-19','19:08:11','10.00','10.00','.00',1),(46,'RE-AS-18','AS18-22020-AB-3',40,48,1,'','Cereza',5,197,'1970.00','.00','1970.00','10.00','1','63','9','3 Rosa','Rodolfo  Carrillo ','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','16:27:44','10.00','10.00','.00',1),(47,'RE-AS-18','AS18-22020-AD-3',6,9,1,'','Cereza',3,112,'1120.00','.00','1120.00','10.00','14','45','13','3 Rosa','Gonzalo Aldair Velazquez','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','16:35:17','10.00','10.00','.00',1),(48,'RE-AS-18','AS18-22020-AD-2',9,12,1,'','Cereza',2,56,'560.00','.00','560.00','10.00','1','30','5','2 Amarillo','Agustina Chavez Martinez','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','16:39:45','10.00','10.00','.00',1),(49,'RE-AS-18','AS18-22020-AB-2',50,69,1,'','Cereza',2,61,'610.00','.00','610.00','10.00','0','20','2','2 Amarillo','Marcos Bartolo Urias Chavez','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','16:44:05','10.00','10.00','.00',1),(50,'RE-AS-18','AS18-22020-AD-3',21,32,1,'','Cereza',3,96,'960.00','.00','960.00','10.00','0','30','20','3 Rosa','Luis Jimenez Rodriguez','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','16:51:32','10.00','10.00','.00',1),(51,'RE-AS-18','AS18-22020-AB-2',45,57,1,'','Cereza',6,190,'1900.00','.00','1900.00','10.00','0','28','12','2 Amarillo','J Jesus Jimenez Esparza','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','16:58:37','10.00','10.00','.00',1),(52,'RE-AS-18','AS18-22020-AB-2',51,70,1,'','Cereza',7,286,'2860.00','.00','2860.00','10.00','0','23','0','2 Amarillo','Socorro Urias Chavez','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','17:05:49','10.00','10.00','.00',1),(53,'RE-AS-18','AS18-22020-AD-2',41,49,1,'','Cereza',3,92,'920.00','.00','920.00','10.00','0','20','6','2 Amarillo','Alma Casteñeda Lopez','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','17:11:13','10.00','10.00','.00',1),(54,'RE-AS-18','AS18-22020-AD-2',18,26,1,'','Cereza',2,83,'830.00','.00','830.00','10.00','0','19','8','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','17:19:59','10.00','10.00','.00',1),(55,'RE-AS-18','AS18-22020-AD-2',54,75,1,'','Cereza',1,49,'490.00','.00','490.00','10.00','0','8','33','2 Amarillo','Savino Delfin','Jose Israel Vergara Martinez','','2022-01-20','','2022-01-20','18:20:03','10.00','10.00','.00',1),(56,'RE-AS-18','AS18-22021-AD-2',41,49,1,'','Cereza',2,81,'972.00','.00','972.00','12.00','0','29','4','2 Amarillo','Benjamin Carrillo','Jose Israel Vergara Martinez','','2022-01-21','','2022-01-21','15:05:26','12.00','12.00','.00',1),(57,'RE-AS-18','AS18-22021-AD-2',54,75,1,'','Cereza',1,32,'384.00','.00','384.00','12.00','0','6','43','2 Amarillo','Sabino Delfin','Jose Israel Vergara Martinez','','2022-01-21','','2022-01-21','15:10:18','12.00','12.00','.00',1),(58,'RE-AS-18','AS18-22021-AD-2',18,24,1,'','Cereza',1,54,'648.00','.00','648.00','12.00','0','44','5','2 Amarillo','incensio Najera','Jose Israel Vergara Martinez','','2022-01-21','','2022-01-21','15:15:55','12.00','12.00','.00',1),(59,'RE-AS-18','AS18-22021-AB-2',45,58,1,'','Cereza',4,108,'1296.00','.00','1296.00','12.00','0','22','23','2 Amarillo','J Jesus Jimenez Esparza','Jose Israel Vergara Martinez','','2022-01-21','','2022-01-21','16:10:13','12.00','12.00','.00',1),(60,'RE-AS-18','AS18-22021-AB-2',53,73,1,'','Cereza',1,43,'516.00','.00','516.00','12.00','0','43','3','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-21','','2022-01-21','16:17:22','12.00','12.00','.00',1),(61,'RE-AS-18','AS18-22021-AB-2',40,48,1,'','Cereza',4,143,'1716.00','.00','1716.00','12.00','0','40','7','2 Amarillo','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-21','','2022-01-21','16:24:15','12.00','12.00','.00',1),(62,'RE-AS-18','AS18-22021-AB-2',50,68,1,'','Cereza',2,66,'792.00','.00','792.00','12.00','0','22','4','2 Amarillo','Marcos Bartolo Urias Chavez','Jose Israel Vergara Martinez','','2022-01-21','','2022-01-21','17:01:32','12.00','12.00','.00',1),(63,'RE-AS-18','AS18-22021-AD-2',18,26,1,'','Cereza',2,94,'1128.00','.00','1128.00','12.00','0','16','15','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-21','','2022-01-21','17:12:41','12.00','12.00','.00',1),(64,'RE-AS-18','AS18-22021-AB-2',51,70,1,'','Cereza',6,243,'2916.00','.00','2916.00','12.00','0','15','18','2 Amarillo','Socorro Urias Chavez','Jose Israel Vergara Martinez','','2022-01-21','','2022-01-21','17:35:38','12.00','12.00','.00',1),(65,'RE-AS-18','AS18-22022-AD-2',41,49,1,'','Cereza',2,64,'768.00','.00','768.00','12.00','0','30','1','2 Amarillo','Alma Casteñeda Lopez','Jose Israel Vergara Martinez','','2022-01-22','','2022-01-22','13:00:31','12.00','12.00','.00',1),(66,'RE-AS-18','AS18-22022-AB-2',40,48,1,'','Cereza',2,72,'864.00','.00','864.00','12.00','0','10','20','2 Amarillo','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-22','','2022-01-22','13:11:58','12.00','12.00','.00',1),(67,'RE-AS-18','AS18-22022-AB-2',51,70,1,'','Cereza',4,138,'1656.00','.00','1656.00','12.00','0','10','20','2 Amarillo','Socorro Urias Chavez','Jose Israel Vergara Martinez','','2022-01-22','','2022-01-22','13:38:33','12.00','12.00','.00',1),(68,'RE-AS-18','AS18-22022-AD-2',6,8,1,'','Cereza',3,103,'1236.00','.00','1236.00','12.00','0','25','3','2 Amarillo','Gonzalo Aldair Velazquez','Jose Israel Vergara Martinez','','2022-01-22','','2022-01-22','14:05:46','12.00','12.00','.00',1),(69,'RE-AS-18','AS18-22022-AD-2',54,75,1,'','Cereza',1,45,'540.00','.00','540.00','12.00','0','13','9','2 Amarillo','Sabino Delfin','Jose Israel Vergara Martinez','','2022-01-22','','2022-01-22','14:10:07','12.00','12.00','.00',1),(70,'RE-AS-18','AS18-22022-AB-2',53,73,1,'','Cereza',1,47,'564.00','.00','564.00','12.00','0','19','5','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-22','','2022-01-22','16:21:08','12.00','12.00','.00',1),(71,'RE-AS-18','AS18-22024-AB-2',45,58,1,'','Cereza',4,126,'1512.00','.00','1512.00','12.00','0','17','15','2 Amarillo','J Jesus Jimenez Esparza','Jose Israel Vergara Martinez','','2022-01-24','','2022-01-24','15:13:02','12.00','12.00','.00',1),(72,'RE-AS-18','AS18-22024-AB-2',48,64,1,'','Cereza',1,50,'600.00','.00','600.00','12.00','0','28','2','2 Amarillo','Sergio Plasencia Lopez','Jose Israel Vergara Martinez','','2022-01-24','','2022-01-24','15:17:53','12.00','12.00','.00',1),(73,'RE-AS-18','AS18-22024-AD-2',54,75,1,'','Cereza',1,42,'504.00','.00','504.00','12.00','0','18','7','2 Amarillo','Domingo Delfin','Jose Israel Vergara Martinez','','2022-01-24','','2022-01-24','16:12:39','12.00','12.00','.00',1),(74,'RE-AS-18','AS18-22024-AB-2',53,73,1,'','Cereza',4,180,'2160.00','.00','2160.00','12.00','0','32','7','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-24','','2022-01-24','16:47:52','12.00','12.00','.00',1),(75,'RE-AS-18','AS18-22024-AB-3',40,48,1,'','Cereza',8,286,'3432.00','.00','3432.00','12.00','0','70','10','3 Rosa','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-24','','2022-01-24','17:01:52','12.00','12.00','.00',1),(76,'RE-AS-18','AS18-22024-AB-2',2,1,1,'','Cereza',1,19,'228.00','.00','228.00','12.00','0','20','4','2 Amarillo','Antonio Bañuelos ','Jose Israel Vergara Martinez','','2022-01-24','','2022-01-24','17:06:47','12.00','12.00','.00',1),(77,'RE-AS-18','AS18-22024-AD-2',398,661,1,'','Cereza',3,122,'1464.00','.00','1464.00','12.00','0','21','5','2 Amarillo','Benjamin Carrrillo','Jose Israel Vergara Martinez','','2022-01-24','','2022-01-24','17:14:11','12.00','12.00','.00',1),(78,'RE-AS-18','AS18-22024-AD-2',18,26,1,'','Cereza',4,152,'1824.00','.00','1824.00','12.00','0','33','8','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-24','','2022-01-24','17:27:18','12.00','12.00','.00',1),(79,'RE-AS-18','AS18-22025-AD-3',54,75,1,'','Cereza',1,42,'504.00','.00','504.00','12.00','0','5','68','3 Rosa','Sabino Delfin','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','15:54:10','12.00','12.00','.00',1),(80,'RE-AS-18','AS18-22025-AD-2',6,8,1,'','Cereza',4,157,'1884.00','.00','1884.00','12.00','0','19','11','2 Amarillo','Gonzalo Aldair','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','16:03:03','12.00','12.00','.00',1),(81,'RE-AS-18','AS18-22025-AD-2',9,11,1,'','Cereza',7,274,'3288.00','.00','3288.00','12.00','0','32','5','2 Amarillo','Agustina Chavez Martinez','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','16:09:25','12.00','12.00','.00',1),(82,'RE-AS-18','AS18-22025-AB-2',40,48,1,'','Cereza',6,207,'2484.00','.00','2484.00','12.00','0','44','0','2 Amarillo','Rodolfo  Carrillo ','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','16:29:43','12.00','12.00','.00',1),(83,'RE-AS-18','AS18-22025-AB-1',40,48,1,'','Cereza',3,96,'1152.00','.00','1152.00','12.00','0','4','6','1 Azul','Rodolfo Carrillo','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','16:31:42','12.00','12.00','.00',1),(84,'RE-AS-18','AS18-22025-AD-2',18,26,1,'','Cereza',6,196,'2352.00','.00','2352.00','12.00','0','36','3','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','16:41:32','12.00','12.00','.00',1),(85,'RE-AS-18','AS18-22025-AB-2',2,1,1,'','Cereza',2,93,'1116.00','.00','1116.00','12.00','0','21','5','2 Amarillo','Antonio Bañuelos Castaneda','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','16:47:04','12.00','12.00','.00',1),(86,'RE-AS-18','AS18-22025-AB-2',53,73,1,'','Cereza',3,115,'1380.00','.00','1380.00','12.00','0','33','5','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','16:57:08','12.00','12.00','.00',1),(87,'RE-AS-18','AS18-22025-AB-1',19,28,1,'','Cereza',1,34,'408.00','.00','408.00','12.00','0','15','0','1 Azul','Juan Manuel Najera Ochoa','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','17:01:02','12.00','12.00','.00',1),(88,'RE-AS-18','AS18-22025-AB-2',45,57,1,'','Cereza',4,116,'1392.00','.00','1392.00','12.00','0','23','10','2 Amarillo','J Jesus Jimenez Esparza','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','17:06:03','12.00','12.00','.00',1),(89,'RE-AS-18','AS18-22025-AB-2',55,77,1,'','Cereza',4,162,'1944.00','.00','1944.00','12.00','0','25','4','2 Amarillo','Oliverio Hernandez Chavez','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','17:12:48','12.00','12.00','.00',1),(90,'RE-AS-18','AS18-22025-AB-2',47,63,1,'','Cereza',4,164,'1968.00','.00','1968.00','12.00','0','35','4','2 Amarillo','Maria Felix De La O','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','17:27:15','12.00','12.00','.00',1),(91,'RE-AS-18','AS18-22025-AB-2',45,57,1,'','Cereza',1,46,'552.00','.00','552.00','12.00','0','23','10','2 Amarillo','J Jesus Jimenez Esparza','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','17:33:19','12.00','12.00','.00',1),(92,'RE-AS-18','AS18-22025-AD-2',398,661,1,'','Cereza',5,219,'2628.00','.00','2628.00','12.00','0','23','1','2 Amarillo','Alma Castañeda Lopez','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','17:35:48','12.00','12.00','.00',1),(93,'RE-AS-18','AS18-22025-AB-2',48,64,1,'','Cereza',3,136,'1632.00','.00','1632.00','12.00','0','20','12','2 Amarillo','Sergio Plasencia Lopez','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','17:46:19','12.00','12.00','.00',1),(94,'RE-AS-18','AS18-22025-AB-1',51,70,1,'','Cereza',5,187,'2244.00','.00','2244.00','12.00','0','16','3','1 Azul','Socorro Urias Chavez','Jose Israel Vergara Martinez','','2022-01-25','','2022-01-25','17:55:42','12.00','12.00','.00',1),(95,'RE-AS-18','AS18-22026-AB-3',45,57,1,'','Cereza',4,137,'1644.00','.00','1644.00','12.00','0','13','47','3 Rosa','J Jesus Jimenez Esparza','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','15:50:48','12.00','12.00','.00',1),(96,'RE-AS-18','AS18-22026-AB-2',19,28,1,'','Cereza',1,30,'360.00','.00','360.00','12.00','0','23','4','2 Amarillo','Juan Manuel Najera Ochoa','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','15:56:04','12.00','12.00','.00',1),(97,'RE-AS-18','AS18-22026-AD-2',54,75,1,'','Cereza',1,51,'612.00','.00','612.00','12.00','0','8','35','2 Amarillo','Sabino Delfin','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','16:02:07','12.00','12.00','.00',1),(98,'RE-AS-18','AS18-22026-AB-3',61,83,1,'','Cereza',6,228,'2736.00','.00','2736.00','12.00','15','40','2','3 Rosa','Zenon Estrada Cruz','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','16:26:40','12.00','12.00','.00',1),(99,'RE-AS-18','AS18-22026-AB-2',40,48,1,'','Cereza',5,186,'2232.00','.00','2232.00','12.00','0','36','13','2 Amarillo','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','16:33:54','12.00','12.00','.00',1),(100,'RE-AS-18','AS18-22026-AB-1',40,48,1,'','Cereza',2,83,'996.00','.00','996.00','12.00','0','10','0','1 Azul','Rodolfo Carrillo','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','16:36:41','12.00','12.00','.00',1),(101,'RE-AS-18','AS18-22026-AB-2',53,73,1,'','Cereza',3,125,'1500.00','.00','1500.00','12.00','0','28','8','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','16:46:48','12.00','12.00','.00',1),(102,'RE-AS-18','AS18-22026-AD-2',18,26,1,'','Cereza',8,310,'3720.00','.00','3720.00','12.00','0','31','5','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','16:54:36','12.00','12.00','.00',1),(103,'RE-AS-18','AS18-22026-AB-2',47,63,1,'','Cereza',4,157,'1884.00','.00','1884.00','12.00','0','29','0','2 Amarillo','Maria Felix De La O','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','17:07:01','12.00','12.00','.00',1),(104,'RE-AS-18','AS18-22026-AB-1',48,64,1,'','Cereza',3,134,'1608.00','.00','1608.00','12.00','0','9','7','1 Azul','Sergio Plasencia Lopez','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','17:10:08','12.00','12.00','.00',1),(105,'RE-AS-18','AS18-22026-AD-1',10,13,1,'','Cereza',3,93,'1116.00','.00','1116.00','12.00','0','7','6','1 Azul','Anacleta Chavez Martinez','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','17:26:50','12.00','12.00','.00',1),(106,'RE-AS-18','AS18-22026-AB-2',55,77,1,'','Cereza',3,131,'1572.00','.00','1572.00','12.00','0','7','31','2 Amarillo','Oliverio Hernandez Chavez','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','17:31:16','12.00','12.00','.00',1),(107,'RE-AS-18','AS18-22026-AD-1',398,661,1,'','Cereza',7,247,'2964.00','.00','2964.00','12.00','0','12','6','1 Azul','Alma Castañeda Lopez','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','17:41:40','12.00','12.00','.00',1),(108,'RE-AS-18','AS18-22026-AD-1',21,32,1,'','Cereza',3,141,'1692.00','.00','1692.00','12.00','0','12','7','1 Azul','Luis Jimenez','Jose Israel Vergara Martinez','','2022-01-26','','2022-01-26','17:46:22','12.00','12.00','.00',1),(109,'RE-AS-18','AS18-22027-AD-1',41,49,1,'','Cereza',4,164,'1968.00','.00','1968.00','12.00','0','17','3','1 Azul','Benjamin Carrillo','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','15:09:30','12.00','12.00','.00',1),(110,'RE-AS-18','AS18-22027-AB-2',55,77,1,'','Cereza',1,39,'468.00','.00','468.00','12.00','0','14','10','2 Amarillo','Oliverio Hernandez Chavez','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','15:14:33','12.00','12.00','.00',1),(111,'RE-AS-18','AS18-22027-AD-1',6,8,1,'','Cereza',4,165,'1980.00','.00','1980.00','12.00','0','18','0','1 Azul','Gonzalo Aldair Vazquez','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','15:20:10','12.00','12.00','.00',1),(112,'RE-AS-18','AS18-22027-AD-2',9,11,1,'','Cereza',1,38,'456.00','.00','456.00','12.00','0','15','9','2 Amarillo','Agustina Chavez Martinez','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','15:39:55','12.00','12.00','.00',1),(113,'RE-AS-18','AS18-22027-AD-1',54,75,1,'','Cereza',2,79,'948.00','.00','948.00','12.00','0','5','6','1 Azul','Sabino Delfin','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','15:48:56','12.00','12.00','.00',1),(114,'RE-AS-18','AS18-22027-AB-2',49,65,1,'','Cereza',3,104,'1248.00','.00','1248.00','12.00','0','26','2','2 Amarillo','Bibiano Silbestre Solis','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','16:06:07','12.00','12.00','.00',1),(115,'RE-AS-18','AS18-22027-AB-2',53,73,1,'','Cereza',3,95,'1140.00','.00','1140.00','12.00','0','21','5','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','16:19:50','12.00','12.00','.00',1),(116,'RE-AS-18','AS18-22027-AB-2',40,48,1,'','Cereza',8,297,'3564.00','.00','3564.00','12.00','0','34','11','2 Amarillo','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','16:35:43','12.00','12.00','.00',1),(117,'RE-AS-18','AS18-22027-AB-1',40,48,1,'','Cereza',2,92,'1104.00','.00','1104.00','12.00','0','1','19','1 Azul','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','16:39:23','12.00','12.00','.00',1),(118,'RE-AS-18','AS18-22027-AB-1',12,16,1,'','Cereza',3,96,'1152.00','.00','1152.00','12.00','0','16','0','1 Azul','Aron Gomez','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','16:46:04','12.00','12.00','.00',1),(119,'RE-AS-18','AS18-22027-AB-2',47,63,1,'','Cereza',4,153,'1836.00','.00','1836.00','12.00','2','35','3','2 Amarillo','Maria Felix  Lopez De La O','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','16:52:08','12.00','12.00','.00',1),(120,'RE-AS-18','AS18-22027-AB-1',38,45,1,'','Cereza',3,98,'1176.00','.00','1176.00','12.00','2','7','3','1 Azul','Ramon Caro Zarate','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','16:59:43','12.00','12.00','.00',1),(121,'RE-AS-18','AS18-22027-AB-1',19,28,1,'','Cereza',1,35,'420.00','.00','420.00','12.00','0','2','7','1 Azul','Juan Manuel Najera Ochoa','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','17:24:33','12.00','12.00','.00',1),(122,'RE-AS-18','AS18-22027-AB-2',2,1,1,'','Cereza',8,299,'3588.00','.00','3588.00','12.00','0','45','4','2 Amarillo','Antonio Bañuelos ','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','17:55:50','12.00','12.00','.00',1),(123,'RE-AS-18','AS18-22027-AD-2',18,25,1,'','Cereza',4,189,'2268.00','.00','2268.00','12.00','2','36','9','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-27','','2022-01-27','18:21:25','12.00','12.00','.00',1),(124,'RE-AS-18','AS18-22028-AD-2',21,32,1,'','Cereza',3,117,'1404.00','.00','1404.00','12.00','2','17','8','2 Amarillo','Luis Jimenez','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','15:51:08','12.00','12.00','.00',1),(125,'RE-AS-18','AS18-22028-AB-2',53,73,1,'','Cereza',1,48,'576.00','.00','576.00','12.00','0','40','6','2 Amarillo','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','16:07:00','12.00','12.00','.00',1),(126,'RE-AS-18','AS18-22028-AB-2',40,48,1,'','Cereza',8,276,'3312.00','.00','3312.00','12.00','0','30','7','2 Amarillo','Rodolfo Carrillo ','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','16:37:46','12.00','12.00','.00',1),(127,'RE-AS-18','AS18-22028-AD-2',9,11,1,'','Cereza',2,65,'780.00','.00','780.00','12.00','0','16','6','2 Amarillo','Agustina Chavez Martinez','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','16:43:22','12.00','12.00','.00',1),(128,'RE-AS-18','AS18-22028-AD-1',44,54,1,'','Cereza',2,67,'804.00','.00','804.00','12.00','0','3','9','1 Azul','Alonzo Lozoya','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','16:49:06','12.00','12.00','.00',1),(129,'RE-AS-18','AS18-22028-AB-1',2,1,1,'','Cereza',8,242,'2904.00','.00','2904.00','12.00','0','16','4','1 Azul','Antonio Bañuelos ','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','17:04:42','12.00','12.00','.00',1),(130,'RE-AS-18','AS18-22028-AB-1',12,16,1,'','Cereza',3,98,'1176.00','.00','1176.00','12.00','0','9','2','1 Azul','Aron  Gomez','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','17:28:10','12.00','12.00','.00',1),(131,'RE-AS-18','AS18-22028-AD-3',18,25,1,'','Cereza',6,135,'1620.00','.00','1620.00','12.00','13','15','12','3 Rosa','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','17:40:49','12.00','12.00','.00',1),(132,'RE-AS-18','AS18-22028-AD-2',18,25,1,'','Cereza',3,129,'1548.00','.00','1548.00','12.00','0','22','8','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','17:43:34','12.00','12.00','.00',1),(133,'RE-AS-18','AS18-22028-AB-1',44,55,1,'','Cereza',1,10,'120.00','.00','120.00','12.00','0','3','9','1 Azul','Maria Cristina Hernandez Chavez','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','18:14:35','12.00','12.00','.00',0),(134,'RE-AS-18','AS18-22028-AD-1',44,55,1,'','Cereza',1,10,'120.00','.00','120.00','12.00','0','3','10','1 Azul','Maria Cristina Hernandez Chavez','Jose Israel Vergara Martinez','','2022-01-28','','2022-01-28','19:10:40','12.00','12.00','.00',1),(135,'RE-AS-18','AS18-22029-AB-2',40,48,1,'','Cereza',3,100,'1200.00','.00','1200.00','12.00','0','29','18','2 Amarillo','Ruperto Carrillo Najera','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','12:25:21','12.00','12.00','.00',1),(136,'RE-AS-18','AS18-22029-AD-2',6,8,1,'','Cereza',3,95,'1140.00','.00','1140.00','12.00','0','22','8','2 Amarillo','Gonzalo Aldair Velazquez','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','12:30:09','12.00','12.00','.00',1),(137,'RE-AS-18','AS18-22029-AD-1',398,661,1,'','Cereza',7,256,'3072.00','.00','3072.00','12.00','0','4','4','1 Azul','ManuelBenjamin Carrillo','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','12:54:58','12.00','12.00','.00',1),(138,'RE-AS-18','AS18-22029-AB-1',2,2,1,'','Cereza',2,84,'1008.00','.00','1008.00','12.00','0','12','0','1 Azul','Antonio Bañuelos ','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','14:43:57','12.00','12.00','.00',1),(139,'RE-AS-18','AS18-22029-AB-1',19,28,1,'','Cereza',1,55,'660.00','.00','660.00','12.00','0','3','6','1 Azul','Juan Manuel Najera Ochoa','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','14:48:27','12.00','12.00','.00',1),(140,'RE-AS-18','AS18-22029-AD-2',18,25,1,'','Cereza',4,162,'1944.00','.00','1944.00','12.00','0','20','4','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','14:54:44','12.00','12.00','.00',1),(141,'RE-AS-18','AS18-22029-AB-1',12,16,1,'','Cereza',2,75,'900.00','.00','900.00','12.00','0','3','0','1 Azul','Aron Gomez','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','14:58:33','12.00','12.00','.00',1),(142,'RE-AS-18','AS18-22029-AD-1',11,15,1,'','Cereza',2,46,'552.00','.00','552.00','12.00','0','5','8','1 Azul','Andrea Flores De La O','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','15:57:21','12.00','12.00','.00',1),(143,'RE-AS-18','AS18-22029-AB-2',47,63,1,'','Cereza',2,78,'936.00','.00','936.00','12.00','0','45','3','2 Amarillo','Maria Felix Loepez De La O','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','16:35:53','12.00','12.00','.00',1),(144,'RE-AS-18','AS18-22029-AD-1',54,75,1,'','Cereza',3,115,'1380.00','.00','1380.00','12.00','0','3','12','1 Azul','Sabino Delfin ','Jose Israel Vergara Martinez','','2022-01-29','','2022-01-29','16:50:17','12.00','12.00','.00',1),(145,'RE-AS-18','AS18-22031-AD-1',41,49,1,'','Cereza',3,110,'1320.00','.00','1320.00','12.00','0','10','7','1 Azul','alma Casteñeda Lopez','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','15:48:36','12.00','12.00','.00',1),(146,'RE-AS-18','AS18-22031-AB-1',19,27,1,'','Cereza',2,63,'756.00','.00','756.00','12.00','0','6','3','1 Azul','Juan Manuel Najera Ochoa','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','15:53:54','12.00','12.00','.00',1),(147,'RE-AS-18','AS18-22031-AB-3',40,48,1,'','Cereza',3,100,'1200.00','.00','1200.00','12.00','0','52','12','3 Rosa','Ruperto Carrillo Najera','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','16:28:07','12.00','12.00','.00',1),(148,'RE-AS-18','AS18-22031-AD-1',44,54,1,'','Cereza',4,179,'2148.00','.00','2148.00','12.00','0','6','14','1 Azul','Juan Silvano Hernandez','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','16:33:48','12.00','12.00','.00',1),(149,'RE-AS-18','AS18-22031-AD-1',18,25,1,'','Cereza',3,108,'1296.00','.00','1296.00','12.00','0','11','9','1 Azul','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','16:55:44','12.00','12.00','.00',1),(150,'RE-AS-18','AS18-22031-AD-2',18,25,1,'','Cereza',2,95,'1140.00','.00','1140.00','12.00','2','25','7','2 Amarillo','Domingo Sanchez','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','16:57:30','12.00','12.00','.00',1),(151,'RE-AS-18','AS18-22031-AB-1',53,73,1,'','Cereza',4,152,'1824.00','.00','1824.00','12.00','0','12','8','1 Azul','Jacinto Mendez Flores','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','17:03:31','12.00','12.00','.00',1),(152,'RE-AS-18','AS18-22031-AD-2',11,15,1,'','Cereza',1,41,'492.00','.00','492.00','12.00','0','45','0','2 Amarillo','Andrea Flores De La O','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','17:29:43','12.00','12.00','.00',1),(153,'RE-AS-18','AS18-22031-AD-1',11,15,1,'','Cereza',5,162,'1944.00','.00','1944.00','12.00','0','15','1','1 Azul','Andrea Flores De La O','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','17:31:47','12.00','12.00','.00',1),(154,'RE-AS-18','AS18-22031-AB-1',55,76,1,'','Cereza',8,273,'3276.00','.00','3276.00','12.00','0','14','5','1 Azul','Oliverio Hernandez Chavez','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','17:38:09','12.00','12.00','.00',1),(155,'RE-AS-18','AS18-22031-AD-1',57,79,1,'','Cereza',2,78,'936.00','.00','936.00','12.00','0','10','2','1 Azul','Julian Perez','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','17:47:20','12.00','12.00','.00',1),(156,'RE-AS-18','AS18-22031-AB-1',2,1,1,'','Cereza',9,254,'3048.00','.00','3048.00','12.00','0','9','3','1 Azul','Antonio Bañuelos ','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','17:58:22','12.00','12.00','.00',1),(157,'RE-AS-18','AS18-22031-AB-1',48,64,1,'','Cereza',3,127,'1524.00','.00','1524.00','12.00','0','10','0','1 Azul','Sergio Plasencia Lopez','Jose Israel Vergara Martinez','','2022-01-31','','2022-01-31','18:02:14','12.00','12.00','.00',1);
/*!40000 ALTER TABLE `recibos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reglasevaluacion`
--

DROP TABLE IF EXISTS `reglasevaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reglasevaluacion` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Grado` int(11) NOT NULL,
  `Defectos` int(11) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reglasevaluacion`
--

LOCK TABLES `reglasevaluacion` WRITE;
/*!40000 ALTER TABLE `reglasevaluacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `reglasevaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relacionf_m`
--

DROP TABLE IF EXISTS `relacionf_m`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relacionf_m` (
  `ID` int(10) unsigned NOT NULL,
  `ID_PersonaF` int(10) unsigned NOT NULL,
  `ID_PersonaM` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PersonaF` (`ID_PersonaF`),
  KEY `ID_PersonaM` (`ID_PersonaM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relacionf_m`
--

LOCK TABLES `relacionf_m` WRITE;
/*!40000 ALTER TABLE `relacionf_m` DISABLE KEYS */;
/*!40000 ALTER TABLE `relacionf_m` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relacionsalidamaquinarias`
--

DROP TABLE IF EXISTS `relacionsalidamaquinarias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relacionsalidamaquinarias` (
  `id` int(11) NOT NULL,
  `idMaquinaria` int(11) NOT NULL,
  `claveSalida` varchar(10) NOT NULL,
  `idActividad` int(11) NOT NULL,
  `idMaquinariaRelacion` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relacionsalidamaquinarias`
--

LOCK TABLES `relacionsalidamaquinarias` WRITE;
/*!40000 ALTER TABLE `relacionsalidamaquinarias` DISABLE KEYS */;
/*!40000 ALTER TABLE `relacionsalidamaquinarias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retenciones`
--

DROP TABLE IF EXISTS `retenciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `retenciones` (
  `ID` int(10) unsigned NOT NULL,
  `importe` varchar(10) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retenciones`
--

LOCK TABLES `retenciones` WRITE;
/*!40000 ALTER TABLE `retenciones` DISABLE KEYS */;
INSERT INTO `retenciones` VALUES (1,'0','Ninguna',1,1,'2019-08-06','09:55:16','','',1,1),(2,'50','Consejo + Interna + Ejido',1,1,'2019-08-06','10:32:23','','',1,1),(3,'10','Ejido',1,1,'2019-08-06','10:32:36','','',1,1),(4,'10','Federal',1,1,'2019-08-06','10:32:52','','',1,1),(5,'40','Estatal',1,1,'2019-08-06','10:33:07','','',1,1),(6,'10','Interna',1,1,'2019-08-06','10:36:56','','',1,1);
/*!40000 ALTER TABLE `retenciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta` (
  `ID` int(11) NOT NULL,
  `NombreProceso` int(10) unsigned NOT NULL,
  `NombreRuta` varchar(85) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `HoraCreacion` time(6) NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta`
--

LOCK TABLES `ruta` WRITE;
/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutabeneficiohumedo`
--

DROP TABLE IF EXISTS `rutabeneficiohumedo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutabeneficiohumedo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idBeneficio` varchar(35) NOT NULL,
  `idProceso` int(11) NOT NULL,
  `nombreRuta` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutabeneficiohumedo`
--

LOCK TABLES `rutabeneficiohumedo` WRITE;
/*!40000 ALTER TABLE `rutabeneficiohumedo` DISABLE KEYS */;
INSERT INTO `rutabeneficiohumedo` VALUES (1,'BH-AI-15',1,'Naturales'),(2,'BH-AI-15',1,'Ruta Completa');
/*!40000 ALTER TABLE `rutabeneficiohumedo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salidasmaquinaria`
--

DROP TABLE IF EXISTS `salidasmaquinaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salidasmaquinaria` (
  `id` int(11) NOT NULL,
  `idMaquinaria` int(11) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `formacafe` varchar(45) NOT NULL,
  `procesocafe` varchar(45) NOT NULL,
  `estadocafe` varchar(45) NOT NULL,
  `datoEvaluar` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salidasmaquinaria`
--

LOCK TABLES `salidasmaquinaria` WRITE;
/*!40000 ALTER TABLE `salidasmaquinaria` DISABLE KEYS */;
INSERT INTO `salidasmaquinaria` VALUES (1,1,'S1','Cereza','Sin Proceso','Escurrido',''),(2,1,'S2','Cereza','Sin Proceso','Escurrido',''),(3,20,'S1','Cereza','Sin Proceso','Fresco',''),(4,20,'S2','Cereza','Sin Proceso','Fresco',''),(5,27,'S1','Cereza','Sin Proceso','Fresco',''),(6,27,'S2','Cereza','Sin Proceso','Fresco',''),(7,40,'S1','Cereza','Sin Proceso','Fresco',''),(8,40,'S2','Cereza','Sin Proceso','Fresco','');
/*!40000 ALTER TABLE `salidasmaquinaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `situacion`
--

DROP TABLE IF EXISTS `situacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `situacion` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) DEFAULT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `situacion`
--

LOCK TABLES `situacion` WRITE;
/*!40000 ALTER TABLE `situacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `situacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sobrante`
--

DROP TABLE IF EXISTS `sobrante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sobrante` (
  `ID` int(11) NOT NULL,
  `Clave` varchar(45) NOT NULL,
  `Nombre` varchar(85) DEFAULT NULL,
  `Factor` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(500) DEFAULT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `HoraCreacion` time(6) NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sobrante`
--

LOCK TABLES `sobrante` WRITE;
/*!40000 ALTER TABLE `sobrante` DISABLE KEYS */;
INSERT INTO `sobrante` VALUES (1,'1','Flote Kg','2.66','Separacion Por Flote',1,1,'2019-08-14','12:19:47.000000','','',1,1),(2,'2','Repaso De Verdes Kg','4.26','Separacion Por Verdes',1,1,'2019-08-14','12:20:10.000000','','',1,1),(3,'3','Espumilla Kg','4.26','Lavado Tradicional',1,1,'2019-08-14','12:20:41.000000','','',1,1),(4,'4','Sobrante De Lavadora Kg','4.26','Lavado Mecanico',1,1,'2019-08-14','12:21:04.000000','','',1,1);
/*!40000 ALTER TABLE `sobrante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sociedadespersona`
--

DROP TABLE IF EXISTS `sociedadespersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sociedadespersona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `id_asociado` int(11) NOT NULL,
  `tipoPersona` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=415 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sociedadespersona`
--

LOCK TABLES `sociedadespersona` WRITE;
/*!40000 ALTER TABLE `sociedadespersona` DISABLE KEYS */;
INSERT INTO `sociedadespersona` VALUES (1,1,7,1),(2,2,1,1),(3,3,1,1),(4,4,1,1),(5,5,1,1),(6,6,1,1),(7,7,1,1),(8,8,1,1),(9,9,1,1),(10,10,1,1),(11,11,1,1),(12,12,1,1),(13,13,1,1),(14,14,1,1),(15,15,1,1),(16,16,1,1),(17,17,1,1),(18,18,1,1),(19,19,1,1),(20,20,1,1),(21,21,1,1),(22,22,1,1),(23,23,1,1),(24,24,1,1),(25,25,1,1),(26,26,1,1),(27,27,1,1),(28,28,1,1),(29,29,1,1),(30,30,1,1),(31,31,1,1),(32,32,1,1),(33,33,1,1),(34,34,1,1),(35,35,1,1),(36,36,1,1),(37,37,1,1),(38,38,1,1),(39,39,1,1),(40,40,1,1),(41,41,1,1),(42,42,1,1),(43,43,1,1),(44,44,1,1),(45,45,1,1),(46,46,1,1),(47,47,1,1),(48,48,1,1),(49,49,1,1),(51,51,1,1),(52,52,1,1),(53,53,1,1),(54,54,1,1),(55,55,1,1),(56,56,1,1),(57,57,1,1),(58,58,1,1),(59,59,1,1),(60,60,1,1),(61,61,1,1),(62,62,2,1),(63,63,2,1),(64,64,2,1),(68,68,2,1),(69,69,2,1),(70,70,2,1),(71,71,2,1),(72,72,2,1),(73,73,2,1),(74,74,2,1),(75,75,2,1),(76,76,2,1),(77,77,2,1),(78,78,2,1),(79,79,2,1),(80,80,2,1),(81,81,2,1),(82,82,2,1),(83,83,2,1),(84,84,2,1),(85,85,2,1),(86,86,2,1),(87,87,2,1),(88,88,2,1),(89,89,2,1),(90,90,2,1),(91,91,2,1),(92,92,2,1),(93,93,2,1),(94,94,2,1),(95,95,2,1),(96,96,2,1),(97,97,2,1),(98,98,2,1),(99,99,2,1),(100,100,2,1),(101,101,2,1),(102,102,2,1),(103,103,2,1),(104,50,2,1),(105,50,1,1),(106,104,2,1),(107,105,2,1),(109,107,2,1),(110,108,2,1),(113,110,2,1),(114,111,2,1),(115,112,2,1),(116,113,2,1),(117,114,2,1),(118,115,2,1),(119,116,2,1),(120,117,2,1),(121,118,2,1),(122,119,2,1),(124,120,2,1),(125,120,7,1),(126,121,2,1),(127,122,2,1),(128,123,2,1),(129,124,2,1),(130,125,2,1),(132,126,2,1),(133,126,7,1),(134,127,2,1),(135,128,2,1),(136,129,2,1),(137,130,2,1),(138,131,5,1),(139,132,5,1),(140,133,5,1),(141,134,5,1),(142,135,5,1),(143,136,5,1),(144,137,5,1),(145,138,5,1),(146,139,5,1),(147,140,5,1),(148,141,5,1),(149,142,5,1),(150,143,5,1),(151,144,5,1),(152,145,5,1),(153,146,5,1),(154,147,5,1),(155,148,5,1),(156,149,5,1),(157,150,5,1),(158,151,5,1),(159,152,5,1),(160,153,5,1),(161,154,5,1),(162,155,5,1),(163,156,5,1),(164,157,5,1),(165,158,5,1),(166,159,5,1),(167,160,5,1),(168,161,5,1),(169,162,5,1),(170,163,5,1),(171,164,5,1),(172,165,5,1),(173,166,5,1),(174,167,5,1),(175,168,5,1),(176,169,5,1),(177,170,5,1),(178,171,5,1),(179,172,5,1),(180,173,5,1),(181,174,5,1),(182,175,5,1),(183,176,5,1),(184,177,5,1),(185,178,5,1),(186,179,5,1),(187,180,5,1),(188,181,5,1),(189,182,5,1),(190,183,5,1),(191,184,5,1),(192,185,5,1),(193,186,5,1),(194,187,5,1),(195,188,5,1),(196,189,5,1),(197,190,5,1),(198,191,5,1),(199,192,5,1),(200,193,5,1),(201,194,5,1),(202,195,5,1),(203,196,5,1),(204,197,5,1),(205,198,5,1),(206,199,5,1),(207,200,5,1),(208,201,5,1),(209,202,5,1),(210,203,5,1),(211,204,5,1),(212,205,5,1),(213,206,5,1),(214,207,5,1),(215,208,5,1),(216,209,5,1),(217,210,5,1),(218,211,5,1),(219,212,5,1),(220,213,5,1),(221,214,6,1),(222,215,6,1),(223,216,6,1),(224,217,6,1),(225,218,6,1),(226,219,6,1),(227,220,6,1),(228,221,6,1),(229,222,6,1),(230,223,6,1),(231,224,6,1),(232,225,6,1),(233,226,6,1),(234,227,6,1),(235,228,6,1),(236,229,6,1),(237,230,6,1),(238,231,6,1),(239,232,6,1),(240,233,6,1),(241,234,11,1),(242,235,11,1),(243,236,11,1),(244,237,11,1),(245,238,11,1),(246,239,11,1),(247,240,11,1),(248,241,11,1),(249,242,11,1),(250,243,11,1),(251,244,11,1),(252,245,11,1),(253,246,11,1),(254,247,11,1),(255,248,11,1),(256,249,11,1),(257,250,11,1),(258,251,11,1),(259,252,11,1),(260,253,11,1),(261,254,11,1),(262,255,11,1),(263,256,11,1),(264,257,11,1),(265,258,11,1),(266,259,11,1),(267,260,8,1),(268,261,8,1),(269,262,8,1),(270,263,8,1),(271,264,8,1),(272,265,8,1),(273,266,8,1),(274,267,8,1),(275,268,8,1),(276,269,8,1),(277,270,8,1),(278,271,8,1),(279,272,8,1),(280,273,8,1),(281,274,8,1),(282,275,8,1),(283,276,8,1),(284,277,8,1),(285,278,8,1),(286,279,8,1),(287,280,8,1),(288,281,8,1),(289,282,8,1),(290,283,8,1),(291,284,8,1),(292,285,8,1),(293,286,8,1),(294,287,8,1),(295,288,8,1),(296,289,8,1),(297,290,8,1),(298,291,8,1),(299,292,8,1),(300,293,8,1),(301,294,8,1),(302,295,8,1),(303,296,8,1),(304,297,8,1),(305,298,8,1),(306,299,8,1),(307,300,8,1),(308,301,8,1),(309,302,8,1),(310,303,8,1),(312,305,9,1),(313,306,9,1),(314,307,9,1),(315,308,9,1),(316,309,9,1),(317,310,9,1),(318,311,9,1),(319,312,9,1),(320,313,9,1),(321,314,9,1),(322,315,9,1),(323,316,9,1),(324,317,9,1),(325,318,9,1),(326,319,9,1),(327,320,9,1),(328,321,9,1),(329,322,9,1),(330,323,9,1),(331,324,9,1),(332,325,9,1),(333,326,9,1),(334,327,9,1),(335,328,9,1),(336,329,9,1),(337,330,9,1),(338,331,9,1),(339,332,9,1),(340,333,9,1),(341,334,9,1),(342,335,9,1),(343,336,9,1),(344,337,9,1),(345,338,9,1),(346,339,9,1),(347,340,7,1),(348,341,7,1),(349,342,7,1),(350,343,7,1),(351,344,7,1),(352,345,7,1),(353,346,7,1),(354,347,7,1),(355,348,7,1),(356,349,7,1),(357,350,7,1),(358,351,7,1),(359,352,7,1),(360,353,7,1),(361,354,7,1),(362,355,7,1),(363,356,7,1),(364,357,7,1),(365,358,7,1),(366,359,7,1),(367,360,7,1),(368,361,7,1),(369,362,7,1),(370,363,7,1),(371,304,8,1),(372,304,7,1),(373,364,7,1),(374,365,7,1),(375,366,7,1),(376,367,7,1),(377,368,7,1),(378,369,7,1),(379,370,7,1),(380,371,7,1),(381,372,7,1),(382,109,2,1),(383,109,7,1),(384,373,7,1),(385,374,7,1),(386,65,2,1),(387,65,7,1),(388,66,2,1),(389,66,7,1),(390,375,7,1),(391,67,2,1),(392,67,7,1),(393,376,7,1),(394,377,7,1),(395,378,7,1),(396,379,7,1),(397,380,7,1),(398,381,7,1),(399,106,2,1),(400,106,7,1),(401,382,7,1),(402,386,7,1),(403,387,7,1),(404,388,7,1),(405,389,7,1),(406,390,7,1),(407,391,7,1),(408,392,7,1),(409,393,7,1),(410,394,7,1),(411,395,7,1),(412,396,7,1),(413,397,7,1),(414,398,1,1);
/*!40000 ALTER TABLE `sociedadespersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sublotesconfirmados`
--

DROP TABLE IF EXISTS `sublotesconfirmados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sublotesconfirmados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idLoteOrigen` varchar(35) NOT NULL,
  `idSubLote` varchar(35) NOT NULL,
  `idBeneficio` varchar(15) NOT NULL,
  `fechaCreacion` varchar(35) NOT NULL,
  `formaCafe` varchar(35) NOT NULL,
  `certificacion` varchar(35) NOT NULL,
  `estadoCafe` varchar(35) NOT NULL,
  `kgTotales` varchar(35) NOT NULL,
  `estatus` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sublotesconfirmados`
--

LOCK TABLES `sublotesconfirmados` WRITE;
/*!40000 ALTER TABLE `sublotesconfirmados` DISABLE KEYS */;
INSERT INTO `sublotesconfirmados` VALUES (1,'AI14-21025-AB-1','AI14-21025-AB-1','BH-AI-15','2021-04-26','Cereza','AB','Seco','319.0','0'),(2,'AI14-21026-AB-1','AI14-21026-AB-1','BH-AI-15','2021-04-26','Cereza','AB','Humedo','151.0','1'),(3,'AI14-21026-AC-1','AI14-21026-AC-1','BH-AI-15','2021-04-26','Cereza','AC','Humedo','57.0','0'),(4,'AI14-21026-AC-1','SLot-BH-AI-15-Frg1-4','BH-AI-15','2021-04-26','Cereza','AC','Escurrido','10.00','1'),(5,'AI14-21025-AB-1','SLot-BH-AI-15-Frg1-5','BH-AI-15','2021-04-27','Cereza','AB','Escurrido','119.00','0');
/*!40000 ALTER TABLE `sublotesconfirmados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sublotessecos`
--

DROP TABLE IF EXISTS `sublotessecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sublotessecos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idLoteOrigen` varchar(35) NOT NULL,
  `idSubLote` varchar(35) NOT NULL,
  `sociedad` varchar(55) NOT NULL,
  `idBeneficio` varchar(35) NOT NULL,
  `fechaSecado` varchar(35) NOT NULL,
  `certificacion` varchar(15) NOT NULL,
  `formaSalida` varchar(35) NOT NULL,
  `metodoSecado` varchar(55) NOT NULL,
  `procesoCafe` varchar(55) NOT NULL,
  `sacosFinales` double NOT NULL,
  `kilosFinales` double NOT NULL,
  `humedadFinal` varchar(10) NOT NULL,
  `temperaturaFinal` varchar(10) NOT NULL,
  `kgMuestra` varchar(10) NOT NULL,
  `fechaMuestra` varchar(15) NOT NULL,
  `tomadaPor` varchar(75) NOT NULL,
  `estatus` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sublotessecos`
--

LOCK TABLES `sublotessecos` WRITE;
/*!40000 ALTER TABLE `sublotessecos` DISABLE KEYS */;
INSERT INTO `sublotessecos` VALUES (1,'AI14-21026-AC-1','AI14-21026-AC-1','Procaa','BH-AI-15','2021-04-26','AC','Cereza','0','Sin Proceso',1,30,'20','30','','Fecha','',1),(2,'AI14-21025-AB-1','AI14-21025-AB-1','Procaa','BH-AI-15','2021-05-04','AB','Cereza','SASE01','Sin Proceso',2,80,'20','50','1','Fecha','Carlos Bustamante',1),(3,'AI14-21025-AB-1','SLot-BH-AI-15-Frg1-5','Procaa','BH-AI-15','2021-05-05','AB','Cereza','RUPA01','Sin Proceso',2,100,'50','40','','Fecha','',1);
/*!40000 ALTER TABLE `sublotessecos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temperaturaprocesosecado`
--

DROP TABLE IF EXISTS `temperaturaprocesosecado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temperaturaprocesosecado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSubLote` varchar(25) NOT NULL,
  `humedad` varchar(15) NOT NULL,
  `temperatura` varchar(15) NOT NULL,
  `fecha` varchar(25) NOT NULL,
  `hora` varchar(15) NOT NULL,
  `encargado` varchar(75) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temperaturaprocesosecado`
--

LOCK TABLES `temperaturaprocesosecado` WRITE;
/*!40000 ALTER TABLE `temperaturaprocesosecado` DISABLE KEYS */;
INSERT INTO `temperaturaprocesosecado` VALUES (1,'AI14-21026-AC-1','20','30','2021-04-26','3 : 00','Esto es una prueba'),(2,'AI14-21025-AB-1','20','50','2021-04-27','4 : 05','Esto es otra prueba'),(3,'SLot-BH-AI-15-Frg1-5','50','40','2021-04-27','2 : 01','Luis Humberto');
/*!40000 ALTER TABLE `temperaturaprocesosecado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temporadas`
--

DROP TABLE IF EXISTS `temporadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temporadas` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFin` date NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporadas`
--

LOCK TABLES `temporadas` WRITE;
/*!40000 ALTER TABLE `temporadas` DISABLE KEYS */;
/*!40000 ALTER TABLE `temporadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminales`
--

DROP TABLE IF EXISTS `terminales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminales` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminales`
--

LOCK TABLES `terminales` WRITE;
/*!40000 ALTER TABLE `terminales` DISABLE KEYS */;
/*!40000 ALTER TABLE `terminales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoaccion`
--

DROP TABLE IF EXISTS `tipoaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoaccion` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoaccion`
--

LOCK TABLES `tipoaccion` WRITE;
/*!40000 ALTER TABLE `tipoaccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoasentamiento`
--

DROP TABLE IF EXISTS `tipoasentamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoasentamiento` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(65) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoasentamiento`
--

LOCK TABLES `tipoasentamiento` WRITE;
/*!40000 ALTER TABLE `tipoasentamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoasentamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocontrol`
--

DROP TABLE IF EXISTS `tipocontrol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocontrol` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocontrol`
--

LOCK TABLES `tipocontrol` WRITE;
/*!40000 ALTER TABLE `tipocontrol` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipocontrol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoevaluacion`
--

DROP TABLE IF EXISTS `tipoevaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoevaluacion` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Formula` varchar(60) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoevaluacion`
--

LOCK TABLES `tipoevaluacion` WRITE;
/*!40000 ALTER TABLE `tipoevaluacion` DISABLE KEYS */;
INSERT INTO `tipoevaluacion` VALUES (1,'Rendimiento, Pergamino','Y=2x-148',1,1,'2019-08-14','11:05:05','','',1,1),(2,'Humedad','Y=(-2.9643x^2)+67.921x-370.06',1,1,'2019-08-14','11:14:12','','',1,1),(3,'Uniformidad','Y=2x-2',1,1,'2019-08-14','11:14:44','','',1,1),(4,'Agrio Entero, Granos','Y=-2x+12.5',1,1,'2019-08-14','11:15:16','','',1,1),(5,'Negro Entero, Granos','Y=-2x+12.5',1,1,'2019-08-14','11:15:40','','',1,1),(6,'Broca Severa, Granos','Y=-2*(x/5)+12.5',1,1,'2019-08-14','11:16:27','','',1,1),(7,'Tamaño, Promedio','Y=X-14',1,1,'2019-08-14','11:16:53','','',1,1),(8,'Rendimiento, Natural Despulpado','Y=2x-142',1,1,'2019-08-14','11:17:29','','',1,1),(9,'Rendimiento, Capulin','Y=2x-86',1,1,'2019-08-14','11:17:57','','',1,1),(10,'Criba Dos','X=(3.1416*4)+2.18',1,1,'2019-08-14','11:18:32','','',1,1),(11,'Daño Por Hongos, Granos','Y=-2x+12.5',1,1,'2019-08-14','11:19:01','','',1,1),(12,'Corte','Y=12+4x',1,1,'2019-08-14','11:19:28','','',1,1),(13,'H','H=H*3',1,1,'2019-08-14','11:20:44','','',1,1),(14,'Cereza','Y=100-((v*v)+i+b)',1,1,'2019-08-14','11:21:23','','',1,1);
/*!40000 ALTER TABLE `tipoevaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopersona`
--

DROP TABLE IF EXISTS `tipopersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopersona` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopersona`
--

LOCK TABLES `tipopersona` WRITE;
/*!40000 ALTER TABLE `tipopersona` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipopersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopoda`
--

DROP TABLE IF EXISTS `tipopoda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopoda` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopoda`
--

LOCK TABLES `tipopoda` WRITE;
/*!40000 ALTER TABLE `tipopoda` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipopoda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproduccion`
--

DROP TABLE IF EXISTS `tipoproduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoproduccion` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproduccion`
--

LOCK TABLES `tipoproduccion` WRITE;
/*!40000 ALTER TABLE `tipoproduccion` DISABLE KEYS */;
INSERT INTO `tipoproduccion` VALUES (1,'Silvestre',1,1,'2019-08-14','10:01:21','','',1,1),(2,'Cautivo',1,1,'2019-08-14','10:01:30','','',1,1),(3,'Policultivo Comercial',1,1,'2019-08-14','10:01:49','','',1,1),(4,'Manual',1,1,'2019-08-14','10:01:56','','',1,1);
/*!40000 ALTER TABLE `tipoproduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposombra`
--

DROP TABLE IF EXISTS `tiposombra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposombra` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposombra`
--

LOCK TABLES `tiposombra` WRITE;
/*!40000 ALTER TABLE `tiposombra` DISABLE KEYS */;
INSERT INTO `tiposombra` VALUES (1,'Especializada',1,1,'2019-08-13','14:40:14','','',1,1),(2,'Comercial Con Diversidad',1,1,'2019-08-13','14:48:50','','',1,1),(3,'Comercial Poco Diverso',1,1,'2019-08-13','14:49:11','','',1,1),(4,'Rustico Tradicional',1,1,'2019-08-13','14:49:26','','',1,1);
/*!40000 ALTER TABLE `tiposombra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposuelo`
--

DROP TABLE IF EXISTS `tiposuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposuelo` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposuelo`
--

LOCK TABLES `tiposuelo` WRITE;
/*!40000 ALTER TABLE `tiposuelo` DISABLE KEYS */;
INSERT INTO `tiposuelo` VALUES (1,'Volcanico',1,1,'2019-08-08','14:52:20','','',1,1),(2,'Limoso',1,1,'2019-08-12','15:07:32','','',1,1),(3,'Barroso',1,1,'2019-08-12','15:07:41','','',1,1),(4,'Salino',1,1,'2019-08-12','15:07:53','','',1,1),(5,'Pantanoso',1,1,'2019-08-12','15:10:17','','',1,1),(6,'Arenoso',1,1,'2019-08-12','15:10:24','','',1,1),(7,'Lamoso',1,1,'2019-08-12','15:10:35','','',1,1);
/*!40000 ALTER TABLE `tiposuelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transicioncertparcela`
--

DROP TABLE IF EXISTS `transicioncertparcela`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transicioncertparcela` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Clave` varchar(10) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transicioncertparcela`
--

LOCK TABLES `transicioncertparcela` WRITE;
/*!40000 ALTER TABLE `transicioncertparcela` DISABLE KEYS */;
/*!40000 ALTER TABLE `transicioncertparcela` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idPersona` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `fechaCaducidad` varchar(25) NOT NULL,
  `configurador` int(11) NOT NULL,
  `personas` int(11) NOT NULL,
  `fincacert` int(11) NOT NULL,
  `recepcion` int(11) NOT NULL,
  `beneficiohumedo` int(11) NOT NULL,
  `laboratorio` int(11) NOT NULL,
  `sociedades` int(11) NOT NULL,
  `almacen` int(11) NOT NULL,
  `id_situacion` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,1,'cgvaldez','cgvaldez','2024-10-08',1,1,1,1,1,1,1,1,1),(2,2,'marisolls','marisolls','2025-10-08',0,1,1,0,0,0,1,0,1),(3,99,'yenniae','yenniae','2023-12-31',0,1,1,1,1,0,0,0,2),(4,502,'brayanla','brayanla','2022-02-16',0,1,1,1,0,0,0,0,1),(5,508,'jamesk','jamesk','2022-04-26',1,1,1,1,1,1,1,1,1),(6,350,'yeniae','yeniae','2022-11-30',0,1,1,1,1,0,0,0,1),(7,60,'sandraec','sandraec','2023-01-10',0,1,1,1,0,0,0,0,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variedadcafe`
--

DROP TABLE IF EXISTS `variedadcafe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `variedadcafe` (
  `ID` int(10) unsigned NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variedadcafe`
--

LOCK TABLES `variedadcafe` WRITE;
/*!40000 ALTER TABLE `variedadcafe` DISABLE KEYS */;
INSERT INTO `variedadcafe` VALUES (1,'Borbon',1,1,'2019-08-13','15:31:47','','',1,1),(2,'Caturra',1,1,'2019-08-13','15:33:22','','',1,1),(3,'Mundo Novo',1,1,'2019-08-13','15:33:35','','',1,1),(4,'Geisha',1,1,'2019-08-13','15:33:48','','',1,1),(5,'Robusta',1,1,'2019-08-13','15:33:59','','',1,1),(6,'Pluma Hidalgo',1,1,'2019-08-13','15:34:11','','',1,1),(7,'Costa Rica 95',1,1,'2019-08-13','15:34:23','','',1,1),(8,'Typica (arábiga)',1,1,'2019-08-13','15:34:57','','',1,1),(9,'Catuai',1,1,'2019-08-13','15:35:10','','',1,1),(10,'Colombia',1,1,'2019-08-13','15:35:24','','',1,1),(11,'Pacamara',1,1,'2019-08-13','15:35:31','','',1,1),(12,'Catimor',1,1,'2019-08-13','15:35:41','','',1,1),(13,'Garnica',1,1,'2019-08-13','15:35:51','','',1,1),(14,'Icatu',1,1,'2019-08-13','15:36:01','','',1,1),(15,'Marago',1,1,'2019-08-13','15:36:12','','',1,1),(16,'Pache',1,1,'2019-08-13','15:36:38','','',1,1),(17,'Conilon ',1,1,'2019-08-13','15:36:48','','',1,1),(18,'Acaia',1,1,'2019-08-13','15:36:57','','',1,1),(19,'Americano',1,1,'2019-08-13','15:37:06','','',1,1),(20,'Oro Azteca',1,1,'2019-08-13','15:37:16','','',1,1),(21,'Lempira',1,1,'2019-08-13','15:37:22','','',1,1),(22,'Sarchimor T-5296',1,1,'2019-08-13','15:37:52','','',1,1),(23,'Tupi I A C 1669-13',1,1,'2019-08-13','15:38:21','','',1,1),(24,'Criollo',1,1,'2019-08-13','15:38:28','','',1,1);
/*!40000 ALTER TABLE `variedadcafe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `ID` int(10) unsigned NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Capacidad` int(3) NOT NULL,
  `Placas` varchar(45) NOT NULL,
  `Responsable` varchar(95) NOT NULL,
  `TerminalCreacion` int(10) unsigned NOT NULL,
  `UsuarioCreacion` int(10) unsigned NOT NULL,
  `FechaCreacion` date NOT NULL,
  `HoraCreacion` time NOT NULL,
  `Sincronizado` bit(1) NOT NULL,
  `Activo` bit(1) NOT NULL,
  `ID_Temporada` int(10) unsigned NOT NULL,
  `ID_Situacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'Doble Rodado',5,'PE-73833','Pascual Castañeda',1,1,'2019-10-02','15:08:33','','',1,1),(2,'Ford Negra',5,'PE-58-995','Benigno Altamirano Estrada',1,1,'2019-10-03','08:57:55','','',1,1),(3,'Carretilla Rustico',1,'N/A','Luis Humberto Altamirano',1,1,'2019-10-03','08:58:52','','',1,1),(4,'Carretilla Sandia',1,'N/A','Gregorio Orozco Parra',1,1,'2019-10-03','08:59:26','','',1,1),(5,'Caballo',1,'N/A','Diego Flores Geronimo',1,1,'2019-10-03','09:00:00','','',1,1),(6,'Chevrolet Roja',1,'N/A','Jose Israel Vergara Martinez',1,1,'2019-10-03','09:00:23','','',1,1),(7,'Torton Dina',15,'PE-23-707','Jesus Altamirano Estrada',1,1,'2019-10-03','09:01:08','','',1,1),(8,'Diablito Arrocera',1,'N/A','Antonio Ibarra Carrillo',1,1,'2019-10-03','09:01:43','','',1,1),(9,'Toyota Chica',1,'Pendientes','Ricardo Peña Landin',1,1,'2019-10-03','09:02:10','','',1,1),(10,'Remudas',1,'N/A','Diego Flores Geronimo ',1,1,'2019-10-03','09:02:38','','',1,1),(11,'Carretilla',1,'N/A','Alejandro Altamirano Estrada',1,1,'2019-10-03','09:03:16','','',1,1),(12,'Doble Rodado 2',3,'Pe-37-204','Jose Pulido Lizama',1,1,'2019-10-03','09:03:47','','',1,1),(13,'En Mano Rustico',1,'N/A','Alejandro Altamirano Estrada',1,1,'2019-10-03','09:04:25','','',1,1),(14,'En Mano Sandia',1,'N/a','Gregorio Orozco Parra',1,1,'2019-10-03','09:05:22','','',1,1),(15,'Nissan 1',3,'PE-37-169','Jose Pulido Lizama',1,1,'2019-10-03','09:06:11','','',1,1),(16,'Toyota 85',1,'PE-68-634','Juan Paulino Guardado Salas',1,1,'2019-10-03','09:06:44','','',1,1),(17,'Carretilla Piña',1,'N/A','Juan Paulino Guardado Salas',1,1,'2019-10-03','09:07:15','','',1,1),(18,'Carretilla Astal',1,'N/A','Luis Fernando Gaytan Chavez',1,1,'2019-10-03','09:08:00','','',1,1),(19,'Ford 82 Doble Rodado',3,'PC-87-689','Tomas Carrillo Rodriguez',1,1,'2019-10-03','09:08:43','','',1,1),(20,'Chevrolet 85',1,'PE-11-826','Antonio Ibarra Carrillo',1,1,'2019-10-03','09:09:36','','',1,1),(21,'Toyota T100',15,'PE-88-205','Marcos Bartolo Urias Chavez',1,1,'2019-10-03','09:11:09','','',1,1),(22,'Ford Patona',2,'PE-24-587','Luis Alberto Fuerte',1,1,'2019-10-03','09:17:57','','',1,1),(23,'Transporte Manual Sombrero',0,'N/A','Magdaleno Flores Geronimo',1,1,'2019-10-03','09:18:43','','',1,1),(24,'Transporte Manual B.C.',0,'N/A','Agustin Gonzalez Flores',1,1,'2019-10-03','09:19:16','','',1,1),(25,'Transporte Manual Guajolote',0,'N/A','Griseldo Lamas Pizano',1,1,'2019-10-03','09:19:48','','',1,1),(26,'Transporte Manual Tempizque',0,'N/A ','Delfino Garcia Pizano',1,1,'2019-10-03','09:20:26','','',1,1),(27,'Ford 87',4,'PD-63-400','Efrain Chavez S. ',1,1,'2019-10-03','09:21:02','','',1,1),(28,'Doge',4,'XG-1793-A','Eduardo Sanchez',1,1,'2019-10-03','09:21:42','','',1,1),(29,'Pick Up',4,'PE-12-571','Luis Gaytan',1,1,'2019-10-03','09:22:17','','',1,1),(30,'En Mano Rustico',0,'N/A','Fermin Avila Hernandez',1,1,'2020-01-20','14:42:22','','',1,1);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-01 12:08:18
