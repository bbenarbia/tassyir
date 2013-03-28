insert into parameters values (1,'LANGUAGE', 'FRANCAIS', 'La langue du systeme');
insert into parameters values (2,'EMAIL_ADMIN', 'benaissa@bbenarbia.fr', 'L''email de l''admin');


--Table user_categories

insert into user_categories values (1,'Administrateurs');
insert into user_categories values (2,'Utilisateurs');
insert into user_categories values (3,'SAV');
insert into user_categories values (4,'Invités');

--Roles
insert into roles VALUES (1, 'UTILISATION', '');
insert into roles VALUES (2, 'CREATION USER','');
insert into roles VALUES (3, 'CONSULTATION','');
insert into roles VALUES (4, 'ADMIN ACTIONS','');

insert into user_categories_roles VALUES (1, 1);
insert into user_categories_roles VALUES (1, 2);
insert into user_categories_roles VALUES (1, 3);
insert into user_categories_roles VALUES (1, 4);
insert into user_categories_roles VALUES (2, 1);
insert into user_categories_roles VALUES (3, 1);
insert into user_categories_roles VALUES (4, 2);


insert into contact values (1, 1, 'Contact1', 'Company 1', 'pro', 'adresse1', 'adresse2', false, true, 75001, false, 'Paris', 'adresse@yahoo.fr', '01010101',
'www.bbenarbia.fr', '01010101', '0202020202');

insert into contact values (2, 1, 'Contact2', 'Company 2', 'pro', 'adresse1', 'adresse2', false, true, 75001, false, 'Paris', 'adresse@yahoo.fr', '01010101',
'www.bbenarbia.fr', '01010101', '0202020202');

insert into contact values (3, 1, 'Contact3', 'Company 3', 'pro', 'adresse1', 'adresse2', false, true, 75001, false, 'Paris', 'adresse@yahoo.fr', '01010101',
'www.bbenarbia.fr', '01010101', '0202020202');


insert into users VALUES (1, 1, 'kadour', 'Yahia','kyahia','kyahia',false, false, 1, 2);
insert into users VALUES (2, 2, 'said', 'med','smed','smed',true, false, 2, 1);
insert into users VALUES (3, 3, 'lakhdar', 'omar','lomar','lomar',true, false, 3 , 2);


insert into user_role values (1,1);
insert into user_role values (1,2);
insert into user_role values (2,1);
insert into user_role values (3,1);
