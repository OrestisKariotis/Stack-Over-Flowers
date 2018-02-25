CREATE TABLE kidspiration.Tickets (
  `ticket_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` INT(10) UNSIGNED NOT NULL,
  `event_id`  INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY(`parent_id`) REFERENCES kidspiration.Parents(`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  FOREIGN KEY (`event_id`) REFERENCES kidspiration.CurrentEvents(`event_id`) ON DELETE CASCADE  ON UPDATE NO ACTION
) AUTO_INCREMENT = 1;

CREATE TABLE kidspiration.OldTickets (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ticket_id` INT(10) UNSIGNED NOT NULL,
  `parent_id` INT(10) UNSIGNED NOT NULL,
  `event_id`  INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`ticket_id`) REFERENCES kidspiration.Tickets(`ticket_id`) ON DELETE NO ACTION ON UPDATE NO ACTION, /* maybe is not needed */
  FOREIGN KEY (`parent_id`) REFERENCES kidspiration.Parents(`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  FOREIGN KEY (`event_id`) REFERENCES kidspiration.CurrentEvents(`event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) AUTO_INCREMENT = 1;

/* Check foreign key constraints */


/*SELECT sub.ticket_id, sub.parent_id, sub.event_id, CurrentEvents.title, Providers.businessName, CurrentEvents.date, CurrentEvents.ticket_cost
FROM (((SELECT *
        FROM Tickets
        WHERE Tickets.parent_id = ?) sub
INNER JOIN CurrentEvents ON sub.event_id = CurrentEvents.event_id)
INNER JOIN Providers ON CurrentEvents.provider_id = Providers.id) */

