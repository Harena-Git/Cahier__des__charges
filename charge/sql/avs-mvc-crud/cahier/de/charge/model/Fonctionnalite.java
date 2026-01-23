
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class Fonctionnalite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Module module;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
