DROP TABLE IF EXISTS kidspiration.Tickets;
DROP TABLE IF EXISTS kidspiration.Parents;
DROP TABLE IF EXISTS kidspiration.PendingProviders;
DROP TABLE IF EXISTS kidspiration.PendingEvents;
DROP TABLE IF EXISTS kidspiration.CurrentEvents;
DROP TABLE IF EXISTS kidspiration.Providers;


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

INSERT INTO kidspiration.Providers(username, password, firstname, lastname, email, phone, businessName, bankAccount, profit, rights_code) VALUES("manolman", "test", "Manolis", "Vardas", "mgvardas@hotmail.com", "6981913215", "ACME", "husad8773739", 0, 0),
  ("detectiveal", "test1", "Alexandra", "Vioni", "detectiveal@hotmail.com", "6940422100", "JUPI", "efg934huf3", 0, 0), ("gvoutsi", "test2", "Giannis", "Voutsinas", "gvoutsi@yahoo.gr", "6981930582", "3D", "dh4h8huih39h5", 0, 0);

INSERT INTO kidspiration.Parents(username, password, firstname, lastname, email, phone, wallet, spent_points, ban) VALUES("manolman", "test10", "Manolis", "Vardas", "mgvardas@hotmail.com", "6981913215", 1000, 0, FALSE ),
  ("detectiveal", "test11", "Alexandra", "Vioni", "detectiveal@hotmail.com", "6940422100", 2000, 0, FALSE ), ("gvoutsi", "test12", "Giannis", "Voutsinas", "gvoutsi@yahoo.gr", "6981930582", 1500, 0, FALSE );
