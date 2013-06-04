
insert into parameters values (1,"LANGUAGE", "FRANCAIS", "La langue du systeme");
insert into parameters values (2,"EMAIL_ADMIN", "benaissa@bbenarbia.fr", "L""email de l""admin");
insert into parameters values (3,"TEMP_DIRECTORY", "c:\\Benaissa\\temp\\", "Temp directory");
insert into parameters values (4,"MAIN_CURRENCY", '&euro;', "Main currency");
insert into parameters values (5,"SECOND_CURRENCY", "$", "Second currency");
insert into parameters values (10, "OPTION_EAU_CHAUDE", "false","OPTION_EAU_CHAUDE");
insert into parameters values (11, "OPTION_IMPACT_CONSO","false","OPTION_IMPACT_CONSO");
insert into parameters values (12, "OPTION_NATURE_CHAUFFAGE","false","OPTION_NATURE_CHAUFFAGE");
insert into parameters values (13, "OPTION_TYPE_CHAUFFAGE","false","OPTION_TYPE_CHAUFFAGE");
insert into parameters values (14, "OPTION_PISCINE","false","OPTION_PISCINE");
insert into parameters values (15, "OPTION_JARDIN","false","OPTION_JARDIN");
insert into parameters values (16, "OPTION_ADAPTE_HANDICAPE","false","OPTION_ADAPTE_HANDICAPE");
insert into parameters values (17, "OPTION_DEPARTEMENT","false","OPTION_DEPARTEMENT");
insert into parameters values (18, "OPTION_CAVES","false","OPTION_CAVES");
insert into parameters values (19, "OPTION_TERRASSES","false","OPTION_TERRASSES");
insert into parameters values (20, "OPTION_CUISINEEQUIPEE", "false","OPTION_CUISINEEQUIPEE");
insert into parameters values (21, "OPTION_INTERPHONE","false","OPTION_INTERPHONE");
insert into parameters values (22, "OPTION_DIGICODE","false","OPTION_DIGICODE");
insert into parameters values (23, "OPTION_GARDIEN","false","OPTION_GARDIEN");
insert into parameters values (24, "OPTION_CONSO_ENERGIE","false","OPTION_CONSO_ENERGIE");
 
 
insert into departements values (1,"1","Adrar","Adrar","Adrar");
insert into departements values (2,"2","Chlef","Chlef","Chlef");
insert into departements values (3,"3","Laghouat","Laghouat","Laghouat");
insert into departements values (4,"4","Oum El Bouaghi","Oum El Bouaghi","Oum El Bouaghi");
insert into departements values (5,"5","Batna","Batna","Batna");
insert into departements values (6,"6","Béjaïa","Béjaïa","Béjaïa");
insert into departements values (7,"7","Biskra","Biskra","Biskra");
insert into departements values (8,"8","Béchar","Béchar","Béchar");
insert into departements values (9,"9","Blida","Blida","Blida");
insert into departements values (10,"10","Bouira","Bouira","Bouira");
insert into departements values (11,"11","Tamanrasset","Tamanrasset","Tamanrasset");
insert into departements values (12,"12","Tébessa","Tébessa","Tébessa");
insert into departements values (13,"13","Tlemcen","Tlemcen","Tlemcen");
insert into departements values (14,"14","Tiaret","Tiaret","Tiaret");
insert into departements values (15,"15","Tizi Ouzou","Tizi Ouzou","Tizi Ouzou");
insert into departements values (16,"16","Alger","Alger","Alger");
insert into departements values (17,"17","Djelfa","Djelfa","Djelfa");
insert into departements values (18,"18","Jijel","Jijel","Jijel");
insert into departements values (19,"19","Sétif","Sétif","Sétif");
insert into departements values (20,"20","Saïda","Saïda","Saïda");
insert into departements values (21,"21","Skikda","Skikda","Skikda");
insert into departements values (22,"22","Sidi Bel Abbès","Sidi Bel Abbès","Sidi Bel Abbès");
insert into departements values (23,"23","Annaba","Annaba","Annaba");
insert into departements values (24,"24","Guelma","Guelma","Guelma");
insert into departements values (25,"25","Constantine","Constantine","Constantine");
insert into departements values (26,"26","Médéa","Médéa","Médéa");
insert into departements values (27,"27","Mostaganem","Mostaganem","Mostaganem");
insert into departements values (28,"28","MSila","MSila","MSila");
insert into departements values (29,"29","Mascara","Mascara","Mascara");
insert into departements values (30,"30","Ouargla","Ouargla","Ouargla");
insert into departements values (31,"31","Oran","Oran","Oran");
insert into departements values (32,"32","El Bayadh","El Bayadh","El Bayadh");
insert into departements values (33,"33","Illizi","Illizi","Illizi");
insert into departements values (34,"34","Bordj Bou Arreridj","Bordj Bou Arreridj","Bordj Bou Arreridj");
insert into departements values (35,"35","Boumerdès","Boumerdès","Boumerdès");
insert into departements values (36,"36","El Tarf","El Tarf","El Tarf");
insert into departements values (37,"37","Tindouf","Tindouf","Tindouf");
insert into departements values (38,"38","Tissemsilt","Tissemsilt","Tissemsilt");
insert into departements values (39,"39","El Oued","El Oued","El Oued");
insert into departements values (40,"40","Khenchela","Khenchela","Khenchela");
insert into departements values (41,"41","Souk Ahras","Souk Ahras","Souk Ahras");
insert into departements values (42,"42","Tipaza","Tipaza","Tipaza");
insert into departements values (43,"43","Mila","Mila","Mila");
insert into departements values (44,"44","Aïn Defla","Aïn Defla","Aïn Defla");
insert into departements values (45,"45","Naama","Naama","Naama");
insert into departements values (46,"46","Aïn Témouchent","Aïn Témouchent","Aïn Témouchent");
insert into departements values (47,"47","Ghardaia","Ghardaia","Ghardaia");
insert into departements values (48,"48","Relizane","Relizane","Relizane");


