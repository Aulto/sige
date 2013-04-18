/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : sige

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2013-04-18 10:26:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `atividades`
-- ----------------------------
DROP TABLE IF EXISTS `atividades`;
CREATE TABLE `atividades` (
  `id` int(11) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `materiaId` int(11) NOT NULL,
  `perguntas` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of atividades
-- ----------------------------

-- ----------------------------
-- Table structure for `materias`
-- ----------------------------
DROP TABLE IF EXISTS `materias`;
CREATE TABLE `materias` (
  `id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `idProfessor` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of materias
-- ----------------------------

-- ----------------------------
-- Table structure for `notas`
-- ----------------------------
DROP TABLE IF EXISTS `notas`;
CREATE TABLE `notas` (
  `id` int(11) NOT NULL,
  `alunoId` int(11) NOT NULL,
  `materiaId` int(11) NOT NULL,
  `nota1` double DEFAULT NULL,
  `nota2` double DEFAULT NULL,
  `nota3` double DEFAULT NULL,
  `nota4` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of notas
-- ----------------------------

-- ----------------------------
-- Table structure for `pessoas`
-- ----------------------------
DROP TABLE IF EXISTS `pessoas`;
CREATE TABLE `pessoas` (
  `id` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `sexo` varchar(15) NOT NULL,
  `estadoCivil` varchar(15) NOT NULL,
  `dataNascimento` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `celular` varchar(16) NOT NULL,
  `endereco` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;