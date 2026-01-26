package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class LigneInventaire implements Serializable {
    private Integer id;
    private Integer inventaireId;
    private Integer articleId;
    private Integer lotId;
    private Integer emplacementId;
    private BigDecimal quantiteTheorique;
    private BigDecimal quantitePhysique;
    private BigDecimal ecart;
    private Timestamp dateSaisie;

    public LigneInventaire() {}

    public LigneInventaire(Integer id, Integer inventaireId, Integer articleId, Integer lotId, Integer emplacementId, 
                           BigDecimal quantiteTheorique, BigDecimal quantitePhysique, BigDecimal ecart, Timestamp dateSaisie) {
        this.id = id;
        this.inventaireId = inventaireId;
        this.articleId = articleId;
        this.lotId = lotId;
        this.emplacementId = emplacementId;
        this.quantiteTheorique = quantiteTheorique;
        this.quantitePhysique = quantitePhysique;
        this.ecart = ecart;
        this.dateSaisie = dateSaisie;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
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
    
    public BigDecimal getQuantitePhysique() { return quantitePhysique; }
    public void setQuantitePhysique(BigDecimal quantitePhysique) { this.quantitePhysique = quantitePhysique; }
    
    public BigDecimal getEcart() { return ecart; }
    public void setEcart(BigDecimal ecart) { this.ecart = ecart; }
    
    public Timestamp getDateSaisie() { return dateSaisie; }
    public void setDateSaisie(Timestamp dateSaisie) { this.dateSaisie = dateSaisie; }
}