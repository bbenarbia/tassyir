drop database IF EXISTS tassyir;
CREATE DATABASE IF NOT EXISTS tassyir;
GRANT ALL PRIVILEGES ON tassyir.* TO pc@localhost IDENTIFIED BY 'pc';

USE tassyir;


CREATE TABLE IF NOT EXISTS types (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;



CREATE TABLE IF NOT EXISTS fonction (
    id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    fonction_type INT(5),
--    fk_categorieutilisateur_fonction INT(5),  
  	INDEX(name)
--    FOREIGN KEY (fk_categorieutilisateur_fonction) REFERENCES user_categories(id)
)engine=InnoDB;




 CREATE TABLE IF NOT EXISTS parameters (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  parameter_value VARCHAR(80),
  parameter_description VARCHAR(255),
  INDEX(name)
) engine=InnoDB;


 CREATE TABLE IF NOT EXISTS user_categories (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  INDEX(name)
) engine=InnoDB;



CREATE TABLE IF NOT EXISTS contact (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  typecontact INT(5) DEFAULT 0,
  name VARCHAR(30),
  nomsocietecontact VARCHAR(30),
  titrecontact VARCHAR(30),
  adressecontact1 VARCHAR(255),
  adressecontact2 VARCHAR(255),
  alertesurtelephone1  tinyint (1),
  alertesurtelephone2  tinyint (1),
  codepostalcontact INT(5) UNSIGNED NOT NULL,
  estcontactprincipal  tinyint (1),
  villecontact VARCHAR(80),
  adressemailcontact VARCHAR(80),
  faxcontact VARCHAR(80),
  sitewebcontact VARCHAR(80),
  telephonecontact1 VARCHAR(80),
  telephonecontact2 VARCHAR(80),
  PRIMARY KEY (id),
  INDEX(name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS roles (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255),
  index(name)
  ) engine=InnoDB;

CREATE TABLE IF NOT EXISTS user_categories_roles (
  id_catgory INT(5) UNSIGNED NOT NULL,
  id_role INT(5) UNSIGNED NOT NULL,
  FOREIGN KEY (id_catgory) REFERENCES user_categories(id),
  FOREIGN KEY (id_role) REFERENCES roles(id),
  UNIQUE(id_catgory,  id_role)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS users (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  code INT(5) UNSIGNED NOT NULL default 0,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  login VARCHAR(30),
  password VARCHAR(30),
  locked  tinyint (1),
  is_admin  tinyint (1),
  fk_contact INT(5) UNSIGNED NOT NULL,
  fk_categorieutilisateur INT(5) UNSIGNED NOT NULL,  
  FOREIGN KEY (fk_contact) REFERENCES  contact(id),
  FOREIGN KEY (fk_categorieutilisateur) REFERENCES  user_categories(id),
  INDEX(last_name)
) engine=InnoDB;


 CREATE TABLE IF NOT EXISTS user_role (
  id_user INT(5) UNSIGNED NOT NULL ,
  id_role INT(5) UNSIGNED NOT NULL ,
  FOREIGN KEY (id_user) REFERENCES users(id),
  FOREIGN KEY (id_role) REFERENCES roles(id),
  UNIQUE(id_user,  id_role)
  ) engine=InnoDB;
  
  
  
  CREATE TABLE IF NOT EXISTS biens (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ref VARCHAR(80),
  name VARCHAR(30),
  typeBien VARCHAR(15),
--  APT appartement 
--  STD studio 
--  TRN Terrain
--  CMR Commerce
--  MSN MAISON
--  ETP ENTREPOT  
  
  adresse VARCHAR(120),
  description VARCHAR(300),
  superficie DECIMAL(5,2),
  status INT(5) DEFAULT 0,
  prixVente DECIMAL(5,2),
  prixMinVente DECIMAL(5,2),
  loyerMensuel DECIMAL(5,2),
  chargesMensuel DECIMAL(5,2),
  typeOperation  INT(5) DEFAULT 0,
  etatBien INT(5) DEFAULT 0,
  etage  INT(5) DEFAULT 0,
  nbPieces  INT(5) DEFAULT 0,
  ascenseur tinyint (1),
  cuisineEquipee tinyint (1),
  age  INT(5) DEFAULT 0, 
  jardin  tinyint (1),
  INDEX(ref, name)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS photos (
  id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  bien INT(5) UNSIGNED NOT NULL,
  path VARCHAR(300),
  FOREIGN KEY (bien) REFERENCES biens(id),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS departements (
 id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ref VARCHAR(80),
 name VARCHAR(80),
 region VARCHAR(80),
 prefecture VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

