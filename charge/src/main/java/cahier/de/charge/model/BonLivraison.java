package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class BonLivraison implements Serializable {
    private Integer id;
    private String numeroBl;
    private Integer commandeClientId;
    private Date dateLivraison;
    private Timestamp dateCreation;

    public BonLivraison() {}

    public BonLivraison(Integer id, String numeroBl, Integer commandeClientId, Date dateLivraison, Timestamp dateCreation) {
        this.id = id;
        this.numeroBl = numeroBl;
        this.commandeClientId = commandeClientId;
        this.dateLivraison = dateLivraison;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroBl() { return numeroBl; }
    public void setNumeroBl(String numeroBl) { this.numeroBl = numeroBl; }
    
    public Integer getCommandeClientId() { return commandeClientId; }
    public void setCommandeClientId(Integer commandeClientId) { this.commandeClientId = commandeClientId; }
    
    public Date getDateLivraison() { return dateLivraison; }
    public void setDateLivraison(Date dateLivraison) { this.dateLivraison = dateLivraison; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}