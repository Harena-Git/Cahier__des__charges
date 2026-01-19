1. ADMINISTRATION & GESTION DES ACCÈS
    Utilisateur (
      id,
      email,
      nom,
      prenom,
      telephone,
      site_id
    )

    Role (
      id,
      code,
      nom
    )

    Module (
      id,
      code,          -- Ex: "ACHAT", "VENTE", "STOCK", "ADMIN"
      nom
    )

    Fonctionnalite (
      id,
      module_id,
      code,           -- ex: "DEMANDE_ACHAT", "BON_COMMANDE", "PROFORMA_FOURNISSEUR"
      nom
    )

    Permission (
      id,
      fonctionnalite_id,
      code,
      nom
    )

    RolePermission (
      id,
      role_id,
      permission_id
    )

    DelegationTemporaire (
      id,
      delegant_user_id,       -- Celui qui donne ses droits
      delegataire_user_id,    -- Celui qui reçoit les droits
      role_id,                -- Rôle délégué (optionnel, si on délègue un rôle spécifique)
      date_debut,
      date_fin
    )

    Societe (
      id,
      raison_sociale,
      code,
      adresse,
      ville
    )

    Site (
      id,
      nom,
      code,
      adresse,
      ville,
      societe_id
    )

    Depot (
      id,
      nom,
      code,
      site_id
    )

    UtilisateurDepot (
      id,
      utilisateur_id,
      depot_id,
      role_id
    )

    Emplacement (
      id,
      code,
      depot_id
    )

2. RÉFÉRENTIELS (MASTERS)
    CategorieArticle (
      id,
      code, -- ex: 'MATIERE_PREMIERE', 'PRODUIT_FINI'
      nom, 
      methode_gestion_id
    )

    UniteMesure (
      id,
      code,
      nom
    )

    Article (
      id,
      reference,
      designation,
      description,
      categorie_article_id,
      unite_mesure_stock_id,   -- Unité de gestion en stock (ex: PIECE)
      unite_mesure_achat_id,   -- Unité d'achat (ex: CARTON = 10 pièces)
      unite_mesure_vente_id,   -- Unité de vente (peut être différente)
      est_actif
    )

    Tarif (
      id,
      article_id,
      typeclient_id,              -- NULL = tarif général
      site_id,                -- NULL = tous sites
      prix,
      devise_id,                 -- Ex: "EUR"
      date_debut,
      date_fin               -- NULL = pas de date de fin (valide indéfiniment)
    )

    RegleRemise (
      id,
      article_id,             -- NULL si règle sur tout le panier
      type_client_id,         -- NULL si règle générale
      seuil_min_quantite,     -- Seuil quantité
      seuil_min_montant,      -- Seuil montant HT
      remise_pourcentage,
      date_debut,
      date_fin
    )

    Fournisseur (
      id,
      raison_sociale,
      nif/stat,
      telephone
    )

    TypeClient (
      id,
      nom
    )

    Client (
      id,
      typeclient_id,
      raison_sociale,
      telephone,
      email
    )

    Devise (
      id,
      code,          -- Ex: "EUR", "USD", "XOF"
      nom
    )

    TauxChange (
      id,
      devise_from_id,
      devise_to_id,
      taux,
      date_application
    )

    ModePaiement (
      id,
      code,          -- Ex: "VIREMENT", "CHEQUE", "CARTE", "ESPECES"
      nom
    )

3. ACHATS
    Departement (
      id,
      nom
    )

    DemandeAchat (
      id,
      numero_da,              -- Numéro unique auto-généré (ex: DA-2025-001)
      date_demande,
      departement_id,
      site_id,
      status
    )

    LigneDemandeAchat (
      id,
      demande_achat_id,
      -- OPTION A : Article métier
      article_id,
      -- OPTION B : Achat support
      designation,          -- "Bureau métal 160cm"
      quantite
    )

    ProformaFournisseur (
      id,
      fournisseur_id,
      demande_achat_id,
      numero_proforma,
      date_proforma,
      duree_validite,
      devise_id
    )

    LigneProformaFournisseur (
      id,
      proforma_fournisseur_id,
      ligne_demande_achat_id,
      prix_unitaire,
      remise,
    )

    BonCommande (
      id,
      numero_bc,              -- Numéro unique auto (ex: BC-2025-001)
      proforma_fournisseur_id,-- Référence à la proforma choisie
      date_emission
    )

    LigneBonCommande (
      id,
      bon_commande_id,
      ligne_proforma_fournisseur_id,
      quantite_commandee
    )

