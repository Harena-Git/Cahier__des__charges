# Acteurs du Système

- **Administrateur**
- **Demandeur** (Départements métiers)
- **Service Achats**
- **Magasin / Stock** : Magasinier & Responsable stock
- **Service Ventes** : Commercial & Responsable vente
- **Finance / Comptabilité** : Comptable & DAF
- **Direction**

## 1. Administrateur
- **Admin**
    - Paramétrage général
    - Création utilisateurs
    - Gestion rôles & droits
    - Configuration sites / dépôts / entités

## 2. Demandeur (Départements métiers)
- **Demandeur d’achat**
    - Crée des demandes d’achat (DA)
    - Suit l’état de ses demandes

## 3. Service Achats
- **Acheteur**
    - Analyse DA
    - Demande et saisie proformas
    - Compare fournisseurs
    - Établit BC

## 4. Magasin / Stock
- **Magasinier**
    - Réception marchandises
    - Émission BR
    - Gestion mouvements stock
    - Inventaire physique (sans ajustement)
- **Responsable stock**
    - Valide ajustements
    - Autorise inventaires
    - Supervise transferts

## 5. Service Ventes
- **Commercial**
    - Proforma client
    - Commande client
    - Réservation stock
- **Responsable ventes**
    - Valide remises élevées
    - Annule commandes

## 6. Finance & Comptabilité
- **Comptable**
    - Saisie facture fournisseur / client
    - Rapprochement (BC–BR–Facture)
    - Encaissements
- **DAF**
    - Validation financière
    - Signature BC
    - Paiements

## 7. Direction
- Approbation finale des BC
- Contrôle stratégique

---

# Liste des Pages par Acteur

## Administrateur
- **Administration générale**
    - Tableau de bord Admin
    - Gestion des utilisateurs
    - Gestion des rôles
    - Gestion des permissions
    - Délégations temporaires (congé)
- **Structure organisationnelle**
    - Sociétés
    - Sites
    - Dépôts
    - Emplacements
- **Référentiels**
    - Articles / Produits
    - Catégories
    - Unités
    - Taxes
    - Tarifs
    - Fournisseurs
    - Clients

## Demandeur
- Créer demande d’achat (DA)
- Liste de mes demandes d’achat
- Détail d’une demande d’achat
- Suivi statut DA (en attente, validée, rejetée)

## Service Achats
- **Gestion des demandes**
    - Liste des demandes d’achat à traiter
    - Détail demande d’achat
- **Proformas fournisseurs**
    - Créer / saisir proforma fournisseur
    - Comparatif proformas (tri automatique)
    - Historique proformas par fournisseur
- **Bons de commande (BC)**
    - Créer BC
    - Détail BC
    - Suivi BC (en attente signature, signé, envoyé)

## Magasin / Stock
- **Magasinier**
    - Réception
        - Réception fournisseur (BL)
        - Création bon de réception (BR)
        - Historique réceptions
    - Mouvements de stock
        - Entrées stock
        - Sorties stock
        - Transferts inter-dépôts
        - Réservations stock
    - Stock
        - Consultation stock (par article, dépôt, emplacement, lot)
        - Détail lot / série / expiration
    - Inventaire
        - Saisie inventaire physique
        - Consultation écarts inventaire
- **Responsable Stock**
    - Validation & contrôle
        - Validation ajustements stock
        - Validation transferts
        - Autorisation inventaires
    - Suivi stock
        - Tableau de bord stock
        - Historique ajustements

## Service Ventes
- **Commercial**
    - Proformas & commandes
        - Créer proforma client
        - Liste proformas clients
        - Créer commande client (BC client)
        - Détail commande client
    - Livraison
        - Préparation commande
        - Bon de livraison (BL)
        - Historique livraisons
- **Responsable Ventes**
    - Contrôle ventes
        - Annulation commande client
        - Tableau de bord ventes

## Finance & Comptabilité
- **Comptable**
    - Facturation
        - Saisie facture fournisseur
        - Saisie facture client
        - Historique factures
    - Rapprochements
        - Rapprochement BC – BR – Facture
        - Liste factures bloquées
    - Paiements
        - Paiements fournisseurs
        - Encaissements clients
        - Gestion acomptes / avances
- **DAF**
    - Validation financière
        - Validation budgétaire
        - Validation paiement
        - Signature BC
    - Reporting
        - Tableau de bord financier
        - Suivi engagements

## Direction
- **Approbation**
    - Approbation BC
    - Historique des décisions
