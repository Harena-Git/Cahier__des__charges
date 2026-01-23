
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class ProformaFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Fournisseur fournisseur;

@ManyToOne
private DemandeAchat demandeachat;

@ManyToOne
private Devise devise;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
