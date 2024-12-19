-- Table des utilisateurs
CREATE TABLE utilisateur (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Table des chiens
CREATE TABLE chien (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    race VARCHAR(255),
    date_naissance DATE,
    utilisateur_id BIGINT,
    FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id) ON DELETE CASCADE
);

-- Table des ventes
CREATE TABLE vente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_vente DATE NOT NULL,
    montant DOUBLE NOT NULL,
    description VARCHAR(255),
    utilisateur_id BIGINT,
    FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id) ON DELETE CASCADE
);

-- Table des rendez-vous
CREATE TABLE rendez_vous (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_rendez_vous TIMESTAMP NOT NULL,
    description VARCHAR(255),
    utilisateur_id BIGINT,
    FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id) ON DELETE CASCADE
);
