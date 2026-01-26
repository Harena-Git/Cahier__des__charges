package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class TransfertInterDepot implements Serializable {
    private Integer id;
    private Integer depotSourceId;
    private Integer depotDestinationId;
    private Date date;
    private Timestamp dateCreation;

    public TransfertInterDepot() {}

    public TransfertInterDepot(Integer id, Integer depotSourceId, Integer depotDestinationId, Date date, Timestamp dateCreation) {
        this.id = id;
        this.depotSourceId = depotSourceId;
        this.depotDestinationId = depotDestinationId;
        this.date = date;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getDepotSourceId() { return depotSourceId; }
    public void setDepotSourceId(Integer depotSourceId) { this.depotSourceId = depotSourceId; }
    
    public Integer getDepotDestinationId() { return depotDestinationId; }
    public void setDepotDestinationId(Integer depotDestinationId) { this.depotDestinationId = depotDestinationId; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}