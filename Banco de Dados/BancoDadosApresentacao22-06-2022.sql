CREATE DATABASE  IF NOT EXISTS `concessionaria` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `concessionaria`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: concessionaria
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `idCidade` int NOT NULL AUTO_INCREMENT,
  `idEstadoFK` int NOT NULL,
  `cidade` varchar(100) NOT NULL,
  PRIMARY KEY (`idCidade`),
  KEY `fk_cidade_pais_idx` (`idEstadoFK`),
  CONSTRAINT `fk_cidade_estado` FOREIGN KEY (`idEstadoFK`) REFERENCES `estado` (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=5571 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `idPessoaFK` int NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `fk_cliente_pessoa1_idx` (`idPessoaFK`),
  CONSTRAINT `fk_cliente_pessoa` FOREIGN KEY (`idPessoaFK`) REFERENCES `pessoa` (`idPessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=981 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `idEndereco` int NOT NULL AUTO_INCREMENT,
  `idCidadeFK` int NOT NULL,
  `logradouro` varchar(250) NOT NULL,
  `bairro` varchar(150) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `cep` varchar(10) NOT NULL,
  PRIMARY KEY (`idEndereco`),
  KEY `fk_endereco_cidade_idx` (`idCidadeFK`),
  CONSTRAINT `fk_endereco_cidade` FOREIGN KEY (`idCidadeFK`) REFERENCES `cidade` (`idCidade`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `idEstado` int NOT NULL AUTO_INCREMENT,
  `idPaisFK` int NOT NULL,
  `estado` varchar(255) NOT NULL,
  PRIMARY KEY (`idEstado`),
  KEY `fk_estado_pais_idx` (`idPaisFK`),
  CONSTRAINT `fk_estado_pais` FOREIGN KEY (`idPaisFK`) REFERENCES `pais` (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `idFuncionario` int NOT NULL AUTO_INCREMENT,
  `idPessoaFK` int NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `dataNascimento` date NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `situacao` varchar(50) NOT NULL,
  `salario` decimal(10,2) NOT NULL,
  `dataContratacao` date NOT NULL,
  `dataDemissao` date DEFAULT NULL,
  `senha` varchar(255) NOT NULL,
  `perguntaSeguranca` varchar(255) NOT NULL,
  `respostaSeguranca` varchar(255) NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  KEY `fk_funcionario_pessoa` (`idPessoaFK`),
  CONSTRAINT `fk_funcionario_pessoa` FOREIGN KEY (`idPessoaFK`) REFERENCES `pessoa` (`idPessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=357971 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modelo` (
  `idModelo` int NOT NULL AUTO_INCREMENT,
  `nomeFabricante` varchar(255) NOT NULL,
  `nomeCarro` varchar(150) NOT NULL,
  `versao` varchar(100) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  PRIMARY KEY (`idModelo`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `idPais` int NOT NULL AUTO_INCREMENT,
  `pais` varchar(255) NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `idPessoa` int NOT NULL AUTO_INCREMENT,
  `idEnderecoFK` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `dataPreenchimento` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idPessoa`),
  KEY `fk_pessoa_endereco_idx` (`idEnderecoFK`),
  CONSTRAINT `fk_pessoa_endereco` FOREIGN KEY (`idEnderecoFK`) REFERENCES `endereco` (`idEndereco`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veiculo` (
  `idVeiculo` int NOT NULL AUTO_INCREMENT,
  `idModeloFK` int NOT NULL,
  `situacao` varchar(50) NOT NULL,
  `condicao` varchar(50) NOT NULL,
  `numeroChassi` varchar(100) NOT NULL,
  `placa` varchar(45) DEFAULT NULL,
  `valorPedido` decimal(10,2) NOT NULL,
  `valorVendido` decimal(10,2) DEFAULT NULL,
  `quantidadePortas` int NOT NULL,
  `anoFabricacao` varchar(10) NOT NULL,
  `anoModelo` varchar(10) NOT NULL,
  `cor` varchar(45) NOT NULL,
  `cilindro` int NOT NULL,
  `cilindrada` decimal(10,1) NOT NULL,
  `torque` decimal(10,1) NOT NULL,
  `potencia` int NOT NULL,
  `valvula` int NOT NULL,
  `tipoCombustivel` varchar(100) NOT NULL,
  `aroPneu` int NOT NULL,
  `larguraPneu` int NOT NULL,
  `medidaPneu` int NOT NULL,
  `tipoDirecao` varchar(50) NOT NULL,
  `freioAbs` varchar(50) NOT NULL,
  `freioDianteiro` varchar(45) NOT NULL,
  `freioTraseiro` varchar(45) NOT NULL,
  `transmissao` varchar(100) NOT NULL,
  `alarme` varchar(50) NOT NULL,
  `sistemaVidroDianteiro` varchar(50) NOT NULL,
  `sistemaVidroTraseiro` varchar(50) NOT NULL,
  `tanqueCombustivel` int NOT NULL,
  PRIMARY KEY (`idVeiculo`),
  KEY `fk_veiculo_modelo1_idx` (`idModeloFK`),
  CONSTRAINT `fk_veiculo_fabricante` FOREIGN KEY (`idModeloFK`) REFERENCES `modelo` (`idModelo`)
) ENGINE=InnoDB AUTO_INCREMENT=915 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `idVenda` int NOT NULL AUTO_INCREMENT,
  `idFuncionarioFK` int NOT NULL,
  `idClienteFK` int NOT NULL,
  `idVeiculoFK` int NOT NULL,
  `valorVenda` decimal(10,2) NOT NULL,
  `tipoVenda` varchar(100) NOT NULL,
  `dataVenda` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idVenda`),
  KEY `fk_venda_funcionario` (`idFuncionarioFK`),
  KEY `fk_venda_cliente` (`idClienteFK`),
  KEY `fk_venda_veiculo_idx` (`idVeiculoFK`),
  CONSTRAINT `fk_venda_cliente` FOREIGN KEY (`idClienteFK`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_venda_funcionario` FOREIGN KEY (`idFuncionarioFK`) REFERENCES `funcionario` (`idFuncionario`),
  CONSTRAINT `fk_venda_veiculo` FOREIGN KEY (`idVeiculoFK`) REFERENCES `veiculo` (`idVeiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=951881 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vwlistacliente`
--

DROP TABLE IF EXISTS `vwlistacliente`;
/*!50001 DROP VIEW IF EXISTS `vwlistacliente`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vwlistacliente` AS SELECT 
 1 AS `idCliente`,
 1 AS `idPessoaFK`,
 1 AS `idPessoa`,
 1 AS `idEnderecoFK`,
 1 AS `nome`,
 1 AS `email`,
 1 AS `telefone`,
 1 AS `cpf`,
 1 AS `dataPreenchimento`,
 1 AS `idEndereco`,
 1 AS `idCidadeFK`,
 1 AS `logradouro`,
 1 AS `bairro`,
 1 AS `numero`,
 1 AS `cep`,
 1 AS `idCidade`,
 1 AS `idEstadoFK`,
 1 AS `cidade`,
 1 AS `idEstado`,
 1 AS `idPaisFK`,
 1 AS `estado`,
 1 AS `idPais`,
 1 AS `pais`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vwlistafuncionario`
--

DROP TABLE IF EXISTS `vwlistafuncionario`;
/*!50001 DROP VIEW IF EXISTS `vwlistafuncionario`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vwlistafuncionario` AS SELECT 
 1 AS `idFuncionario`,
 1 AS `idPessoaFK`,
 1 AS `sexo`,
 1 AS `dataNascimento`,
 1 AS `cargo`,
 1 AS `situacao`,
 1 AS `salario`,
 1 AS `dataContratacao`,
 1 AS `dataDemissao`,
 1 AS `senha`,
 1 AS `perguntaSeguranca`,
 1 AS `respostaSeguranca`,
 1 AS `idPessoa`,
 1 AS `idEnderecoFK`,
 1 AS `nome`,
 1 AS `email`,
 1 AS `telefone`,
 1 AS `cpf`,
 1 AS `dataPreenchimento`,
 1 AS `idEndereco`,
 1 AS `idCidadeFK`,
 1 AS `logradouro`,
 1 AS `bairro`,
 1 AS `numero`,
 1 AS `cep`,
 1 AS `idCidade`,
 1 AS `idEstadoFK`,
 1 AS `cidade`,
 1 AS `idEstado`,
 1 AS `idPaisFK`,
 1 AS `estado`,
 1 AS `idPais`,
 1 AS `pais`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vwlistaveiculo`
--

DROP TABLE IF EXISTS `vwlistaveiculo`;
/*!50001 DROP VIEW IF EXISTS `vwlistaveiculo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vwlistaveiculo` AS SELECT 
 1 AS `idModelo`,
 1 AS `nomeFabricante`,
 1 AS `nomeCarro`,
 1 AS `versao`,
 1 AS `categoria`,
 1 AS `idVeiculo`,
 1 AS `idModeloFK`,
 1 AS `situacao`,
 1 AS `condicao`,
 1 AS `numeroChassi`,
 1 AS `placa`,
 1 AS `valorPedido`,
 1 AS `valorVendido`,
 1 AS `quantidadePortas`,
 1 AS `anoFabricacao`,
 1 AS `anoModelo`,
 1 AS `cor`,
 1 AS `cilindro`,
 1 AS `cilindrada`,
 1 AS `torque`,
 1 AS `potencia`,
 1 AS `valvula`,
 1 AS `tipoCombustivel`,
 1 AS `aroPneu`,
 1 AS `larguraPneu`,
 1 AS `medidaPneu`,
 1 AS `tipoDirecao`,
 1 AS `freioAbs`,
 1 AS `freioDianteiro`,
 1 AS `freioTraseiro`,
 1 AS `transmissao`,
 1 AS `alarme`,
 1 AS `SistemaVidroDianteiro`,
 1 AS `SistemaVidroTraseiro`,
 1 AS `tanqueCombustivel`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vwlistacliente`
--

/*!50001 DROP VIEW IF EXISTS `vwlistacliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vwlistacliente` AS select `cliente`.`idCliente` AS `idCliente`,`cliente`.`idPessoaFK` AS `idPessoaFK`,`pessoa`.`idPessoa` AS `idPessoa`,`pessoa`.`idEnderecoFK` AS `idEnderecoFK`,`pessoa`.`nome` AS `nome`,`pessoa`.`email` AS `email`,`pessoa`.`telefone` AS `telefone`,`pessoa`.`cpf` AS `cpf`,`pessoa`.`dataPreenchimento` AS `dataPreenchimento`,`endereco`.`idEndereco` AS `idEndereco`,`endereco`.`idCidadeFK` AS `idCidadeFK`,`endereco`.`logradouro` AS `logradouro`,`endereco`.`bairro` AS `bairro`,`endereco`.`numero` AS `numero`,`endereco`.`cep` AS `cep`,`cidade`.`idCidade` AS `idCidade`,`cidade`.`idEstadoFK` AS `idEstadoFK`,`cidade`.`cidade` AS `cidade`,`estado`.`idEstado` AS `idEstado`,`estado`.`idPaisFK` AS `idPaisFK`,`estado`.`estado` AS `estado`,`pais`.`idPais` AS `idPais`,`pais`.`pais` AS `pais` from (((((`pessoa` join `cliente` on((`pessoa`.`idPessoa` = `cliente`.`idPessoaFK`))) join `endereco` on((`endereco`.`idEndereco` = `pessoa`.`idEnderecoFK`))) join `cidade` on((`cidade`.`idCidade` = `endereco`.`idCidadeFK`))) join `estado` on((`estado`.`idEstado` = `cidade`.`idEstadoFK`))) join `pais` on((`estado`.`idPaisFK` = `pais`.`idPais`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vwlistafuncionario`
--

/*!50001 DROP VIEW IF EXISTS `vwlistafuncionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vwlistafuncionario` AS select `funcionario`.`idFuncionario` AS `idFuncionario`,`funcionario`.`idPessoaFK` AS `idPessoaFK`,`funcionario`.`sexo` AS `sexo`,`funcionario`.`dataNascimento` AS `dataNascimento`,`funcionario`.`cargo` AS `cargo`,`funcionario`.`situacao` AS `situacao`,`funcionario`.`salario` AS `salario`,`funcionario`.`dataContratacao` AS `dataContratacao`,`funcionario`.`dataDemissao` AS `dataDemissao`,`funcionario`.`senha` AS `senha`,`funcionario`.`perguntaSeguranca` AS `perguntaSeguranca`,`funcionario`.`respostaSeguranca` AS `respostaSeguranca`,`pessoa`.`idPessoa` AS `idPessoa`,`pessoa`.`idEnderecoFK` AS `idEnderecoFK`,`pessoa`.`nome` AS `nome`,`pessoa`.`email` AS `email`,`pessoa`.`telefone` AS `telefone`,`pessoa`.`cpf` AS `cpf`,`pessoa`.`dataPreenchimento` AS `dataPreenchimento`,`endereco`.`idEndereco` AS `idEndereco`,`endereco`.`idCidadeFK` AS `idCidadeFK`,`endereco`.`logradouro` AS `logradouro`,`endereco`.`bairro` AS `bairro`,`endereco`.`numero` AS `numero`,`endereco`.`cep` AS `cep`,`cidade`.`idCidade` AS `idCidade`,`cidade`.`idEstadoFK` AS `idEstadoFK`,`cidade`.`cidade` AS `cidade`,`estado`.`idEstado` AS `idEstado`,`estado`.`idPaisFK` AS `idPaisFK`,`estado`.`estado` AS `estado`,`pais`.`idPais` AS `idPais`,`pais`.`pais` AS `pais` from (((((`pessoa` join `funcionario` on((`pessoa`.`idPessoa` = `funcionario`.`idPessoaFK`))) join `endereco` on((`endereco`.`idEndereco` = `pessoa`.`idEnderecoFK`))) join `cidade` on((`cidade`.`idCidade` = `endereco`.`idCidadeFK`))) join `estado` on((`estado`.`idEstado` = `cidade`.`idEstadoFK`))) join `pais` on((`estado`.`idPaisFK` = `pais`.`idPais`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vwlistaveiculo`
--

/*!50001 DROP VIEW IF EXISTS `vwlistaveiculo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vwlistaveiculo` AS select `modelo`.`idModelo` AS `idModelo`,`modelo`.`nomeFabricante` AS `nomeFabricante`,`modelo`.`nomeCarro` AS `nomeCarro`,`modelo`.`versao` AS `versao`,`modelo`.`categoria` AS `categoria`,`veiculo`.`idVeiculo` AS `idVeiculo`,`veiculo`.`idModeloFK` AS `idModeloFK`,`veiculo`.`situacao` AS `situacao`,`veiculo`.`condicao` AS `condicao`,`veiculo`.`numeroChassi` AS `numeroChassi`,`veiculo`.`placa` AS `placa`,`veiculo`.`valorPedido` AS `valorPedido`,`veiculo`.`valorVendido` AS `valorVendido`,`veiculo`.`quantidadePortas` AS `quantidadePortas`,`veiculo`.`anoFabricacao` AS `anoFabricacao`,`veiculo`.`anoModelo` AS `anoModelo`,`veiculo`.`cor` AS `cor`,`veiculo`.`cilindro` AS `cilindro`,`veiculo`.`cilindrada` AS `cilindrada`,`veiculo`.`torque` AS `torque`,`veiculo`.`potencia` AS `potencia`,`veiculo`.`valvula` AS `valvula`,`veiculo`.`tipoCombustivel` AS `tipoCombustivel`,`veiculo`.`aroPneu` AS `aroPneu`,`veiculo`.`larguraPneu` AS `larguraPneu`,`veiculo`.`medidaPneu` AS `medidaPneu`,`veiculo`.`tipoDirecao` AS `tipoDirecao`,`veiculo`.`freioAbs` AS `freioAbs`,`veiculo`.`freioDianteiro` AS `freioDianteiro`,`veiculo`.`freioTraseiro` AS `freioTraseiro`,`veiculo`.`transmissao` AS `transmissao`,`veiculo`.`alarme` AS `alarme`,`veiculo`.`sistemaVidroDianteiro` AS `SistemaVidroDianteiro`,`veiculo`.`sistemaVidroTraseiro` AS `SistemaVidroTraseiro`,`veiculo`.`tanqueCombustivel` AS `tanqueCombustivel` from (`veiculo` join `modelo` on((`modelo`.`idModelo` = `veiculo`.`idModeloFK`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-22 17:01:46
