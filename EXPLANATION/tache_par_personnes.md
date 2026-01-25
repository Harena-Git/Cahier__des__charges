🔹 RÉPARTITION DES TÂCHES – PROJET ACHAT / VENTE / STOCK (5 DÉVELOPPEURS)

👤 Harena
🎯 Modules : ADMINISTRATION + DIRECTION + CORE SÉCURITÉ
Acteurs concernés
Administrateur
Direction
Backend – Responsabilités
🔐 Sécurité & Gouvernance
Gestion des utilisateurs
Gestion des rôles (RBAC)
Gestion des permissions
Délégations temporaires (accès avec expiration)
Journalisation des actions (audit)
🏢 Structure organisationnelle
Sociétés
Sites
Dépôts
Emplacements
📚 Référentiels globaux
Articles / Produits
Catégories
Unités
Taxes
Tarifs
Fournisseurs
Clients
📊 Direction
Approbation finale des Bons de Commande (BC)
Historique des décisions
KPIs globaux Direction
Reporting consolidé (lecture seule)
Pages à développer
Dashboard Administrateur
Gestion utilisateurs / rôles / permissions
Organisation (sociétés, sites, dépôts…)
Référentiels
Dashboard Direction
Approbation BC
KPIs Direction

👤 Fenitra
🎯 Modules : DEMANDEUR + ACHATS (AMONT)
Acteurs concernés
Demandeur
Service Achats (partie DA & Proformas)
Backend – Responsabilités
📝 Demandes d’Achat (DA)
Création DA
Liste DA
Suivi statut (en attente, validée, rejetée)
Historique DA par demandeur
📄 Proformas Fournisseurs
Saisie proforma fournisseur
Historique proformas
Association DA ↔ Proformas
Pages à développer
Dashboard Demandeur
Création DA
Liste / détail DA
Dashboard Achats
Saisie proforma
Historique proformas
Processus couvert
DA → Proforma

👤 Harenkanto
🎯 Modules : ACHATS (AVAL) + BONS DE COMMANDE
Acteurs concernés
Service Achats
DAF (partie BC)
Backend – Responsabilités
🧾 Bons de Commande (BC)
Création BC à partir proformas
Suivi BC (en attente, signé, envoyé)
Signature BC (DAF)
Historique BC
🔁 Workflow Achat
Validation multi-niveaux
Séparation des rôles (création ≠ validation)
Pages à développer
Liste BC
Détail BC
Suivi BC
Validation financière (DAF)
Processus couvert
Proforma → BC → Signature

👤 Ericka
🎯 Modules : MAGASIN / STOCK
Acteurs concernés
Magasinier
Responsable Stock
Backend – Responsabilités
📦 Réceptions & Stock
Réception fournisseur (BL)
Bon de Réception (BR)
Mouvements de stock (entrée, sortie, transfert)
Réservations stock
📊 Inventaire
Saisie inventaire physique
Consultation écarts
Ajustements (validation Responsable Stock)
Pages à développer
Dashboard Magasin
Réceptions fournisseurs
Bons de réception
Consultation stock
Inventaire physique
Validation ajustements
Processus couvert
Réception → Stock → Inventaire

👤 Carene
🎯 Modules : VENTES + FINANCE / COMPTABILITÉ
Acteurs concernés
Commercial
Responsable Ventes
Comptable
DAF (finance)
Backend – Responsabilités
🛒 Ventes
Proforma client
Commande client
Réservation stock
Bon de livraison (BL)
Historique livraisons
💰 Finance
Factures fournisseurs
Factures clients
Rapprochement BC – BR – Facture
Paiements fournisseurs
Encaissements clients
Acomptes / avances
Pages à développer
Dashboard Ventes
Proformas clients
Commandes clients
Bons de livraison
Dashboard Finance
Facturation
Paiements & encaissements
Processus couvert
Commande → Livraison → Facture → Paiement