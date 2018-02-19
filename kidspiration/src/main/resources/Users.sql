DROP TABLE kidspiration.Parents;
DROP TABLE kidspiration.PendingProviders;
CREATE TABLE kidspiration.Parents (
  `id`        INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username`  VARCHAR(45) NOT NULL,
  `password`  VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname`  VARCHAR(45) NOT NULL,
  `email`     VARCHAR(45) NOT NULL,
  `phone`     VARCHAR(45) NOT NULL,
  `available_points` INT(10) UNSIGNED NOT NULL,
  `spent_points`  INT(10) UNSIGNED NOT NULL,
  `ban` BOOl NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT = 1;

CREATE TABLE kidspiration.PendingProviders (
  `id`        INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username`  VARCHAR(45) NOT NULL,
  `password`  VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname`  VARCHAR(45) NOT NULL,
  `email`     VARCHAR(45) NOT NULL,
  `phone`     VARCHAR(45) NOT NULL,
  `businessName` VARCHAR(45) NOT NULL,
  `bankAccount` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT = 1;




