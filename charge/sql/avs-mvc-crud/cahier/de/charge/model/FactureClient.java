
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class FactureClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private BonLivraison bonlivraison;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
