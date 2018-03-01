DROP TABLE IF EXISTS kidspiration.OldTickets;
DROP TABLE IF EXISTS kidspiration.Tickets;

CREATE TABLE kidspiration.Tickets (
  `ticket_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` INT(10) UNSIGNED NOT NULL,
  `event_id`  INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY(`parent_id`) REFERENCES kidspiration.Parents(`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  FOREIGN KEY (`event_id`) REFERENCES kidspiration.CurrentEvents(`event_id`) ON DELETE CASCADE  ON UPDATE NO ACTION
) AUTO_INCREMENT = 1;

CREATE TABLE kidspiration.OldTickets (   /* ADDED */
  `ticket_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` INT(10) UNSIGNED NOT NULL,
  `event_id`  INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY (`parent_id`) REFERENCES kidspiration.Parents(`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  FOREIGN KEY (`event_id`) REFERENCES kidspiration.OldEvents(`event_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) AUTO_INCREMENT = 1;

/* Check foreign key constraints */

/* ADDED */
/* testing tickets insertion */
INSERT INTO kidspiration.Tickets(parent_id, event_id) VALUES (1, 1), (1, 2), (2, 2), (2, 3);

INSERT INTO kidspiration.OldTickets(parent_id, event_id) VALUES (1, 2), (1, 3), (2, 2), (2, 3);

/*SELECT sub.ticket_id, sub.parent_id, sub.event_id, CurrentEvents.title, Providers.businessName, CurrentEvents.date, CurrentEvents.ticket_cost
FROM (((SELECT *
        FROM Tickets
        WHERE Tickets.parent_id = ?) sub
INNER JOIN CurrentEvents ON sub.event_id = CurrentEvents.event_id)
INNER JOIN Providers ON CurrentEvents.provider_id = Providers.id) */

