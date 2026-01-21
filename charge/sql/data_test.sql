--- Référentiels de base
INSERT INTO ville (nom) VALUES
('Antananarivo'),
('Toamasina'),
('Mahajanga');

INSERT INTO devise (code, nom) VALUES
('MGA', 'Ariary');

INSERT INTO mode_paiement (code, nom) VALUES
('ESPECES', 'Paiement en espèces'),
('VIREMENT', 'Virement bancaire');

INSERT INTO methode_gestion (code) VALUES
('FIFO'),
('CUMP');

--- organisation
INSERT INTO societe (raison_sociale, code, adresse, ville)
VALUES ('COMBIEN SARL', 'COMBIEN', 'Analakely', 'Antananarivo');

INSERT INTO site (nom, code, adresse, ville, societe_id)
VALUES ('Site Tana', 'TANA', 'Ankorondrano', 'Antananarivo', 1);

INSERT INTO depot (nom, code, site_id)
VALUES ('Dépôt Central', 'DEPOT_TANA', 1);

INSERT INTO emplacement (code, depot_id)
VALUES ('RACK-A1', 1);

--- Sécurité & hiérarchie utilisateur
INSERT INTO profil_utilisateur (code, nom, niveau_hierarchique) VALUES
('MAGASINIER', 'Magasinier', 1),
('RESP_STOCK', 'Responsable Stock', 2),
('ADMIN', 'Administrateur', 3);

INSERT INTO utilisateur (email, nom, prenom, telephone, site_id) VALUES
('admin@combien.mg', 'Admin', 'System', '0340000000', 1),
('magasinier@combien.mg', 'Rakoto', 'Jean', '0321111111', 1);

INSERT INTO utilisateur_applicatif
(utilisateur_id, profil_utilisateur_id, username, mot_de_passe_hash)
VALUES
(1, 3, 'admin', 'HASH_ADMIN'),
(2, 1, 'magasinier', 'HASH_MAG');

--- Rôles & permissions (minimal)
INSERT INTO role (code, nom) VALUES
('ADMIN', 'Administrateur'),
('MAGASINIER', 'Magasinier');

INSERT INTO utilisateur_depot
(utilisateur_applicatif_id, depot_id, role_id)
VALUES
(1, 1, 1),
(2, 1, 2);

--- Articles & stock
INSERT INTO unite_mesure (code, nom) VALUES
('PCS', 'Pièce');

INSERT INTO categorie_article (code, nom, methode_gestion_id)
VALUES ('INFO', 'Informatique', 1);

INSERT INTO article
(reference, designation, categorie_article_id, unite_mesure_stock_id)
VALUES
('PC-HP-01', 'PC HP EliteBook', 1, 1);

INSERT INTO lot
(numero_lot, article_id, quantite_disponible, statut)
VALUES
('LOT-001', 1, 10, 'DISPONIBLE');

INSERT INTO type_mouvement (code)
VALUES ('ENTREE');

INSERT INTO mouvement_stock
(date_heure, utilisateur_id, type_mouvement_id, article_id, lot_id, quantite)
VALUES
(NOW(), 2, 1, 1, 1, 10);


---Client & vente
INSERT INTO type_client (nom)
VALUES ('PARTICULIER');

INSERT INTO client
(typeclient_id, raison_sociale, telephone)
VALUES
(1, 'Rakoto Client', '0332222222');

INSERT INTO proforma_client
(numero_proforma, client_id, date, devise_id)
VALUES
('PF-001', 1, CURRENT_DATE, 1);

INSERT INTO commande_client
(numero_commande, proforma_client_id, date_commande, depot_id, mode_paiement_id)
VALUES
('CMD-001', 1, CURRENT_DATE, 1, 1);


