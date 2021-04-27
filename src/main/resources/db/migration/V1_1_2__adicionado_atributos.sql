ALTER TABLE `redesocialdb`.`publication`
ADD COLUMN `created_on` DATE NOT NULL AFTER `user_id`,
ADD COLUMN `updated_on` DATE NULL DEFAULT NULL AFTER `created_on`;

ALTER TABLE `redesocialdb`.`user`
ADD COLUMN `created_on` DATE NOT NULL AFTER `birthdate`,
ADD COLUMN `updated_on` DATE NULL DEFAULT NULL AFTER `created_on`;
