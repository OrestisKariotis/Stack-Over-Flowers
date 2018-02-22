CREATE TABLE kidspiration.PendingEvents (
  `event_id`      INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `provider_id`   INT(10) UNSIGNED NOT NULL,
  `title`         VARCHAR(45) NOT NULL,
  `date`          VARCHAR(45) NOT NULL,   /* probably date */
  `starting_time` VARCHAR(45) NOT NULL,
  `place`         VARCHAR(45) NOT NULL,
  `type`          VARCHAR(45) NOT NULL,
  `ticket_cost`   INT UNSIGNED NOT NULL,
  `initial_ticketsNumber` INT UNSIGNED NOT NULL,
  `lowestAge`     TINYINT UNSIGNED NOT NULL,
  `highestAge`    TINYINT UNSIGNED NOT NULL,
  `description`   TEXT,   /* Probably need for change */
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
  `date`          VARCHAR(45) NOT NULL,   /* probably date */
  `starting_time` VARCHAR(45) NOT NULL,
  `place`         VARCHAR(45) NOT NULL,
  `type`          VARCHAR(45) NOT NULL,
  `ticket_cost`   INT UNSIGNED NOT NULL,
  `initial_ticketsNumber` INT UNSIGNED NOT NULL,
  `available_ticketsNumber` INT UNSIGNED NOT NULL,
  `lowestAge`     TINYINT UNSIGNED NOT NULL,
  `highestAge`    TINYINT UNSIGNED NOT NULL,
  `longtitude`    DECIMAL(20, 14) NOT NULL,
  `latitude`      DECIMAL(20, 14) NOT NULL,
  `description`   TEXT,   /* Probably need for change */
  PRIMARY KEY (`event_id`),
  FOREIGN KEY (`provider_id`) REFERENCES kidspiration.Providers(`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) AUTO_INCREMENT = 1;

/* You have to check cascading effects!!! */
/* Probably we 'll change Update No Action, but it worked when i inserted events with no such provider_id */
/* Isws na kanoume catch to error! */

INSERT INTO kidspiration.CurrentEvents(provider_id, title, date, starting_time, place, type, ticket_cost, initial_ticketsNumber, available_ticketsNumber, lowestAge, highestAge, longtitude, latitude, description) VALUES(1, "FOOTBALL GAME", "22-FEB-2018", "21:00", "Vironas, Damaria", "Sports", 50, 10, 10, 20, 25, 37.97864720247794,23.78350140530576, "A great night for football!"),
  (3, "VAN GOGH ALIVE", "3-MARCH-2018", "12:00", "Megaro Mousikis", "Art", 200, 50, 50, 12, 90, 39.974720247794,24.783540530576, "Live the myth!"), (2, "BASKETBALL GAME", "28-FEB-2018", "11:00", "Vironas, Nekrotafeio", "Sports", 50, 10, 10, 20, 25, 37.978620247794,23.783501430576, "A great night for basketball!");