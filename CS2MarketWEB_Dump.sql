CREATE DATABASE  IF NOT EXISTS `cs2market` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `cs2market`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cs2market
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `arma`
--

DROP TABLE IF EXISTS `arma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `arma` (
  `idarma` int(11) NOT NULL AUTO_INCREMENT,
  `arma` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idarma`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arma`
--

LOCK TABLES `arma` WRITE;
/*!40000 ALTER TABLE `arma` DISABLE KEYS */;
INSERT INTO `arma` VALUES (1,'USP-S'),(2,'Glock-18'),(3,'Galil'),(4,'FAMAS'),(5,'AK-47'),(6,'M4A4'),(7,'M4A1-S'),(8,'Desert Eagle'),(9,'AWP'),(11,'MP5-SD'),(20,'P250');
/*!40000 ALTER TABLE `arma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrinho` (
  `idcarrinho` int(11) NOT NULL AUTO_INCREMENT,
  `id_skin` int(11) DEFAULT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`idcarrinho`),
  KEY `id_skin` (`id_skin`),
  CONSTRAINT `carrinho_ibfk_2` FOREIGN KEY (`id_skin`) REFERENCES `skin` (`idskin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colecao`
--

DROP TABLE IF EXISTS `colecao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colecao` (
  `idcol` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colecao`
--

LOCK TABLES `colecao` WRITE;
/*!40000 ALTER TABLE `colecao` DISABLE KEYS */;
INSERT INTO `colecao` VALUES (1,'Nao possui'),(2,'Mirage'),(4,'Dust II'),(5,'The Assault Collection'),(6,'Anubis'),(7,'Inferno');
/*!40000 ALTER TABLE `colecao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario_loja`
--

DROP TABLE IF EXISTS `inventario_loja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario_loja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_skin` int(11) DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_skin` (`id_skin`),
  CONSTRAINT `inventario_loja_ibfk_1` FOREIGN KEY (`id_skin`) REFERENCES `skin` (`idskin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario_loja`
--

LOCK TABLES `inventario_loja` WRITE;
/*!40000 ALTER TABLE `inventario_loja` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario_loja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario_usuario`
--

DROP TABLE IF EXISTS `inventario_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario_usuario` (
  `idinvuser` int(11) NOT NULL AUTO_INCREMENT,
  `id_skin` int(11) DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinvuser`),
  KEY `id_skin` (`id_skin`),
  KEY `fk_user` (`id_user`),
  CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `inventario_usuario_ibfk_2` FOREIGN KEY (`id_skin`) REFERENCES `skin` (`idskin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario_usuario`
--

LOCK TABLES `inventario_usuario` WRITE;
/*!40000 ALTER TABLE `inventario_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raridade`
--

DROP TABLE IF EXISTS `raridade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raridade` (
  `idrar` int(11) NOT NULL AUTO_INCREMENT,
  `raridade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrar`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raridade`
--

LOCK TABLES `raridade` WRITE;
/*!40000 ALTER TABLE `raridade` DISABLE KEYS */;
INSERT INTO `raridade` VALUES (1,'Consumidor'),(2,'Industrial'),(3,'Militar'),(4,'Restrito'),(5,'Secreto'),(6,'Oculto'),(8,'Contrabandeado');
/*!40000 ALTER TABLE `raridade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skin`
--

DROP TABLE IF EXISTS `skin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skin` (
  `idskin` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `preco` float DEFAULT NULL,
  `fk_arma` int(11) DEFAULT NULL,
  `fk_raridade` int(11) DEFAULT NULL,
  `fk_colecao` int(11) DEFAULT NULL,
  PRIMARY KEY (`idskin`),
  KEY `arma_idx` (`fk_arma`),
  KEY `raridade_idx` (`fk_raridade`),
  KEY `colecao` (`fk_colecao`),
  CONSTRAINT `arma` FOREIGN KEY (`fk_arma`) REFERENCES `arma` (`idarma`),
  CONSTRAINT `colecao` FOREIGN KEY (`fk_colecao`) REFERENCES `colecao` (`idcol`),
  CONSTRAINT `raridade` FOREIGN KEY (`fk_raridade`) REFERENCES `raridade` (`idrar`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skin`
--

LOCK TABLES `skin` WRITE;
/*!40000 ALTER TABLE `skin` DISABLE KEYS */;
INSERT INTO `skin` VALUES (14,'Fuinha',3.5,2,4,1),(16,'Asiimov',132.9,9,6,1),(17,'Corintiano',1.52,8,3,5),(19,'Fade',4000,2,5,1),(21,'Bico de Bunsen',4.5,2,3,2),(22,'Pesadelo',23.09,7,4,1),(24,'Tons de Preto',22,5,4,1),(25,'Steel Delta',15,5,3,6),(26,'Asiimov',200,6,5,1);
/*!40000 ALTER TABLE `skin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_skin`
--

DROP TABLE IF EXISTS `usuario_skin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_skin` (
  `id_skin` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_skin`),
  KEY `fk_usuario1` (`id_user`),
  CONSTRAINT `fk_usuario1` FOREIGN KEY (`id_user`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `usuario_skin_ibfk_2` FOREIGN KEY (`id_skin`) REFERENCES `skin` (`idskin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_skin`
--

LOCK TABLES `usuario_skin` WRITE;
/*!40000 ALTER TABLE `usuario_skin` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_skin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password_hash` varchar(60) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'ari','$2a$10$SP.rX9nEk4wWlBGlROpQo.Xza2btsokACqtFvn.ue5jQ6u9YDKlXq','arielce21@gmail.com','2024-08-13 20:49:45'),(2,'kawan','$2a$10$u9TA2jDCzZOR/954tJO8c.J6OQpU/ZMZuKvN6wflUzTdsyIWPP/Dq','kawan@gmail.com','2024-08-13 20:50:00');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuario2` (`id_user`),
  CONSTRAINT `fk_usuario2` FOREIGN KEY (`id_user`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
INSERT INTO `wishlist` VALUES (1,1);
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist_skin`
--

DROP TABLE IF EXISTS `wishlist_skin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist_skin` (
  `wishlist_id` int(11) NOT NULL,
  `skin_id` int(11) NOT NULL,
  PRIMARY KEY (`wishlist_id`,`skin_id`),
  KEY `skin_id` (`skin_id`),
  CONSTRAINT `wishlist_skin_ibfk_1` FOREIGN KEY (`wishlist_id`) REFERENCES `wishlist` (`id`),
  CONSTRAINT `wishlist_skin_ibfk_2` FOREIGN KEY (`skin_id`) REFERENCES `skin` (`idskin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist_skin`
--

LOCK TABLES `wishlist_skin` WRITE;
/*!40000 ALTER TABLE `wishlist_skin` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist_skin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-20 15:35:32
