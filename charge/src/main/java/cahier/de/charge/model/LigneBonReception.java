package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LigneBonReception implements Serializable {
    private Integer id;
    private Integer bonReceptionId;
    private Integer ligneBonCommandeId;
    private BigDecimal quantiteRecue;
    private Integer lotId;
    private Integer emplacementId;

    public LigneBonReception() {}

    public LigneBonReception(Integer id, Integer bonReceptionId, Integer ligneBonCommandeId, 
                             BigDecimal quantiteRecue, Integer lotId, Integer emplacementId) {
        this.id = id;
        this.bonReceptionId = bonReceptionId;
        this.ligneBonCommandeId = ligneBonCommandeId;
        this.quantiteRecue = quantiteRecue;
        this.lotId = lotId;
        this.emplacementId = emplacementId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getBonReceptionId() { return bonReceptionId; }
    public void setBonReceptionId(Integer bonReceptionId) { this.bonReceptionId = bonReceptionId; }
    
    public Integer getLigneBonCommandeId() { return ligneBonCommandeId; }
    public void setLigneBonCommandeId(Integer ligneBonCommandeId) { this.ligneBonCommandeId = ligneBonCommandeId; }
    
    public BigDecimal getQuantiteRecue() { return quantiteRecue; }
    public void setQuantiteRecue(BigDecimal quantiteRecue) { this.quantiteRecue = quantiteRecue; }
    
    public Integer getLotId() { return lotId; }
    public void setLotId(Integer lotId) { this.lotId = lotId; }
    
    public Integer getEmplacementId() { return emplacementId; }
    public void setEmplacementId(Integer emplacementId) { this.emplacementId = emplacementId; }
}