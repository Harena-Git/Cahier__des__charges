
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "proformaclient")
public class ProformaClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
