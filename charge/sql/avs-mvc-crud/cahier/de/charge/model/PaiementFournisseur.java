
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class PaiementFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private FactureFournisseur facturefournisseur;

@ManyToOne
private ModePaiement modepaiement;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
