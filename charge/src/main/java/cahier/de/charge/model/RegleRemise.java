package cahier.de.charge.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class RegleRemise implements Serializable {
    private Integer id;
    private Integer articleId;
    private Integer typeClientId;
    private BigDecimal seuilMinQuantite;
    private BigDecimal seuilMinMontant;
    private BigDecimal remisePourcentage;
    private Date dateDebut;
    private Date dateFin;

    public RegleRemise() {}

    public RegleRemise(Integer id, Integer articleId, Integer typeClientId, BigDecimal seuilMinQuantite, 
                       BigDecimal seuilMinMontant, BigDecimal remisePourcentage, Date dateDebut, Date dateFin) {
        this.id = id;
        this.articleId = articleId;
        this.typeClientId = typeClientId;
        this.seuilMinQuantite = seuilMinQuantite;
        this.seuilMinMontant = seuilMinMontant;
        this.remisePourcentage = remisePourcentage;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getArticleId() { return articleId; }
    public void setArticleId(Integer articleId) { this.articleId = articleId; }
    
    public Integer getTypeClientId() { return typeClientId; }
    public void setTypeClientId(Integer typeClientId) { this.typeClientId = typeClientId; }
    
    public BigDecimal getSeuilMinQuantite() { return seuilMinQuantite; }
    public void setSeuilMinQuantite(BigDecimal seuilMinQuantite) { this.seuilMinQuantite = seuilMinQuantite; }
    
    public BigDecimal getSeuilMinMontant() { return seuilMinMontant; }
    public void setSeuilMinMontant(BigDecimal seuilMinMontant) { this.seuilMinMontant = seuilMinMontant; }
    
    public BigDecimal getRemisePourcentage() { return remisePourcentage; }
    public void setRemisePourcentage(BigDecimal remisePourcentage) { this.remisePourcentage = remisePourcentage; }
    
    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
    
    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }
}