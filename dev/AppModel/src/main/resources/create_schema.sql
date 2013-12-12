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
    unit_type integer unsigned not null default 0
)ENGINE=InnoDB;

insert into units (unit_name,unit_type,unit_health,unit_speed,unit_damage,unit_accuracy) 
values 

('Antiaircraft',0,100,150,100,10),
('HeavyTank',0,100,150,100,10),
('QuickTank',0,100,150,100,10),
('LightTank',0,100,150,100,10),
('Troop',0,100,150,100,10),
('Turret',0,100,150,100,10),

('Ship',1,100,150,100,10),
('Aircraft Carrier',1,100,150,100,10),
('Assault Ship',1,100,150,100,10),
('Destroyer',1,100,150,100,10),
('Submarine',1,100,150,100,10),

('Airplane',2,100,150,100,10),
('Apache Chopper',2,100,150,100,10),
('Biplaned',2,100,150,100,10),
('SingleEngine',2,100,150,100,10),
('Jet and rocket',2,100,150,100,10),
('Bomber',2,100,150,100,10);
