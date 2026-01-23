
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private CategorieArticle categoriearticle;

@ManyToOne
private UniteMesure unitemesure;

@ManyToOne
private UniteMesure unitemesure;

@ManyToOne
private UniteMesure unitemesure;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
