CREATE TABLE IF NOT EXISTS `redesocialdb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `last_name` VARCHAR(150) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `uuid` VARCHAR(50) NOT NULL,
  `birthdate` DATE NOT NULL,
  `created_on` DATETIME NOT NULL,
  `updated_on` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `redesocialdb`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `ddd_cell` INT NULL DEFAULT NULL,
  `home_phone` INT NULL DEFAULT NULL,
  `cell_phone` INT NULL DEFAULT NULL,
  `ddd_home` INT NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  `email` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_phone_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_phone_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `redesocialdb`.`work` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `company` VARCHAR(150) NOT NULL,
  `role` VARCHAR(100) NULL DEFAULT NULL,
  `city` VARCHAR(150) NULL DEFAULT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  `active` BIT(1) NULL DEFAULT b'1',
  `start` DATE NULL DEFAULT NULL,
  `end` DATE NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_work_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_work_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `redesocialdb`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `public_place` VARCHAR(150) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(150) NOT NULL,
  `district` VARCHAR(150) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_address_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `redesocialdb`.`collage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `institution` VARCHAR(150) NOT NULL,
  `start` DATETIME NOT NULL,
  `end` DATETIME NOT NULL,
  `formed` BIT(1) NULL DEFAULT b'0',
  `description` LONGTEXT NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_collage_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_collage_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `redesocialdb`.`publication` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `sharing` INT NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  `created_on` DATE NOT NULL,
  `updated_on` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_publication_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_publication_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `redesocialdb`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `message` LONGTEXT NOT NULL,
  `publication_id` INT NOT NULL,
  `comment_id` INT NULL,
  `created_on` DATETIME NOT NULL,
  `updated_on` DATETIME NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_publication1_idx` (`publication_id` ASC) VISIBLE,
  INDEX `fk_comment_comment1_idx` (`comment_id` ASC) VISIBLE,
  INDEX `fk_comment_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_publication1`
    FOREIGN KEY (`publication_id`)
    REFERENCES `redesocialdb`.`publication` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_comment1`
    FOREIGN KEY (`comment_id`)
    REFERENCES `redesocialdb`.`comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `redesocialdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `redesocialdb`.`like` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(50) NOT NULL,
  `like` INT NULL DEFAULT NULL,
  `love` INT NULL DEFAULT NULL,
  `haha` INT NULL DEFAULT NULL,
  `sad` INT NULL DEFAULT NULL,
  `anger` INT NULL DEFAULT NULL,
  `publication_id1` INT NOT NULL,
  `comment_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_like_publication2_idx` (`publication_id1` ASC) VISIBLE,
  INDEX `fk_like_comment1_idx` (`comment_id` ASC) VISIBLE,
  CONSTRAINT `fk_like_publication2`
    FOREIGN KEY (`publication_id1`)
    REFERENCES `redesocialdb`.`publication` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_comment1`
    FOREIGN KEY (`comment_id`)
    REFERENCES `redesocialdb`.`comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `redesocialdb`.`file` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` BINARY(16) NOT NULL,
  `publication_id` INT NOT NULL,
  `name` VARCHAR(150) NULL DEFAULT NULL,
  `meta_data` JSON NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_file_publication1_idx` (`publication_id` ASC) VISIBLE,
  CONSTRAINT `fk_file_publication1`
    FOREIGN KEY (`publication_id`)
    REFERENCES `redesocialdb`.`publication` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

