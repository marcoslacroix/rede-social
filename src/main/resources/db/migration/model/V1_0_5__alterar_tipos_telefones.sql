ALTER TABLE `redesocialdb`.`phone`
CHANGE COLUMN `ddd` `ddd` VARCHAR(20) NULL DEFAULT NULL ,
CHANGE COLUMN `phone` `phone` VARCHAR(20) NULL DEFAULT NULL ,
CHANGE COLUMN `ddi_phone` `ddi_phone` VARCHAR(20) NULL DEFAULT NULL ,
CHANGE COLUMN `home_phone` `home_phone` VARCHAR(20) NULL DEFAULT NULL ,
CHANGE COLUMN `ddd_home_phone` `ddd_home_phone` VARCHAR(20) NULL DEFAULT NULL ,
CHANGE COLUMN `ddi_home_phone` `ddi_home_phone` VARCHAR(20) NULL DEFAULT NULL ;
