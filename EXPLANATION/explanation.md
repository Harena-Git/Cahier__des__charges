# 📋 EXPLICATION.MD - Cahier des Charges Application Achats/Ventes/Stock

## 🎯 PROBLÉMATIQUE & OBJECTIFS

### Problème Actuel
- **Outils dispersés** : Excel, emails, ERP partiel utilisés séparément
- **Traçabilité faible** : Impossible de savoir qui a fait quoi, quand, pourquoi
- **Risques élevés** : Ruptures de stock, surstocks, fraudes, erreurs de prix

### Objectifs
- **Centraliser** tous les flux dans une seule application web
- **Standardiser** les méthodes de gestion
- **Renforcer les contrôles** avec séparation des tâches
- **Piloter** avec des KPI adaptés à chaque rôle
- **Réduire** les délais, erreurs et écarts

---

## 🏗️ MODULES PRINCIPAUX

### 1. Référentiels
- Articles, fournisseurs, clients, dépôts, taxes, tarifs

### 2. Achats (Processus complet)

 - Demande → Devis → Approbation → Commande → Réception → Facture → Paiement

### 3. Ventes
 - Devis → Commande client → Livraison → Facture → Encaissement


### 4. Stocks
- Mouvements, transferts, réservations, lots/séries, emplacements

### 5. Inventaires
- Tournants (quotidiens)
- Annuels (complets)
- Ajustements contrôlés

### 6. Tableaux de bord
- KPI différents selon le rôle (DAF ≠ Magasinier ≠ Commercial)

---

## 🔐 SÉCURITÉ & GOUVERNANCE

### RBAC + ABAC
- **RBAC** : Contrôle par rôle (Acheteur, Vendeur, Magasinier...)
- **ABAC** : Restrictions supplémentaires (site, montant, catégorie...)

### Séparation IMPÉRATIVE des tâches
 - INTERDIT :
    -- Créer ET approuver une commande
    -- Réceptionner ET payer une facture
    -- Créer un client ET encaisser
    -- Faire l'inventaire ET valider l'ajustement


### Principe du Moindre Privilège
- Chaque utilisateur a uniquement les droits nécessaires
- Exemple : Un magasinier peut scanner des entrées mais PAS modifier les prix

---

## 📦 GESTION DES STOCKS

### Règles de Base
1. **Traçabilité obligatoire** : Chaque mouvement = qui/quoi/quand/où
2. **Numérotation auto** : Tous documents numérotés séquentiellement
3. **Réservation auto** : Stock bloqué à la commande client
4. **Gestion des lots** : Obligatoire pour certains produits
5. **Dates péremption** : Blocage auto si dépassé

### Méthodes de Valorisation
- **FIFO** : Premier entré, premier sorti
- **CUMP** : Coût moyen pondéré
- **FEFO** : Pour produits périssables

---

## 📊 KPI PAR RÔLE

### Direction
- CA, marge, rotation stock, écarts inventaire

### Achats
- Délais commandes, qualité réceptions, litiges factures

### Stock
- Précision inventaires, productivité, obsolescence

### Ventes
- Commandes retard, annulations, remises, backlog

### Finance
- Rapprochements, écarts valorisation, variation marge

---

## ✅ AVANTAGES

### Pour l'entreprise
- **Moins d'erreurs** : Processus standardisés
- **Meilleur contrôle** : Fraude réduite
- **Décisions éclairées** : Données en temps réel
- **Conformité** : Prêt pour audits

### Pour les utilisateurs
- **Interface unique** : Plusieurs outils en un
- **Travail simplifié** : Moins de saisies manuelles
- **Alertes proactives** : Prévention des problèmes

---

## ⚙️ CARACTÉRISTIQUES TECHNIQUES

- **Multi-sites** : Gère plusieurs dépôts/entités
- **Volumétrie élevée** : Conçu pour beaucoup d'articles/mouvements
- **Journalisation complète** : Historique non modifiable
- **Double validation** : Pour opérations sensibles
- **API disponibles** : Intégration possible avec autres systèmes

---

## 🎓 CONCLUSION PÉDAGOGIQUE

Ce système transforme une gestion **réactive** (répondre aux problèmes) en gestion **proactive** (prévenir les problèmes). Il combine :

1. **Technique** : Application web robuste
2. **Processus** : Workflows structurés
3. **Contrôle** : Sécurité intégrée
4. **Pilotage** : KPI adaptés

> **Pour les entreprises malgaches** : C'est l'opportunité de passer à une gestion moderne, compétitive et transparente, essentielle pour attirer les investissements et exporter vers les marchés internationaux.

