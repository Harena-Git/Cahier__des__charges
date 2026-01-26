package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class AjustementStock implements Serializable {
    private Integer id;
    private String numeroAjustement;
    private Integer inventaireId;
    private Integer articleId;
    private Integer lotId;
    private Integer emplacementId;
    private BigDecimal quantiteTheorique;
    private BigDecimal quantiteReelle;
    private BigDecimal ecart;
    private String typeAjustement;
    private Date date;
    private Timestamp dateCreation;

    public AjustementStock() {}

    public AjustementStock(Integer id, String numeroAjustement, Integer inventaireId, Integer articleId, Integer lotId, 
                           Integer emplacementId, BigDecimal quantiteTheorique, BigDecimal quantiteReelle, 
                           BigDecimal ecart, String typeAjustement, Date date, Timestamp dateCreation) {
        this.id = id;
        this.numeroAjustement = numeroAjustement;
        this.inventaireId = inventaireId;
        this.articleId = articleId;
        this.lotId = lotId;
        this.emplacementId = emplacementId;
        this.quantiteTheorique = quantiteTheorique;
        this.quantiteReelle = quantiteReelle;
        this.ecart = ecart;
        this.typeAjustement = typeAjustement;
        this.date = date;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroAjustement() { return numeroAjustement; }
    public void setNumeroAjustement(String numeroAjustement) { this.numeroAjustement = numeroAjustement; }
    
    public Integer getInventaireId() { return inventaireId; }
    public void setInventaireId(Integer inventaireId) { this.inventaireId = inventaireId; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public Integer getLotId() { return lotId; }
    public void setLotId(Integer lotId) { this.lotId = lotId; }
    
    public Integer getEmplacementId() { return emplacementId; }
    public void setEmplacementId(Integer emplacementId) { this.emplacementId = emplacementId; }
    
    public BigDecimal getQuantiteTheorique() { return quantiteTheorique; }
    public void setQuantiteTheorique(BigDecimal quantiteTheorique) { this.quantiteTheorique = quantiteTheorique; }
    
    public BigDecimal getQuantiteReelle() { return quantiteReelle; }
    public void setQuantiteReelle(BigDecimal quantiteReelle) { this.quantiteReelle = quantiteReelle; }
    
    public BigDecimal getEcart() { return ecart; }
    public void setEcart(BigDecimal ecart) { this.ecart = ecart; }
    
    public String getTypeAjustement() { return typeAjustement; }
    public void setTypeAjustement(String typeAjustement) { this.typeAjustement = typeAjustement; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}