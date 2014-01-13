/**
* localhost configuration for user.
*/
drop database if exists thebattlegame_web;
create database thebattlegame_web;
grant all privileges on thebattlegame_web.* to tbg_root@'localhost' identified by 'root';
connect thebattlegame_web;

DROP TABLE IF EXISTS units;

CREATE TABLE units(
    unit_id integer unsigned not null primary key AUTO_INCREMENT,
    unit_name varchar(100) not null,
    unit_health integer unsigned not null,
    unit_speed integer unsigned not null,
    unit_damage integer unsigned not null,
    unit_accuracy integer unsigned not null,
    unit_defense integer unsigned not null,
    unit_type integer unsigned not null default 0
)ENGINE=InnoDB;

insert into units (unit_name,unit_type,unit_health,unit_speed,unit_damage,unit_accuracy, unit_defense) 
values 

('Antiaircraft',0,100,150,70,10,50),
('HeavyTank',0,100,150,20,10,50),
('QuickTank',0,100,150,40,10,50),
('LightTank',0,100,150,10,10,50),
('Troop',0,100,150,10,10,50),
('Turret',0,100,150,20,10,50),

('Ship',1,100,150,50,10,50),
('Aircraft Carrier',1,100,150,20,10,50),
('Assault Ship',1,100,150,20,10,50),
('Destroyer',1,100,150,90,10,50),
('Submarine',1,100,150,50,10,50),

('Airplane',2,100,150,50,10,50),
('Apache Chopper',2,100,150,20,10,50),
('Biplaned',2,100,150,20,10,50),
('SingleEngine',2,100,150,10,10,50),
('Jet and rocket',2,100,150,90,10,50),
('Bomber',2,100,150,70,10,50);


DROP TABLE IF EXISTS battlefield;

CREATE TABLE battlefield(
	battlefield_id integer unsigned not null primary key AUTO_INCREMENT,
    battlefield_name varchar(100) not null
)ENGINE=InnoDB;


insert into battlefield (battlefield_name) 
values 
('Basic'),
('Desert'),
('Coast'),
('Jungle');

create table UserConnection (userId varchar(255) not null,
    providerId varchar(255) not null,
    providerUserId varchar(255),
    rank int not null,
    displayName varchar(255),
    profileUrl varchar(512),
    imageUrl varchar(512),
    accessToken varchar(255) not null,					
    secret varchar(255),
    refreshToken varchar(255),
    expireTime bigint,
    primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

DROP TABLE IF EXISTS users;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_time` timestamp NOT NULL DEFAULT current_timestamp,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `modification_time` timestamp NOT NULL DEFAULT current_timestamp,
  `password` varchar(255),
  `role` varchar(20) NOT NULL,
  `sign_in_provider` varchar(20) NOT NULL,
  `version` bigint(20) NOT NULL DEFAULT '1.0',
  PRIMARY KEY (`id`),
  UNIQUE KEY (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
