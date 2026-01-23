
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class EmplacementStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Article article;

@ManyToOne
private Lot lot;

@ManyToOne
private Emplacement emplacement;

@ManyToOne
private UniteMesure unitemesure;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
