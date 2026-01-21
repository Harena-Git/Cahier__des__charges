/* =========================================================
   BASE DE DONNÉES : COMBIEN
   SOURCE : liste-entités.sql (fourni par l'utilisateur)
   SGBD  : PostgreSQL
========================================================= */

CREATE DATABASE combien_db;
\c combien_db;

/* =========================================================
   1. RÉFÉRENTIELS TRANSVERSES
========================================================= */

CREATE TABLE profil_utilisateur (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    nom VARCHAR(100) NOT NULL,
    niveau_hierarchique SMALLINT NOT NULL
);

CREATE TABLE ville (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE devise (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) NOT NULL UNIQUE,
    nom VARCHAR(50) NOT NULL
);

CREATE TABLE mode_paiement (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    nom VARCHAR(50) NOT NULL
);

CREATE TABLE methode_gestion (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) NOT NULL UNIQUE -- FIFO, CUMP, FEFO, LIFO
);

/* =========================================================
   2. STRUCTURE ORGANISATIONNELLE
========================================================= */

CREATE TABLE societe (
    id SERIAL PRIMARY KEY,
    raison_sociale VARCHAR(150) NOT NULL,
    code VARCHAR(20) NOT NULL UNIQUE,
    adresse TEXT,
    ville VARCHAR(100)
);

CREATE TABLE site (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    code VARCHAR(20) NOT NULL UNIQUE,
    adresse TEXT,
    ville VARCHAR(100),
    societe_id INT NOT NULL REFERENCES societe(id)
);

CREATE TABLE depot (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    code VARCHAR(20) NOT NULL UNIQUE,
    site_id INT NOT NULL REFERENCES site(id)
);

CREATE TABLE emplacement (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    depot_id INT NOT NULL REFERENCES depot(id)
);

/* =========================================================
   3. SÉCURITÉ & GESTION DES ACCÈS
========================================================= */

CREATE TABLE utilisateur (
    id SERIAL PRIMARY KEY,
    email VARCHAR(150) NOT NULL UNIQUE,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    telephone VARCHAR(50),
    site_id INT REFERENCES site(id)
);

CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE module (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE fonctionnalite (
    id SERIAL PRIMARY KEY,
    module_id INT NOT NULL REFERENCES module(id),
    code VARCHAR(100) NOT NULL,
    nom VARCHAR(150) NOT NULL
);

CREATE TABLE permission (
    id SERIAL PRIMARY KEY,
    fonctionnalite_id INT NOT NULL REFERENCES fonctionnalite(id),
    code VARCHAR(100) NOT NULL,
    nom VARCHAR(150) NOT NULL
);

CREATE TABLE role_permission (
    id SERIAL PRIMARY KEY,
    role_id INT NOT NULL REFERENCES role(id),
    permission_id INT NOT NULL REFERENCES permission(id),
    UNIQUE (role_id, permission_id)
);

CREATE TABLE utilisateur_depot (
    id SERIAL PRIMARY KEY,
    utilisateur_id INT NOT NULL REFERENCES utilisateur(id),
    depot_id INT NOT NULL REFERENCES depot(id),
    role_id INT NOT NULL REFERENCES role(id)
);

CREATE TABLE delegation_temporaire (
    id SERIAL PRIMARY KEY,
    delegant_user_id INT NOT NULL REFERENCES utilisateur(id),
    delegataire_user_id INT NOT NULL REFERENCES utilisateur(id),
    role_id INT REFERENCES role(id),
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL
);

/* =========================================================
   4. RÉFÉRENTIELS MÉTIER
========================================================= */

CREATE TABLE unite_mesure (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    nom VARCHAR(50) NOT NULL
);

CREATE TABLE categorie_article (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    nom VARCHAR(100) NOT NULL,
    methode_gestion_id INT REFERENCES methode_gestion(id)
);

CREATE TABLE article (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(100) NOT NULL UNIQUE,
    designation VARCHAR(150) NOT NULL,
    description TEXT,
    categorie_article_id INT REFERENCES categorie_article(id),
    unite_mesure_stock_id INT REFERENCES unite_mesure(id),
    unite_mesure_achat_id INT REFERENCES unite_mesure(id),
    unite_mesure_vente_id INT REFERENCES unite_mesure(id),
    est_actif BOOLEAN DEFAULT TRUE
);

CREATE TABLE type_client (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    typeclient_id INT REFERENCES type_client(id),
    raison_sociale VARCHAR(150) NOT NULL,
    telephone VARCHAR(50),
    email VARCHAR(150)
);

CREATE TABLE fournisseur (
    id SERIAL PRIMARY KEY,
    raison_sociale VARCHAR(150) NOT NULL,
    nif_stat VARCHAR(50),
    telephone VARCHAR(50)
);

CREATE TABLE tarif (
    id SERIAL PRIMARY KEY,
    article_id INT NOT NULL REFERENCES article(id),
    typeclient_id INT REFERENCES type_client(id),
    site_id INT REFERENCES site(id),
    prix NUMERIC(15,2) NOT NULL,
    devise_id INT REFERENCES devise(id),
    date_debut DATE NOT NULL,
    date_fin DATE
);

/* =========================================================
   5. ACHATS
========================================================= */

CREATE TABLE departement (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE demande_achat (
    id SERIAL PRIMARY KEY,
    numero_da VARCHAR(50) NOT NULL UNIQUE,
    date_demande DATE NOT NULL,
    departement_id INT REFERENCES departement(id),
    site_id INT REFERENCES site(id),
    status VARCHAR(30) NOT NULL
);

CREATE TABLE ligne_demande_achat (
    id SERIAL PRIMARY KEY,
    demande_achat_id INT REFERENCES demande_achat(id),
    article_id INT REFERENCES article(id),
    designation VARCHAR(150),
    quantite NUMERIC(15,2) NOT NULL
);

/* =========================================================
   6. STOCK
========================================================= */

CREATE TABLE lot (
    id SERIAL PRIMARY KEY,
    numero_lot VARCHAR(100),
    article_id INT REFERENCES article(id),
    date_expiration DATE,
    quantite_disponible NUMERIC(15,2),
    statut VARCHAR(20)
);

CREATE TABLE type_mouvement (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE mouvement_stock (
    id SERIAL PRIMARY KEY,
    date_heure TIMESTAMP NOT NULL,
    utilisateur_id INT REFERENCES utilisateur(id),
    type_mouvement_id INT REFERENCES type_mouvement(id),
    article_id INT REFERENCES article(id),
    lot_id INT REFERENCES lot(id),
    quantite NUMERIC(15,2),
    emplacement_source_id INT REFERENCES emplacement(id),
    emplacement_destination_id INT REFERENCES emplacement(id)
);

/* =========================================================
   7. VENTES
========================================================= */

CREATE TABLE proforma_client (
    id SERIAL PRIMARY KEY,
    numero_proforma VARCHAR(50) NOT NULL UNIQUE,
    client_id INT REFERENCES client(id),
    date DATE NOT NULL,
    devise_id INT REFERENCES devise(id)
);

CREATE TABLE commande_client (
    id SERIAL PRIMARY KEY,
    numero_commande VARCHAR(50) NOT NULL UNIQUE,
    proforma_client_id INT REFERENCES proforma_client(id),
    date_commande DATE NOT NULL,
    depot_id INT REFERENCES depot(id),
    mode_paiement_id INT REFERENCES mode_paiement(id)
);

/* =========================================================
   8. FACTURATION & PAIEMENTS
========================================================= */

CREATE TABLE facture_client (
    id SERIAL PRIMARY KEY,
    numero_facture_client VARCHAR(50) NOT NULL UNIQUE,
    date_facture DATE NOT NULL,
    montant NUMERIC(15,2) NOT NULL
);

CREATE TABLE encaissement_client (
    id SERIAL PRIMARY KEY,
    numero_encaissement VARCHAR(50) NOT NULL UNIQUE,
    facture_client_id INT REFERENCES facture_client(id),
    date_encaissement DATE NOT NULL,
    mode_paiement_id INT REFERENCES mode_paiement(id)
);
