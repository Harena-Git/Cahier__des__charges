# Cahier des charges — Application Web intégrée Achats / Ventes / Stock / Inventaires

## 1. Problématique et objectifs

### 1.1 Contexte
L'entreprise gère actuellement ses opérations d'achats, de ventes, de stock et d'inventaires à travers des systèmes disparates et parfois manuels. Cette fragmentation entraîne :
- Des erreurs de saisie et des incohérences dans les données
- Un manque de visibilité en temps réel sur l'état des stocks
- Des difficultés de traçabilité des opérations
- Une perte de productivité due aux processus redondants
- Des retards dans la prise de décision stratégique

### 1.2 Problématique
Comment centraliser et automatiser la gestion des achats, ventes, stocks et inventaires au sein d'une application web intégrée, tout en assurant la fiabilité des données, la traçabilité des opérations et l'optimisation des processus métier ?

### 1.3 Objectifs principaux
- **Centralisation** : Regrouper l'ensemble des opérations d'achats, ventes, stocks et inventaires dans une seule plateforme
- **Automatisation** : Réduire les tâches manuelles et les risques d'erreur
- **Traçabilité** : Assurer un suivi complet de toutes les opérations avec historique et audit trail
- **Visibilité** : Fournir une vue en temps réel de l'état des stocks et des flux financiers
- **Performance** : Optimiser les processus métier et accélérer les cycles de traitement
- **Scalabilité** : Supporter la croissance de l'entreprise et l'augmentation des volumes de transactions

### 1.4 Objectifs secondaires
- Améliorer la collaboration entre les différents départements
- Faciliter la prise de décision grâce à des tableaux de bord et rapports analytiques
- Réduire les coûts opérationnels liés aux processus manuels
- Assurer la conformité réglementaire et les obligations d'audit

## 2. Périmètre fonctionnel

### 2.1 Module Achats
**Fonctionnalités incluses :**
- Gestion des fournisseurs (création, modification, désactivation)
- Gestion des catalogues fournisseurs
- Création et suivi des demandes d'achat
- Émission et gestion des bons de commande
- Réception des marchandises et rapprochement avec les commandes
- Gestion des factures fournisseurs
- Suivi des paiements fournisseurs
- Gestion des retours fournisseurs
- Évaluation et notation des fournisseurs

**Workflows inclus :**
- Workflow de validation des demandes d'achat (multi-niveaux)
- Workflow d'approbation des bons de commande
- Rapprochement automatique commande-réception-facture (3-way matching)

### 2.2 Module Ventes
**Fonctionnalités incluses :**
- Gestion des clients (CRM simplifié)
- Gestion des tarifs et catalogues produits
- Création et suivi des devis
- Transformation devis en commandes
- Gestion des commandes clients
- Préparation et expédition des commandes
- Facturation clients
- Suivi des paiements clients
- Gestion des retours clients et avoirs
- Gestion des relances et impayés

**Workflows inclus :**
- Workflow de validation des devis
- Workflow d'approbation des commandes clients
- Workflow de traitement des retours

### 2.3 Module Stock
**Fonctionnalités incluses :**
- Gestion multi-entrepôts / multi-emplacements
- Gestion des entrées de stock (réceptions, retours clients)
- Gestion des sorties de stock (expéditions, retours fournisseurs)
- Mouvements de stock inter-entrepôts
- Réservations de stock pour les commandes clients
- Traçabilité par lot et numéro de série
- Gestion des dates de péremption (FIFO/FEFO)
- Gestion des seuils d'alerte (stock minimum, stock maximum)
- Génération automatique de suggestions de réapprovisionnement
- Gestion des stocks consignés et en dépôt

**Fonctionnalités de suivi :**
- Historique complet des mouvements de stock
- États de stock en temps réel
- Valorisation des stocks (FIFO, LIFO, CUMP)