4. STOCK & RÉCEPTIONS
    BonReception (
      id,
      numero_br,                -- Auto-généré (ex: BR-2025-001)
      bon_commande_id,          -- Réception liée à un BC (peut être NULL)
      date_reception
    )

    LigneBonReception (
      id,
      bon_reception_id,
      ligne_bon_commande_id,    -- Lien vers la ligne du BC
      quantite_recue,
      lot_id,                   -- Lot créé ou associé
      emplacement_id           -- Où ranger
    )

    Lot (
      id,
      numero_lot,               -- Numéro de lot
      article_id,
      date_expiration,          -- DLC/DLUO
      quantite_disponible,
      statut  -- 'DISPONIBLE', 'BLOQUE', 'PERIME', 'EPUISE'
    )

    TypeMouvement (
      id,
      code,           -- ex: "ENTREE", "SORTIE", "TRANSFERT_ENTRANT", "TRANSFERT_SORTANT", "AJUSTEMENT_POS", "AJUSTEMENT_NEG"
    )

    MouvementStock (
      id,
      date_heure,
      utilisateur_id,
      type_mouvement_id,
      article_id,
      lot_id, -- NULL si pas de traçabilité lot
      quantite,
      emplacement_source_id,    -- NULL pour entrée
      emplacement_destination_id, -- NULL pour sortie
    )

    TransfertInterDepot (
      id,
      depot_source_id,
      depot_destination_id,
      date
    )

    LigneTransfert (
      id,
      transfert_inter_depot_id,
      article_id,
      lot_id,
      quantite
    )

    ReservationStock (
      id,
      commande_client_id,      -- Lien vers CommandeClient (module Ventes)
      article_id,
      lot_id,
      quantite_reservee,
      date_reservation
    )

    InventairePhysique (
      id,
      depot_id,
      date_inventaire,
      statut,                  -- "PLANIFIE", "EN_COURS", "CLOTURE", "AJUSTE"
    )

    LigneInventaire (
      id,
      inventaire_id,
      article_id,
      lot_id,
      emplacement_id,
      quantite_theorique,
      quantite_physique,
      ecart,
      date_saisie
    )

    AjustementStock (
      id,
      numero_ajustement,       -- Auto
      inventaire_id,  -- NULL si ajustement hors inventaire
      article_id,
      lot_id,
      emplacement_id,
      quantite_theorique,
      quantite_reelle,
      ecart,
      type_ajustement,         -- "POSITIF", "NEGATIF"
      date
    )

    EmplacementStock (
      id,
      article_id,
      lot_id,
      emplacement_id,
      quantite,
      unite_mesure_id,
      date_dernier_mouvement,
      valeur_stock_ht          -- Coût total (quantité * CUMP ou dernier coût)
    )

5. VENTES
    ProformaClient (
      id,
      numero_proforma,        -- Auto (ex: PRO-2025-001)
      client_id,
      date,
      devise_id
    )

    LigneProformaClient (
      id,
      proforma_client_id,
      article_id,
      quantite,
      prix
    )

    CommandeClient (
      id,
      numero_commande,        -- Auto (ex: CMD-2025-001)
      proforma_client_id,
      date_commande,
      depot_id,               -- Dépôt de préparation
      mode_paiement_id
    )

    LigneCommandeClient (
      id,
      commande_client_id,
      ligne_proforma_client_id,
      quantite_livree        -- Cumul des quantités livrées (mis à jour via BL)
    )

    BonLivraison (
      id,
      numero_bl,              -- Auto (ex: BL-2025-001)
      commande_client_id,
      date_livraison
    )

    LigneBonLivraison (
      id,
      bon_livraison_id,
      ligne_commande_client_id,
      lot_id,                 -- Lot prélevé
      quantite_livree,
      emplacement_id         -- Emplacement source du prélèvement
    )

6. FACTURATION & COMPTABILITÉ
    FactureFournisseur (
      id,
      numero_facture_fournisseur,   -- Numéro fournisseur
      bon_reception_id,             -- Optionnel
      date_facture,
      montant
    )

    FactureClient (
      id,
      numero_facture_client,        -- Numéro interne auto
      bon_livraison_id,             -- Optionnel (livraison associée)
      date_facture,
      montant
    )

    PaiementFournisseur (
      id,
      numero_paiement,              -- Auto (ex: PAI-F-2025-001)
      facture_fournisseur_id,
      date_paiement,
      mode_paiement_id
    )

    EncaissementClient (
      id,
      numero_encaissement,          -- Auto (ex: ENC-C-2025-001)
      facture_client_id,
      date_encaissement,
      mode_paiement_id
    )

    Acompte (
      id,
      client_id,                    -- NULL si fournisseur
      fournisseur_id,               -- NULL si client
      date_acompte,
      montant,
      impute_sur_facture_id,        -- Facture sur laquelle il est imputé
    )

7. 
  Ville (
    id,
    nom
  )

  MethodeGestion (
    id,
    code         -- 'FIFO', 'CUMP', 'FEFO', 'LIFO'
  )

