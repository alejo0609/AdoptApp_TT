CREATE DATABASE  IF NOT EXISTS `animalitos` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `animalitos`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: animalitos
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `adopcion`
--

DROP TABLE IF EXISTS `adopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adopcion` (
  `idadopcion` int NOT NULL AUTO_INCREMENT,
  `estado_adopcion` bit(1) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  PRIMARY KEY (`idadopcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `id_animal` int NOT NULL AUTO_INCREMENT,
  `edad` varchar(4) NOT NULL,
  `estado_animal` bit(1) NOT NULL,
  `esterilizado` bit(1) NOT NULL,
  `imagen_animal` varchar(255) NOT NULL,
  `nombre_animal` varchar(155) NOT NULL,
  `raza` varchar(45) NOT NULL,
  PRIMARY KEY (`id_animal`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'3',_binary '',_binary '','perro1.jpg','Max','Labrador'),(2,'2',_binary '',_binary '','perro2.jpg','Luna','Golden Retriever'),(3,'1',_binary '\0',_binary '\0','cat1.jpg','Simba','Gato Persa'),(4,'5',_binary '',_binary '','perro3.jpg','Milo','Bulldog'),(5,'4',_binary '',_binary '','cat2.jpg','Nala','Siames'),(6,'6',_binary '\0',_binary '\0','perro4.jpg','Toby','Beagle'),(7,'2',_binary '',_binary '','cat3.jpg','Cleo','Mestizo'),(8,'3',_binary '',_binary '','perro5.jpg','Rocky','Husky'),(9,'1',_binary '',_binary '','cat4.jpg','Michi','Maine Coon'),(10,'7',_binary '\0',_binary '\0','perro6.jpg','Bruno','Pastor Alemán'),(11,'3',_binary '',_binary '','dog1.jpg','Bella','Dálmata'),(12,'4',_binary '',_binary '','cat5.jpg','Chester','British Shorthair'),(13,'2',_binary '',_binary '','dog2.jpg','Bolt','Jack Russell Terrier'),(14,'5',_binary '\0',_binary '\0','image1.jpg','Felix','Bengalí'),(15,'3',_binary '',_binary '','dog3.jpg','Duke','San Bernardo'),(16,'6',_binary '',_binary '','image2.jpg','Garfield','Exótico'),(17,'4',_binary '\0',_binary '\0','dog4.jpg','Zeus','Doberman'),(18,'2',_binary '',_binary '','image3.jpg','Tom','Azul Ruso'),(19,'5',_binary '',_binary '','dog5.jpg','Rex','Rottweiler'),(20,'1',_binary '\0',_binary '\0','animal-Background.jpg','Oliver','Siberiano');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuidador`
--

DROP TABLE IF EXISTS `cuidador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuidador` (
  `id` bigint NOT NULL,
  `nombre_completo` varchar(255) DEFAULT NULL,
  `numero_identificacion` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `correo_electronico` varchar(255) DEFAULT NULL,
  `experiencia` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_identificacion` (`numero_identificacion`),
  UNIQUE KEY `correo_electronico` (`correo_electronico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuidador`
--

LOCK TABLES `cuidador` WRITE;
/*!40000 ALTER TABLE `cuidador` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuidador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_personales`
--

DROP TABLE IF EXISTS `datos_personales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_personales` (
  `id_datos_personales` int NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(55) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `dni` varchar(55) NOT NULL,
  `email` varchar(155) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `confirm_password` varchar(155) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(155) NOT NULL,
  PRIMARY KEY (`id_datos_personales`),
  UNIQUE KEY `UKdpry7ftc29rs0ov9tn6x8cqdj` (`dni`),
  UNIQUE KEY `UKlbmttbb0j82ogk5xm579ikitt` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_personales`
--

LOCK TABLES `datos_personales` WRITE;
/*!40000 ALTER TABLE `datos_personales` DISABLE KEYS */;
INSERT INTO `datos_personales` VALUES (1,'Medellín','Calle 54','1215444278','alehhfg@alejo.com','4322578942','hjdfhdkjhdfk','Aandres poustrepo','hjdfhdkjhdfk'),(2,'Medellín','Calle 54','1215278','alehhfg@ale.com','4322578942','hjdfhdkjhdfk','Aandres poustrepo','hjdfhdkjfk'),(3,'Medellín','Calle 54','1214145278','alehnhghhghfg@ale.com','4322578942','hjdfhhfghthdkjfk','Aares poustrepo','hjdfhhfghthdkjfk'),(4,'medellin','manrique','1000258963','mateo@gmail.com','321456977','123456789','mateo','123456789');
/*!40000 ALTER TABLE `datos_personales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_adopcion`
--

DROP TABLE IF EXISTS `detalle_adopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_adopcion` (
  `iddetalleadopcion` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`iddetalleadopcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historia_animal` (
  `idhistoriaanimal` int NOT NULL AUTO_INCREMENT,
  `chip` bit(1) NOT NULL,
  `estado_salud` text NOT NULL,
  `fecha_creado` datetime(6) NOT NULL,
  `fecha_modificado` datetime(6) NOT NULL,
  PRIMARY KEY (`idhistoriaanimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idroles` int NOT NULL AUTO_INCREMENT,
  `creado` datetime(6) NOT NULL,
  `modificado` datetime(6) NOT NULL,
  PRIMARY KEY (`idroles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tienda`
--

DROP TABLE IF EXISTS `tienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tienda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo_electronico` varchar(100) NOT NULL,
  `sitio_web` varchar(100) DEFAULT NULL,
  `ciudad` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo_electronico` (`correo_electronico`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tienda`
--

LOCK TABLES `tienda` WRITE;
/*!40000 ALTER TABLE `tienda` DISABLE KEYS */;
INSERT INTO `tienda` VALUES (1,'Tienda PetLovers','Calle 123','3001234567','contacto@petlovers.com','https://plovs.com','Medellin','miPasswo3'),(2,'Tienda PhhhhhetLovers','Calle 123','3001234567','contacthhho@petlovers.com','https://phhjjjjjhhhlovs.com','Medellin','yhhyjjjhty'),(3,'maerdd','carrera 37','60425252525','n@a.com','andres.com','medellin','123456');
/*!40000 ALTER TABLE `tienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_animal`
--

DROP TABLE IF EXISTS `tipo_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_animal` (
  `idtipoanimal` int NOT NULL AUTO_INCREMENT,
  `nombre_tipo_animal` varchar(155) NOT NULL,
  PRIMARY KEY (`idtipoanimal`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_animal`
--

LOCK TABLES `tipo_animal` WRITE;
/*!40000 ALTER TABLE `tipo_animal` DISABLE KEYS */;
INSERT INTO `tipo_animal` VALUES (2,'Perro'),(3,'Gato');
/*!40000 ALTER TABLE `tipo_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documentos`
--

DROP TABLE IF EXISTS `tipo_documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_documentos` (
  `idtipodocumentos` int NOT NULL AUTO_INCREMENT,
  `nombre_tipo_documento` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipodocumentos`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_usuario` (
  `idTipoUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre_tipo_usuario` varchar(100) NOT NULL,
  `estado_tipoUsuario` tinyint NOT NULL DEFAULT '1',
  `estado_tipo_usuario` bit(1) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Cuidador',1,_binary '\0'),(2,'Tienda',1,_binary '\0'),(3,'Albergue',1,_binary '\0'),(4,'Adoptante',1,_binary '\0'),(5,'Donante',1,_binary '\0');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_vacuna`
--

DROP TABLE IF EXISTS `tipo_vacuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_vacuna` (
  `idvacunas` int NOT NULL AUTO_INCREMENT,
  `nombre_tipo_vacuna` varchar(155) NOT NULL,
  PRIMARY KEY (`idvacunas`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `email` varchar(155) NOT NULL,
  `estado_usuario` bit(1) NOT NULL,
  `pass_usuario` varchar(155) NOT NULL,
  `password` varchar(155) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK5171l57faosmj8myawaucatdw` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
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

-- Dump completed on 2025-04-01 21:17:01
