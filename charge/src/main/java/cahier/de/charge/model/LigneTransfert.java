package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LigneTransfert implements Serializable {
    private Integer id;
    private Integer transfertInterDepotId;
    private Integer articleId;
    private Integer lotId;
    private BigDecimal quantite;

    public LigneTransfert() {}

    public LigneTransfert(Integer id, Integer transfertInterDepotId, Integer articleId, Integer lotId, BigDecimal quantite) {
        this.id = id;
        this.transfertInterDepotId = transfertInterDepotId;
        this.articleId = articleId;
        this.lotId = lotId;
        this.quantite = quantite;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getTransfertInterDepotId() { return transfertInterDepotId; }
    public void setTransfertInterDepotId(Integer transfertInterDepotId) { this.transfertInterDepotId = transfertInterDepotId; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public Integer getLotId() { return lotId; }
    public void setLotId(Integer lotId) { this.lotId = lotId; }
    
    public BigDecimal getQuantite() { return quantite; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }
}