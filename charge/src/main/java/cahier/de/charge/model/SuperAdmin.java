package cahier.de.charge.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "super_admin")
public class SuperAdmin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true, nullable = false)
    private String nom;
    
    @Column(name = "mdp", nullable = false)
    private String mdp;

    public SuperAdmin() {}

    public SuperAdmin(Integer id, String nom, String mdp) {
        this.id = id;
        this.nom = nom;
        this.mdp = mdp;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getMdp() { return mdp; }
    public void setMdp(String mdp) { this.mdp = mdp; }
}
