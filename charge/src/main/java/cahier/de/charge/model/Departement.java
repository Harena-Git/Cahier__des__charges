package cahier.de.charge.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "departement")
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, unique = true)
    private String nom;

    public Departement() {}

    public Departement(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}