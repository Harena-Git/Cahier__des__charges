package cahier.de.charge.model;

import java.io.Serializable;

public class Site implements Serializable {
    private Integer id;
    private String nom;
    private String code;
    private String adresse;
    private String ville;
    private Integer societeId;

    public Site() {}

    public Site(Integer id, String nom, String code, String adresse, String ville, Integer societeId) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.adresse = adresse;
        this.ville = ville;
        this.societeId = societeId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    
    public Integer getSocieteId() { return societeId; }
    public void setSocieteId(Integer societeId) { this.societeId = societeId; }
}