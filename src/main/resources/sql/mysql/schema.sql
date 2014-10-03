drop table if exists ctb_task;
drop table if exists ctb_user;

create table ctb_task (
	id bigint auto_increment,
	title varchar(128) not null,
	description varchar(255),
	user_id bigint not null,
    primary key (id)
) engine=InnoDB;

create table ctb_user (
	id bigint auto_increment,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64) not null,
	roles varchar(255) not null,
	register_date timestamp not null default 0,
	primary key (id)
) engine=InnoDB;

CREATE TABLE `body_part_disease` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `body_part_type` varchar(20) NOT NULL,
  `body_part` varchar(20) NOT NULL,
  `body_part_url` varchar(255) NOT NULL,
  `disease` varchar(100) NOT NULL,
  `disease_url` varchar(255) NOT NULL,
  `from_site` varchar(20) NOT NULL,
  `create_at` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;