
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class DemandeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Departement departement;

@ManyToOne
private Site site;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
