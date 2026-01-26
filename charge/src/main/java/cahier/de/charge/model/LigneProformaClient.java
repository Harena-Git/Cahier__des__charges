package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LigneProformaClient implements Serializable {
    private Integer id;
    private Integer proformaClientId;
    private Integer articleId;
    private BigDecimal quantite;
    private BigDecimal prix;

    public LigneProformaClient() {}

    public LigneProformaClient(Integer id, Integer proformaClientId, Integer articleId, BigDecimal quantite, BigDecimal prix) {
        this.id = id;
        this.proformaClientId = proformaClientId;
        this.articleId = articleId;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getProformaClientId() { return proformaClientId; }
    public void setProformaClientId(Integer proformaClientId) { this.proformaClientId = proformaClientId; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public BigDecimal getQuantite() { return quantite; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }
    
    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }
}