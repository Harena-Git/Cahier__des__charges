
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class BonLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private CommandeClient commandeclient;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
