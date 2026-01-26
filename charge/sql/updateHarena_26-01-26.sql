-- =====================================================
-- SCRIPT DE MISE À JOUR HARENA - BASE DE DONNÉES AVS_DB
-- =====================================================
-- Date: 26/01/2026
-- Auteur: Système Harena
-- Description: Ajout du champ mot_de_passe et données initiales

-- Connexion à la base de données
\c avs_db;

-- =====================================================
-- 1. MISE À JOUR DE LA TABLE UTILISATEUR
-- =====================================================

-- Ajout du champ mot_de_passe à la table utilisateur
ALTER TABLE utilisateur 
ADD COLUMN mot_de_passe VARCHAR(255) NOT NULL DEFAULT 'password123';

-- Ajout d'un commentaire pour le nouveau champ
COMMENT ON COLUMN utilisateur.mot_de_passe IS 'Mot de passe de l''utilisateur (en clair pour le moment - à hasher en production)';

-- =====================================================
-- 2. CRÉATION DES DONNÉES DE RÉFÉRENCE
-- =====================================================

-- Insertion des rôles de base si ils n'existent pas
INSERT INTO role (code, nom) VALUES 
('ADMIN', 'Administrateur'),
('USER', 'Utilisateur'),
('MANAGER', 'Gestionnaire'),
('OPERATOR', 'Opérateur')
ON CONFLICT (code) DO NOTHING;

-- Insertion des modules de base
INSERT INTO module (code, nom) VALUES 
('ADMIN', 'Administration'),
('STOCK', 'Gestion des Stocks'),
('ACHATS', 'Achats'),
('VENTES', 'Ventes'),
('FACTURATION', 'Facturation'),
('REPORTING', 'Rapports')
ON CONFLICT (code) DO NOTHING;

-- Insertion des sites par défaut
INSERT INTO site (nom, code, adresse, ville, societe_id) VALUES 
('Siège Principal', 'SIEGE', '123 Avenue Principale', 'Antananarivo', 1),
('Dépôt Nord', 'DEPOT_NORD', '456 Rue Nord', 'Antsiranana', 1),
('Dépôt Sud', 'DEPOT_SUD', '789 Boulevard Sud', 'Fianarantsoa', 1)
ON CONFLICT (code) DO NOTHING;

-- =====================================================
-- 3. CRÉATION DES UTILISATEURS PAR DÉFAUT
-- =====================================================

-- Insertion des utilisateurs de test
INSERT INTO utilisateur (email, nom, prenom, telephone, site_id, mot_de_passe) VALUES 
('admin@harena.mg', 'Rakoto', 'Admin', '+261 32 00 000 01', 1, 'admin123'),
('manager@harena.mg', 'Rabe', 'Manager', '+261 32 00 000 02', 1, 'manager123'),
('user@harena.mg', 'Randria', 'User', '+261 32 00 000 03', 2, 'user123'),
('operator@harena.mg', 'Rasoa', 'Operator', '+261 32 00 000 04', 3, 'operator123')
ON CONFLICT (email) DO NOTHING;

-- =====================================================
-- 4. CRÉATION DES DÉPÔTS PAR DÉFAUT
-- =====================================================

-- Insertion des dépôts
INSERT INTO depot (nom, code, site_id) VALUES 
('Dépôt Principal', 'DEP_PRINCIPAL', 1),
('Dépôt Secondaire', 'DEP_SECONDAIRE', 2),
('Dépôt Tertiaire', 'DEP_TERTIAIRE', 3)
ON CONFLICT (code) DO NOTHING;

-- =====================================================
-- 5. ASSIGNATION DES RÔLES AUX UTILISATEURS
-- =====================================================

-- Association des utilisateurs aux dépôts avec leurs rôles
INSERT INTO utilisateur_depot (utilisateur_id, depot_id, role_id) VALUES 
-- Admin a accès à tous les dépôts
((SELECT id FROM utilisateur WHERE email = 'admin@harena.mg'), (SELECT id FROM depot WHERE code = 'DEP_PRINCIPAL'), (SELECT id FROM role WHERE code = 'ADMIN')),
((SELECT id FROM utilisateur WHERE email = 'admin@harena.mg'), (SELECT id FROM depot WHERE code = 'DEP_SECONDAIRE'), (SELECT id FROM role WHERE code = 'ADMIN')),
((SELECT id FROM utilisateur WHERE email = 'admin@harena.mg'), (SELECT id FROM depot WHERE code = 'DEP_TERTIAIRE'), (SELECT id FROM role WHERE code = 'ADMIN')),
-- Manager a accès aux dépôts principaux
((SELECT id FROM utilisateur WHERE email = 'manager@harena.mg'), (SELECT id FROM depot WHERE code = 'DEP_PRINCIPAL'), (SELECT id FROM role WHERE code = 'MANAGER')),
((SELECT id FROM utilisateur WHERE email = 'manager@harena.mg'), (SELECT id FROM depot WHERE code = 'DEP_SECONDAIRE'), (SELECT id FROM role WHERE code = 'MANAGER')),
-- User a accès au dépôt principal
((SELECT id FROM utilisateur WHERE email = 'user@harena.mg'), (SELECT id FROM depot WHERE code = 'DEP_PRINCIPAL'), (SELECT id FROM role WHERE code = 'USER')),
-- Operator a accès au dépôt secondaire
((SELECT id FROM utilisateur WHERE email = 'operator@harena.mg'), (SELECT id FROM depot WHERE code = 'DEP_SECONDAIRE'), (SELECT id FROM role WHERE code = 'OPERATOR'))
ON CONFLICT (utilisateur_id, depot_id, role_id) DO NOTHING;

-- =====================================================
-- 6. CRÉATION DES FONCTIONNALITÉS ET PERMISSIONS
-- =====================================================

