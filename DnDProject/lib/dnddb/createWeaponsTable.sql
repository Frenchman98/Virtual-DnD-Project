create database if not exists dnddb;
use dnddb;
drop table if exists weapons;
create table weapons (
		 id int not null auto_increment,
		 name varchar(50),
		 cost int,
		 unit varchar(5),
		 encumbrance int, 
		 weaponGroup varchar(30),
		 damage varchar(10), 
		 weaponRange varchar(10), 
		 reload varchar(15), 
		 qualities varchar(50),
		 availability varchar(20),
		 requiresTwoHands boolean,
		 primary key (id)
	);
 
insert into weapons values (1, 'Buckler', 2, 'gc', 10, 'Parrying', 'SB-4', '', '',
 'Balanced, Defensive, Pummelling', 'Average', 0);
 
 insert into weapons values (2, 'Dagger', 1, 'gc', 10, 'Ordinary', 'SB-3', '', '',
 'None', 'Common', 0);
 
 insert into weapons values (3, 'Demilance (Cavalry Spear)', 20, 'gc', 75,
 'Cavalry', 'SB', '', '', 'Fast, Impact, Tiring', 'Scarce', 0);
 
 insert into weapons values (4, 'Flail', 15, 'gc', 95, 'Flail', 'SB+1', '', '',
 'Impact, Tiring', 'Scarce', 1);
 
 insert into weapons values (5, 'Foil', 18, 'gc', 40, 'Fencing', 'SB-2', '', '',
 'Fast, Precise', 'Rare', 0);
 
 insert into weapons values (6, 'Gauntlet/Knuckle-duster', 1, 'gc', 10,
 'Ordinary', 'SB-3', '', '','Pummelling', 'Common', 0);
 
 insert into weapons values (7, 'Great Weapon', 20, 'gc', 200, 'Two-Handed', 'SB',
  '', '', 'Balanced, Defensive, Pummelling', 'Average', 1);
  
 insert into weapons values (8, 'Halberd', 15, 'gc', 175, 'Two-Handed', 'SB', '', '',
 'Balanced, Defensive, Pummelling', 'Average', 1);
 
 insert into weapons values (9, 'Hand Weapon (sword etc)', 50, 'gc', 10,
 'Ordinary', 'SB', '', '','Balanced, Defensive, Pummelling', 'Average', 0);
 
 insert into weapons values (10, 'Improvised', NULL, '', 35, 'Ordinary', 'SB-4',
 '', '', 'Balanced, Defensive, Pummelling', 'Average', 0);
 
 insert into weapons values (11, 'Lance', 15, 'gc', 100, 'Cavalry', 'SB+1', '', '',
 'Balanced, Defensive, Pummelling', 'Average', 0);
 
 insert into weapons values (12, 'Main Gauche', 4,  'gc',15, 'Parrying', 'SB-3',
  '', '', 'Balanced, Defensive, Pummelling', 'Average', 0);
  
 insert into weapons values (13, 'Morning Star', 15, 'gc', 60, 'Flail', 'SB', '', '',
 'Balanced, Defensive, Pummelling', 'Average', 0);
 
 insert into weapons values (14, 'Quarter Staff', 3, 's', 50, 'Ordinary', 'SB-2',
  '', '', 'Balanced, Defensive, Pummelling', 'Average', 1);
  
 insert into weapons values (15, 'Rapier', 18, 'gc', 40, 'Fencing', 'SB-1', '', '',
 'Balanced, Defensive, Pummelling', 'Average', 0);
 
 insert into weapons values (16, 'Shield', 10, 'gc', 50, 'Ordinary', 'SB-2', '', '',
 'Balanced, Defensive, Pummelling', 'Average', 0);
 
 insert into weapons values (17, 'Spear', 10, 'gc', 50, 'Ordinary', 'SB', '', '',
 'Balanced, Defensive, Pummelling', 'Average', 0);
 
 insert into weapons values (18, 'Sword-breaker', 5, 'gc', 40, 'Parrying', 'SB-3',
  '', '', 'Balanced, Defensive, Pummelling', 'Sword-breaker', 0);
  
 insert into weapons values (19, 'Unarmed', NULL, '', NULL, 'Ordinary', 'SB-4',
  '', '', 'Balanced, Defensive, Pummelling', 'Average', 0);
  
 insert into weapons values (20, 'Blunderbuss', 70, 'gc', 50, 'Gunpowder', '3',
  '32/-', '3 Full/6 Full', 'Shrapnel, Unreliable', 'Scarce', 0);
  
 insert into weapons values (21, 'Bola', 7, 's', 20, 'Entangling', '1', '8/16', 'Half',
 'Snare', 'Scarce', 0);
 
 insert into weapons values (22, 'Bow', 10, 'gc', 80, 'Ordinary', '3', '24/48', 'Half',
 'None', 'Common', 1);
 
 insert into weapons values (23, 'Crossbow', 25, 'gc', 120, 'Ordinary', '4', '30/60', 'Full',
 'None', 'Average', 1);
 
 insert into weapons values (24, 'Crossbow Pistol', 25, 'gc', 10, 'Crossbow', '2',
  '8/16', 'Full', 'None', 'Rare', 0);
  
 insert into weapons values (25, 'Elfbow', 70, 'gc', 75, 'Longbow', '3', '36/72', 'Half',
 'Armour Piercing', 'Very Rare', 1);
 
 insert into weapons values (26, 'Firearm', 300, 'gc', 30, 'Gunpowder', '4', '24/48', '2 Full',
 'Impact, Unreliable', 'Very Rare', 1);
 
 insert into weapons values (27, 'Hochland Long Rifle', 450, 'gc', 70, 'Engineer', '4',
  '48/96', '2 Full','Impact, Unreliable', 'Very Rare', 0);
  
 insert into weapons values (28, 'Improvised', NULL, '', 10, 'Ordinary', 'SB-4',
  '6/-', 'Half', 'None', '', 0);
  
 insert into weapons values (29, 'Javelin', 25, 's', 30, 'Ordinary', 'SB-1', '8/16', 'Half',
 'None', 'Average', 0);
 
 insert into weapons values (30, 'Lasso', 1, 'gc', 10, 'Entangling', '', '8/-', 'Half',
 'Snare', 'Plentiful', 1);
 
 insert into weapons values (31, 'Longbow', 15, 'gc', 90, 'Longbow', '3', '30/60', 'Half',
 'Armour Piercing', 'Average', 1);
 
 insert into weapons values (32, 'Net', 3, 'gc', 60, 'Entangling', '', '4/8', 'Full',
 'Snare', 'Plentiful', 0);
 
 insert into weapons values (33, 'Pistol', 200, 'gc', 25, 'Gunpowder', '4', '8/16', '2 Full',
 'Impact, Unreliable', 'Very Rare', 0);
 
 insert into weapons values (34, 'Repeater Crossbow', 100, 'gc', 150, 'Crossbow',
 '2', '16/32', 'Free','Special', 'Very Rare', 1);
 
 insert into weapons values (35, 'Repeater Firearm', 600, 'gc', 30, 'Engineer', '4',
  '24/48', 'Free','Experimental, Special', 'Very Rare', 1);
  
 insert into weapons values (36, 'Repeater Pistol', 400, 'gc', 25, 'Engineer', '4',
  '8/16', 'Free','Experimental, Special', 'Very Rare', 0);
  
 insert into weapons values (37, 'Shortbow', 7, 'gc', 75, 'Ordinary', '3', '16/32', 'Half',
 'None', 'Common', 1);
 
 insert into weapons values (38, 'Sling', 4, 'gc', 10, 'Sling', '3', '16/32', 'Half',
 'None', 'Common', 0);
 
 insert into weapons values (39, 'Spear', 10, 'gc', 50, 'Ordinary', 'SB', '8/-', 'Half',
 'None', 'Common', 0);
 
 insert into weapons values (40, 'Staff Sling', 6, 'gc', 50, 'Sling', '4', '24/48', 'Full',
 'None', 'Rare', 1);
 
 insert into weapons values (41, 'Throwing Axe/Hammer', 5, 'gc', 40, 'Throwing', 'SB-2',
  '8/=', 'Half','None', 'Average', 0);
  
 insert into weapons values (42, 'Throwing Dagger/Star', 3, 'gc', 10, 'Throwing', 'SB-3',
  '6/12', 'Half','None', 'Common', 0);
  
 insert into weapons values (43, 'Whip', 2, 'gc', 15, 'Entangling', 'SB-4',
  '6/-', 'Half','Snare', 'Average', 0);
  
 insert into weapons values (44, 'Arrows (5)', 1, 's', 10, '', '',
  '', '', '', 'Common', 0);
  
 insert into weapons values (45, 'Bolts (5)', 2, 's', 10, '', '',
  '', '', '', 'Average', 0);
  
 insert into weapons values (46, 'Firearm Shot (10)', 1, 's', 10, '', '',
  '', '', '', 'Rare', 0);
  
 insert into weapons values (47, 'Gunpowder (per shot)', 3, 's', 1, '', '',
  '', '', '', 'Very Rare', 0);