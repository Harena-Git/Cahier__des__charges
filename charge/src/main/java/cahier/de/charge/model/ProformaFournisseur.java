package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class ProformaFournisseur implements Serializable {
    private Integer id;
    private Integer fournisseurId;
    private Integer demandeAchatId;
    private String numeroProforma;
    private Date dateProforma;
    private Integer dureeValidite;
    private Integer deviseId;
    private Timestamp dateReception;

    public ProformaFournisseur() {}

    public ProformaFournisseur(Integer id, Integer fournisseurId, Integer demandeAchatId, String numeroProforma, 
                               Date dateProforma, Integer dureeValidite, Integer deviseId, Timestamp dateReception) {
        this.id = id;
        this.fournisseurId = fournisseurId;
        this.demandeAchatId = demandeAchatId;
        this.numeroProforma = numeroProforma;
        this.dateProforma = dateProforma;
        this.dureeValidite = dureeValidite;
        this.deviseId = deviseId;
        this.dateReception = dateReception;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getFournisseurId() { return fournisseurId; }
    public void setFournisseurId(Integer fournisseurId) { this.fournisseurId = fournisseurId; }
    
    public Integer getDemandeAchatId() { return demandeAchatId; }
    public void setDemandeAchatId(Integer demandeAchatId) { this.demandeAchatId = demandeAchatId; }
    
    public String getNumeroProforma() { return numeroProforma; }
    public void setNumeroProforma(String numeroProforma) { this.numeroProforma = numeroProforma; }
    
    public Date getDateProforma() { return dateProforma; }
    public void setDateProforma(Date dateProforma) { this.dateProforma = dateProforma; }
    
    public Integer getDureeValidite() { return dureeValidite; }
    public void setDureeValidite(Integer dureeValidite) { this.dureeValidite = dureeValidite; }
    
    public Integer getDeviseId() { return deviseId; }
    public void setDeviseId(Integer deviseId) { this.deviseId = deviseId; }
    
    public Timestamp getDateReception() { return dateReception; }
    public void setDateReception(Timestamp dateReception) { this.dateReception = dateReception; }
}