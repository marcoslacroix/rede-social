CREATE TABLE IF NOT EXISTS `redesocialdb`.`photo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `image` BLOB NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photo_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_photo_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB