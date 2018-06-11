-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 11 Juin 2018 à 11:33
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `wemanity_entretient_bdd`
--
CREATE DATABASE IF NOT EXISTS `wemanity_entretient_bdd` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `wemanity_entretient_bdd`;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `admin`
--

INSERT INTO `admin` (`id`, `nom`, `prenom`, `username`, `password`, `email`, `tel`) VALUES
(1, 'omrani', 'mohamedamine', 'admin', 'admin', 'omranimohamedamine@gmail.com', 52939593);

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE IF NOT EXISTS `candidat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `datenaissance` date NOT NULL,
  `pays` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `activite` varchar(50) NOT NULL,
  `etat` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `candidat`
--

INSERT INTO `candidat` (`id`, `nom`, `prenom`, `datenaissance`, `pays`, `ville`, `activite`, `etat`, `tel`, `mail`) VALUES
(1, 'OMRANI', 'Mohamed Amine', '1989-11-23', 'Tunisie', 'Monastir', 'Informatique', 'Celibataire', '52939593', 'omranimohamedamine@gmail.com'),
(2, 'Slavia', 'Rimka', '1992-06-13', 'France', 'Paris', 'Informatique', 'Marié', '0033232222', 'test@gmail.com'),
(3, 'Monrau', 'Jack', '2018-06-18', 'Belgique', 'gent', 'Infomatique', 'Marié', '003424242', 'jack@gmail.com'),
(4, 'ORAN', 'SIHAM', '1991-06-08', 'Maroc', 'Tanja', 'Infomatique', 'Celibataire', '002174356433', 'siham@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `entretient`
--

CREATE TABLE IF NOT EXISTS `entretient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `candidat` int(11) NOT NULL,
  `date` date NOT NULL,
  `heure` varchar(20) NOT NULL,
  `description` varchar(300) NOT NULL,
  `qualite` varchar(300) NOT NULL,
  `defaut` varchar(300) NOT NULL,
  `decision` varchar(300) NOT NULL,
  `note` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `candidat` (`candidat`),
  KEY `candidat_2` (`candidat`),
  KEY `candidat_3` (`candidat`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `entretient`
--

INSERT INTO `entretient` (`id`, `candidat`, `date`, `heure`, `description`, `qualite`, `defaut`, `decision`, `note`) VALUES
(1, 1, '2018-06-06', '12:00', 'test', 'test', 'test', 'test', 15),
(2, 1, '2018-06-10', '12:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'invalide', 0),
(3, 1, '2018-06-11', '12:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'invalide', 0),
(4, 2, '2018-06-12', '14:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'invalide', 0),
(5, 3, '2018-06-12', '14:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'invalide', 0),
(6, 3, '2018-06-13', '14:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'invalide', 0),
(7, 3, '2018-06-14', '14:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'invalide', 0),
(8, 2, '2018-06-14', '15:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'invalide', 0),
(9, 1, '2018-06-11', '15:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'invalide', 0),
(10, 2, '2018-06-13', '15:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'valide', 15),
(11, 2, '2018-06-12', '15:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'valide', 15),
(12, 1, '2018-06-11', '11:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'valide', 15),
(13, 4, '2018-06-11', '11:00', 'aucune description fournie', 'aucune qualité fournie', 'aucun defaut fournie', 'valide', 15);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `entretient`
--
ALTER TABLE `entretient`
  ADD CONSTRAINT `FK_Candidat_Entretient` FOREIGN KEY (`candidat`) REFERENCES `candidat` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
