package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class EmplacementStock implements Serializable {
    private Integer id;
    private Integer articleId;
    private Integer lotId;
    private Integer emplacementId;
    private BigDecimal quantite;
    private Integer uniteMesureId;
    private Timestamp dateDernierMouvement;
    private BigDecimal valeurStockHt;

    public EmplacementStock() {}

    public EmplacementStock(Integer id, Integer articleId, Integer lotId, Integer emplacementId, BigDecimal quantite, 
                            Integer uniteMesureId, Timestamp dateDernierMouvement, BigDecimal valeurStockHt) {
        this.id = id;
        this.articleId = articleId;
        this.lotId = lotId;
        this.emplacementId = emplacementId;
        this.quantite = quantite;
        this.uniteMesureId = uniteMesureId;
        this.dateDernierMouvement = dateDernierMouvement;
        this.valeurStockHt = valeurStockHt;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public Integer getLotId() { return lotId; }
    public void setLotId(Integer lotId) { this.lotId = lotId; }
    
    public Integer getEmplacementId() { return emplacementId; }
    public void setEmplacementId(Integer emplacementId) { this.emplacementId = emplacementId; }
    
    public BigDecimal getQuantite() { return quantite; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }
    
    public Integer getUniteMesureId() { return uniteMesureId; }
    public void setUniteMesureId(Integer uniteMesureId) { this.uniteMesureId = uniteMesureId; }
    
    public Timestamp getDateDernierMouvement() { return dateDernierMouvement; }
    public void setDateDernierMouvement(Timestamp dateDernierMouvement) { this.dateDernierMouvement = dateDernierMouvement; }
    
    public BigDecimal getValeurStockHt() { return valeurStockHt; }
    public void setValeurStockHt(BigDecimal valeurStockHt) { this.valeurStockHt = valeurStockHt; }
}