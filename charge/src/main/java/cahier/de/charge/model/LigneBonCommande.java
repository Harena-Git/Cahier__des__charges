
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class LigneBonCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private BonCommande boncommande;

@ManyToOne
private LigneProformaFournisseur ligneproformafournisseur;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