-- Insertion des fonctionnalités par module
INSERT INTO fonctionnalite (module_id, code, nom) VALUES 
-- Administration
((SELECT id FROM module WHERE code = 'ADMIN'), 'USER_MGMT', 'Gestion des Utilisateurs'),
((SELECT id FROM module WHERE code = 'ADMIN'), 'ROLE_MGMT', 'Gestion des Rôles'),
((SELECT id FROM module WHERE code = 'ADMIN'), 'SITE_MGMT', 'Gestion des Sites'),
-- Stock
((SELECT id FROM module WHERE code = 'STOCK'), 'STOCK_VIEW', 'Visualisation des Stocks'),
((SELECT id FROM module WHERE code = 'STOCK'), 'STOCK_EDIT', 'Modification des Stocks'),
((SELECT id FROM module WHERE code = 'STOCK'), 'INVENTORY', 'Inventaire'),
-- Achats
((SELECT id FROM module WHERE code = 'ACHATS'), 'DEMANDE_ACHAT', 'Demandes d''Achat'),
((SELECT id FROM module WHERE code = 'ACHATS'), 'COMMANDE', 'Commandes Fournisseurs'),
((SELECT id FROM module WHERE code = 'ACHATS'), 'RECEPTION', 'Réceptions'),
-- Ventes
((SELECT id FROM module WHERE code = 'VENTES'), 'DEVIS', 'Devis Clients'),
((SELECT id FROM module WHERE code = 'VENTES'), 'COMMANDE_CLIENT', 'Commandes Clients'),
((SELECT id FROM module WHERE code = 'VENTES'), 'LIVRAISON', 'Bons de Livraison')
ON CONFLICT (module_id, code) DO NOTHING;

-- Insertion des permissions
INSERT INTO permission (fonctionnalite_id, code, nom) VALUES 
-- Pour chaque fonctionnalité, on ajoute les permissions de base
((SELECT id FROM fonctionnalite WHERE code = 'USER_MGMT'), 'CREATE', 'Création'),
((SELECT id FROM fonctionnalite WHERE code = 'USER_MGMT'), 'READ', 'Lecture'),
((SELECT id FROM fonctionnalite WHERE code = 'USER_MGMT'), 'UPDATE', 'Modification'),
((SELECT id FROM fonctionnalite WHERE code = 'USER_MGMT'), 'DELETE', 'Suppression'),
((SELECT id FROM fonctionnalite WHERE code = 'STOCK_VIEW'), 'READ', 'Lecture'),
((SELECT id FROM fonctionnalite WHERE code = 'STOCK_EDIT'), 'UPDATE', 'Modification'),
((SELECT id FROM fonctionnalite WHERE code = 'INVENTORY'), 'CREATE', 'Création'),
((SELECT id FROM fonctionnalite WHERE code = 'INVENTORY'), 'READ', 'Lecture'),
((SELECT id FROM fonctionnalite WHERE code = 'INVENTORY'), 'UPDATE', 'Modification')
ON CONFLICT (fonctionnalite_id, code) DO NOTHING;

-- =====================================================
-- 7. ASSIGNATION DES PERMISSIONS AUX RÔLES
-- =====================================================

-- Admin a toutes les permissions
INSERT INTO role_permission (role_id, permission_id)
SELECT 
    (SELECT id FROM role WHERE code = 'ADMIN'),
    id
FROM permission
ON CONFLICT (role_id, permission_id) DO NOTHING;

-- Manager a les permissions de lecture et modification
INSERT INTO role_permission (role_id, permission_id)
SELECT 
    (SELECT id FROM role WHERE code = 'MANAGER'),
    id
FROM permission 
WHERE code IN ('READ', 'UPDATE')
ON CONFLICT (role_id, permission_id) DO NOTHING;

-- User a uniquement les permissions de lecture
INSERT INTO role_permission (role_id, permission_id)
SELECT 
    (SELECT id FROM role WHERE code = 'USER'),
    id
FROM permission 
WHERE code = 'READ'
ON CONFLICT (role_id, permission_id) DO NOTHING;

-- =====================================================
-- 8. VALIDATION ET RAPPORT
-- =====================================================

-- Affichage du résumé des créations
DO $$
DECLARE
    user_count INTEGER;
    role_count INTEGER;
    site_count INTEGER;
    depot_count INTEGER;
BEGIN
    SELECT COUNT(*) INTO user_count FROM utilisateur;
    SELECT COUNT(*) INTO role_count FROM role;
    SELECT COUNT(*) INTO site_count FROM site;
    SELECT COUNT(*) INTO depot_count FROM depot;
    
    RAISE NOTICE '=== RAPPORT DE MISE À JOUR HARENA ===';
    RAISE NOTICE 'Utilisateurs créés: %', user_count;
    RAISE NOTICE 'Rôles créés: %', role_count;
    RAISE NOTICE 'Sites créés: %', site_count;
    RAISE NOTICE 'Dépôts créés: %', depot_count;
    RAISE NOTICE '====================================';
END $$;

-- =====================================================
-- 9. INSTRUCTIONS POST-INSTALLATION
-- =====================================================

-- NOTE IMPORTANTE:
-- 1. Les mots de passe sont en clair pour le développement
-- 2. En production, il faut hasher les mots de passe avec BCrypt ou Argon2
-- 3. Pensez à changer les mots de passe par défaut après la première connexion
-- 4. Configurez correctement les permissions selon vos besoins métier

-- Comptes créés pour tester:
-- admin@harena.mg / admin123 (Administrateur)
-- manager@harena.mg / manager123 (Gestionnaire)
-- user@harena.mg / user123 (Utilisateur)
-- operator@harena.mg / operator123 (Opérateur)

-- Fin du script updateHarena.sql
