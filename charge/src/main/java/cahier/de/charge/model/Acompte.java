
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class Acompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Client client;

@ManyToOne
private Fournisseur fournisseur;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
