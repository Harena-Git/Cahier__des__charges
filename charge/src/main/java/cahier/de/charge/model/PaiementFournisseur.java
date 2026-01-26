package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class PaiementFournisseur implements Serializable {
    private Integer id;
    private String numeroPaiement;
    private Integer factureFournisseurId;
    private Date datePaiement;
    private Integer modePaiementId;
    private Timestamp dateCreation;

    public PaiementFournisseur() {}

    public PaiementFournisseur(Integer id, String numeroPaiement, Integer factureFournisseurId, 
                               Date datePaiement, Integer modePaiementId, Timestamp dateCreation) {
        this.id = id;
        this.numeroPaiement = numeroPaiement;
        this.factureFournisseurId = factureFournisseurId;
        this.datePaiement = datePaiement;
        this.modePaiementId = modePaiementId;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroPaiement() { return numeroPaiement; }
    public void setNumeroPaiement(String numeroPaiement) { this.numeroPaiement = numeroPaiement; }
    
    public Integer getFactureFournisseurId() { return factureFournisseurId; }
    public void setFactureFournisseurId(Integer factureFournisseurId) { this.factureFournisseurId = factureFournisseurId; }
    
    public Date getDatePaiement() { return datePaiement; }
    public void setDatePaiement(Date datePaiement) { this.datePaiement = datePaiement; }
    
    public Integer getModePaiementId() { return modePaiementId; }
    public void setModePaiementId(Integer modePaiementId) { this.modePaiementId = modePaiementId; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}