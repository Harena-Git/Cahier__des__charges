package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Acompte implements Serializable {
    private Integer id;
    private Integer clientId;
    private Integer fournisseurId;
    private Date dateAcompte;
    private BigDecimal montant;
    private Integer imputeSurFactureId;
    private Timestamp dateCreation;

    public Acompte() {}

    public Acompte(Integer id, Integer clientId, Integer fournisseurId, Date dateAcompte, 
                   BigDecimal montant, Integer imputeSurFactureId, Timestamp dateCreation) {
        this.id = id;
        this.clientId = clientId;
        this.fournisseurId = fournisseurId;
        this.dateAcompte = dateAcompte;
        this.montant = montant;
        this.imputeSurFactureId = imputeSurFactureId;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getClientId() { return clientId; }
    public void setClientId(Integer clientId) { this.clientId = clientId; }
    
    public Integer getFournisseurId() { return fournisseurId; }
    public void setFournisseurId(Integer fournisseurId) { this.fournisseurId = fournisseurId; }
    
    public Date getDateAcompte() { return dateAcompte; }
    public void setDateAcompte(Date dateAcompte) { this.dateAcompte = dateAcompte; }
    
    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }
    
    public Integer getImputeSurFactureId() { return imputeSurFactureId; }
    public void setImputeSurFactureId(Integer imputeSurFactureId) { this.imputeSurFactureId = imputeSurFactureId; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}