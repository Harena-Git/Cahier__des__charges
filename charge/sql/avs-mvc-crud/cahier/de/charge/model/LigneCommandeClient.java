
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class LigneCommandeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private CommandeClient commandeclient;

@ManyToOne
private LigneProformaClient ligneproformaclient;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
