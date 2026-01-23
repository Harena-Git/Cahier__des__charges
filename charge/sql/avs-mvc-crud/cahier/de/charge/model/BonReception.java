
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class BonReception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private BonCommande boncommande;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
