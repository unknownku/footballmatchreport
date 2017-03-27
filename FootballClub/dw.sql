DROP TABLE IF EXISTS `fact_match`;
CREATE TABLE `fact_match` (
   `competitionKy` INT(3) NOT NULL ,
   `dateKy` DATE NOT NULL,
   `opponentKy` INT(3) NOT NULL,
	`tacticKy` INT(2) NOT NULL,
	`playerKy` INT(3) NOT NULL,
    
    `fullTimeGoals` INT(3) NOT NULL,
    `halfTimeGoals` INT(3) NOT NULL,
    `shot` INT(3) NOT NULL,
    `onTarget` INT(3) NOT NULL,
    `offTarget` INT(3) NOT NULL,
    `cornner` INT(3) NOT NULL,
    `foul` INT(3) NOT NULL,
    `yellowCard` INT(3) NOT NULL,
    `redCard` INT(3) NOT NULL
);


DROP TABLE IF EXISTS `dim_competition`;
CREATE TABLE `dim_competition` (
  `competitionKy` INT(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `competiotionName` VARCHAR(20) NOT NULL,
  `seasonName` VARCHAR(10) NOT NULL,
  `seasonStartYear` INT(4) NOT NULL,
  `seasonEndYear` INT(4) NOT NULL,
  PRIMARY KEY (`competitionKy`)
);

DROP TABLE IF EXISTS `dim_tactic`;
CREATE TABLE `dim_tactic` (
  `tacticKy` INT(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tacticName` VARCHAR(10) NOT NULL,
  `tacticInstruction` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`tacticKy`)
);

DROP TABLE IF EXISTS `dim_date`;
CREATE TABLE `dim_date` (
-- `dateKy` INT(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `year` INT(4) NOT NULL,
  `month` INT(4) NOT NULL,
  `day` INT(4) NOT NULL,
  `season` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`date`)
);

DROP TABLE IF EXISTS `dim_opponent`;
CREATE TABLE `dim_opponent` (
  `opponentKy` INT(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `opponentLongName` VARCHAR(50) NOT NULL,
  `opponentShortName` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`opponentKy`)
);

DROP TABLE IF EXISTS `dim_player`;
CREATE TABLE `dim_player` (
  `playerKy` INT(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `nationality` VARCHAR(20) NOT NULL,
  `value` DOUBLE NOT NULL,
  `height` DOUBLE NOT NULL,
  `weight` DOUBLE NOT NULL,
  PRIMARY KEY (`playerKy`)
);
