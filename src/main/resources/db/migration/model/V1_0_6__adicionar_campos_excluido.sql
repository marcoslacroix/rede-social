ALTER TABLE `redesocialdb`.`address`
ADD COLUMN `excluded` BIT(1) NULL DEFAULT b'0' AFTER `user_id`;

ALTER TABLE `redesocialdb`.`collage`
ADD COLUMN `excluded` BIT(1) NULL DEFAULT b'0' AFTER `user_id`;

ALTER TABLE `redesocialdb`.`contact`
ADD COLUMN `excluded` BIT(1) NULL DEFAULT b'0' AFTER `email`;

ALTER TABLE `redesocialdb`.`email`
CHANGE COLUMN `excluido` `excluded` BIT(1) NOT NULL DEFAULT b'0' ;

ALTER TABLE `redesocialdb`.`phone`
ADD COLUMN `excluded` BIT(1) NULL DEFAULT b'0' AFTER `ddi_home_phone`;

ALTER TABLE `redesocialdb`.`work`
ADD COLUMN `excluded` BIT(1) NULL DEFAULT b'0' AFTER `user_id`;

