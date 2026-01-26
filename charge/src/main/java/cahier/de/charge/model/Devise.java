package cahier.de.charge.model;

import java.io.Serializable;

public class Devise implements Serializable {
    private Integer id;
    private String code;
    private String nom;

    public Devise() {}

    public Devise(Integer id, String code, String nom) {
        this.id = id;
        this.code = code;
        this.nom = nom;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}