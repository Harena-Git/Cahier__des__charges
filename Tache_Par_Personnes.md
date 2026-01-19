Objectif de la répartition :

* ✔ Charge équilibrée
* ✔ Responsabilités claires
* ✔ Modules faiblement couplés
* ✔ Chaque membre a **du métier + du technique**
* ✔ Le projet reste intégrable facilement

---

# 📌 Titre du projet

**Gestion de Stock – Vente – Achat (Projet COMBIEN)**

---

# 🧱 Découpage global des modules

Le projet est découpé en **5 grands blocs fonctionnels**, exactement adaptés à un groupe de **5 personnes**.

| Bloc                      | Nature     | Importance  |
| ------------------------- | ---------- | ----------- |
| Administration & Sécurité | Fondations | Critique    |
| Référentiels & Base       | Structure  | Critique    |
| Achats                    | Métier     | Élevée      |
| Stock & Inventaire        | Noyau      | Très élevée |
| Ventes & Finance          | Métier     | Élevée      |

---

# 👥 Répartition des tâches par membre

---

## 1️⃣ **Harena** – *Chef de projet / Architecture & Sécurité*

### 🎯 Rôle principal

Responsable **cohérence globale**, sécurité et intégration.

### 📦 Modules

**Administration & Gouvernance**

### 🛠️ Fonctionnalités à réaliser

* Gestion des utilisateurs
* Gestion des rôles (RBAC)
* Gestion des permissions
* Accès temporaires (délégation)
* Affectation utilisateur ↔ site ↔ dépôt
* Séparation des tâches (règles métier)

### Table 
* utilisateur
* role
* permission
* role_permission
* delegation_temporaire
* module
* fonctionnalite

### Table liées
* site
* depot
* utilisateur_depot

### 📄 Pages à développer

* Connexion / Déconnexion
* Gestion utilisateurs
* Gestion rôles & permissions
* Délégations temporaires
* Tableau de bord admin

### 🎓 Justification pédagogique

> Module stratégique, transversal, démontre la compréhension du **contrôle interne**.

---

## 2️⃣ **Fenitra** – *Référentiels & Données de base*

### 🎯 Rôle principal

Responsable de la **qualité des données**.

### 📦 Modules

**Référentiels (Masters)**

### 🛠️ Fonctionnalités à réaliser

* Sociétés
* Sites
* Dépôts
* Articles
* Catégories d’articles
* Unités de mesure
* Fournisseurs
* Clients
* Devises
* Méthodes de gestion (FIFO, CMUP…)

### Table 
* societe
* site
* depot
* emplacement
* article
* categorie_article
* unite_mesure
* fournisseur
* client
* type_client
* devise
* methode_gestion
* mode_paiement

### Table liées (consultées par d’autres modules)
* tarif
* regle_remise

### 📄 Pages à développer

* Gestion articles
* Gestion fournisseurs
* Gestion clients
* Gestion dépôts & emplacements
* Paramétrage méthodes de stock

### 🎓 Justification pédagogique

> Sans référentiels fiables, **aucun système de gestion ne fonctionne**.

---

## 3️⃣ **Erica** – *Module Achats*

### 🎯 Rôle principal

Responsable du **processus d’achat complet**.

### 📦 Modules

**Achats**

### 🛠️ Fonctionnalités à réaliser

* Demande d’achat
* Validation demande
* Saisie proformas fournisseurs
* Comparaison automatique des proformas
* Approbation financière
* Génération bon de commande
* Suivi réception
* Facture fournisseur

### Table 
* demande_achat
* ligne_demande_achat
* proforma_fournisseur
* ligne_proforma_fournisseur
* bon_commande
* ligne_bon_commande
* facture_fournisseur
* paiement_fournisseur

### Tables liées (lecture)
* fournisseur
* article
* site
* devise

### 📄 Pages à développer

* Demande d’achat
* Proformas fournisseurs
* Comparatif proformas
* Bons de commande
* Réceptions
* Factures fournisseurs

### 🎓 Justification pédagogique

> Module riche en **workflow**, validations, décisions → très formateur.

---

## 4️⃣ **Harenkanto** – *Stock & Inventaire (Cœur du système)*

### 🎯 Rôle principal

Responsable du **noyau technique du projet**.

### 📦 Modules

**Stock & Inventaire**

### 🛠️ Fonctionnalités à réaliser

* Consultation stock réel
* Mouvements de stock
* Gestion lots / séries
* Gestion emplacements
* Transferts inter-dépôts
* Réservations de stock
* Inventaire ponctuel
* Ajustement (avec validation)

### Table 
* mouvement_stock
* type_mouvement
* lot
* emplacement_stock
* transfert_inter_depot
* ligne_transfert
* reservation_stock
* inventaire_physique
* ligne_inventaire
* ajustement_stock

### Tables liées (lecture)
* article
* depot
* emplacement
* utilisateur

### 📄 Pages à développer

* État de stock
* Mouvements de stock
* Transferts
* Inventaires
* Ajustements

### 🎓 Justification pédagogique

> C’est le **module le plus sensible**, très apprécié par les jurys.

---

## 5️⃣ **Carene** – *Ventes & Finance*

### 🎯 Rôle principal

Responsable du **cycle de vente et des flux financiers**.

### 📦 Modules

**Ventes & Facturation**

### 🛠️ Fonctionnalités à réaliser

* Proforma client
* Commande client
* Réservation stock
* Bon de livraison
* Facture client
* Encaissement
* Suivi paiements

### Table 
* proforma_client
* ligne_proforma_client
* commande_client
* ligne_commande_client
* bon_livraison
* ligne_bon_livraison
* facture_client
* encaissement_client
* acompte

### Tables liées (lecture)
* client
* article
* devise
* mode_paiement
* reservation_stock (interaction avec Stock)

### 📄 Pages à développer

* Proformas clients
* Commandes clients
* Livraisons
* Factures clients
* Encaissements

### 🎓 Justification pédagogique

> Montre la maîtrise du **cash-flow**, sujet clé en gestion.

---

# 🔗 Coordination entre membres (important)

* **Harena** valide les règles d’accès de tous
* **Fenitra** fournit les référentiels à tous
* **Harenkanto** reçoit les flux Achat & Vente
* **Erica** alimente le stock
* **Carene** consomme le stock

👉 Cette interaction **reflète exactement la réalité d’une entreprise**.

---

# ✅ Conclusion du professeur

✔ Répartition **équitable**
✔ Aucun membre surchargé
✔ Chacun a :

* du métier
* de la logique
* des écrans
* des règles de gestion

🎓 **Avec cette organisation, votre projet est défendable devant n’importe quel jury.**

---

Si tu veux, je peux ensuite :

* faire un **planning (Gantt)**
* définir les **interfaces API entre modules**
* préparer un **plan de soutenance orale**

👉 Dis-moi la prochaine étape.