### 2.4 Module Inventaires
**Fonctionnalités incluses :**
- Planification des inventaires (tournants, annuels, par zone)
- Génération des listes d'inventaire
- Saisie des comptages (simple ou double comptage)
- Rapprochement avec le stock théorique
- Gestion des écarts d'inventaire
- Validation et régularisation des écarts
- Génération des PV d'inventaire
- Archivage et historique des inventaires

**Types d'inventaire supportés :**
- Inventaire complet (annuel)
- Inventaire tournant (permanent)
- Inventaire par échantillonnage
- Inventaire ciblé (par famille, par entrepôt, etc.)

### 2.5 Fonctionnalités transverses
**Référentiels :**
- Gestion des articles / produits (création, modification, archivage)
- Gestion des familles et sous-familles d'articles
- Gestion des unités de mesure et conversions
- Gestion des devises et taux de change
- Gestion des taxes (TVA, autres taxes)
- Gestion des conditions de paiement
- Gestion des modes de paiement et de livraison

**Reporting et Analytics :**
- Tableaux de bord personnalisables par rôle
- Rapports standard (CA, marges, rotation stock, etc.)
- Exports Excel / PDF
- Indicateurs clés de performance (KPI)
- Analyses prédictives (prévisions de ventes, optimisation stock)

**Intégrations :**
- Import/Export de données (CSV, Excel)
- API REST pour intégration avec systèmes tiers
- Connecteurs avec ERP existants (si applicable)
- Connecteurs avec solutions de paiement
- Connecteurs avec solutions de transport/logistique

### 2.6 Éléments exclus du périmètre (hors scope)
- Gestion de la production (MES/MRP)
- Gestion des ressources humaines (paie, congés)
- Comptabilité générale complète (hors écritures liées aux achats/ventes)
- Gestion de projet
- E-commerce (interface client final)

## 3. Hypothèses et contraintes SI

### 3.1 Hypothèses métier
- L'entreprise dispose d'une connexion internet stable et performante
- Les utilisateurs possèdent les équipements nécessaires (ordinateurs, navigateurs récents)
- Les processus métier actuels peuvent être adaptés aux bonnes pratiques de l'application
- Les données historiques seront migrées ou ressaisies selon un plan de migration défini
- Une phase de formation des utilisateurs sera organisée avant le déploiement

### 3.2 Contraintes techniques

#### 3.2.1 Architecture et hébergement
- **Type d'application** : Application web responsive (accessible via navigateur)
- **Hébergement** : Cloud (AWS, Azure ou GCP) avec option de déploiement on-premise si nécessaire
- **Disponibilité** : SLA minimum de 99,5% (objectif 99,9%)
- **Performance** : Temps de réponse < 2 secondes pour 95% des requêtes
- **Scalabilité** : Architecture permettant de supporter jusqu'à 1000 utilisateurs simultanés

#### 3.2.2 Compatibilité
- **Navigateurs supportés** : 
  - Google Chrome (3 dernières versions)
  - Mozilla Firefox (3 dernières versions)
  - Microsoft Edge (3 dernières versions)
  - Safari (2 dernières versions)
- **Responsive** : Interface adaptée tablettes (écrans ≥ 768px)
- **Accessibilité** : Conformité niveau AA du WCAG 2.1

#### 3.2.3 Sécurité
- Authentification forte (MFA recommandé pour comptes à privilèges)
- Chiffrement des données en transit (TLS 1.2 minimum) et au repos
- Gestion des sessions sécurisée (timeout, renouvellement)
- Protection contre les vulnérabilités OWASP Top 10
- Journalisation des accès et des actions sensibles
- Sauvegardes automatiques quotidiennes avec rétention de 30 jours minimum
- Plan de reprise d'activité (PRA) avec RPO < 24h et RTO < 4h

#### 3.2.4 Conformité réglementaire
- RGPD : Respect de la réglementation sur la protection des données personnelles
- Archivage légal : Conservation des documents selon obligations légales (10 ans pour documents comptables)
- Piste d'audit : Traçabilité complète des modifications de données sensibles
- Droit à l'oubli : Mécanisme d'anonymisation des données clients/fournisseurs

