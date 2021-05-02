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
  `ddd` INT NOT NULL,
  `phone` INT NOT NULL,
  `user_id` INT NOT NULL,
  `ddi` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_phone_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_phone_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `redesocialdb`.`home_phone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `ddd` INT NOT NULL,
  `ddi` INT NOT NULL,
  `home_phone` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_home_phone_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_home_phone_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;