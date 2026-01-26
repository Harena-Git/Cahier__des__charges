package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class CommandeClient implements Serializable {
    private Integer id;
    private String numeroCommande;
    private Integer proformaClientId;
    private Date dateCommande;
    private Integer depotId;
    private Integer modePaiementId;
    private Timestamp dateCreation;

    public CommandeClient() {}

    public CommandeClient(Integer id, String numeroCommande, Integer proformaClientId, Date dateCommande, 
                          Integer depotId, Integer modePaiementId, Timestamp dateCreation) {
        this.id = id;
        this.numeroCommande = numeroCommande;
        this.proformaClientId = proformaClientId;
        this.dateCommande = dateCommande;
        this.depotId = depotId;
        this.modePaiementId = modePaiementId;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroCommande() { return numeroCommande; }
    public void setNumeroCommande(String numeroCommande) { this.numeroCommande = numeroCommande; }
    
    public Integer getProformaClientId() { return proformaClientId; }
    public void setProformaClientId(Integer proformaClientId) { this.proformaClientId = proformaClientId; }
    
    public Date getDateCommande() { return dateCommande; }
    public void setDateCommande(Date dateCommande) { this.dateCommande = dateCommande; }
    
    public Integer getDepotId() { return depotId; }
    public void setDepotId(Integer depotId) { this.depotId = depotId; }
    
    public Integer getModePaiementId() { return modePaiementId; }
    public void setModePaiementId(Integer modePaiementId) { this.modePaiementId = modePaiementId; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}