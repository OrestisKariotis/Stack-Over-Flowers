CREATE TABLE kidspiration.Tickets (
  `ticket_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` INT(10) UNSIGNED NOT NULL,
  `event_id`  INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY(`parent_id`) REFERENCES kidspiration.Parents(`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  FOREIGN KEY (`event_id`) REFERENCES kidspiration.CurrentEvents(`event_id`) ON DELETE CASCADE  ON UPDATE NO ACTION
) AUTO_INCREMENT = 1;