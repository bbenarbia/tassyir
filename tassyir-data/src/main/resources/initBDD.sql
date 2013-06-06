drop database IF EXISTS tassyir;
CREATE DATABASE IF NOT EXISTS tassyir;

GRANT ALL PRIVILEGES ON tassyir.* TO pc@localhost IDENTIFIED BY 'pc';
USE tassyir;


CREATE TABLE IF NOT EXISTS types (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB  DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS fonction (
    id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    fonction_type INT(5),
--    fk_categorieutilisateur_fonction INT(5),  
  	INDEX(name)
--    FOREIGN KEY (fk_categorieutilisateur_fonction) REFERENCES user_categories(id)
)engine=InnoDB  DEFAULT CHARSET=utf8;


 CREATE TABLE IF NOT EXISTS parameters (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  parameter_value VARCHAR(80),
  parameter_description VARCHAR(255),
  INDEX(name)
) engine=InnoDB  DEFAULT CHARSET=utf8;


 CREATE TABLE IF NOT EXISTS user_categories (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  photo VARCHAR(300),
  INDEX(name)
) engine=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS contact (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  typecontact INT(5) DEFAULT 0,
  name VARCHAR(30),
  nomsocietecontact VARCHAR(30),
  adressecontact1 VARCHAR(255),
  alertesurtelephone1  tinyint (1),
  alertesurtelephone2  tinyint (1),
  codepostalcontact INT(5) UNSIGNED NOT NULL,
  villecontact VARCHAR(80),
  adressemailcontact VARCHAR(80),
  sitewebcontact VARCHAR(80),
  telephonecontact1 VARCHAR(80),
  telephonecontact2 VARCHAR(80),
  PRIMARY KEY (id),
  INDEX(name)
)engine=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS roles (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255),
  index(name)
  ) engine=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS user_categories_roles (
  id_catgory INT(5) UNSIGNED NOT NULL,
  id_role INT(5) UNSIGNED NOT NULL,
  FOREIGN KEY (id_catgory) REFERENCES user_categories(id),
  FOREIGN KEY (id_role) REFERENCES roles(id),
  UNIQUE(id_catgory,  id_role)
) engine=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS users (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  code INT(5) UNSIGNED NOT NULL default 0,
  photo VARCHAR(300),
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  login VARCHAR(30),
  password VARCHAR(30),
  locked  tinyint (1),
  is_admin  tinyint (1),  
  adresse VARCHAR(300),
  codePostal VARCHAR(10),
  ville VARCHAR(30),
  alertesurtelephone1  tinyint (1),
  alertesurtelephone2  tinyint (1),
  adresseMail VARCHAR(80),
  siteWeb	VARCHAR(80),
  telephonePerso  VARCHAR(80),
  telephoneProf VARCHAR(80),
  mobile  VARCHAR(80),
  fk_categorieutilisateur INT(5) UNSIGNED NOT NULL,  
  FOREIGN KEY (fk_categorieutilisateur) REFERENCES  user_categories(id),
  INDEX(last_name)
) engine=InnoDB  DEFAULT CHARSET=utf8;


 CREATE TABLE IF NOT EXISTS user_role (
  id_user INT(5) UNSIGNED NOT NULL ,
  id_role INT(5) UNSIGNED NOT NULL ,
  FOREIGN KEY (id_user) REFERENCES users(id),
  FOREIGN KEY (id_role) REFERENCES roles(id),
  UNIQUE(id_user,  id_role)
  ) engine=InnoDB  DEFAULT CHARSET=utf8;
  
  CREATE TABLE IF NOT EXISTS towns (
 id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 ref VARCHAR(80),
 name VARCHAR(80),
 codePostal VARCHAR(20),
 departement VARCHAR(80),
 typeVille INT(5) DEFAULT 0,
 region VARCHAR(80),
  INDEX(name)
) engine=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS biens (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ref VARCHAR(80),
  name VARCHAR(30),
  typeBien VARCHAR(15),
  adresse  VARCHAR(120),
  idDepartement INT(5) DEFAULT 0,
  description VARCHAR(800),
  superficie DOUBLE ,
  status INT(5) DEFAULT 0,
  prixVente DOUBLE ,
  prixMinVente DOUBLE ,
  loyerMensuel DOUBLE ,
  chargesMensuel DOUBLE ,
  typeOperation  INT(5) DEFAULT 0,
  etatBien INT(5) DEFAULT 0,
  etage  varchar(15),
  nbPieces  INT(5) DEFAULT 0,
  nbChambres INT(5) DEFAULT 0,
  nbTerrasses INT(5) DEFAULT 0,
  nbBalcons INT(5) DEFAULT 0,
  nbParkingInt   INT(5) DEFAULT 0,
  nbParkingExt INT(5) DEFAULT 0,
  interphone tinyint (1),
  digicode tinyint (1),
  gardien tinyint (1),
  piscine tinyint (1),
  transport VARCHAR(200),
  proximite VARCHAR(200),
  adapteHandicape tinyint (1),
  honoraires DOUBLE ,
  depotGarantie DOUBLE ,
  nbSallesBains INT(5) DEFAULT 0,
  nbCaves INT(5) DEFAULT 0,
  consoEnergie INT(5) DEFAULT 0,
  typeEauChaude INT(5) DEFAULT 0,
  impactConso INT(5) DEFAULT 0,
  natureChauffage INT(5) DEFAULT 0,
  typeChauffage INT(5) DEFAULT 0,
  meuble tinyint (1),
  ascenseur tinyint (1),
  cuisineEquipee tinyint (1),
  age  INT(5) DEFAULT 0, 
  jardin  tinyint (1),
  proprietaire INT(5) UNSIGNED NOT NULL,
  INDEX(ref, name)
) engine=InnoDB  DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS photos (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250),
  bien INT(5) UNSIGNED NOT NULL,
  path VARCHAR(300),

  INDEX(name)
) engine=InnoDB  DEFAULT CHARSET=utf8;


--FOREIGN KEY (idDepartement) REFERENCES departements(id),
--  FOREIGN KEY (bien) REFERENCES biens(id),
