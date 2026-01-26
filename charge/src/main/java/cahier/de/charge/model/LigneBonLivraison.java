package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LigneBonLivraison implements Serializable {
    private Integer id;
    private Integer bonLivraisonId;
    private Integer ligneCommandeClientId;
    private Integer lotId;
    private BigDecimal quantiteLivree;
    private Integer emplacementId;

    public LigneBonLivraison() {}

    public LigneBonLivraison(Integer id, Integer bonLivraisonId, Integer ligneCommandeClientId, 
                             Integer lotId, BigDecimal quantiteLivree, Integer emplacementId) {
        this.id = id;
        this.bonLivraisonId = bonLivraisonId;
        this.ligneCommandeClientId = ligneCommandeClientId;
        this.lotId = lotId;
        this.quantiteLivree = quantiteLivree;
        this.emplacementId = emplacementId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getBonLivraisonId() { return bonLivraisonId; }
    public void setBonLivraisonId(Integer bonLivraisonId) { this.bonLivraisonId = bonLivraisonId; }
    
    public Integer getLigneCommandeClientId() { return ligneCommandeClientId; }
    public void setLigneCommandeClientId(Integer ligneCommandeClientId) { this.ligneCommandeClientId = ligneCommandeClientId; }
    
    public Integer getLotId() { return lotId; }
    public void setLotId(Integer lotId) { this.lotId = lotId; }
    
    public BigDecimal getQuantiteLivree() { return quantiteLivree; }
    public void setQuantiteLivree(BigDecimal quantiteLivree) { this.quantiteLivree = quantiteLivree; }
    
    public Integer getEmplacementId() { return emplacementId; }
    public void setEmplacementId(Integer emplacementId) { this.emplacementId = emplacementId; }
}