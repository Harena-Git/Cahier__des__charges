-- =====================================================
-- SCRIPT DE MISE À JOUR - AJOUT SUPER ADMIN
-- =====================================================
-- Date: 26/01/2026
-- Auteur: Système Harena
-- Description: Ajout de la table super_admin et données initiales

-- Connexion à la base de données
\c avs_db;

-- =====================================================
-- 1. CRÉATION DE LA TABLE SUPER_ADMIN
-- =====================================================

CREATE TABLE IF NOT EXISTS super_admin (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) UNIQUE NOT NULL,
    mdp VARCHAR(255) NOT NULL
);

-- Ajout d'un commentaire pour la table
COMMENT ON TABLE super_admin IS 'Table des super administrateurs ayant le pouvoir de créer des admins dans chaque département';
COMMENT ON COLUMN super_admin.nom IS 'Nom unique du super administrateur';
COMMENT ON COLUMN super_admin.mdp IS 'Mot de passe du super administrateur (en clair pour le développement)';

-- =====================================================
-- 2. INSERTION DU SUPER ADMIN PAR DÉFAUT
-- =====================================================

-- Insertion du super admin par défaut
INSERT INTO super_admin (nom, mdp) VALUES 
('superadmin', 'superadmin123')
ON CONFLICT (nom) DO NOTHING;

-- =====================================================
-- 3. VALIDATION ET RAPPORT
-- =====================================================

-- Affichage du résumé des créations
DO $$
DECLARE
    super_admin_count INTEGER;
BEGIN
    SELECT COUNT(*) INTO super_admin_count FROM super_admin;
    
    RAISE NOTICE '=== RAPPORT DE MISE À JOUR SUPER ADMIN ===';
    RAISE NOTICE 'Super admins créés: %', super_admin_count;
    RAISE NOTICE 'Compte par défaut: superadmin / superadmin123';
    RAISE NOTICE '==========================================';
END $$;

-- =====================================================
-- 4. INSTRUCTIONS POST-INSTALLATION
-- =====================================================

-- NOTE IMPORTANTE:
-- 1. Le mot de passe est en clair pour le développement
-- 2. En production, il faut hasher les mots de passe avec BCrypt ou Argon2
-- 3. Pensez à changer le mot de passe par défaut après la première connexion
-- 4. Le super admin a accès à la création d'admins dans tous les départements

-- Compte créé pour tester:
-- superadmin / superadmin123

-- Fin du script update.sql
