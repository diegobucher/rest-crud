CREATE DATABASE  IF NOT EXISTS `datainfo_rest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `datainfo_rest`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: datainfo_rest
-- ------------------------------------------------------
-- Server version	5.1.72-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `funcao_usuario_externo`
--

DROP TABLE IF EXISTS `funcao_usuario_externo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcao_usuario_externo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `funcao` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcao_usuario_externo`
--

LOCK TABLES `funcao_usuario_externo` WRITE;
/*!40000 ALTER TABLE `funcao_usuario_externo` DISABLE KEYS */;
INSERT INTO `funcao_usuario_externo` VALUES (1,'Gestor'),(2,'Administrador'),(3,'Frente de Caixa');
/*!40000 ALTER TABLE `funcao_usuario_externo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_externo`
--

DROP TABLE IF EXISTS `usuario_externo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_externo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `perfil_acesso` bigint(20) NOT NULL,
  `situacao` varchar(255) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) NOT NULL,
  `funcao_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmkvog64qmh4rytt8lmxjuloyg` (`funcao_id`),
  CONSTRAINT `FKmkvog64qmh4rytt8lmxjuloyg` FOREIGN KEY (`funcao_id`) REFERENCES `funcao_usuario_externo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_externo`
--

LOCK TABLES `usuario_externo` WRITE;
/*!40000 ALTER TABLE `usuario_externo` DISABLE KEYS */;
INSERT INTO `usuario_externo` VALUES (1,'05518138903','diegobucher@gmail.com',3,'I','47999123969','Diego Bucher',1),(2,'83120918660','thiagocaiobarros-75@creativeinteriores.com.br',3,'A','6937775866','Thiago Caio Barros',2);
/*!40000 ALTER TABLE `usuario_externo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-09 19:14:03
