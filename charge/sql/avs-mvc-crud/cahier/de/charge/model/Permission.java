
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Fonctionnalite fonctionnalite;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
