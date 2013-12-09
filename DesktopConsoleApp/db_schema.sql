drop database if exists battlegame_db;
create database battlegame_db;
grant all privileges on *.* to victor@'localhost' identified by 'local';
use battlegame_db;
create table units (id integer unsigned not null primary key auto_increment, name varchar (50) not null);

insert into units values (null, 'heavytank');
insert into units values (null, 'ship');
insert into units values (null, 'troops');
insert into units values (null, 'chopper');
insert into units values (null, 'lighttank');

select * from units;

