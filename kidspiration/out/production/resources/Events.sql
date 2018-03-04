DROP TABLE IF EXISTS kidspiration.OldTickets;
DROP TABLE IF EXISTS kidspiration.Tickets;
DROP TABLE IF EXISTS kidspiration.PendingEvents;
DROP TABLE IF EXISTS kidspiration.CurrentEvents;
DROP TABLE IF EXISTS kidspiration.OldEvents;

CREATE TABLE kidspiration.PendingEvents (
  `event_id`      INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `provider_id`   INT(10) UNSIGNED NOT NULL,
  `title`         VARCHAR(45) NOT NULL,
  `date`          DATE NOT NULL,   /* CHANGED FROM VARCHAR */
  `starting_time` VARCHAR(45) NOT NULL,
  `place`         VARCHAR(45) NOT NULL, /* Place == Address */
  `type`          VARCHAR(45) NOT NULL,
  `ticket_cost`   INT UNSIGNED NOT NULL,
  `initial_ticketsNumber` INT UNSIGNED NOT NULL,
  `lowestAge`     TINYINT UNSIGNED NOT NULL,
  `highestAge`    TINYINT UNSIGNED NOT NULL,
  `description`   TEXT,   /* Probably need for change */
  `numOfPhotos`  INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`event_id`),
  FOREIGN KEY (`provider_id`) REFERENCES kidspiration.Providers(`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) AUTO_INCREMENT = 1;

/* You have to check cascading effects!!! */
/* Probably we 'll change Update No Action, but it worked when i inserted events with no such provider_id */
/* Isws na kanoume catch to error! */

CREATE TABLE kidspiration.CurrentEvents (
  `event_id`      INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `provider_id`   INT(10) UNSIGNED NOT NULL,
  `title`         VARCHAR(45) NOT NULL,
  `date`          DATE NOT NULL,    /* CHANGED FROM VARCHAR */
  `starting_time` VARCHAR(45) NOT NULL,
  `place`         VARCHAR(45) NOT NULL,
  `type`          VARCHAR(45) NOT NULL,
  `ticket_cost`   INT UNSIGNED NOT NULL,
  `initial_ticketsNumber` INT UNSIGNED NOT NULL,
  `available_ticketsNumber` INT UNSIGNED NOT NULL,
  `lowestAge`     TINYINT UNSIGNED NOT NULL,
  `highestAge`    TINYINT UNSIGNED NOT NULL,
  `latitude`      DECIMAL(20, 14) NOT NULL,
  `longitude`    DECIMAL(20, 14) NOT NULL,
  `description`   TEXT,   /* Probably need for change */
  `numOfPhotos` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`event_id`),
  FOREIGN KEY (`provider_id`) REFERENCES kidspiration.Providers(`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) AUTO_INCREMENT = 1;

/* You have to check cascading effects!!! */
/* Probably we 'll change Update No Action, but it worked when i inserted events with no such provider_id */
/* Isws na kanoume catch to error! */

CREATE TABLE kidspiration.OldEvents (    /* ADDED */
  `event_id`      INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `provider_id`   INT(10) UNSIGNED NOT NULL,
  `title`         VARCHAR(45) NOT NULL,
  `date`          DATE NOT NULL,
  `starting_time` VARCHAR(45) NOT NULL,
  `place`         VARCHAR(45) NOT NULL,
  `type`          VARCHAR(45) NOT NULL,
  `ticket_cost`   INT UNSIGNED NOT NULL,
  `initial_ticketsNumber` INT UNSIGNED NOT NULL,
  `sold_ticketsNumber` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`event_id`),
  FOREIGN KEY (`provider_id`) REFERENCES kidspiration.Providers(`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) AUTO_INCREMENT = 1;

/* You have to check cascading effects!!! */
/* Probably we 'll change Update No Action, but it worked when i inserted events with no such provider_id */
/* Isws na kanoume catch to error! */


/* ADDED */
/* Info Insertion */
INSERT INTO kidspiration.CurrentEvents(provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, available_ticketsNumber, lowestAge, highestAge, latitude, longitude, description, numOfPhotos) VALUES(1, "FOOTBALL GAME", curdate(), "21:00", "Vironas, Damaria", "Sports", 50, 10, 5, 20, 25, 37.97864720247794,23.78350140530576, "A great night for football!", 4),
  (3, "VAN GOGH ALIVE", STR_TO_DATE('1-01-2018', '%d-%m-%Y'), "12:00", "Megaro Mousikis", "Art", 200, 50, 50, 12, 90, 39.974720247794,24.783540530576, "Live the myth!", 2), (2, "BASKETBALL GAME", curdate(), "11:00", "Vironas, Nekrotafeio", "Sports", 50, 10, 9, 20, 25, 37.978620247794,23.783501430576, "A great night for basketball!", 5);


/* Failure due to id conflict */

INSERT INTO kidspiration.OldEvents(provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, sold_ticketsNumber) VALUES(1, "Handball GAME", STR_TO_DATE('27-02-2017', '%d-%m-%Y'), "21:00", "Vironas, Damaria", "Sports", 50, 10, 5),
  (3, "VAN GOGH DEAD", STR_TO_DATE('1-03-2017', '%d-%m-%Y'), "12:00", "Megaro Mousikis", "Art", 200, 50, 50), (2, "Volleyball GAME", STR_TO_DATE('28-02-2017', '%d-%m-%Y'), "11:00", "Vironas, Nekrotafeio", "Sports", 50, 10, 9);

/* Adding default pending events because I'm bored of inserting manually every time. */
INSERT INTO kidspiration.PendingEvents(provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, lowestAge, highestAge, description, numOfPhotos) VALUES(1, "GeoTesting", curdate(), "10:34", "Συβρισσαριου 18 Βυρωνας", "Art", 10, 2, 19, 40, "Testing geocoding of coordinates during pending event's acceptance.", 2)