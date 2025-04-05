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
  `estadoAnimal` tinyint(1) DEFAULT NULL,
  `esterilizado` bit(1) NOT NULL,
  `imagen_animal` varchar(255) NOT NULL,
  `nombre_animal` varchar(155) NOT NULL,
  `raza` varchar(45) NOT NULL,
  `estado_animal` bit(1) NOT NULL,
  PRIMARY KEY (`id_animal`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'3',NULL,_binary '','perro1.jpg','Max','Labrador',_binary '\0'),(2,'2',NULL,_binary '','perro2.jpg','Luna','Golden Retriever',_binary '\0'),(3,'1',NULL,_binary '\0','cat1.jpg','Simba','Gato Persa',_binary '\0'),(4,'5',NULL,_binary '','perro3.jpg','Milo','Bulldog',_binary '\0'),(5,'4',NULL,_binary '','cat2.jpg','Nala','Siames',_binary '\0'),(6,'6',NULL,_binary '\0','perro4.jpg','Toby','Beagle',_binary '\0'),(7,'2',NULL,_binary '','cat3.jpg','Cleo','Mestizo',_binary '\0'),(8,'3',NULL,_binary '','perro5.jpg','Rocky','Husky',_binary '\0'),(9,'1',NULL,_binary '','cat4.jpg','Michi','Maine Coon',_binary '\0'),(10,'7',NULL,_binary '\0','perro6.jpg','Bruno','Pastor Alemán',_binary '\0'),(11,'3',NULL,_binary '','dog1.jpg','Bella','Dálmata',_binary '\0'),(12,'4',NULL,_binary '','cat5.jpg','Chester','British Shorthair',_binary '\0'),(13,'2',NULL,_binary '','dog2.jpg','Bolt','Jack Russell Terrier',_binary '\0'),(14,'5',NULL,_binary '\0','image1.jpg','Felix','Bengalí',_binary '\0'),(15,'3',NULL,_binary '','dog3.jpg','Duke','San Bernardo',_binary '\0'),(16,'6',NULL,_binary '','image2.jpg','Garfield','Exótico',_binary '\0'),(17,'4',NULL,_binary '\0','dog4.jpg','Zeus','Doberman',_binary '\0'),(18,'2',NULL,_binary '','image3.jpg','Tom','Azul Ruso',_binary '\0'),(19,'5',NULL,_binary '','dog5.jpg','Rex','Rottweiler',_binary '\0'),(20,'1',NULL,_binary '\0','animal-Background.jpg','Oliver','Siberiano',_binary '\0'),(21,'3',NULL,_binary '','dog5.jpg','Andres Perez','Labrador',_binary ''),(22,'21',NULL,_binary '','perro2.jpg','Maximiliano','Rotwailer',_binary '\0'),(23,'21',NULL,_binary '','perro2.jpg','Carolino','Rotwailer',_binary '');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
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
  `email` varchar(155) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `confirm_password` varchar(155) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(155) NOT NULL,
  `dni` bigint NOT NULL,
  PRIMARY KEY (`id_datos_personales`),
  UNIQUE KEY `UKlbmttbb0j82ogk5xm579ikitt` (`email`),
  UNIQUE KEY `UKdpry7ftc29rs0ov9tn6x8cqdj` (`dni`),
  UNIQUE KEY `unique_dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_personales`
--

LOCK TABLES `datos_personales` WRITE;
/*!40000 ALTER TABLE `datos_personales` DISABLE KEYS */;
INSERT INTO `datos_personales` VALUES (7,'Medellin','carrera 50 94-123','gamersoccer700@gmail.com','344556696778','12345678','Pedro firu','12345678',1234456787),(11,'Medellin','Calle 54 # 86a-60 int. 207','alejocxc22222@hotmail.com','3044122036cx','1234','Coste Ubarnes','1234',37498005);
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
  `id` int NOT NULL AUTO_INCREMENT,
  `compania` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cedula` (`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tienda`
--

LOCK TABLES `tienda` WRITE;
/*!40000 ALTER TABLE `tienda` DISABLE KEYS */;
INSERT INTO `tienda` VALUES (1,'TechWorld','Juan Pérez','100200300'),(2,'Supermercado El Sol','María Gómez','200300400'),(3,'Ferretería Los Andes','Carlos Ramírez','300400500'),(4,'Moda y Estilo','Ana Fernández','400500600'),(5,'Cafetería Delicias','Pedro López','500600700');
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
  `compania` varchar(100) NOT NULL,
  `propietario` varchar(255) NOT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `contacto` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ciudad` varchar(100) NOT NULL,
  `ciuadad` varchar(255) DEFAULT NULL,
  `estado_tipo_us` bit(1) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Cuidador','1','0','','','',NULL,_binary '\0'),(2,'Tienda','1','0','','','',NULL,_binary '\0'),(3,'Albergue','1','0','','','',NULL,_binary '\0'),(4,'Adoptante','1','0','','','',NULL,_binary '\0'),(5,'Donante','1','0','','','',NULL,_binary '\0'),(6,'Tienda La Esquina','Carlos Pérez','12345678A','3001234567','carlosperez@mail.com','Medellín',NULL,_binary '\0'),(7,'Supermercado El Centro','Ana Gómez','87654321B','3019876543','anagomez@mail.com','Bogotá',NULL,_binary '\0'),(8,'Boutique Elegancia','Luis Martínez','11223344C','3025556677','luismartinez@mail.com','Cali',NULL,_binary '\0'),(9,'ElectroHogar','Marta Rodríguez','44332211D','3034445566','martarodriguez@mail.com','Barranquilla',NULL,_binary '\0'),(10,'Papelería y Más','Pedro Ramírez','55667788E','3047778899','pedroramirez@mail.com','Cartagena',NULL,_binary '\0');
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_vacuna`
--

LOCK TABLES `tipo_vacuna` WRITE;
/*!40000 ALTER TABLE `tipo_vacuna` DISABLE KEYS */;
INSERT INTO `tipo_vacuna` VALUES (1,'Rabia'),(2,'Moquillo'),(3,'Parvovirus'),(4,'Hepatitis Canina'),(5,'Leptospirosis'),(6,'Coronavirus Canino'),(7,'Bordetella'),(8,'Parainfluenza Canina'),(9,'Giardia'),(10,'Calicivirus Felino'),(11,'Rinotraqueitis Felina'),(12,'Panleucopenia Felina'),(13,'Leucemia Felina'),(14,'Peritonitis Infecciosa Felina'),(15,'Inmunodeficiencia Felina'),(16,'vvvvvvv');
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

-- Dump completed on 2025-04-05 10:28:05
