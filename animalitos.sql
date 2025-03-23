-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: animalitos
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `adopcion`
--

DROP TABLE IF EXISTS `adopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `adopcion` (
  `idadopcion` int(11) NOT NULL AUTO_INCREMENT,
  `estado_adopcion` bit(1) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  PRIMARY KEY (`idadopcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adopcion`
--

LOCK TABLES `adopcion` WRITE;
/*!40000 ALTER TABLE `adopcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `adopcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `animal` (
  `id_animal` int(11) NOT NULL AUTO_INCREMENT,
  `edad` varchar(4) NOT NULL,
  `estado_animal` bit(1) NOT NULL,
  `esterilizado` bit(1) NOT NULL,
  `imagen_animal` varchar(255) NOT NULL,
  `nombre_animal` varchar(155) NOT NULL,
  `raza` varchar(45) NOT NULL,
  PRIMARY KEY (`id_animal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'3',_binary '',_binary '','imagen1.jpg','Firu','Chanda'),(2,'33',_binary '',_binary '','imagen1.jpg','Coco','Gran Danes');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_personales`
--

DROP TABLE IF EXISTS `datos_personales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `datos_personales` (
  `id_datos_personales` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(55) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `dni` varchar(55) NOT NULL,
  `email` varchar(155) NOT NULL,
  `nombre_completo` varchar(255) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  PRIMARY KEY (`id_datos_personales`),
  UNIQUE KEY `UKdpry7ftc29rs0ov9tn6x8cqdj` (`dni`),
  UNIQUE KEY `UKlbmttbb0j82ogk5xm579ikitt` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_personales`
--

LOCK TABLES `datos_personales` WRITE;
/*!40000 ALTER TABLE `datos_personales` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_personales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_adopcion`
--

DROP TABLE IF EXISTS `detalle_adopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `detalle_adopcion` (
  `iddetalleadopcion` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`iddetalleadopcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_adopcion`
--

LOCK TABLES `detalle_adopcion` WRITE;
/*!40000 ALTER TABLE `detalle_adopcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_adopcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historia_animal`
--

DROP TABLE IF EXISTS `historia_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `historia_animal` (
  `idhistoriaanimal` int(11) NOT NULL AUTO_INCREMENT,
  `chip` bit(1) NOT NULL,
  `estado_salud` text NOT NULL,
  `fecha_creado` datetime(6) NOT NULL,
  `fecha_modificado` datetime(6) NOT NULL,
  PRIMARY KEY (`idhistoriaanimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia_animal`
--

LOCK TABLES `historia_animal` WRITE;
/*!40000 ALTER TABLE `historia_animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `historia_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `idroles` int(11) NOT NULL AUTO_INCREMENT,
  `creado` datetime(6) NOT NULL,
  `modificado` datetime(6) NOT NULL,
  PRIMARY KEY (`idroles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_animal`
--

DROP TABLE IF EXISTS `tipo_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_animal` (
  `idtipoanimal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_animal` varchar(155) NOT NULL,
  PRIMARY KEY (`idtipoanimal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_animal`
--

LOCK TABLES `tipo_animal` WRITE;
/*!40000 ALTER TABLE `tipo_animal` DISABLE KEYS */;
INSERT INTO `tipo_animal` VALUES (1,'Perro'),(2,'Gato');
/*!40000 ALTER TABLE `tipo_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documentos`
--

DROP TABLE IF EXISTS `tipo_documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_documentos` (
  `idtipodocumentos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_documento` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipodocumentos`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documentos`
--

LOCK TABLES `tipo_documentos` WRITE;
/*!40000 ALTER TABLE `tipo_documentos` DISABLE KEYS */;
INSERT INTO `tipo_documentos` VALUES (1,'Cédula de Ciudadanía'),(2,'Tarjeta de Identidad'),(3,'Registro Civil'),(4,'Cédula de Extranjería'),(5,'Pasaporte'),(6,'Permiso Especial de Permanencia'),(7,'NIT'),(8,'Documento Nacional de Identidad'),(9,'Carné Diplomático'),(10,'Salvoconducto de Permanencia'),(11,'Otro');
/*!40000 ALTER TABLE `tipo_documentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `estado_tipo_usuario` bit(1) NOT NULL,
  `nombre_tipo_usuario` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_vacuna`
--

DROP TABLE IF EXISTS `tipo_vacuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_vacuna` (
  `idvacunas` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_vacuna` varchar(155) NOT NULL,
  PRIMARY KEY (`idvacunas`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_vacuna`
--

LOCK TABLES `tipo_vacuna` WRITE;
/*!40000 ALTER TABLE `tipo_vacuna` DISABLE KEYS */;
INSERT INTO `tipo_vacuna` VALUES (1,'Rabia'),(2,'Moquillo'),(3,'Parvovirus'),(4,'Hepatitis Canina'),(5,'Leptospirosis'),(6,'Coronavirus Canino'),(7,'Bordetella'),(8,'Parainfluenza Canina'),(9,'Giardia'),(10,'Calicivirus Felino'),(11,'Rinotraqueitis Felina'),(12,'Panleucopenia Felina'),(13,'Leucemia Felina'),(14,'Peritonitis Infecciosa Felina'),(15,'Inmunodeficiencia Felina');
/*!40000 ALTER TABLE `tipo_vacuna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoUsuario`
--

DROP TABLE IF EXISTS `tipoUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipoUsuario` (
  `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_usuario` varchar(100) NOT NULL,
  `estado_tipoUsuario` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoUsuario`
--

LOCK TABLES `tipoUsuario` WRITE;
/*!40000 ALTER TABLE `tipoUsuario` DISABLE KEYS */;
INSERT INTO `tipoUsuario` VALUES (1,'Cuidador',1),(2,'Tienda',1),(3,'Albergue',1),(4,'Adoptante',1),(5,'Donante',1);
/*!40000 ALTER TABLE `tipoUsuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(155) NOT NULL,
  `estado_usuario` bit(1) NOT NULL,
  `pass_usuario` varchar(155) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK5171l57faosmj8myawaucatdw` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-23  9:53:08
