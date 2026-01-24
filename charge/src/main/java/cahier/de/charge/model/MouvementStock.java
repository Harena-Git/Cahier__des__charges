
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class MouvementStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Utilisateur utilisateur;

@ManyToOne
private TypeMouvement typemouvement;

@ManyToOne
private Article article;

@ManyToOne
private Lot lot;

@ManyToOne
private Emplacement emplacement;

@ManyToOne
private Emplacement emplacement;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
