
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "typeclient")
public class TypeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
