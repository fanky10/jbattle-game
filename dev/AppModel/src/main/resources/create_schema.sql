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
