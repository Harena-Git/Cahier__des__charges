-- ============================================================
-- BASE DE DONNÉES POSTGRESQL - GESTION ENTREPRISE
-- Généré le 18 janvier 2026
-- ============================================================

-- Suppression des tables dans l'ordre inverse des dépendances
DROP TABLE IF EXISTS acompte CASCADE;
DROP TABLE IF EXISTS encaissement_client CASCADE;
DROP TABLE IF EXISTS paiement_fournisseur CASCADE;
DROP TABLE IF EXISTS facture_client CASCADE;
DROP TABLE IF EXISTS facture_fournisseur CASCADE;
DROP TABLE IF EXISTS ligne_bon_livraison CASCADE;
DROP TABLE IF EXISTS bon_livraison CASCADE;
DROP TABLE IF EXISTS ligne_commande_client CASCADE;
DROP TABLE IF EXISTS commande_client CASCADE;
DROP TABLE IF EXISTS ligne_proforma_client CASCADE;
DROP TABLE IF EXISTS proforma_client CASCADE;
DROP TABLE IF EXISTS emplacement_stock CASCADE;
DROP TABLE IF EXISTS ajustement_stock CASCADE;
DROP TABLE IF EXISTS ligne_inventaire CASCADE;
DROP TABLE IF EXISTS inventaire_physique CASCADE;
DROP TABLE IF EXISTS reservation_stock CASCADE;
DROP TABLE IF EXISTS ligne_transfert CASCADE;
DROP TABLE IF EXISTS transfert_inter_depot CASCADE;
DROP TABLE IF EXISTS mouvement_stock CASCADE;
DROP TABLE IF EXISTS type_mouvement CASCADE;
DROP TABLE IF EXISTS lot CASCADE;
DROP TABLE IF EXISTS ligne_bon_reception CASCADE;
DROP TABLE IF EXISTS bon_reception CASCADE;
DROP TABLE IF EXISTS ligne_bon_commande CASCADE;
DROP TABLE IF EXISTS bon_commande CASCADE;
DROP TABLE IF EXISTS ligne_proforma_fournisseur CASCADE;
DROP TABLE IF EXISTS proforma_fournisseur CASCADE;
DROP TABLE IF EXISTS ligne_demande_achat CASCADE;
DROP TABLE IF EXISTS demande_achat CASCADE;
DROP TABLE IF EXISTS departement CASCADE;
DROP TABLE IF EXISTS taux_change CASCADE;
DROP TABLE IF EXISTS mode_paiement CASCADE;
DROP TABLE IF EXISTS devise CASCADE;
DROP TABLE IF EXISTS client CASCADE;
DROP TABLE IF EXISTS type_client CASCADE;
DROP TABLE IF EXISTS fournisseur CASCADE;
DROP TABLE IF EXISTS regle_remise CASCADE;
DROP TABLE IF EXISTS tarif CASCADE;
DROP TABLE IF EXISTS article CASCADE;
DROP TABLE IF EXISTS unite_mesure CASCADE;
DROP TABLE IF EXISTS categorie_article CASCADE;
DROP TABLE IF EXISTS methode_gestion CASCADE;
DROP TABLE IF EXISTS emplacement CASCADE;
DROP TABLE IF EXISTS utilisateur_depot CASCADE;
DROP TABLE IF EXISTS depot CASCADE;
DROP TABLE IF EXISTS site CASCADE;
DROP TABLE IF EXISTS societe CASCADE;
DROP TABLE IF EXISTS ville CASCADE;
DROP TABLE IF EXISTS delegation_temporaire CASCADE;
DROP TABLE IF EXISTS role_permission CASCADE;
DROP TABLE IF EXISTS permission CASCADE;
DROP TABLE IF EXISTS fonctionnalite CASCADE;
DROP TABLE IF EXISTS module CASCADE;
DROP TABLE IF EXISTS utilisateur CASCADE;
DROP TABLE IF EXISTS role CASCADE;

-- ============================================================
-- 1. ADMINISTRATION & GESTION DES ACCÈS
-- ============================================================

