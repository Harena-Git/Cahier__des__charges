package cahier.de.charge.model;

import java.io.Serializable;

public class CategorieArticle implements Serializable {
    private Integer id;
    private String code;
    private String nom;
    private Integer methodeGestionId;

    public CategorieArticle() {}

    public CategorieArticle(Integer id, String code, String nom, Integer methodeGestionId) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.methodeGestionId = methodeGestionId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public Integer getMethodeGestionId() { return methodeGestionId; }
    public void setMethodeGestionId(Integer methodeGestionId) { this.methodeGestionId = methodeGestionId; }
}