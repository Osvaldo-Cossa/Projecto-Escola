-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.5-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for escola
CREATE DATABASE IF NOT EXISTS `escola` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `escola`;

-- Dumping structure for table escola.avaliacao
CREATE TABLE IF NOT EXISTS `avaliacao` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nomeAvaliacao` mediumtext NOT NULL,
  `data` mediumtext NOT NULL,
  `codigoDisciplina` int(11) NOT NULL,
  `codigoProfessor` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `codigoDisciplina` (`codigoDisciplina`),
  KEY `codigoProfessor` (`codigoProfessor`),
  CONSTRAINT `avaliacao_ibfk_2` FOREIGN KEY (`codigoDisciplina`) REFERENCES `disciplina` (`codigo`),
  CONSTRAINT `avaliacao_ibfk_3` FOREIGN KEY (`codigoProfessor`) REFERENCES `professor` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table escola.disciplina
CREATE TABLE IF NOT EXISTS `disciplina` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nomeDisciplina` mediumtext DEFAULT NULL,
  `horasPorSemana` time DEFAULT NULL,
  `creditos` int(11) DEFAULT NULL,
  `codigoProfessor` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `nomeDisciplina` (`nomeDisciplina`) USING HASH,
  KEY `codigoProfessor` (`codigoProfessor`),
  CONSTRAINT `disciplina_ibfk_1` FOREIGN KEY (`codigoProfessor`) REFERENCES `professor` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table escola.estudante
CREATE TABLE IF NOT EXISTS `estudante` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` mediumtext DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `anoIngresso` year(4) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table escola.nota
CREATE TABLE IF NOT EXISTS `nota` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nota` double NOT NULL,
  `nomeEstudante` mediumtext NOT NULL,
  `codigoDisciplina` int(11) NOT NULL,
  `codigoProfessor` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `codigoDisciplina` (`codigoDisciplina`),
  KEY `codigoProfessor` (`codigoProfessor`),
  CONSTRAINT `nota_ibfk_1` FOREIGN KEY (`codigoDisciplina`) REFERENCES `disciplina` (`codigo`),
  CONSTRAINT `nota_ibfk_2` FOREIGN KEY (`codigoProfessor`) REFERENCES `professor` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table escola.professor
CREATE TABLE IF NOT EXISTS `professor` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` mediumtext DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `nivelAcademico` mediumtext DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
