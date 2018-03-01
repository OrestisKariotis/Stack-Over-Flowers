DROP TABLE IF EXISTS kidspiration.OldTickets;
DROP TABLE IF EXISTS kidspiration.Tickets;
DROP TABLE IF EXISTS kidspiration.Parents;
DROP TABLE IF EXISTS kidspiration.PendingProviders;
DROP TABLE IF EXISTS kidspiration.PendingEvents;
DROP TABLE IF EXISTS kidspiration.OldEvents;      /* ADDED */
DROP TABLE IF EXISTS kidspiration.CurrentEvents;
DROP TABLE IF EXISTS kidspiration.Providers;

DROP TABLE IF EXISTS kidspiration.MonthReferences; /* ADDED */

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
  `profit` DOUBLE NOT NULL,      /* CHANGED FROM INT*/
  `rights_code` TINYINT NOT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT = 1;

CREATE TABLE kidspiration.MonthReferences(     /* ADDED */
  `month` TINYINT UNSIGNED,
  `earnings` INT,
  `expenses` DOUBLE,
  `profit` DOUBLE,
  PRIMARY KEY (`month`)     /*  WASN'T INCLUDED */
);

INSERT INTO kidspiration.Providers(username, password, firstname, lastname, email, phone, businessName, bankAccount, profit, rights_code) VALUES("manolman", "test", "Manolis", "Vardas", "mgvardas@hotmail.com", "6981913215", "ACME", "husad8773739", 0, 0),
  ("detectiveal", "test1", "Alexandra", "Vioni", "detectiveal@hotmail.com", "6940422100", "JUPI", "efg934huf3", 0, 0), ("gvoutsi", "test2", "Giannis", "Voutsinas", "gvoutsi@yahoo.gr", "6981930582", "3D", "dh4h8huih39h5", 0, 0);

INSERT INTO kidspiration.Parents(username, password, firstname, lastname, email, phone, wallet, spent_points, ban) VALUES("manolman", "test10", "Manolis", "Vardas", "mgvardas@hotmail.com", "6981913215", 1000, 0, FALSE ),
  ("detectiveal", "test11", "Alexandra", "Vioni", "detectiveal@hotmail.com", "6940422100", 2000, 0, FALSE ), ("gvoutsi", "test12", "Giannis", "Voutsinas", "gvoutsi@yahoo.gr", "6981930582", 1500, 0, FALSE );


INSERT INTO kidspiration.MonthReferences(month, earnings, expenses, profit) VALUES (0, 0, 0, 0), (1, 0, 0, 0), (2, 0, 0, 0), (3, 0, 0, 0), (4, 0, 0, 0), (5, 0, 0, 0), (6, 0, 0, 0), (7, 0, 0, 0), (8, 0, 0, 0), (9, 0, 0, 0), (10, 0, 0, 0), (11, 0, 0, 0);

/* ADDED, WILL BE CHANGED BY GIANNIS - ORESTIS */