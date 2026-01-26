package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LigneDemandeAchat implements Serializable {
    private Integer id;
    private Integer demandeAchatId;
    private Integer articleId;
    private String designation;
    private BigDecimal quantite;

    public LigneDemandeAchat() {}

    public LigneDemandeAchat(Integer id, Integer demandeAchatId, Integer articleId, String designation, BigDecimal quantite) {
        this.id = id;
        this.demandeAchatId = demandeAchatId;
        this.articleId = articleId;
        this.designation = designation;
        this.quantite = quantite;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getDemandeAchatId() { return demandeAchatId; }
    public void setDemandeAchatId(Integer demandeAchatId) { this.demandeAchatId = demandeAchatId; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    
    public BigDecimal getQuantite() { return quantite; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }
}