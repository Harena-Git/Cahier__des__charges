> *Combien*

## Fanazavana objectifs

Controle interne: systeme de controle apetraky ny administration (na informatique na procedurale)


## Perimetre fonctionnel

### Achat
1. Demande: misy service/departement manao demande d'achat (mila zavatra, t@ RH nila olona).
2. Mankany @ `Service/Direction achat` ilay demande
	1. ataony copie ny magasinier sao efa misy anaty stock le angatahana vidiana
	2. rehefa tsisy anaty stock zay vao mangataka `Proforma` any @ fournisseurS (minimum 3) ny service direction
		`Proforma = Facture future raha hividy entana aman'olona`\
	3. Triage de proforma (saisie anaty systeme)
		1. izay moins 10 ans (mora indrindra) no raisin systeme
		izay tena kely indirindra
		
3. Mandeha ny approbation rehetra
	Vita proforma, dia presentena any @ finance
	hitenenana hoe: misy fikasana hividy zavatra, izay ito ny valeur any. Manana an'izany vola izany ve isika ?
4. Bon de commande (+ref proforma)
	 **acte irreversible** rehefa lasa any @ fournisseur.
	 PLUS  Ny signature ana document (DG, adjoint , DAF.)
	 io no fait generateur an'ny achat (declancheur)
	 
	miandry entana sisa zany.
 5. Bon de livraison
	 omeny an'ny magasinier.
	 Mety tsy mitovy ny bon de livraison (avy @ livreur fa soniavin le oppose) sy bon de reception (avy @ mpiasan'ny societe fa soniavin le oppose).
	 Conclusion: bon de reception no tena manankery kokoa
	 
    En general tonga dia miaraka @ facture ny bon de livraison, fa possible tsis
6. Reception facture
7. Paiement
	 rehefa tonga ny facture

---
### Vente
`f^-1` an'ny achat fotsiny

1. check stock
2. mamoka proforma
	1. misy validite (1 semaine, 3 jours) satria tsy hay raha ho lany le entana na tsia
3. miandry bon de commande
	1. mipreparer entanta
4. Mipreparer bon de livraison
5. Mandefa facture

### Stock
Mouvements rehetra no generena: achat, vente, transfert, reservation, lots/series, emplacements.
Misy `id` daholo izany
	Reservation: vao raikitra ny commande an'ny client dia efa reservena ny stock, @ livraison manaraka tsy voakasika intsony zany ny stock

### Inventaire
Ny tena important dia ny resaka ajustement de stock, iza no afaka manao an zany ?
- superieur hierarchique no manao ajustement ana stock

---
## Contraintes
Ilay systeme ve multi-sites, sa multi-depots sa multi-entites
### Multi-sites:
misy eny Tana, Mahajanga...
Client/stock an'Antsirabe ve tokony mahita ny zava-misy ety Antananarivo ?
	Tsy tokony, satria mety misy sabotage ana magasinier

Multi-site: 
- sady achat 
- no vente
- no stock
### Multi-depots
Multi-depot: 
- vente sy achat centralise amina toerana iray 
- fa depot/stock fotsiny no ananany

### Multi-entites
notion ana groupe de societe.
`Ex: BICI, Ketrika, ITU, Vidy Varotra`
Societes samihafa fa afaka manao transfert ana stock sy stock iarahana

---
## Gestion role
qui peut faire quoi ?
- RBAC: personne - olona
- ABAC: attribut - zavatra (tsy voatery toerana)

Acces temporaire a chaque role: 
	tsy eo a fa conge, dia omeko acces lo lah. Apres mikatona ny applis

Double validation
	magasinier, finance...

---
## Gestion de stock
Otrin ny valeur an'ny sortie, entree, stock ? 
	Methode de valorisation/gestion de stock eken'ny norme internationale:
- *CMUP: Coup Moyen Unitaire Pondere*
		Date, PU, QT, Valeur
	 1er Janvier, 1000, 20, 2000
	 2 Janvier, 500, 10, 5000
	- `PU = 25000/30 = 833,33`
	- Raha hamoaka entana zany ny 3 janvier, dia -15 * 833,33 no prix manaraka. 
	- donc `stock = 15 * 833.33`
	- Raha CMUP dia moyenne an'ny PU fotsiny
- *FIFO (PEPS): First In First Out*
     Date, PU, QT, Valeur
	 1er Janvier, 1000, 20, 2000
	 2 Janvier, 500, 10, 5000
	- Mbola tsisy nivoaka donc tsisy PU
	- Le 3 janvier namoaka 15 isika, donc -15 @ 1000 => -15000 no mivoaka
		- donc `stock = 5 * 1000 et 10 * 500`
	- **Last in no miconstituer ny stock an'ny FIFO**
- *LIFO (DEPS)*: efa manomboka tsy dia eken'ny firenena sasany
	 Date, PU, QT, Valeur
	 1er Janvier, 1000, 20, 2000
	 2 Janvier, 500, 10, 5000
	- Tsisy PU
	- Le 3 janvier, namoaka 15 isika
		- donc `stock = 15 * 1000`
	- **First in no miconstituer ny stock an'ny FIFO**

Firy ny quantite nivoaka/nihiditra, firy ny isan'ny ao anatiny ao
 -  FEFO: First Expiry 
	  - @ matiere de gestion d'article no tena mety, fa tsy mety @ gestion de valeur (le methodes eo ambony no mety)
	  - ex: mividy zavatra lany daty dia iny no amidy aingana satria azony mora, dia amidiny mora koa

Conclusion:
- au niveau quantite dia mety fona 
- par societe: une methode = regle des permanences des methodes
- FIFO no mirefleter realite indrindra
	- izay novidiana farany no anaty stock
	- raha mivarotra mety tsy ho faty antoka. Mirefleter ny tena valeur actuelle an le stock ilay ao
- Choix ilay atao fa tsy maintsy **justifiena**
	- par rapport @ nature an'ny produit:
		- zavatra perissable: FIFO
	- par rapport @ emplacement anaty depot
	- par rapport @ utilisation
- Gestion de quantite vitan'ny rehetra fa gestion de valeur no mila atao TSARA
- Prix d'achat dol reo, fa prix de vente definissiavana manokana
	- ny fanaon'ny olona: pourcentage par rapport @ prix d'achat
	- fa afaka overridena koa

*Atao dol izy rehetra, FEFO optionnel ?*

---

TODO: 
- Tsaraina any @ derniere session 💃
- Tsy mikitika Gel de coup et mouvements retrodates 
- Tsy mikitika FIFO
- Inventaire:
	- ajanona le tournant sy annuel
	- asina notion d'inventaire tout court fotsiny

---

## Vocabulaire
Avance = Accompte
