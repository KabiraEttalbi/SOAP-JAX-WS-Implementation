-- Création des tables

CREATE TABLE IF NOT EXISTS utilisateurs (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS evenements (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    lieu VARCHAR(100) NOT NULL,
    date TIMESTAMP NOT NULL,
    description TEXT,
    capacite_max INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS billets (
    id SERIAL PRIMARY KEY,
    evenement_id INTEGER REFERENCES evenements(id),
    categorie VARCHAR(50) NOT NULL,
    prix DECIMAL(10, 2) NOT NULL,
    disponible BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS reservations (
    id SERIAL PRIMARY KEY,
    utilisateur_id INTEGER REFERENCES utilisateurs(id),
    billet_id INTEGER REFERENCES billets(id),
    date_reservation TIMESTAMP NOT NULL,
    statut VARCHAR(20) NOT NULL
);
