
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "encaissementclient")
public class EncaissementClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
