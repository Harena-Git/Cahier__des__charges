package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LigneProformaFournisseur implements Serializable {
    private Integer id;
    private Integer proformaFournisseurId;
    private Integer ligneDemandeAchatId;
    private BigDecimal prixUnitaire;
    private BigDecimal remise;

    public LigneProformaFournisseur() {}

    public LigneProformaFournisseur(Integer id, Integer proformaFournisseurId, Integer ligneDemandeAchatId, 
                                    BigDecimal prixUnitaire, BigDecimal remise) {
        this.id = id;
        this.proformaFournisseurId = proformaFournisseurId;
        this.ligneDemandeAchatId = ligneDemandeAchatId;
        this.prixUnitaire = prixUnitaire;
        this.remise = remise;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getProformaFournisseurId() { return proformaFournisseurId; }
    public void setProformaFournisseurId(Integer proformaFournisseurId) { this.proformaFournisseurId = proformaFournisseurId; }
    
    public Integer getLigneDemandeAchatId() { return ligneDemandeAchatId; }
    public void setLigneDemandeAchatId(Integer ligneDemandeAchatId) { this.ligneDemandeAchatId = ligneDemandeAchatId; }
    
    public BigDecimal getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(BigDecimal prixUnitaire) { this.prixUnitaire = prixUnitaire; }
    
    public BigDecimal getRemise() { return remise; }
    public void setRemise(BigDecimal remise) { this.remise = remise; }
}