#### 3.2.5 Contraintes d'intégration
- API REST documentée (OpenAPI/Swagger) pour intégrations futures
- Support des formats standards : JSON, XML, CSV, Excel
- Webhooks pour notifications temps réel vers systèmes tiers
- Compatibilité avec les systèmes existants (à définir selon contexte)

### 3.3 Contraintes de performance
- **Volume de données** :
  - Gestion jusqu'à 100 000 références articles
  - Stockage de 5 ans d'historique de transactions
  - Support de millions de lignes de mouvement de stock
- **Transactions** :
  - Capacité de traiter 10 000 transactions/jour minimum
  - Pics de charge supportés (périodes de soldes, fin d'exercice)
- **Temps de traitement** :
  - Calcul de disponibilité stock : < 1 seconde
  - Génération de rapport standard : < 5 secondes
  - Export de données volumineuses : mode asynchrone avec notification

### 3.4 Contraintes de déploiement et maintenance
- Déploiement progressif par module ou par entité
- Mises à jour applicatives en dehors des heures ouvrées (ou sans interruption de service)
- Documentation technique et utilisateur en français
- Support technique pendant les heures ouvrées (extensible 24/7 selon SLA)
- Formation des utilisateurs et des administrateurs prévue

### 3.5 Contraintes budgétaires et planning
- Budget alloué au projet : [À définir]
- Délai de mise en œuvre : [À définir]
- Phases de déploiement : Pilote puis généralisation
- ROI attendu : [À définir selon objectifs]

## 4. Gouvernance, rôles et gestion des accès

### 4.1 Principes de gouvernance

#### 4.1.1 Comité de pilotage
- **Composition** : Direction générale, DSI, Directeurs métier (Achats, Ventes, Logistique), Chef de projet
- **Fréquence** : Mensuel ou selon jalons projet
- **Rôle** : Validation des orientations stratégiques, arbitrage, validation des livrables majeurs

#### 4.1.2 Comité projet
- **Composition** : Chef de projet, Référents métier, Équipe technique, Intégrateur
- **Fréquence** : Hebdomadaire
- **Rôle** : Suivi opérationnel, gestion des risques, coordination des équipes

#### 4.1.3 Référents métier
- Un référent par module (Achats, Ventes, Stock, Inventaires)
- Responsables de la validation fonctionnelle
- Relais auprès des utilisateurs finaux
- Participation aux recettes fonctionnelles

### 4.2 Rôles et profils utilisateurs

#### 4.2.1 Rôles administratifs et techniques

**Administrateur Système (Super Admin)**
- **Permissions** :
  - Configuration complète de l'application
  - Gestion des utilisateurs et des rôles
  - Paramétrage des référentiels globaux
  - Accès aux journaux d'audit complets
  - Gestion des sauvegardes et restaurations
  - Configuration des intégrations et API
- **Restrictions** :
  - Aucune restriction technique
  - Traçabilité renforcée de toutes les actions
- **Périmètre** : Global (toutes entités, tous modules)

**Administrateur Fonctionnel**
- **Permissions** :
  - Paramétrage des workflows de validation
  - Configuration des référentiels métier (articles, familles, tarifs)
  - Gestion des droits utilisateurs (attribution des rôles)
  - Consultation des statistiques et tableaux de bord globaux
  - Export de données pour analyse
- **Restrictions** :
  - Pas d'accès aux configurations système critiques
  - Pas de modification des paramètres de sécurité
- **Périmètre** : Global ou par entité selon organisation

#### 4.2.2 Rôles métier - Module Achats

**Directeur des Achats**
- **Permissions** :
  - Vue globale sur tous les achats et fournisseurs
  - Validation des commandes au-delà d'un certain seuil
  - Accès aux rapports analytiques et KPI achats
  - Gestion des stratégies d'achat et des contrats cadres
  - Consultation de tous les workflows de validation
- **Restrictions** :
  - Peut consulter mais ne peut pas modifier les données validées
- **Périmètre** : Tous les services achats

**Responsable Achats**
- **Permissions** :
  - Gestion des fournisseurs (création, modification, évaluation)
  - Validation des demandes d'achat de son périmètre
  - Création et validation des bons de commande
  - Négociation et saisie des conditions tarifaires
  - Suivi des réceptions et des factures
  - Accès aux rapports de son périmètre
- **Restrictions** :
  - Validation limitée selon seuils définis
  - Ne peut pas supprimer des données validées
- **Périmètre** : Département ou catégorie d'achats

**Acheteur**
- **Permissions** :
  - Création et suivi des demandes d'achat
  - Création de bons de commande (selon seuils)
  - Consultation des catalogues fournisseurs
  - Saisie des réceptions de marchandises
  - Communication avec les fournisseurs
  - Consultation des historiques d'achat
- **Restrictions** :
  - Validation requise pour commandes > seuil défini
  - Ne peut pas modifier les tarifs fournisseurs
  - Accès limité à son portefeuille
- **Périmètre** : Portefeuille fournisseurs attribué

**Demandeur Achats**
- **Permissions** :
  - Création de demandes d'achat
  - Suivi de ses propres demandes
  - Consultation du catalogue produits
  - Consultation des statuts de commande
- **Restrictions** :
  - Ne peut pas créer de bon de commande directement
  - Accès en lecture seule aux fournisseurs
  - Ne peut modifier que ses demandes non validées
- **Périmètre** : Service ou département

#### 4.2.3 Rôles métier - Module Ventes

**Directeur Commercial / Ventes**
- **Permissions** :
  - Vue globale sur toutes les ventes et clients
  - Validation des devis stratégiques ou à fort enjeu
  - Accès aux rapports analytiques et KPI ventes
  - Gestion des politiques tarifaires et remises exceptionnelles
  - Consultation de tous les workflows de validation
  - Gestion des objectifs commerciaux
- **Restrictions** :
  - Peut consulter mais ne peut pas modifier directement les commandes validées
- **Périmètre** : Tous les services commerciaux

**Responsable Commercial**
- **Permissions** :
  - Gestion du portefeuille clients de son équipe
  - Validation des devis de son périmètre
  - Création et modification des commandes clients
  - Octroi de remises (dans limites définies)
  - Suivi des objectifs de l'équipe
  - Accès aux rapports de performance de l'équipe
- **Restrictions** :
  - Remises limitées selon grille de délégation
  - Validation requise pour devis > seuil défini
- **Périmètre** : Équipe commerciale ou zone géographique

**Commercial / Vendeur**
- **Permissions** :
  - Gestion de son portefeuille clients
  - Création et suivi des devis
  - Transformation devis en commandes
  - Création de commandes clients
  - Consultation des stocks disponibles
  - Suivi des livraisons de ses commandes
  - Accès à ses statistiques de ventes
- **Restrictions** :
  - Remises limitées selon grille de délégation
  - Validation requise selon montant ou conditions
  - Ne peut pas modifier les prix catalogue sans autorisation
- **Périmètre** : Portefeuille clients attribué

**Assistant Commercial**
- **Permissions** :
  - Saisie des commandes clients
  - Suivi administratif des commandes
  - Relance des paiements clients
  - Création de factures
  - Gestion des retours clients
- **Restrictions** :
  - Ne peut pas valider de devis
  - Ne peut pas accorder de remises
  - Accès limité selon attribution
- **Périmètre** : Support d'une équipe commerciale

**Service Client**
- **Permissions** :
  - Consultation des commandes et factures clients
  - Suivi des livraisons
  - Gestion des réclamations clients
  - Création d'avoirs (selon procédure)
  - Gestion des retours clients
- **Restrictions** :
  - Pas de création de nouvelles commandes
  - Avoirs soumis à validation
  - Accès en lecture seule aux tarifs
- **Périmètre** : Tous les clients

#### 4.2.4 Rôles métier - Module Stock et Logistique

**Directeur Logistique / Supply Chain**
- **Permissions** :
  - Vue globale multi-entrepôts
  - Validation des mouvements inter-entrepôts stratégiques
  - Accès aux rapports analytiques stock (rotation, valorisation)
  - Paramétrage des seuils de stock et politiques de réapprovisionnement
  - Consultation de tous les inventaires
- **Restrictions** :
  - Peut consulter mais ne modifie pas directement les stocks
- **Périmètre** : Tous les entrepôts

**Responsable d'Entrepôt**
- **Permissions** :
  - Gestion opérationnelle de son entrepôt
  - Validation des entrées et sorties de stock
  - Organisation et planification des inventaires
  - Gestion des emplacements et zones de stockage
  - Validation des mouvements inter-entrepôts
  - Gestion de l'équipe logistique de l'entrepôt
  - Accès aux rapports de performance de l'entrepôt
- **Restrictions** :
  - Périmètre limité à son/ses entrepôt(s)
  - Ne peut pas modifier les valorisations de stock
- **Périmètre** : Entrepôt(s) attribué(s)

**Magasinier / Gestionnaire de Stock**
- **Permissions** :
  - Enregistrement des réceptions de marchandises
  - Enregistrement des expéditions
  - Mouvements de stock internes (changement d'emplacement)
  - Préparation des commandes clients
  - Saisie des comptages d'inventaire
  - Impression des étiquettes et documents logistiques
- **Restrictions** :
  - Ne peut pas valider les inventaires
  - Ne peut pas modifier les données article
  - Limité à son entrepôt ou sa zone
- **Périmètre** : Entrepôt ou zone de stockage

**Préparateur de Commandes**
- **Permissions** :
  - Consultation des ordres de préparation
  - Saisie des préparations (picking)
  - Validation des expéditions
  - Impression des bons de livraison
- **Restrictions** :
  - Pas de création de mouvements de stock
  - Accès en lecture seule aux stocks
  - Ne peut que traiter les commandes assignées
- **Périmètre** : Entrepôt attribué

**Réceptionnaire**
- **Permissions** :
  - Enregistrement des réceptions fournisseurs
  - Contrôle qualité/quantité à la réception
  - Rapprochement avec les bons de commande
  - Gestion des litiges à la réception
  - Impression des étiquettes de réception
- **Restrictions** :
  - Ne peut pas modifier les commandes fournisseurs
  - Limité aux opérations de réception
- **Périmètre** : Entrepôt attribué

#### 4.2.5 Rôles métier - Module Inventaires

**Responsable Inventaire**
- **Permissions** :
  - Planification et organisation des inventaires
  - Génération des listes d'inventaire
  - Attribution des zones aux équipes de comptage
  - Validation des comptages
  - Analyse et validation des écarts
  - Génération des PV d'inventaire
  - Régularisation des stocks post-inventaire
- **Restrictions** :
  - Validation finale soumise à approbation selon importance des écarts
- **Périmètre** : Tous les entrepôts ou entrepôt attribué

**Compteur / Inventoriste**
- **Permissions** :
  - Saisie des comptages physiques
  - Consultation des listes d'inventaire assignées
  - Signalement des anomalies
  - Double comptage si requis
- **Restrictions** :
  - Accès en lecture seule au stock théorique
  - Ne peut pas valider ou régulariser les écarts
  - Limité aux zones assignées
- **Périmètre** : Zones d'inventaire assignées

#### 4.2.6 Rôles transverses

**Contrôleur de Gestion**
- **Permissions** :
  - Consultation de tous les modules
  - Accès à tous les rapports et tableaux de bord
  - Export de données pour analyse
  - Consultation des valorisations de stock
  - Accès aux historiques complets
- **Restrictions** :
  - Accès en lecture seule (pas de modification)
  - Ne peut pas valider de transactions
- **Périmètre** : Global

**Auditeur Interne**
- **Permissions** :
  - Accès aux journaux d'audit complets
  - Consultation de toutes les transactions
  - Accès aux workflows de validation
  - Export de données pour audit
  - Consultation des historiques de modifications
- **Restrictions** :
  - Accès en lecture seule uniquement
  - Pas de modification de données
- **Périmètre** : Global, accès temporaire selon mission d'audit

**Consultant / Lecture Seule**
- **Permissions** :
  - Consultation des données selon périmètre défini
  - Accès aux rapports standards
- **Restrictions** :
  - Aucune modification
  - Aucune validation
  - Périmètre strictement défini
- **Périmètre** : Défini par l'administrateur

### 4.3 Matrice de droits détaillée

#### 4.3.1 Niveaux de permission
- **C** : Création (Create)
- **R** : Lecture (Read)
- **U** : Modification (Update)
- **D** : Suppression (Delete)
- **V** : Validation
- **E** : Export

#### 4.3.2 Tableau récapitulatif par objet métier

| Objet / Rôle | Super Admin | Admin Fonc. | Dir. Achats | Resp. Achats | Acheteur | Dir. Ventes | Resp. Ventes | Commercial | Resp. Entrepôt | Magasinier |
|--------------|-------------|-------------|-------------|--------------|----------|-------------|--------------|------------|----------------|------------|
| **Fournisseurs** | CRUDVE | CRUDVE | RVE | CRUVE | CRU | R | R | R | R | R |
| **Demandes Achat** | CRUDVE | CRUDVE | RVE | CRUDVE | CRUDVE | R | R | R | R | R |
| **Bons Commande** | CRUDVE | CRUDVE | RVE | CRUDVE | CRU | R | R | R | R | R |
| **Réceptions** | CRUDVE | CRUDVE | RE | RVE | CRUDVE | R | R | R | CRUDVE | CRUDVE |
| **Clients** | CRUDVE | CRUDVE | R | R | R | CRUDVE | CRUDVE | CRUE | R | R |
| **Devis** | CRUDVE | CRUDVE | R | R | R | CRUDVE | CRUDVE | CRUE | R | R |
| **Commandes Clients** | CRUDVE | CRUDVE | R | R | R | CRUDVE | CRUDVE | CRUE | RE | RE |
| **Factures Clients** | CRUDVE | CRUDVE | R | R | R | CRUDVE | CRUE | RE | R | R |
| **Articles** | CRUDVE | CRUDVE | RUE | RUE | R | RUE | RUE | R | RU | R |
| **Stocks** | CRUDVE | CRUDVE | RE | RE | RE | RE | RE | RE | CRUDVE | CRUDVE |
| **Inventaires** | CRUDVE | CRUDVE | RVE | RVE | R | R | R | R | CRUDVE | CRU |
| **Rapports** | RE | RE | RE | RE | RE | RE | RE | RE | RE | R |

**Légende** :
- C = Création, R = Lecture, U = Modification, D = Suppression, V = Validation, E = Export
- Les permissions peuvent être affinées selon les seuils de montants ou autres critères métier

### 4.4 Gestion des accès et sécurité

#### 4.4.1 Principes de gestion des accès
- **Principe du moindre privilège** : Chaque utilisateur dispose uniquement des droits nécessaires à sa fonction
- **Séparation des tâches** : Les fonctions sensibles requièrent l'intervention de plusieurs acteurs (ex: création et validation)
- **Traçabilité** : Tous les accès et actions sont journalisés avec horodatage
- **Révision périodique** : Les droits d'accès sont révisés semestriellement ou à chaque changement de fonction

#### 4.4.2 Authentification et connexion
- **Identifiants uniques** : Chaque utilisateur dispose d'un identifiant unique et personnel
- **Mots de passe** : 
  - Longueur minimum : 12 caractères
  - Complexité requise : majuscules, minuscules, chiffres, caractères spéciaux
  - Renouvellement : tous les 90 jours
  - Historique : interdiction de réutiliser les 5 derniers mots de passe
- **Authentification multi-facteurs (MFA)** :
  - Obligatoire pour les administrateurs
  - Recommandée pour les rôles à responsabilité (directeurs, responsables)
  - Optionnelle pour les autres utilisateurs
- **Gestion des sessions** :
  - Timeout après 30 minutes d'inactivité
  - Déconnexion automatique en fin de journée
  - Une seule session active par utilisateur

#### 4.4.3 Délégation et substitution
- **Délégation temporaire** : Un utilisateur peut déléguer ses droits à un autre utilisateur pour une période définie
- **Suppléance** : Mise en place de suppléants pour les rôles critiques (validation, approbation)
- **Traçabilité** : Toute action réalisée en délégation est tracée avec l'identité du délégant et du délégataire

#### 4.4.4 Workflows de validation

**Validation des demandes d'achat** :
- Montant < 500 € : Validation par le Responsable Achats
- Montant 500 € - 5 000 € : Validation par le Responsable Achats + Chef de Service
- Montant 5 000 € - 50 000 € : Validation par le Directeur des Achats
- Montant > 50 000 € : Validation par le Directeur des Achats + Direction Générale

**Validation des bons de commande** :
- Montant < 1 000 € : Validation par l'Acheteur
- Montant 1 000 € - 10 000 € : Validation par le Responsable Achats
- Montant 10 000 € - 100 000 € : Validation par le Directeur des Achats
- Montant > 100 000 € : Validation par le Directeur des Achats + Direction Générale

**Validation des devis clients** :
- Montant < 10 000 € et remise < 5% : Validation par le Commercial
- Montant 10 000 € - 50 000 € ou remise 5-10% : Validation par le Responsable Commercial
- Montant 50 000 € - 500 000 € ou remise 10-20% : Validation par le Directeur Commercial
- Montant > 500 000 € ou remise > 20% : Validation par le Directeur Commercial + Direction Générale

**Validation des écarts d'inventaire** :
- Écart < 1 000 € : Validation par le Responsable Entrepôt
- Écart 1 000 € - 10 000 € : Validation par le Directeur Logistique
- Écart > 10 000 € : Validation par le Directeur Logistique + Direction Financière

*Note : Les seuils ci-dessus sont indicatifs et devront être adaptés selon la taille et les pratiques de l'entreprise*

#### 4.4.5 Audit et journalisation

**Événements journalisés** :
- Connexions et déconnexions (succès et échecs)
- Création, modification, suppression de données
- Validations et refus de workflows
- Exports de données
- Modifications de droits d'accès
- Accès aux données sensibles (fiches clients, fournisseurs, tarifs)

**Informations enregistrées** :
- Identifiant utilisateur
- Date et heure de l'action
- Type d'action effectuée
- Objet concerné (référence, identifiant)
- Anciennes et nouvelles valeurs (pour les modifications)
- Adresse IP de connexion
- Résultat de l'action (succès/échec)

**Conservation des logs** :
- Logs d'accès : 12 mois en ligne, 5 ans en archivage
- Logs de modification de données : Durée de conservation légale (10 ans pour données comptables)
- Logs système : 3 mois en ligne

**Consultation des logs** :
- Administrateur Système : Accès complet
- Auditeur : Accès complet en lecture seule
- Responsables métier : Accès aux logs de leur périmètre
- Utilisateurs : Accès à leur propre historique d'actions

#### 4.4.6 Gestion des départs et arrivées

**Arrivée d'un nouvel utilisateur** :
1. Création du compte par l'Administrateur Fonctionnel
2. Attribution du/des rôle(s) selon la fonction
3. Attribution du périmètre (entité, entrepôt, portefeuille)
4. Génération d'un mot de passe temporaire
5. Formation initiale à l'application
6. Premier accès avec changement obligatoire du mot de passe

**Départ d'un utilisateur** :
1. Désactivation immédiate du compte (pas de suppression)
2. Révocation de tous les accès et délégations
3. Transfert des dossiers en cours à un autre utilisateur
4. Archivage de l'historique des actions
5. Conservation des données pour la traçabilité et l'audit

**Changement de fonction** :
1. Révision des rôles attribués
2. Ajout/retrait de permissions selon nouvelle fonction
3. Transfert du périmètre d'activité
4. Formation complémentaire si nécessaire
5. Traçabilité du changement dans les logs

### 4.5 Gestion des données sensibles et confidentialité

#### 4.5.1 Classification des données
- **Données publiques** : Catalogues produits, informations générales
- **Données internes** : Stocks, mouvements, statistiques globales
- **Données confidentielles** : Tarifs, marges, conditions commerciales, données clients/fournisseurs
- **Données hautement confidentielles** : Stratégies d'achat, contrats cadres, données financières consolidées

#### 4.5.2 Contrôle d'accès selon classification
- Accès aux données confidentielles limité aux rôles concernés
- Masquage des données sensibles pour les rôles non autorisés (ex: marges pour les commerciaux)
- Watermarking des exports de données confidentielles
- Alerte automatique en cas d'accès inhabituel à des données sensibles

#### 4.5.3 Conformité RGPD
- **Consentement** : Enregistrement du consentement pour traitement des données personnelles
- **Droit d'accès** : Possibilité pour les personnes concernées de consulter leurs données
- **Droit de rectification** : Procédure de correction des données personnelles
- **Droit à l'effacement** : Mécanisme d'anonymisation pour respecter le droit à l'oubli
- **Portabilité** : Export des données personnelles dans un format exploitable
- **DPO** : Désignation d'un délégué à la protection des données

### 4.6 Formation et support

#### 4.6.1 Plan de formation
- **Formation des administrateurs** : 3 jours (technique et fonctionnel)
- **Formation des référents métier** : 2 jours (fonctionnel approfondi par module)
- **Formation des utilisateurs clés** : 2 jours (fonctionnel par rôle)
- **Formation des utilisateurs finaux** : 1 jour (fonctionnel basique)
- **Sessions de e-learning** : Modules complémentaires en auto-formation

#### 4.6.2 Documentation
- **Documentation utilisateur** : Guide par rôle avec cas d'usage
- **Documentation administrateur** : Guide d'administration technique et fonctionnelle
- **FAQ** : Base de connaissances des questions fréquentes
- **Vidéos tutorielles** : Capsules courtes pour les opérations courantes

#### 4.6.3 Support utilisateur
- **Niveau 1** : Référents métier (support de proximité)
- **Niveau 2** : Administrateurs fonctionnels
- **Niveau 3** : Équipe technique / Éditeur
- **Plateforme de ticketing** : Outil de gestion des demandes avec SLA définis
- **Heures de support** : 8h-18h en jours ouvrés (extensible selon besoins)

---

## 5. Annexes

### 5.1 Glossaire
- **ERP** : Enterprise Resource Planning (Progiciel de Gestion Intégré)
- **FIFO** : First In, First Out (Premier Entré, Premier Sorti)
- **FEFO** : First Expired, First Out (Premier Périmé, Premier Sorti)
- **LIFO** : Last In, First Out (Dernier Entré, Premier Sorti)
- **CUMP** : Coût Unitaire Moyen Pondéré
- **KPI** : Key Performance Indicator (Indicateur Clé de Performance)
- **SLA** : Service Level Agreement (Accord de Niveau de Service)
- **PRA** : Plan de Reprise d'Activité
- **RPO** : Recovery Point Objective (Perte de données maximale acceptable)
- **RTO** : Recovery Time Objective (Durée maximale d'interruption acceptable)
- **RGPD** : Règlement Général sur la Protection des Données
- **MFA** : Multi-Factor Authentication (Authentification Multi-Facteurs)

### 5.2 Références
- Documentation RGPD : https://www.cnil.fr/
- OWASP Top 10 : https://owasp.org/www-project-top-ten/
- WCAG 2.1 : https://www.w3.org/WAI/WCAG21/quickref/

### 5.3 Historique des versions
| Version | Date | Auteur | Description |
|---------|------|--------|-------------|
| 1.0 | [Date] | [Auteur] | Version initiale du cahier des charges |

