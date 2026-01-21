
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur_applicatif")
public class UtilisateurApplicatif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "profil_utilisateur_id")
    private ProfilUtilisateur profilUtilisateur;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ProfilUtilisateur getProfilUtilisateur() {
        return profilUtilisateur;
    }

    public void setProfilUtilisateur(ProfilUtilisateur profilUtilisateur) {
        this.profilUtilisateur = profilUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
