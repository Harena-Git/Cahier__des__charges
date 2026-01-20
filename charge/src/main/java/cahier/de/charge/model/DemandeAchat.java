
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "demandeachat")
public class DemandeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
