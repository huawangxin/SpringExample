-- CREATE DATABASE `demo` /*!40100 COLLATE 'utf8_general_ci' */
DROP TABLE users;
CREATE TABLE `Users` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50)  NOT NULL unique ,
	`pwd` VARCHAR(50) NULL ,
	`phone` VARCHAR(50) NULL ,
	PRIMARY KEY (`id`)
);

insert into users (name, pwd, phone) values ('Tom', '123', '110');
insert into users (name, pwd, phone) values ('Jerry', 'abc', '119');
insert into users (name, pwd, phone) values ('Andy', '456', '112');
--  select * from users;

