package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class EncaissementClient implements Serializable {
    private Integer id;
    private String numeroEncaissement;
    private Integer factureClientId;
    private Date dateEncaissement;
    private Integer modePaiementId;
    private Timestamp dateCreation;

    public EncaissementClient() {}

    public EncaissementClient(Integer id, String numeroEncaissement, Integer factureClientId, 
                              Date dateEncaissement, Integer modePaiementId, Timestamp dateCreation) {
        this.id = id;
        this.numeroEncaissement = numeroEncaissement;
        this.factureClientId = factureClientId;
        this.dateEncaissement = dateEncaissement;
        this.modePaiementId = modePaiementId;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroEncaissement() { return numeroEncaissement; }
    public void setNumeroEncaissement(String numeroEncaissement) { this.numeroEncaissement = numeroEncaissement; }
    
    public Integer getFactureClientId() { return factureClientId; }
    public void setFactureClientId(Integer factureClientId) { this.factureClientId = factureClientId; }
    
    public Date getDateEncaissement() { return dateEncaissement; }
    public void setDateEncaissement(Date dateEncaissement) { this.dateEncaissement = dateEncaissement; }
    
    public Integer getModePaiementId() { return modePaiementId; }
    public void setModePaiementId(Integer modePaiementId) { this.modePaiementId = modePaiementId; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}