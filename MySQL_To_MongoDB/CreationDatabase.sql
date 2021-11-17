    -- --------------------------
-- CREATION DE  LA TABLE Espece
-- ------------------------------

CREATE TABLE Espece (
    id SMALLINT UNSIGNED AUTO_INCREMENT,
    nom_courant VARCHAR(40) NOT NULL,
    nom_latin VARCHAR(40) NOT NULL UNIQUE,
    description TEXT,
    PRIMARY KEY(id)
);

-- -----------------------
-- REMPLISSAGE DE LA TABLE
-- -----------------------

INSERT INTO Espece (nom_courant, nom_latin, description) VALUES
    ('Chien', 'Canis canis', 'Bestiole à quatre pattes qui aime les caresses et tire souvent la langue'),
    ('Chat', 'Felis silvestris', 'Bestiole à quatre pattes qui saute très haut et grimpe aux arbres'),
    ('Tortue d''Hermann', 'Testudo hermanni', 'Bestiole avec une carapace très dure'),
    ('Perroquet amazone', 'Alipiopsitta xanthops', 'Joli oiseau parleur vert et jaune');


    -- --------------------------
-- CREATION DE  LA TABLE Race
-- ------------------------------ 
CREATE TABLE Race (
    id SMALLINT UNSIGNED AUTO_INCREMENT,
    nom VARCHAR(40) NOT NULL,
    espece_id SMALLINT UNSIGNED NOT NULL,
    description TEXT,
    PRIMARY KEY(id),
    CONSTRAINT fk_race_espece_id FOREIGN KEY (espece_id) REFERENCES Espece(id)  
);

-- -----------------------
-- REMPLISSAGE DE LA TABLE
-- -----------------------
INSERT INTO Race (nom, espece_id, description)
VALUES ('Berger allemand', 1, 'Chien sportif et élégant au pelage dense, noir-marron-fauve, noir ou gris.'),
('Berger blanc suisse', 1, 'Petit chien au corps compact, avec des pattes courtes mais bien proportionnées et au pelage tricolore ou bicolore.'),
('Boxer', 1, 'Chien de taille moyenne, au poil ras de couleur fauve ou bringé avec quelques marques blanches.'),
('Bleu russe', 2, 'Chat aux yeux verts et à la robe épaisse et argentée.'),
('Maine coon', 2, 'Chat de grande taille, à poils mi-longs.'),
('Singapura', 2, 'Chat de petite taille aux grands yeux en amandes.'),
('Sphynx', 2, 'Chat sans poils.');

    -- --------------------------
-- CREATION DE  LA TABLE Owner
-- ------------------------------

CREATE TABLE Owner (
name VARCHAR(20), 
owner VARCHAR(20), 
species VARCHAR(20), 
sex CHAR(1), 
birth DATE, 
death DATE);

-- -----------------------------
-- REMPLISSAGE DE LA TABLE Owner
-- -----------------------------
INSERT INTO Owner( 1,'Nouna','ZED','NY city')
INSERT INTO Owner( 2,'Imane','Bello','London')
INSERT INTO Owner( 3,'Dounia','Bennoune','LA')
INSERT INTO Owner( 4,'Gilbert','Blaith','Prince Edward island')

-- -----------------------------
-- CREATION DE LA TABLE pet
-- -----------------------------

CREATE TABLE pet (name VARCHAR(20), owner VARCHAR(20),
species VARCHAR(20), sex CHAR(1), birth DATE, death DATE);

-- -----------------------------
-- REMPLISSAGE DE LA TABLE pet
-- -----------------------------
INSERT INTO pet
       VALUES ('Puffball',1,'hamster','f','1999-03-30',NULL),
    ('Claws',4,'cat','m','1994-03-17',NULL),
    ('Buffy',2,'dog','f','1989-05-13',NULL),
    ('loki',3,'cat','m','2019-03-01',NULL),
    ('Bowser',2,'snake','m','1979-08-31','1995-07-29');