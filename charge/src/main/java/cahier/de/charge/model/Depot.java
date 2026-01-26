package cahier.de.charge.model;

import java.io.Serializable;

public class Depot implements Serializable {
    private Integer id;
    private String nom;
    private String code;
    private Integer siteId;

    public Depot() {}

    public Depot(Integer id, String nom, String code, Integer siteId) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.siteId = siteId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public Integer getSiteId() { return siteId; }
    public void setSiteId(Integer siteId) { this.siteId = siteId; }
}