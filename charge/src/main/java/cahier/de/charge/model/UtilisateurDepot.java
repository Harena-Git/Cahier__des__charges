
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class UtilisateurDepot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Utilisateur utilisateur;

@ManyToOne
private Depot depot;

@ManyToOne
private Role role;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
