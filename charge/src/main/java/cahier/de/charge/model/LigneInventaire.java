
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class LigneInventaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private InventairePhysique inventairephysique;

@ManyToOne
private Article article;

@ManyToOne
private Lot lot;

@ManyToOne
private Emplacement emplacement;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
