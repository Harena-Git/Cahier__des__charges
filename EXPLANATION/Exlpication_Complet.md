# GUIDE FONCTIONNEL & TECHNIQUE – PROJET COMBIEN

---

## 1. Objectif du système

Le projet **COMBIEN** est un système de **contrôle interne** destiné à gérer de manière sécurisée et traçable :

* les **achats**,
* les **ventes**,
* le **stock**,
* la **facturation**,
* les **droits d’accès (RBAC / ABAC)**,
* le **multi-sites, multi-dépôts et multi-entités**.

Objectif principal :

> Garantir la fiabilité des opérations, éviter la fraude, assurer la traçabilité et respecter les bonnes pratiques comptables et logistiques.

---

## 2. Périmètre fonctionnel global

Modules couverts par le système :

* Administration & Sécurité
* Référentiels (Masters)
* Achats
* Stock & Inventaire
* Ventes
* Facturation & Paiements

Chaque module est **indépendant fonctionnellement**, mais **interconnecté via la base de données**.

---

## 3. Architecture fonctionnelle

### 3.1 Multi-entités

* Une **entité = une société juridique** (ex: BICI, Ketrika, ITU).
* Chaque société possède :

  * ses sites
  * ses dépôts
  * ses utilisateurs
* Possibilité de **transfert de stock inter-sociétés** (option contrôlée).

### 3.2 Multi-sites

* Un site = localisation géographique (Tana, Mahajanga, Antsirabe).
* Règle :

  * ❌ un utilisateur **ne voit pas le stock des autres sites** par défaut
  * ✔ visibilité contrôlée via rôles / permissions

### 3.3 Multi-dépôts

* Dépôts rattachés à un site
* Cas d’usage :

  * Achats et ventes centralisés
  * Stock réparti sur plusieurs dépôts

---

## 4. Gestion des rôles et accès

### 4.1 RBAC (Role Based Access Control)

* Utilisateur → Rôle → Permissions
* Exemples de rôles :

  * Magasinier
  * Acheteur
  * Finance
  * Directeur
  * Administrateur

### 4.2 ABAC (Attribute Based Access Control)

Contrôles supplémentaires basés sur :

* site
* dépôt
* type de document
* statut du document

### 4.3 Délégation temporaire

* Un utilisateur peut déléguer ses droits
* Définition :

  * date début
  * date fin
* Cas : congé, mission

---

## 5. Module Achats – Workflow métier

### 5.1 Demande d’achat

Acteur : Département / Service

Étapes :

1. Création d’une **demande d’achat**
2. Validation interne du service
3. Transmission au service achat

Données affichées :

* numéro DA
* articles / désignation libre
* quantités
* statut

---

### 5.2 Vérification du stock

Acteur : Service achat

* Vérifier si l’article existe déjà en stock
* Si stock suffisant → rejet ou ajustement de la demande
* Sinon → poursuite du processus

---

### 5.3 Proformas fournisseurs

Acteur : Service achat

* Demande minimum **3 proformas**
* Saisie dans le système
* Comparaison automatique des prix

Règle :

> Le système propose automatiquement la **proforma la moins chère**

---

### 5.4 Approbation financière

Acteur : Finance

* Vérifier la disponibilité budgétaire
* Valider ou refuser

---

### 5.5 Bon de commande (BC)

Acteurs : Direction / Finance

* Généré à partir d’une proforma validée
* Acte **irréversible**
* Déclenche l’achat réel

---

### 5.6 Réception

Documents :

* Bon de livraison (fournisseur)
* Bon de réception (interne – document de référence)

Acteur : Magasinier

---

### 5.7 Facture & paiement fournisseur

* Réception facture fournisseur
* Paiement via mode de paiement

---

## 6. Module Ventes – Workflow métier

Processus inverse des achats :

1. Consultation stock
2. Création proforma client (avec durée de validité)
3. Réception commande client
4. Réservation du stock
5. Préparation livraison
6. Bon de livraison
7. Facturation client
8. Encaissement

---

## 7. Module Stock

### 7.1 Principes

* Tous les mouvements sont tracés
* Chaque mouvement a un ID unique

Types de mouvements :

* Entrée
* Sortie
* Transfert
* Réservation
* Ajustement

---

### 7.2 Réservation de stock

* Dès la commande client : stock réservé
* Le stock réservé n’est plus disponible à la vente

---

### 7.3 Gestion des lots & emplacements

* Optionnel selon l’article
* Traçabilité par lot
* Gestion par emplacement

---

## 8. Inventaire & ajustement

### 8.1 Inventaire

* Inventaire ponctuel uniquement
* Pas de tournant ni annuel

Statuts :

* Planifié
* En cours
* Clôturé
* Ajusté

---

### 8.2 Ajustement de stock

* Autorisé uniquement aux **supérieurs hiérarchiques**
* Historisation obligatoire

---

## 9. Valorisation du stock

Méthodes supportées :

### 9.1 CMUP

* Moyenne pondérée
* Adaptée à la gestion de valeur

### 9.2 FIFO

* Reflète la réalité économique
* Adaptée aux produits périssables

### 9.3 LIFO

* Supporté mais déconseillé

### 9.4 FEFO

* Gestion de quantité
* Basée sur date d’expiration

---

## 10. Contraintes fonctionnelles

* Pas de modification rétroactive des mouvements
* Pas de gel de stock
* Justification obligatoire de la méthode de valorisation

---

## 11. Interfaces (pages à développer)

### Administration

* Gestion utilisateurs
* Rôles & permissions
* Délégations temporaires

### Achats

* Demandes d’achat
* Proformas
* Bons de commande
* Réceptions

### Ventes

* Proformas clients
* Commandes
* Livraisons

### Stock

* Consultation stock
* Mouvements
* Inventaires

### Finance

* Factures
* Paiements
* Encaissements

---

## 12. Glossaire

* Proforma : facture prévisionnelle
* Acompte : avance sur paiement
* BC : Bon de commande
* BR : Bon de réception
* BL : Bon de livraison