- **Pilotage**
    - Tableau de bord direction
    - KPIs globaux

---

# Liens (Sidebar) par Espace / Acteur

## Espace Administrateur
- Dashboard
- Utilisateurs
- Rôles
- Permissions
- Délégations temporaires
- Organisation
    - Sociétés
    - Sites
    - Dépôts
    - Emplacements
- Référentiels
    - Articles / Produits
    - Catégories
    - Unités
    - Taxes
    - Tarifs
    - Fournisseurs
    - Clients

## Espace Demandeur (Départements métiers)
- Dashboard
- Créer demande d’achat
- Mes demandes d’achat
- Détail demande d’achat

## Espace Service Achats
- Dashboard
- Demandes d’achat
- Proformas fournisseurs
- Comparatif proformas
- Bons de commande
- Suivi des BC

## Espace Magasin / Stock
- Dashboard
- Réceptions fournisseurs
- Bons de réception (BR)
- Mouvements de stock
- Transferts
- Réservations
- Consultation stock
- Inventaire physique
- Écarts d’inventaire

## Espace Service Ventes
- Dashboard
- Proformas clients
- Commandes clients
- Préparation commandes
- Bons de livraison (BL)
- Historique livraisons

## Espace Finance / Comptabilité
- Dashboard
- Factures fournisseurs
- Factures clients
- Rapprochement (BC–BR–Facture)
- Paiements fournisseurs
- Encaissements clients
- Acomptes / Avances

## Espace Direction
- Dashboard
- Approbation bons de commande
- Historique approbations
- KPIs globaux
- Reporting consolidé

---

# Contenu des Dashboards par Acteur

## Dashboard Administrateur
- **KPIs**
    - Nombre total d’utilisateurs
    - Nombre de rôles actifs
    - Nombre de permissions
    - Accès temporaires actifs
- **Actions rapides**
    - Créer utilisateur
    - Créer rôle
    - Attribuer rôle
    - Créer délégation

## Dashboard Demandeur (Départements)
- **KPIs**
    - Nombre de DA créées
    - DA en attente
    - DA validées
    - DA rejetées
- **Actions rapides**
    - Nouvelle demande d’achat
- **Informations**
    - Mes dernières DA
    - Statut des DA

## Dashboard Service Achats
- **KPIs**
    - DA à traiter
    - Proformas reçues
    - BC en attente signature
    - BC envoyés
- **Actions rapides**
    - Saisir proforma
    - Créer BC
- **Informations**
    - DA récentes
    - Comparatif proformas en cours

## Dashboard Magasinier
- **KPIs**
    - Articles en stock
    - Réceptions en attente
    - Articles à stock faible
- **Actions rapides**
    - Réception fournisseur
    - Mouvement stock
    - Saisie inventaire
- **Informations**
    - Dernières réceptions
    - Lots proches expiration

## Dashboard Responsable Stock
- **KPIs**
    - Ajustements en attente validation
    - Écarts d’inventaire
    - Transferts en attente
    - Valeur stock totale
- **Actions rapides**
    - Valider ajustement
    - Autoriser inventaire

## Dashboard Commercial
- **KPIs**
    - Commandes en cours
    - Commandes livrées
    - Commandes en retard
    - Stock réservé
- **Actions rapides**
    - Créer proforma client
    - Créer commande client
- **Informations**
    - Dernières commandes
    - Commandes à préparer
    - Produits les plus vendus

## Dashboard Responsable Ventes
- **KPIs**
    - Remises à valider
    - Commandes annulées
    - Chiffre d’affaires
    - Avoirs clients
- **Actions rapides**
    - Valider remise
    - Annuler commande

## Dashboard Comptable
- **KPIs**
    - Factures fournisseurs en attente
    - Factures clients émises
    - Encaissements du mois
- **Actions rapides**
    - Saisir facture
    - Rapprocher facture
    - Enregistrer paiement
- **Informations**
    - Factures en retard
    - Rapprochements incomplets
    - Acomptes en cours

## Dashboard DAF
- **KPIs**
    - BC à valider
    - Engagements financiers
    - Paiements en attente
- **Actions rapides**
    - Valider BC
    - Valider paiement
- **Informations**
    - Historique validations

## Dashboard Direction
- **KPIs**
    - Chiffre d’affaires
    - Marge brute
    - Valeur stock
    - Écarts inventaire
- **Actions rapides**
    - Approuver BC
- **Informations**
    - KPIs par site
    - Top surstocks
