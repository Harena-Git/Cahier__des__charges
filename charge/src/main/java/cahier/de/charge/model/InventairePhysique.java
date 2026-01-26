package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class InventairePhysique implements Serializable {
    private Integer id;
    private Integer depotId;
    private Date dateInventaire;
    private String statut;
    private Timestamp dateCreation;

    public InventairePhysique() {}

    public InventairePhysique(Integer id, Integer depotId, Date dateInventaire, String statut, Timestamp dateCreation) {
        this.id = id;
        this.depotId = depotId;
        this.dateInventaire = dateInventaire;
        this.statut = statut;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getDepotId() { return depotId; }
    public void setDepotId(Integer depotId) { this.depotId = depotId; }
    
    public Date getDateInventaire() { return dateInventaire; }
    public void setDateInventaire(Date dateInventaire) { this.dateInventaire = dateInventaire; }
    
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}