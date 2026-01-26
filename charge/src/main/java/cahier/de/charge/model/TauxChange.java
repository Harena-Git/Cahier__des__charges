package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class TauxChange implements Serializable {
    private Integer id;
    private Integer deviseFromId;
    private Integer deviseToId;
    private BigDecimal taux;
    private Date dateApplication;

    public TauxChange() {}

    public TauxChange(Integer id, Integer deviseFromId, Integer deviseToId, BigDecimal taux, Date dateApplication) {
        this.id = id;
        this.deviseFromId = deviseFromId;
        this.deviseToId = deviseToId;
        this.taux = taux;
        this.dateApplication = dateApplication;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getDeviseFromId() { return deviseFromId; }
    public void setDeviseFromId(Integer deviseFromId) { this.deviseFromId = deviseFromId; }
    
    public Integer getDeviseToId() { return deviseToId; }
    public void setDeviseToId(Integer deviseToId) { this.deviseToId = deviseToId; }
    
    public BigDecimal getTaux() { return taux; }
    public void setTaux(BigDecimal taux) { this.taux = taux; }
    
    public Date getDateApplication() { return dateApplication; }
    public void setDateApplication(Date dateApplication) { this.dateApplication = dateApplication; }
}