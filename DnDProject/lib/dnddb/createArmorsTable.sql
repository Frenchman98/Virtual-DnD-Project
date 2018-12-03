create database if not exists dnddb;
use dnddb;
drop table if exists armors;
create table armors (
		id int not null auto_increment,
		 name varchar(50),
		 armourType varchar(10),
		 cost int,
		 unit varchar(5),
		 encumbrance int,
		 locationCovered varchar(25),
		 ap int,
		 availability varchar(10), 
		 primary key (id)
	 );
 
insert into armors values (default, 'Leather Skullcap', 'Leather', 3, 'gc', 10, 'Head', 1, 'Common'),

(default, 'Leather Jerkin', 'Leather', 6, 'gc', 40, 'Body', 1, 'Common'),

(default, 'Leather Jack', 'Leather', 12, 'gc', 50, 'Body,Arms', 1, 'Common'),

(default, 'Leather Leggings', 'Leather', 10, 'gc', 20, 'Legs', 1, 'Common'),

(default, 'Full Leather Armour', 'Leather', 25, 'gc', 80, 'All', 1, 'Average'),

(default, 'Mail Coif', 'Chain', 20, 'gc', 30, 'Head', 2, 'Average'),

(default, 'Mail Shirt', 'Chain', 60, 'gc', 60, 'Body', 2, 'Average'),

(default, 'Sleeved Mail Shirt', 'Chain', 95, 'gc', 80, 'Body,Arms', 2, 'Average'),

(default, 'Mail Coat', 'Chain', 75, 'gc', 80, 'Body,Legs', 2, 'Average'),

(default, 'Sleeved Mail Coat', 'Chain', 130, 'gc', 100, 'Body,Arms,Legs', 2, 'Average'),

(default, 'Mail Leggings', 'Chain', 20, 'gc', 40, 'Legs', 2, 'Scarce'),

(default, 'Full Mail Armour', 'Chain', 170, 'gc', 210, 'All', 2, 'Scarce'),

(default, 'Helmet', 'Plate', 30, 'gc', 40, 'Head', 2, 'Scarce'),

(default, 'Breastplate', 'Plate', 70, 'gc', 75, 'Body', 2, 'Scarce'),

(default, 'Plate Bracers', 'Plate', 60, 'gc', 30, 'Arms', 2, 'Scarce'),

(default, 'Plate Leggings', 'Plate', 70, 'gc', 40, 'Legs', 2, 'Scarce'),

(default, 'Full Plate Armour', 'Plate', 400, 'gc', 395, 'All', 5, 'Rare');
