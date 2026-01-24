
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class LigneBonLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private BonLivraison bonlivraison;

@ManyToOne
private LigneCommandeClient lignecommandeclient;

@ManyToOne
private Lot lot;

@ManyToOne
private Emplacement emplacement;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
