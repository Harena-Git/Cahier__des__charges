package cahier.de.charge.model;

import java.io.Serializable;

public class Fonctionnalite implements Serializable {
    private Integer id;
    private Integer moduleId;
    private String code;
    private String nom;

    public Fonctionnalite() {}

    public Fonctionnalite(Integer id, Integer moduleId, String code, String nom) {
        this.id = id;
        this.moduleId = moduleId;
        this.code = code;
        this.nom = nom;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getModuleId() { return moduleId; }
    public void setModuleId(Integer moduleId) { this.moduleId = moduleId; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}