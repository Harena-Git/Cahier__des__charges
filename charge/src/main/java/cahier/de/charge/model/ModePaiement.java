
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modepaiement")
public class ModePaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
