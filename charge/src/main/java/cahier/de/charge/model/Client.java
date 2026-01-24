
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private TypeClient typeclient;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
