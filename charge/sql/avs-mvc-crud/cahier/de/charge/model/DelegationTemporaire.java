
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class DelegationTemporaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Utilisateur utilisateur;

@ManyToOne
private Utilisateur utilisateur;

@ManyToOne
private Role role;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
