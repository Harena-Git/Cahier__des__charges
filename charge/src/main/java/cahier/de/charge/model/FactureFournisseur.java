package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class FactureFournisseur implements Serializable {
    private Integer id;
    private String numeroFactureFournisseur;
    private Integer bonReceptionId;
    private Date dateFacture;
    private BigDecimal montant;
    private Timestamp dateCreation;

    public FactureFournisseur() {}

    public FactureFournisseur(Integer id, String numeroFactureFournisseur, Integer bonReceptionId, 
                              Date dateFacture, BigDecimal montant, Timestamp dateCreation) {
        this.id = id;
        this.numeroFactureFournisseur = numeroFactureFournisseur;
        this.bonReceptionId = bonReceptionId;
        this.dateFacture = dateFacture;
        this.montant = montant;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroFactureFournisseur() { return numeroFactureFournisseur; }
    public void setNumeroFactureFournisseur(String numeroFactureFournisseur) { this.numeroFactureFournisseur = numeroFactureFournisseur; }
    
    public Integer getBonReceptionId() { return bonReceptionId; }
    public void setBonReceptionId(Integer bonReceptionId) { this.bonReceptionId = bonReceptionId; }
    
    public Date getDateFacture() { return dateFacture; }
    public void setDateFacture(Date dateFacture) { this.dateFacture = dateFacture; }
    
    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}