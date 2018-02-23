DROP TABLE IF EXISTS kidspiration.Parents;
DROP TABLE IF EXISTS kidspiration.PendingProviders;
DROP TABLE IF EXISTS kidspiration.Providers;
DROP TABLE IF EXISTS kidspiration.MonthReferences;



CREATE TABLE kidspiration.Parents (
  `id`        INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username`  VARCHAR(45) NOT NULL,
  `password`  VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname`  VARCHAR(45) NOT NULL,
  `email`     VARCHAR(45) NOT NULL,
  `phone`     VARCHAR(45) NOT NULL,
  `wallet` INT(10) UNSIGNED NOT NULL,
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

CREATE TABLE kidspiration.Providers (
  `id`        INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username`  VARCHAR(45) NOT NULL,
  `password`  VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname`  VARCHAR(45) NOT NULL,
  `email`     VARCHAR(45) NOT NULL,
  `phone`     VARCHAR(45) NOT NULL,
  `businessName` VARCHAR(45) NOT NULL,
  `bankAccount` VARCHAR(45) NOT NULL,
  `profit` INT(10) NOT NULL,
  `rights_code` TINYINT NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT = 1;


CREATE TABLE kidspiration.MonthReferences (
  `month` INT ,
  `earnings` INT ,
  `expenses` DOUBLE
);


INSERT INTO kidspiration.Providers(username, password, firstname, lastname, email, phone, businessName, bankAccount, profit, rights_code) VALUES("manolman", "test", "Manolis", "Vardas", "mgvardas@hotmail.com", "6981913215", "ACME", "husad8773739", 0, 0),
  ("detectiveal", "test1", "Alexandra", "Vioni", "detectiveal@hotmail.com", "6940422100", "JUPI", "efg934huf3", 0, 0), ("gvoutsi", "test2", "Giannis", "Voutsinas", "gvoutsi@yahoo.gr", "6981930582", "3D", "dh4h8huih39h5", 0, 0);

INSERT INTO kidspiration.MonthReferences(month, earnings, expenses) VALUES (0, 0, 0), (1, 0, 0), (2, 0, 0), (3, 0, 0), (4, 0, 0), (5, 0, 0), (6, 0, 0), (7, 0, 0), (8, 0, 0), (9, 0, 0), (10, 0, 0), (11, 0, 0);