---Table user_categories

insert into user_categories values (1,"Administrateurs", "c:\\Benaissa\\temp\\p1.jpg");
insert into user_categories values (2,"Utilisateurs", "c:\\Benaissa\\temp\\p2.jpg");
insert into user_categories values (3,"Managers", "c:\\Benaissa\\temp\\p3.jpg");
insert into user_categories values (4,"Commerciaux","c:\\Benaissa\\temp\\p4.jpg");
insert into user_categories values (5,"Autres","c:\\Benaissa\\temp\\p4.jpg");

--Roles
insert into roles VALUES (1, "ROLE_USER", "");
insert into roles VALUES (2, "ROLE_CONSULTATION","");
insert into roles VALUES (3, "ROLE_MODIFICATION","");
insert into roles VALUES (4, "ROLE_MANAGER","");
insert into roles VALUES (5, "ROLE_ADMIN","");

insert into user_categories_roles(id_catgory, id_role ) VALUES (1, 1);
insert into user_categories_roles(id_catgory, id_role ) VALUES (1, 2);
insert into user_categories_roles(id_catgory, id_role ) VALUES (1, 3);
insert into user_categories_roles(id_catgory, id_role ) VALUES (1, 4);
insert into user_categories_roles(id_catgory, id_role ) VALUES (1, 5);

insert into user_categories_roles(id_catgory, id_role ) VALUES (2, 1);

insert into user_categories_roles(id_catgory, id_role ) VALUES (3, 1);
insert into user_categories_roles(id_catgory, id_role ) VALUES (3, 2);
insert into user_categories_roles(id_catgory, id_role ) VALUES (3, 3);
insert into user_categories_roles(id_catgory, id_role ) VALUES (3, 4);

insert into user_categories_roles VALUES (4, 1);
insert into user_categories_roles VALUES (4, 2);
insert into user_categories_roles VALUES (4, 3);




insert into contact values (1, 1, "Contact1", "Company 1",  "adresse1",  false, true, 75001, "Paris", "adresse@yahoo.fr", 
"www.bbenarbia.fr", "01010101", "0202020202");

insert into contact values (2, 1, "Contact2", "Company 2",  "adresse1",  false, true, 75001, "Paris", "adresse@yahoo.fr", 
"www.bbenarbia.fr", "01010101", "0202020202");

insert into contact values (3, 1, "Contact3", "Company 3",  "adresse1",  false, true, 75001, "Paris", "adresse@yahoo.fr", 
"www.bbenarbia.fr", "01010101", "0202020202");

