package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class DemandeAchat implements Serializable {
    private Integer id;
    private String numeroDa;
    private Date dateDemande;
    private Integer departementId;
    private Integer siteId;
    private String status;
    private Timestamp dateCreation;

    public DemandeAchat() {}

    public DemandeAchat(Integer id, String numeroDa, Date dateDemande, Integer departementId, Integer siteId, 
                        String status, Timestamp dateCreation) {
        this.id = id;
        this.numeroDa = numeroDa;
        this.dateDemande = dateDemande;
        this.departementId = departementId;
        this.siteId = siteId;
        this.status = status;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroDa() { return numeroDa; }
    public void setNumeroDa(String numeroDa) { this.numeroDa = numeroDa; }
    
    public Date getDateDemande() { return dateDemande; }
    public void setDateDemande(Date dateDemande) { this.dateDemande = dateDemande; }
    
    public Integer getDepartementId() { return departementId; }
    public void setDepartementId(Integer departementId) { this.departementId = departementId; }
    
    public Integer getSiteId() { return siteId; }
    public void setSiteId(Integer siteId) { this.siteId = siteId; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}