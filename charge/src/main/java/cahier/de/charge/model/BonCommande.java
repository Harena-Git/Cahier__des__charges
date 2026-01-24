
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class BonCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private ProformaFournisseur proformafournisseur;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
