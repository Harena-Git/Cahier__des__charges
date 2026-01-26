package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Lot implements Serializable {
    private Integer id;
    private String numeroLot;
    private Integer articleId;
    private Date dateExpiration;
    private BigDecimal quantiteDisponible;
    private String statut;
    private Timestamp dateCreation;

    public Lot() {}

    public Lot(Integer id, String numeroLot, Integer articleId, Date dateExpiration, 
               BigDecimal quantiteDisponible, String statut, Timestamp dateCreation) {
        this.id = id;
        this.numeroLot = numeroLot;
        this.articleId = articleId;
        this.dateExpiration = dateExpiration;
        this.quantiteDisponible = quantiteDisponible;
        this.statut = statut;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroLot() { return numeroLot; }
    public void setNumeroLot(String numeroLot) { this.numeroLot = numeroLot; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public Date getDateExpiration() { return dateExpiration; }
    public void setDateExpiration(Date dateExpiration) { this.dateExpiration = dateExpiration; }
    
    public BigDecimal getQuantiteDisponible() { return quantiteDisponible; }
    public void setQuantiteDisponible(BigDecimal quantiteDisponible) { this.quantiteDisponible = quantiteDisponible; }
    
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}