insert into users(id,code, photo,first_name,last_name, login, password,locked,is_admin, adresse ,  codePostal,  ville,  alertesurtelephone1 ,  alertesurtelephone2,  adresseMail,  siteWeb,  telephonePerso,  telephoneProf,  mobile,  fk_categorieutilisateur)  VALUES
				(1, 1, "c:\\Benaissa\\temp\\p1.jpg", "kadour", "Yahia","kyahia","kyahia",false, false, "adresse1","93800","Epinay sur seine", false, false, "ben@gmail.com","www.bbenaissa.fr","01010101","","0625252525",4);
insert into users(id,code, photo,first_name,last_name, login, password,locked,is_admin, adresse ,  codePostal,  ville,  alertesurtelephone1 ,  alertesurtelephone2,  adresseMail,  siteWeb,  telephonePerso,  telephoneProf,  mobile,  fk_categorieutilisateur)  VALUES 
				(2, 2, "c:\\Benaissa\\temp\\p2.jpg", "said", "med","smed","smed",true, false, "adresse2","65800","Epinay sur seine", false, false, "ben@gmail.com","www.bbenarbia.fr","01010101","","0625252525", 3);
insert into users(id,code, photo,first_name,last_name, login, password,locked,is_admin, adresse ,  codePostal,  ville,  alertesurtelephone1 ,  alertesurtelephone2,  adresseMail,  siteWeb,  telephonePerso,  telephoneProf,  mobile,  fk_categorieutilisateur)  VALUES
				(3, 3, "c:\\Benaissa\\temp\\p3.jpg", "lakhdar", "omar","lomar","lomar",true, false,"adresse3","95800","Epinay sur seine", true, true, "ben@gmail.com","","01010101","","0625252525",  2);

insert into users(id,code, photo,first_name,last_name, login, password,locked,is_admin, adresse ,  codePostal,  ville,  alertesurtelephone1 ,  alertesurtelephone2,  adresseMail,  siteWeb,  telephonePerso,  telephoneProf,  mobile,  fk_categorieutilisateur)  VALUES 
                 (4, 4, "c:\\Benaissa\\temp\\p3.jpg", "benaissa", "BENARBIA","bbenaissa","bbenaissa",false, false,"adresse3","95800","Epinay sur seine", false, false, "ben@gmail.com","","01010101","","0625252525",  1);
  
  
insert into user_role values (4,1);
insert into user_role values (4,2);
  
insert into biens (
 id, ref ,name, typeBien, adresse,codePostal, ville,  idDepartement,description,superficie,status,prixVente,prixMinVente,loyerMensuel,chargesMensuel,typeOperation
  ,etatBien,etage,nbPieces,nbChambres, nbTerrasses,nbBalcons,nbParkingInt,nbParkingExt,interphone,digicode,gardien,piscine,transport,proximite,adapteHandicape
  ,honoraires,depotGarantie,nbSallesBains,nbCaves,consoEnergie,typeEauChaude,impactConso,natureChauffage,typeChauffage,meuble,ascenseur
  ,cuisineEquipee,age,jardin,proprietaire
) values(1, "1",  "appartement1","APPARTEMENT","adresse 1",'93800','Epinay sur seine', 1,"description de location",24.4, 1, 700, 
500,100, 100, 1, 1, "2/5", 2,1, 0,1,1,0,true,false,true,false, "10 min de RER A", "Proche tout commerce et centre ville",false,100.0,200,2,0,1,1,1,1,1,false, false, false, 1967, false,4);   


insert into biens (
 id, ref ,name, typeBien, adresse,codePostal, ville, idDepartement,description,superficie,status,prixVente,prixMinVente,loyerMensuel,chargesMensuel,typeOperation
  ,etatBien,etage,nbPieces,nbChambres, nbTerrasses,nbBalcons,nbParkingInt,nbParkingExt,interphone,digicode,gardien,piscine,transport,proximite,adapteHandicape
 ,honoraires,depotGarantie,nbSallesBains,nbCaves,consoEnergie,typeEauChaude,impactConso,natureChauffage,typeChauffage,meuble,ascenseur
  ,cuisineEquipee,age,jardin,proprietaire
) values(2, "2", "appartement2","APPARTEMENT","adresse 1",'95800','Argenteuil', 2, "description de location",24.4, 1, 700, 
500,100, 100, 1, 1, "2/2", 2,1,0,1,1,0,true,false,true,false, "10 min de RER A", "Proche tout commerce et centre ville",false,100.0,200,2,0,1,1,1,1,1,false, false, false, 2001, false,3);   


