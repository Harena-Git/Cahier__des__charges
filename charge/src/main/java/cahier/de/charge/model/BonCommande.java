package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class BonCommande implements Serializable {
    private Integer id;
    private String numeroBc;
    private Integer proformaFournisseurId;
    private Date dateEmission;
    private Timestamp dateCreation;

    public BonCommande() {}

    public BonCommande(Integer id, String numeroBc, Integer proformaFournisseurId, Date dateEmission, Timestamp dateCreation) {
        this.id = id;
        this.numeroBc = numeroBc;
        this.proformaFournisseurId = proformaFournisseurId;
        this.dateEmission = dateEmission;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroBc() { return numeroBc; }
    public void setNumeroBc(String numeroBc) { this.numeroBc = numeroBc; }
    
    public Integer getProformaFournisseurId() { return proformaFournisseurId; }
    public void setProformaFournisseurId(Integer proformaFournisseurId) { this.proformaFournisseurId = proformaFournisseurId; }
    
    public Date getDateEmission() { return dateEmission; }
    public void setDateEmission(Date dateEmission) { this.dateEmission = dateEmission; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}