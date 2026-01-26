package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Fournisseur implements Serializable {
    private Integer id;
    private String raisonSociale;
    private String nifStat;
    private String telephone;
    private Timestamp dateCreation;

    public Fournisseur() {}

    public Fournisseur(Integer id, String raisonSociale, String nifStat, String telephone, Timestamp dateCreation) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.nifStat = nifStat;
        this.telephone = telephone;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getRaisonSociale() { return raisonSociale; }
    public void setRaisonSociale(String raisonSociale) { this.raisonSociale = raisonSociale; }
    
    public String getNifStat() { return nifStat; }
    public void setNifStat(String nifStat) { this.nifStat = nifStat; }
    
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}