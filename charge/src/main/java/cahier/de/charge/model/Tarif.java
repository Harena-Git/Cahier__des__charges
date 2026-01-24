
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class Tarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Article article;

@ManyToOne
private TypeClient typeclient;

@ManyToOne
private Site site;

@ManyToOne
private Devise devise;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
