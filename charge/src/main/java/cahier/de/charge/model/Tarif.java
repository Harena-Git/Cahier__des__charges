package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Tarif implements Serializable {
    private Integer id;
    private Integer articleId;
    private Integer typeclientId;
    private Integer siteId;
    private BigDecimal prix;
    private Integer deviseId;
    private Date dateDebut;
    private Date dateFin;

    public Tarif() {}

    public Tarif(Integer id, Integer articleId, Integer typeclientId, Integer siteId, BigDecimal prix, 
                 Integer deviseId, Date dateDebut, Date dateFin) {
        this.id = id;
        this.articleId = articleId;
        this.typeclientId = typeclientId;
        this.siteId = siteId;
        this.prix = prix;
        this.deviseId = deviseId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public Integer getTypeclientId() { return typeclientId; }
    public void setTypeclientId(Integer typeclientId) { this.typeclientId = typeclientId; }
    
    public Integer getSiteId() { return siteId; }
    public void setSiteId(Integer siteId) { this.siteId = siteId; }
    
    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }
    
    public Integer getDeviseId() { return deviseId; }
    public void setDeviseId(Integer deviseId) { this.deviseId = deviseId; }
    
    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
    
    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }
}