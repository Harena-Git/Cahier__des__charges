package cahier.de.charge.model;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    private Integer id;
    private String email;
    private String nom;
    private String prenom;
    private String telephone;
    private Integer siteId;

    public Utilisateur() {}

    public Utilisateur(Integer id, String email, String nom, String prenom, String telephone, Integer siteId) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.siteId = siteId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    
    public Integer getSiteId() { return siteId; }
    public void setSiteId(Integer siteId) { this.siteId = siteId; }
}