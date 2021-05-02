ALTER TABLE `redesocialdb`.`like`
DROP FOREIGN KEY `fk_like_comment1`,
DROP FOREIGN KEY `fk_like_publication2`;
ALTER TABLE `redesocialdb`.`like`
CHANGE COLUMN `publication_id1` `publication_id1` INT NULL ,
CHANGE COLUMN `comment_id` `comment_id` INT NULL ;
ALTER TABLE `redesocialdb`.`like`
ADD CONSTRAINT `fk_like_comment1`
  FOREIGN KEY (`comment_id`)
  REFERENCES `redesocialdb`.`comment` (`id`),
ADD CONSTRAINT `fk_like_publication2`
  FOREIGN KEY (`publication_id1`)
  REFERENCES `redesocialdb`.`publication` (`id`);
