
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Societe societe;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
