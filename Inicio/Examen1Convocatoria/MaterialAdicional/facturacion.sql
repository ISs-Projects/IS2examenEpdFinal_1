-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	6.0.2-alpha-community-nt-debug


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema facturacion
--

CREATE DATABASE IF NOT EXISTS facturacion;
USE facturacion;

--
-- Temporary table structure for view `vfacturas`
--
DROP TABLE IF EXISTS `vfacturas`;
DROP VIEW IF EXISTS `vfacturas`;
CREATE TABLE `vfacturas` (
  `dni` varchar(10),
  `nombre` varchar(45),
  `direccion` varchar(45),
  `identificador` varchar(10),
  `id_cliente` varchar(10),
  `importe` double
);

--
-- Definition of table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientes`
--

/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`dni`,`nombre`,`direccion`) VALUES 
 ('1111','Francisco Gómez','24.1.?'),
 ('1234','Norberto Díaz','11.1.18');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;


--
-- Definition of table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
CREATE TABLE `facturas` (
  `identificador` varchar(10) NOT NULL,
  `id_cliente` varchar(10) NOT NULL,
  `importe` double DEFAULT NULL,
  PRIMARY KEY (`identificador`) USING BTREE,
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facturas`
--

/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` (`identificador`,`id_cliente`,`importe`) VALUES 
 ('1','1234',500),
 ('2','1111',200);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;


--
-- Definition of view `vfacturas`
--

DROP TABLE IF EXISTS `vfacturas`;
DROP VIEW IF EXISTS `vfacturas`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vfacturas` AS select `clientes`.`dni` AS `dni`,`clientes`.`nombre` AS `nombre`,`clientes`.`direccion` AS `direccion`,`facturas`.`identificador` AS `identificador`,`facturas`.`id_cliente` AS `id_cliente`,`facturas`.`importe` AS `importe` from (`clientes` join `facturas`) where (`clientes`.`dni` = `facturas`.`id_cliente`);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
