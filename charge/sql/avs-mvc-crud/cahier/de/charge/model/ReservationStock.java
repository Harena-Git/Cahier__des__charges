
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class ReservationStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private CommandeClient commandeclient;

@ManyToOne
private Article article;

@ManyToOne
private Lot lot;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
