package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class MouvementStock implements Serializable {
    private Integer id;
    private Timestamp dateHeure;
    private Integer utilisateurId;
    private Integer typeMouvementId;
    private Integer articleId;
    private Integer lotId;
    private BigDecimal quantite;
    private Integer emplacementSourceId;
    private Integer emplacementDestinationId;

    public MouvementStock() {}

    public MouvementStock(Integer id, Timestamp dateHeure, Integer utilisateurId, Integer typeMouvementId, 
                          Integer articleId, Integer lotId, BigDecimal quantite, Integer emplacementSourceId, 
                          Integer emplacementDestinationId) {
        this.id = id;
        this.dateHeure = dateHeure;
        this.utilisateurId = utilisateurId;
        this.typeMouvementId = typeMouvementId;
        this.articleId = articleId;
        this.lotId = lotId;
        this.quantite = quantite;
        this.emplacementSourceId = emplacementSourceId;
        this.emplacementDestinationId = emplacementDestinationId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Timestamp getDateHeure() { return dateHeure; }
    public void setDateHeure(Timestamp dateHeure) { this.dateHeure = dateHeure; }
    
    public Integer getUtilisateurId() { return utilisateurId; }
    public void setUtilisateurId(Integer utilisateurId) { this.utilisateurId = utilisateurId; }
    
    public Integer getTypeMouvementId() { return typeMouvementId; }
    public void setTypeMouvementId(Integer typeMouvementId) { this.typeMouvementId = typeMouvementId; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public Integer getLotId() { return lotId; }
    public void setLotId(Integer lotId) { this.lotId = lotId; }
    
    public BigDecimal getQuantite() { return quantite; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }
    
    public Integer getEmplacementSourceId() { return emplacementSourceId; }
    public void setEmplacementSourceId(Integer emplacementSourceId) { this.emplacementSourceId = emplacementSourceId; }
    
    public Integer getEmplacementDestinationId() { return emplacementDestinationId; }
    public void setEmplacementDestinationId(Integer emplacementDestinationId) { this.emplacementDestinationId = emplacementDestinationId; }
}