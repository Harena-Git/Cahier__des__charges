-- 1️⃣ ADMINISTRATION & GESTION DES ACCÈS
CREATE TABLE societe (
    id BIGSERIAL PRIMARY KEY,
    raison_sociale VARCHAR(255) NOT NULL,
    code VARCHAR(50) UNIQUE NOT NULL,
    adresse TEXT,
    ville VARCHAR(100)
);

CREATE TABLE site (
    id BIGSERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    code VARCHAR(50) UNIQUE NOT NULL,
    adresse TEXT,
    ville VARCHAR(100),
    societe_id BIGINT REFERENCES societe(id)
);

CREATE TABLE utilisateur (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(150) UNIQUE NOT NULL,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    telephone VARCHAR(30),
    site_id BIGINT REFERENCES site(id)
);

CREATE TABLE role (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE module (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE fonctionnalite (
    id BIGSERIAL PRIMARY KEY,
    module_id BIGINT REFERENCES module(id),
    code VARCHAR(100) UNIQUE NOT NULL,
    nom VARCHAR(150) NOT NULL
);

CREATE TABLE permission (
    id BIGSERIAL PRIMARY KEY,
    fonctionnalite_id BIGINT REFERENCES fonctionnalite(id),
    code VARCHAR(100) UNIQUE NOT NULL,
    nom VARCHAR(150) NOT NULL
);

CREATE TABLE role_permission (
    id BIGSERIAL PRIMARY KEY,
    role_id BIGINT REFERENCES role(id),
    permission_id BIGINT REFERENCES permission(id)
);

CREATE TABLE delegation_temporaire (
    id BIGSERIAL PRIMARY KEY,
    delegant_user_id BIGINT REFERENCES utilisateur(id),
    delegataire_user_id BIGINT REFERENCES utilisateur(id),
    role_id BIGINT REFERENCES role(id),
    date_debut DATE,
    date_fin DATE
);

CREATE TABLE depot (
    id BIGSERIAL PRIMARY KEY,
    nom VARCHAR(100),
    code VARCHAR(50) UNIQUE,
    site_id BIGINT REFERENCES site(id)
);

CREATE TABLE utilisateur_depot (
    id BIGSERIAL PRIMARY KEY,
    utilisateur_id BIGINT REFERENCES utilisateur(id),
    depot_id BIGINT REFERENCES depot(id),
    role_id BIGINT REFERENCES role(id)
);

CREATE TABLE emplacement (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    depot_id BIGINT REFERENCES depot(id)
);

-- 2️⃣ RÉFÉRENTIELS (MASTERS)
CREATE TABLE methode_gestion (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE categorie_article (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    nom VARCHAR(100),
    methode_gestion_id BIGINT REFERENCES methode_gestion(id)
);

CREATE TABLE unite_mesure (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL,
    nom VARCHAR(50)
);

CREATE TABLE article (
    id BIGSERIAL PRIMARY KEY,
    reference VARCHAR(100) UNIQUE NOT NULL,
    designation VARCHAR(255),
    description TEXT,
    categorie_article_id BIGINT REFERENCES categorie_article(id),
    unite_mesure_stock_id BIGINT REFERENCES unite_mesure(id),
    unite_mesure_achat_id BIGINT REFERENCES unite_mesure(id),
    unite_mesure_vente_id BIGINT REFERENCES unite_mesure(id),
    est_actif BOOLEAN DEFAULT TRUE
);

CREATE TABLE devise (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    nom VARCHAR(50)
);

CREATE TABLE type_client (
    id BIGSERIAL PRIMARY KEY,
    nom VARCHAR(100)
);

CREATE TABLE tarif (
    id BIGSERIAL PRIMARY KEY,
    article_id BIGINT REFERENCES article(id),
    typeclient_id BIGINT REFERENCES type_client(id),
    site_id BIGINT REFERENCES site(id),
    prix NUMERIC(15,2),
    devise_id BIGINT REFERENCES devise(id),
    date_debut DATE,
    date_fin DATE
);

-- 3️⃣ ACHATS (EXTRAIT CLÉ)
CREATE TABLE fournisseur (
    id BIGSERIAL PRIMARY KEY,
    raison_sociale VARCHAR(255),
    nif_stat VARCHAR(100),
    telephone VARCHAR(30)
);

CREATE TABLE demande_achat (
    id BIGSERIAL PRIMARY KEY,
    numero_da VARCHAR(50) UNIQUE NOT NULL,
    date_demande DATE,
    departement_id BIGINT,
    site_id BIGINT REFERENCES site(id),
    status VARCHAR(50)
);

CREATE TABLE ligne_demande_achat (
    id BIGSERIAL PRIMARY KEY,
    demande_achat_id BIGINT REFERENCES demande_achat(id),
    article_id BIGINT REFERENCES article(id),
    designation TEXT,
    quantite NUMERIC(15,2)
);

-- 4️⃣ STOCK & MOUVEMENTS
CREATE TABLE lot (
    id BIGSERIAL PRIMARY KEY,
    numero_lot VARCHAR(100),
    article_id BIGINT REFERENCES article(id),
    date_expiration DATE,
    quantite_disponible NUMERIC(15,2),
    statut VARCHAR(20)
);

CREATE TABLE type_mouvement (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE mouvement_stock (
    id BIGSERIAL PRIMARY KEY,
    date_heure TIMESTAMP,
    utilisateur_id BIGINT REFERENCES utilisateur(id),
    type_mouvement_id BIGINT REFERENCES type_mouvement(id),
    article_id BIGINT REFERENCES article(id),
    lot_id BIGINT REFERENCES lot(id),
    quantite NUMERIC(15,2),
    emplacement_source_id BIGINT REFERENCES emplacement(id),
    emplacement_destination_id BIGINT REFERENCES emplacement(id)
);

-- 5️⃣ VENTES & FACTURATION (EXTRAIT)
CREATE TABLE commande_client (
    id BIGSERIAL PRIMARY KEY,
    numero_commande VARCHAR(50) UNIQUE,
    date_commande DATE,
    depot_id BIGINT REFERENCES depot(id),
    mode_paiement_id BIGINT
);

CREATE TABLE facture_client (
    id BIGSERIAL PRIMARY KEY,
    numero_facture_client VARCHAR(50) UNIQUE,
    date_facture DATE,
    montant NUMERIC(15,2)
);

