package cahier.de.charge.model;

import java.io.Serializable;

public class Societe implements Serializable {
    private Integer id;
    private String raisonSociale;
    private String code;
    private String adresse;
    private String ville;

    public Societe() {}

    public Societe(Integer id, String raisonSociale, String code, String adresse, String ville) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.code = code;
        this.adresse = adresse;
        this.ville = ville;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getRaisonSociale() { return raisonSociale; }
    public void setRaisonSociale(String raisonSociale) { this.raisonSociale = raisonSociale; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
}