insert into biens (
  id, ref ,name, typeBien, adresse,codePostal, ville, idDepartement,description,superficie,status,prixVente,prixMinVente,loyerMensuel,chargesMensuel,typeOperation
  ,etatBien,etage,nbPieces,nbChambres,nbTerrasses,nbBalcons,nbParkingInt,nbParkingExt,interphone,digicode,gardien,piscine,transport,proximite,adapteHandicape
  ,honoraires,depotGarantie,nbSallesBains,nbCaves,consoEnergie,typeEauChaude,impactConso,natureChauffage,typeChauffage,meuble,ascenseur
  ,cuisineEquipee,age,jardin,proprietaire
) values(3, "3", "Studio","STUDIO","adresse 1",'93800','Epinay sur seine', 2, "description de location",24.4, 1, 700, 
500,100, 100, 1, 1,"2/6", 2,2,0,1,1,0,true,false,true,false, "10 min de RER A", "Proche tout commerce et centre ville",false,100.0,200,2,0,1,1,1,1,1,false, false, false, 2011, false,2);   

insert into biens (
  id, ref ,name, typeBien, adresse,codePostal, ville, idDepartement,description,superficie,status,prixVente,prixMinVente,loyerMensuel,chargesMensuel,typeOperation
  ,etatBien,etage,nbPieces,nbChambres,nbTerrasses,nbBalcons,nbParkingInt,nbParkingExt,interphone,digicode,gardien,piscine,transport,proximite,adapteHandicape
  ,honoraires,depotGarantie,nbSallesBains,nbCaves,consoEnergie,typeEauChaude,impactConso,natureChauffage,typeChauffage,meuble,ascenseur
  ,cuisineEquipee,age,jardin,proprietaire
) values(4, "4",  "maison 1","MAISON","adresse 1",'93800','Epinay sur seine',1, "description de location",24.4, 1, 700, 
500,100, 100, 1, 1, "1/3", 2,2,0,1,1,0,true,true,true,true, "10 min de RER A", "Proche tout commerce et centre ville",true,100.0,200,2,0,1,1,1,1,1,true, true, true, 2011, true,1);   


insert into biens (
 id, ref ,name, typeBien, adresse,codePostal, ville, idDepartement,description,superficie,status,prixVente,prixMinVente,loyerMensuel,chargesMensuel,typeOperation
  ,etatBien,etage,nbPieces,nbChambres, nbTerrasses,nbBalcons,nbParkingInt,nbParkingExt,interphone,digicode,gardien,piscine,transport,proximite,adapteHandicape
 ,honoraires,depotGarantie,nbSallesBains,nbCaves,consoEnergie,typeEauChaude,impactConso,natureChauffage,typeChauffage,meuble,ascenseur
  ,cuisineEquipee,age,jardin,proprietaire
) values(5, "5", "appartement5","APPARTEMENT","adresse 5",'95800','Argenteuil', 1, "description de location",24.4, 1, 700, 
-500,100, 100, 0, 1, "2/2", 2,1,0,1,1,0,true,true,true,true, "10 min de RER A", "Proche tout commerce et centre ville",true,100.0,200,2,0,1,1,1,1,1,true, true, true, 2001, true, 1);   



insert into photos values(1,"photos1", 2,"c:\\Benaissa\\temp\\app1.jpg");
insert into photos values(2,"photos2", 2,"c:\\Benaissa\\temp\\app2.jpg");
insert into photos values(3,"photos3", 2,"c:\\Benaissa\\temp\\app3.jpg");

insert into photos values(4,"photos4", 3,"c:\\Benaissa\\temp\\m1.jpg");
insert into photos values(5,"photos5", 3,"c:\\Benaissa\\temp\\m2.jpg");
insert into photos values(6,"photos6", 3,"c:\\Benaissa\\temp\\m3.jpg");
insert into photos values(7,"photos7", 3,"c:\\Benaissa\\temp\\m4.jpg");


---c:\\Benaissa\\temp\\
---/home/moad/tempfile/
