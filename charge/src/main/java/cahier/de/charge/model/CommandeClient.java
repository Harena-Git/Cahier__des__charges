
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class CommandeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private ProformaClient proformaclient;

@ManyToOne
private Depot depot;

@ManyToOne
private ModePaiement modepaiement;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
