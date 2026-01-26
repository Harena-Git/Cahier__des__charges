package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class BonReception implements Serializable {
    private Integer id;
    private String numeroBr;
    private Integer bonCommandeId;
    private Date dateReception;
    private Timestamp dateCreation;

    public BonReception() {}

    public BonReception(Integer id, String numeroBr, Integer bonCommandeId, Date dateReception, Timestamp dateCreation) {
        this.id = id;
        this.numeroBr = numeroBr;
        this.bonCommandeId = bonCommandeId;
        this.dateReception = dateReception;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNumeroBr() { return numeroBr; }
    public void setNumeroBr(String numeroBr) { this.numeroBr = numeroBr; }
    
    public Integer getBonCommandeId() { return bonCommandeId; }
    public void setBonCommandeId(Integer bonCommandeId) { this.bonCommandeId = bonCommandeId; }
    
    public Date getDateReception() { return dateReception; }
    public void setDateReception(Date dateReception) { this.dateReception = dateReception; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}