ALTER TABLE `redesocialdb`.`like`
ADD COLUMN `user_id` INT NULL AFTER `comment_id`,
ADD INDEX `fk_like_user1_idx` (`user_id` ASC) INVISIBLE;
;
ALTER TABLE `redesocialdb`.`like`
ADD CONSTRAINT `fk_like_user1`
  FOREIGN KEY (`user_id`)
  REFERENCES `redesocialdb`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `redesocialdb`.`like`
DROP FOREIGN KEY `fk_like_user1`;
ALTER TABLE `redesocialdb`.`like`
CHANGE COLUMN `user_id` `user_id` INT NOT NULL ;
ALTER TABLE `redesocialdb`.`like`
ADD CONSTRAINT `fk_like_user1`
  FOREIGN KEY (`user_id`)
  REFERENCES `redesocialdb`.`user` (`id`);

ALTER TABLE `redesocialdb`.`like`
DROP FOREIGN KEY `fk_like_publication2`;
ALTER TABLE `redesocialdb`.`like`
CHANGE COLUMN `publication_id1` `publication_id` INT NULL DEFAULT NULL ;
ALTER TABLE `redesocialdb`.`like`
ADD CONSTRAINT `fk_like_publication2`
  FOREIGN KEY (`publication_id`)
  REFERENCES `redesocialdb`.`publication` (`id`);

ALTER TABLE `redesocialdb`.`user`
ADD COLUMN `activated` BIT(1) NULL DEFAULT b'1' AFTER `updated_on`;

ALTER TABLE `redesocialdb`.`user`
CHANGE COLUMN `email` `email_principal` VARCHAR(150) NOT NULL ;
