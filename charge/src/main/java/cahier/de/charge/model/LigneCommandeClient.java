package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LigneCommandeClient implements Serializable {
    private Integer id;
    private Integer commandeClientId;
    private Integer ligneProformaClientId;
    private BigDecimal quantiteLivree;

    public LigneCommandeClient() {}

    public LigneCommandeClient(Integer id, Integer commandeClientId, Integer ligneProformaClientId, BigDecimal quantiteLivree) {
        this.id = id;
        this.commandeClientId = commandeClientId;
        this.ligneProformaClientId = ligneProformaClientId;
        this.quantiteLivree = quantiteLivree;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getCommandeClientId() { return commandeClientId; }
    public void setCommandeClientId(Integer commandeClientId) { this.commandeClientId = commandeClientId; }
    
    public Integer getLigneProformaClientId() { return ligneProformaClientId; }
    public void setLigneProformaClientId(Integer ligneProformaClientId) { this.ligneProformaClientId = ligneProformaClientId; }
    
    public BigDecimal getQuantiteLivree() { return quantiteLivree; }
    public void setQuantiteLivree(BigDecimal quantiteLivree) { this.quantiteLivree = quantiteLivree; }
}