DROP SCHEMA IF EXISTS `hb-01-one-to-one-uni`;
CREATE SCHEMA `hb-01-one-to-one-uni`;

use `hb-01-one-to-one-uni`;

set FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detail`;
CREATE TABLE `instructor_detail`(
	`id` int(11) NOT NULL auto_increment,
	`youtube_channel` varchar(128) default null,
    `hobby` varchar(45) not null,
    primary key (`id`)
) ENGINE=InnoDB auto_increment=1 default charset=latin1;

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor`(
	`id` int(11) not null auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,
    `instructor_detail_id` int(11) default null,
    primary key(`id`),
    key `FK_DETAIL_idx` (`instructor_detail_id`),
    constraint `FK_DETAIL` foreign key (`instructor_detail_id`) references `instructor_detail`(`id`)
    on delete no action on update no action
) ENGINE=InnoDB auto_increment=1 default charset=latin1;

SET FOREIGN_KEY_CHECKS = 1;