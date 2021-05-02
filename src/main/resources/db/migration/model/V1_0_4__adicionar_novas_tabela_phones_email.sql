CREATE TABLE IF NOT EXISTS `redesocialdb`.`email` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(150) NOT NULL,
  `excluido` BIT(1) NOT NULL DEFAULT b'0',
  `uuid` VARCHAR(50) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_email_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_email_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `redesocialdb`.`phone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `ddd` INT NULL DEFAULT NULL,
  `phone` INT NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  `ddi_phone` INT NULL DEFAULT NULL,
  `home_phone` INT NULL DEFAULT NULL,
  `ddd_home_phone` INT NULL DEFAULT NULL,
  `ddi_home_phone` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_phone_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_phone_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;