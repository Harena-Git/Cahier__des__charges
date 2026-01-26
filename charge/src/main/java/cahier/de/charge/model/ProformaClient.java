package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class ProformaClient implements Serializable {
    private Integer id;
    private String numeroProforma;
    private Integer clientId;
    private Date date;
    private Integer deviseId;
    private Timestamp dateCreation;

    public ProformaClient() {}

    public ProformaClient(Integer id, String numeroProforma, Integer clientId, Date date, Integer deviseId, Timestamp dateCreation) {
        this.id = id;
        this.numeroProforma = numeroProforma;
        this.clientId = clientId;
        this.date = date;
        this.deviseId = deviseId;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroProforma() { return numeroProforma; }
    public void setNumeroProforma(String numeroProforma) { this.numeroProforma = numeroProforma; }
    
    public Integer getClientId() { return clientId; }
    public void setClientId(Integer clientId) { this.clientId = clientId; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    
    public Integer getDeviseId() { return deviseId; }
    public void setDeviseId(Integer deviseId) { this.deviseId = deviseId; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}