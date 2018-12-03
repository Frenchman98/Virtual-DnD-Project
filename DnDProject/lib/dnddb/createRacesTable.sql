create database if not exists dnddb;
use dnddb;
drop table if exists races;
create table races (
		id int not null auto_increment,
		name varchar(25) not null,
		primary key (id)
	);
insert into races values (1, 'Dwarfs');
insert into races values (2, 'Elves');
insert into races values (3, 'Halflings');
insert into races values (4, 'Humans');