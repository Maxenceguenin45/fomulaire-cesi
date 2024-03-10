DROP DATABASE IF EXISTS formationQCM;
CREATE DATABASE formationQCM;

-- Utilisation de la base de données
USE formationQCM;

-- Table Utilisateur
CREATE TABLE Utilisateur (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             nom VARCHAR(255),
                             prenom VARCHAR(255),
                             date_naissance DATE,
                             telephone VARCHAR(20),
                             email VARCHAR(255),
                             sexe ENUM('M', 'F', 'Autre'),
                             adresse VARCHAR(255),
                             code_postal VARCHAR(10)
);

-- Table Situation_Scolaire
CREATE TABLE Situation_Scolaire (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    utilisateur_id INT,
                                    FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(id),
                                    dernier_diplome VARCHAR(255),
                                    etablissement VARCHAR(255),
                                    experience_professionnelle TEXT,
                                    poste_occupe VARCHAR(255),
                                    duree VARCHAR(50)
);

-- Table Domaine_Formation
CREATE TABLE Domaine_Formation (
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   utilisateur_id INT,
                                   FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(id),
                                   type_bac VARCHAR(50),
                                   type_formation VARCHAR(50),
                                   domaine VARCHAR(255)
);

-- Table Connaisances_Evenement
CREATE TABLE Connaisances_Evenement (
                                        id INT PRIMARY KEY AUTO_INCREMENT,
                                        utilisateur_id INT,
                                        FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(id),
                                        autorisation_mail ENUM('Oui', 'Non'),
                                        reseau VARCHAR(255)
);

-- Table QCM
CREATE TABLE QCM (
                     id INT PRIMARY KEY AUTO_INCREMENT,
                     utilisateur_id INT,
                     FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(id),
                     orientation_formation VARCHAR(255),
                     pret VARCHAR(10), -- 'Oui' ou 'Non'
                     mission_international VARCHAR(10), -- 'Oui' ou 'Non'
                     via_associative VARCHAR(10), -- 'Oui' ou 'Non'
                     projet_associative VARCHAR(10), -- 'Oui' ou 'Non'
                     matiere_generale VARCHAR(10), -- 'Oui' ou 'Non'
                     total VARCHAR(255)
);