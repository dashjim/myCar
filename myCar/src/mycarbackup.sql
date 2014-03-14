--Junxiang:
--===========================================================================
--to export: 

--1, goto /bin 
--2, mysqldump --no-data --tables -u root -p mycar >> mycarbackup.sql
--3, import: mysql -h localhost -u root -p mydb2 < e:\mysql\mydb2.sql

--to creat db:
-- first change the mysql charset to utf8 at mysql config file -- my.ini
--===========================================================================


-- MySQL dump 10.10
--
-- Host: localhost    Database: mycar
-- ------------------------------------------------------
-- Server version	5.0.16-nt

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
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars` (
  `producer` varchar(20) default NULL,
  `id` int(11) NOT NULL auto_increment,
  `model` varchar(20) default NULL,
  `priceLevel` smallint(2) default NULL,
  `Year` date default NULL,
  `isMt` tinyint(1) NOT NULL default '0',
  `paiLiang` char(5) NOT NULL default '',
  `avgLPM` tinyint(4) default NULL,
  `hybrid` varchar(5) default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `gasrcds`
--

DROP TABLE IF EXISTS `gasrcds`;
CREATE TABLE `gasrcds` (
  `id` int(11) NOT NULL auto_increment,
  `fueledTime` datetime NOT NULL default '0000-00-00 00:00:00',
  `timeStamp` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `totalDistance` mediumint(9) default NULL,
  `lastDistance` smallint(6) default NULL,
  `fueledVolum` float NOT NULL default '0',
  `money` float NOT NULL default '0',
  `isFull` tinyint(1) default NULL,
  `LPM` float default NULL,
  `place` varchar(20) default NULL,
  `roadType` varchar(10) default NULL,
  `gasType` varchar(10) default '',
  `comment` varchar(50) default '',
  `userId` mediumint(9) NOT NULL default '0',
  `lastFueledTime` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `statistics`
--

DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics` (
  `totalDistance` mediumint(9) default NULL,
  `totalGas` float default NULL,
  `totalFee` float default NULL,
  `recordedday` smallint(6) default NULL,
  `avgGasPrice` float default NULL,
  `milesPerDay` int(11) default NULL,
  `avgLPM` float default NULL,
  `avgFee` float default NULL,
  `id` mediumint(9) NOT NULL auto_increment,
  `userId` mediumint(9) NOT NULL default '0',
  `timestamp` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `fueledTime` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `name` varchar(16) default NULL,
  `driveYear` varchar(2) default NULL,
  `pwd` char(16) default NULL,
  `email` varchar(20) default NULL,
  `carID` int(11) NOT NULL default '0',
  `img` varchar(20) default NULL,
  `createTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `level` char(1) default NULL,
  `id` int(11) NOT NULL auto_increment,
  `loginTimes` int(11) default NULL,
  `lastTimeLogin` datetime default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

