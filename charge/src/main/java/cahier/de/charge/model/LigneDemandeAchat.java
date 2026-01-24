
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class LigneDemandeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private DemandeAchat demandeachat;

@ManyToOne
private Article article;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
