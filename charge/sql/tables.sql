-- -----------------------------
-- Création de la base
-- -----------------------------
DROP DATABASE IF EXISTS avs_db;
CREATE DATABASE avs_db;
\c avs_db;

-- ============================================
-- 0. TABLES DE BASE (SANS DÉPENDANCES)
-- ============================================
CREATE TABLE ville (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE methode_gestion (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) NOT NULL UNIQUE
);

-- ============================================
-- 1. MODULE ADMINISTRATION & GESTION DES ACCÈS
-- ============================================

CREATE TABLE societe (
    id SERIAL PRIMARY KEY,
    raison_sociale VARCHAR(200) NOT NULL,
    code VARCHAR(20) UNIQUE NOT NULL,
    adresse TEXT,
    ville VARCHAR(100)
);

CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE module (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE site (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    code VARCHAR(20) UNIQUE NOT NULL,
    adresse TEXT,
    ville VARCHAR(100),
    societe_id INTEGER REFERENCES societe(id) ON DELETE CASCADE
);

CREATE TABLE utilisateur (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    telephone VARCHAR(20),
    site_id INTEGER REFERENCES site(id) ON DELETE SET NULL
);

CREATE TABLE super_admin (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) UNIQUE NOT NULL,
    mdp VARCHAR(255) NOT NULL
);

CREATE TABLE fonctionnalite (
    id SERIAL PRIMARY KEY,
    module_id INTEGER REFERENCES module(id) ON DELETE CASCADE,
    code VARCHAR(50) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    UNIQUE(module_id, code)
);

CREATE TABLE permission (
    id SERIAL PRIMARY KEY,
    fonctionnalite_id INTEGER REFERENCES fonctionnalite(id) ON DELETE CASCADE,
    code VARCHAR(50) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    UNIQUE(fonctionnalite_id, code)
);

CREATE TABLE role_permission (
    id SERIAL PRIMARY KEY,
    role_id INTEGER REFERENCES role(id) ON DELETE CASCADE,
    permission_id INTEGER REFERENCES permission(id) ON DELETE CASCADE,
    UNIQUE(role_id, permission_id)
);

CREATE TABLE depot (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    code VARCHAR(20) UNIQUE NOT NULL,
    site_id INTEGER REFERENCES site(id) ON DELETE CASCADE
);

CREATE TABLE utilisateur_depot (
    id SERIAL PRIMARY KEY,
    utilisateur_id INTEGER REFERENCES utilisateur(id) ON DELETE CASCADE,
    depot_id INTEGER REFERENCES depot(id) ON DELETE CASCADE,
    role_id INTEGER REFERENCES role(id) ON DELETE CASCADE,
    UNIQUE(utilisateur_id, depot_id, role_id)
);

CREATE TABLE delegation_temporaire (
    id SERIAL PRIMARY KEY,
    delegant_user_id INTEGER REFERENCES utilisateur(id) ON DELETE CASCADE,
    delegataire_user_id INTEGER REFERENCES utilisateur(id) ON DELETE CASCADE,
    role_id INTEGER REFERENCES role(id) ON DELETE CASCADE,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL
    -- CHECK (date_debut < date_fin) supprimé
);

CREATE TABLE emplacement (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    depot_id INTEGER REFERENCES depot(id) ON DELETE CASCADE,
    UNIQUE(depot_id, code)
);

