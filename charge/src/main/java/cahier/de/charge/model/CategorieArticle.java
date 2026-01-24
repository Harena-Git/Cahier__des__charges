
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class CategorieArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private MethodeGestion methodegestion;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
