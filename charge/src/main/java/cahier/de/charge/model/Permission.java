package cahier.de.charge.model;

import java.io.Serializable;

public class Permission implements Serializable {
    private Integer id;
    private Integer fonctionnaliteId;
    private String code;
    private String nom;

    public Permission() {}

    public Permission(Integer id, Integer fonctionnaliteId, String code, String nom) {
        this.id = id;
        this.fonctionnaliteId = fonctionnaliteId;
        this.code = code;
        this.nom = nom;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getFonctionnaliteId() { return fonctionnaliteId; }
    public void setFonctionnaliteId(Integer fonctionnaliteId) { this.fonctionnaliteId = fonctionnaliteId; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}