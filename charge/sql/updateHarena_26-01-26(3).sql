-- =====================================================
-- SCRIPT DE MISE À JOUR - TABLE UTILISATEUR
-- =====================================================
-- Date: 26/01/2026
-- Auteur: Système Harena
-- Description: Ajout de la colonne id_departement à la table utilisateur

-- Connexion à la base de données
\c avs_db;

-- =====================================================
-- 1. VÉRIFICATION DE L'EXISTANCE DE LA TABLE UTILISATEUR
-- =====================================================

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.tables 
        WHERE table_name='utilisateur'
    ) THEN
        RAISE NOTICE 'La table utilisateur n''existe pas. Veuillez d''abord créer la table utilisateur.';
        RETURN;
    END IF;
    
    RAISE NOTICE 'Table utilisateur trouvée.';
END $$;

-- =====================================================
-- 2. AJOUT DE LA COLONNE id_departement
-- =====================================================

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.columns 
        WHERE table_name='utilisateur' AND column_name='id_departement'
    ) THEN
        ALTER TABLE utilisateur 
        ADD COLUMN id_departement INTEGER REFERENCES departement(id) ON DELETE SET NULL;
        
        RAISE NOTICE 'Colonne id_departement ajoutée avec succès à la table utilisateur.';
        
        -- Ajout d'un commentaire
        COMMENT ON COLUMN utilisateur.id_departement IS 'Référence au département de l''utilisateur';
        RAISE NOTICE 'Commentaire ajouté sur la colonne id_departement.';
    ELSE
        RAISE NOTICE 'La colonne id_departement existe déjà dans la table utilisateur.';
    END IF;
END $$;

-- =====================================================
-- 3. VÉRIFICATION DE LA TABLE DEPARTEMENT
-- =====================================================

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.tables 
        WHERE table_name='departement'
    ) THEN
        RAISE NOTICE 'AVERTISSEMENT: La table departement n''existe pas.';
        RAISE NOTICE 'La colonne id_departement sera ajoutée mais sans contrainte de clé étrangère.';
        
        -- Suppression de la contrainte si la table departement n'existe pas
        ALTER TABLE utilisateur DROP CONSTRAINT IF EXISTS utilisateur_id_departement_fkey;
        RAISE NOTICE 'Contrainte de clé étrangère supprimée (table departement inexistante).';
    ELSE
        RAISE NOTICE 'Table departement trouvée, contrainte de clé étrangère maintenue.';
    END IF;
END $$;

-- =====================================================
-- 4. AFFICHAGE DE LA STRUCTURE ACTUELLE
-- =====================================================

RAISE NOTICE '=== STRUCTURE ACTUELLE DE LA TABLE UTILISATEUR ===';

DO $$
DECLARE
    column_record RECORD;
    column_count INTEGER := 0;
BEGIN
    RAISE NOTICE 'Colonnes de la table utilisateur:';
    
    FOR column_record IN 
        SELECT column_name, data_type, is_nullable, column_default
        FROM information_schema.columns 
        WHERE table_name='utilisateur'
        ORDER BY ordinal_position
    LOOP
        column_count := column_count + 1;
        RAISE NOTICE '  %: % (nullable: %, default: %)', 
            column_record.column_name, 
            column_record.data_type,
            column_record.is_nullable,
            COALESCE(column_record.column_default, 'NULL');
    END LOOP;
    
    RAISE NOTICE 'Total colonnes: %', column_count;
END $$;

-- =====================================================
-- 5. VALIDATION FINALE
-- =====================================================

DO $$
DECLARE
    utilisateur_count INTEGER;
    has_id_departement BOOLEAN;
BEGIN
    SELECT COUNT(*) INTO utilisateur_count FROM utilisateur;
    SELECT EXISTS(
        SELECT 1 FROM information_schema.columns 
        WHERE table_name='utilisateur' AND column_name='id_departement'
    ) INTO has_id_departement;
    
    RAISE NOTICE '=== RAPPORT DE MISE À JOUR UTILISATEUR ===';
    RAISE NOTICE 'Utilisateurs dans la table: %', utilisateur_count;
    RAISE NOTICE 'Colonne id_departement présente: %', CASE WHEN has_id_departement THEN 'OUI' ELSE 'NON' END;
    
    IF has_id_departement THEN
        RAISE NOTICE '✅ Mise à jour réussie !';
        RAISE NOTICE 'La table utilisateur est maintenant compatible avec la gestion des départements.';
    ELSE
        RAISE NOTICE '❌ Échec de l''ajout de la colonne id_departement.';
    END IF;
    
    RAISE NOTICE '==========================================';
END $$;

-- =====================================================
-- 6. INSTRUCTIONS POST-UPDATE
-- =====================================================

RAISE NOTICE '=== INSTRUCTIONS POST-UPDATE ===';
RAISE NOTICE '1. Redémarrez l''application Spring Boot';
RAISE NOTICE '2. Testez la création d''utilisateurs avec département';
RAISE NOTICE '3. Vérifiez l''affichage dans le tableau de bord super admin';
RAISE NOTICE '==========================================';

-- Fin du script