-- Table Role
CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    nom VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Module
CREATE TABLE module (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,  -- Ex: "ACHAT", "VENTE", "STOCK", "ADMIN"
    nom VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Fonctionnalite
CREATE TABLE fonctionnalite (
    id SERIAL PRIMARY KEY,
    module_id INTEGER NOT NULL REFERENCES module(id) ON DELETE CASCADE,
    code VARCHAR(100) NOT NULL UNIQUE,  -- ex: "DEMANDE_ACHAT", "BON_COMMANDE", "PROFORMA_FOURNISSEUR"
    nom VARCHAR(200) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Permission
CREATE TABLE permission (
    id SERIAL PRIMARY KEY,
    fonctionnalite_id INTEGER NOT NULL REFERENCES fonctionnalite(id) ON DELETE CASCADE,
    code VARCHAR(100) NOT NULL UNIQUE,
    nom VARCHAR(200) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table RolePermission
CREATE TABLE role_permission (
    id SERIAL PRIMARY KEY,
    role_id INTEGER NOT NULL REFERENCES role(id) ON DELETE CASCADE,
    permission_id INTEGER NOT NULL REFERENCES permission(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(role_id, permission_id)
);

-- Table Ville
CREATE TABLE ville (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Societe
CREATE TABLE societe (
    id SERIAL PRIMARY KEY,
    raison_sociale VARCHAR(200) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    adresse TEXT,
    ville_id INTEGER REFERENCES ville(id) ON DELETE SET NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Site
CREATE TABLE site (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    adresse TEXT,
    ville_id INTEGER REFERENCES ville(id) ON DELETE SET NULL,
    societe_id INTEGER NOT NULL REFERENCES societe(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Utilisateur
CREATE TABLE utilisateur (
    id SERIAL PRIMARY KEY,
    email VARCHAR(150) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(255) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    telephone VARCHAR(30),
    site_id INTEGER REFERENCES site(id) ON DELETE SET NULL,
    est_actif BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table DelegationTemporaire
CREATE TABLE delegation_temporaire (
    id SERIAL PRIMARY KEY,
    delegant_user_id INTEGER NOT NULL REFERENCES utilisateur(id) ON DELETE CASCADE,  -- Celui qui donne ses droits
    delegataire_user_id INTEGER NOT NULL REFERENCES utilisateur(id) ON DELETE CASCADE,  -- Celui qui reçoit les droits
    role_id INTEGER REFERENCES role(id) ON DELETE CASCADE,  -- Rôle délégué (optionnel)
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (date_fin >= date_debut)
);

-- Table Depot
CREATE TABLE depot (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    site_id INTEGER NOT NULL REFERENCES site(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table UtilisateurDepot
CREATE TABLE utilisateur_depot (
    id SERIAL PRIMARY KEY,
    utilisateur_id INTEGER NOT NULL REFERENCES utilisateur(id) ON DELETE CASCADE,
    depot_id INTEGER NOT NULL REFERENCES depot(id) ON DELETE CASCADE,
    role_id INTEGER REFERENCES role(id) ON DELETE SET NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(utilisateur_id, depot_id)
);

-- Table Emplacement
CREATE TABLE emplacement (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    depot_id INTEGER NOT NULL REFERENCES depot(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(code, depot_id)
);

-- ============================================================
-- 2. RÉFÉRENTIELS (MASTERS)
-- ============================================================

-- Table MethodeGestion
CREATE TABLE methode_gestion (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,  -- 'FIFO', 'CUMP', 'FEFO', 'LIFO'
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table CategorieArticle
CREATE TABLE categorie_article (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,  -- ex: 'MATIERE_PREMIERE', 'PRODUIT_FINI'
    nom VARCHAR(100) NOT NULL,
    methode_gestion_id INTEGER REFERENCES methode_gestion(id) ON DELETE SET NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table UniteMesure
CREATE TABLE unite_mesure (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    nom VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Article
CREATE TABLE article (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(100) NOT NULL UNIQUE,
    designation VARCHAR(250) NOT NULL,
    description TEXT,
    categorie_article_id INTEGER REFERENCES categorie_article(id) ON DELETE SET NULL,
    unite_mesure_stock_id INTEGER REFERENCES unite_mesure(id) ON DELETE SET NULL,  -- Unité de gestion en stock (ex: PIECE)
    unite_mesure_achat_id INTEGER REFERENCES unite_mesure(id) ON DELETE SET NULL,  -- Unité d'achat (ex: CARTON = 10 pièces)
    unite_mesure_vente_id INTEGER REFERENCES unite_mesure(id) ON DELETE SET NULL,  -- Unité de vente
    est_actif BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Devise
CREATE TABLE devise (
    id SERIAL PRIMARY KEY,
    code VARCHAR(10) NOT NULL UNIQUE,  -- Ex: "EUR", "USD", "XOF", "MGA"
    nom VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table TypeClient
CREATE TABLE type_client (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Tarif
CREATE TABLE tarif (
    id SERIAL PRIMARY KEY,
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    type_client_id INTEGER REFERENCES type_client(id) ON DELETE SET NULL,  -- NULL = tarif général
    site_id INTEGER REFERENCES site(id) ON DELETE SET NULL,  -- NULL = tous sites
    prix DECIMAL(18, 2) NOT NULL,
    devise_id INTEGER NOT NULL REFERENCES devise(id) ON DELETE RESTRICT,
    date_debut DATE NOT NULL,
    date_fin DATE,  -- NULL = pas de date de fin (valide indéfiniment)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table RegleRemise
CREATE TABLE regle_remise (
    id SERIAL PRIMARY KEY,
    article_id INTEGER REFERENCES article(id) ON DELETE CASCADE,  -- NULL si règle sur tout le panier
    type_client_id INTEGER REFERENCES type_client(id) ON DELETE SET NULL,  -- NULL si règle générale
    seuil_min_quantite DECIMAL(18, 4),  -- Seuil quantité
    seuil_min_montant DECIMAL(18, 2),  -- Seuil montant HT
    remise_pourcentage DECIMAL(5, 2) NOT NULL,
    date_debut DATE NOT NULL,
    date_fin DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Fournisseur
CREATE TABLE fournisseur (
    id SERIAL PRIMARY KEY,
    raison_sociale VARCHAR(200) NOT NULL,
    nif VARCHAR(50),
    stat VARCHAR(50),
    telephone VARCHAR(30),
    email VARCHAR(150),
    adresse TEXT,
    est_actif BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Client
CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    type_client_id INTEGER REFERENCES type_client(id) ON DELETE SET NULL,
    raison_sociale VARCHAR(200) NOT NULL,
    telephone VARCHAR(30),
    email VARCHAR(150),
    adresse TEXT,
    est_actif BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table TauxChange
CREATE TABLE taux_change (
    id SERIAL PRIMARY KEY,
    devise_from_id INTEGER NOT NULL REFERENCES devise(id) ON DELETE CASCADE,
    devise_to_id INTEGER NOT NULL REFERENCES devise(id) ON DELETE CASCADE,
    taux DECIMAL(18, 6) NOT NULL,
    date_application DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table ModePaiement
CREATE TABLE mode_paiement (
    id SERIAL PRIMARY KEY,
    code VARCHAR(30) NOT NULL UNIQUE,  -- Ex: "VIREMENT", "CHEQUE", "CARTE", "ESPECES"
    nom VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- 3. ACHATS
-- ============================================================

-- Table Departement
CREATE TABLE departement (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table DemandeAchat
CREATE TABLE demande_achat (
    id SERIAL PRIMARY KEY,
    numero_da VARCHAR(50) NOT NULL UNIQUE,  -- Numéro unique auto-généré (ex: DA-2025-001)
    date_demande DATE NOT NULL DEFAULT CURRENT_DATE,
    departement_id INTEGER REFERENCES departement(id) ON DELETE SET NULL,
    site_id INTEGER REFERENCES site(id) ON DELETE SET NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'BROUILLON',  -- BROUILLON, EN_ATTENTE, VALIDEE, REFUSEE, CLOTUREE
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table LigneDemandeAchat
CREATE TABLE ligne_demande_achat (
    id SERIAL PRIMARY KEY,
    demande_achat_id INTEGER NOT NULL REFERENCES demande_achat(id) ON DELETE CASCADE,
    article_id INTEGER REFERENCES article(id) ON DELETE SET NULL,  -- OPTION A : Article métier
    designation VARCHAR(250),  -- OPTION B : Achat support (ex: "Bureau métal 160cm")
    quantite DECIMAL(18, 4) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table ProformaFournisseur
CREATE TABLE proforma_fournisseur (
    id SERIAL PRIMARY KEY,
    fournisseur_id INTEGER NOT NULL REFERENCES fournisseur(id) ON DELETE CASCADE,
    demande_achat_id INTEGER REFERENCES demande_achat(id) ON DELETE SET NULL,
    numero_proforma VARCHAR(100) NOT NULL,
    date_proforma DATE NOT NULL,
    duree_validite INTEGER,  -- En jours
    devise_id INTEGER NOT NULL REFERENCES devise(id) ON DELETE RESTRICT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table LigneProformaFournisseur
CREATE TABLE ligne_proforma_fournisseur (
    id SERIAL PRIMARY KEY,
    proforma_fournisseur_id INTEGER NOT NULL REFERENCES proforma_fournisseur(id) ON DELETE CASCADE,
    ligne_demande_achat_id INTEGER REFERENCES ligne_demande_achat(id) ON DELETE SET NULL,
    prix_unitaire DECIMAL(18, 2) NOT NULL,
    remise DECIMAL(5, 2) DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table BonCommande
CREATE TABLE bon_commande (
    id SERIAL PRIMARY KEY,
    numero_bc VARCHAR(50) NOT NULL UNIQUE,  -- Numéro unique auto (ex: BC-2025-001)
    proforma_fournisseur_id INTEGER NOT NULL REFERENCES proforma_fournisseur(id) ON DELETE RESTRICT,
    date_emission DATE NOT NULL DEFAULT CURRENT_DATE,
    status VARCHAR(30) NOT NULL DEFAULT 'EMIS',  -- EMIS, PARTIELLEMENT_RECU, RECU, ANNULE
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table LigneBonCommande
CREATE TABLE ligne_bon_commande (
    id SERIAL PRIMARY KEY,
    bon_commande_id INTEGER NOT NULL REFERENCES bon_commande(id) ON DELETE CASCADE,
    ligne_proforma_fournisseur_id INTEGER NOT NULL REFERENCES ligne_proforma_fournisseur(id) ON DELETE RESTRICT,
    quantite_commandee DECIMAL(18, 4) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- 4. STOCK & RÉCEPTIONS
-- ============================================================

-- Table BonReception
CREATE TABLE bon_reception (
    id SERIAL PRIMARY KEY,
    numero_br VARCHAR(50) NOT NULL UNIQUE,  -- Auto-généré (ex: BR-2025-001)
    bon_commande_id INTEGER REFERENCES bon_commande(id) ON DELETE SET NULL,  -- Peut être NULL
    date_reception DATE NOT NULL DEFAULT CURRENT_DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Lot
CREATE TABLE lot (
    id SERIAL PRIMARY KEY,
    numero_lot VARCHAR(100) NOT NULL,
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    date_expiration DATE,  -- DLC/DLUO
    quantite_disponible DECIMAL(18, 4) NOT NULL DEFAULT 0,
    statut VARCHAR(30) NOT NULL DEFAULT 'DISPONIBLE',  -- 'DISPONIBLE', 'BLOQUE', 'PERIME', 'EPUISE'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(numero_lot, article_id)
);

-- Table LigneBonReception
CREATE TABLE ligne_bon_reception (
    id SERIAL PRIMARY KEY,
    bon_reception_id INTEGER NOT NULL REFERENCES bon_reception(id) ON DELETE CASCADE,
    ligne_bon_commande_id INTEGER REFERENCES ligne_bon_commande(id) ON DELETE SET NULL,
    quantite_recue DECIMAL(18, 4) NOT NULL,
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,  -- Lot créé ou associé
    emplacement_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL,  -- Où ranger
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table TypeMouvement
CREATE TABLE type_mouvement (
    id SERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,  -- ex: "ENTREE", "SORTIE", "TRANSFERT_ENTRANT", "TRANSFERT_SORTANT", "AJUSTEMENT_POS", "AJUSTEMENT_NEG"
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table MouvementStock
CREATE TABLE mouvement_stock (
    id SERIAL PRIMARY KEY,
    date_heure TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    utilisateur_id INTEGER REFERENCES utilisateur(id) ON DELETE SET NULL,
    type_mouvement_id INTEGER NOT NULL REFERENCES type_mouvement(id) ON DELETE RESTRICT,
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,  -- NULL si pas de traçabilité lot
    quantite DECIMAL(18, 4) NOT NULL,
    emplacement_source_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL,  -- NULL pour entrée
    emplacement_destination_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL,  -- NULL pour sortie
    reference_document VARCHAR(100),  -- Référence du document source (BR, BL, etc.)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table TransfertInterDepot
CREATE TABLE transfert_inter_depot (
    id SERIAL PRIMARY KEY,
    depot_source_id INTEGER NOT NULL REFERENCES depot(id) ON DELETE RESTRICT,
    depot_destination_id INTEGER NOT NULL REFERENCES depot(id) ON DELETE RESTRICT,
    date_transfert DATE NOT NULL DEFAULT CURRENT_DATE,
    status VARCHAR(30) NOT NULL DEFAULT 'EN_COURS',  -- EN_COURS, VALIDE, ANNULE
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table LigneTransfert
CREATE TABLE ligne_transfert (
    id SERIAL PRIMARY KEY,
    transfert_inter_depot_id INTEGER NOT NULL REFERENCES transfert_inter_depot(id) ON DELETE CASCADE,
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    quantite DECIMAL(18, 4) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table InventairePhysique
CREATE TABLE inventaire_physique (
    id SERIAL PRIMARY KEY,
    depot_id INTEGER NOT NULL REFERENCES depot(id) ON DELETE CASCADE,
    date_inventaire DATE NOT NULL,
    statut VARCHAR(30) NOT NULL DEFAULT 'PLANIFIE',  -- "PLANIFIE", "EN_COURS", "CLOTURE", "AJUSTE"
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table LigneInventaire
CREATE TABLE ligne_inventaire (
    id SERIAL PRIMARY KEY,
    inventaire_id INTEGER NOT NULL REFERENCES inventaire_physique(id) ON DELETE CASCADE,
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    emplacement_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL,
    quantite_theorique DECIMAL(18, 4) NOT NULL DEFAULT 0,
    quantite_physique DECIMAL(18, 4),
    ecart DECIMAL(18, 4),
    date_saisie DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table AjustementStock
CREATE TABLE ajustement_stock (
    id SERIAL PRIMARY KEY,
    numero_ajustement VARCHAR(50) NOT NULL UNIQUE,  -- Auto-généré
    inventaire_id INTEGER REFERENCES inventaire_physique(id) ON DELETE SET NULL,  -- NULL si ajustement hors inventaire
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    emplacement_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL,
    quantite_theorique DECIMAL(18, 4) NOT NULL,
    quantite_reelle DECIMAL(18, 4) NOT NULL,
    ecart DECIMAL(18, 4) NOT NULL,
    type_ajustement VARCHAR(20) NOT NULL,  -- "POSITIF", "NEGATIF"
    date_ajustement DATE NOT NULL DEFAULT CURRENT_DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table EmplacementStock (stock par emplacement)
CREATE TABLE emplacement_stock (
    id SERIAL PRIMARY KEY,
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    emplacement_id INTEGER NOT NULL REFERENCES emplacement(id) ON DELETE CASCADE,
    quantite DECIMAL(18, 4) NOT NULL DEFAULT 0,
    unite_mesure_id INTEGER REFERENCES unite_mesure(id) ON DELETE SET NULL,
    date_dernier_mouvement TIMESTAMP,
    valeur_stock_ht DECIMAL(18, 2) DEFAULT 0,  -- Coût total (quantité * CUMP ou dernier coût)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(article_id, lot_id, emplacement_id)
);

-- ============================================================
-- 5. VENTES
-- ============================================================

-- Table ProformaClient
CREATE TABLE proforma_client (
    id SERIAL PRIMARY KEY,
    numero_proforma VARCHAR(50) NOT NULL UNIQUE,  -- Auto (ex: PRO-2025-001)
    client_id INTEGER NOT NULL REFERENCES client(id) ON DELETE CASCADE,
    date_proforma DATE NOT NULL DEFAULT CURRENT_DATE,
    devise_id INTEGER NOT NULL REFERENCES devise(id) ON DELETE RESTRICT,
    statut VARCHAR(30) NOT NULL DEFAULT 'BROUILLON',  -- BROUILLON, ENVOYE, ACCEPTE, REFUSE, EXPIRE
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table LigneProformaClient
CREATE TABLE ligne_proforma_client (
    id SERIAL PRIMARY KEY,
    proforma_client_id INTEGER NOT NULL REFERENCES proforma_client(id) ON DELETE CASCADE,
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    quantite DECIMAL(18, 4) NOT NULL,
    prix_unitaire DECIMAL(18, 2) NOT NULL,
    remise DECIMAL(5, 2) DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table CommandeClient
CREATE TABLE commande_client (
    id SERIAL PRIMARY KEY,
    numero_commande VARCHAR(50) NOT NULL UNIQUE,  -- Auto (ex: CMD-2025-001)
    proforma_client_id INTEGER REFERENCES proforma_client(id) ON DELETE SET NULL,
    date_commande DATE NOT NULL DEFAULT CURRENT_DATE,
    depot_id INTEGER REFERENCES depot(id) ON DELETE SET NULL,  -- Dépôt de préparation
    mode_paiement_id INTEGER REFERENCES mode_paiement(id) ON DELETE SET NULL,
    statut VARCHAR(30) NOT NULL DEFAULT 'EN_COURS',  -- EN_COURS, PARTIELLEMENT_LIVREE, LIVREE, ANNULEE
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table ReservationStock
CREATE TABLE reservation_stock (
    id SERIAL PRIMARY KEY,
    commande_client_id INTEGER NOT NULL REFERENCES commande_client(id) ON DELETE CASCADE,
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,
    quantite_reservee DECIMAL(18, 4) NOT NULL,
    date_reservation TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table LigneCommandeClient
CREATE TABLE ligne_commande_client (
    id SERIAL PRIMARY KEY,
    commande_client_id INTEGER NOT NULL REFERENCES commande_client(id) ON DELETE CASCADE,
    ligne_proforma_client_id INTEGER REFERENCES ligne_proforma_client(id) ON DELETE SET NULL,
    article_id INTEGER NOT NULL REFERENCES article(id) ON DELETE CASCADE,
    quantite DECIMAL(18, 4) NOT NULL,
    prix_unitaire DECIMAL(18, 2) NOT NULL,
    quantite_livree DECIMAL(18, 4) NOT NULL DEFAULT 0,  -- Cumul des quantités livrées
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table BonLivraison
CREATE TABLE bon_livraison (
    id SERIAL PRIMARY KEY,
    numero_bl VARCHAR(50) NOT NULL UNIQUE,  -- Auto (ex: BL-2025-001)
    commande_client_id INTEGER NOT NULL REFERENCES commande_client(id) ON DELETE CASCADE,
    date_livraison DATE NOT NULL DEFAULT CURRENT_DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table LigneBonLivraison
CREATE TABLE ligne_bon_livraison (
    id SERIAL PRIMARY KEY,
    bon_livraison_id INTEGER NOT NULL REFERENCES bon_livraison(id) ON DELETE CASCADE,
    ligne_commande_client_id INTEGER NOT NULL REFERENCES ligne_commande_client(id) ON DELETE CASCADE,
    lot_id INTEGER REFERENCES lot(id) ON DELETE SET NULL,  -- Lot prélevé
    quantite_livree DECIMAL(18, 4) NOT NULL,
    emplacement_id INTEGER REFERENCES emplacement(id) ON DELETE SET NULL,  -- Emplacement source du prélèvement
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- 6. FACTURATION & COMPTABILITÉ
-- ============================================================

-- Table FactureFournisseur
CREATE TABLE facture_fournisseur (
    id SERIAL PRIMARY KEY,
    numero_facture_fournisseur VARCHAR(100) NOT NULL,  -- Numéro fournisseur
    fournisseur_id INTEGER NOT NULL REFERENCES fournisseur(id) ON DELETE CASCADE,
    bon_reception_id INTEGER REFERENCES bon_reception(id) ON DELETE SET NULL,  -- Optionnel
    date_facture DATE NOT NULL,
    montant_ht DECIMAL(18, 2) NOT NULL,
    montant_tva DECIMAL(18, 2) DEFAULT 0,
    montant_ttc DECIMAL(18, 2) NOT NULL,
    statut VARCHAR(30) NOT NULL DEFAULT 'A_PAYER',  -- A_PAYER, PARTIELLEMENT_PAYEE, PAYEE
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table FactureClient
CREATE TABLE facture_client (
    id SERIAL PRIMARY KEY,
    numero_facture_client VARCHAR(50) NOT NULL UNIQUE,  -- Numéro interne auto
    client_id INTEGER NOT NULL REFERENCES client(id) ON DELETE CASCADE,
    bon_livraison_id INTEGER REFERENCES bon_livraison(id) ON DELETE SET NULL,  -- Optionnel
    date_facture DATE NOT NULL DEFAULT CURRENT_DATE,
    montant_ht DECIMAL(18, 2) NOT NULL,
    montant_tva DECIMAL(18, 2) DEFAULT 0,
    montant_ttc DECIMAL(18, 2) NOT NULL,
    statut VARCHAR(30) NOT NULL DEFAULT 'A_ENCAISSER',  -- A_ENCAISSER, PARTIELLEMENT_ENCAISSEE, ENCAISSEE
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table PaiementFournisseur
CREATE TABLE paiement_fournisseur (
    id SERIAL PRIMARY KEY,
    numero_paiement VARCHAR(50) NOT NULL UNIQUE,  -- Auto (ex: PAI-F-2025-001)
    facture_fournisseur_id INTEGER NOT NULL REFERENCES facture_fournisseur(id) ON DELETE CASCADE,
    date_paiement DATE NOT NULL DEFAULT CURRENT_DATE,
    montant DECIMAL(18, 2) NOT NULL,
    mode_paiement_id INTEGER NOT NULL REFERENCES mode_paiement(id) ON DELETE RESTRICT,
    reference_paiement VARCHAR(100),  -- Référence du chèque, virement, etc.
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table EncaissementClient
CREATE TABLE encaissement_client (
    id SERIAL PRIMARY KEY,
    numero_encaissement VARCHAR(50) NOT NULL UNIQUE,  -- Auto (ex: ENC-C-2025-001)
    facture_client_id INTEGER NOT NULL REFERENCES facture_client(id) ON DELETE CASCADE,
    date_encaissement DATE NOT NULL DEFAULT CURRENT_DATE,
    montant DECIMAL(18, 2) NOT NULL,
    mode_paiement_id INTEGER NOT NULL REFERENCES mode_paiement(id) ON DELETE RESTRICT,
    reference_encaissement VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table Acompte
CREATE TABLE acompte (
    id SERIAL PRIMARY KEY,
    client_id INTEGER REFERENCES client(id) ON DELETE CASCADE,  -- NULL si fournisseur
    fournisseur_id INTEGER REFERENCES fournisseur(id) ON DELETE CASCADE,  -- NULL si client
    date_acompte DATE NOT NULL DEFAULT CURRENT_DATE,
    montant DECIMAL(18, 2) NOT NULL,
    impute_sur_facture_client_id INTEGER REFERENCES facture_client(id) ON DELETE SET NULL,
    impute_sur_facture_fournisseur_id INTEGER REFERENCES facture_fournisseur(id) ON DELETE SET NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (
        (client_id IS NOT NULL AND fournisseur_id IS NULL) OR
        (client_id IS NULL AND fournisseur_id IS NOT NULL)
    )
);

-- ============================================================
-- INDEX POUR OPTIMISATION
-- ============================================================

-- Index sur les clés étrangères fréquemment utilisées
CREATE INDEX idx_utilisateur_site ON utilisateur(site_id);
CREATE INDEX idx_site_societe ON site(societe_id);
CREATE INDEX idx_depot_site ON depot(site_id);
CREATE INDEX idx_article_categorie ON article(categorie_article_id);
CREATE INDEX idx_tarif_article ON tarif(article_id);
CREATE INDEX idx_client_type ON client(type_client_id);
CREATE INDEX idx_demande_achat_site ON demande_achat(site_id);
CREATE INDEX idx_demande_achat_status ON demande_achat(status);
CREATE INDEX idx_bon_commande_status ON bon_commande(status);
CREATE INDEX idx_lot_article ON lot(article_id);
CREATE INDEX idx_lot_statut ON lot(statut);
CREATE INDEX idx_mouvement_stock_article ON mouvement_stock(article_id);
CREATE INDEX idx_mouvement_stock_date ON mouvement_stock(date_heure);
CREATE INDEX idx_commande_client_statut ON commande_client(statut);
CREATE INDEX idx_facture_client_statut ON facture_client(statut);
CREATE INDEX idx_facture_fournisseur_statut ON facture_fournisseur(statut);

-- ============================================================
-- DONNÉES INITIALES
-- ============================================================

-- Méthodes de gestion
INSERT INTO methode_gestion (code, description) VALUES
('FIFO', 'First In First Out - Premier entré, premier sorti'),
('LIFO', 'Last In First Out - Dernier entré, premier sorti'),
('CUMP', 'Coût Unitaire Moyen Pondéré'),
('FEFO', 'First Expired First Out - Premier à expirer, premier sorti');

-- Types de mouvement
INSERT INTO type_mouvement (code, description) VALUES
('ENTREE', 'Entrée en stock'),
('SORTIE', 'Sortie de stock'),
('TRANSFERT_ENTRANT', 'Transfert entrant'),
('TRANSFERT_SORTANT', 'Transfert sortant'),
('AJUSTEMENT_POS', 'Ajustement positif'),
('AJUSTEMENT_NEG', 'Ajustement négatif');

-- Modes de paiement
INSERT INTO mode_paiement (code, nom) VALUES
('ESPECES', 'Espèces'),
('CHEQUE', 'Chèque'),
('VIREMENT', 'Virement bancaire'),
('CARTE', 'Carte bancaire'),
('MOBILE', 'Mobile Money');

-- Devises
INSERT INTO devise (code, nom) VALUES
('MGA', 'Ariary Malgache'),
('EUR', 'Euro'),
('USD', 'Dollar Américain');

-- Unités de mesure
INSERT INTO unite_mesure (code, nom) VALUES
('PCS', 'Pièce'),
('KG', 'Kilogramme'),
('L', 'Litre'),
('M', 'Mètre'),
('M2', 'Mètre carré'),
('M3', 'Mètre cube'),
('CARTON', 'Carton'),
('PAQUET', 'Paquet'),
('BOITE', 'Boîte');

-- Modules
INSERT INTO module (code, nom) VALUES
('ADMIN', 'Administration'),
('ACHAT', 'Achats'),
('VENTE', 'Ventes'),
('STOCK', 'Stock'),
('COMPTA', 'Comptabilité');

-- ============================================================
-- FIN DU SCRIPT
-- ============================================================