-- ============================================
-- 2. MODULE RÉFÉRENTIELS (MASTERS)
-- ============================================
CREATE TABLE unite_mesure (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE devise (
    id SERIAL PRIMARY KEY,
    code VARCHAR(3) UNIQUE NOT NULL,
    nom VARCHAR(50) NOT NULL
);

CREATE TABLE taux_change (
    id SERIAL PRIMARY KEY,
    devise_from_id INTEGER REFERENCES devise(id) ON DELETE CASCADE,
    devise_to_id INTEGER REFERENCES devise(id) ON DELETE CASCADE,
    taux DECIMAL(10,6) NOT NULL,
    date_application DATE NOT NULL,
    UNIQUE(devise_from_id, devise_to_id, date_application)
);

CREATE TABLE mode_paiement (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE type_client (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    typeclient_id INTEGER REFERENCES type_client(id) ON DELETE SET NULL,
    raison_sociale VARCHAR(200) NOT NULL,
    telephone VARCHAR(20),
    email VARCHAR(255),
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE fournisseur (
    id SERIAL PRIMARY KEY,
    raison_sociale VARCHAR(200) NOT NULL,
    nif_stat VARCHAR(20) NOT NULL,
    telephone VARCHAR(20) NOT NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categorie_article (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL,
    methode_gestion_id INTEGER REFERENCES methode_gestion(id) ON DELETE SET NULL
);

CREATE TABLE article (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(50) UNIQUE NOT NULL,
    designation VARCHAR(200) NOT NULL,
    description TEXT,
    categorie_article_id INTEGER REFERENCES categorie_article(id) ON DELETE SET NULL,
    unite_mesure_stock_id INTEGER REFERENCES unite_mesure(id) ON DELETE SET NULL,
    unite_mesure_achat_id INTEGER REFERENCES unite_mesure(id) ON DELETE SET NULL,
    unite_mesure_vente_id INTEGER REFERENCES unite_mesure(id) ON DELETE SET NULL,
    est_actif BOOLEAN DEFAULT TRUE,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tarif (
    id SERIAL PRIMARY KEY,
    article_id INTEGER REFERENCES article(id) ON DELETE CASCADE,
    typeclient_id INTEGER REFERENCES type_client(id) ON DELETE CASCADE,
    site_id INTEGER REFERENCES site(id) ON DELETE CASCADE,
    prix DECIMAL(12,2) NOT NULL,
    devise_id INTEGER REFERENCES devise(id),
    date_debut DATE NOT NULL,
    date_fin DATE,
    UNIQUE(article_id, typeclient_id, site_id, date_debut)
);

CREATE TABLE regle_remise (
    id SERIAL PRIMARY KEY,
    article_id INTEGER REFERENCES article(id) ON DELETE CASCADE,
    type_client_id INTEGER REFERENCES type_client(id) ON DELETE CASCADE,
    seuil_min_quantite DECIMAL(10,3) DEFAULT 0,
    seuil_min_montant DECIMAL(12,2) DEFAULT 0,
    remise_pourcentage DECIMAL(5,2) NOT NULL,
    date_debut DATE NOT NULL,
    date_fin DATE
    -- Tous les CHECK supprimés
);

-- ============================================
-- 3. MODULE ACHATS
-- ============================================

CREATE TABLE departement (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE demande_achat (
    id SERIAL PRIMARY KEY,
    numero_da VARCHAR(50) UNIQUE NOT NULL,
    date_demande DATE NOT NULL DEFAULT CURRENT_DATE,
    departement_id INTEGER REFERENCES departement(id) ON DELETE SET NULL,
    site_id INTEGER REFERENCES site(id) ON DELETE SET NULL,
    status VARCHAR(20) DEFAULT 'BROUILLON',
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ligne_demande_achat (
    id SERIAL PRIMARY KEY,
    demande_achat_id INTEGER REFERENCES demande_achat(id) ON DELETE CASCADE,
    article_id INTEGER REFERENCES article(id) ON DELETE SET NULL,
    designation VARCHAR(200),
    quantite DECIMAL(10,3) NOT NULL
    -- CHECK supprimé
);

CREATE TABLE proforma_fournisseur (
    id SERIAL PRIMARY KEY,
    fournisseur_id INTEGER REFERENCES fournisseur(id) ON DELETE CASCADE,
    demande_achat_id INTEGER REFERENCES demande_achat(id) ON DELETE CASCADE,
    numero_proforma VARCHAR(100) NOT NULL,
    date_proforma DATE NOT NULL,
    duree_validite INTEGER NOT NULL,
    devise_id INTEGER REFERENCES devise(id),
    date_reception TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ligne_proforma_fournisseur (
    id SERIAL PRIMARY KEY,
    proforma_fournisseur_id INTEGER REFERENCES proforma_fournisseur(id) ON DELETE CASCADE,
    ligne_demande_achat_id INTEGER REFERENCES ligne_demande_achat(id) ON DELETE CASCADE,
    prix_unitaire DECIMAL(12,2) NOT NULL,
    remise DECIMAL(5,2) DEFAULT 0
);

CREATE TABLE bon_commande (
    id SERIAL PRIMARY KEY,
    numero_bc VARCHAR(50) UNIQUE NOT NULL,
    proforma_fournisseur_id INTEGER REFERENCES proforma_fournisseur(id),
    date_emission DATE NOT NULL DEFAULT CURRENT_DATE,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ligne_bon_commande (
    id SERIAL PRIMARY KEY,
    bon_commande_id INTEGER REFERENCES bon_commande(id) ON DELETE CASCADE,
    ligne_proforma_fournisseur_id INTEGER REFERENCES ligne_proforma_fournisseur(id),
    quantite_commandee DECIMAL(10,3) NOT NULL
);

-- ============================================
-- 4. MODULE STOCK & RÉCEPTIONS
-- ============================================

CREATE TABLE type_mouvement (
    id SERIAL PRIMARY KEY,
    code VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE lot (
    id SERIAL PRIMARY KEY,
    numero_lot VARCHAR(100) NOT NULL,
    article_id INTEGER REFERENCES article(id) ON DELETE CASCADE,
    date_expiration DATE,
    quantite_disponible DECIMAL(10,3) DEFAULT 0,
    statut VARCHAR(20) DEFAULT 'DISPONIBLE',
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(numero_lot, article_id)
);

CREATE TABLE bon_reception (
    id SERIAL PRIMARY KEY,
    numero_br VARCHAR(50) UNIQUE NOT NULL,
    bon_commande_id INTEGER REFERENCES bon_commande(id) ON DELETE SET NULL,
    date_reception DATE NOT NULL DEFAULT CURRENT_DATE,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ligne_bon_reception (
    id SERIAL PRIMARY KEY,
    bon_reception_id INTEGER REFERENCES bon_reception(id) ON DELETE CASCADE,
    ligne_bon_commande_id INTEGER REFERENCES ligne_bon_commande(id) ON DELETE SET NULL,
    quantite_recue DECIMAL(10,3) NOT NULL,
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    emplacement_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL
);

CREATE TABLE mouvement_stock (
    id SERIAL PRIMARY KEY,
    date_heure TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    utilisateur_id INTEGER REFERENCES utilisateur(id) ON DELETE SET NULL,
    type_mouvement_id INTEGER REFERENCES type_mouvement(id),
    article_id INTEGER REFERENCES article(id),
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    quantite DECIMAL(10,3) NOT NULL,
    emplacement_source_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL,
    emplacement_destination_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL
);

CREATE TABLE transfert_inter_depot (
    id SERIAL PRIMARY KEY,
    depot_source_id INTEGER REFERENCES depot(id),
    depot_destination_id INTEGER REFERENCES depot(id),
    date DATE NOT NULL DEFAULT CURRENT_DATE,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    -- CHECK supprimé
);

CREATE TABLE ligne_transfert (
    id SERIAL PRIMARY KEY,
    transfert_inter_depot_id INTEGER REFERENCES transfert_inter_depot(id) ON DELETE CASCADE,
    article_id INTEGER REFERENCES article(id),
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    quantite DECIMAL(10,3) NOT NULL
);

CREATE TABLE inventaire_physique (
    id SERIAL PRIMARY KEY,
    depot_id INTEGER REFERENCES depot(id) ON DELETE CASCADE,
    date_inventaire DATE NOT NULL DEFAULT CURRENT_DATE,
    statut VARCHAR(20) DEFAULT 'PLANIFIE',
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ligne_inventaire (
    id SERIAL PRIMARY KEY,
    inventaire_id INTEGER REFERENCES inventaire_physique(id) ON DELETE CASCADE,
    article_id INTEGER REFERENCES article(id),
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    emplacement_id INTEGER REFERENCES emplacement(id),
    quantite_theorique DECIMAL(10,3) NOT NULL,
    quantite_physique DECIMAL(10,3),
    ecart DECIMAL(10,3),
    date_saisie TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(inventaire_id, article_id, lot_id, emplacement_id)
);

CREATE TABLE ajustement_stock (
    id SERIAL PRIMARY KEY,
    numero_ajustement VARCHAR(50) UNIQUE NOT NULL,
    inventaire_id INTEGER REFERENCES inventaire_physique(id) ON DELETE SET NULL,
    article_id INTEGER REFERENCES article(id),
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    emplacement_id INTEGER REFERENCES emplacement(id),
    quantite_theorique DECIMAL(10,3) NOT NULL,
    quantite_reelle DECIMAL(10,3) NOT NULL,
    ecart DECIMAL(10,3),
    type_ajustement VARCHAR(10) NOT NULL,
    date DATE NOT NULL DEFAULT CURRENT_DATE,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE emplacement_stock (
    id SERIAL PRIMARY KEY,
    article_id INTEGER REFERENCES article(id) ON DELETE CASCADE,
    lot_id INTEGER REFERENCES lot(id) ON DELETE CASCADE,
    emplacement_id INTEGER REFERENCES emplacement(id) ON DELETE CASCADE,
    quantite DECIMAL(10,3) NOT NULL DEFAULT 0,
    unite_mesure_id INTEGER REFERENCES unite_mesure(id),
    date_dernier_mouvement TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valeur_stock_ht DECIMAL(12,2) DEFAULT 0,
    UNIQUE(article_id, lot_id, emplacement_id)
);

CREATE TABLE reservation_stock (
    id SERIAL PRIMARY KEY,
    commande_client_id INTEGER REFERENCES commande_client(id) ON DELETE CASCADE,
    article_id INTEGER REFERENCES article(id),
    lot_id INTEGER REFERENCES lot(id),
    quantite_reservee DECIMAL(10,3) NOT NULL,
    date_reservation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ============================================
-- 5. MODULE VENTES
-- ============================================

CREATE TABLE proforma_client (
    id SERIAL PRIMARY KEY,
    numero_proforma VARCHAR(50) UNIQUE NOT NULL,
    client_id INTEGER REFERENCES client(id),
    date DATE NOT NULL DEFAULT CURRENT_DATE,
    devise_id INTEGER REFERENCES devise(id),
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ligne_proforma_client (
    id SERIAL PRIMARY KEY,
    proforma_client_id INTEGER REFERENCES proforma_client(id) ON DELETE CASCADE,
    article_id INTEGER REFERENCES article(id),
    quantite DECIMAL(10,3) NOT NULL,
    prix DECIMAL(12,2) NOT NULL
);

CREATE TABLE commande_client (
    id SERIAL PRIMARY KEY,
    numero_commande VARCHAR(50) UNIQUE NOT NULL,
    proforma_client_id INTEGER REFERENCES proforma_client(id) ON DELETE SET NULL,
    date_commande DATE NOT NULL DEFAULT CURRENT_DATE,
    depot_id INTEGER REFERENCES depot(id) ON DELETE SET NULL,
    mode_paiement_id INTEGER REFERENCES mode_paiement(id) ON DELETE SET NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ligne_commande_client (
    id SERIAL PRIMARY KEY,
    commande_client_id INTEGER REFERENCES commande_client(id) ON DELETE CASCADE,
    ligne_proforma_client_id INTEGER REFERENCES ligne_proforma_client(id),
    quantite_livree DECIMAL(10,3) DEFAULT 0
);

CREATE TABLE bon_livraison (
    id SERIAL PRIMARY KEY,
    numero_bl VARCHAR(50) UNIQUE NOT NULL,
    commande_client_id INTEGER REFERENCES commande_client(id),
    date_livraison DATE NOT NULL DEFAULT CURRENT_DATE,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ligne_bon_livraison (
    id SERIAL PRIMARY KEY,
    bon_livraison_id INTEGER REFERENCES bon_livraison(id) ON DELETE CASCADE,
    ligne_commande_client_id INTEGER REFERENCES ligne_commande_client(id) ON DELETE SET NULL,
    lot_id INTEGER REFERENCES lot(id),
    quantite_livree DECIMAL(10,3) NOT NULL,
    emplacement_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL
);

-- ============================================
-- 6. MODULE FACTURATION & COMPTABILITÉ
-- ============================================

CREATE TABLE facture_fournisseur (
    id SERIAL PRIMARY KEY,
    numero_facture_fournisseur VARCHAR(100) NOT NULL,
    bon_reception_id INTEGER REFERENCES bon_reception(id) ON DELETE SET NULL,
    date_facture DATE NOT NULL,
    montant DECIMAL(12,2) NOT NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(numero_facture_fournisseur, bon_reception_id)
);

CREATE TABLE facture_client (
    id SERIAL PRIMARY KEY,
    numero_facture_client VARCHAR(50) UNIQUE NOT NULL,
    bon_livraison_id INTEGER REFERENCES bon_livraison(id) ON DELETE SET NULL,
    date_facture DATE NOT NULL,
    montant DECIMAL(12,2) NOT NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE paiement_fournisseur (
    id SERIAL PRIMARY KEY,
    numero_paiement VARCHAR(50) UNIQUE NOT NULL,
    facture_fournisseur_id INTEGER REFERENCES facture_fournisseur(id),
    date_paiement DATE NOT NULL DEFAULT CURRENT_DATE,
    mode_paiement_id INTEGER REFERENCES mode_paiement(id) ON DELETE SET NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE encaissement_client (
    id SERIAL PRIMARY KEY,
    numero_encaissement VARCHAR(50) UNIQUE NOT NULL,
    facture_client_id INTEGER REFERENCES facture_client(id),
    date_encaissement DATE NOT NULL DEFAULT CURRENT_DATE,
    mode_paiement_id INTEGER REFERENCES mode_paiement(id) ON DELETE SET NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE acompte (
    id SERIAL PRIMARY KEY,
    client_id INTEGER REFERENCES client(id) ON DELETE SET NULL,
    fournisseur_id INTEGER REFERENCES fournisseur(id) ON DELETE SET NULL,
    date_acompte DATE NOT NULL DEFAULT CURRENT_DATE,
    montant DECIMAL(12,2) NOT NULL,
    impute_sur_facture_id INTEGER,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    -- CHECK supprimé
);