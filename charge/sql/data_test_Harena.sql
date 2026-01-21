-- Données : MODULES
INSERT INTO module (id, code, nom) VALUES
(1, 'ADMIN', 'Administration & Sécurité'),
(2, 'ACHAT', 'Gestion des Achats'),
(3, 'VENTE', 'Gestion des Ventes'),
(4, 'STOCK', 'Gestion du Stock'),
(5, 'FINANCE', 'Finance & Paiements');

-- Données : RÔLES
INSERT INTO role (id, code, nom) VALUES
(1, 'ADMIN', 'Administrateur système'),
(2, 'DIRECTEUR', 'Directeur'),
(3, 'FINANCE', 'Responsable Finance'),
(4, 'ACHETEUR', 'Responsable Achat'),
(5, 'MAGASINIER', 'Magasinier'),
(6, 'RESP_STOCK', 'Responsable Stock');

-- Données : PERMISSIONS
INSERT INTO permission (id, code, description, module_id) VALUES
-- ADMIN
(1, 'USER_CREATE', 'Créer un utilisateur', 1),
(2, 'USER_UPDATE', 'Modifier un utilisateur', 1),
(3, 'ROLE_ASSIGN', 'Assigner un rôle', 1),

-- ACHATS
(4, 'DA_CREATE', 'Créer une demande d’achat', 2),
(5, 'BC_VALIDATE', 'Valider un bon de commande', 2),

-- STOCK
(6, 'STOCK_VIEW', 'Consulter le stock', 4),
(7, 'STOCK_ADJUST', 'Ajuster le stock', 4),

-- FINANCE
(8, 'PAYMENT_VALIDATE', 'Valider un paiement', 5);

-- Association RÔLES ↔ PERMISSIONS
INSERT INTO role_permission (role_id, permission_id) VALUES
-- ADMIN
(1, 1), (1, 2), (1, 3),
(1, 4), (1, 5),
(1, 6), (1, 7),
(1, 8),

-- DIRECTEUR
(2, 5), (2, 8),

-- FINANCE
(3, 8),

-- ACHETEUR
(4, 4), (4, 5),

-- MAGASINIER
(5, 6),

-- RESPONSABLE STOCK
(6, 6), (6, 7);

-- Utilisateurs de test (exemple contrôlé)
INSERT INTO utilisateur (id, email, nom, prenom, telephone, site_id, actif) VALUES
(1, 'admin@combien.local', 'Systeme', 'Admin', '0300000000', 1, true),
(2, 'finance@combien.local', 'Rakoto', 'Finance', '0300000001', 1, true),
(3, 'stock@combien.local', 'Rabe', 'Stock', '0300000002', 1, true);

-- Association UTILISATEUR ↔ RÔLE
INSERT INTO utilisateur_role (utilisateur_id, role_id) VALUES
(1, 1), -- ADMIN
(2, 3), -- FINANCE
(3, 6); -- RESPONSABLE STOCK

