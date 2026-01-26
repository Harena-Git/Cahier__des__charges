package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LigneBonCommande implements Serializable {
    private Integer id;
    private Integer bonCommandeId;
    private Integer ligneProformaFournisseurId;
    private BigDecimal quantiteCommandee;

    public LigneBonCommande() {}

    public LigneBonCommande(Integer id, Integer bonCommandeId, Integer ligneProformaFournisseurId, BigDecimal quantiteCommandee) {
        this.id = id;
        this.bonCommandeId = bonCommandeId;
        this.ligneProformaFournisseurId = ligneProformaFournisseurId;
        this.quantiteCommandee = quantiteCommandee;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getBonCommandeId() { return bonCommandeId; }
    public void setBonCommandeId(Integer bonCommandeId) { this.bonCommandeId = bonCommandeId; }
    
    public Integer getLigneProformaFournisseurId() { return ligneProformaFournisseurId; }
    public void setLigneProformaFournisseurId(Integer ligneProformaFournisseurId) { this.ligneProformaFournisseurId = ligneProformaFournisseurId; }
    
    public BigDecimal getQuantiteCommandee() { return quantiteCommandee; }
    public void setQuantiteCommandee(BigDecimal quantiteCommandee) { this.quantiteCommandee = quantiteCommandee; }
}