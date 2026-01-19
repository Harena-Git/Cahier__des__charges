---

# 🎯 Projet : Gestion Stock – Vente – Achat (COMBIEN)

---

# 1️⃣ Harena — **Administration & Sécurité (RBAC / ABAC)**

## 🎓 Rôle métier (en clair)

Harena construit **les règles du jeu** :

* Qui peut se connecter
* Qui peut voir quoi
* Qui peut faire quoi
* Quand un droit commence et quand il s’arrête

Sans ce module, **le système n’est pas crédible**.

---

## 📊 Exemples de données

### Utilisateur

| id | nom    | email                                               | site         |
| -- | ------ | --------------------------------------------------- | ------------ |
| 1  | Rakoto | [rakoto@entreprise.mg](mailto:rakoto@entreprise.mg) | Antananarivo |
| 2  | Lalao  | [lalao@entreprise.mg](mailto:lalao@entreprise.mg)   | Antsirabe    |

### Rôles

| id | code | nom        |
| -- | ---- | ---------- |
| 1  | MAG  | Magasinier |
| 2  | ACH  | Acheteur   |
| 3  | FIN  | Finance    |
| 4  | DIR  | Direction  |

### Permissions

| code          |
| ------------- |
| CREER_DA      |
| VALIDER_DA    |
| CREER_BC      |
| AJUSTER_STOCK |

---

## 🧩 Exemple concret

* Rakoto (Magasinier)
  ✔ peut réceptionner
  ❌ ne peut pas payer
* Lalao (Finance)
  ✔ peut payer
  ❌ ne peut pas créer une commande

---

## 🧱 Ce que Harena doit livrer

* Pages :

  * Login
  * Gestion utilisateurs
  * Gestion rôles
  * Gestion permissions
  * Délégation temporaire
* Règles :

  * Séparation des tâches
  * Accès multi-sites
  * Accès temporaire (dates)

---

# 2️⃣ Fenitra — **Référentiels (Données de base)**

## 🎓 Rôle métier

Fenitra prépare **les données propres et fiables** sur lesquelles tout le monde va travailler.

👉 Si ce module est mal fait → tout le projet est faux.

---

## 📊 Exemples de données

### Article

| référence | désignation    | catégorie        | unité |
| --------- | -------------- | ---------------- | ----- |
| ART-001   | Riz blanc 50kg | Matière première | Sac   |
| ART-002   | Huile 5L       | Produit fini     | Bidon |

### Fournisseur

| nom     | téléphone     |
| ------- | ------------- |
| SOMACOU | 034 12 345 67 |

### Dépôt

| code        | site         |
| ----------- | ------------ |
| DEP-TANA-01 | Antananarivo |

---

## 🧩 Exemple concret

* Impossible de créer une demande d’achat **sans article**
* Impossible de réceptionner **sans dépôt**
* Impossible de valoriser stock **sans méthode (FIFO / CMUP)**

---

## 🧱 Ce que Fenitra doit livrer

* Pages CRUD :

  * Articles
  * Fournisseurs
  * Clients
  * Dépôts
  * Emplacements
  * Unités de mesure
  * Méthodes de gestion
* Validation des données (unicité, obligatoire, cohérence)

---

# 3️⃣ Erica — **Module Achats**

## 🎓 Rôle métier

Erica gère **l’argent qui sort de l’entreprise**.
C’est un module **très contrôlé**.

---

## 📊 Exemples de données

### Demande d’achat

| numéro      | article   | quantité | statut     |
| ----------- | --------- | -------- | ---------- |
| DA-2025-001 | Riz blanc | 50       | EN_ATTENTE |

### Proformas

| fournisseur | prix |
| ----------- | ---- |
| SOMACOU     | 900  |
| ABC SARL    | 950  |
| XYZ LTD     | 1000 |

👉 Le système choisit **900**

---

## 🧩 Exemple concret

* Le service RH demande des chaises
* Le magasinier vérifie : stock = 0
* L’acheteur saisit 3 proformas
* Finance valide
* Bon de commande généré
* Attente livraison

---

## 🧱 Ce que Erica doit livrer

* Pages :

  * Demande d’achat
  * Proformas fournisseurs
  * Comparatif prix
  * Bon de commande
  * Réception
  * Facture fournisseur
* Workflow :

  * Statuts
  * Validations
  * Historique

---

# 4️⃣ Harenkanto — **Stock & Inventaire (Cœur)**

## 🎓 Rôle métier

Harenkanto gère **la vérité physique** :

> ce qu’il y a réellement dans l’entrepôt.

---

## 📊 Exemples de données

### Mouvement de stock

| type   | article | quantité | dépôt    |
| ------ | ------- | -------- | -------- |
| Entrée | Riz     | +50      | DEP-TANA |
| Sortie | Riz     | -10      | DEP-TANA |

### Lot

| lot     | article | expiration |
| ------- | ------- | ---------- |
| LOT-001 | Riz     | 2025-12-31 |

---

## 🧩 Exemple concret

* 50 sacs reçus → entrée stock
* 10 vendus → sortie stock
* Stock restant = 40
* Inventaire trouve 38 → ajustement -2 (validé par supérieur)

---

## 🧱 Ce que Harenkanto doit livrer

* Pages :

  * État de stock
  * Mouvements
  * Lots
  * Emplacements
  * Transferts
  * Inventaires
  * Ajustements
* Règles :

  * Pas de suppression
  * Pas de modification rétroactive

---

# 5️⃣ Carene — **Ventes & Finance**

## 🎓 Rôle métier

Carene gère **l’argent qui entre**.

---

## 📊 Exemples de données

### Proforma client

| numéro       | client   | montant |
| ------------ | -------- | ------- |
| PRO-2025-001 | Client A | 500 000 |

### Commande client

| commande     | statut    |
| ------------ | --------- |
| CMD-2025-001 | CONFIRMÉE |

---

## 🧩 Exemple concret

* Client demande devis
* Stock disponible → OK
* Proforma envoyée
* Commande confirmée
* Stock réservé
* Livraison
* Facture
* Paiement encaissé

---

## 🧱 Ce que Carene doit livrer

* Pages :

  * Proformas clients
  * Commandes clients
  * Réservations
  * Bons de livraison
  * Factures clients
  * Encaissements
* Règles :

  * Pas de vente sans stock
  * Réservation automatique

---

# ✅ Conclusion pédagogique

✔ Chaque membre :

* a un **périmètre clair**
* comprend **les données**
* comprend **les règles**
* comprend **les pages à développer**

🎓 **Si chacun fait correctement sa partie, le projet est solide, cohérent et défendable.**

---

Si tu veux, prochaine étape possible :

* 🗂️ backlog technique par membre
* 📅 planning par semaine
* 🔗 contrats API entre modules
* 🧪 scénarios de tests

👉 Dis-moi ce que tu veux maintenant.
