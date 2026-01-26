package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class FactureClient implements Serializable {
    private Integer id;
    private String numeroFactureClient;
    private Integer bonLivraisonId;
    private Date dateFacture;
    private BigDecimal montant;
    private Timestamp dateCreation;

    public FactureClient() {}

    public FactureClient(Integer id, String numeroFactureClient, Integer bonLivraisonId, 
                         Date dateFacture, BigDecimal montant, Timestamp dateCreation) {
        this.id = id;
        this.numeroFactureClient = numeroFactureClient;
        this.bonLivraisonId = bonLivraisonId;
        this.dateFacture = dateFacture;
        this.montant = montant;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroFactureClient() { return numeroFactureClient; }
    public void setNumeroFactureClient(String numeroFactureClient) { this.numeroFactureClient = numeroFactureClient; }
    
    public Integer getBonLivraisonId() { return bonLivraisonId; }
    public void setBonLivraisonId(Integer bonLivraisonId) { this.bonLivraisonId = bonLivraisonId; }
    
    public Date getDateFacture() { return dateFacture; }
    public void setDateFacture(Date dateFacture) { this.dateFacture = dateFacture; }
    
    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}