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
    battlefield_name varchar(100) not null
    battlefield_id integer unsigned not null primary key AUTO_INCREMENT,
    
)ENGINE=InnoDB;


insert into battlefield (battlefield_name, battlefield_id) 
values 

('Basic',1),
('Desert',2),
('Coast',3),
('Jungle',4),
('Coast',5);